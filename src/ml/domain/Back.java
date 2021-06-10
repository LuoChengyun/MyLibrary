package ml.domain;

public class Back {

	//表ID
	private int backId;
	//申请状态(0代表等待还书，1代表已经还书)
	private int backState;
	//申请用户
	private User backUser;
	//申请书籍
	private Book backUook;
	/**
	 * @param backId
	 * @param backState
	 * @param backUser
	 * @param backUook
	 */
	public Back(int backId, int backState, User backUser, Book backUook) {
		this.backId = backId;
		this.backState = backState;
		this.backUser = backUser;
		this.backUook = backUook;
	}
	/**
	 * 
	 */
	public Back() {
	}
	/**
	 * @param backState
	 * @param backUser
	 * @param backUook
	 */
	public Back(int backState, User backUser, Book backUook) {
		super();
		this.backState = backState;
		this.backUser = backUser;
		this.backUook = backUook;
	}
	public int getBackId() {
		return backId;
	}
	public void setBackId(int backId) {
		this.backId = backId;
	}
	public int getBackState() {
		return backState;
	}
	public void setBackState(int backState) {
		this.backState = backState;
	}
	public User getBackUser() {
		return backUser;
	}
	public void setBackUser(User backUser) {
		this.backUser = backUser;
	}
	public Book getBackUook() {
		return backUook;
	}
	public void setBackUook(Book backUook) {
		this.backUook = backUook;
	}
	
	
	
}
