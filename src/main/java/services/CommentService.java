package services;

import models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(
            CommentService.class.getName()
    );

    @ToLog
    public boolean publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return true;
    }
}