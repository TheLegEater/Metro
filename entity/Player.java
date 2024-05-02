package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
//import java.awt.Image;
//balls
import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//import java.awt.Color;

//import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import main.GamePanel;
import main.KeyHandler;
import entity.Impact;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    
    
    public Player(GamePanel gp, KeyHandler keyH, int x, int y){
        this.gp = gp;
        this.keyH = keyH;
        worldX = x;
        worldY = y;
        solidArea = new Rectangle(0, 0, gp.tileSize, gp.tileSize);
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        health = 5;
        acc = 1;
        speed = 4;
        grav = 0;
        jumpVal = 0;
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
        if(jumpVal > 0){
          jumpVal--;
        }
        
            
        
        if(keyH.att1Pressed){
          gp.impact.spawn(getX(), getY());
        }
        
        //if else makes it so multiple inputs cannot be done at once
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true){
            if(keyH.upPressed == true){
                //if(jumpVal == 0){
                direction = "jump";
                jumpVal = 300;
              //}
            }
            else if(keyH.downPressed == true){
                direction = "standL";
                
            }
            else if(keyH.leftPressed == true){
                direction = "walkL";
                
            }
            else if(keyH.rightPressed == true){
                direction = "walkR";
                comInput = 6;
            }
        }else{
          if(looking == "right"){
            direction = "standR";
          }else{ //if(looking == "left"){
            direction = "standL";
          }
        }
    
            collisionOn = false;
            gp.cChecker.checkTile(this);

            if(collisionOn == false){
                switch(direction){
                case "jump":
                    worldY -= speed;
                    acc--;
                    break;
                case "standL":
                    worldY += speed;
                    acc--;
                    break;
                case "walkL":
                    worldX -= speed;
                    if(acc < 4){
                      acc++;
                    }
                    break;
                case "walkR":
                    worldX += speed;
                    if(acc < 4){
                      acc++;
                    }
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
