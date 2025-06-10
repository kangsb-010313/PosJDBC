package Pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//카테고리 데이터베이스 접근을 담당하는 클래스
public class CategoryDAO {
	// 카테고리 등록
	public static void categoryInsert(String emoji, String name, String explanation) throws SQLException {
		
		String query = "";
		query += "insert into category ";
		query += "values(null, ?, ?, ?)";
		
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, emoji);
			pstmt.setString(2, name);
			pstmt.setString(3, explanation);
			pstmt.executeUpdate();
		}
	}

	// 카테고리 조회 (전체)
	public static List<CategoryVO> getAllCategories() throws SQLException {
		
		List<CategoryVO> list = new ArrayList<>();
		String query = "select * from category";
		
		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
				while (rs.next()) {
					list.add(new CategoryVO(rs.getInt("category_id"), rs.getString("emoji"), rs.getString("name"), rs.getString("explanation")));
				}
		}
		return list;
	}

	// 카테고리 조회 (단일)
	public static CategoryVO getCategory(int categoryId) throws SQLException {
		
		String query = "select * from category WHERE category_id = ?";
		
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, categoryId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return new CategoryVO(rs.getInt("category_id"), rs.getString("emoji"), rs.getString("name"), rs.getString("explanation"));
			}
		}
		return null;
	}

	// 카테고리 수정
	public static void updateCategory(int categoryId, String emoji, String name, String explanation) throws SQLException {
		
		String query = "update category ";
		query += " set emoji=?, ";
		query += " name=?, ";
		query += " explanation=? ";
		query += " where category_id=? ";
		
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setString(1, emoji);
			pstmt.setString(2, name);
			pstmt.setString(3, explanation);
			pstmt.setInt(4, categoryId);
			pstmt.executeUpdate();
		}
	}

	// 카테고리 삭제
	public static void deleteCategory(int categoryId) throws SQLException {
		
		String query = " delete from category ";
		query += " where category_id = ? ";
		
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, categoryId);
			pstmt.executeUpdate();
		}
	}
}