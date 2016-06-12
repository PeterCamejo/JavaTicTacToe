package main;

/**
 * Created by The Alex on 5/31/2016.
 */
public class Launcher {
    public static void main (String args[]){
        Game game = new Game("JavaTicTacToe" , 600 , 700);
        game.start();
        return;
    }
}