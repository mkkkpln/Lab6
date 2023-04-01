package data;

public enum Mood {
    SORROW ("Печальный"),
    GLOOM ("Хмурый"),
    APATHY ("Вялый"),
    CALM ("Спокойный");

    private String mean;
    Mood(String name) {
        this.mean = name;
    }

    @Override
    public String toString() {
        return mean;
    }

}