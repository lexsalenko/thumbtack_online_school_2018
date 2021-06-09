package net.thumbtack.school.spring.daoimpl;

import net.thumbtack.school.spring.dao.PublishingChannels;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class YoutubeMusicChannel implements PublishingChannels {

    public String publish(RecordingForPublication recordingForPublication, ZonedDateTime publishAvailableDate) {
        System.out.println("publication of the video " + recordingForPublication.getTrackName() + " on Youtube in " + publishAvailableDate.toString() + " days");
        return "Publication of the video " + recordingForPublication.getTrackName() + " on Youtube";
    }

    public String delete(String id) {
        System.out.println("Deleting an video recording from YouTube, id: " + id);
        return "Deleting an video recording from YouTube, id: " + id;
    }

}
