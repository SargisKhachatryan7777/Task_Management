package taskManagement.servlet;

import taskManagement.manager.UserManager;
import taskManagement.model.User;
import taskManagement.model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/userRegister")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UserRegisterServlet extends HttpServlet {

    UserManager userManager=new UserManager();
    private final String UPLOAD_DIR = "C:\\Users\\Admin\\IdeaProjects\\FullStack20\\Task\\upload";
    User user=new User();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        String type=req.getParameter("type");
        String image=req.getParameter("image");
        userManager.addUser(User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .userType(UserType.valueOf(type))
                .image(image)
                .build());
        for (Part part : req.getParts()) {
            if (image.equals("")) {
                String fileName = System.currentTimeMillis() + getFileName(part);
                String fullFileName = UPLOAD_DIR + File.separator + fileName;
                part.write(fullFileName);
                user.setImage(fileName);
            }
        }
        resp.sendRedirect("/managerHome");
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return null;
    }
}