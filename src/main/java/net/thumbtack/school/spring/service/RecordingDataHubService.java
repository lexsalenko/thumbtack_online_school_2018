package net.thumbtack.school.spring.service;

import net.thumbtack.school.spring.dao.AudioRecordingStorage;
import net.thumbtack.school.spring.dao.VideoRecordingStorage;
import net.thumbtack.school.spring.daoimpl.AudioRecordingStorageImpl;
import net.thumbtack.school.spring.daoimpl.VideoRecordingStorageImpl;
import net.thumbtack.school.spring.model.Recording;
import net.thumbtack.school.spring.model.RecordingForPublication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordingDataHubService {

    private AudioRecordingStorage audioRecordingStorage;
    private VideoRecordingStorage videoRecordingStorage;

    @Autowired
    public RecordingDataHubService(AudioRecordingStorageImpl audioRecordingStorage, VideoRecordingStorageImpl videoRecordingStorage) {
        this.audioRecordingStorage = audioRecordingStorage;
        this.videoRecordingStorage = videoRecordingStorage;
    }

    public String saveVideo(RecordingForPublication recordingForPublication) {
        System.out.println("RecordingDataHubService: Video");
        return videoRecordingStorage.save(recordingForPublication.getLinkVideoFile());
    }

    public String saveAudio(RecordingForPublication recordingForPublication) {
        System.out.println("RecordingDataHubService: Audio");
        return audioRecordingStorage.save(recordingForPublication.getLinkAudioFile());
    }

    public Recording getAudioRecording(String id) {
        System.out.println("Get audio from AudioRecording");
        return audioRecordingStorage.getRecording(id);
    }

    public Recording getVideoRecording(String id) {
        System.out.println("Get video from VideoRecording");
        return videoRecordingStorage.getRecording(id);
    }

}
