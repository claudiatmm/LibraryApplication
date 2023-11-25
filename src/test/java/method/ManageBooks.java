package method;

import pojo.Book;
import pojo.Library;
import pojo.Shelf;
import pojo.ShelfLetter;

import java.util.Iterator;
import java.util.stream.Collectors;

public class ManageBooks {


    // add Book
    public static void addNewBook (int price, String author, String title, int year, int pages, Library library){
        Book carte1 = Book.builder()
                .bookName(title)
                .author(author)
                .price(price)
                .year(year)
                .numberOfPage(pages)
                .build();
        if(library.getShelves().stream().filter( i-> i.getShelfLetter().toString().equals(String.valueOf(carte1.getBookName().charAt(0))))
                .collect(Collectors.toList()).size() == 0){
            ShelfLetter shelfLetterA = ShelfLetter.valueOf(String.valueOf(carte1.getBookName().charAt(0)));
          library.addShelf(shelfLetterA);
        }

        for (Shelf raft : library.getShelves()){
            if(carte1.getBookName().startsWith(raft.getShelfLetter().toString())){
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


    // update Book
    public static void updateBook(Library library, String bookName, int price){
     for(Shelf ss : library.getShelves()){
         for(Book bb : ss.getBooks()){
             if(bb.getBookName().equals(bookName)){
                 bb.setPrice(price);
             }
         }
     }
    }


    // delete Book
    public static void deleteBook(Library library, String autor){
        Iterator iteratorS = library.getShelves().iterator();
        while (iteratorS.hasNext()){
            Shelf hh = (Shelf) iteratorS.next();
            Iterator iterator = hh.getBooks().iterator();
            while (iterator.hasNext()){
                Book jj = (Book) iterator.next();
                if(jj.getAuthor().equals(autor)){
                    iterator.remove();
                }
            }
        }
    }



    // search for the required Book


    // taking care of the issue date and return date



}
