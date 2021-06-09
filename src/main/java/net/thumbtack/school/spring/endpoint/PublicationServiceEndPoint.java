package net.thumbtack.school.spring.endpoint;

import net.thumbtack.school.spring.model.Recording;
import net.thumbtack.school.spring.model.RecordingForPublication;
import net.thumbtack.school.spring.service.PromotionService;
import net.thumbtack.school.spring.service.PublicationService;
import net.thumbtack.school.spring.service.RecordingDataHubService;
import net.thumbtack.school.spring.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/records")
public class PublicationServiceEndPoint {

    private final PublicationService publicationService;
    private final RecordingDataHubService recordingDataHubService;
    private final PromotionService promotionService;
    private final Validator validator;


    @Autowired
    public PublicationServiceEndPoint(PublicationService publicationService, RecordingDataHubService recordingDataHubService, PromotionService promotionService, Validator validator) {
        this.publicationService = publicationService;
        this.recordingDataHubService = recordingDataHubService;
        this.promotionService = promotionService;
        this.validator = validator;
    }


     /*
        {
            "artist": "Camille Saint-Saëns",
            "trackName": "Danse macabre",
            "albumTitle": "Равенство, братство",
            "yearRelease": 1974,
            "linkAlbumCover": "ru.wikipedia.org/wiki/Пляска_смерти_(Сен-Санс)",
            "genre": "симфоническая поэма",
            "duration": "429",
            "linkAudioFile": "https://music.yandex.ru/album/167671/track/1689395",
            "linkVideoFile": "https://www.youtube.com/watch?v=YyknBTm_YyM"
        }
     */

    // saving

    @PostMapping(value = "/save_audio", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveAudioRecordingInDataHub(@Valid @RequestBody RecordingForPublication recordingForPublication) {
        Optional<RecordingForPublication> optResult = validator.validate(recordingForPublication);
        if (!optResult.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Incorrect parameters");
        } else {
            return recordingDataHubService.saveAudio(recordingForPublication);
        }
    }

    @PostMapping(value = "/save_video", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveVideoRecordingInDataHub(@Valid @RequestBody RecordingForPublication recordingForPublication) {
        Optional<RecordingForPublication> optResult = validator.validate(recordingForPublication);
        if (!optResult.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Incorrect parameters");
        } else {
            return recordingDataHubService.saveVideo(recordingForPublication);
        }
    }

    // publishing

    @GetMapping(value = "/publishing_audio_itunes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String publishingAudioRecordingToItunes(@PathVariable("id") String id) {
        Recording recording = recordingDataHubService.getAudioRecording(id);
        return publicationService.publishToItunesChannel(recording, ZonedDateTime.now());
    }

    @GetMapping(value = "/publishing_video_youtube/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String publishingVideoRecordingOnYoutube(@PathVariable("id") String id) {
        Recording recording = recordingDataHubService.getVideoRecording(id);
        return publicationService.publishOnYoutube(recording, ZonedDateTime.now());
    }

    @GetMapping(value = "/publishing_audio_yandex/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String publishingAudioRecordingOnYandex(@PathVariable("id") String id) {
        Recording recording = recordingDataHubService.getAudioRecording(id);
        return publicationService.publishOnYandexChannel(recording, ZonedDateTime.now());
    }

    // deleting

    @DeleteMapping(value = "/deleting_audio_itunes/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deletingAudioRecordingToItunes(@PathVariable("id") String id) {
        return publicationService.deleteFromItunesChannel(id);
    }

    @DeleteMapping(value = "/deleting_video_youtube/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deletingVideoRecordingOnYoutube(@PathVariable("id") String id) {
        return publicationService.deleteFromYoutube(id);
    }

    @DeleteMapping(value = "/deleting_audio_yandex/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deletingAudioRecordingOnYandex(@PathVariable("id") String id) {
        return publicationService.deleteFromYandexChannel(id);
    }

    // promotion

    @PostMapping(value = "/create_campaign", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCampaign(@Valid @RequestBody RecordingForPublication recordingForPublication) {
        Optional<RecordingForPublication> optResult = validator.validate(recordingForPublication);
        if (!optResult.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Incorrect parameters");
        } else {
            return promotionService.createCampaign(recordingForPublication, ZonedDateTime.now());
        }
    }

    @GetMapping(value = "/stop_campaign", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String stopCampaign(@Valid @RequestBody RecordingForPublication recordingForPublication) {
        Optional<RecordingForPublication> optResult = validator.validate(recordingForPublication);
        if (!optResult.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Incorrect parameters");
        } else {
            return promotionService.toStopCampaign(recordingForPublication, ZonedDateTime.now());
        }
    }

    @DeleteMapping(value = "/delete_campaign", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCampaign(@Valid @RequestBody RecordingForPublication recordingForPublication) {
        Optional<RecordingForPublication> optResult = validator.validate(recordingForPublication);
        if (!optResult.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Incorrect parameters");
        } else {
            return promotionService.deleteCampaign(recordingForPublication, ZonedDateTime.now());
        }
    }

}
