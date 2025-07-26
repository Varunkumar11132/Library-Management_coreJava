package com.libraryManagement.model;

public class Book {
	private String bookId;
	private String bookName;
	private String authorName;
	private int numOfCopies;
	
	

	public int getBookCount() {
		return numOfCopies;
	}

	public void setBookCount(int bookCount) {
		this.numOfCopies = bookCount;
	}

	public Book(String bookId, String bookName, String authorName, int numOfCopies) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.numOfCopies = numOfCopies;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Book(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", numOfCopies="
				+ numOfCopies + "]";
	}

	public Book(String bookId, String bookName, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
	}

}
