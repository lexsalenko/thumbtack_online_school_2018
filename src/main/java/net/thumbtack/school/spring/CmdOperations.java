package net.thumbtack.school.spring;

import net.thumbtack.school.spring.dao.PromotionChannels;
import net.thumbtack.school.spring.model.Recording;
import net.thumbtack.school.spring.model.RecordingForPublication;
import net.thumbtack.school.spring.service.PublicationService;
import net.thumbtack.school.spring.service.RecordingDataHubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class CmdOperations implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(CmdOperations.class);

    private final PublicationService publicationService;
    private final RecordingDataHubService recordingDataHubService;
    private final PromotionChannels promotionChannels;


    @Autowired
    public CmdOperations(PublicationService publicationService, RecordingDataHubService recordingDataHubService, PromotionChannels promotionChannels) {
        this.publicationService = publicationService;
        this.recordingDataHubService = recordingDataHubService;
        this.promotionChannels = promotionChannels;
    }


    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Hello, runner was started, {}", 123);
        System.out.println("\nRunner was started \n");

        String artist = "Camille Saint-Saëns";
        String trackName = "Danse macabre";
        String albumTitle = "Равенство, братство";
        int yearRelease = 1974;
        String linkAlbumCover = "ru.wikipedia.org/wiki/Пляска_смерти_(Сен-Санс)";
        String genre = "симфоническая поэма";
        String duration = "429";
        String linkAudioFile = "https://music.yandex.ru/album/167671/track/1689395";
        String linkVideoFile = "https://www.youtube.com/watch?v=YyknBTm_YyM";

        RecordingForPublication recordingForPublication = new RecordingForPublication(artist, trackName, albumTitle, yearRelease, linkAlbumCover, genre, duration, linkAudioFile, linkVideoFile);

        System.out.println("Scenario 1 was started ... \n");
        scenario1(recordingForPublication);
        System.out.println("\nScenario 1 was stopped ... \n");
        System.out.println("//////////////////\n");
        System.out.println("Scenario 2 was started ... \n");
        scenario2(recordingForPublication);
        System.out.println("\nScenario 2 was stopped ... \n");

        System.out.println("Runner was stopped \n");
    }

    //Сохранение и публикация аудиозаписи, рекламная кампания стартует немедленно,
    // публикация во всех каналах происходит спустя 1 неделю от текущей даты

    public void scenario1(RecordingForPublication recordingForPublication) {
        recordingDataHubService.saveAudio(recordingForPublication);
        promotionChannels.createCampaign(recordingForPublication, ZonedDateTime.now());

        String artist = recordingForPublication.getArtist();
        String trackName = recordingForPublication.getTrackName();
        String albumTitle = recordingForPublication.getAlbumTitle();
        int yearRelease = recordingForPublication.getYearRelease();
        String linkAlbumCover = recordingForPublication.getLinkAlbumCover();
        String genre = recordingForPublication.getGenre();
        String duration = recordingForPublication.getDuration();
        String linkAudioFile = recordingForPublication.getLinkAudioFile();
        String linkVideoFile = recordingForPublication.getLinkVideoFile();

        Recording recording = new Recording(artist, trackName, albumTitle, yearRelease, linkAlbumCover, genre, duration, linkAudioFile, linkVideoFile);


        publicationService.publishOnYoutube(recording, ZonedDateTime.now().plusDays(7));
        publicationService.publishToItunesChannel(recording, ZonedDateTime.now().plusDays(7));
        publicationService.publishOnYandexChannel(recording, ZonedDateTime.now().plusDays(7));
    }


    //Сохранение и публикация видеозаписи, рекламная кампания стартует немедленно,
    // публикация только в youtube канале спустя 2 недели

    public void scenario2(RecordingForPublication recordingForPublication) {
        recordingDataHubService.saveVideo(recordingForPublication);
        promotionChannels.createCampaign(recordingForPublication, ZonedDateTime.now());

        String artist = recordingForPublication.getArtist();
        String trackName = recordingForPublication.getTrackName();
        String albumTitle = recordingForPublication.getAlbumTitle();
        int yearRelease = recordingForPublication.getYearRelease();
        String linkAlbumCover = recordingForPublication.getLinkAlbumCover();
        String genre = recordingForPublication.getGenre();
        String duration = recordingForPublication.getDuration();
        String linkAudioFile = recordingForPublication.getLinkAudioFile();
        String linkVideoFile = recordingForPublication.getLinkVideoFile();

        Recording recording = new Recording(artist, trackName, albumTitle, yearRelease, linkAlbumCover, genre, duration, linkAudioFile, linkVideoFile);

        publicationService.publishOnYoutube(recording, ZonedDateTime.now().plusDays(14));
    }

}
