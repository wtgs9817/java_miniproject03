package com.scoremanagementprogram.dbutil.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;

import com.scoremanagementprogram.dbutil.common.DatabaseConnector;

public class AccountDAO {

	//JDBC 관련 변수
		private Connection conn;
		private PreparedStatement stmt;
		private ResultSet rs;
		
		//쿼리
		private static String USER_ALLSELECT = "select * from account";
		private static String USER_SELECT ="select * from account where id=?";
		private static String USER_INSERT ="insert into account (ID, PASSWORD, ROLE, NAME) values (?, ?, ?, ?)";
		private static String USER_UPDATE = "update account set id=?, password=?,role=?,name=? where id=?";
		private static String USER_DELETE = "delete from account where id=?";
		
		private static String CHANGE_PASSWORD = "update account set password=? where id=?";
		
		
		//회원정보 삭제
		public void deleteUser(AccountVO vo) {
			
			try {
				conn = DatabaseConnector.getConnection();
				stmt = conn.prepareStatement(USER_DELETE);
				System.out.println(vo.getId());
				
				stmt.setString(1, vo.getId());				
				stmt.executeUpdate();

				
			} catch (SQLException e) {
				DatabaseConnector.close(stmt, conn);
				
			}
			

		}
		

		//회원정보 수정
		public void updateUser(AccountVO vo, String stdid) {
			try {
				conn = DatabaseConnector.getConnection();
				stmt = conn.prepareStatement(USER_UPDATE);
				
				stmt.setString(1, vo.getId());
				stmt.setString(2, vo.getPassword());
				stmt.setString(3, vo.getRole());
				stmt.setString(4, vo.getName());
				stmt.setString(5, stdid);
				
				
				stmt.executeUpdate();
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				DatabaseConnector.close(stmt, conn);
			}
			
			System.out.println("수정 완료");
			
		}
		
		//전체 회원정보 가져오기
		public List<AccountVO> getAllUser() {
			List<AccountVO> list = new ArrayList<AccountVO>();
			try {
				conn = DatabaseConnector.getConnection();
				stmt = conn.prepareStatement(USER_ALLSELECT);
				
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					AccountVO vo = new AccountVO();
					
					vo.setId(rs.getString("id"));
					vo.setPassword(rs.getString("password"));
					vo.setRole(rs.getString("role"));
					vo.setName(rs.getString("name"));
					
					list.add(vo);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				DatabaseConnector.close(rs, stmt, conn);
			}

			return list;
			
		}
		
		
		//특정 회원정보 가져오기
		public AccountVO getUser(AccountVO vo) {
			AccountVO user = new AccountVO();
			
			try {
				conn = DatabaseConnector.getConnection();
				stmt = conn.prepareStatement(USER_SELECT);
				
				stmt.setString(1, vo.getId());
				rs = stmt.executeQuery();
								
				while(rs.next()) {
					user.setId(rs.getString("id"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));
					user.setName(rs.getString("name"));
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				DatabaseConnector.close(rs, stmt, conn);
			}
			

			return user;
	
		}


		//회원추가
		public void insertUser(AccountVO vo) {
			// TODO Auto-generated method stub
			
			try {
				conn = DatabaseConnector.getConnection();
				stmt = conn.prepareStatement(USER_INSERT);
				
				stmt.setString(1,vo.getId());
				stmt.setString(2, vo.getPassword());
				stmt.setString(3, vo.getRole());
				System.out.println(vo.getRole());
				stmt.setString(4, vo.getName());
				
				stmt.executeUpdate();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				DatabaseConnector.close(stmt, conn);
			}

		}

		
		//교수 + 학생 비밀번호 변경
		public void changePassword(AccountVO vo) {
			// TODO Auto-generated method stub
			
			try {
				conn = DatabaseConnector.getConnection();
				stmt = conn.prepareStatement(CHANGE_PASSWORD);
				
				stmt.setString(1, vo.getPassword());
				stmt.setString(2, vo.getId());
				
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				DatabaseConnector.close(stmt, conn);
			}
			
			
		}
}
