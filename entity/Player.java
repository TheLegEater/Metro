package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
//import java.awt.Image;

import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//import java.awt.Color;

//import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        solidArea = new Rectangle(0, 0, gp.tileSize, gp.tileSize);
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = 300;
        worldY = 100;
        speed = 4;
        grav = 1;
        comInput = 0;
        direction = "standR";
        looking = "right";
    }
    public void getPlayerImage(){

    }
    public void update(){       
        if(worldY != 525){
          worldY += grav;
        }
        
            
        
        if(keyH.att1Pressed){
          System.out.println("input");
        }
        
        //if else makes it so multiple inputs cannot be done at once
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true){
            if(keyH.upPressed == true){
                direction = "standR";
                comInput = 8;
            }
            else if(keyH.downPressed == true){
                direction = "standL";
                comInput = 2;
            }
            else if(keyH.leftPressed == true){
                direction = "walkL";
                comInput = 4;
            }
            else if(keyH.rightPressed == true){
                direction = "walkR";
                comInput = 6;
            }
        }else{
          if(looking == "right"){
            direction = "standR";
          }else if(looking == "left"){
            direction = "standL";
          }
        }
    
            collisionOn = false;
            gp.cChecker.checkTile(this);

            if(collisionOn == false){
                switch(direction){
                case "standR":
                    //worldY -= speed;
                    break;
                case "standL":
                    //worldY += speed;
                    break;
                case "walkL":
                    worldX -= speed;
                    break;
                case "walkR":
                    worldX += speed;
                    break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 3;
                }
                else if(spriteNum == 3){
                    spriteNum = 4;
                }
                else if(spriteNum == 4){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }else{
               direction = "standR";
        }
    }
        
    
  public int getX(){
    return worldX;
  }
  public int getY(){
    return worldY;
  }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch(direction){
        case "standR":
            image = standR;
            break;
        case "standL":
            image = standL;
            break;
        case "walkR":
            if(spriteNum == 1){
                image = walkR;
            }
            if(spriteNum == 2 || spriteNum == 4){
                image = walkR2;
            }
            if(spriteNum == 3){
                image = walkR3;
            }
            break;
        case "walkL":
            if(spriteNum == 1){
                image = walkL;
            }
            if(spriteNum == 2 || spriteNum == 4){
                image = walkL2;
            }
            if(spriteNum == 3){
                image = walkL3;
            }
            break;
        }
        //g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
      
    }
}
