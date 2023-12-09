package user;

import pojo.Book;
import pojo.Library;

import java.util.ArrayList;
import java.util.List;

import static method.ManageBooks.requiredBook;

public class UserOne {

    public List<Book> userBooks;


    //rent a book by book name
    public void rentBook(Library library, String bookName){
        userBooks = new ArrayList<>();
        Book book = requiredBook(library, bookName);
        userBooks.add(book);

    }


    //display all the books user have on his name
    public void userBookDisplay(){
        System.out.println("The user have a number of : " + userBooks.size() + " book's");
    }

}
