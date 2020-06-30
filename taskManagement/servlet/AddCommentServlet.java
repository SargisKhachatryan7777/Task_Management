package taskManagement.servlet;

import taskManagement.manager.CommentManager;
import taskManagement.model.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/addComment")
public class AddCommentServlet extends HttpServlet {

    CommentManager commentManager = new CommentManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("taskId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        String userName = req.getParameter("userName");
        String comment = req.getParameter("comment");
            commentManager.addComment(Comment.builder()
                    .taskId(taskId)
                    .userId(userId)
                    .userBy(userName)
                    .comment(comment)
                    .date(new Date())
                    .userId(userId)
                    .build());
        resp.sendRedirect("/commentHome?taskId=" + taskId);
        }
}