package data;

import java.io.IOException;

public class Coordinates {
    private Float x; //Значение поля должно быть больше -598, Поле не может быть null
    private Integer y; //Значение поля должно быть больше -67, Поле не может быть null

    public Coordinates(Float x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        try{
            if (x==null || x <= -598) {
                throw new IOException("Нельзя вводить null или меньше -598");
            }
            else {
                this.x = x;
            }
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        try{
            if (y == null || y <= -67) {
                throw new IOException("Нельзя вводить null или меньше -67");
            }
            else {
                this.y = y;
            }
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
