package com.libraryManagement;

import java.util.Scanner;

import com.libraryManagement.service.BookService;
import com.libraryManagement.service.BookTransactionService;
import com.libraryManagement.service.MemberService;

public class LibraryManagement {
	static BookService bookService = new BookService();
	static MemberService memberService = new MemberService();
	static BookTransactionService bookTransactionService = new BookTransactionService();

	public static void optionMethod() {
		System.out.println("Select the one of the below:");
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Book");
		System.out.println("2.Add Member");
		System.out.println("3.Issue Book");
		System.out.println("4.Return Book");
		System.out.println("5.To Display Book details");
		System.out.println("6.To Display Members");
		System.out.println("7.Add extra copies of book");
		System.out.println("8.Show book history");
		System.out.println("9.To Update MemberName");
		int option = sc.nextInt();
		if (option == 1) {
			bookService.addBook();
		} else if (option == 2) {
			memberService.addMember();
		} else if (option == 3) {
			bookTransactionService.issuedBook();
		} else if (option == 4) {
			bookTransactionService.returnBook();
		} else if (option == 5) {
			bookService.displayBook();
		} else if (option == 6) {
			memberService.displayMembers();
		} else if (option == 7) {
			bookService.addExtraBookCopies();
		}
		else if (option == 8) {
			bookTransactionService.showBookHistory();
		}
		else if (option == 9) {
			memberService.updateMemberName();
		}else {
			System.out.println("Invalid option");
			optionMethod();
		}
		sc.close();
	}

	public static void main(String[] args) {
		optionMethod();

	}

}
