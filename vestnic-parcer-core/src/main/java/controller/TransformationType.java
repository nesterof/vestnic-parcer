package controller;

public enum TransformationType {
    DOAJ("doaj.xslt");

    private String filePath;

    TransformationType(String filePath) {
        this.filePath = filePath;
    }
}
