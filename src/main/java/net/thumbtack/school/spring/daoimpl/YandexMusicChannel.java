package net.thumbtack.school.spring.daoimpl;

import net.thumbtack.school.spring.dao.PublishingChannels;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class YandexMusicChannel implements PublishingChannels {

    public String publish(RecordingForPublication recordingForPublication, ZonedDateTime publishAvailableDate) {
      System.out.println("publication of the song " + recordingForPublication.getTrackName() + " on Yandex in " + publishAvailableDate.toString() + " days");
      return "Publication of the song " + recordingForPublication.getTrackName() + " on Yandex";
    }

    public String delete(String id) {
        System.out.println("Deleting an audio recording from Yandex Music, id: " + id);
        return "Deleting an audio recording from Yandex Music, id: " + id;
    }

}
