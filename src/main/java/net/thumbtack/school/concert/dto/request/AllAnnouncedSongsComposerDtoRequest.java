package net.thumbtack.school.concert.dto.request;

public class AllAnnouncedSongsComposerDtoRequest {

    private String composer;

    public AllAnnouncedSongsComposerDtoRequest(String composer) {
        this.composer = composer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }
}
