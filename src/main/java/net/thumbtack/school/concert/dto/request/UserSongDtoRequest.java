package net.thumbtack.school.concert.dto.request;

public class UserSongDtoRequest {

    private String songsName;
    private String composer;
    private String wordWriter;
    private String singer;
    private int songDuration;

    public UserSongDtoRequest(String songsName, String composer, String wordWriter, String singer, int songDuration) {
        this.songsName = songsName;
        this.composer = composer;
        this.wordWriter = wordWriter;
        this.singer = singer;
        this.songDuration = songDuration;
    }

    public int getSongDuration() {
        return songDuration;
    }

    public String getSinger() {
        return singer;
    }

    public String getWordWriter() {
        return wordWriter;
    }

    public String getComposer() {
        return composer;
    }

    public String getSongsName() {
        return songsName;
    }

    public void setSongDuration(int songDuration) {
        this.songDuration = songDuration;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setWordWriter(String wordWriter) {
        this.wordWriter = wordWriter;
    }

    public void setComposer(String copmposer) {
        this.composer = copmposer;
    }

    public void setSongsName(String songsName) {
        this.songsName = songsName;
    }
}
