package client.clientCode;

//import java.time.ZonedDateTime;
import java.lang.management.OperatingSystemMXBean;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import server.data.*;
import server.serverCode.MovieManager;

public class FieldReceiver {

    private HashSet<Movie> collection;

    {
        MovieManager manager = new MovieManager();
        collection = manager.getCollection();
    }

    public Long receiveId() {
        return (long) ((Math.random() * (Integer.MAX_VALUE - Integer.MIN_VALUE)) + Integer.MIN_VALUE);
    }

    public String receiveName() {
        try {
            while (true){
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the name of Movie: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) throw new InputMismatchException();
                    return name;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter not empty string.");
                }
            }

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return null;
    }

    public Integer receiveXCoordinate (){
        try {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the X coordinate of Movie: ");
                    Integer xCoordinate = scanner.nextInt();
                    if (xCoordinate > 975) throw new InputMismatchException();
                    return xCoordinate;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter integer number that must be less or equal than 975.");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return null;
    }

    public long receiveYCoordinate (){
        try {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the Y coordinate: ");
                    return scanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter integer number.");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return 0;
    }

    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveXCoordinate(), receiveYCoordinate());
    }

    public int receiveOscarsCount() {
        while (true) {
            try {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the oscars amount of Movie: ");
                    int oscarsCount = scanner.nextInt();
                    if (oscarsCount < 0) throw new InputMismatchException();
                    return oscarsCount;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter integer number that must be not negative.");
                }
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("The program finished successfully");
                System.exit(0);
            }
        }
    }

    public MovieGenre receiveMovieGenre() {
        try {
            System.out.println("Choose the Genre of Movie from this list: ");
            System.out.println("1. WESTERN");
            System.out.println("2. COMEDY");
            System.out.println("3. THRILLER");
            System.out.println("4. HORROR");
            System.out.println("5. FANTASY");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String genre = scanner.nextLine().toUpperCase();
                switch (genre) {
                    case "WESTERN":
                        return MovieGenre.WESTERN;
                    case "COMEDY":
                        return MovieGenre.COMEDY;
                    case "THRILLER":
                        return MovieGenre.THRILLER;
                    case "HORROR":
                        return MovieGenre.HORROR;
                    case "FANTASY":
                        return MovieGenre.FANTASY;
                    default:
                        System.out.println("You need to enter value from list");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program is finished successfully.");
            System.exit(0);
        }
        return null;
    }


    public MpaaRating receiveMpaaRating() {
        try {
            System.out.println("Choose the MpaaRating of Movie from this list: ");
            System.out.println("1. G");
            System.out.println("2. PG");
            System.out.println("3. PG_13");
            System.out.println("4. R");
            System.out.println("5. NC_17");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String Mpaa = scanner.nextLine().toUpperCase();
                switch (Mpaa) {
                    case "G":
                        return MpaaRating.G;
                    case "PG":
                        return MpaaRating.PG;
                    case "PG_13":
                        return MpaaRating.PG_13;
                    case "R":
                        return MpaaRating.R;
                    case "NC_17":
                        return MpaaRating.NC_17;
                    default:
                        System.out.println("You need to enter value from list");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program is finished successfully.");
            System.exit(0);
        }
        return null;
    }


    public Color receiveColor() {
        try {
            System.out.println("Choose the color from this list: ");
            System.out.println("1. GREEN");
            System.out.println("2. BLUE");
            System.out.println("3. YELLOW");
            System.out.println("4. ORANGE");
            System.out.println("5. WHITE");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String color = scanner.nextLine().toUpperCase();
                switch (color) {
                    case "GREEN":
                        return Color.GREEN;
                    case "BLUE":
                        return Color.BLUE;
                    case "YELLOW":
                        return Color.YELLOW;
                    case "ORANGE":
                        return Color.ORANGE;
                    case "WHITE":
                        return Color.WHITE;
                    default:
                        System.out.println("You need to enter value from list");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program is finished successfully.");
            System.exit(0);
        }
        return null;
    }

    // there are fields of class Person here

    public String receiveNameOfPerson() {
        try {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the name of Person: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) throw new InputMismatchException();
                    return name;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter not empty string.");
                }
            }

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return null;
    }

    public double receiveWeight(){
        try {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the weight of Person: ");
                    double weight = scanner.nextDouble();
                    if (weight <= 0) throw new InputMismatchException();
                    return weight;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter real number greater than 0.");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return 0;
    }

    public Country receiveNationality() {
        try {
            System.out.println("Choose the nationality of Person from this list: ");
            System.out.println("1. UNITED_KINGDOM");
            System.out.println("2. FRANCE");
            System.out.println("3. VATICAN");
            System.out.println("4. ITALY");

            while (true) {
                Scanner scanner = new Scanner(System.in);
                String country = scanner.nextLine().toUpperCase();
                switch (country) {
                    case "UNITED_KINGDOM":
                        return Country.UNITED_KINGDOM;
                    case "FRANCE":
                        return Country.FRANCE;
                    case "VATICAN":
                        return Country.VATICAN;
                    case "ITALY":
                        return Country.ITALY;
                    default:
                        System.out.println("You need to enter value from list");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program is finished successfully.");
            System.exit(0);
        }
        return null;
    }

    public long receiveXOFPerson (){
        try {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the X of Person: ");
                    return scanner.nextLong();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter long number.");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return 0;
    }

    public int receiveYOFPerson() {
        try {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the Y of Person: ");
                    return scanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter integer number.");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return 0;
    }

    public Double receiveZOFPerson() {
        try {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the Z of Person: ");
                    Double zCoordinate = scanner.nextDouble();
                    if (zCoordinate == null) {
                        throw new InputMismatchException();
                    }
                    return zCoordinate;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("You need to enter double number.");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The program is finished successfully.");
            System.exit(0);
        }
        return 0.0;
    }

    public Location receivePersonLocation() {
        return new Location(receiveXOFPerson(), receiveYOFPerson(), receiveZOFPerson());
    }

    public Color receiveEyeColor() {
        try {
            System.out.println("Choose the eye color of Person from this list: ");
            System.out.println("1. GREEN");
            System.out.println("2. BLUE");
            System.out.println("3. YELLOW");
            System.out.println("4. ORANGE");
            System.out.println("5. WHITE");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String color = scanner.nextLine().toUpperCase();
                switch (color) {
                    case "GREEN":
                        return Color.GREEN;
                    case "BLUE":
                        return Color.BLUE;
                    case "YELLOW":
                        return Color.YELLOW;
                    case "ORANGE":
                        return Color.ORANGE;
                    case "WHITE":
                        return Color.WHITE;
                    default:
                        System.out.println("You need to enter value from list");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program is finished successfully.");
            System.exit(0);
        }
        return null;
    }

    public Color receiveHairColor() {
        try {
            System.out.println("Choose the hair color of Person from this list: ");
            System.out.println("1. GREEN");
            System.out.println("2. BLUE");
            System.out.println("3. YELLOW");
            System.out.println("4. ORANGE");
            System.out.println("5. WHITE");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String color = scanner.nextLine().toUpperCase();
                switch (color) {
                    case "GREEN":
                        return Color.GREEN;
                    case "BLUE":
                        return Color.BLUE;
                    case "YELLOW":
                        return Color.YELLOW;
                    case "ORANGE":
                        return Color.ORANGE;
                    case "WHITE":
                        return Color.WHITE;
                    default:
                        System.out.println("You need to enter value from list");
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program is finished successfully.");
            System.exit(0);
        }
        return null;
    }

    public Person receiveOperator() {
        return new Person(receiveNameOfPerson(), receiveWeight(), receiveEyeColor(), receiveHairColor(),
                receiveNationality(), receivePersonLocation());
    }

    //public Movie receiveMovie() {
      //  return new Movie(receiveId(), receiveName(), receiveCoordinates(), ZonedDateTime.now().toString(),
        //        receiveOscarsCount(), receiveMovieGenre(), receiveMpaaRating(), receiveOperator());
    //}
}
