package net.thumbtack.school.concert.dao.songDao;

import net.thumbtack.school.concert.dataBase.DataBase;
import net.thumbtack.school.concert.domain.Comment;
import net.thumbtack.school.concert.domain.Song;
import net.thumbtack.school.concert.domain.SongInfoConcert;
import net.thumbtack.school.concert.exception.ServerException;

import java.util.List;

public class SongDaoImpl implements SongDao {

    private DataBase dataBase = DataBase.getInstance();

    @Override
    public String addSong(String songAuthorLogin, String songUUIDString, Song song) throws ServerException {
        return dataBase.addSong(songAuthorLogin, songUUIDString, song);
    }

    @Override
    public List<Song> getAllSongsByAuthorLogin(String songAuthorLogin) {
        return dataBase.getAllSongsByAuthorLogin(songAuthorLogin);
    }

    @Override
    public void addRatingToTheSong(String songAuthorLogin, String songUUIDString, String authorOfTheAssessmentLogin, Integer songRating) throws ServerException {
        dataBase.addRatingToTheSong(songAuthorLogin, songUUIDString, authorOfTheAssessmentLogin, songRating);
    }

    @Override
    public List<Integer> getSongsRatingBySongName(String songAuthorLogin, String songUUIDString) throws ServerException {
        return dataBase.getSongsRatingBySongName(songAuthorLogin, songUUIDString);
    }


    @Override
    public void changeRating(String songAuthorLogin, String songUUIDString, String authorOfAssessmentLogin, Integer newSongRating) throws ServerException {
        dataBase.changeRating(songAuthorLogin, songUUIDString, authorOfAssessmentLogin, newSongRating);
    }

    @Override
    public void deleteRating(String songUUIDString, String authorAssessmentLogin) throws ServerException {
        dataBase.deleteRating(songUUIDString, authorAssessmentLogin);
    }

    @Override
    public void cancelProposedSong(String songAuthorLogin, String songUUIDString) {
        dataBase.cancelProposedSong(songAuthorLogin, songUUIDString);
    }

    // Comments
    @Override
    public String addCommentSong(String songUUIDString, String commentUUIDString, Comment comment) {
        return dataBase.addCommentSong(songUUIDString, commentUUIDString, comment);
    }

    @Override
    public List<String> getAllCommentsSongUUID(String songUUIDString) {
        return dataBase.getAllCommentsSongUUID(songUUIDString);
    }

    @Override
    public void addLikeComment(String songUUIDString, String commentUUIDString, String loginAuthorLike) {
        dataBase.addLikeComment(songUUIDString, commentUUIDString, loginAuthorLike);
    }

    @Override
    public void changeComment(String songUUIDString, String oldCommentUUIDString, String newCommentUUIDString, Comment newComment) {
        dataBase.changeComment(songUUIDString, oldCommentUUIDString, newCommentUUIDString, newComment);
    }

    @Override
    public List<String> getLoginsConnoisseursByCommentUUID(String songUUIDString, String commentUUIDString) {
        return dataBase.getLoginsConnoisseursByCommentUUID(songUUIDString, commentUUIDString);
    }

    @Override
    public List<Song> getAllAnnouncedSongs() {
        return dataBase.getAllAnnouncedSongs();
    }

    @Override
    public List<Song> getAllAnnouncedSongsComposer(String composer) {
        return dataBase.getAllAnnouncedSongsComposer(composer);
    }

    @Override
    public List<Song> getAllAnnouncedSongsWordWriter(String wordWriter) {
        return dataBase.getAllAnnouncedSongsWordWriter(wordWriter);
    }

    @Override
    public List<Song> getAllAnnouncedSongsSinger(String singer) {
        return dataBase.getAllAnnouncedSongsSinger(singer);
    }

    @Override
    public List<SongInfoConcert> getTestProgramConcert() {
        return dataBase.getTestProgramConcert();
    }

}
