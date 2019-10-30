package com.tthshop.entities;

public class Report {
	private String name;
	private int num;
	
	public Report() {

	}

	public Report(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
