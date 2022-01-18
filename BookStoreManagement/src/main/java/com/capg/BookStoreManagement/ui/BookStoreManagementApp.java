package com.capg.BookStoreManagement.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capg.BookStoreManagement.beans.Book;
import com.capg.BookStoreManagement.beans.User;
import com.capg.BookStoreManagement.dao.AdminDAOImpl;
import com.capg.BookStoreManagement.exception.InvalidAdminException;
import com.capg.BookStoreManagement.exception.InvalidBookException;
import com.capg.BookStoreManagement.exception.InvalidUserException;
import com.capg.BookStoreManagement.services.AdminServiceImpl;

public class BookStoreManagementApp {
	Scanner sc=new Scanner(System.in);
	static Scanner scr=new Scanner(System.in);
	AdminDAOImpl adminobj=new AdminDAOImpl();
	AdminServiceImpl asi=new AdminServiceImpl();
	
	//User user=new User(u.getUserId(),u.getUserName(),u.getUserPwd(),u.getUserEmail(),u.getUserAddress(),u.getUserPhone());
	//MainServer app1=new MainServer();
	boolean status;
	public static void main(String[] args) throws InvalidUserException, InvalidAdminException, InvalidBookException {
		// TODO Auto-generated method stub

		BookStoreManagementApp app=new BookStoreManagementApp();
		
		while(true)
	    {
	    	System.out.println("\n\n****APPLICATION*****");
	    	System.out.println("\n\n****BOOKSTORE MANAGEMENT SYSTEM*****");
	    	System.out.println("1.admin login");
	    	System.out.println("2.user login");
	    	System.out.println("0.EXIT ");
	    	System.out.println("enter your choice ");
	    	int choice=app.sc.nextInt();
	    	switch (choice) {
			case 1:
				   
				   System.out.println("enter your username");
				   String adminName=scr.nextLine();
				   System.out.println("enter your password");
				   String adminPassword=scr.nextLine();
				   try {
					app.doAdminLogin(adminName,adminPassword);
				} catch (InvalidUserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidAdminException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidBookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       break;
			case 2:
				   System.out.println("enter your username");
				   String userName=scr.nextLine();
				   System.out.println("enter your password");
				   String password=scr.nextLine();
				   app.doUserLogin(userName,password);
				   break;
			case 0:
				   System.out.println("\n\n EXIT ");
				   System.exit(0);
				   break;
			default:
				break;
			}
	    }
	   
	}
	public void doAdminLogin(String adminName,String adminPassword) throws InvalidUserException,InvalidAdminException,InvalidBookException
    {
		while(true)
		{
		if(asi.doValidateAdmin(adminName, adminPassword)) {
	 //System.out.println("admin login successfully");
	 System.out.println("1. Add user");
	 System.out.println("2. Modify User");
	 System.out.println("3. Delete User");
	 System.out.println("4. Manage Stocks ");
	 System.out.println("5. Add Books ");
	 System.out.println("6. Delete Books ");
	 System.out.println("7. Edit Books ");
	 System.out.println("8. Find total orders");
	 System.out.println("9. retrieve users from range");
	 System.out.println("10.Sort By Using Book Price");
	 System.out.println("11.Search User by isbn");
	 System.out.println("12.Search Book");
	 System.out.println("13.Search User by userName");
	 System.out.println("14.Search Book by author");
	 System.out.println("15.Search by using book title");
	 System.out.println("0. EXIT");
	 
	 int choice=sc.nextInt();
	 User status1;
	Book status2;
	switch (choice) {
	case 1: // add user
		System.out.println("enter userid to add user");
		int userId=sc.nextInt();
		//us.setUserId(userId);
		System.out.println("enter the userName");
		String userName=scr.nextLine();
		//us.setUserName(userName);
		System.out.println("enter the password");
		String userPwd=scr.nextLine();
		//us.setUserPwd(userPwd);
		System.out.println("enter the user Email");
		String userEmail=scr.nextLine();
		//us.setUserEmail(userEmail);
		System.out.println("enter the user Address");
		String userAddress=scr.nextLine();
		//us.setUserAddress(userAddress);
		System.out.println("enter the phonenumber");
		int userPhone=sc.nextInt();
		//us.setUserPhone(userPhone);
		//adminobj.doAddUser(us.getUserId(),us.getUserName(),us.getUserPwd(),us.getUserEmail(),us.getUserAddress(),us.getUserPhone());
		User u=new User(userId,userName,userPwd,userEmail,userAddress,userPhone);
		try {
			status=asi.doAddUser(u);
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status) {
			System.out.println("User Added Successfully");
		}
		else {
			System.out.println("Sorry User Not Added Successfully");
		}
		
		break;
	case 2: // modify user
		System.out.println("enter userid to modify user");
		int modifyUserId=sc.nextInt();
		//us.setUserId(modifyUserId);
		System.out.println("enter the userName");
		String modifyUserName=scr.nextLine();
		//us.setUserName(modifyUserName);
		System.out.println("enter the password");
		String modifyUserPwd=scr.nextLine();
		//us.setUserPwd(modifyUserPwd);
		System.out.println("enter the user Email");
		String modifyUserEmail=scr.nextLine();
		//us.setUserEmail(modifyUserEmail);
		System.out.println("enter the user Address");
		String modifyUserAddress=scr.nextLine();
		//us.setUserAddress(modifyUserAddress);
		System.out.println("enter the phonenumber");
		int modifyUserPhone=sc.nextInt();
		//us.setUserPhone(modifyUserPhone);
		//adminobj.doModifyUser(us.getUserId(),us.getUserName(),us.getUserPwd(),us.getUserEmail(),us.getUserAddress(),us.getUserPhone());
		//status=adminobj.doAddUser(u.returnUser());
		User us=new User(modifyUserId,modifyUserName,modifyUserPwd,modifyUserEmail,modifyUserAddress,modifyUserPhone);
		status=asi.doModifyUser(us);
		if(status) {
			System.out.println("User Modified Successfully");
		}
		else {
			System.out.println("Sorry User Not Modified Successfully");
		}
		break;
	case 3: // delete user
		System.out.println("enter the userId to Delete");
		int delUserId=sc.nextInt();
		//adminobj.doDeleteUser(delUserId);
		status=asi.doDeleteUser(delUserId);
		if(status) {
			System.out.println("User Deleted Successfully");
		}
		else {
			System.out.println("Sorry User Not Deleted Successfully");
		}
		break;
	case 4: // manage stock
		 adminobj.doManageStocks();
		 break;
	case 5: //add books
		System.out.println("enter inter national standard book number");
		int isbn=sc.nextInt();
		//b.setIsbn(isbn);
		System.out.println("enter book title");
		String title=scr.nextLine();
		//b.setTitle(title);
		System.out.println("enter book author");
		String author=scr.nextLine();
		//b.setAuthor(author);
		System.out.println("enter book price");
		int price=sc.nextInt();
		//b.setPrice(price);
		System.out.println("enter quantity");
		int qty=sc.nextInt();
		//b.setQty(qty);
		 //adminobj.doAddBooks(b.getIsbn(),b.getTitle(),b.getAuthor(),b.getPrice(),b.getQty());
	    Book b =new Book(isbn,title,author,price,qty);
		status=asi.doAddBooks(b);
		if(status) {
			System.out.println("Book Added Successfully");
		}
		else {
			System.out.println("Sorry Book Not Added Successfully");
		}
		 break;
	case 6: // delete Books
		System.out.println("Enter book Isbn number");
		int bookIsbn=sc.nextInt();
		try {
			status=asi.doDeleteBooks(bookIsbn);
		} catch (InvalidBookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status) {
			System.out.println("Book Deleted Successfully");
		}
		else {
			System.out.println("Sorry Book Not Deleted Successfully");
		}
		break;
	case 7://edit books
		System.out.println("enter inter national standard book number");
		int modifyIsbn=sc.nextInt();
		//b.setIsbn(modifyIsbn);
		System.out.println("enter book title");
		String modifyTitle=scr.nextLine();
		//b.setTitle(modifyTitle);
		System.out.println("enter book author");
		String modifyAuthor=scr.nextLine();
		//b.setAuthor(modifyAuthor);
		System.out.println("enter book price");
		int modifyPrice=sc.nextInt();
		//b.setPrice(modifyPrice);
		System.out.println("enter quantity");
		int modifyQty=sc.nextInt();
		//b.setQty(modifyQty);
		//adminobj.doEditBooks(b.getIsbn(),b.getTitle(),b.getAuthor(),b.getPrice(),b.getQty());
		 Book bk =new Book(modifyIsbn,modifyTitle,modifyAuthor,modifyPrice,modifyQty);
		 status=asi.doEditBooks(bk);
		 if(status) {
				System.out.println("Book Modified Successfully");
			}
			else {
				System.out.println("Sorry Book Not Modified Successfully");
			}
		 break;
	case 8://total orders
		 break;
	case 9://retrieve users
		System.out.println("enter the userId1");
		int userId1=sc.nextInt();
		System.out.println("enter the userId2");
		int userId2=sc.nextInt();
		List<User> users=asi.getUsers(userId1,userId2);
		for (User u1 : users) 
		{
			System.out.println(u1);
		}
		break;
	case 10:
		
		List<Book> books=asi.getBooks();
		//Collections.sort(books);
		for (Book book : books) {
			System.out.println(book.getIsbn()+" "+book.getTitle()+" "+book.getPrice()+" "+book.getAuthor());
			
		}
		break;
	case 11://search user
		System.out.println("Enter the UserId to search");
		int userID=sc.nextInt();
		status1=asi.doSearchUser(userID);
		if(status1!=null) {
			System.out.println("UserId :"+status1.getUserId());
			System.out.println("UserName :"+status1.getUserName());
			System.out.println("UserPassword :"+status1.getUserPwd());
			System.out.println("UserEmail :"+status1.getUserEmail());
			System.out.println("UserAddress :"+status1.getUserAddress());
			System.out.println("UserPhoneNumber :"+status1.getUserPhone());
		}
		else {
			System.out.println("Sorry User Not Found");
		}
		break;
	case 12://search book
		System.out.println("Enter the Book ISBN to search");
		int Isbn=sc.nextInt();
		status2=asi.doSearchBook(Isbn);
		if(status2!=null) {
			System.out.println("Book_Isbn :"+status2.getIsbn());
			System.out.println("Book_Title :"+status2.getTitle());
			System.out.println("Book_Author :"+status2.getAuthor());
			System.out.println("Book_Price :"+status2.getPrice());
			System.out.println("Book_Qty :"+status2.getQty());
		}
		else {
			System.out.println("Sorry Book Not Found");
		}
		break;
	case 13://search user by username
		    System.out.println("enter the userName");
		    String searchUserName=scr.next();
		    User status3 = asi.doSearchUser(searchUserName);
		    if(status3!=null) {
		    	System.out.println("user found");
		    	System.out.println("UserId :"+status3.getUserId());
				System.out.println("UserName :"+status3.getUserName());
				System.out.println("UserPassword :"+status3.getUserPwd());
				System.out.println("UserEmail :"+status3.getUserEmail());
				System.out.println("UserAddress :"+status3.getUserAddress());
				System.out.println("UserPhoneNumber :"+status3.getUserPhone());
		    }
		    else
		    {
		    	System.out.println("user not found");
		    }
		   break;
	case 14://search by author name
		List<Book> newBook=new ArrayList<Book>();
		System.out.println("enter the author name");
		String authorSearch=scr.next();
		newBook=asi.doSearchBook(authorSearch);
		for (Book book : newBook) {
			System.out.println(book.getIsbn()+" "+book.getTitle()+" "+book.getPrice());
		}
		break;
	case 15:
		   System.out.println("enter the book title");
		   String titleSearch=scr.nextLine();
		   b=asi.SortByBookTitle(titleSearch);
		   System.out.println(b);
		break;
	case 0:
		  System.exit(0);
		  break;
		 

	default:
		break;
	}
	 }
		else {
			System.out.println("UserName or Password Invalid");
			System.out.println("enter your username");
			   adminName=scr.nextLine();
			   System.out.println("enter your password");
			   adminPassword=scr.nextLine();
			   doAdminLogin(adminName,adminPassword);
			
		}
    	
    }
    }
 public void doUserLogin(String userName,String password)
 {
	 
 }
		//System.out.println("Enter Adim username:");
		//String username=sc.nextLine();
}

