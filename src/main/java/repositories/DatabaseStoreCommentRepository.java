package repositories;

import models.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseStoreCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println(comment + " ✅");
    }
}
