package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.daoimpl.ItunesChannel;
import net.thumbtack.school.spring.daoimpl.YandexMusicChannel;
import net.thumbtack.school.spring.daoimpl.YoutubeMusicChannel;
import net.thumbtack.school.spring.model.Recording;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PublicationService {

    private ItunesChannel itunesChannel;
    private YandexMusicChannel yandexMusicChannel;
    private YoutubeMusicChannel youtubeMusicChannel;

    @Autowired
    public PublicationService(ItunesChannel itunesChannel, YandexMusicChannel yandexMusicChannel, YoutubeMusicChannel youtubeMusicChannel) {
        this.itunesChannel = itunesChannel;
        this.yandexMusicChannel = yandexMusicChannel;
        this.youtubeMusicChannel = youtubeMusicChannel;
    }

    public String publishOnYoutube(Recording recording, ZonedDateTime publishAvailableDate) {
        System.out.println("Publication Service- Publication video: Youtube");

        String artist = recording.getArtist();
        String trackName = recording.getTrackName();
        String albumTitle = recording.getAlbumTitle();
        int yearRelease = recording.getYearRelease();
        String linkAlbumCover = recording.getLinkAlbumCover();
        String genre = recording.getGenre();
        String duration = recording.getDuration();
        String linkAudioFile = recording.getLinkAudioFile();
        String linkVideoFile = recording.getLinkVideoFile();

        RecordingForPublication recordingForPublication = new RecordingForPublication(artist, trackName, albumTitle, yearRelease, linkAlbumCover, genre, duration, linkAudioFile, linkVideoFile);

        return youtubeMusicChannel.publish(recordingForPublication, publishAvailableDate);
    }

    public String publishOnYandexChannel(Recording recording, ZonedDateTime publishAvailableDate) {
        System.out.println("Publication Service - Publication audio: Yandex");

        String artist = recording.getArtist();
        String trackName = recording.getTrackName();
        String albumTitle = recording.getAlbumTitle();
        int yearRelease = recording.getYearRelease();
        String linkAlbumCover = recording.getLinkAlbumCover();
        String genre = recording.getGenre();
        String duration = recording.getDuration();
        String linkAudioFile = recording.getLinkAudioFile();
        String linkVideoFile = recording.getLinkVideoFile();

        RecordingForPublication recordingForPublication = new RecordingForPublication(artist, trackName, albumTitle, yearRelease, linkAlbumCover, genre, duration, linkAudioFile, linkVideoFile);

        return yandexMusicChannel.publish(recordingForPublication, publishAvailableDate);
    }

    public String publishToItunesChannel(Recording recording, ZonedDateTime publishAvailableDate) {
        System.out.println("Publication Service - Publication audio: Itunes");

        String artist = recording.getArtist();
        String trackName = recording.getTrackName();
        String albumTitle = recording.getAlbumTitle();
        int yearRelease = recording.getYearRelease();
        String linkAlbumCover = recording.getLinkAlbumCover();
        String genre = recording.getGenre();
        String duration = recording.getDuration();
        String linkAudioFile = recording.getLinkAudioFile();
        String linkVideoFile = recording.getLinkVideoFile();

        RecordingForPublication recordingForPublication = new RecordingForPublication(artist, trackName, albumTitle, yearRelease, linkAlbumCover, genre, duration, linkAudioFile, linkVideoFile);

        return itunesChannel.publish(recordingForPublication, publishAvailableDate);
    }

    public String deleteFromYoutube(String id) {
        System.out.println("Publication Service - Deleting video: Youtube");
        return youtubeMusicChannel.delete(id);
    }

    public String deleteFromYandexChannel(String id) {
        System.out.println("Publication Service - Deleting audio: Yandex");
        return yandexMusicChannel.delete(id);
    }

    public String deleteFromItunesChannel(String id) {
        System.out.println("Publication Service - Deleting audio: Itunes");
        return itunesChannel.delete(id);
    }

}
