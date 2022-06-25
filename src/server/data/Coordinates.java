package server.data;

import javax.xml.bind.annotation.*;
@XmlType(name = "coordinates")
@XmlRootElement
public class Coordinates {
    @XmlElement
    private Integer x; // <= 975, not null
    @XmlElement
    private long y;

    public Coordinates(Integer x, long y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {}

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Integer getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}