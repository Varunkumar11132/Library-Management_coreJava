package com.libraryManagement.service;

import java.util.List;
import java.util.Scanner;

import com.libraryManagement.LibraryManagement;
import com.libraryManagement.db.MemberDb;
import com.libraryManagement.model.Member;

public class MemberService {
	List<Member> memberList = MemberDb.getMemberDb();

	public void addMember() {
		System.out.println("Enter the member ID:");
		Scanner sc = new Scanner(System.in);
		String memberid = sc.next();
		if (!checkMemberIdAlreadyExistOrNot(memberid)) {
			System.out.println("Enter the member name:");
			String memberName = sc.next();
			System.out.println("Enter the age:");
			int age = sc.nextInt();
			System.out.println("Enter the address:");
			String address = sc.next();
			Member member = new Member(memberid, memberName, age, address);
			memberList.add(member);
			System.out.println("Member details added successfully");
			// System.out.println(memberList);
			LibraryManagement.optionMethod();
			sc.close();
		} else {
			System.out.println("Member id is already exist please enter the unique id:");
			addMember();
		}

	}

	public String getMemberNameByMemberId(String memberId) {
		String memberName = null;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				memberName = memberList.get(i).getMemberName();
			}
		}
		return memberName;
	}

	public boolean checkMemberIdAlreadyExistOrNot(String memberId) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberId.equals(memberList.get(i).getMemberId())) {
				return true;
			}
		}
		return false;

	}

	public void displayMembers() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println(memberList.get(i).getMemberId() + "|" + memberList.get(i).getMemberName() + "|"
					+ memberList.get(i).getAddress());
		}
		LibraryManagement.optionMethod();
	}

	public String validateMemberId() {
		System.out.println("Enter the member id");
		Scanner sc = new Scanner(System.in);
		String memberId = sc.next();
		if (checkMemberIdAlreadyExistOrNot(memberId)) {
			return memberId;
		} else {
			System.out.println("Memberid is not exist:");
			return validateMemberId();
		}

	}

	public void updateMemberName() {
		System.out.println("Enter the member ID");
		Scanner scanner = new Scanner(System.in);
		String memberId = scanner.next();
		if (checkMemberIdAlreadyExistOrNot(memberId)) {
			String oldRecordName = getMemberNameByMemberId(memberId);
			System.out.println("Older recrd name:" + oldRecordName);
			System.out.println("Enter the name to need to update:");
			String newName = scanner.next();
			for (int i = 0; i < memberList.size(); i++) {
				if (memberId.equals(memberList.get(i).getMemberId())) {
					memberList.get(i).setMemberName(newName);
					System.out.println("The name is updated to the record successfully");
					LibraryManagement.optionMethod();
				}
			}
		}
		else {
			System.out.println("Member Id does not esist");
			updateMemberName();
		}
	}
}
