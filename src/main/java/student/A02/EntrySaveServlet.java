package student.A02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.bean.Certificate;
import student.bean.StudentBean;

/**
 * 「トップページ」ボタンを押すと、トップページへ遷移
 *  「確認」ボタンを押すと、入力チェックしたのちに、「申込内容確認画面」に遷移する
 */
@WebServlet("/EntrySave")
public class EntrySaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EntrySaveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String studentState = (String) session.getAttribute("studentState");

		String btnState = request.getParameter("btnState");
		if (btnState == null || studentState == null) {
			request.getRequestDispatcher("/WEB-INF/student/ERROR/Error.jsp").forward(request, response);
		}

		// ボタンチェック
		if (btnState.equals("top")) { // 「トップページ」ボタンを押下時の処理
			request.getRequestDispatcher("/Top").forward(request, response);
		} else if (btnState.equals("check")) { // 「確認」ボタンを押下時の処理
			try {
				String name = request.getParameter("name"); 
				String no = request.getParameter("no"); 
				String birthday = request.getParameter("birthday"); 
				String grade = request.getParameter("grade"); 
				String dept = request.getParameter("dept"); 
				String mail = request.getParameter("mail");
				String dormitory = request.getParameter("dormitory");
				String[] certList = request.getParameterValues("certList");
				String[] priceList = request.getParameterValues("priceList");
				String[] quantityList = request.getParameterValues("quantityList");

				ArrayList<Certificate> list = new ArrayList<Certificate>();

				int sum = 0;
				for (int i = 0; i < certList.length; i++) {
					int price = Integer.parseInt(priceList[i]) * Integer.parseInt(quantityList[i]);
					sum += price;
					list.add(new Certificate(certList[i], String.valueOf(price), quantityList[i]));
				}
				StudentBean sb = new StudentBean(name, no, birthday, grade, dept, mail, dormitory, String.valueOf(sum));
				sb.setCertList(list);

				session.setAttribute("sb", sb);

				if (studentState.equals("ja")) {
					// 「申込入力情報確認画面」に遷移する
					request.getRequestDispatcher("/WEB-INF/student/A03/CheckJaStudent.jsp").forward(request, response);
				} else if (studentState.equals("in")) {
					request.getRequestDispatcher("/WEB-INF/student/A03/CheckInStudent.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/WEB-INF/ERROR/Error.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/WEB-INF/ERROR/Error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/ERROR/Error.jsp").forward(request, response);
		}

	}

}
