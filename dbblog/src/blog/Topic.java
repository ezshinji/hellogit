/**
 * 
 */
package blog;

import java.util.Date;

/**
 * @author Shinji
 *
 */
public class Topic {
	
	/**
	 * 連番
	 */
	private int id;
	/**
	 * タイトル
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 投稿日
	 */
	private Date postDate;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content セットする content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return postDate
	 */
	public Date getPostDate() {
		return postDate;
	}
	/**
	 * @param postDate セットする postDate
	 */
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
		
}
