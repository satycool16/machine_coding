package social;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Item {
    int id;
    String text;
    Date createdAt;
    User createdBy;

    List<Item> child;
    int upvotes;
    int downvotes;
    ItemType type;

    public Item(int id, String text, User createdBy, ItemType type) {
        this.id = id;
        this.text = text;
        this.createdBy = createdBy;
        this.createdAt = new Date();
        this.child = new ArrayList<>();
        this.upvotes = 0;
        this.downvotes = 0;
        this.type = type;
    }

    public boolean addChild(Item item){
        return child.add(item);
    }

    public int upvote(){
        return ++upvotes;
    }

    public int downvote(){
        return ++downvotes;
    }

    public String toString(String prefix) {
        List<String> comments =
                child.stream()
                .map(item ->item.toString(prefix+ "\t"))
                .collect(Collectors.toList());
        return
                prefix + "id:" + id + "\t" + "\t" + "(" + upvotes + " upvotes, " + downvotes + " downvotes)"+ "\n"+
                prefix +text +" - " + createdBy + " "+ type.toString().toLowerCase() + "ed" + "\n"+
                prefix + createdAt + "\n" +
                        child.stream()
                                .map(item ->item.toString(prefix+ "\t"))
                                .collect(Collectors.joining("\n"));

    }
}
