package common;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import student.bean.Certificate;
import student.bean.StudentBean;

public class DBConnection {
	// DB接続関係クラス
	private Connection con = null;
	private PreparedStatement ps = null;

	/**
	 * 同じ学籍番号がすでにデータベースに存在するかチェック
	 * 
	 * @param keyword
	 * @return 存在する:true ,存在しない:false
	 * @throws Exception
	 */
	public boolean existsSameStudentNum(String studentNum) throws Exception {
		try {
			// データソースの取得
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/teamb");

			// データベースへ接続
			con = ds.getConnection();

			// 学生表のデータ取得
			String sql = "SELECT student_no FROM Student WHERE student_no = ?";
			ps = con.prepareStatement(sql); // preparedStatementにsqlをセット
			ps.setString(1, studentNum);
			System.out.println("学生表のデータを取得する余");
			ResultSet rs = ps.executeQuery(); // sqlを実行する

			// レコード数とレコードの重複をチェック
			int line = 0;
			while (rs.next()) {
				line++;
			}

			if (line == 0) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			try {
				this.con.close();
				this.ps.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 学生表ににデータをインサートする。すでに同じ学籍番号があるときは、データをアップデートする
	 * 
	 */
	public void executeInsertUpdateStudentQuery(StudentBean sb) throws Exception {
		if (sb != null) {
			try {
				// データソースの取得
				InitialContext ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/teamb");

				String sql = null;
				if (existsSameStudentNum(sb.getNo())) {// すでに同じ学籍番号が登録されていたら、更新する
					// データベースへ接続
					con = ds.getConnection();
					sql = "UPDATE Student set name=?, email=?, birthday=? WHERE student_no=?";
					ps = con.prepareStatement(sql); // preparedStatementにsqlをセット
					ps.setString(1, sb.getName());
					ps.setString(2, sb.getMail());
					ps.setString(3, sb.getBirthday());
					ps.setInt(4, Integer.parseInt(sb.getNo()));
				} else {
					// データベースへ接続
					con = ds.getConnection();
					sql = "INSERT INTO Student(student_no, name, email, birthday) VALUES(?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(sb.getNo()));
					ps.setString(2, sb.getName());
					ps.setString(3, sb.getMail());
					ps.setString(4, sb.getBirthday());
				}

				ps.executeUpdate(); // sqlを実行する

			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw e;
			} finally {
				try {
					this.con.close();
					this.ps.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public int executeInsertSelectReceptionQuery(StudentBean sb) throws Exception {
		if (sb != null) {
			try {
				// データソースの取得
				InitialContext ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/teamb");

				// データベースへ接続
				con = ds.getConnection();
				
				Date nowDate = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String formatNowDate = sdf.format(nowDate);
				String sql = "INSERT INTO reception(student_no, dept_id, dormitory_id, division_id, school_grade, reception_date, total_price) VALUES(?,?,?,?,?,?,?)";

				ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(sb.getNo()));
				ps.setString(2, sb.getDept());
				ps.setString(3, sb.getDormitory());
				ps.setString(4, "R10");	//依頼待機状態のフラグを付与
				ps.setInt(5, Integer.parseInt(sb.getGrade()));
				ps.setString(6, formatNowDate);
				ps.setInt(7, Integer.parseInt(sb.getSum()));
				ps.executeUpdate(); // sqlを実行する
				
				//受付Idを取得
				sql = "SELECT reception_id FROM reception WHERE student_no = ? AND reception_date = ?";
				ps = con.prepareStatement(sql); // preparedStatementにsqlをセット
				ps.setInt(1, Integer.parseInt(sb.getNo()));
				ps.setString(2, formatNowDate);
				
				ResultSet rs = ps.executeQuery();
				
				int reception_id=-1;	
				while(rs.next()) {
					reception_id = rs.getInt("reception_id");
				}
				
				return reception_id;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw e;
			} finally {
				try {
					this.con.close();
					this.ps.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return -1;	//エラーである数値を返す
	}
	
	public void executeInsertReceptionDetailsQuery(StudentBean sb,int reception_id) throws Exception {
		if (sb != null || reception_id==- 1) {
			try {
				// データソースの取得
				InitialContext ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/teamb");

				// データベースへ接続
				con = ds.getConnection();
				String sql = "INSERT INTO reception_details(reception_id,certificate_id,quantity) VALUES(?,?,?)";
				
				ArrayList<Certificate> list = sb.getCertList();
			
				for(int i=0;i<list.size();i++) {
					int quantity = Integer.parseInt(list.get(i).getQuantity());
					if(quantity > 0) {
						ps = con.prepareStatement(sql);	// preparedStatementにsqlをセット
						ps.setInt(1, reception_id);		//受付IDをセット
						ps.setString(2, list.get(i).getCertName());	//証明書IDをセット
						ps.setInt(3, quantity);	//部数をセット
						
						ps.executeUpdate(); // sqlを実行する
					}
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw e;
			} finally {
				try {
					this.con.close();
					this.ps.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	/**
	 * DB接続をクローズ
	 * 
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		this.con.close();
		this.ps.close();
	}
}
