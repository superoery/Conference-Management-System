package team.softwarede.confersys.entity;

public class User {

    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_id
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	private String userId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.identity_id
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	private Integer identityId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.name
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.sex
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	private String sex;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.telephone
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	private String telephone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.email
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	private String email;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	private String password;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.user_id
	 * @return  the value of user.user_id
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.user_id
	 * @param userId  the value for user.user_id
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.identity_id
	 * @return  the value of user.identity_id
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public Integer getIdentityId() {
		return identityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.identity_id
	 * @param identityId  the value for user.identity_id
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public void setIdentityId(Integer identityId) {
		this.identityId = identityId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.name
	 * @return  the value of user.name
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.name
	 * @param name  the value for user.name
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.sex
	 * @return  the value of user.sex
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.sex
	 * @param sex  the value for user.sex
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.telephone
	 * @return  the value of user.telephone
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.telephone
	 * @param telephone  the value for user.telephone
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.email
	 * @return  the value of user.email
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.email
	 * @param email  the value for user.email
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbg.generated  Sat Jun 01 21:30:06 CST 2019
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	private String userId;

    private Integer id;

    private Integer ideId;

    private String name;

    private String sex;

    private String telephone;

    private String email;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }
}