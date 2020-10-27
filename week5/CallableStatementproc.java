package jdbcPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

public class CallableStatementproc {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/student";
		String username="root";
		String password="";
		
		try {
			
			//for loading the vendor specific driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//for establishing the connection
			Connection con=DriverManager.getConnection(url,username,password);
			
			System.out.println("Connection Established"+con);
			
			//so here we do about callable statements for procedures
			//have procedures in ur db already before calling the procedures;
			
			CallableStatement cltstmnt=con.prepareCall("{call getRollNumber(?,?)}");
			cltstmnt.setInt(1,4);
			cltstmnt.registerOutParameter(2, Types.VARCHAR);
			cltstmnt.execute();
			
			//so we need to write 2 in above and below since we are giving outparameter at after id in parameter
			System.out.println(cltstmnt.getString(2));
						
			
		}
		catch(Exception e)
		{
			System.out.println("Connection did not establish");
			e.printStackTrace();
			
		}


	}

}
