package servletspackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlAuthChecker 
{
	
	public boolean checkCredentials(String username,String rollnumber)
	{
		String url="jdbc:mysql://localhost:3306/student";
		String dbusername="root";
		String dbpassword="";
			
			
			try {
				
				//for loading the vendor specific driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//for establishing the connection
				Connection con=DriverManager.getConnection(url,dbusername,dbpassword);
				
				System.out.println(con);
				
				
				String querystring="select * from information where name like ? and rollnumber like ?";
			
				PreparedStatement pstmnt=con.prepareStatement(querystring);
				
				pstmnt.setString(1,username);
				pstmnt.setString(2, rollnumber);
				
				ResultSet rs=pstmnt.executeQuery();
				
				if(rs.next())
				{
					return true;
				}
				else {
					return false;
				}
				
				
						
			}
			catch(Exception e)
			{
				System.out.println("Connection did not establish");
				e.printStackTrace();
				
				return false;
			}
		
	}

}
