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
	    		// GET request: ȸ������ ��� form ��û	
	    		
				return "/user/registerForm.jsp"; 
		    }	

	    	// POST request (ȸ�������� parameter�� ���۵�)
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

				//�Ŵ������� .create()�� ���� ����.
		        return "redirect:/user/informaition";	// ���� �� ����� ����Ʈ ȭ������ redirect
		        
			} catch (Exception e) {	// ���� �߻� �� ȸ������ form���� forwarding
	            request.setAttribute("registerFailed", true);
				request.setAttribute("exception", e);
				request.setAttribute("user", user);
				return "/user/registerForm.jsp";
			}
	    }
}
