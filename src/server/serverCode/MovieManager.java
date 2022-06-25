package server.serverCode;


//import javax.xml.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.NoSuchElementException;
import server.data.*;

public class MovieManager {

    private HashSet<Movie> collection; //количество элементов из size
    //private ZonedDateTime dataInitialisation;
    private String pathToFile;
    private File xmlCollection;
    {
        collection = new HashSet<>();

    }

    public HashSet<Movie> getCollection() {
        return collection;
    }

    public void loadCollection(String pathToFile) {
        try {
            // java -jar La5.jar/home/proga/movies.xml
            //System.out.print("Enter a full path to XML file with collection: ");
            try {
                final QName qName = new QName("movie");
                InputStream inputStream = new FileInputStream(pathToFile);
                // create xml event reader for input stream
                XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
                XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);
                // initialize jaxb
                JAXBContext context = JAXBContext.newInstance(Movie.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                XMLEvent e;
                // Field for counting amount of downloaded elements
                int counterGood = 0;
                int counterBad = 0;
                // Loop for unmarshalling the collection
                while ((e = xmlEventReader.peek()) != null) {
                    // check the event is a Document start element
                    if (e.isStartElement() && ((StartElement) e).getName().equals(qName)) {
                        // unmarshall the document
                        Movie unmarshalledMovie = unmarshaller.unmarshal(xmlEventReader, Movie.class).getValue();
                        Coordinates newCoordinates = unmarshalledMovie.getCoordinates();
                        //Operator newPerson = unmarshalledMovie.getPerson();
                        if (unmarshalledMovie.getId() != null && unmarshalledMovie.getId() > 0 &&
                                unmarshalledMovie.getName() != null && !unmarshalledMovie.getName().equals("") &&
                                unmarshalledMovie.getCoordinates() != null && unmarshalledMovie.getCoordinates().getX() <= 975 &&
                                unmarshalledMovie.getCoordinates().getX() != null &&
                                unmarshalledMovie.getCreationDate() != null && unmarshalledMovie.getOscarsCount() != null &&
                                unmarshalledMovie.getOscarsCount() > 0 && unmarshalledMovie.getGenre() != null &&
                                unmarshalledMovie.getMpaaRating() != null) {
                            collection.add(unmarshalledMovie);
                            counterGood += 1;
                            //xmlCollection = new File(pathToFile);
                        } else counterBad += 1;
                    } else {
                        xmlEventReader.next();
                    }
                }
                System.out.println("Collection was loaded successfully. " + counterGood + " elements has been loaded.");
                System.out.println("Amount of elements which contains invalid values and has not been loaded: " + counterBad);
                xmlCollection = new File(pathToFile);
                //dataInitialisation = ZonedDateTime.now();
            } catch (JAXBException jaxbException) {
                System.out.println("XML syntax error.");
                jaxbException.printStackTrace();
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File not found");
                fileNotFoundException.printStackTrace();
            } catch (XMLStreamException xmlStreamException) {
                xmlStreamException.printStackTrace();
                System.out.println("XML Stream error");
            } catch (NullPointerException nullPointerException) {
                System.out.println("Impossible to load this file.");
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program will be finished now.");
            System.exit(0);
        }
    }

    public File getXmlCollection() {
        return xmlCollection;
    }
}