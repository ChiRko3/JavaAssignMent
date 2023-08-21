import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Ladders{
    HashMap<Integer,Integer> laddersMapping = new HashMap<>();
    Ladders (){
        laddersMapping.put(30,56);
        laddersMapping.put(14,55);
        laddersMapping.put(22,56);
        laddersMapping.put(44,70);
    }
}
class Snakes{
    HashMap<Integer,Integer> snakesMapping = new HashMap<>();
    Snakes (){
        snakesMapping.put(37,3);
        snakesMapping.put(47,16);
        snakesMapping.put(28,10);
        snakesMapping.put(96,42);
        snakesMapping.put(75,32);
    }
}
class Player{
    Integer Tile = 0;
    Snakes S = new Snakes();
    Ladders L = new Ladders();
    public Integer genRand(){
        return (int)(Math.random()*(6 - 1 + 1) + 1);
    }
    public int Turn(){
        Integer increMentTile = genRand();
        System.out.println("Dice throw = " + increMentTile);
        Integer newDes = this.Tile + increMentTile;
        if(S.snakesMapping.containsKey(newDes)){
            System.out.println("Aw, Bit By Snake");
            this.Tile = S.snakesMapping.get(newDes);
        }
        else if(L.laddersMapping.containsKey(newDes)){
            System.out.println("Ah, a ladder");
            this.Tile = L.laddersMapping.get(newDes);
        }
        else if(this.Tile + increMentTile == 100){
            return -1;
        }
        else {
            if(this.Tile + increMentTile > 100){
                System.out.println("Invalid Move, You need " + (100 - this.Tile) + " to Win !");
                return 0;
            }
            this.Tile += increMentTile;
        }
        return this.Tile;
    }
}
public class SnakesAndLadder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number of players:");
        Integer N = in.nextInt();
        ArrayList<Player> Players = new ArrayList<>();
        for(int i = 0;i < N;i++){
            Players.add(new Player());
        }
        Integer Moves = 0;
        System.out.println("Starting Snakes and Ladder Game Press 0 after any move to Quit or any other key to continue");
        while(in.nextInt() != 0){
            Moves++;
            for(int i = 0;i < N;i++){
                Integer res = Players.get(i).Turn();
                if(res == -1){
                    System.out.println("Player " + (i + 1) + " Win !");
                    return;
                }
            }
            System.out.println("State of board after " + Moves);
            for(int i = 0;i < N;i++){
                Player Temp = Players.get(i);
                System.out.println("Player " + (i + 1) + " at " + Temp.Tile);
            }
        }
    }
}
