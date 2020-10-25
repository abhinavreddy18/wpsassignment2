package servlet;
import java.sql.Connection;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.DriverManager;
import java.sql.Statement;
public class sqldbchecker {
	public boolean checkCredentials(String username,String password) {
		 Connection c = null;
	      Statement stmt = null;
		try {
	    	  Class.forName("org.postgresql.Driver");
	    	  
	    	  RowSetFactory factory = RowSetProvider.newFactory();
	           CachedRowSet rowSet = factory.createCachedRowSet();
	           String mysqlUrl = "jdbc:postgresql://localhost:5432/postgres";
	           c=DriverManager
	        	          .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
	           c.setAutoCommit(false);
	           rowSet.setCommand("select * from login where username="+username);
	           rowSet.execute(c);
	           String check=rowSet.getNString("username");
	           if(check.contentEquals(username)) {
	        	   return true;
	           }
	           return false;
	      }
	      catch(Exception e) {
	          e.printStackTrace();
	          System.err.println(e.getClass().getName()+": "+e.getMessage());
	          System.exit(0);
	      }
		return false;
		
	}
	public String nameSpecify(String username,String password) {
		
		Connection c = null;
	      Statement stmt = null;
		try {
	    	  Class.forName("org.postgresql.Driver");
	    	  
	    	  RowSetFactory factory = RowSetProvider.newFactory();
	           CachedRowSet rowSet = factory.createCachedRowSet();
	           String mysqlUrl = "jdbc:postgresql://localhost:5432/postgres";
	           c=DriverManager
	        	          .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
	           c.setAutoCommit(false);
	           rowSet.setCommand("select * from login where username="+username);
	           rowSet.execute(c);
	           String check=rowSet.getString("username");
	           if(check.contentEquals(username)) {
	        	   return rowSet.getString("fullname");
	           }
	      }
	      catch(Exception e) {
	          e.printStackTrace();
	          System.err.println(e.getClass().getName()+": "+e.getMessage());
	          System.exit(0);
	      }
		return null;
		
	}
}
