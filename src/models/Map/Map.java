package models.Map;

import models.Scoreboard;
import views.Assets;

import java.awt.*;

/**
 * Created by The Alex on 5/31/2016.
 */
public class Map {
    /* Attributes */
    private Tile[][] tiles;
    private int size;
    private int tileSize;
    private Point selected;


    /* Constructor */
    public Map(){
        size = 3;
        tileSize = 100;
        tiles = new Tile[size][size];
        selected = new Point(0 , 0 );
        init();
    }

    public Map(int mapSize){
        size = mapSize;
        tileSize = 100;
        tiles = new Tile[size][size];
        selected = new Point(0 , 0 );
        init();
    }

    /* Methods */
    public void init(){
        for(int i = 0; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                tiles[i][j] = new Tile();
            }
        }
    }

    public Boolean setSelectedToken(String token){
        if(tiles[selected.x][selected.y].setToken(token)){
            return true;
        }

        return false;
    }

    public void setSelected(String direction){
        switch(direction){
            case "north":
                if(selected.y - 1 >= 0){
                   selected.y -= 1;
                }
                break;
            case "south":
                if(selected.y + 1 <= size - 1){
                    selected.y += 1;
                }
                break;
            case "east":
                if(selected.x + 1 <= size - 1){
                    selected.x += 1;
                }
                break;
            case "west":
                if(selected.x - 1 >= 0){
                    selected.x -= 1;
                }
                break;
        }
    }

    public String checkWin(){
        int[] X_ROW_COUNT = new int[size];
        int[] O_ROW_COUNT = new int[size];
        int[] X_COL_COUNT = new int[size];
        int[] O_COL_COUNT = new int[size];
        int countInd = 0;
        /*
        *   DIAG_COUNT0 refers to the northwest-to-southeast diagonal
        *   DIAG_COUNT1 refers to the northeast-to-southwest diagonal
        */
        int X_DIAG_COUNT0 = 0;
        int X_DIAG_COUNT1 = 0;
        int O_DIAG_COUNT0 = 0;
        int O_DIAG_COUNT1 = 0;

        /* NULL_COUNT keeps track of the number of empty squares.
        *  If no squares empty but no one has won, it is a "CAT" game
         */
        int NULL_COUNT  = 0;

        for(int  i = 0 ; i < size ; i++){
            /* Diagonal Check */
            if(tiles[i][i].tokenEquals("X")){
                X_DIAG_COUNT0++;
            }
            if(tiles[i][i].tokenEquals("O")){
                O_DIAG_COUNT0++;
            }
            if(tiles[size-1-i][i].tokenEquals("X")){
                X_DIAG_COUNT1++;
            }
            if(tiles[size-1-i][i].tokenEquals("O")){
                O_DIAG_COUNT1++;
            }

            /* Row Col and Null Check*/
            for(int j = 0 ; j < size; j++){
                /* Row */
                if(tiles[i][j].tokenEquals("X")){
                    X_ROW_COUNT[countInd]++;
                }
                if(tiles[i][j].tokenEquals("O")){
                    O_ROW_COUNT[countInd]++;
                }
                if(!tiles[i][j].hasToken()){
                    NULL_COUNT++;
                }

                /* Col */
                if(tiles[j][i].tokenEquals("X")){
                    X_COL_COUNT[countInd]++;
                }
                if(tiles[j][i].tokenEquals("O")){
                    O_COL_COUNT[countInd]++;
                }
            }

            countInd++;
        }

        if(X_DIAG_COUNT0 == size || X_DIAG_COUNT1 == size){
            return "X";
        }
        if(O_DIAG_COUNT0 == size || O_DIAG_COUNT1 == size){
            return "O";
        }

        for(int i = 0; i < size; i++){
            if(X_ROW_COUNT[i] == size || X_COL_COUNT[i] == size){
                return "X";
            }
            if(O_ROW_COUNT[i] == size || O_COL_COUNT[i] == size){
                return "O";
            }
        }

        if(NULL_COUNT == 0){
            return "CAT";
        }

        return null;
    }

    public void render(Graphics g){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){

                if(selected.x == i && selected.y == j){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.BLACK);
                }

                g.fillRect(i * tileSize , j * tileSize, tileSize , tileSize);
                g.setColor(Color.BLUE);
                g.fillRect(i * tileSize + 3 , j * tileSize + 3 , tileSize - 6, tileSize - 6);

                if(tiles[i][j].getToken() != null){
                    if(tiles[i][j].getToken() == "X"){
                        g.drawImage(Assets.X , i * tileSize + 3 , j * tileSize + 3 , null);
                    }else{
                        g.drawImage(Assets.O , i  * tileSize + 3  , j * tileSize + 3 ,  null);
                    }
                }

            }
        }
    }

    public Tile[][] getTiles(){return tiles;}

    public int getSize(){ return size;}

    public void clearBoard(){
        for(int i = 0 ; i < size ; i++){
            for(int  j = 0 ;j < size ; j++){
                tiles[i][j].clear();
            }
        }
    }


}
