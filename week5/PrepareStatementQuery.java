package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrepareStatementQuery {

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
			
			
			String querystring="select id,rollnumber,name from information where id=?";
		
			PreparedStatement pstmnt=con.prepareStatement(querystring);
			
			//for the question mark in the executequery string give a value;
			pstmnt.setInt(1,4);
			ResultSet rs=pstmnt.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
					
		}
		catch(Exception e)
		{
			System.out.println("Connection did not establish");
			e.printStackTrace();
			
		}

	}

}
