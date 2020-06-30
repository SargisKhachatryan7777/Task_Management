package taskManagement.manager;

import taskManagement.db.DBConnectionProvider;
import taskManagement.model.Comment;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CommentManager {

    private Connection connection;
    public CommentManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void addComment(Comment comment) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT  INTO comment(task_id,user_id,user_by,comment,date) Values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, comment.getTaskId());
            preparedStatement.setInt(2, comment.getUserId());
            preparedStatement.setString(3, comment.getUserBy());
            preparedStatement.setString(4, comment.getComment());
            preparedStatement.setString(5, sdf.format(new Date()));
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                comment.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Comment> getAllCommentByTaskId(int taskId) {
        PreparedStatement statement = null;
        List<Comment> comments = new LinkedList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM comment WHERE task_id = ? ");

            statement.setInt(1, taskId);
            ResultSet resultSet = statement.executeQuery();
            comments = getCommentFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }



    private List<Comment> getCommentFromResultSet(ResultSet resultSet) throws SQLException {
        List<Comment> comments = new LinkedList<>();
        while (resultSet.next()) {
            Comment comment = new Comment();
            comment.setId(resultSet.getInt("id"));
            comment.setTaskId(resultSet.getInt("task_id"));
            comment.setUserId(resultSet.getInt("user_id"));
            comment.setUserBy(resultSet.getString("user_by"));
            comment.setComment(resultSet.getString("comment"));
            try {
                comment.setDate(sdf.parse(resultSet.getString("date")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            comments.add(comment);
        }
        return comments;
    }
    public void deleteCommentById(int id) {
        try {
            PreparedStatement   preparedStatement = connection.prepareStatement("DELETE FROM comment WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}