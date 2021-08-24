package beatgame.member.vo;

public class Track {
    private String titleImage; // 제목 부분 이미지
    private String startImage; // 게임 선택 창 표지 이미지
    private String gameImage; // 해당 곡을 실행했을 때 표지 이미지
    private String startMusic; // 게임 선택 창 음악
    private String gameMusic; // 해당 곡을 실행했을 때 음악
    private String titleName;

    public String getTitleImage() {
        return this.titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getStartImage() {
        return this.startImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public String getGameImage() {
        return this.gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public String getStartMusic() {
        return this.startMusic;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }

    public String getGameMusic() {
        return this.gameMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String titleName) {
        super();
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
        this.titleName = titleName;
    }
    
}
