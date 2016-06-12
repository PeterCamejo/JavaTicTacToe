package models;

import java.awt.*;

/**
 *  Keeps track of score. SRP for life.
 */
public class Scoreboard {
    /* Attributes */
    private int playerScore;
    private int compScore;

    /* Constructors */
    public Scoreboard(){
        playerScore = 0;
        compScore = 0;
    }

    /* Methods */
    public void incrementPlayerScore(){
        playerScore++;
    }

    public void incrementCompScore(){
        compScore++;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public int getCompScore(){
        return compScore;
    }

    public void clearScore(){
        playerScore = 0;
        compScore = 0;
    }

    public void render(Graphics g){
        String playerScoreText;
        String compScoreText;

        g.setColor(Color.ORANGE);
        g.fillRect(0 , 600 , 600 , 100);

        playerScoreText = "Player Score: " + Integer.toString(playerScore);
        compScoreText = "Computer Score: " + Integer.toString(compScore);

        g.setColor(Color.black);
        g.drawString(playerScoreText , 150 , 650 );
        g.drawString(compScoreText , 350 , 650 );

    }
}
