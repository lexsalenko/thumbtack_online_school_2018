package net.thumbtack.school.concert.dto.request;

public class ChangeEstimateDtoRequest {

   private String songAuthorLogin;
   private String songUUIDString;
   private String authorOfTheAssessmentLogin;
   private Integer newSongRating;

    public ChangeEstimateDtoRequest(String songAuthorLogin, String songUUIDString, String authorOfTheAssessmentLogin, Integer newSongRating) {
        this.songAuthorLogin = songAuthorLogin;
        this.songUUIDString = songUUIDString;
        this.authorOfTheAssessmentLogin = authorOfTheAssessmentLogin;
        this.newSongRating = newSongRating;
    }

    public void setSongAuthorLogin(String songAuthorLogin) {
        this.songAuthorLogin = songAuthorLogin;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public void setAuthorOfTheAssessmentLogin(String authorOfTheAssessmentLogin) {
        this.authorOfTheAssessmentLogin = authorOfTheAssessmentLogin;
    }

    public void setNewSongRating(Integer newSongRating) {
        this.newSongRating = newSongRating;
    }

    public String getSongAuthorLogin() {
        return songAuthorLogin;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public String getAuthorOfTheAssessmentLogin() {
        return authorOfTheAssessmentLogin;
    }

    public Integer getNewSongRating() {
        return newSongRating;
    }
}
