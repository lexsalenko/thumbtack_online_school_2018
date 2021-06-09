package net.thumbtack.school.concert.threads;

import net.thumbtack.school.spring.Application;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ApplicationTests {

    private RestTemplate template = new RestTemplate();

    @Test
    public void testPost() {
        RecordingForPublication dto = new RecordingForPublication();

        String artist = "Camille Saint-Saëns";
        String trackName = "Danse macabre";
        String albumTitle = "Равенство, братство";
        int yearRelease = 1974;
        String linkAlbumCover = "ru.wikipedia.org/wiki/Пляска_смерти_(Сен-Санс)";
        String genre = "симфоническая поэма";
        String duration = "429";
        String linkAudioFile = "https://music.yandex.ru/album/167671/track/1689395";
        String linkVideoFile = "https://www.youtube.com/watch?v=YyknBTm_YyM";

        dto.setArtist(artist);
        dto.setTrackName(trackName);
        dto.setAlbumTitle(albumTitle);
        dto.setYearRelease(yearRelease);
        dto.setLinkAlbumCover(linkAlbumCover);
        dto.setGenre(genre);
        dto.setDuration(duration);
        dto.setLinkAudioFile(linkAudioFile);
        dto.setLinkVideoFile(linkVideoFile);


        String actualResponse = template.postForObject("http://localhost:8080/api/records/save_audio", dto, String.class);
        String expectedResponse = "Storing audio, path: https://music.yandex.ru/album/167671/track/1689395";
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void testGet() {
        String actualResponse = template.getForObject("http://localhost:8080/api/records/publishing_audio_itunes/13", String.class);

        String expectedResponse = "Publication of the song Неваляшка in Itunes";
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void testPostWIthError() {

        RecordingForPublication dto = new RecordingForPublication();

        String artist = "Camille Saint-Saëns";
        String trackName = "Danse macabre";
        String albumTitle = "Равенство, братство";
        int yearRelease = 1974;
        String linkAlbumCover = "ru.wikipedia.org/wiki/Пляска_смерти_(Сен-Санс)";
        String genre = "симфоническая поэма";
        String duration = "429";
        String linkAudioFile = "//music.yandex.ru/album/167671/track/1689395";
        String linkVideoFile = "https://www.youtube.com/watch?v=YyknBTm_YyM";

        dto.setArtist(artist);
        dto.setTrackName(trackName);
        dto.setAlbumTitle(albumTitle);
        dto.setYearRelease(yearRelease);
        dto.setLinkAlbumCover(linkAlbumCover);
        dto.setGenre(genre);
        dto.setDuration(duration);
        dto.setLinkAudioFile(linkAudioFile);
        dto.setLinkVideoFile(linkVideoFile);

        try {
            String actualRecording = template.postForObject("http://localhost:8080/api/records/save_audio", dto, String.class);
            fail();
        } catch (HttpClientErrorException exc) {
            assertEquals(400, exc.getStatusCode().value());

            assertTrue(exc.getResponseBodyAsString().contains("linkAudioFile"));
        }
    }

}
