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
    //借书时间
    private Date lendDay;
    //还书时间
    private Date lendBack;

    /**
     * 构造函数
     * @param lendBook
     * @param lendUser
     * @param lendDay
     */
    public Lend(Book lendBook, User lendUser, Date lendDay) {
        this.lendBook = lendBook;
        this.lendUser = lendUser;
        this.lendDay = lendDay;
    }
    
    

    /**
	 * @param lendId
	 * @param lendBook
	 * @param lendUser
	 * @param lendDay
	 * @param lendBack
	 */
	public Lend(int lendId, Book lendBook, User lendUser, Date lendDay, Date lendBack) {
		this.lendId = lendId;
		this.lendBook = lendBook;
		this.lendUser = lendUser;
		this.lendDay = lendDay;
		this.lendBack = lendBack;
	}



	public Lend() {
		// TODO 自动生成的构造函数存根
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
