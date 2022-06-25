package server.commands;

import server.data.Movies;
import server.serverCode.MovieManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class SaveCommand extends AbstractCommand {

    private MovieManager movieManager;

    public SaveCommand(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public String execute() {
        try {
            File file = movieManager.getXmlCollection();
            Movies newMovies = new Movies();
            newMovies.setMovies(new ArrayList<>(movieManager.getCollection()));
            JAXBContext jaxbContext = JAXBContext.newInstance(Movies.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Marshal the persons list in file
            System.out.println(movieManager.getXmlCollection());
            jaxbMarshaller.marshal(newMovies, movieManager.getXmlCollection());
            return "Saved successfully";
        } catch (JAXBException jaxbException) {
            return ("XML syntax error. Try again.");
        }
    }
}
