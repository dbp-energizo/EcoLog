package Controller;

import javax.servlet.http.HttpServletRequest;
import model.UserManager;

import javax.servlet.http.HttpServletResponse;

import domain.User;

public class RegisterUserController  implements Controller  {
	// private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       	if (request.getMethod().equals("GET")) {	
	    		// GET request: 회원정보 등록 form 요청	
	    		
				return "/user/registerForm.jsp"; 
		    }	

	    	// POST request (회원정보가 parameter로 전송됨)
	       User user = new User(
				request.getParameter("userId"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("phone"),
				request.getParameter("address"),
				request.getParameter("birth"),
				request.getParameter("nickname"));
			
			try {

				//매니저에서 .create()로 유저 생성.
		        return "redirect:/user/informaition";	// 성공 시 사용자 리스트 화면으로 redirect
		        
			} catch (Exception e) {	// 예외 발생 시 회원가입 form으로 forwarding
	            request.setAttribute("registerFailed", true);
				request.setAttribute("exception", e);
				request.setAttribute("user", user);
				return "/user/registerForm.jsp";
			}
	    }
}
