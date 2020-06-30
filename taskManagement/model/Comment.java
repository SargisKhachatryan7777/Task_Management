package taskManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private int id;
    private int taskId;
    private int userId;
    private String userBy;
    private String comment;
    private Date date;




}
