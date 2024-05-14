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
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        solidArea = new Rectangle(screenX, screenY, 48, 48);
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
        clock = 1;
        //worldX = gp.tileSize * 28;
        //worldY = gp.tileSize * 8;
        worldX = 500;
        worldY = 500;
        direction = "standR";
        looking = "right";
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

            jumpR = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob Jump R.png"));
            jumpL = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob Jump L.png"));

  
            //walkR = ImageIO.read(new File("/Sprite Cranberry/Ob WC R.gif"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void time(){
        //100 is about 1.5 seconds
        if(clock < 100){
            clock++;
        }else if(clock >= 100){
            clock = 0;
            //System.out.println("reset");
        }
    }
    public void update(){ 
        
        if(worldY != 525 && collisionOn == false){
          worldY += grav;
        }
        if(jumpVal > 0){
          jumpVal--;
        }
        
        if(keyH.rightPressed == true){
            time();
            if(clock == 0 && speed < 5){
                speed++;
            }
        }else if(keyH.rightPressed == false && speed > 0){
                speed = 1;
            
        }
        //solidArea.x = worldX;
        //solidArea.y = worldY;
        
            
        
        if(keyH.att1Pressed){
          gp.impact.spawn(getX(), getY());
        }
       
        //if else makes it so multiple inputs cannot be done at once
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true){
            
            if(keyH.downPressed == true){
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
                
                case "standL":
                    worldY += speed;
                  
                    //acc--;
                    break;
                case "walkL":
                    worldX -= speed;
                   
                    //if(acc < 4){
                      //acc++;
                    //}
                    break;
                case "walkR":
                    worldX += speed;
                   
                    if(acc < 4){
                      //acc++;
                    }
                    break;
                }
                if(keyH.rightPressed == true && jumpVal == 0){
                    if(keyH.upPressed == true){
                        direction = "jumpR";
                        worldY -= speed * 3;
                        worldX += speed * 2;
                        jumpVal = 100;
                    }
                        
                }else if(keyH.leftPressed == true && jumpVal == 0){
                    if(keyH.upPressed == true){
                        direction = "jumpL";
                        worldY -= speed * 3;
                        worldX -= speed * 2;
                        jumpVal = 100;
                    }
                            
                }else if(keyH.upPressed == true && jumpVal == 0){
                    direction = "jumpR";
                    worldY -= speed * 3;
                    jumpVal = 100;
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
        case "jumpL":
            image = jumpL;
            break;
        case "jumpR":
            image = jumpR;
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
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        g2.draw(solidArea);
    }
}
