package net.thumbtack.school.concert.dto.request;

public class DeleteRatingDtoRequest {

    private String songUUIDString;
    private String authorAssessmentLogin;

    public DeleteRatingDtoRequest(String songUUIDString, String authorAssessmentLogin) {
        this.songUUIDString = songUUIDString;
        this.authorAssessmentLogin = authorAssessmentLogin;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public void setAuthorAssessmentLogin(String authorAssessmentLogin) {
        this.authorAssessmentLogin = authorAssessmentLogin;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public String getAuthorAssessmentLogin() {
        return authorAssessmentLogin;
    }
}
