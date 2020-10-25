

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlAuthChecker 
{
	
	public boolean checkCredentials(String username,String rollnumber)
	{
		String url="jdbc:mysql://localhost:5432/postgres";
		String dbusername="postgres";
		String dbpassword="postgres";
			
			
			try {
				
				//for loading the vendor specific driver
				Class.forName("org.postgresql.Driver");
				
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