package beatgame.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import beatgame.controller.GameController;
import beatgame.controller.KeyController;
import beatgame.member.vo.Music;
import beatgame.member.vo.Track;
import beatgame.run.GameRun;


public class GameMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	private Image screenImage;
    private Graphics screenGraphic;
    
    private ImageIcon exitButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/exitButtonEntered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/exitButtonBasic.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/startButtonEntered.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/startButtonBasic.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/quitButtonEntered.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/quitButtonBasic.png"));
    private ImageIcon rightButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/rightButtonBasic.png"));
    private ImageIcon rightButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/rightButtonEntered.png"));
    private ImageIcon leftButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/leftButtonBasic.png"));
    private ImageIcon leftButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/leftButtonEntered.png"));
    private ImageIcon easyButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/easyButtonBasic.png"));
    private ImageIcon easyButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/easyButtonEntered.png"));
    private ImageIcon hardButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/hardButtonBasic.png"));
    private ImageIcon hardButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/hardButtonEntered.png"));
    private ImageIcon backButtonBasicImage = new ImageIcon(GameRun.class.getResource("/images/backButtonBasic.png"));
    private ImageIcon backButtonEnteredImage = new ImageIcon(GameRun.class.getResource("/images/backButtonEntered.png"));
    
    
    private Image background = new ImageIcon(GameRun.class.getResource("/images/title.png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(GameRun.class.getResource("/images/menuBar.png")));
    
    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);
    private JButton leftButton = new JButton(leftButtonBasicImage);
    private JButton easyButton = new JButton(easyButtonBasicImage);
    private JButton hardButton = new JButton(hardButtonBasicImage);
    private JButton backButton = new JButton(backButtonBasicImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;
    private boolean isGameScreen = false;

    ArrayList<Track> trackList = new ArrayList<Track>();

    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic;
    Music introMusic = new Music("introMusic.mp3",true);
    private int nowSelected = 0;

    public static GameController game;
    
    public GameMenu(){
        trackList.add(new Track("brandNewDaysTitle.png", "brandNewDaysStartImage.png", "brandNewDaysGameImage.png", "Brand New Days Selected.mp3", "Roa - Brand New Days.mp3", "Roa - Brand New Days"));
        trackList.add(new Track("summerTitle.png", "summerStartImage.png", "summerGameImage.png", "Summer Selected.mp3", "MBB - Summer.mp3", "MBB - Summer"));
        trackList.add(new Track("islandTitle.png", "islandStartImage.png", "islandGameImage.png", "Island Selected.mp3", "MBB - Island.mp3", "MBB - Island"));

        setUndecorated(true);
        setTitle("Tropical Summer");
        setSize(GameRun.SCREEN_WIDTH, GameRun.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);//만든 게임 창이 정중앙에 뜬다
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 끄면 프로그램 전체 종료
        setVisible(true);//우리 눈에 게임창이 보이도록 함
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        addKeyListener(new KeyController());

        introMusic.start();

        //우상단 나가기 버튼
        exitButton.setBounds(1245, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                System.exit(0);
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        add(exitButton);

        //시작버튼
        startButton.setBounds(40, 200, 400, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                introMusic.close();
                enterMain();
            }
        });
        add(startButton);

        //나가기 버튼
        quitButton.setBounds(40, 330, 400, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                System.exit(0);
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        add(quitButton);

        //오른쪽 이동 버튼
        rightButton.setVisible(false);
        rightButton.setBounds(1080, 310, 60, 60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                rightButton.setIcon(rightButtonBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                //오른쪽 버튼 이벤트
                selectRight();
            }
        });
        add(rightButton);

        //왼쪽 이동 버튼
        leftButton.setVisible(false);
        leftButton.setBounds(140, 310, 60, 60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                leftButton.setIcon(leftButtonBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                //왼쪽 버튼 이벤트
                selectLeft();
            }
        });
        add(leftButton);

        //이지모드 버튼
        easyButton.setVisible(false);
        easyButton.setBounds(375, 580, 250, 67);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                easyButton.setIcon(easyButtonEnteredImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                easyButton.setIcon(easyButtonBasicImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                //난이도 쉬움 이벤트
                gameStart(nowSelected, "Easy");
            }
        });
        add(easyButton);

        //하드모드 버튼
        hardButton.setVisible(false);
        hardButton.setBounds(655, 580, 250, 67);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                hardButton.setIcon(hardButtonEnteredImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                hardButton.setIcon(hardButtonBasicImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                //난이도 어려움 이벤트
                gameStart(nowSelected, "Hard");
            }
        });
        add(hardButton);

        //뒤로가기 버튼
        backButton.setVisible(false);
        backButton.setBounds(20, 50, 60, 60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                backButton.setIcon(backButtonEnteredImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                backButton.setIcon(backButtonBasicImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
                buttonPressedMusic.start();
                //메인 화면으로 돌아가기
                backMain();
                
            }
        });
        add(backButton);

        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);
    }
    
    public void paint(Graphics g){
        screenImage = createImage(GameRun.SCREEN_WIDTH, GameRun.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw((Graphics2D) screenGraphic);
        g.drawImage(screenImage, 0, 0, null);

    }

    public void screenDraw(Graphics2D g){
        g.drawImage(background, 0, 0, null);
        if(isMainScreen){
            g.drawImage(selectedImage, 415, 100, null);
            g.drawImage(titleImage, 415, 270, null);
        }
        if(isGameScreen){
            game.screenDraw(g);
        }
        paintComponents(g);
        try{
            Thread.sleep(5);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.repaint();// 전체화면 이미지를 매순간 다시 그려주는 것
    }

    public void selectTrack(int nowSelected){
        if(selectedMusic != null)
            selectedMusic.close();
        titleImage = new ImageIcon(GameRun.class.getResource("/images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(GameRun.class.getResource("/images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft(){
        if(nowSelected == 0){
            nowSelected = trackList.size() - 1;
        }
        else
            nowSelected--;
        selectTrack(nowSelected);
    }

    public void selectRight(){
        if(nowSelected == trackList.size() - 1){
            nowSelected = 0;
        }
        else
            nowSelected++;
        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected, String difficulty){
        if(selectedMusic != null)
            selectedMusic.close();
        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        background = new ImageIcon(GameRun.class.getResource("/images/" + trackList.get(nowSelected).getGameImage())).getImage();
        backButton.setVisible(true);
        isGameScreen = true;
        game = new GameController(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
        game.start();
        setFocusable(true);
    }

    public void backMain(){
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        background = new ImageIcon(GameRun.class.getResource("/images/mainBackground.png")).getImage();
        backButton.setVisible(false);
        selectTrack(nowSelected);
        isGameScreen = false;
        game.close();
    }

    public void enterMain(){
        
        // 게임 시작 이벤트
        startButton.setVisible(false);
        quitButton.setVisible(false);
        background = new ImageIcon(GameRun.class.getResource("/images/mainBackground.png")).getImage();
        isMainScreen = true;
        rightButton.setVisible(true);
        leftButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        introMusic.close();
        selectTrack(0);
    }
}
