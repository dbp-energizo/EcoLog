package Controller;

import domain.User;

public class CalendarActivityController {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       	if (request.getMethod().equals("GET")) {	
	    		// GET request: 	
	       	  request.setAttribute("ActivityList",  List<Calendar>); //캘린더 가져와서 리스트 저장.
	       	  //request.setAttribute("date", date); //날짜도 저장해야 될듯 한데...?
				return "/main/calendar.jsp"; 
		    }	
	    }
}
