package controller.post;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;	
import model.service.UserManager;
import model.Post;
import model.service.PostManager;

public class DeletePostController  implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DeletePostController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String postNo = request.getParameter("postNo");	//postNo�޾ƿͼ� ����
		log.debug("Delete Post : {}", postNo);

		PostManager pmanager = PostManager.getInstance();		//post
		UserManager umanager = UserManager.getInstance();		//user
		HttpSession session = request.getSession();

		if ((UserSessionUtils.isLoginUser("admin", session) && 	// �α����� ����ڰ� �������̰� 	
				|| 												// �Ǵ� 
				(!UserSessionUtils.isLoginUser("admin", session) &&  // �α����� ����ڰ� �����ڰ� �ƴϰ� 
						){ //post ??? { // ������ �� ���� ��� -->��� ����?
			manager.delete(postNo);				// �Խñ� ����
		
			return "/post/list.jsp";
		} 


		/* ������ �Ұ����� ��� */
		Post post = pmanager.findPost(postNo);	// �Խñ� �˻�
		request.setAttribute("writer", writer);						
		request.setAttribute("deleteFailed", true);
		String msg = "���� �� ���� �ƴմϴ�.";				

		request.setAttribute("exception", new IllegalStateException(msg));            
		return "/post/deletePost.jsp";		// ���� ȭ������ �̵� (forwarding)	
	}
}
