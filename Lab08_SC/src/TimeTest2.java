import java.sql.*;
import java.util.Random;


public class TimeTest2{

	
	public static void main(String [] args) {
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String Password= "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection con = DriverManager.getConnection(url,user,Password);
			con.setAutoCommit(true);
			PreparedStatement stt= null;
			String query, insertQuery;
			long _t1, _t2, _t_result;
			
			_t1 = System.currentTimeMillis();
			
			insertQuery = "INSERT INTO Students"+"(Name,Semester,Address) VALUES" +
					"(?,?,?)";
			
			query = "CREATE DATABASE IF NOT EXISTS StudentData";
			stt = con.prepareStatement(query);
			stt.execute();
			
			query =  "USE StudentData";
			stt = con.prepareStatement(query);
			stt.execute();
			
			query = "DROP TABLE IF EXISTS Students";
			stt = con.prepareStatement(query);
			stt.execute();
			
			query = "CREATE TABLE Students("+
					"ID BIGINT NOT NULL AUTO_INCREMENT,"+
					"Name VARCHAR(25),"+
					"Semester INT,"+
					"Address VARCHAR(50),"+
					"PRIMARY KEY(Id)"
							+")";
			stt = con.prepareStatement(query);
			stt.execute();			

			for (int i = 0; i<5000;i++){
				String name = r_name_generator();
				int semester = r_semester();
				
				stt = con.prepareStatement(insertQuery);
				stt.setString(1, name);
				stt.setInt(2, semester);
				stt.setString(3, "Room "+ i);
				stt.executeUpdate();
			
			}
			
			_t2 = System.currentTimeMillis();	
			_t_result = _t2 - _t1;
			System.out.println("Time: "+_t_result+"ms");
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		
		
	}
	
	
	public static String r_name_generator() {
		String name[] = {"ali","hammad","asad","sohaib","sharif","talha","kaab","ashar","basim","danish","fahad","adnan"};
		String temp = name[new Random().nextInt(name.length)];
		return temp;
	}
	
	public static int r_semester() {
		int temp = new Random().nextInt(6) + 1;
		return temp;
	}
}
