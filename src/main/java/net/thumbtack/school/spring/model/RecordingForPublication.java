package net.thumbtack.school.spring.model;

import net.thumbtack.school.spring.validator.Link;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RecordingForPublication {

    @NotNull
    @Size(min=5, max=30)
    private String artist;
    @NotNull
    private String trackName;
    private String albumTitle;
    @NotNull
    @Min(1970)
    private int yearRelease;
    private String linkAlbumCover;
    private String genre;
    @NotNull
    private String duration;
    @Link
    private String linkAudioFile;
    private String linkVideoFile;

    public RecordingForPublication() {
    }

    public RecordingForPublication(String artist, String trackName, String albumTitle, int yearRelease, String linkAlbumCover, String genre, String duration, String linkAudioFile, String linkVideoFile) {
        this.artist = artist;
        this.trackName = trackName;
        this.albumTitle = albumTitle;
        this.yearRelease = yearRelease;
        this.linkAlbumCover = linkAlbumCover;
        this.genre = genre;
        this.duration = duration;
        this.linkAudioFile = linkAudioFile;
        this.linkVideoFile = linkVideoFile;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getLinkAlbumCover() {
        return linkAlbumCover;
    }

    public void setLinkAlbumCover(String linkAlbumCover) {
        this.linkAlbumCover = linkAlbumCover;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLinkAudioFile() {
        return linkAudioFile;
    }

    public void setLinkAudioFile(String linkAudioFile) {
        this.linkAudioFile = linkAudioFile;
    }

    public String getLinkVideoFile() {
        return linkVideoFile;
    }

    public void setLinkVideoFile(String linkVideoFile) {
        this.linkVideoFile = linkVideoFile;
    }
}
