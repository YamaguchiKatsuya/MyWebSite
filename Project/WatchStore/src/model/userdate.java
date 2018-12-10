package model;

import java.util.Date;

public class userdate {

	private int id;
	private String user_name;
	private String address;
	private Date birth_date;
	private String password;
	private String create_date;
	private String update_date;




	public userdate(String user_name, String address, Date birth_date, String password) {
		super();
		this.user_name = user_name;
		this.address = address;
		this.birth_date = birth_date;
		this.password = password;
	}
	public userdate(int id, String user_name, String password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
	}
	public userdate(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}
	public userdate() {
		super();
	}
	public userdate(int id, String user_name, String address, Date birth_date, String password, String create_date,
			String update_date) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.address = address;
		this.birth_date = birth_date;
		this.password = password;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
}

