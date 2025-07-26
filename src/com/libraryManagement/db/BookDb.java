package com.libraryManagement.db;

import java.util.ArrayList;
import java.util.List;

import com.libraryManagement.model.Book;

public class BookDb {
	private static List<Book> bookList;
	public static List<Book> getBookDb() {
		if(bookList==null) {
			bookList=new ArrayList<Book>();
			
		}
		return bookList;
	}
}

