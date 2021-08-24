package beatgame.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import beatgame.view.GameMenu;

public class KeyController extends KeyAdapter{
    
    @Override
    public void keyPressed(KeyEvent e){
        if(GameMenu.game == null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            GameMenu.game.pressA();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            GameMenu.game.pressS();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            GameMenu.game.pressD();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            GameMenu.game.pressSpace();
        }
        else if(e.getKeyCode() == KeyEvent.VK_J){
            GameMenu.game.pressJ();
        }
        else if(e.getKeyCode() == KeyEvent.VK_K){
            GameMenu.game.pressK();
        }
        else if(e.getKeyCode() == KeyEvent.VK_L){
            GameMenu.game.pressL();
        }

    }
    @Override
    public void keyReleased(KeyEvent e){
        if(GameMenu.game == null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            GameMenu.game.releaseA();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            GameMenu.game.releaseS();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D){
            GameMenu.game.releaseD();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            GameMenu.game.releaseSpace();
        }
        else if(e.getKeyCode() == KeyEvent.VK_J){
            GameMenu.game.releaseJ();
        }
        else if(e.getKeyCode() == KeyEvent.VK_K){
            GameMenu.game.releaseK();
        }
        else if(e.getKeyCode() == KeyEvent.VK_L){
            GameMenu.game.releaseL();
        }
    }
}
