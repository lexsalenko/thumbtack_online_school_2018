package net.thumbtack.school.concert.dto.response;

public class ErrorResponse {

    private String errorDescription;

    public ErrorResponse(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

}
