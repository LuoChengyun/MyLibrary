package ml.domain;

import java.sql.Date;

/**
 * 借书表
 * @author luochengyun
 */
public class Lend {
    //借书表ID
    private int lendId;
    //借书表包含的书ID
    private Book lendBook;
    //借书表包含的用户
    private User lendUser;
    //借书进度 0代表申请借书，1代表正在读， 2代表申请还书， 3代表已经还书
    private int lendState;
    //借书时间
    private Date lendDay;
    //还书时间
    private Date lendBack;
	/**
	 * @param lendId
	 * @param lendBook
	 * @param lendUser
	 * @param lendState
	 * @param lendDay
	 * @param lendBack
	 */
	public Lend(int lendId, Book lendBook, User lendUser, int lendState, Date lendDay, Date lendBack) {
		super();
		this.lendId = lendId;
		this.lendBook = lendBook;
		this.lendUser = lendUser;
		this.lendState = lendState;
		this.lendDay = lendDay;
		this.lendBack = lendBack;
	}
	/**
	 * @param lendBook
	 * @param lendUser
	 * @param lendState
	 * @param lendDay
	 * @param lendBack
	 */
	public Lend(Book lendBook, User lendUser, int lendState, Date lendDay, Date lendBack) {
		super();
		this.lendBook = lendBook;
		this.lendUser = lendUser;
		this.lendState = lendState;
		this.lendDay = lendDay;
		this.lendBack = lendBack;
	}
	/**
	 * 
	 */
	public Lend() {
		super();
	}
	public int getLendId() {
		return lendId;
	}
	public void setLendId(int lendId) {
		this.lendId = lendId;
	}
	public Book getLendBook() {
		return lendBook;
	}
	public void setLendBook(Book lendBook) {
		this.lendBook = lendBook;
	}
	public User getLendUser() {
		return lendUser;
	}
	public void setLendUser(User lendUser) {
		this.lendUser = lendUser;
	}
	public int getLendState() {
		return lendState;
	}
	public void setLendState(int lendState) {
		this.lendState = lendState;
	}
	public Date getLendDay() {
		return lendDay;
	}
	public void setLendDay(Date lendDay) {
		this.lendDay = lendDay;
	}
	public Date getLendBack() {
		return lendBack;
	}
	public void setLendBack(Date lendBack) {
		this.lendBack = lendBack;
	}

    
}
