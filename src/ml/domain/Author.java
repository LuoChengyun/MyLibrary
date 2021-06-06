package ml.domain;

/**
 * 作者
 * @author luochengyun
 */
public class Author {
    //作者ID
    private int authorId;
    //作者姓名
    private int authorName;
    //作者性别(0代表男，1代表女)
    private int authorSex;
    //作者介绍
    private String authorIntroduct;

    /**
     * 构造函数
     * @param authorName
     * @param authorSex
     */
    public Author(int authorName, int authorSex) {
        this.authorName = authorName;
        this.authorSex = authorSex;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getAuthorName() {
        return authorName;
    }

    public void setAuthorName(int authorName) {
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
