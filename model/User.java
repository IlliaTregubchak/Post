package post.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

@Data
@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(columnName = "id", generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "position")
    private String position;

//    dao
//    User
//    select + from ?
//    insert into ? (name) value (?)
    // 1 ? - tableName
    // 2 ? - getName
}
