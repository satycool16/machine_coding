package social;

public class MainClass {
    public static void main(String[] args) throws Exception{
        UserManager userManager = UserManager.getInstance();
        ItemManager itemManager = new ItemManager();

        userManager.signup("lucious");
        userManager.signup("albus");
        userManager.signup("tom");
        userManager.login("tom");
        itemManager.addPost("I am going to be the darkest dark wizard of all time");
        itemManager.addPost("I am lord voldermort btw 3:");
        userManager.login("lucious");
        userManager.follow("tom");
        itemManager.upvote(1);
        itemManager.addComment("Nice bro!!", 1);
        userManager.login("albus");
        itemManager.addComment("what's nice in that lucious?", 3);
        itemManager.downvote( 3);
        itemManager.addComment("Be like HP instead", 1);
        itemManager.downvote( 1);

        userManager.login("lucious");
        itemManager.showFeed();


    }
}
