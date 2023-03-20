package data;


import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jetbrains.annotations.NotNull;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
@XmlType(name = "HumanBeing")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HumanBeing {
    @NotNull
    @XmlElement(name = "id", required=true)
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NotNull
    @XmlElement(name = "name", required=true)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    @XmlElement(name = "coordinates", required=true)
    private Coordinates coordinates; //Поле не может быть null
    @NotNull
    @XmlElement(name = "creationDate", required=true)
    @XmlJavaTypeAdapter(utils.DateAdapter.class)
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NotNull
    @XmlElement(name = "realHero", required=true)
    private Boolean realHero; //Поле не может быть null
    @NotNull
    @XmlElement(name = "hasToothpick", required=true)
    private boolean hasToothpick;
    @NotNull
    @XmlElement(name = "impactSpeed", required=true)
    private float impactSpeed; //Максимальное значение поля: 491
    @NotNull
    @XmlElement(name = "soundtrackName", required=true)
    private String soundtrackName; //Поле не может быть null
    @NotNull
    @XmlElement(name = "minutesOfWaiting", required=true)
    private float minutesOfWaiting;
    @NotNull
    @XmlElement(name = "mood", required=true)
    private Mood mood; //Поле не может быть null
    @NotNull
    @XmlElement(name = "car", required=true)
    private Car car; //Поле может быть null

    public HumanBeing(){}

    public HumanBeing(Long id, String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, float impactSpeed, String soundtrackName, float minutesOfWaiting, Mood mood, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.mood = mood;
        this.car = car;
    }

    public HumanBeing(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public float getImpactSpeed() {

        return impactSpeed;
    }

    public void setImpactSpeed(float impactSpeed) {
        try{
            if (impactSpeed > 491) {
                throw new IOException("Максимальное значение поля: 491");
            }
            else {
                this.impactSpeed = impactSpeed;;
            }
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public float getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public void setMinutesOfWaiting(float minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanBeing that = (HumanBeing) o;
        return hasToothpick == that.hasToothpick && Float.compare(that.impactSpeed, impactSpeed) == 0 && Float.compare(that.minutesOfWaiting, minutesOfWaiting) == 0 && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(realHero, that.realHero) && Objects.equals(soundtrackName, that.soundtrackName) && mood == that.mood && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, mood, car);
    }
    @Override
    public String toString() {
        String answer ="";
        answer+= String.format("ID : %d\n",id);
        answer+= String.format("Имя : " + name + "\n");
        answer+= String.format("Дата рождения : " + creationDate.toString() + "\n");
        answer+= String.format("Скорость : %.3f\n", impactSpeed);
        answer+= String.format("Название саундтрека : " + soundtrackName + "\n");
        answer+= String.format("Минуты ожидания : %.3f\n", minutesOfWaiting);
        answer+= String.format("Машина : " + car.toString() + "\n");
        answer+= String.format("Настроение : " + mood + "\n");

        return answer;
    }

    public int compareTo(HumanBeing o) {
        return 0;
    }
}