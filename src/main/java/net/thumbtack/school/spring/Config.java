package net.thumbtack.school.spring;

import net.thumbtack.school.spring.dao.AudioRecordingStorage;
import net.thumbtack.school.spring.dao.VideoRecordingStorage;
import net.thumbtack.school.spring.daoimpl.*;
import net.thumbtack.school.spring.service.PromotionService;
import net.thumbtack.school.spring.service.PublicationService;
import net.thumbtack.school.spring.service.RecordingDataHubService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean("service1")
    public PublicationService separateService1(ItunesChannel itunesChannel, YandexMusicChannel yandexMusicChannel, YoutubeMusicChannel youtubeMusicChannel) {
        return new PublicationService(itunesChannel, yandexMusicChannel, youtubeMusicChannel);
    }

    @Bean("service2")
    public RecordingDataHubService separateService2(AudioRecordingStorageImpl audioRecordingStorage, VideoRecordingStorageImpl videoRecordingStorage) {
        return new RecordingDataHubService(audioRecordingStorage, videoRecordingStorage);
    }

    @Bean("service3")
    public PromotionService separateService3(PromotionChannelsImpl promotionService) {
        return new PromotionService(promotionService);
    }

    @Bean
    public YandexMusicChannel getYandexMusicChannel() {
        return new YandexMusicChannel();
    }

    @Bean
    public ItunesChannel getItunesChannel() {
        return new ItunesChannel();
    }

    @Bean
    public YoutubeMusicChannel getYoutubeMusicChannel() {
        return new YoutubeMusicChannel();
    }

    @Bean
    public AudioRecordingStorage getAudioRecordingStorage() {
        return new AudioRecordingStorageImpl();
    }

    @Bean
    public VideoRecordingStorage getVideoRecordingStorage() {
        return new VideoRecordingStorageImpl();
    }

}

