package net.thumbtack.school.spring.dao;

import net.thumbtack.school.spring.model.RecordingForPublication;

import java.time.ZonedDateTime;

public interface PublishingChannels {

    String publish(RecordingForPublication recordingForPublication, ZonedDateTime publishAvailableDate);

    String delete(String id);

}
