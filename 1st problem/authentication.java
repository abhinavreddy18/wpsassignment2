package assignment2;
import java.sql.Connection;



import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;  
public class authentication {
   public static void main(String args[]) {
      Connection c = null;
      Statement stmt = null;
      try {
    	  Class.forName("org.postgresql.Driver");
    	  c=DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
    	  System.out.println("Opened database successfully");
    	  stmt = c.createStatement();
    	  c.setAutoCommit(false);
    	  String sql;
    	  //String sql="drop table login";
    	 // String sql ="Create table login(lname text not null,mobile int not null,email text,dob date)";
    	  //stmt.executeUpdate(sql);
    	 sql="insert into login values('abhinav',2340,'balabhinavreddy@gmail.com','2000-02-18')";
    	  stmt.executeUpdate(sql);
    	  sql="insert into login values('avinash',2320,'avinashreddy@gmail.com','2001-03-19')";
    	  stmt.executeUpdate(sql);
    	  c.commit();
      }
      catch(Exception e) {
          e.printStackTrace();
          System.err.println(e.getClass().getName()+": "+e.getMessage());
          System.exit(0);
      }
      try {
         Class.forName("org.postgresql.Driver");

           //Creating the RowSet object
           int mobile;
           RowSetFactory factory = RowSetProvider.newFactory();
           CachedRowSet rowSet = factory.createCachedRowSet();
           String mysqlUrl = "jdbc:postgresql://localhost:5432/postgres";
           c=DriverManager
        	          .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
           c.setAutoCommit(false);
          
           Scanner myObj = new Scanner(System.in); 
           System.out.println("Enter the mobile number");
           mobile=myObj.nextInt();
           rowSet.setCommand("select * from login where mobile="+mobile);
           rowSet.execute(c);
           System.out.println("Contents of the row set");
           while(rowSet.next()) {
        	   System.out.println("Name "+rowSet.getString("lname"));
        	   System.out.println("Email id "+rowSet.getString("email"));
        	   System.out.println("Mobile Number "+rowSet.getInt("mobile"));
        	   System.out.println("Date of birth "+rowSet.getDate("dob"));
           }
          
           int choice;
           System.out.println("Enter 1 for email change");
           choice=myObj.nextInt();
           if(choice==1) {
        	   String email;
        	   System.out.println("Enter the email id");
        	   email=myObj.nextLine();
        	   
        	  
        	   rowSet.beforeFirst();
        	   while(rowSet.next()) {
        	         if(rowSet.getInt("mobile")==mobile) {
        	             rowSet.updateString("email",email);
        	             rowSet.updateRow();
        	          }
        	         rowSet.acceptChanges();
        	           rowSet.beforeFirst();
        	           System.out.println("After changes");
        	           while(rowSet.next()) {
        	        	   System.out.println("Name "+rowSet.getString("lname"));
        	        	   System.out.println("Email id "+rowSet.getString("email"));
        	        	   System.out.println("Mobile Number "+rowSet.getInt("mobile"));
        	        	   System.out.println("Date of birth "+rowSet.getDate("dob"));
        	           }
        	        
        	       }
           }
           
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
     
   }
}