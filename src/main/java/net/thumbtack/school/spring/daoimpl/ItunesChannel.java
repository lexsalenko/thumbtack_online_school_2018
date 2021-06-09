package net.thumbtack.school.spring.daoimpl;

import net.thumbtack.school.spring.dao.PublishingChannels;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class ItunesChannel implements PublishingChannels {

    public String publish(RecordingForPublication recordingForPublication, ZonedDateTime publishAvailableDate) {
        System.out.println("publication of the song " + recordingForPublication.getTrackName() + " in Itunes in " + publishAvailableDate.toString() + " days");
        return "Publication of the song " + recordingForPublication.getTrackName() + " in Itunes";
    }

    public String delete(String id) {
        System.out.println("Deleting an audio recording from iTunes, id: " + id);
        return "Deleting an audio recording from iTunes, id: " + id;
    }

}
