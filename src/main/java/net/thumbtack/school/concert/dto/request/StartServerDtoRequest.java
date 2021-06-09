package net.thumbtack.school.concert.dto.request;

public class StartServerDtoRequest {

    private String fileName;

    public StartServerDtoRequest(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
