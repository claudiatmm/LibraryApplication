package pojo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Shelf> shelves = new ArrayList<>();

    public Library(List<Shelf> shelves) {
        this.shelves = shelves;
    }


    public Library(){
    }


    public void addShelf(ShelfLetter shelfLetter){
        Shelf shelf = new Shelf(shelfLetter);
        shelves.add(shelf);
    }


    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }


    public void printAllBooks(){
        for(Shelf s :shelves){
            for (Book b : s.getBooks()){
                System.out.println("here are all the books " + b.toString() + " here is the shelf : " +s.getShelfLetter());
            }

        }

    }

    public Shelf update(ShelfLetter shelfLetter){



        return null;
    }
}
