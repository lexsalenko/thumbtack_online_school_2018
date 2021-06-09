package net.thumbtack.school.concert.service;

import com.google.gson.Gson;
import net.thumbtack.school.concert.dao.songDao.SongDao;
import net.thumbtack.school.concert.dao.songDao.SongDaoImpl;
import net.thumbtack.school.concert.dao.userDao.UserDao;
import net.thumbtack.school.concert.dao.userDao.UserDaoImpl;
import net.thumbtack.school.concert.domain.Proposal;
import net.thumbtack.school.concert.domain.Song;
import net.thumbtack.school.concert.domain.SongInfoConcert;
import net.thumbtack.school.concert.domain.User;
import net.thumbtack.school.concert.dto.request.*;
import net.thumbtack.school.concert.dto.response.*;
import net.thumbtack.school.concert.exception.ServerException;
import net.thumbtack.school.concert.validators.Validator;

import java.util.List;
import java.util.UUID;

public class SongService {

    private SongDao songDao = new SongDaoImpl();
    private Gson gson = new Gson();

    public void setSongDao(SongDao songDao) {
        this.songDao = songDao;
    }


    public String addSong(String request) {
        try {
            UUID songUUID = UUID.randomUUID();
            Proposal proposal = gson.fromJson(request, Proposal.class);
            Validator.validateProposal(proposal);
            String songUUIDString = songDao.addSong(proposal.getSongAuthorLogin(), songUUID.toString(), proposal.getSong());
            AddSongDtoResponse addSongDtoResponse = new AddSongDtoResponse(songUUIDString);
            return gson.toJson(addSongDtoResponse);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getAllSongsAuthorLogin(String requestJsonSongAndRating) {
        try {
            AllSongsByAuthorLoginDtoRequest allSongsByAuthorLoginDtoRequest
                    = gson.fromJson(requestJsonSongAndRating, AllSongsByAuthorLoginDtoRequest.class);
            Validator.validateUserLogin(allSongsByAuthorLoginDtoRequest.getUserLogin());
            List<Song> songList = songDao.getAllSongsByAuthorLogin(allSongsByAuthorLoginDtoRequest.getUserLogin());
            System.out.println(songList.size());
            AllSongsAuthorLoginDtoResponse response = new AllSongsAuthorLoginDtoResponse(songList);
            return gson.toJson(response);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String addRatingToTheSong(String requestJsonSongAndRating) {
        try {
            AddRatingSongDtoRequest addRatingSongDtoRequest
                    = gson.fromJson(requestJsonSongAndRating, AddRatingSongDtoRequest.class);
            Validator.validateAddRatingSong(addRatingSongDtoRequest);
            songDao.addRatingToTheSong(
                    addRatingSongDtoRequest.getSongAuthorUUIDString(),
                    addRatingSongDtoRequest.getSongUUIDString(),
                    addRatingSongDtoRequest.getAuthorOfTheAssessment(),
                    addRatingSongDtoRequest.getSongRating());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getSongsRatingBySongName(String stringRequest) {
        try {
            SongRatingBySongNameDtoRequest songRatingBySongNameDtoRequest
                    = gson.fromJson(stringRequest, SongRatingBySongNameDtoRequest.class);
            Validator.validatorSongsRatingBySongName(songRatingBySongNameDtoRequest);
            List<Integer> integerList = songDao.getSongsRatingBySongName(
                    songRatingBySongNameDtoRequest.getSongAuthorLogin(),
                    songRatingBySongNameDtoRequest.getSongUUIDString());
            SongRatingSongNameDtoResponse response = new SongRatingSongNameDtoResponse(integerList);
            return gson.toJson(response);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }


    public String changeRating(String requestJsonString) {
        try {
            ChangeEstimateDtoRequest changeEstimateDtoRequest
                    = gson.fromJson(requestJsonString, ChangeEstimateDtoRequest.class);

            Validator.validateChangeRating(changeEstimateDtoRequest);

            songDao.changeRating(
                    changeEstimateDtoRequest.getSongAuthorLogin(),
                    changeEstimateDtoRequest.getSongUUIDString(),
                    changeEstimateDtoRequest.getAuthorOfTheAssessmentLogin(),
                    changeEstimateDtoRequest.getNewSongRating());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String deleteRating(String stringRequest) {
        try {
            DeleteRatingDtoRequest deleteRatingDtoRequest = gson.fromJson(stringRequest, DeleteRatingDtoRequest.class);
            Validator.validateDeleteRating(deleteRatingDtoRequest);
            songDao.deleteRating(
                    deleteRatingDtoRequest.getSongUUIDString(),
                    deleteRatingDtoRequest.getAuthorAssessmentLogin());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String cancelProposedSong(String stringRequest) {
        try {
            CancelProposedSongDtoRequest cancelProposedSongDtoRequest
                    = gson.fromJson(stringRequest, CancelProposedSongDtoRequest.class);
            Validator.validateCancelProposedSong(cancelProposedSongDtoRequest);
            songDao.cancelProposedSong(
                    cancelProposedSongDtoRequest.getSongAuthorLogin(),
                    cancelProposedSongDtoRequest.getSongUUIDString());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    // Comments

    public String addCommentSong(String stringRequest) {
        try {
            UUID commentUUIDString = UUID.randomUUID();
            AddCommentSongDtoRequest addCommentSongDtoRequest
                    = gson.fromJson(stringRequest, AddCommentSongDtoRequest.class);
            Validator.validateComment(addCommentSongDtoRequest.getComment());
            String response = songDao.addCommentSong(
                    addCommentSongDtoRequest.getSongUUIDString(),
                    commentUUIDString.toString(),
                    addCommentSongDtoRequest.getComment());
            AddCommentSongDtoResponse addCommentSongDtoResponse = new AddCommentSongDtoResponse(response);
            return gson.toJson(addCommentSongDtoResponse);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getAllCommentsSongUUID(String stringRequest) {
        try {
            AllCommentsSongUUIDDtoRequest allCommentsSongUUIDDtoRequest
                    = gson.fromJson(stringRequest, AllCommentsSongUUIDDtoRequest.class);
            Validator.validateUUID(allCommentsSongUUIDDtoRequest.getSongUUIDString());
            List<String> stringList = songDao.getAllCommentsSongUUID(allCommentsSongUUIDDtoRequest.getSongUUIDString());
            AllCommentsSongUUIDDtoResponse response = new AllCommentsSongUUIDDtoResponse(stringList);
            return gson.toJson(response);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String addLikeComment(String stringRequest) {
        try {
            AddLikeCommentDtoRequest addLikeCommentDtoRequest = gson.fromJson(stringRequest, AddLikeCommentDtoRequest.class);
            Validator.validateAddLikeComment(addLikeCommentDtoRequest);
            // REVU: слишком длинная строка (длинее 120 символов) - нужно разбить на две.
            // таких строк довольно много в сервисах
            songDao.addLikeComment(
                    addLikeCommentDtoRequest.getSongUUIDString(),
                    addLikeCommentDtoRequest.getCommentUUIDString(),
                    addLikeCommentDtoRequest.getLoginAuthorLike());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String changeComment(String stringRequest) {
        try {
            ChangeCommentDtoRequest changeCommentDtoRequest = gson.fromJson(stringRequest, ChangeCommentDtoRequest.class);
            UUID newCommentUUIDString = UUID.randomUUID();
            Validator.validateChangeComment(changeCommentDtoRequest);
            songDao.changeComment(
                    changeCommentDtoRequest.getSongUUIDString(),
                    changeCommentDtoRequest.getOldCommentUUIDString(),
                    newCommentUUIDString.toString(),
                    changeCommentDtoRequest.getNewComment());
            return gson.toJson(new SuccessResponse());
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getLoginsConnoisseursCommentUUID(String stringRequest) {
        try {
            LoginsConnoisseursCommentUUIDDtoRequest loginsConnoisseursCommentUUIDDtoRequest
                    = gson.fromJson(stringRequest, LoginsConnoisseursCommentUUIDDtoRequest.class);
            Validator.validateLoginsConnoisseursComment(loginsConnoisseursCommentUUIDDtoRequest);
            List<String> stringList = songDao.getLoginsConnoisseursByCommentUUID(
                    loginsConnoisseursCommentUUIDDtoRequest.getSongUUIDString(),
                    loginsConnoisseursCommentUUIDDtoRequest.getCommentUUIDString());
            LoginsConnoisseursCommentUUIDDtoResponse response = new LoginsConnoisseursCommentUUIDDtoResponse(stringList);
            return gson.toJson(response);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getAllAnnouncedSongs() {
        List<Song> songList = songDao.getAllAnnouncedSongs();
        AnnouncedSongsDtoResponse response = new AnnouncedSongsDtoResponse(songList);
        return gson.toJson(response);
    }

    public String getAllAnnouncedSongsComposer(String stringRequest) {
        try {
            AllAnnouncedSongsComposerDtoRequest allAnnouncedSongsComposerDtoRequest
                    = gson.fromJson(stringRequest, AllAnnouncedSongsComposerDtoRequest.class);
            Validator.validateComposer(allAnnouncedSongsComposerDtoRequest.getComposer());
            List<Song> songList = songDao.getAllAnnouncedSongsComposer(allAnnouncedSongsComposerDtoRequest.getComposer());
            AnnouncedSongsDtoResponse response = new AnnouncedSongsDtoResponse(songList);
            return gson.toJson(response);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getAllAnnouncedSongsWordWriter(String stringRequest) {
        try {
            AllAnnouncedSongsWordWriterDtoRequest allAnnouncedSongsWordWriterDtoRequest
                    = gson.fromJson(stringRequest, AllAnnouncedSongsWordWriterDtoRequest.class);
            Validator.validateWordWriter(allAnnouncedSongsWordWriterDtoRequest.getWordWriter());
            List<Song> songList = songDao.getAllAnnouncedSongsWordWriter(allAnnouncedSongsWordWriterDtoRequest.getWordWriter());
            AnnouncedSongsDtoResponse response = new AnnouncedSongsDtoResponse(songList);
            return gson.toJson(response);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getAllAnnouncedSongsSinger(String stringRequest) {
        try {
            AllAnnouncedSongsSingerDtoRequest allAnnouncedSongsSingerDtoRequest
                    = gson.fromJson(stringRequest, AllAnnouncedSongsSingerDtoRequest.class);
            Validator.validateSinger(allAnnouncedSongsSingerDtoRequest.getSinger());
            List<Song> songList = songDao.getAllAnnouncedSongsSinger(allAnnouncedSongsSingerDtoRequest.getSinger());
            AnnouncedSongsDtoResponse response = new AnnouncedSongsDtoResponse(songList);
            return gson.toJson(response);
        } catch (ServerException se) {
            return gson.toJson(new ErrorResponse(se.getServerErrorCode().getErrorString()));
        }
    }

    public String getTestProgramConcert() {
        List<SongInfoConcert> songInfoConcertList = songDao.getTestProgramConcert();
        TestProgramConcertDtoResponse response = new TestProgramConcertDtoResponse(songInfoConcertList);
        return gson.toJson(response);
    }

    public int getList(User user) throws Exception {
        UserDaoImpl userDao = new UserDaoImpl();
        String token = UUID.randomUUID().toString();
        userDao.registerUser(user, token);
        List<Song> songList = songDao.getAllSongsByAuthorLogin(user.getLogin());
        userDao.leaveServer(gson.toJson(new LeaveServerDtoRequest(user.getLogin())));
        return songList.size();
    }


}
