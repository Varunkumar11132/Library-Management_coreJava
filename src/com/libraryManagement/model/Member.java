package com.libraryManagement.model;

public class Member {
	private String memberId;
	private String memberName;
	private int memberAge;
	private String address;

	public Member(String memberId, String memberName, int memberAge, String address) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.address = address;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Member(String memberName, int memberAge, String address) {
		super();
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.address = address;
	}

	@Override
	public String toString() {
		return "[memberId=" + memberId + ", memberName=" + memberName + ", memberAge=" + memberAge + ", address="
				+ address + "]";
	}

}
