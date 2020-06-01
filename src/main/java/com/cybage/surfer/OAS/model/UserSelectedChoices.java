package com.cybage.surfer.OAS.model;

public class UserSelectedChoices {
	int qid;
	String ans;
	
	public UserSelectedChoices() {
	}

	public UserSelectedChoices(int qid, String ans) {
		super();
		this.qid = qid;
		this.ans = ans;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "UserSelectedChoices [qid=" + qid + ", ans=" + ans + "]";
	}
	
	
	
	
}
