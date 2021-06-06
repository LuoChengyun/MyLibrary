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
    private int lendBook;
    //借书表包含的用户
    private int lendUser;
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
    public Lend(int lendBook, int lendUser, Date lendDay) {
        this.lendBook = lendBook;
        this.lendUser = lendUser;
        this.lendDay = lendDay;
    }

    public int getLendId() {
        return lendId;
    }

    public void setLendId(int lendId) {
        this.lendId = lendId;
    }

    public int getLendBook() {
        return lendBook;
    }

    public void setLendBook(int lendBook) {
        this.lendBook = lendBook;
    }

    public int getLendUser() {
        return lendUser;
    }

    public void setLendUser(int lendUser) {
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
