package com.iuh.factory;

import com.iuh.entity.AudioBook;
import com.iuh.entity.Book;
import com.iuh.entity.EBook;
import com.iuh.entity.PaperBook;

public class BookFactory {
    public static Book getBook(String type, String title, String author, String genre, boolean isBorrowed){
        if("PaperBook".equalsIgnoreCase(type))
            return new PaperBook(title, author, genre, isBorrowed);
        else if("EBook".equalsIgnoreCase(type))
            return new EBook(title, author, genre, isBorrowed);
        else if("AudioBook".equalsIgnoreCase(type))
            return new AudioBook(title, author, genre, isBorrowed);
        return null;
    }
}
