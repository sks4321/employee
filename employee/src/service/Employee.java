package service;

import java.util.ArrayList;

public class Employee {
	private int employeeNo;
	private String employeeName;
	private String employeeGender;
	private ArrayList<Skill> skill;
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public ArrayList<Skill> getSkill() {
		return skill;
	}
	public void setSkill(ArrayList<Skill> skill) {
		this.skill = skill;
	}
}
