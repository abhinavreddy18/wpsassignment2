package jdbcPractice;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowsetP {

	public static void main(String[] args) 
	{
		try {
			
			JdbcRowSet rs=RowSetProvider.newFactory().createJdbcRowSet();
			
			rs.setUrl("jdbc:mysql://localhost:3306/student");
			rs.setUsername("root");
			rs.setPassword("");
			
			rs.setCommand("select * from information");
			rs.execute();
			while(rs.next())
			{
				System.out.println("Id:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2));
				System.out.println("Id:"+rs.getString(3));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
