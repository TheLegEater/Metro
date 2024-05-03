package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    //public int x;
    //public int y;
    public int speed;
    public int health;
    public int acc;
    public int comInput;
    public BufferedImage standR, standL, walkR, walkL, walkR2, walkL2, walkR3, walkL3, stable, unstable, jumpR, jumpL;
    public String direction;
    public String action;
    public String looking;
    public int jumpVal;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public int worldX, worldY;
    public int grav;
    
}
