package com.libraryManagement.model;

import java.time.LocalDateTime;

public class BookTransaction {
	private String bookId;
	private String memberId;
	private String bookName;
	private String memberName;
	private LocalDateTime issueDateTime;
	private boolean isReturned = false;
	private LocalDateTime returnDateTime;
	private LocalDateTime dueDate;
	private long fineAmount;

	public long getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(long fineAmount) {
		this.fineAmount = fineAmount;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public LocalDateTime getIssueDateTime() {
		return issueDateTime;
	}

	public void setIsueDateTime(LocalDateTime bookIssueDate) {
		this.issueDateTime = bookIssueDate;
	}
	public LocalDateTime getReturnDateTime() {
		return returnDateTime;
	}

	public void setReturnDateTime(LocalDateTime returnDateTime) {
		this.returnDateTime = returnDateTime;
	}

	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public BookTransaction(String bookId, String memberId) {
		super();
		this.bookId = bookId;
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "BookTransaction [bookId=" + bookId + ", memberId=" + memberId + ", bookName=" + bookName
				+ ", memberName=" + memberName + ", issueDateTime=" + issueDateTime + ", isReturned=" + isReturned
				+ ", returnDateTime=" + returnDateTime + ", dueDate=" + dueDate + ", fineAmount=" + fineAmount + "]";
	}
}
