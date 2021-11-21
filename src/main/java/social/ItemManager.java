package social;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemManager {
    Map<Integer, Item> itemMap;
    UserManager userManager;
    int itemCount;

    public ItemManager() {
        itemMap = new HashMap<>();
        userManager = UserManager.getInstance();
        itemCount = 0;
    }

    public Item addPost(String text){
        Post newPost = new Post(++itemCount, text, userManager.getLoggedInUser());
        itemMap.put(newPost.id, newPost);
        return getItem(newPost.id);
    }

    public Item getItem(int id){
        return itemMap.get(id);
    }

    public Item addComment(String text, int parentId){
        Item parent = itemMap.get(parentId);
        Comment newComment = new Comment(++itemCount, text, userManager.getLoggedInUser(), parent);
        itemMap.put(newComment.id, newComment);
        parent.addChild(newComment);
        return newComment;
    }

    public int upvote(int id){
        return itemMap.get(id).upvote();
    }

    public int downvote(int id){
        return itemMap.get(id).downvote();
    }

    private List<Item> getFeedItems(){
        Set<User> following = userManager.getLoggedInUser().following;
        return itemMap
                .values()
                .stream()
                .filter(item -> following.contains(item.createdBy) && item.type == ItemType.Post)
                .map(item -> (Post) item)
                .collect(Collectors.toList());


    }

    public void showFeed(){
        List<Item> feedItems =  getFeedItems();
        feedItems.forEach(item -> System.out.println(item.toString("")));
    }
}
