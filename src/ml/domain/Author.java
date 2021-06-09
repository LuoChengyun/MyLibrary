package ml.domain;

/**
 * 作者
 * @author luochengyun
 */
public class Author {
    //作者ID
    private int authorId;
    //作者姓名
    private String authorName;
    //作者性别(0代表男，1代表女)
    private int authorSex;
    //作者介绍
    private String authorIntroduct;

    /**
     * 构造函数
     * @param authorName
     * @param authorSex
     */
    public Author(String authorName, int authorSex) {
        this.authorName = authorName;
        this.authorSex = authorSex;
    }
    
    




	public Author() {
		// TODO 自动生成的构造函数存根
	}

	

	/**
	 * @param authorId
	 * @param authorName
	 * @param authorSex
	 * @param authorIntroduct
	 */
	public Author(int authorId, String authorName, int authorSex, String authorIntroduct) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorSex = authorSex;
		this.authorIntroduct = authorIntroduct;
	}

	public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorSex() {
        return authorSex;
    }

    public void setAuthorSex(int authorSex) {
        this.authorSex = authorSex;
    }

    public String getAuthorIntroduct() {
        return authorIntroduct;
    }

    public void setAuthorIntroduct(String authorIntroduct) {
        this.authorIntroduct = authorIntroduct;
    }
}
