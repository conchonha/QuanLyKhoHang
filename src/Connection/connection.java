package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	Connection coon = null;
	String url="jdbc:mysql://localhost:3306/quanlykhoxaydung";
	String username = "root";
	String password = "";
	public Connection ketnoi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
				coon= DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("loi load Driver ");
		}
		 catch (SQLException e) {
				System.out.println("loi: "+ e.getMessage());
				}
		
		return coon;
	}
}
