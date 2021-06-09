package net.thumbtack.school.spring.dao;

import net.thumbtack.school.spring.model.Recording;

public interface VideoRecordingStorage {

    String save(String path);

    Recording getRecording(String id);

}
