package server.data;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Karina Zaytseva
 * @version 1.0
 * Class for describing a collection in a marshaling-ready view
 */
@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.NONE)
public class Movies
{
    public Movies() {}
    /** Field movies - list for keeping collection */
    @XmlElement(name = "movie")
    private List<Movie> movies = null;

    /**
     * Method for get persons list
     * @return List<Person> persons
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /** Method for passing a value to the persons list */
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}