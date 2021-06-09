package net.thumbtack.school.concert.dto.request;

public class AllCommentsSongUUIDDtoRequest {

    private String songUUIDString;

    public AllCommentsSongUUIDDtoRequest(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }
}
