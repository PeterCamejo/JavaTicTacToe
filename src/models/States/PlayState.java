package models.States;

import input.KeyManager;
import input.PlayKeyManager;
import models.AI.AI;
import models.Map.Map;
import models.Scoreboard;

import java.awt.*;

/**
 * Created by The Alex on 5/31/2016.
 */
public class PlayState extends State {
    /* Attributes */
    private PlayKeyManager keyManager;
    private Map gameMap;
    private Scoreboard scoreboard;
    private int inputBuffer;
    private String playerToken;
    private String compToken;
    private AI ai;

    //These Attributes should be put in a new class (Turn?)
    boolean playerTurn;
    boolean roundEnd;


    /* Constructors*/
    public PlayState(String playerToken , int mapSize){
        keyManager = new PlayKeyManager();
        gameMap = new Map(mapSize);
        scoreboard = new Scoreboard();
        inputBuffer = 0;
        playerTurn = true;
        roundEnd = false;

        this.playerToken = playerToken;
        if(playerToken.equals("X")){
            compToken = "O";
        }else{
            compToken = "X";
        }

        init();
    }

    public void tick(){
        keyManager.tick();

    /* Player Turn */
        if (++inputBuffer == 4) {
            if (roundEnd) {
                if (keyManager.select) {
                    gameMap.clearBoard();
                    roundEnd = false;
                }
            } else {
                if (playerTurn) {

                    if (keyManager.north || keyManager.north1) {
                        gameMap.setSelected("north");
                    }
                    if (keyManager.south || keyManager.south1) {
                        gameMap.setSelected("south");
                    }
                    if (keyManager.east || keyManager.east1) {
                        gameMap.setSelected("east");
                    }
                    if (keyManager.west || keyManager.west1) {
                        gameMap.setSelected("west");
                    }
                    if (keyManager.select) {
                        if (gameMap.setSelectedToken(playerToken)) {
                            if (checkWin()) {
                                roundEnd = true;
                            }
                            playerTurn = false;
                        }
                    }
                    if (keyManager.back) {
                        GameStateManager.setState(new SizeSelectionState(playerToken));
                    }

                }

     /* AI Turn */
                else {
                    ai.takeTurn(gameMap.getSize(), gameMap.getTiles());
                    if (checkWin()) {
                        roundEnd = true;
                    }
                    playerTurn = true;
                }
            }
            inputBuffer = 0;
        }
    }





    public void init(){
        if(playerToken.equals("X")){
            ai  = new AI("O");
        }else{
            ai = new AI("X");
        }
    }
    public void render(Graphics g){
        gameMap.render(g);
        scoreboard.render(g);
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    private boolean checkWin(){
        if(gameMap.checkWin() != null) {
            if (gameMap.checkWin().equals(playerToken)) {
                scoreboard.incrementPlayerScore(); //
                System.out.println("Player ("+playerToken+") Wins");
            }
            if (gameMap.checkWin().equals(compToken)) {
                scoreboard.incrementCompScore();//
                System.out.println("Computer ("+compToken+") Wins");
            }
            if(gameMap.checkWin().equals("CAT")){
                System.out.println("CAT. Tie game.");
            }
            return true;
        }
        return false;
    }
}
