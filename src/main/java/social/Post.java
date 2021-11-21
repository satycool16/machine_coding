package social;

import java.util.Date;
import java.util.List;

public class Post extends Item{
    public Post(int id, String text, User createdBy) {
        super(id, text, createdBy, ItemType.Post);
    }
}
