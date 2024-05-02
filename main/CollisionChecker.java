 package main;

import entity.Entity;
import entity.Player;


public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;

    }
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tilenum1, tilenum2;
        //if(gp.player.getX() == gp.player2.getX2()){
          //entity.collisionOn = true;
        //}
        



      
        switch(entity.direction){
        case "standR":
            //entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            
            if(gp.tileM.tile[2].collision == true  && entity.worldY == 0){
                //entity.collisionOn = true;
            }
            break;
        case "standL":
            entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
            tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tilenum1].collision == true  || gp.tileM.tile[tilenum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        case "walkL":
            entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
            tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tilenum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if(gp.tileM.tile[tilenum1].collision == true  || gp.tileM.tile[tilenum2].collision == true){
                entity.collisionOn = true;
            
            }
            break;
        case "walkR":
            entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
            tilenum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tilenum1].collision == true  || gp.tileM.tile[tilenum2].collision == true){
                entity.collisionOn = true;
            
            } 
            break;
        case "jump":
            entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            tilenum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tilenum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            if(gp.tileM.tile[tilenum1].collision == true  || gp.tileM.tile[tilenum2].collision == true){
              entity.collisionOn = true;
            }
            break;
        }
    }
}



