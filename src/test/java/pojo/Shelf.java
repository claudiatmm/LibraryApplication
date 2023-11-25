package pojo;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private ShelfLetter shelfLetter;
    private List<Book> books;

    public Shelf(ShelfLetter shelfLetter) {
        this.shelfLetter = shelfLetter;
        this.books = new ArrayList<>();
    }


    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public ShelfLetter getShelfLetter() {
        return shelfLetter;
    }
}
