package DigtalCom;
//whenever we create paraemetrised const always create default const.
public class Game {
    private String gameName;
    private String authorName;
    private float price;

    public String getAuthorName() {
        return authorName;
    }

    Game(){}
    public float getPrice() {
        return price;
    }

    public String getGameName() {
        return gameName;
    }



    Game(String gameName, String authorName, float price){
        this.gameName = gameName;
        this.authorName = authorName;
        this.price = price;
    }
    public String toString(){
        return gameName+"\t"+authorName+"\t"+price;
    }
}
