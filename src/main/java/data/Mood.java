package data;

public enum Mood {
    SORROW ("печаль"),
    GLOOM ("уныние"),
    APATHY("апатия"),
    CALM ("спокойствие");
    private String mean;
    Mood(String name) {
        this.mean = name;
    }

    @Override
    public String toString() {
        return mean;
    }
}
