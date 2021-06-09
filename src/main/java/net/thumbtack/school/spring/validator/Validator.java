package net.thumbtack.school.spring.validator;

import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class Validator {
    public Optional<RecordingForPublication> validate(final RecordingForPublication recordingForPublication) {
        if (recordingForPublication.getArtist() == null) {
            return Optional.empty();
        }
        if (recordingForPublication.getTrackName() == null) {
            return Optional.empty();
        }
        if (recordingForPublication.getGenre() == null) {
            return Optional.empty();
        }
        if (recordingForPublication.getDuration() == null) {
            return Optional.empty();
        }
        if (recordingForPublication.getLinkAudioFile() == null) {
            return Optional.empty();
        }
        return Optional.of(recordingForPublication);
    }
}
