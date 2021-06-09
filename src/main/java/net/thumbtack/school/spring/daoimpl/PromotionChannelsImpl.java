package net.thumbtack.school.spring.daoimpl;

import net.thumbtack.school.spring.dao.PromotionChannels;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class PromotionChannelsImpl implements PromotionChannels {

    public String createCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignCreateDate) {
        System.out.println("The advertising campaign for the song " + recordingForPublication.getTrackName() + " will start in " + campaignCreateDate.toString() + " days");
        return "The advertising campaign for the song " + recordingForPublication.getTrackName();
    }

    public String toStopCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignStopDate) {
        System.out.println("Stop an advertising campaign for an recordingForPublication " + recordingForPublication.getTrackName() + " , date " + campaignStopDate.toString());
        return "Stop an advertising campaign for an recordingForPublication " + recordingForPublication.getTrackName();
    }

    public String deleteCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignDeleteDate) {
        System.out.println("Delete an advertising campaign for an recordingForPublication " + recordingForPublication.getTrackName() + " , date " + campaignDeleteDate.toString());
        return "Delete an advertising campaign for an recordingForPublication " + recordingForPublication.getTrackName();
    }
}
