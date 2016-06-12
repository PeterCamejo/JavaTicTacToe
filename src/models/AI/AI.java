package models.AI;

import models.Map.Map;
import models.Map.Tile;

/**
 *
 */
public class AI {
    /* Attributes */
    private String token;
    private String enemyToken;

    /* Constructors */
    public AI(String token){
        this.token = token;
        init();
    }

    /* Methods */
    public void init(){
        if(token.equals("X")){
            enemyToken = "O";
        }else{
            enemyToken = "X";
        }
    }


    public void takeTurn(int mapSize , Tile[][] tiles){
        int rowCount = 0;
        int colCount = 0;
        int diagCount0 = 0;
        int diagCount1 = 0;

        /* Check for winning move */
        for(int i = 0 ; i < mapSize ; i++){
            //Diag counting
            if(tiles[i][i].tokenEquals(token)){
                diagCount0++;
            }

            if(tiles[mapSize-1-i][i].tokenEquals(token)){
                diagCount1++;
            }

            // Row and Col counting
            for(int  j = 0 ; j < mapSize; j++){
                if(tiles[i][j].tokenEquals(token)){
                    rowCount++;
                }

                if(tiles[j][i].tokenEquals(token)){
                    colCount++;
                }
            }

            //Winning move in this row detected.
            if(rowCount == mapSize - 1){
                for(int k  = 0; k < mapSize ; k++){
                    if(tiles[i][k].getToken() == null){
                        tiles[i][k].setToken(token);
                        return;
                    }
                }
            }

            //Winning move in this coloumn detected.
            if(colCount == mapSize - 1){
                for(int k = 0; k < mapSize ; k++){
                    if(tiles[k][i].getToken() == null){
                        tiles[k][i].setToken(token);
                        return;
                    }
                }
            }

            //Winning move in Diag0 found
            if(diagCount0 == mapSize - 1){
                for(int k = 0 ; k < mapSize; k++){
                    if(tiles[k][k].getToken() == null){
                        tiles[k][k].setToken(token);
                        return;
                    }
                }
            }

            if(diagCount1 == mapSize - 1){
                for(int k = 0 ; k < mapSize; k++){
                    if(tiles[mapSize-1-k][k].getToken() == null){
                        tiles[mapSize-1-k][k].setToken(token);
                        return;
                    }
                }
            }

            rowCount = 0;
            colCount = 0;
        }


        rowCount = 0;
        colCount = 0;
        diagCount0 = 0;
        diagCount1 = 0;

        /* Check for saving move */
        for(int i = 0 ; i < mapSize ; i++){
            //Diag counting
            if(tiles[i][i].tokenEquals(enemyToken)){
                diagCount0++;
            }

            if(tiles[mapSize-1-i][i].tokenEquals(enemyToken)){
                diagCount1++;
            }

            // Row and Col counting
            for(int  j = 0 ; j < mapSize; j++){
                if(tiles[i][j].tokenEquals(enemyToken)){
                    rowCount++;
                }

                if(tiles[j][i].tokenEquals(enemyToken)){
                    colCount++;
                }
            }

            //SAving move in this row detected.
            if(rowCount == mapSize - 1){
                for(int k  = 0; k < mapSize ; k++){
                    if(tiles[i][k].getToken() == null){
                        tiles[i][k].setToken(token);
                        return;
                    }
                }
            }

            //Saving move in this coloumn detected.
            if(colCount == mapSize - 1){
                for(int k = 0; k < mapSize ; k++){
                    if(tiles[k][i].getToken() == null){
                        tiles[k][i].setToken(token);
                        return;
                    }
                }
            }

            //Saving move in Diag0 found
            if(diagCount0 == mapSize - 1){
                for(int k = 0 ; k < mapSize; k++){
                    if(tiles[k][k].getToken() == null){
                        tiles[k][k].setToken(token);
                        return;
                    }
                }
            }

            if(diagCount1 == mapSize - 1){
                for(int k = 0 ; k < mapSize; k++){
                    if(tiles[mapSize-1-k][k].getToken() == null){
                        tiles[mapSize-1-k][k].setToken(token);
                        return;
                    }
                }
            }

            rowCount = 0;
            colCount = 0;
        }

        /* Build towards a winning move*/
        /* SUPER SIMPLE FOR NOW */
        for( int i = 0 ; i < mapSize ; i++){
            for(int j = 0 ; j < mapSize; j++){
                if(tiles[i][j].getToken() == null){
                    tiles[i][j].setToken(token);
                    return;
                }
            }
        }


    }
}
