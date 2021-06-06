package ml.domain;

/**
 * 借阅车
 * @author luochengyun
 */
public class LendCar {
    //借阅车ID
    private int lendCarId;
    //借车包含用户用户ID
    private int lendCarUser;
    //借车包含的书ID
    private int lendCarBook;

    /**
     * 构造函数
     * @param lendCarUser
     * @param lendCarBook
     */
    public LendCar(int lendCarUser, int lendCarBook) {
        this.lendCarUser = lendCarUser;
        this.lendCarBook = lendCarBook;
    }

    public int getLendCarId() {
        return lendCarId;
    }

    public void setLendCarId(int lendCarId) {
        this.lendCarId = lendCarId;
    }

    public int getLendCarUser() {
        return lendCarUser;
    }

    public void setLendCarUser(int lendCarUser) {
        this.lendCarUser = lendCarUser;
    }

    public int getLendCarBook() {
        return lendCarBook;
    }

    public void setLendCarBook(int lendCarBook) {
        this.lendCarBook = lendCarBook;
    }
}
