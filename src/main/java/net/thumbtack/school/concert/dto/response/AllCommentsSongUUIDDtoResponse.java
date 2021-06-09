package net.thumbtack.school.concert.dto.response;

import java.util.List;

public class AllCommentsSongUUIDDtoResponse {

    private List<String> stringList;

    public AllCommentsSongUUIDDtoResponse(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
