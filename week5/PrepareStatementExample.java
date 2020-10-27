package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PrepareStatementExample {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="";
		
		try {
			
			//for loading the vendor specific driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//for establishing the connection
			Connection con=DriverManager.getConnection(url,username,password);
			
			System.out.println(con);
			
			
			String updation="insert into information(id,name,rollnumber) values(?,?,?)";
		
			//we will use prepared statement for the manipulations
			
			PreparedStatement pstmnt=con.prepareStatement(updation);
			
			pstmnt.setInt(1, 4);
			pstmnt.setString(2, "Mathur");
			pstmnt.setString(3, "1602-18-733-042");
			int x=pstmnt.executeUpdate();
			
			pstmnt.setInt(1, 5);
			pstmnt.setString(2, "KVACH");
			pstmnt.setString(3, "1602-18-733-026");
			int y=pstmnt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Connection did not establish");
			e.printStackTrace();
			
		}


	}

}
