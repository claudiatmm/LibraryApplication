package method;

import pojo.Book;
import pojo.Library;
import pojo.Shelf;
import pojo.ShelfLetter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ManageBooks {


    // add Book
    public static void addNewBook(int price, String author, String title, int year, int pages, Library library) {
        Book carte1 = Book.builder().bookName(title).author(author).price(price).year(year).numberOfPage(pages).build();
        if (library.getShelves().stream().filter(i -> i.getShelfLetter().toString().equals(String.valueOf(carte1.getBookName().charAt(0)))).collect(Collectors.toList()).size() == 0) {
            //create Shelf
            ShelfLetter shelfLetterA = ShelfLetter.valueOf(String.valueOf(carte1.getBookName().charAt(0)));
            library.addShelf(shelfLetterA);
        }

        for (Shelf raft : library.getShelves()) {
            if (carte1.getBookName().startsWith(raft.getShelfLetter().toString())) {
                raft.addBook(carte1);
            }
        }
        //Metoda e acelasi lucru cu ce am mai sus - merg cu un for peste toate rafturile
//        public Shelf getSpecificShelf(ShelfLetter shelfLetterInput){
//            for(Shelf currentShelf : shelves){
//                if(currentShelf.getShelfLetter().equals(shelfLetterInput));
//                return currentShelf;
//            }
//            return null;
//        }
        System.out.println("book has been added into the system: " + carte1);
    }


    // update Book price
    public static void updateBook(Library library, String bookName, int price) {
        for (Shelf ss : library.getShelves()) {
            for (Book bb : ss.getBooks()) {
                if (bb.getBookName().equals(bookName)) {
                    bb.setPrice(price);
                }
            }
        }
    }


    // delete a Book
    public static void deleteBook(Library library, String autor) {
        Iterator iteratorS = library.getShelves().iterator();
        while (iteratorS.hasNext()) {
            Shelf hh = (Shelf) iteratorS.next();
            Iterator iterator = hh.getBooks().iterator();
            while (iterator.hasNext()) {
                Book jj = (Book) iterator.next();
                if (jj.getAuthor().equals(autor)) {
                    iterator.remove();
                }
            }
        }
    }


    // search for the required Book - method with return type
    public static Book requiredBook(Library library, String bookName) {
        Book book = null;
        for (Shelf ss : library.getShelves()) {
            for (Book bb : ss.getBooks()) {
                if (bb.getBookName().equals(bookName)) {
                    book = bb;
                }
            }
        }
        System.out.println("here is your search for " + bookName + " and the results is: " + book);
        return book;
    }


    // update any Book variable user want
    public static <W> void updateBookT(Library library, String bookName, W value, String propertyName) {
        for (Shelf shelf : library.getShelves()) {
            for (Book book : shelf.getBooks()) {
                if (book.getBookName().equals(bookName)) {
//                    book.(value, propertyName);
                    switch (propertyName) {
                        case "bookName":
                            book.setBookName((String) value);
                            break;
                        case "author":
                            book.setAuthor((String) value);
                            break;
                        case "price":
                            book.setPrice((Integer) value);
                            break;
                    }
                }
            }
        }
    }


    //display books with > 300 pages
    public static void displayBookBaseOnCondition(Library library) {
        for (Shelf shelf : library.getShelves()) {
            List<Book> books = shelf.getBooks().stream().filter(i -> i.getNumberOfPage() > 300).collect(Collectors.toList());
            if (books.size() != 0) {
                System.out.println("Here is the list with all book wich have pages > 300: --- " + books);
            }
        }
    }


    //display books with <= 300 pages
    public static void displayBookBaseOnConditionTwo(Library library) {
        for (Shelf shelf : library.getShelves()) {
            List<Book> books = shelf.getBooks().stream().filter(i -> i.getNumberOfPage() <= 300).collect(Collectors.toList());
            if (books.size() != 0) {
                System.out.println("Here is the list with all book wich have pages <= 300: --- " + books);
            }
        }
    }


    //display the cheapest book
    public static void cheapestBook(Library library) {
        Book bookP = null;
        List<Book> books = new ArrayList<>();
        library.getShelves().stream().forEach(i -> books.addAll(i.getBooks()));
        bookP = books.stream().min(Comparator.comparing(Book::getPrice)).get();
        System.out.println("The cheapest book is: " + bookP.getBookName() + " with price: " + bookP.getPrice());
    }



    //calculate the price of all books which have > 300 pages
    public static int priceBookManyPage(Library library) {
        int sumOfPrice = 0;
        for (Shelf shelf : library.getShelves()) {
            for (Book book : shelf.getBooks()) {
                if (book.getNumberOfPage() > 300) {
                    sumOfPrice = sumOfPrice + book.getPrice();
                }
            }
        }
        System.out.println("sum of books with > 300 page is: " + sumOfPrice);
        return sumOfPrice;
    }


    //display all books when user mention a capital letter
    public static void displayBooksByLetter(Library library, ShelfLetter shelfLetterInput) throws MyException {
        for (Shelf shelf : library.getShelves()) {
            try {
                if (shelf.getShelfLetter().equals(shelfLetterInput)) {
                    System.out.println("Here are all the books that starts with letter : " + shelfLetterInput + " " + shelf.getBooks());
                    break;

                } else {
                    throw new MyException("Please try another one capital letter");
                }
            }
            catch (MyException exception){
                System.out.println(exception.toString());
            }
        }
    }



    // filtrez rafturile care au litera "X"

}
