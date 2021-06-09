package net.thumbtack.school.concert.dto.response;

public class AddSongDtoResponse {

    private String songUUIDString;

    public AddSongDtoResponse(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }
}
