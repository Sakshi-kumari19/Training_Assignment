package DigtalCom;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static ArrayList<Game> games; //this is static so initilaise in static, can be done is const but do in static ,good practice
    //static block - always executes 1st and only one time
    static{
        games = new ArrayList<Game>();
        games.add(new Game("SnowBird","Danny",300));
        games.add(new Game("FreshFood","Ram",450));
        games.add(new Game("Batsman","Kate",400));
        games.add(new Game("Pokiman","Steeve",600));
        games.add(new Game("YammyTommy","Narayan",350));
    }


    public List<Game> ViewAll(){
        return games;
    }
    public String authorSearch(String author){
          for(Game gm :games){
              if((gm.getAuthorName()).equals(author)){
                  return gm.getGameName();
              }
          }
          return "NOT Found";
    }
}
