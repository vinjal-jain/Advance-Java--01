package in.co.rays.marksheet;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	public class MarskheetModel {

		public void add(MarksheetBean bean) throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");

			
			pstmt.setInt(1, bean.getRoll_no());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhysics());
			pstmt.setInt(4, bean.getChemistry());
			pstmt.setInt(5, bean.getMathematics());

			int i = pstmt.executeUpdate();

			System.out.println("data inserted => " + i);

		}

		public void update(MarksheetBean bean) throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement(
					"update marksheet set roll_no = ?, name = ?, physics = ?, chemistry = ?, maths = ? where id = ?");

			pstmt.setInt(1, bean.getRoll_no());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhysics());
			pstmt.setInt(4, bean.getChemistry());
			pstmt.setInt(5, bean.getMathematics());
			

			int i = pstmt.executeUpdate();

			System.out.println("data updated => " + i);

		}

		public void delete(int id) throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			System.out.println("data deleted => " + i);

		}

		public void read() throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				
				System.out.print( rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getInt(3));
				System.out.print("\t" + rs.getInt(4));
				System.out.println("\t" + rs.getInt(5));

			}
		}
			public MarksheetBean findByPk(int roll_no) throws Exception {

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

				PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where roll_no = ?");

				pstmt.setInt(1, roll_no);

				ResultSet rs = pstmt.executeQuery();

				MarksheetBean bean = null;

				while (rs.next()) {
					bean = new MarksheetBean();
					bean.setRoll_no(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setPhysics(rs.getInt(3));
					bean.setChemistry(rs.getInt(4));
					bean.setMathematics(rs.getInt(5));

				}
				return bean;
			}
		
			public List search() throws Exception {

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

				PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

				ResultSet rs = pstmt.executeQuery();

				List list = new ArrayList();

				while (rs.next()) {
					MarksheetBean bean = new MarksheetBean();
					bean.setRoll_no(rs.getInt(1));
					bean.setName(rs.getString(2));
					bean.setPhysics(rs.getInt(3));
					bean.setChemistry(rs.getInt(4));
					bean.setMathematics(rs.getInt(5));
					list.add(bean);
				}
				return list;
			}


		}
