package ml.domain;

/**
 * 出版社
 * @author luochengyun
 */
public class Publishment {
    //出版社ID
    private int publishId;
    //出版社名字
    private String publishName;
    //出版社地址
    private String publishLocal;

    /**
     * 构造函数
     * @param publishName
     * @param publishLocal
     */
    public Publishment(String publishName, String publishLocal) {
        this.publishName = publishName;
        this.publishLocal = publishLocal;
    }
    
    

    /**
	 * @param publishId
	 * @param publishName
	 * @param publishLocal
	 */
	public Publishment(int publishId, String publishName, String publishLocal) {
		super();
		this.publishId = publishId;
		this.publishName = publishName;
		this.publishLocal = publishLocal;
	}



	public Publishment() {
		// TODO 自动生成的构造函数存根
	}

	public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPublishLocal() {
        return publishLocal;
    }

    public void setPublishLocal(String publishLocal) {
        this.publishLocal = publishLocal;
    }
}
