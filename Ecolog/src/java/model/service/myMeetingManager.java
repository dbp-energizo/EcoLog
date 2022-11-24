package model;

import java.sql.SQLException;
import java.util.List;

import model.MyMeeting;

public class myMeetingManager {
	private static myMeetingManager mtMan = new myMeetingManager();
	private MyMeetingDAO mtDao;

	private myMeetingManager() {
		try {
			mtDao = new MyMeetingDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static myMeetingManager getInstance() {
		return mtMan;
	}
	
    public int create(MyMeeting mt) throws SQLException {
//        if (mtDao.existingUser(bm.getUserId()) == true) {
//            throw new ExistingBookMarkException(user.getUserId() + "는 존재하는 아이디입니다.");
//        }
        return mtDao.create(mt);
    }

	public int getBookMarkNum(String userId) {
		return mtDao.getNumberOfMyMt(userId);
	}

	public MyMeetingDAO getmtDao() {
		return this.mtDao;
	}
	
   public List<MyMeeting> findBookMarkList(String userId) throws SQLException {               
        return mtDao.findMyMtList(userId);
    }


   public int deleteStudent(String postNum) throws SQLException {         
       return mtDao.remove(postNum);
  }
   
//   public int existingNickname(BookMark user) throws SQLException {  
//       if (mtDao.existingUser(user.getNickname()) == true) {
//           throw new ExistingUserException(user.getNickname() + "는 존재하는 닉네임입니다.");
//       }
//    return 0;
//  }
}
