package com.capg.BookStoreManagement.sortings;

import java.util.Comparator;

import com.capg.BookStoreManagement.beans.Book;

public class SortByBookName implements Comparator<Book> {

	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getTitle().compareToIgnoreCase(o2.getTitle());
	}

}
