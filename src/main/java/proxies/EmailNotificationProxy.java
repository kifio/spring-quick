package proxies;

import models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("EMAIL")
@Component
public class EmailNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendNotification(Comment comment) {
        System.out.printf("e-mail {%s написал: %s}\n", comment.getAuthor(), comment.getText());
    }
}
