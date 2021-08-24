package beatgame.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import beatgame.member.vo.Beat;
import beatgame.member.vo.Music;
import beatgame.member.vo.Note;
import beatgame.run.GameRun;

public class GameController extends Thread{
    
    private Image noteRouteLineImage = new ImageIcon(GameRun.class.getResource("/images/noteRouteLine.png")).getImage();
    private Image judgementLineImage = new ImageIcon(GameRun.class.getResource("/images/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(GameRun.class.getResource("/images/gameInfo.png")).getImage();
    private Image noteRouteAImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
    private Image purpleFlareImage;
    private Image judgeImage;
    private Image keyPadAImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadSImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadDImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadSpace1Image = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadSpace2Image = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadJImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadKImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    private Image keyPadLImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    
    private String titleName;
    private String difficulty;
    private String musicTitle;
    
    private Music gameMusic;
    private int totalScore = 0;
    
//    private boolean gameMaker = true;
    private int index = 0;

    ArrayList<Note> noteList = new ArrayList<Note>();

    public GameController(String titleName, String difficulty, String musicTitle){
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
        
    }

    public void screenDraw(Graphics2D g){
        g.drawImage(noteRouteAImage, 228, 30, null);
        g.drawImage(noteRouteSImage, 332, 30, null);
        g.drawImage(noteRouteDImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
        g.drawImage(noteRouteLineImage, 224, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 432, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgementLineImage, 0, 580, null);
        for(int i = 0; i < noteList.size(); i++){
            Note note = noteList.get(i);
            if(note.getY() > 620){
                judgeImage = new ImageIcon(GameRun.class.getResource("/images/judgeMiss.png")).getImage();
            }
            if(!note.isProceed()){
                noteList.remove(i);
                i--;
            }
            else{
                note.screenDraw(g);
            }
        }
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);//글씨가 깨지지 않도록 렌더링
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("A", 270, 609);
        g.drawString("S", 374, 609);
        g.drawString("D", 478, 609);
        g.drawString("Space Bar", 580, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 993, 609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString(Integer.toString(totalScore), 565, 702);
        g.drawImage(purpleFlareImage, 131, 180, null);
        g.drawImage(judgeImage, 460, 420, null);
        g.drawImage(keyPadAImage, 228, 580, null);
        g.drawImage(keyPadSImage, 332, 580, null);
        g.drawImage(keyPadDImage, 436, 580, null);
        g.drawImage(keyPadSpace1Image, 540, 580, null);
        g.drawImage(keyPadSpace2Image, 640, 580, null);
        g.drawImage(keyPadJImage, 744, 580, null);
        g.drawImage(keyPadKImage, 848, 580, null);
        g.drawImage(keyPadLImage, 952, 580, null);
    }
    
    public void pressA(){
        judge("A");
        score("A");
        noteRouteAImage = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadAImage = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
//        if(gameMaker == true)
//            System.out.println(gameMusic.getTime()+" A");
    }
    public void pressS(){
        judge("S");
        score("S");
        noteRouteSImage = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadSImage = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
//        if(gameMaker == true)
//            System.out.println(gameMusic.getTime()+" S");
    }
    public void pressD(){
        judge("D");
        score("D");
        noteRouteDImage = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadDImage = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
//        if(gameMaker == true)
//            System.out.println(gameMusic.getTime()+" D");
    }
    public void pressSpace(){
        judge("Space");
        score("Space");
        noteRouteSpace1Image = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadSpace1Image = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        keyPadSpace2Image = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("drumBig1.mp3", false).start();
//        if(gameMaker == true)
//            System.out.println(gameMusic.getTime()+" Space");
    }
    public void pressJ(){
        judge("J");
        score("J");
        noteRouteJImage = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadJImage = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
//        if(gameMaker == true)
//            System.out.println(gameMusic.getTime()+" J");
    }
    public void pressK(){
        judge("K");
        score("K");
        noteRouteKImage = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadKImage = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
//        if(gameMaker == true)
//            System.out.println(gameMusic.getTime()+" K");
    }
    public void pressL(){
        judge("L");
        score("L");
        noteRouteLImage = new ImageIcon(GameRun.class.getResource("/images/noteRoutePressed.png")).getImage();
        keyPadLImage = new ImageIcon(GameRun.class.getResource("/images/keyPadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
//        if(gameMaker == true)
//            System.out.println(gameMusic.getTime()+" L");
    }

    public void releaseA(){
        noteRouteAImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        keyPadAImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseS(){
        noteRouteSImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        keyPadSImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseD(){
        noteRouteDImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        keyPadDImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseSpace(){
        noteRouteSpace1Image = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        keyPadSpace1Image = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
        keyPadSpace2Image = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseJ(){
        noteRouteJImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        keyPadJImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseK(){
        noteRouteKImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        keyPadKImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    }
    public void releaseL(){
        noteRouteLImage = new ImageIcon(GameRun.class.getResource("/images/noteRoute.png")).getImage();
        keyPadLImage = new ImageIcon(GameRun.class.getResource("/images/keyPadBasic.png")).getImage();
    }

    @Override
    public void run(){
        try {
            dropNotes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(){
        gameMusic.close();
        this.interrupt();
    }

	public void dropNotes() throws Exception {
		Beat[] beats = null;
//		String musicName = "./beat_text/"+titleName + difficulty + ".txt";
		index(titleName, difficulty);
		int[] time = new int[this.index];
		String[] noteType = new String[this.index];
		int i = 0;
		try {
	    	InputStream in = getClass().getResourceAsStream("/beat_text/"+titleName+difficulty+".txt");
	    	BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			BufferedReader br = new BufferedReader(new FileReader(musicName));
			String str = "";
			while ((str = br.readLine()) != null) {
				String[] tmp = str.split(" ");
				String st = tmp[0];
				int k = Integer.valueOf(st);
				time[i] = k;
				noteType[i] = tmp[1];
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int gap = (660 / GameRun.NOTE_SPEED) * GameRun.SLEEP_TIME;

		beats = new Beat[index];
		for (int k = 0; k < index; k++) {
			beats[k] = new Beat(time[k] - gap, noteType[k]);
		}
		int j = 0;
		gameMusic.start();
		while (j < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[j].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[j].getNoteName());
				note.start();
				noteList.add(note);
				j++;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
    }

    public void index(String titleName, String difficulty) throws Exception{
    	InputStream in = getClass().getResourceAsStream("/beat_text/"+titleName+difficulty+".txt");
    	BufferedReader br = new BufferedReader(new InputStreamReader(in));
//        BufferedReader br = new BufferedReader(new FileReader("./beat_text/"+titleName+difficulty+".txt" ));
        while((br.readLine()) != null){
            index++;
        }
        br.close();
    }

    public void judge(String input){
        for(int i = 0; i < noteList.size(); i++){
            Note note = noteList.get(i);
            if(input.equals(note.getNoteType())){
                judgeEvent(note.judge());
                break;
            }
        }
    }

    public void judgeEvent(String judge){
        if(!judge.equals("None")){
            purpleFlareImage = new ImageIcon(GameRun.class.getResource("/images/purpleFlare.png")).getImage();
        }
        if(judge.equals("Miss")){
            judgeImage = new ImageIcon(GameRun.class.getResource("/images/judgeMiss.png")).getImage();
        }
        else if(judge.equals("Good")){
            judgeImage = new ImageIcon(GameRun.class.getResource("/images/judgeGood.png")).getImage();
        }
        else if(judge.equals("Great")){
            judgeImage = new ImageIcon(GameRun.class.getResource("/images/judgeGreat.png")).getImage();
        }
        else if(judge.equals("Perfect")){
            judgeImage = new ImageIcon(GameRun.class.getResource("/images/judgePerfect.png")).getImage();
        }
    }
    
    public void score(String input) {
		for(int i=0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				scoreEvent(note.score());
				break;
			}
		}
	}
    
	public void scoreEvent(int score) {
		if(score==10) {
			totalScore+=10;
			//System.out.println("Total score="+totalScore);
		}
		else if(score==20) {
			totalScore+=20;
			//System.out.println("Total score="+totalScore);
		}
		else if(score==30) {
			totalScore+=30;
			//System.out.println("Total score="+totalScore);
		}
		else if(score==40) {
			totalScore+=40;
			//System.out.println("Total score="+totalScore);
		}
	}
}
