package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
//import java.awt.Image;

import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
//import entity.Player;

public class Ob extends Player{
  GamePanel gp;
  KeyHandler keyH;

  public Ob(GamePanel gp, KeyHandler keyH, int x, int y){
    super(gp, keyH, x, y);
    solidArea = new Rectangle(0, 0, gp.tileSize, gp.tileSize);
    setDefaultValues();
    getPlayerImage();
  }
  public void setDefaultValues(){
      //worldX = 300;
      //worldY = 100;
      speed = 4;
      grav = 1;
      comInput = 0;
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
  
}