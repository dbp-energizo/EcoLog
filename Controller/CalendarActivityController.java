package Controller;

import domain.User;

public class CalendarActivityController {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       	if (request.getMethod().equals("GET")) {	
	    		// GET request: 	
	       	  request.setAttribute("ActivityList",  List<Calendar>); //Ķ���� �����ͼ� ����Ʈ ����.
	       	  //request.setAttribute("date", date); //��¥�� �����ؾ� �ɵ� �ѵ�...?
				return "/main/calendar.jsp"; 
		    }	
	    }
}
