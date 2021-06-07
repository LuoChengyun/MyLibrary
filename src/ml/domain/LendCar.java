package ml.domain;

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

    /**
     * 构造函数
     * @param lendCarUser
     * @param lendCarBook
     */
    public LendCar(User lendCarUser, Book lendCarBook) {
        this.lendCarUser = lendCarUser;
        this.lendCarBook = lendCarBook;
    }

    public LendCar() {
		// TODO 自动生成的构造函数存根
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

    
}
