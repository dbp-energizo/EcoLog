package model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import ch.qos.logback.core.Context;

import model.Post;

public class postDAO {
	private HttpServletRequest request;
	private Context context;
	private DataSource datasource;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement preStmt;
	private ResultSet result;
	private JDBCUtil jdbcUtil = null;
	
	public postDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	public List<Post> postList(int currentPage, int countPerPage) {
		String sql = "SELECT postnum, title, writer, category, writedate " 
				+ "FROM USER_INFO u LEFT OUTER JOIN POST p ON u.id = p.writer "
				+ "ORDER BY postnum";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
			ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
			ResultSet.CONCUR_READ_ONLY);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Post> postList = new ArrayList<Post>();	// User들의 리스트 생성
				do {
					Post post = new Post(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("postnum"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("category"),
						rs.getString("writedate"));
					postList.add(post);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return postList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
		
		

		/*try {

			
			
			// 리스트 정보 가져오기
			String query = "select * from "
					+ "(select ROWNUM as rnum, A.* from "
					+ "(select * from board_chat order by bdgroup desc, bdorder)A ) "
					+ "where rnum >= ? and rnum <= ?";
			preStmt = conn.prepareStatement(query);
			// 요청된 페이지에 따른 게시물 범위 지정
			int startPage = (page - 1) * BoardList.pagePerList + 1; // 시작 게시물
			int endPage = startPage + BoardList.pagePerList - 1; // 끝 게시물
			preStmt.setInt(1, startPage);
			preStmt.setInt(2, endPage);
			result = preStmt.executeQuery();
			
			// 결과를 ArrayList에 추가
			ArrayList<Post> list = new ArrayList<>(); // 리스트 정보 담아줄 객체
			while (result.next()) {
				Post dto = new Post();
				dto.setPostNum(result.getInt("postnum"));
				dto.setTitle(result.getString("title"));
				dto.setCategory(result.getString("category"));
				dto.setContent(result.getString("content"));
				dto.setVisitCount(result.getInt("visitcnt"));
				dto.setWriteDate(result.getString("date"));

				list.add(dto);
			}

			// 일반 배열로 지정해서 전달 (제네릭 타입은 타입변환에서 warning 발생)
			Post[] bdList = list.toArray(new Post[list.size()]);
			request.setAttribute("bdList", bdList); // 리스트 전달

			return Ctrl.TRUE;

		} catch (Exception e) {
			System.out.println("readList db working Fail");
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return Ctrl.EXCEPT;
	}*/
	
	
	

}
