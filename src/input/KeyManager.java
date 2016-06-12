package input;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolverException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by The Alex on 5/22/2016.
 */
public abstract class KeyManager implements KeyListener {
    /* Attributes */
    protected boolean[] keys;

    /* Constructor */
    public KeyManager(){
        keys = new boolean[256];
    }
    /* Methods */
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e){

    }

    public abstract void tick();
}
