package com.iuh.test;

import com.iuh.entity.Book;
import com.iuh.entity.Library;
import com.iuh.factory.BookFactory;
import com.iuh.observer.User;
import com.iuh.strategy.AuthorStategy;
import com.iuh.strategy.GenreStategy;
import com.iuh.strategy.TitleStrategy;

public class Test {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        Book book01 = BookFactory.getBook("EBook", "Muon Kiep Nhan Sinh", "Nguyen Phong", "Tam Linh", false);
        Book book02 = BookFactory.getBook("PaperBook", "Hanh Trinh Tim Ve Phuong Dong", "John Vu", "Tam Linh", false);
        Book book03 = BookFactory.getBook("AudioBook", "Muon Kiep Nhan Sinh 2", "Nguyen Phong ", "Tam Linh Phuong Tay", false);

        User user01 = new User("Nguyen Van A");
        User user02 = new User("Tran Van B");
        User user03 = new User("Phan Van C");

        System.out.println("-------------------------------Them Nguoi Dung---------------------------------");
        library.register(user01);
        library.register(user02);
        library.register(user03);

        System.out.println("-------------------------------Them Sach---------------------------------");
        library.addBook(book01);
        library.addBook(book02);
        library.addBook(book03);

        System.out.println("-------------------------------Tim Kiem---------------------------------");
        System.out.println("Tim Kiem Theo Ten Sach");
        library.searchBooks(new TitleStrategy(), "Muon Kiep Nhan Sinh");
        System.out.println("Tim Kiem Theo Ten Tac Gia");
        library.searchBooks(new AuthorStategy(), "John Vu");
        System.out.println("Tim Kiem Theo The Loai");
        library.searchBooks(new GenreStategy(), "Tam Linh Phuong Tay");

        System.out.println("-----------------------------Muon Sach-----------------------------------");
        library.borrowBook("Muon Kiep Nhan Sinh", true, false);
        library.borrowBook("Muon Kiep Nhan Sinh 2", false, true);
    }
}
