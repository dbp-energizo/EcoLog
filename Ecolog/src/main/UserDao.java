package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CustomerDTO;
import model.Customer;

import dto.CustomerDTO;
/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class UserDao2{
	private JDBCUtil jdbcUtil = null;
	
	public UserDao2() {			
		jdbcUtil = new JDBCUtil();	// JDBC
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int createCustomer(CustomerDTO cus) throws SQLException {
		String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {cus.getCusId(), cus.getPassword(), 
				cus.getName(), cus.getPhone(), cus.getEmail(), cus.getAddress(), cus.getBirth()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(cus.getName() + "삽입되었습니다.");
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int updateInfo(CustomerDTO cus) {
		
		String updateQuery = "UPDATE STUDENT SET ";
		int index = 0;
		Object[] tempParam = new Object[10];		// update 문에 사용할 매개변수를 저장할 수 있는 임시 배열
		
		if (cus.getPassword() != null) {		// 이름이 설정되어 있을 경우
			updateQuery += "password = ?, ";		// update 문에 이름 수정 부분 추가
			tempParam[index++] = cus.getPassword();		// 매개변수에 수정할 이름 추가
		}
		if (cus.getPhone() != null) {		// 패스워드가 설정되어 있을 경우
			updateQuery += "phone = ?, ";		// update 문에 패스워드 수정 부분 추가
			tempParam[index++] = cus.getPhone();		// 매개변수에 수정할 패스워드 추가
		}
		if (cus.getEmail() != null) {		// 휴대폰 번호가 설정되어 있을 경우
			updateQuery += "email = ?, ";		// update 문에 휴대폰 수정 부분 추가
			tempParam[index++] = cus.getEmail();		// 매개변수에 수정할 휴대폰 추가
		}
		if (cus.getAddress() != null) {		// 학년이 설정되어 있을 경우
			updateQuery += "address = ?, ";		// update 문에 학년 수정 부분 추가
			tempParam[index++] = cus.getAddress();		// 매개변수에 수정할 학년 추가
		}
		if (cus.getBirth() != null) {		// 교수코드가 설정되어 있을 경우
			updateQuery += "birth = ?, ";		// update 문에 지도교수 수정 부분 추가
			tempParam[index++] = cus.getBirth();		// 매개변수에 수정할 지도교수코드 추가
		}
		updateQuery += "WHERE customerId = ? ";		// update 문에 조건 지정
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 문의 where 절 앞에 있을 수 있는 , 제거
		
		tempParam[index++] = cus.getCusId();		// 찾을 조건에 해당하는 학번에 대한 매개변수 추가
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		// 매개변수의 개수만큼의 크기를 갖는 배열을 생성하고 매개변수 값 복사
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSqlAndParameters(updateQuery, newParam);
		
		try {
			int result = jdbcUtil.executeUpdate();		// update 문 실행
			return result;			// update 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int removeCustomer(String customerId) throws SQLException {
		String sql = "DELETE FROM USERINFO WHERE customerId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public CustomerDTO findUser(String customerId) throws SQLException {
        String sql = "SELECT password, name, phone, email, address, birth, nickname"
        			+ "FROM CUSTOMER"
        			+ "WHERE customerId=? ";          
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			CustomerDTO dto = null;
			if (rs.next()) {						// 학생 정보 발견
				dto = new CustomerDTO();	
				dto.setCusId(customerId);
				dto.setPassword("password");
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setBirth(rs.getString("birth"));
				dto.setNickname(rs.getString("nickname"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<CustomerDTO> findUserList() throws SQLException {
        String sql = "SELECT customerId, name, phone,email, birth,nickname " 
        		   + "FROM Customer"
        		   + "ORDER BY customerId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<CustomerDTO> cusList = new ArrayList<CustomerDTO>();	// User들의 리스트 생성
			while (rs.next()) {
				CustomerDTO dto = new CustomerDTO();		
					dto.setCusId(rs.getString("customerId"));
					dto.setPassword("null");
					dto.setName(rs.getString("name"));
					dto.setPhone(rs.getString("phone"));
					dto.setEmail(rs.getString("email"));
					dto.setAddress(null);
					dto.setBirth(rs.getString("birth"));
					dto.setNickname(rs.getString("nickname"));
				cusList.add(dto);				// List에 User 객체 저장
			}		
			return cusList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<CustomerDTO> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT customerId, name, phone,email, birth " 
					+ "FROM USERINFO"
					+ "ORDER BY userId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<CustomerDTO> cusList = new ArrayList<CustomerDTO>();	// User들의 리스트 생성
				do {
					CustomerDTO dto = new CustomerDTO();		
						dto.setCusId(rs.getString("customerId"));
						dto.setPassword(null);
						dto.setName(rs.getString("name"));
						dto.setPhone(rs.getString("phone"));
						dto.setEmail(rs.getString("email"));
						dto.setAddress(null);
						dto.setBirth(rs.getString("birth"));
						dto.setNickname(rs.getString("nickname"));
					cusList.add(dto);				
				}while ((rs.next()) && (--countPerPage > 0));	
				return cusList;								
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 특정 모임에 속한 사용자들을 검색하여 List에 저장 및 반환
	 */
	public List<CustomerDTO> findUsersInCommunity(String meetingName) throws SQLException {
        String sql = "SELECT customerId, name, email, phone FROM Customer u LEFT OUTER JOIN Meeting m ON c.customerId = m.cusId "
     				+ "WHERE m.meetingName = ?";                         
		jdbcUtil.setSqlAndParameters(sql, new Object[] {meetingName});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<CustomerDTO> cusList = new ArrayList<CustomerDTO>();	// member들의 리스트 생성
			while (rs.next()) {
				CustomerDTO dto = new CustomerDTO();		
				dto.setCusId(rs.getString("customerId"));
				dto.setPassword(null);
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(null);
				dto.setBirth(rs.getString("birth"));
				dto.setNickname(rs.getString("nickname"));
			cusList.add(dto);					
			}		
			return cusList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String customerId) throws SQLException {
		String sql = "SELECT count(*) FROM Customer WHERE customerId=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}


	public boolean existingNickname(String nickname) throws SQLException {
		String sql = "SELECT count(*) FROM Customer WHERE nickname=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {nickname});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

	public int updateNickname(CustomerDTO cus) throws SQLException {
		String sql = "UPDATE Customer "
					+ "SET nickname=?"
					+ "WHERE customerId=?";
		Object[] param = new Object[] {cus.getNickname(),cus.getCusId()};		//잘모르겠음		
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

}
