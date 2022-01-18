package com.capg.BookStoreManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.util.DBConnection;


public class AdminDAOImpl implements AdminDAO{
	//public boolean doAddUser(int userId,String userName,String userPwd,String userEmail,String userAddress,int userPhone)
	Connection con = DBConnection.con;
    PreparedStatement ps;
	public boolean doAddUser(User user)
    {
		    //Connection con = DBConnection.con;
		    //PreparedStatement ps;

		    try
		    {
		        ps = con.prepareStatement("insert into bookstoremanagement.user values (?,?,?,?,?,?)");
		        ps.setInt(1,user.getUserId());
		        ps.setString(2,user.getUserName());
		        ps.setString(3,user.getUserPwd());
		        ps.setString(4,user.getUserEmail());
		        ps.setString(5,user.getUserAddress());
		        ps.setInt(6,user.getUserPhone());
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Insertion of User "+e);
		    }
		    return false;
		 }
	public boolean doModifyUser(User user)
    {
		//Connection con = DBConnection.con;
	    //PreparedStatement ps;

	    try
	    {
	    	//int UserId=user.getUserId();
	      String cmd = "update bookstoremanagement.user set userId=?, userName=?, userPwd=?, userEmail=?, userAddress =?, userPhone=? where userId=?";

	      ps = con.prepareStatement(cmd);
	        ps.setInt(1,user.getUserId());
	        ps.setString(2,user.getUserName());
	        ps.setString(3,user.getUserPwd());
	        ps.setString(4,user.getUserEmail());
	        ps.setString(5,user.getUserAddress());
	        ps.setInt(6,user.getUserPhone());
	        ps.setInt(7,user.getUserId());
	      
	      int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
			if(i==1) return true;
			return false;
	    }
	   catch(Exception e)
	   {
		   System.out.println("Exception while Updating User "+e);
	   }
	   return false;

	  }
	 public boolean doDeleteUser(int userId)
	    {
		    //Connection con = DBConnection.con;
			//PreparedStatement ps;

		    try
		    {
		      String cmd = "delete from bookstoremanagement.user where userId=?";

		      ps = con.prepareStatement(cmd);
		      ps.setInt(1,userId);
		      int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		   catch(Exception e)
		   {
			   System.out.println("Exception while Deleting User "+e);
		   }
		   return false;

		  }
	 public boolean doManageStocks()
	    {
	    	return false;
	    }
	 //public boolean doAddBooks(long isbn,String title,String author,int price,int qty){
	 public boolean doAddBooks(Book book) {
		 //Connection con = DBConnection.con;
			//PreparedStatement ps;

		    try
		    {
		        ps = con.prepareStatement("insert into bookstoremanagement.book values (?,?,?,?,?)");
		        ps.setLong(1,book.getIsbn());
		        ps.setString(2,book.getTitle());
		        ps.setString(3,book.getAuthor());
		        ps.setInt(4,book.getPrice());
		        ps.setInt(5,book.getQty());
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Adding Books "+e);
		    }
		    return false;
	    }
	 public boolean doDeleteBooks(int isbn) {
		// Connection con = DBConnection.con;
		//	PreparedStatement ps;

		    try
		    {
		        ps = con.prepareStatement("delete from bookstoremanagement.book where isbn=?");
		        ps.setInt(1,isbn);
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Deleting Books "+e);		    
		    	}
		    return false;
	    }
	 //public boolean doEditBooks(long Isbn,String title,String author,int price,int qty) {
	 public boolean doEditBooks(Book book) {
		// Connection con = DBConnection.con;
			//PreparedStatement ps;

		    try
		    {
		        
		        ps = con.prepareStatement("update bookstoremanagement.Book set isbn=?, title=?, author=?, price=?, qty =? where isbn=?");
		        ps.setLong(1,book.getIsbn());
		        ps.setString(2,book.getTitle());
		        ps.setString(3,book.getAuthor());
		        ps.setInt(4,book.getPrice());
		        ps.setInt(5,book.getQty());
		        ps.setLong(6,book.getIsbn());
		        ps.executeUpdate();
		        int i = ps.executeUpdate(); // DML, i holds the value :- number of rows effected
				if(i==1) return true;
				return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Exception while Editing Books "+e);
		    }
		    return false;
	    }
	 public int doCalculateTotal(int orders)
	    {
		 return orders;
	    }
	 public List<User> getUsers(int userId1, int userId2)
	 {
		 String sqlQuery="SELECT * FROM bookstoremanagement.user where userId>=? and userId<=?";
		 List<User> usersList=new ArrayList<User>();
		 try
		 {
			 ps=con.prepareStatement(sqlQuery);
			 ps.setInt(1, userId1);
			 ps.setInt(2, userId2);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 int userId=rs.getInt("userId");
				 String name=rs.getString("userName");
				 String pwd=rs.getString("userPwd");
				 String email=rs.getString("userEmail");
				 String address=rs.getString("userAddress");
				 int phone=rs.getInt("userPhone");
				 
				 User u=new User(userId,name,pwd,email,address,phone);
				 usersList.add(u);
			 }
			 return usersList;
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Exception in getting users by range "+e);
		}
		 return null;
	 }
	 public List<Book> getBooks()
	 {
		 String sqlQuery="Select * from bookstoremanagementsystem.Book order by price";
		 List<Book> booksList=new ArrayList<Book>();
		 try
		 {
			 ps=con.prepareStatement(sqlQuery);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 long isbn=rs.getLong("isbn");
				 String title=rs.getString("title");
				 String author=rs.getString("author");
				 int price=rs.getInt("price");
				 int qty=rs.getInt("qty");
				 Book bp=new Book(isbn,title,author,price,qty);
				 booksList.add(bp);
			 }
			 return booksList;
		 }
		 catch (Exception e) {
			 System.out.println("exception in sorting");
			// TODO: handle exception
		}
		return null;
		 
	 }
	 public User doSearchUser(int userId) {
		 try {
		 ps=con.prepareStatement("SELECT * FROM bookstoremanagement.user where userId=?");
		 ps.setInt(1,userId);
		 
		 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
		while(rs.next()) {
			int userID = rs.getInt("userId");
			String userName = rs.getString("userName");
			String userPwd = rs.getString("userPwd");
			String userEmail = rs.getString("userEmail");
			String userAddress = rs.getString("userAddress");
		    int userPhone = rs.getInt("userPhone");
			User u=new User(userID,userName,userPwd,userEmail,userAddress,userPhone);
			return u;
		}
	 }
		 catch(Exception e) {
			 System.out.println("Exception while Searching User");
		 }
		 return null;
	}
	 
	 public Book doSearchBook(int Isbn) {
		 try {
		 ps=con.prepareStatement("select * from bookstoremanagement.book where isbn=?");
		 ps.setInt(1,Isbn);
		 
		 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
			while(rs.next()) {
				int isbn = rs.getInt("isbn");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				int qty = rs.getInt("qty");
				Book b=new Book(isbn,title,author,price,qty);
				return b;
			}
		 }
			 catch(Exception e) {
				 System.out.println("Exception while Searching Book");
			 }
			 return null;
	    }
	 public User doSearchUser(String userName) {
		 try {
		 ps=con.prepareStatement("SELECT * FROM bookstoremanagement.user where userName=?");
		 ps.setString(1,userName);
		 
		 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
		while(rs.next()) {
			int userID = rs.getInt("userId");
			String guserName = rs.getString("userName");
			String userPwd = rs.getString("userPwd");
			String userEmail = rs.getString("userEmail");
			String userAddress = rs.getString("userAddress");
		    int userPhone = rs.getInt("userPhone");
			User u=new User(userID,guserName,userPwd,userEmail,userAddress,userPhone);
			return u;
		}
	 }
		 catch(Exception e) {
			 System.out.println("Exception while Searching User by userName");
		 }
		 return null;
	}
	 public List<Book> doSearchBook(String author)
	 {
		 try {
			 List<Book> booksList=new ArrayList<Book>();
			 ps=con.prepareStatement("select * from bookstoremanagement.book where author=?");
			 ps.setString(1,author);
			 
			 ResultSet rs = ps.executeQuery(); // DML, i holds the value :- number of rows effected
				while(rs.next()) {
					int isbn = rs.getInt("isbn");
					String title = rs.getString("title");
					String authorSearch = rs.getString("author");
					int price = rs.getInt("price");
					int qty = rs.getInt("qty");
					Book b=new Book(isbn,title,authorSearch,price,qty);
					booksList.add(b);
					return booksList;
				}
			 }
				 catch(Exception e) {
					 System.out.println("Exception while Searching Book by author");
				 }
				 return null;
	 }
	 public Book sortByBookTitle(String title)
	 {
		 String sqlQuery="select * from bookstoremanagement.Book where title=?";
		 try
		 {
			 ps = con.prepareStatement(sqlQuery);
				ps.setString(1,title);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					int isbn = rs.getInt("isbn");
					String titleSearch = rs.getString("title");
					String author = rs.getString("author");
					int price = rs.getInt("price");
					int qty = rs.getInt("qty");
					
					Book b=new Book(isbn,titleSearch,author,price,qty);
					
					return b;
				}
		 } catch (Exception e) 
			{
				System.out.println("Exception in getting books by title"+e);
			}
			return null;
			 
		 }
}
	 

