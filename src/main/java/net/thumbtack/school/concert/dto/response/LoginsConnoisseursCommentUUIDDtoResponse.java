package net.thumbtack.school.concert.dto.response;

import java.util.List;

public class LoginsConnoisseursCommentUUIDDtoResponse {

    private List<String> stringList;

    public LoginsConnoisseursCommentUUIDDtoResponse(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
