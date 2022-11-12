package controller.post;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;	
import model.Post;
import model.service.PostManager;

public class UpdatePostController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdatePostController.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		if (request.getMethod().equals("GET")) {	
			String updatePost = request.getParameter("postNo");

			log.debug("Post Update : {}", postNo);

			PostManager manager = PostManager.getInstance();
			Post post = manager.findPost(updatePost);	// �����Ϸ��� �Խñ� �˻�
			request.setAttribute("user", user);			

			HttpSession session = request.getSession();
			if (//userSession���� postSession���� �� / post�� writer�� ���)
					{
						return "/post/list.jsp";       
					}    
					//�ݴ�� �ƴѰ�� else Ÿ���� �� ���� ������ �� �����ϴ� 
		}

		//POST��� | ������Ʈ�� �Խù� ���� ����
		Post updatePost = new Post(
				request.getParameter("category"),
				request.getParameter("title"),
				request.getParameter("text"),
				request.getParameter("file"));
		
		log.debug("Post Update : {}", postNo);
		PostManager manager = UserManager.getInstance();
		manager.update(updatePost);
		
		return "redirect:/post/list";
	}
}
