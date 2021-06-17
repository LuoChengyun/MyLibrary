package ml.domain;

/**
 * 用户
 * @author luochengyun
 */
public class User {
    //用户ID
    private int userId;
    //用户名字
    private String userName;
    //用户账号
    private String userAccount;
    //用户密码
    private String userPassword;
    //用户标识符
    private int userIdentity;
    //用户状态
    private int userState;
    //用户删除标识
    private int userRemove;

    /**
     *构造函数（用户注册和增加用户）
     * @param userName
     * @param userAccount
     * @param userPassword
     */
    public User(String userName, String userAccount, String userPassword) {
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
    }

    /**
     * 构造函数(用户增加管理员)
     * @param userName
     * @param userAccount
     * @param userPassword
     * @param userIdentity
     */
    public User(String userName, String userAccount, String userPassword, int userIdentity) {
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userIdentity = userIdentity;
    }

    
    
	/**
	 * @param userId
	 * @param userName
	 * @param userAccount
	 * @param userPassword
	 */
	public User(int userId, String userName, String userAccount, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param userAccount
	 * @param userPassword
	 * @param userIdentity
	 * @param userState
	 * @param userRemove
	 */
	public User(int userId, String userName, String userAccount, String userPassword, int userIdentity, int userState,
			int userRemove) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userIdentity = userIdentity;
		this.userState = userState;
		this.userRemove = userRemove;
	}

	public User() {
		// TODO 自动生成的构造函数存根
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(int userIdentity) {
        this.userIdentity = userIdentity;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public int getUserRemove() {
        return userRemove;
    }

    public void setUserRemove(int userRemove) {
        this.userRemove = userRemove;
    }
}