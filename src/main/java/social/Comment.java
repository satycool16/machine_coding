package social;

public class Comment extends Item{

    Item parent;
    public Comment(int id, String text, User createdBy, Item parent) {
        super(id, text, createdBy, ItemType.Comment);
        this.parent = parent;

    }

}
