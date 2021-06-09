package net.thumbtack.school.concert.dto.request;

public class StopServerDtoRequest {

    private String fileName;

    public StopServerDtoRequest(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
