package taskManagement.servlet;

import taskManagement.manager.CommentManager;
import taskManagement.manager.TaskManager;
import taskManagement.model.Comment;
import taskManagement.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/commentHome")
public class CommentHomeServlet extends HttpServlet {
    TaskManager taskManager = new TaskManager();
    CommentManager commentManager = new CommentManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("taskId"));
        List<Task> allTasks = taskManager.getAllTaskById(taskId);
        req.setAttribute("tasks", allTasks);
        List<Comment> allComment = commentManager.getAllCommentByTaskId(taskId);
        req.setAttribute("comments", allComment);
        req.getRequestDispatcher("/WEB-INF/comment.jsp").forward(req, resp);
    }
}
