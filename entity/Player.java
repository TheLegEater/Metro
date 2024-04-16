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
        solidArea = new Rectangle(0, 0, 48, 48);
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX = 100;
        worldY = 100;
        speed = 4;
        direction = "standR";
    }
    public void getPlayerImage(){
        try{

            standR = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob ST R.png"));
            standL = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob ST L.png"));

            walkL = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob WC L-1.png"));
            walkR = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob WC R-1.png"));
            walkL2 = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob WC L-2.png"));
            walkR2 = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob WC R-2.png"));
            walkL3 = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob WC L-3.png"));
            walkR3 = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob WC R-3.png"));
            
            //walkR = ImageIO.read(new File("/Sprite Cranberry/Ob WC R.gif"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        //if else makes it so multiple inputs cannot be done at once
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true){
            if(keyH.upPressed == true){
                direction = "standR";
            }
            else if(keyH.downPressed == true){
                direction = "standL";
            }
            else if(keyH.leftPressed == true){
                direction = "walkL";
            }
            else if(keyH.rightPressed == true){
                direction = "walkR";               
            }
            collisionOn = false;
            gp.cChecker.checkTile(this);

            if(collisionOn == false){
                switch(direction){
                case "standR":
                    worldY -= speed;
                    break;
                case "standL":
                    worldY += speed;
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
            }  
        }else{
            //if(x > player2.x){
                //direction = "standL";
            //}
            //else if(x < Player2.x){
                //direction = "standR";
            //}
            direction = "standL";
        }
        
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
