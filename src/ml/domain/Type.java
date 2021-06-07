package ml.domain;


/**
 * 分类实体类
 * @author luochengyun
 *
 */
public class Type {
	
	//分类ID
	private int typeId;
	 //分类名
	private String typeName;
	
	
	
	/**
	 * 
	 */
	public Type() {
	}
	/**
	 * @param typeName
	 */
	public Type(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * @param typeId
	 * @param typeName
	 */
	public Type(int typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
	
}
