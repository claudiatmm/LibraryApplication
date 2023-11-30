package pojo;

import lombok.Builder;

@Builder
public class Book {

    private int price;
    private String author;
    private String bookName;
    private int year;
    private int numberOfPage;


    public Book(int price, String author, String bookName, int year, int numberOfPage) {
        this.price = price;
        this.author = author;
        this.bookName = bookName;
        this.year = year;
        this.numberOfPage = numberOfPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", year=" + year +
                ", numberOfPage=" + numberOfPage +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }



//    public <T> Book setValueForBook (T value, String propertyName) {
//        }  switch (propertyName){
//            case "bookName": setBookName((String) value);
//            case "author" : setAuthor((String) value);
//
//        Book carte = Book.builder()
//                .bookName((String) value)
//                .author((String) value)
//                .price(getPrice())
//                .year(getYear())
//                .numberOfPage(getNumberOfPage())
//                .build();
//        return carte;
//    }



}
