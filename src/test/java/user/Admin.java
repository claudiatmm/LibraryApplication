package user;

import pojo.Book;
import pojo.Library;
import pojo.Shelf;

import java.util.Iterator;

public class Admin {


    // delete all Book
    public void deleteAllBook(Library library){
        Iterator iteratorS = library.getShelves().iterator();
        while (iteratorS.hasNext()){
            Shelf hh = (Shelf) iteratorS.next();
            Iterator iterator = hh.getBooks().iterator();
            while (iterator.hasNext()){
                Book jj = (Book) iterator.next();
                iterator.remove();
            }
        }
    }







}
