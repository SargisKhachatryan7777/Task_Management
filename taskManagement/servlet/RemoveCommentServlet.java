package taskManagement.servlet;


import taskManagement.manager.CommentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removeComment")
public class RemoveCommentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int commentId = Integer.parseInt(req.getParameter("commentId"));
        int taskId = Integer.parseInt(req.getParameter("taskId"));
        CommentManager commentManager = new CommentManager();
        commentManager.deleteCommentById(commentId);
        resp.sendRedirect("/commentHome?taskId=" + taskId);
        }
    }