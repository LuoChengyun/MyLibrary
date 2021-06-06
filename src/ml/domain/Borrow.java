package ml.domain;

import java.sql.Timestamp;

/**
 * 结束记录实体类
 * @author luochengyun
 *
 */
public class Borrow {
	
	/**
	 * 记录ID
	 */
	private Long Id;
	/**
	 * 所借的书
	 */
	private Book book;
	/**
	 * 结束的用户
	 */
	private User user;
	/**
	 * 借书时间
	 */
	private Timestamp start;
	/**
	 * 还书时间
	 */
	private Timestamp end;
	
	
	
	/**
	 * @param id
	 * @param book
	 * @param user
	 * @param start
	 * @param end
	 */
	public Borrow(Long id, Book book, User user, Timestamp start, Timestamp end) {
		
		this.Id = id;
		this.book = book;
		this.user = user;
		this.start = start;
		this.end = end;
	}
	
	public Borrow(Book book, User user, Timestamp start, Timestamp end) {
		
		this(null,book,user,start,end);
	}

	public Borrow () {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Borrow other = (Borrow) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	

}
