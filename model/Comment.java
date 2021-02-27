package post.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@Data
@DatabaseTable(tableName = "comments")
public class Comment {

    // не включай це поле в SQL-запит insert into...
    // за замовчуванням вже стоїть false
    @DatabaseField(columnName = "id", generatedId = true)
    private Integer id;

    // insert into comments(text, ...)

    @DatabaseField(columnName = "text")
    private String text;

    @DatabaseField(columnName = "date")
    private String date;

    @DatabaseField(columnName = "user_id")
    private Integer userId;

    @DatabaseField(columnName = "post_id")
    private Integer postId;


}
