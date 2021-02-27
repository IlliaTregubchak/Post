import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import post.model.Comment;
import post.model.Post;
import post.model.User;
import post.service.CommentService;
import post.service.UserService;
import post.service.impl.CommentServiceImpl;
import post.service.impl.PostServiceImpl;
import post.service.impl.UserServiceImpl;

import java.lang.reflect.Field;
import java.util.List;

//public class Main {
//    public static void main(String[] args) {
//        final Class<User> clazz = User.class;
//
//        final StringBuilder builder = new StringBuilder();
//
//        final boolean present = clazz.isAnnotationPresent(DatabaseTable.class);
//        if (present) {
//            final DatabaseTable annotation = clazz.getAnnotation(DatabaseTable.class);
//            builder.append("Insert into " + annotation.tableName());
//        } else {
//            System.out.println("Annotation DatabaseTable is not specified");
//        }
//
//        builder.append("(");
//        final Field[] fields = clazz.getDeclaredFields();
//        for (Field elem : fields) {
//            final boolean annotationPresent = elem.isAnnotationPresent(DatabaseField.class);
//            if (annotationPresent) {
//                final DatabaseField annotation = elem.getAnnotation(DatabaseField.class);
//                builder.append(annotation.columnName()).append(",");
//            }
//        }
//        builder.append(") values (");
//
//        System.out.println(builder.toString());

//        final UserService userService = new UserServiceImpl();
//        final User user = new User();
//        user.setId(3);
//        user.setName("John");
//        user.setPosition("Head Hunter");
//        userService.save(user);

//        final List<User> users = userService.findAll();
//        for (User elem : users) {
//            System.out.println(elem.toString());
//        }

        //----------------------------------------------------------------

//        final PostServiceImpl postService = new PostServiceImpl();
//        final Post post = new Post();

//        post.setUserId(12);
//        post.setTitle("Thomas Mann");
//        post.setDate("2020-08-20");
//        post.setDescription("Who is Thomas Mann?");
//        postService.save(post);

//        final List<Post> posts = postService.findAll();
//        for (Post elem : posts) {
//            System.out.println(elem.toString());
//        }

//        final List<Post> posts = postService.findAllByUserId(1);
//        for (Post elem : posts) {
//            System.out.println(elem.toString());
//        }

//        final Post post2 = postService.findById(1);
//        System.out.println(post2);

        //---------------------------------------------------------------

//        '; delete * from users;
        // insert into users() valie

        // select * users where name = ''; delete * from users;

//        final CommentService commentService = new CommentServiceImpl();
//        final Comment comment = new Comment();
//        comment.setUserId(2);
//        comment.setPostId(null);
//        comment.setText("ABC is the best TV channel");
//        comment.setDate("2020-08-22");
//        commentService.save(comment);

//        final List<Comment> comments = commentService.findAllByPostId(23);
//        for (Comment elem : comments) {
//            System.out.println(elem.toString());
//        }

//    }
//}
