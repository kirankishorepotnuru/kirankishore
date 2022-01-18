package com.capg.BookStoreManagement.dao;
import java.util.List;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.User;
public interface AdminDAO {
	//public boolean doAddUser(int userId,String userName,String userPwd,String userEmail,String userAddress,int userPhone);
	public boolean doAddUser(User user);
    //public boolean doModifyUser(int userId,String userName,String userPwd,String userEmail,String userAddress,int userPhone);
	public boolean doModifyUser(User user);
    public boolean doDeleteUser(int userId);
    public boolean doManageStocks();
    //public boolean doAddBooks(long isbn,String title,String author,int price,int qty);
    public boolean doAddBooks(Book book);
   // public boolean doEditBooks(long isbn,String title,String author,int price,int qty);
    public boolean doEditBooks(Book book);
    public boolean doDeleteBooks(int isbn);
    public int doCalculateTotal(int orders);
    public List<User> getUsers(int userId1,int userId2);
    public List<Book> getBooks();
    public User doSearchUser(int userId);
    public Book doSearchBook(int isbn);
    public User doSearchUser(String userName);
    public List<Book> doSearchBook(String author);
    public Book sortByBookTitle(String title);
    
    
    
}
