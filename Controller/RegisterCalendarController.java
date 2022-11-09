package Controller;

import domain.User;

public class RegisterCalendarController {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	       	if (request.getMethod().equals("GET")) {	
	    		// GET request: ȸ������ ��� form ��û	
	    		
				return "/user/registerForm.jsp"; 
		    }	

	    	// POST request (ȸ�������� parameter�� ���۵�)
	       User user = new User(
				request.getParameter("activity"), //Ȱ�� ����Ʈ �����ؼ� ������
				request.getParameter("userId"),
				request.getParameter("year"),
				request.getParameter("month"),
				request.getParameter("day"),
				request.getParameter("totalPoint"));
			 
	       //**������, ���н� �ٸ��� �����ؾ� ��.
			try {
				//DB�� ����
		        return "redirect://main/calcular.jsp";	// ���� �� 
		        
			} catch (Exception e) {	// ���� �߻� �� ȸ������ form���� forwarding
	            request.setAttribute("registerFailed", true);
				request.setAttribute("exception", e);
				request.setAttribute("user", user);
				return "/main/calcular.jsp";
			}
	    }
}
