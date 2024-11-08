package com.scoremanagementprogram.dbutil.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.scoremanagementprogram.dbutil.account.AccountVO;
import com.scoremanagementprogram.dbutil.common.DatabaseConnector;

public class SubjectDAO {

	private static String GET_ALLSUBJECT = "select * from subject ORDER BY UV_YEAR ASC, SEMESTER ASC, SUBJECT_NAME ASC, ID ASC";
	private static String GET_SUBJECT = "select * from subject where id=? and subject_name=?";
	private static String DELETE_SUBJECT = "delete from subject where id=? and subject_name=?";
	private static String INSERT_SUBJECT = "insert into subject (ID, UV_YEAR, SEMESTER, COURSE, SUBJECT_NAME, CREDIT, PROFESSOR, SCORE) values (?, ?, ?, ?, ?, ?, ?, ?)";
	
	//관리자 전용 학생 성적 수정
	private static String UPDATE_SUBJECT ="update subject set ID=?, UV_YEAR=?, SEMESTER=?, COURSE=?, SUBJECT_NAME=?, CREDIT=?, PROFESSOR=?, SCORE=? where id=?";
	
	//관리자 학생 성적 검색 /중복된 수강신청에 대한 예외처리에도 사용됨.
	private static String GET_STDIDSUBJECT ="select * from subject where id=?";
	
	// 수강가능 학점 18점에 대한 예외처리를 위해서도 사용함.
	private static String GET_STDIDSUBJECT2 ="select * from subject where id=? and UV_YEAR=? and SEMESTER=? ";
	
	//교수전용 학생 성적 수정
	private static String PROF_UPDATE_SUBJECT= "update subject set score=? where id=?";
	
	//교수전용 학생 성적 검색
	private static String GET_PROFSTDIDSUBJECT ="select * from subject where id=? and professor=?";
	
	//학생 전용 성적 조회
	private static String GET_STUDENTSUBJECT= "select * from subject where id=?";
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs; 
	
	
	
	
	
	//관리자 전용 학생 검색
	public List<SubjectVO> getStdIdSubject(SubjectVO vo) {
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		
		
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(GET_STDIDSUBJECT);
			
			stmt.setString(1, vo.getId());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				SubjectVO subject = new SubjectVO();
				
				subject.setId(rs.getString("ID"));
				subject.setYear(rs.getString("UV_YEAR"));
				subject.setSemester(rs.getString("SEMESTER"));
				subject.setCourse(rs.getString("COURSE"));	
				subject.setSubjectName(rs.getString("SUBJECT_NAME"));
				subject.setCredit(rs.getString("CREDIT"));
				subject.setProfessor(rs.getString("PROFESSOR"));
				subject.setScore(rs.getString("SCORE"));
				
				list.add(subject);
				
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
			DatabaseConnector.close(rs, stmt, conn);
			
		}
		
		
		return list;
		
		
	}
	
	
	//교수 전용 학생 검색
		public List<SubjectVO> getProfStdIdSubject(SubjectVO vo, AccountVO user) {
			List<SubjectVO> list = new ArrayList<SubjectVO>();
			// 세션정보도 같이 받아서 해야할듯. 교수에 맞는 수업만 조회하게끔
			
			try {
				conn = DatabaseConnector.getConnection();
				stmt = conn.prepareStatement(GET_STDIDSUBJECT);
				
				stmt.setString(1, vo.getId());
				stmt.setString(2, user.getId());
				
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					SubjectVO subject = new SubjectVO();
					
					subject.setId(rs.getString("ID"));
					subject.setYear(rs.getString("UV_YEAR"));
					subject.setSemester(rs.getString("SEMESTER"));
					subject.setCourse(rs.getString("COURSE"));	
					subject.setSubjectName(rs.getString("SUBJECT_NAME"));
					subject.setCredit(rs.getString("CREDIT"));
					subject.setProfessor(rs.getString("PROFESSOR"));
					subject.setScore(rs.getString("SCORE"));
					
					list.add(subject);
					
				}

				
			} catch (SQLException e) {
				e.printStackTrace();
				DatabaseConnector.close(rs, stmt, conn);
				
			}
			
			return list;
			
			
		}	
	

	
	public List<SubjectVO> getAllSubject() {
		
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(GET_ALLSUBJECT);
			
			rs = stmt.executeQuery();

			while(rs.next()) {
				SubjectVO subject = new SubjectVO();
				
				subject.setId(rs.getString("ID"));
				subject.setYear(rs.getString("UV_YEAR"));
				subject.setSemester(rs.getString("SEMESTER"));
				subject.setCourse(rs.getString("COURSE"));	
				subject.setSubjectName(rs.getString("SUBJECT_NAME"));
				subject.setCredit(rs.getString("CREDIT"));
				subject.setProfessor(rs.getString("PROFESSOR"));
				subject.setScore(rs.getString("SCORE"));
				
				list.add(subject);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			DatabaseConnector.close(rs, stmt, conn);
		}

		
		return list;
		
	}
	
	public SubjectVO getSubject(SubjectVO vo) {
		SubjectVO user = new SubjectVO();
		try {
			
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(GET_SUBJECT);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getSubjectName());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				user.setId(rs.getString("ID"));
				user.setYear(rs.getString("UV_YEAR"));
				user.setSemester(rs.getString("SEMESTER"));
				user.setCourse(rs.getString("COURSE"));
				user.setSubjectName(rs.getString("SUBJECT_NAME"));
				user.setCredit(rs.getString("CREDIT"));
				user.setProfessor(rs.getString("PROFESSOR"));
				user.setScore(rs.getString("SCORE"));
	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DatabaseConnector.close(rs, stmt, conn);
			
			
		}
		
		
		return user;
	}
	//관리자 학생 성적 삭제
	public void deleteSubject(SubjectVO vo)  {
		// TODO Auto-generated method stub
		
		
		
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(DELETE_SUBJECT);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getSubjectName());
			System.out.println(vo.getSubjectName() + "!!!");
			stmt.executeUpdate();
			//수정 필요 학번에 해당하는 전체과목이 삭제됨.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DatabaseConnector.close(stmt, conn);
			}				
	}

	
	public void insertSubject(SubjectVO vo) {
		// TODO Auto-generated method stub
		
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(INSERT_SUBJECT);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getYear());
			stmt.setString(3, vo.getSemester());
			stmt.setString(4, vo.getCourse());
			stmt.setString(5, vo.getSubjectName());
			stmt.setString(6, vo.getCredit());
			stmt.setString(7, vo.getProfessor());
			stmt.setString(8, vo.getScore());
			
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DatabaseConnector.close(stmt, conn);
		}
		
	}
	
	
	
	
	
	
	
	
	
	

	//교수 전용 학생 성적 수정
	public void updateProfStdSubject(SubjectVO vo) {
		
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(PROF_UPDATE_SUBJECT);
			
			stmt.setString(1, vo.getScore());
			stmt.setString(2, vo.getId());
			
			stmt.executeUpdate();
			
		} 
		
		catch (SQLException e) {
			DatabaseConnector.close(stmt, conn);
		}
		
		
	}
	//관리자 전용 학생 성적 정보 수정
	public void updateSubject(SubjectVO vo, String stdid) {
		// TODO Auto-generated method stub
		
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(UPDATE_SUBJECT);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getYear());
			stmt.setString(3, vo.getSemester());
			stmt.setString(4, vo.getCourse());
			stmt.setString(5, vo.getSubjectName());
			stmt.setString(6, vo.getCredit());
			stmt.setString(7, vo.getProfessor());
			stmt.setString(8, vo.getScore());
			stmt.setString(9, stdid);
			
			stmt.executeUpdate();			
			
		} 
		
		catch (SQLException e) {
			DatabaseConnector.close(stmt, conn);
			e.printStackTrace();
		}
		
	}
	
	//학생 전용 성적 조회
	public List<SubjectVO> getStudentSubject(AccountVO user) {
		// TODO Auto-generated method stub
		
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		
		
		String id = user.getId();
		
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(GET_STUDENTSUBJECT);

			stmt.setString(1, id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				SubjectVO subject = new SubjectVO();
				
				subject.setId(rs.getString("ID"));
				subject.setYear(rs.getString("UV_YEAR"));
				subject.setSemester(rs.getString("SEMESTER"));
				subject.setCourse(rs.getString("COURSE"));	
				subject.setSubjectName(rs.getString("SUBJECT_NAME"));
				subject.setCredit(rs.getString("CREDIT"));
				subject.setProfessor(rs.getString("PROFESSOR"));
				subject.setScore(rs.getString("SCORE"));
				
				list.add(subject);
								
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DatabaseConnector.close(rs, stmt, conn);
		}
		
		
		
		return list;
	}
	//관리자
	//총 수강 가능한 학점 18점에 대한 예외처리를 위한 메소드
	public int getCountStdCredit(SubjectVO vo) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(GET_STDIDSUBJECT2);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getYear());
			stmt.setString(3, vo.getSemester());
			
			rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				String credit = rs.getString("credit");
				count +=  Integer.parseInt(credit.trim());
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DatabaseConnector.close(rs, stmt, conn);
			e.printStackTrace();
		}
		
		return count;
		
	}

	//관리자 전용 추가하려는 수업이 db에 있는 지 확인하기 위한 메소드
	public int getSubjectName(SubjectVO vo) {
		// TODO Auto-generated method stub
		
		int flag=-1;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(GET_STDIDSUBJECT);
			
			stmt.setString(1, vo.getId());
			
			rs = stmt.executeQuery();

			while(rs.next()) {
				if(vo.getSubjectName().equals(rs.getString("SUBJECT_NAME")) ) {
					flag = 1; //추가하려는 과목은 기존에 저장되어 있는 과목임.
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DatabaseConnector.close(rs, stmt, conn);
			e.printStackTrace();
		}
		
		return flag;
	}

}
