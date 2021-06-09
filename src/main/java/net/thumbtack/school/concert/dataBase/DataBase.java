package net.thumbtack.school.concert.dataBase;

import com.google.gson.Gson;
import net.thumbtack.school.concert.domain.*;
import net.thumbtack.school.concert.exception.ServerErrorCode;
import net.thumbtack.school.concert.exception.ServerException;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.io.*;
import java.util.*;

public class DataBase {

    private static DataBase dataBase;
    private static final String COMMUNITY_RADIO_LISTENERS = "Community radio listeners";

    // Users

    private Map<String, User> users; // user login, user
    private Map<String, String> onlineUsers; // user token, user

    // Sogns

    private Map<String, Song> songMap; // SongUUID, Song
    private Map<String, Map<String, Integer>> songRatings; // SongUUID, Map <AuthorOfTheAssessmentLogin, SongRating>
    private MultiValuedMap<String, String> proposalsMultiValuedMap; // songAuthorLogin, songUUID
    private Map<String, String> songAuthors; // Map<songUUID, songAuthorLogin>

    private MultiValuedMap<String, String> composersMultiValuedMap; // composer, songUUIDString
    private MultiValuedMap<String, String> singersMultiValuedMap; // singer, songUUIDString;
    private MultiValuedMap<String, String> wordWritersMultiValuedMap; // wordWriter, songUUIDString;


    private DataBase() {

        //users
        users = new HashMap<>(); // пользователи
        onlineUsers = new HashMap<>(); // пользователи онлайн

        //songs
        songMap = new HashMap<>();
        songRatings = new HashMap<>();
        proposalsMultiValuedMap = new ArrayListValuedHashMap<>();
        songAuthors = new HashMap<>();

        composersMultiValuedMap = new ArrayListValuedHashMap<>();
        singersMultiValuedMap = new ArrayListValuedHashMap<>();
        wordWritersMultiValuedMap = new ArrayListValuedHashMap<>();

        User comunityRadioListeners = new User(COMMUNITY_RADIO_LISTENERS, COMMUNITY_RADIO_LISTENERS, COMMUNITY_RADIO_LISTENERS, COMMUNITY_RADIO_LISTENERS);
        users.put(comunityRadioListeners.getLogin(), comunityRadioListeners);
    }

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }

    public void restartDataBase() {
        //users
        users = new HashMap<>(); // пользователи
        onlineUsers = new HashMap<>(); // пользователи онлайн

        //songs
        songMap = new HashMap<>();
        songRatings = new HashMap<>();
        proposalsMultiValuedMap = new ArrayListValuedHashMap<>();
        songAuthors = new HashMap<>();

        composersMultiValuedMap = new ArrayListValuedHashMap<>();
        singersMultiValuedMap = new ArrayListValuedHashMap<>();
        wordWritersMultiValuedMap = new ArrayListValuedHashMap<>();

        User comunityRadioListeners = new User(COMMUNITY_RADIO_LISTENERS, COMMUNITY_RADIO_LISTENERS, COMMUNITY_RADIO_LISTENERS, COMMUNITY_RADIO_LISTENERS);
        users.put(comunityRadioListeners.getLogin(), comunityRadioListeners);
    }


    // User Methods


    public String registerUser(User user, String userUUIDString) throws ServerException {
        if (users.containsKey(user.getLogin()) || onlineUsers.containsValue(user.getLogin())) {
            throw new ServerException(ServerErrorCode.USER_ALREADY_EXIST);
        }
        users.put(user.getLogin(), user);
        onlineUsers.put(userUUIDString, user.getLogin());
        return userUUIDString;
    }

    public String logInUser(String login, String password, String userUUIDString) throws ServerException {
        User user = users.get(login);
        try {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                onlineUsers.put(userUUIDString, user.getLogin());
            }
        } catch (Exception e) {
            throw new ServerException(ServerErrorCode.USER_NOT_FOUND);
        }
        return userUUIDString;
    }

    public void logOutUser(String userToken) {
        onlineUsers.remove(userToken);
    }

    public User getOnlineUserByToken(String token) {
        String userLogin = onlineUsers.get(token);
        return users.getOrDefault(userLogin, null);
    }

    public User getUserByLogin(String login) {
        return users.get(login);
    }

    public void leaveServer(String userLogin) throws ServerException {
        List<String> songNamesList = new ArrayList<>(proposalsMultiValuedMap.get(userLogin));
        List<String> newSongNamesList = new ArrayList<>(songNamesList);
        onlineUsers.remove(userLogin);
        users.remove(userLogin);
        for (String songName : newSongNamesList) {
            cancelProposedSong(userLogin, songName);
        }
        proposalsMultiValuedMap.remove(userLogin);
    }


    // Song Methods


    public String addSong(String songAuthorLogin, String songUUIDString, Song song) throws ServerException {
        if (songMap.containsValue(song)) {
            throw new ServerException(ServerErrorCode.SONG_ALREADY_ADDED);
        }
        songMap.put(songUUIDString, song);
        Map<String, Integer> map = new HashMap<>();
        map.put(songAuthorLogin, 5);
        songRatings.put(songUUIDString, map);
        proposalsMultiValuedMap.put(songAuthorLogin, songUUIDString);

        songAuthors.put(songUUIDString, songAuthorLogin);

        composersMultiValuedMap.put(song.getComposer(), songUUIDString);
        singersMultiValuedMap.put(song.getSinger(), songUUIDString);
        wordWritersMultiValuedMap.put(song.getWordWriter(), songUUIDString);

        return songUUIDString;
    }

    public List<Song> getAllSongsByAuthorLogin(String songAuthorLogin) {
        List<Song> songList = new ArrayList<>();
        for (String songUUIDString : proposalsMultiValuedMap.get(songAuthorLogin)) {
            songList.add(songMap.get(songUUIDString));
        }
        return songList;
    }

    public void addRatingToTheSong(String songAuthorLogin, String songUUIDString, String authorOfTheAssessmentLogin, Integer songRating) throws ServerException {
        if (songAuthorLogin.equals(authorOfTheAssessmentLogin)) {
            throw new ServerException(ServerErrorCode.IMPOSIBLE_TO_CHANGE_OWN_RATING);
        }
        Map<String, Integer> map = songRatings.get(songUUIDString);
        map.put(authorOfTheAssessmentLogin, songRating);
        songRatings.put(songUUIDString, map);
    }

    public List<Integer> getSongsRatingBySongName(String songAuthorLogin, String songUUIDString) throws ServerException {
        if (!proposalsMultiValuedMap.containsKey(songAuthorLogin)) {
            throw new ServerException(ServerErrorCode.SONG_DOES_NOT_EXIST);
        }
        Map<String, Integer> map = songRatings.get(songUUIDString);
        return new ArrayList<>(map.values());
    }

    public void changeRating(String songAuthorLogin, String songUUIDString, String authorOfAssessmentLogin, Integer newSongRating) throws ServerException {
        if (songAuthorLogin.equals(authorOfAssessmentLogin)) {
            throw new ServerException(ServerErrorCode.IMPOSIBLE_TO_CHANGE_OWN_RATING);
        }
        Map<String, Integer> map = songRatings.get(songUUIDString);
        map.remove(authorOfAssessmentLogin);
        map.put(authorOfAssessmentLogin, newSongRating);
        songRatings.put(songUUIDString, map);
    }

    public void deleteRating(String songUUIDString, String authorAssessmentLogin) throws ServerException {
        if (!songRatings.get(songUUIDString).containsKey(authorAssessmentLogin)) {
            throw new ServerException(ServerErrorCode.SONG_DOES_NOT_EXIST);
        }
        Map<String, Integer> map = songRatings.get(songUUIDString);
        map.remove(authorAssessmentLogin);
        songRatings.put(authorAssessmentLogin, map);
    }

    public void cancelProposedSong(String songAuthorLogin, String songUUIDString) {
        Map<String, Integer> map = songRatings.get(songUUIDString);
        if (map.size() == 1) {
            songMap.remove(songUUIDString);
            songRatings.remove(songUUIDString);
        } else {
            proposalsMultiValuedMap.put(COMMUNITY_RADIO_LISTENERS, songUUIDString);
            map.remove(songAuthorLogin);
        }
        proposalsMultiValuedMap.removeMapping(songAuthorLogin, songUUIDString);
    }


    // comments


    public String addCommentSong(String songUUIDString, String commentUUIDString, Comment comment) {
        Song song = songMap.get(songUUIDString);
        Map<String, Comment> commentMap = song.getCommentMap();
        commentMap.put(commentUUIDString, comment);
        song.setCommentMap(commentMap);
        return commentUUIDString;
    }

    public List<String> getAllCommentsSongUUID(String songUUIDString) {
        Song song = songMap.get(songUUIDString);
        Map<String, Comment> commentMap = song.getCommentMap();
        List<String> list = new ArrayList<>();
        for (Comment comment : commentMap.values()) {
            list.add(comment.getComment());
        }
        return list;
    }

    public void addLikeComment(String songUUIDString, String commentUUIDString, String loginAuthorLike) {
        Song song = songMap.get(songUUIDString);
        Map<String, Comment> commentMap = song.getCommentMap();
        Comment comment = commentMap.get(commentUUIDString);
        List<String> stringList = comment.getJoinedComments();
        stringList.add(loginAuthorLike);
    }

    public List<String> getLoginsConnoisseursByCommentUUID(String songUUIDString, String commentUUIDString) {
        Song song = songMap.get(songUUIDString);
        Map<String, Comment> commentMap = song.getCommentMap();
        Comment comment = commentMap.get(commentUUIDString);
        return comment.getJoinedComments();
    }

    public void changeComment(String songUUIDString, String oldCommentUUIDString, String newCommentUUIDString, Comment newComment) {
        Song song = songMap.get(songUUIDString);
        Map<String, Comment> commentMap = song.getCommentMap();
        Comment comment = commentMap.get(oldCommentUUIDString);
        List<String> stringList = comment.getJoinedComments();
        if (stringList.size() == 0) {
            commentMap.remove(oldCommentUUIDString);
            commentMap.put(newCommentUUIDString, newComment);
        } else {
            commentMap.remove(oldCommentUUIDString);
            comment.setCommentAuthorLogin(COMMUNITY_RADIO_LISTENERS);
            commentMap.put(newCommentUUIDString, newComment);
            commentMap.put(oldCommentUUIDString, comment);
        }
    }

    public List<SongInfoConcert> getTestProgramConcert() {
        List<String> songNameList = new ArrayList<>(songRatings.keySet());
        List<SongConcert> songConcertList = new ArrayList<>();
        for (String songName : songNameList) {
            List<Integer> integerList = new ArrayList<>(songRatings.get(songName).values());
            songConcertList.add(new SongConcert(songName, getSumList(integerList), getAverageRatingSong(integerList)));
        }

        songConcertList.sort(Comparator.comparing(SongConcert::getSumAllEstimates));
        Collections.reverse(songConcertList);

        List<SongInfoConcert> songInfoConcertList = new ArrayList<>();

        int timeConcert = 0;

        for (SongConcert songConcert : songConcertList) {
            if (songMap.get(songConcert.getSongUUIDString()).getLengthSong() < 3600 - timeConcert) {
                Song song = songMap.get(songConcert.getSongUUIDString());
                User user = users.get(songAuthors.get(songConcert.getSongUUIDString()));
                SongInfoConcert songInfoConcert = new SongInfoConcert(song.getSongName(), song.getComposer(), song.getWordWriter(), song.getSinger(), user.getFirstName(), user.getLastName(), user.getLogin(), songConcert.getAverageRatingSongs(), new ArrayList<>(song.getCommentMap().values()));

                timeConcert += song.getLengthSong();
                timeConcert += 10;

                songInfoConcertList.add(songInfoConcert);
            }
        }
        return songInfoConcertList;
    }

    private int getSumList(List<Integer> integerList) {
        int sum = 0;
        for (Integer elem : integerList) {
            sum += elem;
        }
        return sum;
    }

    private int getAverageRatingSong(List<Integer> integerList) {
        int sum = 0;
        for (Integer elem : integerList) {
            sum += elem;
        }
        return sum / integerList.size();
    }

    public List<Song> getAllAnnouncedSongs() {
        return new ArrayList<>(songMap.values());
    }

    public List<Song> getAllAnnouncedSongsComposer(String composer) {
        List<Song> songListComposer = new ArrayList<>();
        for (String songUUIDString : composersMultiValuedMap.get(composer)) {
            songListComposer.add(songMap.get(songUUIDString));
        }
        return songListComposer;
    }

    public List<Song> getAllAnnouncedSongsWordWriter(String wordWriter) {
        List<Song> songListWordWriter = new ArrayList<>();
        for (String songUUIDString : wordWritersMultiValuedMap.get(wordWriter)) {
            songListWordWriter.add(songMap.get(songUUIDString));
        }
        return songListWordWriter;
    }

    public List<Song> getAllAnnouncedSongsSinger(String singer) {
        List<Song> songListSinger = new ArrayList<>();
        for (String songUUIDString : singersMultiValuedMap.get(singer)) {
            songListSinger.add(songMap.get(songUUIDString));
        }
        return songListSinger;
    }

    public void startServer(String savedDataFileName, Gson gson) throws ServerException {
        if (savedDataFileName == null || savedDataFileName.length() == 0) {
            dataBase.restartDataBase();
        } else {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(savedDataFileName)))) {
                gson.toJson(dataBase, bw);
            } catch (IOException e) {
                throw new ServerException(ServerErrorCode.START_SERVER_ERROR);
            }
        }
    }

    public void stopServer(String savedDataFileName, Gson gson) throws ServerException {
        if (savedDataFileName != null || savedDataFileName.length() == 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(new File(savedDataFileName)))) {
                dataBase = gson.fromJson(br, DataBase.class);
            } catch (IOException e) {
                throw new ServerException(ServerErrorCode.STOP_SERVER_ERROR);
            }
        }
    }
}
