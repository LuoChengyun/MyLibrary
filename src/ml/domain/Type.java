package ml.domain;


/**
 * 分类实体类
 * @author luochengyun
 *
 */
public class Type {
	
	/**
	 * 分类ID
	 */
	private Long Id;
	/**
	 * 分类名
	 */
	private String Name;
	
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Type(Long id, String name) {
		
		this.Id = id;
		this.Name = name;
	}
	/**
	 * 
	 * @param name
	 */
	public Type(String name) {
		this(null,name);
	}


	
	public Type() {
		// TODO 自动生成的构造函数存根
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}


	
	
}
