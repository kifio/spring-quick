package proxies;

import models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("PUSH")
@Component
public class PushNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendNotification(Comment comment) {
        System.out.printf("push {%s написал: %s}\n", comment.getAuthor(), comment.getText());
    }
}
