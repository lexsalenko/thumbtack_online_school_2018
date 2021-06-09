package net.thumbtack.school.concert.domain;

import java.util.Objects;

public class SongConcert {

    private String songUUIDString;
    private Integer sumAllEstimates;
    private double averageRatingSongs;

    public SongConcert(String songUUIDString, Integer sumAllEstimates, double averageRatingSongs) {
        this.songUUIDString = songUUIDString;
        this.sumAllEstimates = sumAllEstimates;
        this.averageRatingSongs = averageRatingSongs;
    }

    public String getSongUUIDString() {
        return songUUIDString;
    }

    public void setSongUUIDString(String songUUIDString) {
        this.songUUIDString = songUUIDString;
    }

    public Integer getSumAllEstimates() {
        return sumAllEstimates;
    }

    public void setSumAllEstimates(Integer sumAllEstimates) {
        this.sumAllEstimates = sumAllEstimates;
    }

    public double getAverageRatingSongs() {
        return averageRatingSongs;
    }

    public void setAverageRatingSongs(double averageRatingSongs) {
        this.averageRatingSongs = averageRatingSongs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongConcert that = (SongConcert) o;
        return Double.compare(that.averageRatingSongs, averageRatingSongs) == 0 &&
                Objects.equals(songUUIDString, that.songUUIDString) &&
                Objects.equals(sumAllEstimates, that.sumAllEstimates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songUUIDString, sumAllEstimates, averageRatingSongs);
    }

}
