import java.sql.*;

public class TableDropper{

	
	public static void main(String [] args) {
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String Password= "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con=DriverManager.getConnection(url,user,Password);
			Statement stt=con.createStatement();
			
			stt.execute("USE StudentData");
			
			stt.execute("DROP TABLE IF EXISTS Students");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
