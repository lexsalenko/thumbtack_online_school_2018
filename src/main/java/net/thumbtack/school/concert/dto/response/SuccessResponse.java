package net.thumbtack.school.concert.dto.response;

public class SuccessResponse {

    private String description;

    public SuccessResponse() {
        this.description = "Success";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
