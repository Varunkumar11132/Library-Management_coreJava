package com.libraryManagement.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.libraryManagement.LibraryManagement;
import com.libraryManagement.model.Book;
import com.libraryManagement.model.BookTransaction;

public class BookTransactionService {
	List<BookTransaction> bookTransactionsList = new ArrayList<BookTransaction>();

	BookService bookService = new BookService();
	MemberService memberService = new MemberService();

	public void issuedBook() {
		System.out.println("Enter the book ID:");
		Scanner sc = new Scanner(System.in);
		String bookId = sc.next();

		if (bookService.checkBookIdAlreadyExistOrNot(bookId)) {
			String memberId = memberService.validateMemberId();

			System.out.println("Enter the number of copies do you want:");
			int bookCopies = sc.nextInt();

			if (bookCopies <= bookService.getBookCopiesCount(bookId) && bookService.getBookCopiesCount(bookId) > 0) {

				BookTransaction bookTransaction = new BookTransaction(bookId, memberId);
				bookTransaction.setBookName(bookService.getBookNameByBookId(bookId));
				bookTransaction.setMemberName(memberService.getMemberNameByMemberId(memberId));
				bookTransaction.setIsueDateTime(LocalDateTime.now());
				LocalDateTime dueDate = LocalDateTime.now().plusDays(30);
				bookTransaction.setDueDate(dueDate);
				bookTransactionsList.add(bookTransaction);
				System.out.println("Issued book with the respective member successfully");
				System.out.println(bookTransactionsList);
				for (int i = 0; i < bookService.bookList.size(); i++) {
					if (bookId.equals(bookService.bookList.get(i).getBookId())) {
						Book book = bookService.bookList.get(i);
						book.setBookCount(book.getBookCount() - bookCopies);
					}
				}
				LibraryManagement.optionMethod();
				sc.close();
			} else {
				System.out.println("No more book copies");
				issuedBook();
			}

		} else {
			System.out.println("Book id is not exist");
			issuedBook();
		}

	}

	public void returnBook() {
		System.out.println("Enter the book id:");
		Scanner sc = new Scanner(System.in);
		String bookId = sc.next();
		System.out.println("Enter the member id");
		String memberId = sc.next();
		for (int i = 0; i < bookTransactionsList.size(); i++) {
			if ((bookId.equals(bookTransactionsList.get(i).getBookId())
					&& memberId.equals(bookTransactionsList.get(i).getMemberId()))) {
				bookTransactionsList.get(i).setReturned(true);
				bookTransactionsList.get(i).setReturnDateTime(LocalDateTime.now());
				Book book = bookService.bookList.get(i);
				book.setBookCount(book.getBookCount() + 1);

				if (bookTransactionsList.get(i).getReturnDateTime().isBefore(bookTransactionsList.get(i).getDueDate())
						&& bookTransactionsList.get(i).getFineAmount() == 0) {
					System.out.println("Member returned the book successfully");
					System.out.println(bookTransactionsList);
					LibraryManagement.optionMethod();
				}

				else {
					long fine = ChronoUnit.DAYS.between(bookTransactionsList.get(i).getDueDate(),
							bookTransactionsList.get(i).getReturnDateTime());
					fine = fine * 10;
					bookTransactionsList.get(i).setFineAmount(fine);
					System.out.println("Fine amount of the person need to pay is Rs: " + fine);
					System.out.println("Enter the fine amount paid by the member");
					int amountPaid = sc.nextInt();
					if (amountPaid - fine == 0) {
						System.out.println("Member returned the book successfully");
						bookTransactionsList.get(i).setFineAmount(0);
						System.out.println(bookTransactionsList);
						LibraryManagement.optionMethod();
					} else {
						System.out.println("Please pay the fine amount:");
						returnBook();
					}
					System.out.println(bookTransactionsList);
					returnBook();
					// LibraryManagement.optionMethod();
				}

			} else {
				System.out.println("Please enter the valid book and member id");
			}
		}
		System.out.println(bookTransactionsList);
		LibraryManagement.optionMethod();
		sc.close();
	}

	public void showBookHistory() {
		System.out.println("Enter the bookname to show book history details:");
		Scanner scanner=new Scanner(System.in);
		String bookName=scanner.next();
		System.out.println(" Member id | Member Name | Issue time| Return time ");
		for(int i=0;i<bookTransactionsList.size();i++) {
			if(bookName.equals(bookTransactionsList.get(i).getBookName())) {
				System.out.println(bookTransactionsList.get(i).getMemberId()+"|"+bookTransactionsList.get(i).getMemberName()+"|"+
			bookTransactionsList.get(i).getIssueDateTime()+"|"+bookTransactionsList.get(i).getReturnDateTime());
				LibraryManagement.optionMethod();
			}
			else {
				System.out.println("Invalid book name please enter the correct name:");
				showBookHistory();
				
			}
		}
		
		
	}

}
