package com.Database;

public class User {

	public int _id;
	public String empNo;
	public String empName;
	public String fromMobile;
	public String toMobile;
	
	
	
	
	public User(String empNo,String empName,String  fromMobile,String toMobile)
	{
		this.empNo = empNo;
		this.empName = empName;
		this.fromMobile = fromMobile;
		this.toMobile = toMobile;
		
	}




	public int get_id() {
		return _id;
	}




	public void set_id(int _id) {
		this._id = _id;
	}




	public String getEmpNo() {
		return empNo;
	}




	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}




	public String getFromMobile() {
		return fromMobile;
	}




	public void setFromMobile(String fromMobile) {
		this.fromMobile = fromMobile;
	}




	public String getToMobile() {
		return toMobile;
	}




	public void setToMobile(String toMobile) {
		this.toMobile = toMobile;
	}
	
	
	

}
