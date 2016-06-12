package models.States;

import input.KeyManager;
import input.PlayKeyManager;
import views.Assets;

import java.awt.*;

/**
 * Created by The Alex on 6/12/2016.
 */
public class TokenSelectState extends State {
    /* Attributes */
    private PlayKeyManager keyManager;
    boolean selected; //X = true , O = false;
    private int inputBuffer;

    /*Constructors */
    public TokenSelectState(){
        keyManager = new PlayKeyManager();
        selected = true;
        inputBuffer = 0;
    }

    /* Methods */
    public void tick(){
        keyManager.tick();
        if(++inputBuffer == 4) {

            if (keyManager.west || keyManager.west1 || keyManager.east || keyManager.east1) {
                toggleSelected();
            }
            if (keyManager.select) {
                if (selected == true) {
                    GameStateManager.setState(new SizeSelectionState("X"));
                } else {
                    GameStateManager.setState(new SizeSelectionState("O"));
                }
            }
            inputBuffer = 0;
        }
    }
    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(0 , 0 , 600 , 700 );

        g.setColor(Color.red);
        if(selected){
            g.fillRect(95 , 245 , 105 , 105);
        }else{
            g.fillRect(395 , 245 , 105 , 105);
        }

        g.drawImage(Assets.X , 100 , 250, null);
        g.drawImage(Assets.O , 400 , 250 , null);


    }
    public KeyManager getKeyManager(){
        return keyManager;
    }

    private void toggleSelected(){
        selected = !selected;
    }
}
