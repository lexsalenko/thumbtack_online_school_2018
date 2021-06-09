package net.thumbtack.school.threads;

public enum PingPongOperation {

    PING("Ping"), PONG("Pong");
    private String operation;

    private PingPongOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

}
