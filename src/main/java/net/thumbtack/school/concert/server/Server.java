package net.thumbtack.school.concert.server;

import net.thumbtack.school.concert.dao.songDao.SongDaoImpl;
import net.thumbtack.school.concert.dataBase.DataBase;
import net.thumbtack.school.concert.domain.Song;
import net.thumbtack.school.concert.exception.ServerException;
import net.thumbtack.school.concert.service.DataBaseService;
import net.thumbtack.school.concert.service.SongService;
import net.thumbtack.school.concert.service.UserService;

import java.util.List;

public class Server {

    private UserService userService = new UserService();
    private SongService songService = new SongService();
    private DataBaseService dataBaseService = new DataBaseService();

    public void startServer(String stringRequest) {
        dataBaseService.startServer(stringRequest);
    }

    public String registerUser(String requestJsonString) {
        return userService.registerUser(requestJsonString);
    }

    public String getUserByLogin(String requestJsonStringLogin) {
        return userService.getUserByLogin(requestJsonStringLogin);
    }

    public String getOnilneUserByToken(String requestJsonString) {
        return userService.getOnlineUserUUIDString(requestJsonString);
    }

    public String logInUser(String requestJsonString) {
        return userService.logInUser(requestJsonString);
    }

    public void logOutUser(String requestJsonString) {
        userService.logOutUser(requestJsonString);
    }

    // Music

    public String addSong(String request) {
        return songService.addSong(request);
    }

    public String getAllSongsByAuthorLogin(String request) {
        return songService.getAllSongsAuthorLogin(request);
    }

    public void addRatingToTheSong(String requestJsonSongAndRating) {
        songService.addRatingToTheSong(requestJsonSongAndRating);
    }

    public String getSongsRatingBySongName(String stringRequest) {
        return songService.getSongsRatingBySongName(stringRequest);
    }

    public void changeRating(String requestJsonString) {
        songService.changeRating(requestJsonString);
    }

    public void deleteRating(String stringRequest) {
        songService.deleteRating(stringRequest);
    }

    public void cancelProposedSong(String stringRequest) {
        songService.cancelProposedSong(stringRequest);
    }

    public void leaveServer(String stringRequest) throws ServerException {
        userService.leaveServer(stringRequest);
    }

    // Comments

    public String addCommentSong(String stringRequest) {
        return songService.addCommentSong(stringRequest);
    }

    public void addLikeComment(String stringRequest) {
        songService.addLikeComment(stringRequest);
    }

    public void changeComment(String stringRequest) {
        songService.changeComment(stringRequest);
    }

    public String getAllCommentsSongUUID(String stringRequest) {
        return songService.getAllCommentsSongUUID(stringRequest);
    }

    public String getLoginsConnoisseursByCommentUUID(String stringRequest) {
        return songService.getLoginsConnoisseursCommentUUID(stringRequest);
    }

    public String getAllAnnouncedSongs() {
        return songService.getAllAnnouncedSongs();
    }

    public String getAllAnnouncedSongsComposer(String stringRequest) {
        return songService.getAllAnnouncedSongsComposer(stringRequest);
    }

    public String getAllAnnouncedSongsWordWriter(String stringRequest) {
        return songService.getAllAnnouncedSongsWordWriter(stringRequest);
    }

    public String getAllAnnouncedSongsSinger(String stringRequest) {
        return songService.getAllAnnouncedSongsSinger(stringRequest);
    }

    public String getTestProgramConcert() {
        return songService.getTestProgramConcert();
    }

    public void stopServer(String stringRequest) {
        dataBaseService.stopServer(stringRequest);
    }

}
