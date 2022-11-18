package controller.post;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;	//�α��� Ȯ���� ����
import model.Post;
import model.service.PostManager;

public class CreatePostController implements Controller {
	 private static final Logger log = LoggerFactory.getLogger(CreatePostController.class);
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/registerForm";		// login form ��û���� redirect
        }
    	
    	// userList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
    	request.setAttribute("userList", userList);				
    	request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));	
    	
    	Post post = new Post(
				request.getParameter("category"),
				request.getParameter("title"),
				request.getParameter("text"),
				request.getParameter("file"));
    	
    	log.debug("Create Post : {}", post);
    	
    	try {
			PostManager manager = PostManager.getInstance();
			manager.create(post);
	        return "redirect:/post/list";		// ���� �� �Խñ� ����Ʈ ȭ������ redirect
	        
		} catch (ExistingPostException e) {		// ���� �߻� �� ȸ������ form���� forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("post", post);
			return "/user/registerForm.jsp";		
		}
	}
}