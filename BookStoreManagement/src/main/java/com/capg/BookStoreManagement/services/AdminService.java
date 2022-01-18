package com.capg.BookStoreManagement.services;

import java.util.List;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.exception.InvalidAdminException;
import com.capg.BookStoreManagement.exception.InvalidBookException;
import com.capg.BookStoreManagement.exception.InvalidUserException;

public interface AdminService {
	public boolean doValidateAdmin(String username,String password) throws InvalidAdminException;
	public boolean doAddUser(User user) throws InvalidUserException;
	//public boolean doAddUser(int userId,String userName,String userPwd,String userEmail,String userAddress,int userPhone) throws InvalidUserException;
    //public boolean doModifyUser(int userId,String userName,String userPwd,String userEmail,String userAddress,int userPhone) throws InvalidUserException;
	public boolean doModifyUser(User user)throws InvalidUserException;
	public boolean doDeleteUser(int userId) throws InvalidUserException;
    public boolean doManageStocks();
    public boolean doAddBooks(Book book) throws InvalidBookException;
    //public boolean doAddBooks(int isbn,String title,String author,int price,int qty) throws InvalidBookException;
    //public boolean doEditBooks(int isbn,String title,String author,int price,int qty) throws InvalidBookException;
    public boolean doEditBooks(Book book) throws InvalidBookException;
    public boolean doDeleteBooks(int isbn) throws InvalidBookException;
    public int doCalculateTotal(int orders);
    public List<User> getUsers(int userId1,int userId2);
    public List<Book> getBooks() throws InvalidBookException;
    public User doSearchUser(int userId) throws InvalidUserException;
    public Book doSearchBook(int isbn) throws InvalidBookException;
    public User doSearchUser(String userName) throws InvalidUserException;
    public List<Book> doSearchBook(String author) throws InvalidBookException;
    public Book SortByBookTitle(String title);
}
