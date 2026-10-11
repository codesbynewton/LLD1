package org.example.lld1.class_basics.lab_book;

/*
Problem statement:
Youre building a library management stystem. Start by modeling a Book Entity

Requirements:

A book has a titile, author, ISBN(Unique identifier), price, and number of pages
A book can be borrowed and returned
we should be able to check if a book is currently available

 */

public class Book  {
    String title;
    String author;
    String ISBN;
    int price;
    int noOfPages;
    boolean isAvailable;

    void borrowBook(){
        if(isAvailable){
            isAvailable=false;
            System.out.println("The book has been borrowed");
        } else {
            System.out.println("The book is not available");
        }
    }

    void returnBook(){
        isAvailable=true;
        System.out.println("The book is returned");
    }

    boolean checkAvailability(){
        return isAvailable;
    }
}
