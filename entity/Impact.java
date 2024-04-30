package entity;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Impact extends Entity{
    GamePanel gp;
    KeyHandler keyH;


    public Impact(GamePanel gp, KeyHandler keyH, int x, int y){
        this.gp = gp;
        this.keyH = keyH;
        worldX = x;
        worldY = y;
        solidArea = new Rectangle(0, 0, gp.tileSize, gp.tileSize);
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        health = 100;
        acc = 0;
        speed = 4;
        grav = 1;
        direction = "null";
        looking = "null";
    }
    public void spawn(int x, int y){
      worldX = x;
      worldY = y;
    }
    public void getPlayerImage(){
      try{
          stable = ImageIO.read(getClass().getResourceAsStream("/Sprite Cranberry/Ob ST R.png"));
          //walkR = ImageIO.read(new File("/Sprite Cranberry/Ob WC R.gif"));
      }catch(IOException e){
          e.printStackTrace();
      }
    }
    public int getX(){
      return worldX;
    }
    public int getY(){
      return worldY;
    }
  
    public void update(){
      if(worldX != -100){
        health--;
        if(health <= 0){
          worldX = -100;
          health = 100;
        }
        
      }
      //System.out.print(health);
    }
    public void draw(Graphics2D g2){
      BufferedImage image = null;
      image = stable;
      g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}