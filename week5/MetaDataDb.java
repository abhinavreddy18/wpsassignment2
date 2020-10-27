package jdbcPractice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataDb {

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
			
			ResultSet rs=st.executeQuery(queryString);
			
			//meta data;
			
			ResultSetMetaData mdata=rs.getMetaData();
			
			System.out.println("ColoumnCount Information table:"+mdata.getColumnCount());
			System.out.println("ColoumnName 2:"+mdata.getColumnName(2));
			
			//we can also get Data base data;
			
			DatabaseMetaData ddata=con.getMetaData();
			
			System.out.println("DataBaseType:"+ddata.getDatabaseProductName());
			System.out.println("DataBaseDriver Name:"+ddata.getDriverName());
					
			
		}
		catch(Exception e)
		{
			System.out.println("Connection did not establish");
			e.printStackTrace();			
		}


	}

}
