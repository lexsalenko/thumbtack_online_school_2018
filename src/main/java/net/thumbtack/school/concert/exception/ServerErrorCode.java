package net.thumbtack.school.concert.exception;

public enum ServerErrorCode {

    WRONG_TEXT_COMMENT("Wrong comment text"),
    WRONG_COMMENT_AUTHOR_LOGIN("Wrong comment author login"),
    WRONG_SONG_UUID_STRING("Wrong song UUID"),
    WRONG_COMMENT_UUID("Wrong comment UUID"),
    WRONG_LOGIN_AUTHOR_LIKE("Wrong login author like"),
    WRONG_OLD_COMMENT_UUID("Wrong old comment UUID"),
    WRONG_SONG_AUTHOR_LOGIN("Wrong song author login"),
    WRONG_SONGS_NAME("Wrong songs name"),
    WRONG_COMPOSER("Wrong composer"),
    WRONG_WORD_WRITER("Wrong word writer"),
    WRONG_SINGER("Wrong singer"),
    WRONG_SONG_DURATION("Wrong song duration"),
    SONG_ALREADY_ADDED("Song is already added"),
    SONG_DOES_NOT_EXIST("Song does not exist"),
    IMPOSIBLE_TO_CHANGE_OWN_RATING("You cannot add a grade to your own suggestions"),
    WRONG_SONG_AUTHOR_UUID("Wrong song author UUID"),
    WRONG_AUTHOR_ASSESSMENT("Wrong author assessment"),
    WRONG_SONG_RATING("Wrong song rating"),
    WRONG_FIRSTNAME("Wrong first name"),
    WRONG_LASTNAME("Wrong last name"),
    WRONG_LOGIN("Wrong login"),
    WRONG_PASSWORD("Wrong password"),
    WRONG_USER_TOKEN("Wrong user token"),
    USER_ALREADY_EXIST("User already exists"),
    WRONG_FILE_NAME("Wrong file name"),
    FILE_DOES_NOT_EXIST("File does not exist"),
    STOP_SERVER_ERROR("Stop server (write error)"),
    USER_NOT_FOUND("User not found"),
    START_SERVER_ERROR("Start server (read error)");


    private String message;

    private ServerErrorCode(String message) {
        this.message = message;
    }

    public String getErrorString() {
        return message;
    }

}
