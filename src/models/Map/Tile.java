package models.Map;

/**
 * Created by The Alex on 5/31/2016.
 */
public class Tile {
    /* Attributes */
    String token;


    /* Constructor */
    public Tile(){
        token = null;

    }

    public Tile(String token){
        this.token = token;
    }

    /* Methods */
    public String getToken(){
        return this.token;
    }

    public boolean tokenEquals(String newToken){

        if(token != null) {
            if (token.equals(newToken)) {
                return true;
            }
        }

        return false;
    }

    public Boolean setToken(String token){
        if(token ==  null){
            return false;
        }
        if(this.token !=  null){
            return false;
        }

        this.token = token;
        return true;
    }

    public void clear(){
        this.token = null;
        return;
    }

    public boolean hasToken(){
        if(token == null){
            return false;
        }

        return true;
    }




}
