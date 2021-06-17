package ml.domain;

import java.sql.Date;

/**
 * 借阅车
 * @author luochengyun
 */
public class LendCar {
    //借阅车ID
    private int lendCarId;
    //借车包含用户用户ID
    private User lendCarUser;
    //借车包含的书ID
    private Book lendCarBook;
    //借车日期
    private Date lendCarDay;
	/**
	 * @param lendCarId
	 * @param lendCarUser
	 * @param lendCarBook
	 * @param lendCarState
	 * @param lendCarDay
	 */
	public LendCar(int lendCarId, User lendCarUser, Book lendCarBook, Date lendCarDay) {
		super();
		this.lendCarId = lendCarId;
		this.lendCarUser = lendCarUser;
		this.lendCarBook = lendCarBook;
		this.lendCarDay = lendCarDay;
	}
	/**
	 * @param lendCarUser
	 * @param lendCarBook
	 * @param lendCarState
	 * @param lendCarDay
	 */
	public LendCar(User lendCarUser, Book lendCarBook,  Date lendCarDay) {
		super();
		this.lendCarUser = lendCarUser;
		this.lendCarBook = lendCarBook;
		this.lendCarDay = lendCarDay;
	}
	/**
	 * 
	 */
	public LendCar() {
		super();
	}
	public int getLendCarId() {
		return lendCarId;
	}
	public void setLendCarId(int lendCarId) {
		this.lendCarId = lendCarId;
	}
	public User getLendCarUser() {
		return lendCarUser;
	}
	public void setLendCarUser(User lendCarUser) {
		this.lendCarUser = lendCarUser;
	}
	public Book getLendCarBook() {
		return lendCarBook;
	}
	public void setLendCarBook(Book lendCarBook) {
		this.lendCarBook = lendCarBook;
	}
	public Date getLendCarDay() {
		return lendCarDay;
	}
	public void setLendCarDay(Date lendCarDay) {
		this.lendCarDay = lendCarDay;
	}
    
    
    
}
