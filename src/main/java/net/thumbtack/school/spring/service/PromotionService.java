package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.dao.PromotionChannels;
import net.thumbtack.school.spring.daoimpl.PromotionChannelsImpl;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PromotionService {

    private PromotionChannels promotionService;

    @Autowired
    public PromotionService(PromotionChannelsImpl promotionService) {
        this.promotionService = promotionService;
    }

    public String createCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignCreateDate) {
        System.out.println("Promotion service - Create campaign");
        return promotionService.createCampaign(recordingForPublication, campaignCreateDate);
    }

    public String toStopCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignStopDate) {
        System.out.println("Promotion Service - Stop campaign");
        return promotionService.toStopCampaign(recordingForPublication, campaignStopDate);
    }

    public String deleteCampaign(RecordingForPublication recordingForPublication, ZonedDateTime campaignDeleteDate) {
        System.out.println("Promotion Service - Delete campaign");
        return promotionService.deleteCampaign(recordingForPublication, campaignDeleteDate);
    }

}
