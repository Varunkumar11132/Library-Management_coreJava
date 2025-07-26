package com.libraryManagement.db;

import java.util.ArrayList;
import java.util.List;

import com.libraryManagement.model.Member;

public class MemberDb {
	private static List<Member> memberList;
	public static List<Member>getMemberDb(){
		if(memberList==null) {
			memberList= new ArrayList<Member>();
		}
		return memberList;
	}
	
}
