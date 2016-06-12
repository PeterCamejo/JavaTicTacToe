package input;

import models.States.PlayState;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 */
public class PlayKeyManager extends KeyManager {
    /* Attributes */
    public boolean north, south, east , west , select, north1 , south1 , east1 , west1 , back;

    /* Constructor */
    public PlayKeyManager(){
        super();
    }

    /* Methods */
    public void tick(){
        north = keys[KeyEvent.VK_W];
        north1 = keys[KeyEvent.VK_UP];
        south = keys[KeyEvent.VK_S];
        south1 = keys[KeyEvent.VK_DOWN];
        east = keys[KeyEvent.VK_D];
        east1 = keys[KeyEvent.VK_RIGHT];
        west = keys[KeyEvent.VK_A];
        west1 = keys[KeyEvent.VK_LEFT];
        select = keys[KeyEvent.VK_ENTER];
        back = keys[KeyEvent.VK_ESCAPE];
    }
}