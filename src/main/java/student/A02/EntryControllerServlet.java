package student.A02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 証明書申込画面のコントローラ
 * 日本人学生ボタンを押されていたら、日本人学生用の証明書申込画面に遷移
 * 留学生ボタンを押されていたら、留学生用の証明書申込画面に遷移する
 */
@WebServlet("/Entry")
public class EntryControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//証明書申込画面に遷移
		String btnState = request.getParameter("btnState");
		if(btnState == null) {
			request.getRequestDispatcher("/WEB-INF/student/ERROR/Error.jsp").forward(request, response);
		}
		HttpSession session = request.getSession();
		if(btnState.equals("ja")) {			//日本人学生の証明書申込画面に遷移
			session.setAttribute("studentState","ja");
			request.getRequestDispatcher("/WEB-INF/student/A02/EntryJaStudent.jsp").forward(request, response);
		}else if(btnState.equals("in")){	//留学生の証明書申込画面に遷移
			session.setAttribute("studentState","in");
			request.getRequestDispatcher("/WEB-INF/student/A02/EntryInStudent.jsp").forward(request, response);
		}else {
			session.setAttribute("studentState", null);
			request.getRequestDispatcher("/WEB-INF/student/ERROR/Error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
