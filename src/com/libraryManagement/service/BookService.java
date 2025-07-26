package com.libraryManagement.service;

import java.util.List;
import java.util.Scanner;

import com.libraryManagement.LibraryManagement;
import com.libraryManagement.db.BookDb;
import com.libraryManagement.model.Book;

public class BookService {
	List<Book> bookList = BookDb.getBookDb();

	public void addBook() {
		String bookId = validateBookId();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the book Name:");
		String bookName = sc.next();
		System.out.println("Enter the Author name:");
		String authorName = sc.next();
		System.out.println("Enter the number of copies:");
		int noOfCopies = sc.nextInt();
		Book book = new Book(bookId, bookName, authorName, noOfCopies);
		bookList.add(book);
		System.out.println("Book details added successfully");
		// System.out.println(bookList);

		LibraryManagement.optionMethod();
		sc.close();
	}

	public void addExtraBookCopies() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the bookId:");
		String bookId = sc.next();
		if (checkBookIdAlreadyExistOrNot(bookId)) {
			System.out.println("Please enter the no of copies you want to add:");
			int extraCopies = sc.nextInt();
			for (int i = 0; i < bookList.size(); i++) {
				if (bookId.equals(bookList.get(i).getBookId())) {
					Book book = bookList.get(i);
					book.setBookCount(book.getBookCount() + extraCopies);
					System.out.println("Extra copies added successfully");
					LibraryManagement.optionMethod();
				} else {
					System.out.println("Book id not exist");
					addExtraBookCopies();
				}

			}

		} else {
			addExtraBookCopies();
		}
	}
	public int getBookCopiesCount(String bookId) {
		int bookCopies = 0;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookId.equals(bookList.get(i).getBookId())) {
				bookCopies = bookList.get(i).getBookCount();
				return bookCopies;
				}
			}
		return bookCopies;
	}	
	

	public boolean checkBookIdAlreadyExistOrNot(String bookId) {
		// System.err.println("display book");
		// displayBookStr();
		for (int i = 0; i < bookList.size(); i++) {
			if (bookId.equals(bookList.get(i).getBookId())) {
				return true;
			}
		}
		return false;

	}

	public String validateBookId() {
		System.out.println("Enter the bookId:");
		Scanner sc = new Scanner(System.in);
		String bookId = sc.next();
		if (!checkBookIdAlreadyExistOrNot(bookId)) {
			return bookId;
		}

		else {
			System.out.println("Book Id Already exist Please enter the unique one:");
			return validateBookId();
		}

	}

	public String getBookNameByBookId(String bookId) {
		String bookName = null;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookId.equals(bookList.get(i).getBookId())) {
				bookName = bookList.get(i).getBookName();
			}
		}
		return bookName;
	}


	public void displayBook() {
		System.out.println("BookId|BookName|AuthorName");
		for (int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i).getBookId() + "|" + bookList.get(i).getBookName() + "|"
					+ bookList.get(i).getAuthorName() + "|" + bookList.get(i).getBookCount());
		}
		LibraryManagement.optionMethod();
	}

	
}
