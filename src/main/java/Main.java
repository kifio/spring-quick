import models.Comment;
import services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

class Main {

    private final static Random random = new Random();
    private final static int LEFT_LIMIT = 'a' - '0';
    private final static int RIGHT_LIMIT = 'z' - '0';

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var commentService = context.getBean(CommentService.class);

        System.out.println(commentService.getClass());

        for (int i = 0; i < 100; i++) {
            commentService.publishComment(
                    new Comment(
                            "Author " + i,
                            randomText(10 + random.nextInt(25)
                            )
                    )
            );
        }
    }

    private static String randomText(int length) {
        return random.ints(LEFT_LIMIT, RIGHT_LIMIT + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}