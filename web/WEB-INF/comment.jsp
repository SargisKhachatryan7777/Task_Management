<%@ page import="taskManagement.model.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="taskManagement.model.User" %>
<%@ page import="taskManagement.model.Task" %>
<%@ page import="java.util.Date" %>
<%@ page import="taskManagement.manager.TaskManager" %>
<%@ page import="taskManagement.model.UserType" %>
<%--Created by IntelliJ IDEA.
  User: Admin
  Date: 25.06.2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/commentStyle.css">
</head>
<body>


<%User user= (User) session.getAttribute("user");%>

<%List<Comment> comments= (List<Comment>) request.getAttribute("comments");%>
<%List<Task> tasks= (List<Task>) request.getAttribute("tasks");%>

<%
    for (Task task : tasks) {%>
Name : <%=task.getName()%><br>
Status : <%=task.getTaskStatus()%><br>
Description : <%=task.getDescription()%><br>
Deadline : <%=task.getDeadline()%><br><br>
<%}%>
add Comment<br><br>
<div>
    <form action="/addComment" method="post">
<%
    for (Task task : tasks) {%>
        <input type="hidden" name="taskId" value="<%=task.getId()%>">
        <input type="hidden" name="userId" value="<%=user.getId()%>">
        <%}%>
        <input type=hidden name="userName" value="<%=user.getName()%>">

        <textarea style="width: 250px;height: 150px;" placeholder="Comment" name="comment"></textarea><br><br>
        <input type="submit" class="button" name="comment">
    </form>

</div>
<br>
    <%for (Comment  comment : comments) {%>
<div class="user"><%=comment.getUserBy()%> by  :</div>
<div class="comment"><%=comment.getComment()%></div>
<div class="date"><%=comment.getDate()%></div>
<%if ((user.getUserType()== UserType.USER && user.getName().equals(comment.getUserBy())) || (user.getUserType()==UserType.MANAGER)){%>
<a href="/removeComment?commentId=<%=comment.getId()%>&taskId=<%=comment.getTaskId()%>"><button class="button" >Remove</button></a>
<%}%><br><br>
<%}%>

</body>
</html>