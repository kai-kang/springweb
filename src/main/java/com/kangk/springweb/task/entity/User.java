package com.kangk.springweb.task.entity;

public class User {
	private Integer id;		//主键
	private String userName;			//用户名
	private String password;			//密码
	private String fullnName;			//全名
	private String address;				//地址
	private String sex;					//性别1男、0女
	private Integer age;				//年龄
	private String email;				//邮件
	private String enabled;				//是否启用1启用、0不启用
	private String plainPassword;		//普通密码
	private String salt;				//SALT值属于随机值。用户注册时，系统用来和用户密码进行组合而生成的随机数值，称作salt值，通称为加盐值
	private Integer type;				//类型
	private Integer org;				//开源
	private String createTime;			//创建时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullnName() {
		return fullnName;
	}
	public void setFullnName(String fullnName) {
		this.fullnName = fullnName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getOrg() {
		return org;
	}
	public void setOrg(Integer org) {
		this.org = org;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public User() {
		super();
	}
	public User(Integer id, String userName, String password, String fullnName, String address, String sex, Integer age,
			String email, String enabled, String plainPassword, String salt, Integer type, Integer org,
			String createTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fullnName = fullnName;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.enabled = enabled;
		this.plainPassword = plainPassword;
		this.salt = salt;
		this.type = type;
		this.org = org;
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", fullnName=" + fullnName
				+ ", address=" + address + ", sex=" + sex + ", age=" + age + ", email=" + email + ", enabled=" + enabled
				+ ", plainPassword=" + plainPassword + ", salt=" + salt + ", type=" + type + ", org=" + org
				+ ", createTime=" + createTime + "]";
	}
	
	
	
	
	
}
