package server.data;
import javax.xml.bind.annotation.*;
@XmlType(name = "location")
@XmlRootElement
public class Location {
    @XmlElement
    private long x;
    @XmlElement
    private int y;
    @XmlElement
    private Double z; //Поле не может быть null

    public Location(long x, int y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location() {}
}
