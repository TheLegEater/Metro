package main;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean upPressed, downPressed, leftPressed, rightPressed, upPressed2, downPressed2, leftPressed2, rightPressed2, att1Pressed, att1Pressed2;;
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_C){
          att1Pressed = true;
        }

        if(code == KeyEvent.VK_I){
            upPressed2 = true;
        }
        if(code == KeyEvent.VK_K){
            downPressed2 = true;
        }
        if(code == KeyEvent.VK_J){
            leftPressed2 = true;
        }
        if(code == KeyEvent.VK_L){
            rightPressed2 = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_C){
          att1Pressed = false;
        }
        
        if(code == KeyEvent.VK_I){
            upPressed2 = false;
        }
        if(code == KeyEvent.VK_K){
            downPressed2 = false;
        }
        if(code == KeyEvent.VK_J){
            leftPressed2 = false;
        }
        if(code == KeyEvent.VK_L){
            rightPressed2 = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
