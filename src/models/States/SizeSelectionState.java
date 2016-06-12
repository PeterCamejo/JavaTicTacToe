package models.States;

import input.KeyManager;
import input.PlayKeyManager;
import views.Assets;

import java.awt.*;

/**
 * Created by The Alex on 6/12/2016.
 */
public class SizeSelectionState extends State {
    /* Attributes */
    private PlayKeyManager keyManager;
    private int[] selections;
    private int selector;
    private int inputBuffer;
    private String playerToken;

    /* Constructor */
    public SizeSelectionState(String playerToken){
        keyManager = new PlayKeyManager();
        selections = new int[4];
        selector = 0;
        inputBuffer = 0;
        this.playerToken = playerToken;
        init();
    }

    /* Methods */
    public void tick(){
        keyManager.tick();
        if(++inputBuffer == 4) {
            if (keyManager.west || keyManager.west1) {
                if (selector - 1 >= 0) {
                    selector--;
                }
            }

            if (keyManager.east || keyManager.east1) {
                if (selector + 1 <= 3) {
                    selector++;
                }
            }

            if (keyManager.back) {
                GameStateManager.setState(new TokenSelectState());
            }

            if(keyManager.select){
                GameStateManager.setState(new PlayState(playerToken , selections[selector]));
            }

            inputBuffer = 0;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(0 , 0 , 600, 700);

        g.setColor(Color.red);
        switch(selector){
            case 0:
                g.fillRect( 45 , 245 , 105 , 105);
                break;
            case 1:
                g.fillRect( 180 , 245 , 105 , 105);
                break;
            case 2:
                g.fillRect(315 , 245 , 105 , 105);
                break;
            case 3:
                g.fillRect(450 , 245 , 105 , 105);
                break;
        }


        g.drawImage(Assets.three ,50 , 250 ,null );
        g.drawImage(Assets.four , 185 , 250 , null);
        g.drawImage(Assets.five , 320 , 250  , null);
        g.drawImage(Assets.six ,  455 , 250 , null);
    };

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public void init(){
        int sizeValue = 3;
        for(int  i = 0 ; i < 4 ; i++){
            selections[i] = sizeValue;
            sizeValue++;
        }
    }
}
