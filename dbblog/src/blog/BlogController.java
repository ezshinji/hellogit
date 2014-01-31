/**
 * 
 */
package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Shinji
 * 
 */
/**
 * @author Shinji
 *
 */
/**
 * @author Shinji
 *
 */
public class BlogController {
	/**
	 * シングルトンのインスタンス
	 */
	private static BlogController controller = new BlogController();

	/**
	 * @return
	 */
	public static BlogController getInstance() {
		return controller;
	}

	/**
	 * 
	 */
	private BlogController() {
	}

	public void postTopic(Topic topic) {
		String sql = "INSERT INTO TOPIC(TITLE, CONTENT) VALUES(?,?)";

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, topic.getTitle());
			ps.setString(2, topic.getContent());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		String sql = "SELECT * FROM TOPIC";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Topic topic = new Topic();
				topic.setId(rs.getInt("ID"));
				topic.setTitle(rs.getString("TITLE"));
				topic.setContent(rs.getString("CONTENT"));
				topic.setPostDate(rs.getTimestamp("POST_DATE"));
				topics.add(topic);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

		}
		return topics;
	}
	
	
	/**
	 * 動作確認用
	 * @param args
	 */
	public static void main(String[] args) {
		BlogController ctrl = BlogController.getInstance();
		ArrayList<Topic> list = (ArrayList<Topic>) ctrl.getTopics();
		for(Topic t : list)
			System.out.println(t.getTitle());
	}

}
