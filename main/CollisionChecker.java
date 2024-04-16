package main;

import entity.Entity;

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

        int tileNum1, tileNum2;

        switch(entity.direction){
        case "standR":
            //entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            if(gp.tileM.tile[0].collision == true  && entity.worldY == 200 && entity.worldX == 200){
                entity.collisionOn = true;
            }
            break;
        case "standL":
            break;
        case "walkL":
            break;
        case "walkR":
            break;
        }
    }
}
