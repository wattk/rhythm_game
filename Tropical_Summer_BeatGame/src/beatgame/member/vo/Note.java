package beatgame.member.vo;

import java.awt.Image;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

import beatgame.run.GameRun;

public class Note extends Thread{
    
    private Image noteBasicImage = new ImageIcon(GameRun.class.getResource("/images/noteBasic.png")).getImage();
    private Image noteBasicSpaceImage = new ImageIcon(GameRun.class.getResource("/images/noteBasicSpace.png")).getImage();
    private int x, y = 580 - (1000 / GameRun.SLEEP_TIME * GameRun.NOTE_SPEED) * GameRun.REACH_TIME;
    private String noteType;
    private boolean proceeded = true;

    public String getNoteType(){
        return noteType;
    }

    public boolean isProceed(){
        return proceeded;
    }

    public void close(){
        proceeded = false;
    }

    public Note(String noteType){
        if(noteType.equals("A")){
            x = 228;
        }
        else if(noteType.equals("S")){
            x = 332;
        }
        else if(noteType.equals("D")){
            x = 436;
        }
        else if(noteType.equals("Space")){
            x = 540;
        }
        else if(noteType.equals("J")){
            x = 744;
        }
        else if(noteType.equals("K")){
            x = 848;
        }
        else if(noteType.equals("L")){
            x = 952;
        }
        this.noteType = noteType;
    }

    public void screenDraw(Graphics2D g){
        if(!noteType.equals("Space")){
            g.drawImage(noteBasicImage, x, y, null);
        }
        else{
            g.drawImage(noteBasicSpaceImage, x, y, null);
        }
    }

    public void drop(){
        y += GameRun.NOTE_SPEED;
        if(y > 620){
//            System.out.println("Miss");
            close();
        }
    }

    @Override
    public void run(){
        try{
            while(true){
            	drop();
                if(proceeded){
                    Thread.sleep(GameRun.SLEEP_TIME);
                }
                else{
                    interrupt();
                    break;
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public String judge(){
        if(y >= 613){
//            System.out.println("Miss");
            close();
            return "Miss";
        }
        else if(y >= 600){
//            System.out.println("Good");
            close();
            return "Good";
        }
        else if(y >= 587){
//            System.out.println("Great");
            close();
            return "Great";
        }
        else if(y >= 573){
//            System.out.println("Perfect");
            close();
            return "Perfect";
        }
        else if(y >= 565){
//            System.out.println("Great");
            close();
            return "Great";
        }
        else if(y >= 550){
//            System.out.println("Good");
            close();
            return "Good";
        }
        else if(y >= 535){
//            System.out.println("Miss");
            close();
            return "Miss";
        }
        return "None";
    }

    public int getY(){
        return y;
    }
    
    public int score() {
		if(y>=613) { 
			//System.out.println("Current score="+10);
			close();
			return 10;
		}
		else if(y>=600) { 
			//System.out.println("Current score="+20);
			close();
			return 20;
		}
		else if(y>=587) { 
			//System.out.println("Current score="+30);
			close();
			return 30;
		}
		else if(y>=573) {
			//System.out.println("Current score="+40);
			close();
			return 40;
		}
		else if(y>=565) {
			//System.out.println("Current score="+30);
			close();
			return 30;
		}
		else if(y>=550) { 
			//System.out.println("Current score="+20);
			close();
			return 20;
		}
		else if(y>=535) { 
			//System.out.println("Current score="+10);
			close();
			return 10;
		}
		return 0;
	}
}
