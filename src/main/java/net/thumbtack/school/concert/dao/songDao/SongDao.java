package net.thumbtack.school.concert.dao.songDao;

import net.thumbtack.school.concert.domain.Comment;
import net.thumbtack.school.concert.domain.Song;
import net.thumbtack.school.concert.domain.SongInfoConcert;
import net.thumbtack.school.concert.exception.ServerException;

import java.util.List;

public interface SongDao {

    String addSong(String songAuthorLogin, String songUUIDString, Song song) throws ServerException;

    List<Song> getAllSongsByAuthorLogin(String songAuthorLogin);

    void addRatingToTheSong(String songAuthorLogin, String songUUIDString, String authorOfTheAssessmentLogin, Integer songRating) throws ServerException;

    void changeRating(String songAuthorLogin, String songUUIDString, String authorOfAssessmentLogin, Integer newSongRating) throws ServerException;

    List<Integer> getSongsRatingBySongName(String songAuthorLogin, String songUUIDString) throws ServerException;

    void deleteRating(String songUUIDString, String authorAssessmentLogin) throws ServerException;

    void cancelProposedSong(String songAuthorLogin, String songUUIDString);

    String addCommentSong(String songUUIDString, String commentUUIDString, Comment comment);

    List<String> getAllCommentsSongUUID(String songUUIDString);

    void addLikeComment(String songUUIDString, String commentUUIDString, String loginAuthorLike);

    void changeComment(String songUUIDString, String oldCommentUUIDString, String newCommentUUIDString, Comment newComment);

    List<String> getLoginsConnoisseursByCommentUUID(String songUUIDString, String commentUUIDString);

    List<Song> getAllAnnouncedSongs();

    List<Song> getAllAnnouncedSongsComposer(String composer);

    List<Song> getAllAnnouncedSongsWordWriter(String wordWriter);

    List<Song> getAllAnnouncedSongsSinger(String singer);

    List<SongInfoConcert> getTestProgramConcert();

}
