package ml.domain;

import java.util.Date;

/**
 * 书
 * @author luochengyun
 */
public class Book {
    //书的ID
    private int bookId;
    //书的名字
    private String bookName;
    //书的ISBN
    private String bookISBN;
    //书的介绍
    private String bookDesc;
    //书的价格
    private double bookPrice;
    //书的发行时间
    private Date bookRelease;
    //书的位置
    private String bookLocation;
    //书的数量
    private int bookCount;
    //书的状态
    private int bookState;
    //书的作者
    private Author bookAuthor;
    //书的出版社
    private Publishment bookPublish;
    //书的类型
    private Type bookType;
    
    

    
	/**
     * 构造函数
     * @param bookName
     * @param bookISBN
     * @param bookDesc
     * @param bookPrice
     * @param bookRelease
     * @param bookLocation
     * @param bookCount
     * @param bookState
     * @param bookAuthor
     * @param bookPublish
     * @param bookType
     */
    public Book(String bookName, String bookISBN, String bookDesc, double bookPrice, Date bookRelease, String bookLocation,int bookCount, int bookState, Author bookAuthor, Publishment bookPublish,Type bookType) {
        this.bookName = bookName;
        this.bookISBN = bookISBN;
        this.bookDesc = bookDesc;
        this.bookPrice = bookPrice;
        this.bookRelease = bookRelease;
        this.bookLocation = bookLocation;
        this.bookCount = bookCount;
        this.bookState = bookState;
        this.bookAuthor = bookAuthor;
        this.bookPublish = bookPublish;
        this.bookType = bookType;
    }
    
    

    /**
	 * @param bookId
	 * @param bookName
	 * @param bookISBN
	 * @param bookDesc
	 * @param bookPrice
	 * @param bookRelease
	 * @param bookLocation
	 * @param bookCount
	 * @param bookState
	 * @param bookAuthor
	 * @param bookPublish
	 * @param bookType
	 */
	public Book(int bookId, String bookName, String bookISBN, String bookDesc, double bookPrice, Date bookRelease,
			String bookLocation, int bookCount, int bookState, Author bookAuthor, Publishment bookPublish,
			Type bookType) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookISBN = bookISBN;
		this.bookDesc = bookDesc;
		this.bookPrice = bookPrice;
		this.bookRelease = bookRelease;
		this.bookLocation = bookLocation;
		this.bookCount = bookCount;
		this.bookState = bookState;
		this.bookAuthor = bookAuthor;
		this.bookPublish = bookPublish;
		this.bookType = bookType;
	}



	public Book() {
		// TODO 自动生成的构造函数存根
	}

	public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getBookRelease() {
        return bookRelease;
    }

    public void setBookRelease(Date bookRelease) {
        this.bookRelease = bookRelease;
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public int getBookState() {
        return bookState;
    }

    public void setBookState(int bookState) {
        this.bookState = bookState;
    }

	public Author getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Publishment getBookPublish() {
		return bookPublish;
	}

	public void setBookPublish(Publishment bookPublish) {
		this.bookPublish = bookPublish;
	}

	public Type getBookType() {
		return bookType;
	}

	public void setBookType(Type bookType) {
		this.bookType = bookType;
	}

    
    
}
