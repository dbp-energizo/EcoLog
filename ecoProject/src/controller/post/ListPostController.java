package controller.post;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controller.Controller;
import model.Post;
import model.service.PostManager;

public class ListPostController implements Controller {
		
	    PostManager manager = PostManager.getInstance();
	    List<Post> postList = manager.findPostList();
	    
	    //�Խñ� ����Ʈ ȭ������ �̵�(forwarding)
	    return "/post/list.jsp";
	 }
}
