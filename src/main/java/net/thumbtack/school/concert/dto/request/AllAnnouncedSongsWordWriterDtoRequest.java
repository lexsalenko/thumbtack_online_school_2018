package net.thumbtack.school.concert.dto.request;

public class AllAnnouncedSongsWordWriterDtoRequest {

    private String wordWriter;

    public AllAnnouncedSongsWordWriterDtoRequest(String wordWriter) {
        this.wordWriter = wordWriter;
    }

    public String getWordWriter() {
        return wordWriter;
    }

    public void setWordWriter(String wordWriter) {
        this.wordWriter = wordWriter;
    }
}
