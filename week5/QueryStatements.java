package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryStatements {

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
			
			
			String queryString="select * from information";
			
			Statement st=con.createStatement();
			
			ResultSet resultset=st.executeQuery(queryString);
			
			while(resultset.next())
			{
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Connection did not establish");
			e.printStackTrace();
			
		}



	}

}
