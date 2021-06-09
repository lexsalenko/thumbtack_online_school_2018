package net.thumbtack.school.concert.dto.request;

public class AddRatingSongDtoRequest {

    private String songAuthorUUIDString;
    private String songUUIDString;
    private String authorOfTheAssessment;
    private Integer songRating;

    public AddRatingSongDtoRequest(String songAuthorUUIDString, String songUUIDString, String authorOfTheAssessment, Integer songRating) {
        this.songAuthorUUIDString = songAuthorUUIDString;
        this.songUUIDString = songUUIDString;
        this.authorOfTheAssessment = authorOfTheAssessment;
        this.songRating = songRating;
    }

    public void setSongAuthorUUIDString(String songAuthorUUIDString) {
        this.songAuthorUUIDString = songAuthorUUIDString;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public void setAuthorOfTheAssessment(String authorOfTheAssessment) {
        this.authorOfTheAssessment = authorOfTheAssessment;
    }

    public void setSongRating(Integer songRating) {
        this.songRating = songRating;
    }

    public String getSongAuthorUUIDString() {
        return songAuthorUUIDString;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public String getAuthorOfTheAssessment() {
        return authorOfTheAssessment;
    }

    public Integer getSongRating() {
        return songRating;
    }
}
