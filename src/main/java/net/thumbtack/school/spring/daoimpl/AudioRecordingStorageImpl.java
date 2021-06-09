package net.thumbtack.school.spring.daoimpl;

import net.thumbtack.school.spring.dao.AudioRecordingStorage;
import net.thumbtack.school.spring.model.Recording;
import org.springframework.stereotype.Component;

@Component
public class AudioRecordingStorageImpl implements AudioRecordingStorage {

    @Override
    public String save(String path) {
        System.out.println("Storing audio, path: " + path);
        return "Storing audio, path: " + path;
    }

    public Recording getRecording(String id){
        System.out.println("Get audio from Audio RecordingForPublication Storage, id: " + id);

        String artist = "Oxxxymiron";
        String trackName = "Неваляшка";
        String albumTitle = "Вечный жид";
        int yearRelease = 2013;
        String linkAlbumCover = "https://ru.wikipedia.org/wiki/%D0%90%D0%B3%D0%B0%D1%81%D1%84%D0%B5%D1%80";
        String genre = "Rap";
        String duration = "269";
        String linkAudioFile = "https://play.google.com/music/preview/Tw7okgkxkgrjjfwiwcmp24swfzy?play=1&u=0";
        String linkVideoFile = "https://www.youtube.com/watch?v=R8j9qmVJ1JA";

        return new Recording(artist, trackName, albumTitle, yearRelease, linkAlbumCover, genre, duration, linkAudioFile, linkVideoFile);
    }

}
