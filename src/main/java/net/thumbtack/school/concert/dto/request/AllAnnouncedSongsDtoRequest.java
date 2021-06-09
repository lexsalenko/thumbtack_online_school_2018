package net.thumbtack.school.concert.dto.request;

import net.thumbtack.school.concert.domain.Song;

import java.util.List;

public class AllAnnouncedSongsDtoRequest {

    private List<Song> songList;

    public AllAnnouncedSongsDtoRequest(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
