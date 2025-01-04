package proxies;

import models.Comment;

public interface CommentNotificationProxy {
    void sendNotification(Comment comment);
}
