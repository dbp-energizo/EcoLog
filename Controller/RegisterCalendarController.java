package Controller;

import domain.User;

public class RegisterCalendarController {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       	if (request.getMethod().equals("GET")) {	
	    		// GET request: 회원정보 등록 form 요청	
	    		
				return "/user/registerForm.jsp"; 
		    }	

	    	// POST request (회원정보가 parameter로 전송됨)
	       User user = new User(
				request.getParameter("activity"), //활동 리스트 저장해서 가져옴
				request.getParameter("userId"),
				request.getParameter("year"),
				request.getParameter("month"),
				request.getParameter("day"),
				request.getParameter("totalPoint"));
			 
	       //**성공시, 실패시 다르게 변경해야 함.
			try {
				//DB에 저장
		        return "redirect://main/calcular.jsp";	// 성공 시 
		        
			} catch (Exception e) {	// 예외 발생 시 회원가입 form으로 forwarding
	            request.setAttribute("registerFailed", true);
				request.setAttribute("exception", e);
				request.setAttribute("user", user);
				return "/main/calcular.jsp";
			}
	    }
}
