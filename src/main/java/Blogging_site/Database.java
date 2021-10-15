package Blogging_site;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Blogging_site", "root", "1234");
			System.out.println("Connection Estabilished");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void add_user(String nam, String email, String pas) {

		try {
			ps = con.prepareStatement("insert into User values(?,?,?,?)");
			ps.setString(1, null);
			ps.setString(2, nam);
			ps.setString(3, email);
			ps.setString(4, pas);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public boolean login_user(String e, String p) {
		try {
			ps = con.prepareStatement("select * from User where email=? and password=?");
			ps.setString(1, e);
			ps.setString(2, p);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public void add_blog(String h, String b) {
		try {
			ps=con.prepareStatement("insert into blogs values(?,?,?)");
			ps.setString(1, null);
			ps.setString(2, h);
			ps.setString(3, b);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
