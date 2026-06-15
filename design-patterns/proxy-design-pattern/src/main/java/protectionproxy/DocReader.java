package protectionproxy;

public class DocReader implements IDocReader{

    private String password = "abcd@123";
    @Override
    public void unlockDoc(String username, String password) {
        if(this.password.equals(password)){
            System.out.println("Doc unlocked for user: " + username);
        }
    }
}
