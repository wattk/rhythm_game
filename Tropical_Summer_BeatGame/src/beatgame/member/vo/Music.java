package beatgame.member.vo;

//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;
//import java.io.InputStreamReader;

import javazoom.jl.player.Player;

public class Music extends Thread{
    
    private Player player;
    private boolean isLoop;
//    private File file;
//    private FileInputStream fis;
//    private BufferedInputStream bis;
    private InputStream in;

    public Music(String name, boolean isLoop){
        try{
            this.isLoop = isLoop;
//            file = new File(GameRun.class.getResource("/music/" + name).toURI());
//            fis = new FileInputStream(file);
//            bis = new BufferedInputStream(fis);
//            player = new Player(bis);
            in = getClass().getResourceAsStream("/music/" + name);
            player = new Player(in);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getTime(){
        if(player == null)
            return 0;
        return player.getPosition();
    }

    public void close(){
        isLoop = false;
        player.close();
        this.interrupt();//음악이 나오는 스레드(작은 프로그램)을 종료하는 명령어
    }

    //스레드를 상속받으면 무조건 오버라이드해야 하는 함수
    @Override
    public void run(){
        try{
            do{
                player.play();
//                fis = new FileInputStream(file);
//                bis = new BufferedInputStream(fis);
                player = new Player(in);
            } while(isLoop);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
