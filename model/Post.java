package post.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@Data
@DatabaseTable(tableName = "posts")
public class Post {

    @DatabaseField(columnName = "id", generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "title")
    private String title;

    @DatabaseField(columnName = "description")
    private String description;

    @DatabaseField(columnName = "date")
    private String date;

    @DatabaseField(columnName = "user_id")
    private Integer userId;

}
