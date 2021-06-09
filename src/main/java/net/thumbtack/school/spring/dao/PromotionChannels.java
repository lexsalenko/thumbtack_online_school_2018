package net.thumbtack.school.spring.dao;

import net.thumbtack.school.spring.model.RecordingForPublication;

import java.time.ZonedDateTime;

public interface PromotionChannels {

    String createCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignCreateDate);

    String toStopCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignCreateDate);

    String deleteCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignCreateDate);

}
