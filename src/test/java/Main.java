import pojo.Library;

import static method.ManageBooks.*;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();


        addNewBook(12, "Hannah Grace", "WILDFIRE", 2021, 150, library);
        addNewBook(25, "Rebecca Yarros", "FOURTH WING", 2001,200, library);
        addNewBook(14, "Rebecca Yarros", "FOURTH ", 2009,400, library);
        addNewBook(95, "John Sandford", "JUDGMENT PREY", 1996,400, library);
        addNewBook(45, "Danielle Steel", "SECOND ACT", 2005,300, library);
        addNewBook(11, "Stephen King", "HOLLY", 2007,260,library);
        addNewBook(89, "Michael Lewis", "GOING INFINITE", 2010,275, library);
        addNewBook(33, "Bonnie Garmus", "LESSONS IN CHEMISTRY", 2017,243, library);
        addNewBook(14, "Kerri Maniscalco", "THRONE OF THE FALLEN", 2022,100, library);


        library.printAllBooks();
        System.out.println("this is the size of shelves " + library.getShelves().size());
        updateBook(library, "FOURTH WING", 2000);
        library.printAllBooks();
        deleteBook(library,"Hannah Grace");

        System.out.println("--------------------------------");
        library.printAllBooks();

    }
}
