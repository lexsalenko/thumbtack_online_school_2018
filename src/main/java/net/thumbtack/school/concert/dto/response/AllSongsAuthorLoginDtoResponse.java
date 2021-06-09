package net.thumbtack.school.concert.dto.response;

import net.thumbtack.school.concert.domain.Song;

import java.util.List;
import java.util.Objects;

public class AllSongsAuthorLoginDtoResponse {

    private List<Song> songList;

    public AllSongsAuthorLoginDtoResponse(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllSongsAuthorLoginDtoResponse that = (AllSongsAuthorLoginDtoResponse) o;
        return Objects.equals(songList, that.songList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songList);
    }
}
