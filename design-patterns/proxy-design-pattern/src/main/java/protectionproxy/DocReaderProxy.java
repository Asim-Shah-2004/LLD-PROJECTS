package protectionproxy;

import protectionproxy.models.User;

public class DocReaderProxy implements IDocReader{
    private User user;
    private DocReader docReader;
    public DocReaderProxy(User user){
        this.user = user;
        this.docReader = new DocReader();
    }
    @Override
    public void unlockDoc(String username, String password) {
        if(user.isPremium()){
            docReader.unlockDoc(user.getUsername(), password);
        }else{
            System.out.println("User is not premium");
        }
    }
}
