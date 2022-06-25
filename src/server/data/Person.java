package server.data;
import javax.xml.bind.annotation.*;
@XmlType(name = "operator")
@XmlRootElement
public class Person {
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private double weight; //Значение поля должно быть больше 0
    @XmlElement
    private Color eyeColor; //Поле не может быть null
    @XmlElement
    private Color hairColor; //Поле может быть null
    @XmlElement
    private Country nationality; //Поле может быть null
    @XmlElement
    private Location location; //Поле может быть null

    public Person(String name, double weight, Color eyeColor, Color hairColor, Country nationality, Location location) {
        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }
}
