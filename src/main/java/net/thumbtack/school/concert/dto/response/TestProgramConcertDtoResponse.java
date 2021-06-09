package net.thumbtack.school.concert.dto.response;

import net.thumbtack.school.concert.domain.SongInfoConcert;
import java.util.List;

public class TestProgramConcertDtoResponse {

    private List<SongInfoConcert> songInfoConcertList;

    public TestProgramConcertDtoResponse(List<SongInfoConcert> songInfoConcertList) {
        this.songInfoConcertList = songInfoConcertList;
    }

    public List<SongInfoConcert> getSongInfoConcertList() {
        return songInfoConcertList;
    }

    public void setSongInfoConcertList(List<SongInfoConcert> songInfoConcertList) {
        this.songInfoConcertList = songInfoConcertList;
    }
}
