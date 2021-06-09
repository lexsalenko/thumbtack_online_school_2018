package net.thumbtack.school.concert.dto.response;

import net.thumbtack.school.concert.domain.Song;

import java.util.List;

public class AnnouncedSongsDtoResponse {

    private List<Song> songList;

    public AnnouncedSongsDtoResponse(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
