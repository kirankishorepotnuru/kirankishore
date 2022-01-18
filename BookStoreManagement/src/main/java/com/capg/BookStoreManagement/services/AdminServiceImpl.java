package com.capg.BookStoreManagement.services;
import java.util.List;

//import java.util.*;
import com.capg.BookStoreManagement.beans.Admin;
import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.dao.AdminDAO;
import com.capg.BookStoreManagement.dao.AdminDAOImpl;
import com.capg.BookStoreManagement.exception.InvalidAdminException;
//import com.capg.BookStoreManagement.exception.InvalidAdminException;
import com.capg.BookStoreManagement.exception.InvalidBookException;
import com.capg.BookStoreManagement.exception.InvalidUserException;

public class AdminServiceImpl implements AdminService{
	Admin as=new Admin();
	AdminDAO ad=new AdminDAOImpl();
	public boolean doValidateAdmin(String adminName,String adminPassword) throws InvalidAdminException  {
		if(adminName.equals(as.UserNameSaved) && adminPassword.equals(as.PasswordSaved)) {
			return true;
		}
		else {
			System.out.println("invalid credentials");
			throw new InvalidAdminException();
			//return false;
		}
	}
	public boolean doAddUser(User user)throws InvalidUserException {
		// TODO Auto-generated method stub
		//if(user!=null) {
			//if(user.getUserId()>=1 && user.getUserName()!=null) {
				boolean isUserAdded=ad.doAddUser(user);
				return isUserAdded;
			//}
		//}
		//return false;
	}
	//public boolean doModifyUser(int userId, String userName, String userPwd, String userEmail, String userAddress,int userPhone) throws InvalidUserException {
		// TODO Auto-generated method stub
	public boolean doModifyUser(User user)throws InvalidUserException {
				boolean isUserModified=ad.doModifyUser(user);
				return isUserModified;
			
	}
	public boolean doDeleteUser(int userId) throws InvalidUserException {
		// TODO Auto-generated method stub
			boolean isBookDeleted=ad.doDeleteUser(userId);
			return isBookDeleted;
	}
	public boolean doManageStocks() {
		// TODO Auto-generated method stub
		return false;
	}
	//public boolean doAddBooks(int isbn, String title, String author, int price, int qty) throws InvalidBookException {
	public boolean doAddBooks(Book book) throws InvalidBookException{
		// TODO Auto-generated method stub
				boolean isBookAdded=ad.doAddBooks(book);
				return isBookAdded;
	}
	
	 public boolean doDeleteBooks(int isbn) throws InvalidBookException{
		 boolean isBookDeleted=ad.doDeleteBooks(isbn);
		 if(true)
		 {
			return isBookDeleted;
		 }
		 else
		 {
			 throw new InvalidBookException();
		 }
	 }
	//public boolean doEditBooks(int isbn, String title, String author, int price, int qty) throws InvalidBookException {
	public boolean doEditBooks(Book book) throws InvalidBookException{
		// TODO Auto-generated method stub
				boolean isBookEdited=ad.doEditBooks(book);
				return isBookEdited;
	}
	public int doCalculateTotal(int orders) {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<User> getUsers(int userId1,int userId2)
	{
		List<User> allUsers=null;
		if(userId1<userId2)
		{
			allUsers=ad.getUsers(userId1,userId2);
			return allUsers;
		}
		else
		{
			return null;
		}
	}
	public List<Book> getBooks()
	{
		List<Book> allBooks=ad.getBooks();
		return allBooks;
		
	}
	public Book doSearchBook(int Isbn) throws InvalidBookException{
		Book isBookSearch=ad.doSearchBook(Isbn);
		return isBookSearch;
	}
	public User doSearchUser(int userID) throws InvalidUserException{
		User isUserSearch=ad.doSearchUser(userID);
		return isUserSearch;
	}
	public User doSearchUser(String userName) throws InvalidUserException{
		User isUserSearch=ad.doSearchUser(userName);
		return isUserSearch;
	}
	public List<Book> doSearchBook(String author) throws InvalidBookException{
		List<Book> isBookSearch=ad.doSearchBook(author);
		return isBookSearch;
	}
	public Book SortByBookTitle(String title)
	{
		if(title!=null)
		{
			return ad.sortByBookTitle(title);
		}
		return null;
	}
	
}
