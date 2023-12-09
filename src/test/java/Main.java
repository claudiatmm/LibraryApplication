import method.ManageBooks;
import method.MyException;
import pojo.Library;
import pojo.ShelfLetter;
import user.Admin;
import user.UserOne;

import static method.ManageBooks.*;

public class Main {

    public static void main(String[] args) throws MyException {

//        try {
//            System.out.println(1/0);
//            System.out.println(2/2);
//        }
//        //intra numai daca so aruncat exceptie
//        catch (Exception e){
//            System.out.println(e);
//        }
//        // intra mereu aici
//        finally {
//            System.out.println("ceva");
//        }
//        System.out.println("test");


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


        System.out.println(" ******--------------------------------********");
        library.printAllBooks();
        System.out.println("--------------------------------");
        System.out.println("------- this is the size of shelves --------- : " + library.getShelves().size());

        updateBook(library, "FOURTH WING", 2000);
        System.out.println("--------------------------------");
        library.printAllBooks();

        System.out.println("--------------------------------");
        deleteBook(library,"Hannah Grace");

        System.out.println("--------------------------------");
        library.printAllBooks();


        updateBookT(library, "WILDFIRE", "test", "bookName");
        library.printAllBooks();

        requiredBook(library, "LESSONS IN CHEMISTRY");
        System.out.println("--------------------------------");
        displayBookBaseOnCondition(library);
        System.out.println("--------------------------------");
        displayBookBaseOnConditionTwo(library);
        System.out.println("--------------------------------");
        cheapestBook(library);
        System.out.println("--------------------------------");

        priceBookManyPage(library);

        displayBooksByLetter(library, ShelfLetter.T);
        System.out.println("--------------------------------");
        filterShelfByLetter(library,ShelfLetter.T);
        System.out.println("--------------------------------");
        booksDisplayByYear(library, 2010);


        Admin admin = new Admin();
        admin.deleteAllBook(library);


        System.out.println("--------------------------------");
        library.printAllBooks();
        UserOne userOne = new UserOne();
        userOne.rentBook(library,"SECOND ACT");
        userOne.userBookDisplay();

    }


}
