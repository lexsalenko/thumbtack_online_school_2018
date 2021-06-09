package net.thumbtack.school.concert.dto.response;

import java.util.List;

public class SongRatingSongNameDtoResponse {

    private List<Integer> integerList;

    public SongRatingSongNameDtoResponse(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}
