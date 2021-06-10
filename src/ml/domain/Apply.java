package ml.domain;

/**
 * 申请借书
 * @author luochengyun
 *
 */
public class Apply {
	//表ID
	private int appayId;
	//申请状态(0代表正在审核，1代表审核通过)
	private int applyState;
	//申请用户
	private User applyUser;
	//申请书籍
	private Book applyUook;
	/**
	 * @param appayId
	 * @param applyState
	 * @param applyUser
	 * @param applyUook
	 */
	public Apply(int appayId, int applyState, User applyUser, Book applyUook) {
		this.appayId = appayId;
		this.applyState = applyState;
		this.applyUser = applyUser;
		this.applyUook = applyUook;
	}
	/**
	 * @param applyState
	 * @param applyUser
	 * @param applyUook
	 */
	public Apply(int applyState, User applyUser, Book applyUook) {
		this.applyState = applyState;
		this.applyUser = applyUser;
		this.applyUook = applyUook;
	}
	/**
	 * 
	 */
	public Apply() {
	}
	public int getAppayId() {
		return appayId;
	}
	public void setAppayId(int appayId) {
		this.appayId = appayId;
	}
	public int getApplyState() {
		return applyState;
	}
	public void setApplyState(int applyState) {
		this.applyState = applyState;
	}
	public User getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(User applyUser) {
		this.applyUser = applyUser;
	}
	public Book getApplyUook() {
		return applyUook;
	}
	public void setApplyUook(Book applyUook) {
		this.applyUook = applyUook;
	}

	
	
	

}
