package net.thumbtack.school.concert.validators;

import net.thumbtack.school.concert.domain.Comment;
import net.thumbtack.school.concert.domain.Proposal;
import net.thumbtack.school.concert.dto.request.*;
import net.thumbtack.school.concert.exception.ServerErrorCode;
import net.thumbtack.school.concert.exception.ServerException;

import java.io.File;

public class Validator {

    public static void validateProposal(Proposal proposal) throws ServerException {
        if (proposal.getSongAuthorLogin() == null || proposal.getSongAuthorLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_AUTHOR_LOGIN);
        }
        if (proposal.getSong().getSongName() == null || proposal.getSong().getSongName().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONGS_NAME);
        }
        if (proposal.getSong().getComposer() == null || proposal.getSong().getComposer().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_COMPOSER);
        }
        if (proposal.getSong().getWordWriter() == null || proposal.getSong().getWordWriter().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_WORD_WRITER);
        }
        if (proposal.getSong().getSinger() == null || proposal.getSong().getSinger().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SINGER);
        }
        if (proposal.getSong().getLengthSong() < 0 || proposal.getSong().getLengthSong() > 3600) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_DURATION);
        }
    }

    public static void validateUserLogin(String userLogin) throws ServerException {
        if (userLogin == null || userLogin.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_LOGIN);
        }
    }

    public static void validateUserUUIDString(String userToken) throws ServerException {
        if (userToken == null || userToken.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_USER_TOKEN);
        }
    }

    public static void validateUserLPassword(String userPassword) throws ServerException {
        if (userPassword == null || userPassword.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_PASSWORD);
        }
    }

    public static void validateAddRatingSong(AddRatingSongDtoRequest addRatingSongDtoRequest) throws ServerException {
        // REVU: слишком длинная строка
        if (addRatingSongDtoRequest.getSongAuthorUUIDString() == null
                || addRatingSongDtoRequest.getSongAuthorUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_AUTHOR_UUID);
        }
        if (addRatingSongDtoRequest.getSongUUIDString() == null
                || addRatingSongDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
        if (addRatingSongDtoRequest.getAuthorOfTheAssessment() == null
                || addRatingSongDtoRequest.getAuthorOfTheAssessment().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_AUTHOR_ASSESSMENT);
        }
        if (addRatingSongDtoRequest.getSongRating() > 5
                || addRatingSongDtoRequest.getSongRating() < 1) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_RATING);
        }
    }

    public static void validatorSongsRatingBySongName(SongRatingBySongNameDtoRequest songRatingBySongNameDtoRequest) throws ServerException {
        if (songRatingBySongNameDtoRequest.getSongAuthorLogin() == null
                || songRatingBySongNameDtoRequest.getSongAuthorLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_LOGIN);
        }
        if (songRatingBySongNameDtoRequest.getSongUUIDString() == null
                || songRatingBySongNameDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
    }

    public static void validateChangeRating(ChangeEstimateDtoRequest changeEstimateDtoRequest) throws ServerException {
        if (changeEstimateDtoRequest.getSongAuthorLogin() == null
                || changeEstimateDtoRequest.getSongAuthorLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_AUTHOR_LOGIN);
        }
        if (changeEstimateDtoRequest.getSongUUIDString() == null
                || changeEstimateDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
        if (changeEstimateDtoRequest.getAuthorOfTheAssessmentLogin() == null
                || changeEstimateDtoRequest.getAuthorOfTheAssessmentLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_AUTHOR_ASSESSMENT);
        }
        if (changeEstimateDtoRequest.getNewSongRating() < 1
                || changeEstimateDtoRequest.getNewSongRating() > 5) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_RATING);
        }
    }

    public static void validateDeleteRating(DeleteRatingDtoRequest deleteRatingDtoRequest) throws ServerException {
        if (deleteRatingDtoRequest.getAuthorAssessmentLogin() == null
                || deleteRatingDtoRequest.getAuthorAssessmentLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_AUTHOR_ASSESSMENT);
        }
        if (deleteRatingDtoRequest.getSongUUIDString() == null
                || deleteRatingDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
    }

    public static void validateCancelProposedSong(CancelProposedSongDtoRequest cancelProposedSongDtoRequest) throws ServerException {
        if (cancelProposedSongDtoRequest.getSongAuthorLogin() == null
                || cancelProposedSongDtoRequest.getSongAuthorLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_AUTHOR_LOGIN);
        }
        if (cancelProposedSongDtoRequest.getSongUUIDString() == null
                || cancelProposedSongDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
    }

    public static void validateComment(Comment comment) throws ServerException {
        if (comment.getComment() == null || comment.getComment().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_TEXT_COMMENT);
        }
        if (comment.getCommentAuthorLogin() == null || comment.getCommentAuthorLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_COMMENT_AUTHOR_LOGIN);
        }

    }

    public static void validateUUID(String UUIDString) throws ServerException {
        if (UUIDString == null || UUIDString.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
    }

    public static void validateAddLikeComment(AddLikeCommentDtoRequest addLikeCommentDtoRequest) throws ServerException {
        if (addLikeCommentDtoRequest.getSongUUIDString() == null
                || addLikeCommentDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
        if (addLikeCommentDtoRequest.getCommentUUIDString() == null
                || addLikeCommentDtoRequest.getCommentUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_COMMENT_UUID);
        }
        if (addLikeCommentDtoRequest.getLoginAuthorLike() == null
                || addLikeCommentDtoRequest.getLoginAuthorLike().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_LOGIN_AUTHOR_LIKE);
        }
    }

    public static void validateChangeComment(ChangeCommentDtoRequest changeCommentDtoRequest) throws ServerException {
        if (changeCommentDtoRequest.getSongUUIDString() == null
                || changeCommentDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
        if (changeCommentDtoRequest.getOldCommentUUIDString() == null
                || changeCommentDtoRequest.getOldCommentUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_OLD_COMMENT_UUID);
        }
        validateComment(changeCommentDtoRequest.getNewComment());
    }

    public static void validateLoginsConnoisseursComment(LoginsConnoisseursCommentUUIDDtoRequest loginsConnoisseursCommentUUIDDtoRequest) throws ServerException {
        if (loginsConnoisseursCommentUUIDDtoRequest.getSongUUIDString() == null
                || loginsConnoisseursCommentUUIDDtoRequest.getSongUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SONG_UUID_STRING);
        }
        if (loginsConnoisseursCommentUUIDDtoRequest.getCommentUUIDString() == null
                || loginsConnoisseursCommentUUIDDtoRequest.getCommentUUIDString().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_COMMENT_UUID);
        }
    }

    public static void validateComposer(String composer) throws ServerException {
        if (composer == null || composer.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_COMPOSER);
        }
    }

    public static void validateSinger(String singer) throws ServerException {
        if (singer == null || singer.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_SINGER);
        }
    }

    public static void validateWordWriter(String wordWriter) throws ServerException {
        if (wordWriter == null || wordWriter.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_WORD_WRITER);
        }
    }

    public static void validateRegisterUser(RegisterUserDtoRequest registerUserDtoRequest) throws ServerException {
        if (registerUserDtoRequest.getFirstName() == null || registerUserDtoRequest.getFirstName().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_FIRSTNAME);
        }
        if (registerUserDtoRequest.getLastName() == null || registerUserDtoRequest.getLastName().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_LASTNAME);
        }
        if (registerUserDtoRequest.getLogin() == null || registerUserDtoRequest.getLogin().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_LOGIN);
        }
        if (registerUserDtoRequest.getPassword() == null || registerUserDtoRequest.getPassword().length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_PASSWORD);
        }
    }

    public static void validateFile(String fileName) throws ServerException {
        if (fileName == null || fileName.length() == 0) {
            throw new ServerException(ServerErrorCode.WRONG_FILE_NAME);
        }
        if (!new File(fileName).exists()) {
            throw new ServerException(ServerErrorCode.FILE_DOES_NOT_EXIST);
        }
    }

}