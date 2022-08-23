package com.Database;

public class KeySet 
{
	private int _id;
	private String key_aes;
	private String empOtp;
	
	public KeySet(String key_aes,String empOtp)
	{
		this.key_aes = key_aes;
		this.empOtp = empOtp;
	}

	public String getKey_aes() {
		return key_aes;
	}


	public void setKey_aes(String key_aes) {
		this.key_aes = key_aes;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getEmpOtp() {
		return empOtp;
	}

	public void setEmpOtp(String empOtp) {
		this.empOtp = empOtp;
	}
	
	

}
