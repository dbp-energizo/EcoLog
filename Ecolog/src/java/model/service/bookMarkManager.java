package model;

import java.sql.SQLException;
import java.util.List;

import model.BookMark;

public class bookMarkManager {
	private static bookMarkManager bmMan = new bookMarkManager();
	private bookMarkDAO bmDao;

	private bookMarkManager() {
		try {
			bmDao = new bookMarkDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static bookMarkManager getInstance() {
		return bmMan;
	}
	
    public int create(BookMark bm) throws SQLException {
//        if (bmDao.existingUser(bm.getUserId()) == true) {
//            throw new ExistingBookMarkException(user.getUserId() + "는 존재하는 아이디입니다.");
//        }
        return bmDao.create(bm);
    }

	public int getBookMarkNum(String userId) {
		return bmDao.getNumberOfBookMark(userId);
	}

	public bookMarkDAO getbmDao() {
		return this.bmDao;
	}
	
   public List<BookMark> findBookMarkList(String userId) throws SQLException {               
        return bmDao.findBookMarkList(userId);
    }


   public int deleteStudent(String postNum) throws SQLException {         
       return bmDao.remove(postNum);
  }
   
//   public int existingNickname(BookMark user) throws SQLException {  
//       if (bmDao.existingUser(user.getNickname()) == true) {
//           throw new ExistingUserException(user.getNickname() + "는 존재하는 닉네임입니다.");
//       }
//    return 0;
//  }
}
