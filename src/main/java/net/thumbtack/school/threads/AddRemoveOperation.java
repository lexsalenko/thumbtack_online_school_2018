package net.thumbtack.school.threads;

public enum AddRemoveOperation {
    ADD("Add"), REMOVE("Remove");
    private String operation;

    private AddRemoveOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
