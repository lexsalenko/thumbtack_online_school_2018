package net.thumbtack.school.concert.dto.request;

public class AllAnnouncedSongsSingerDtoRequest {

    private String singer;

    public AllAnnouncedSongsSingerDtoRequest(String singer) {
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
