package com.iuh.entity;

import com.iuh.decorator.BasicBorrow;
import com.iuh.decorator.Borrow;
import com.iuh.decorator.ExtendBorrow;
import com.iuh.decorator.SpecialEditionBorrow;
import com.iuh.observer.Observer;
import com.iuh.observer.Subject;
import com.iuh.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

public class Library implements Subject {
    private List<Book> listBook;
    private final Object MUTEX= new Object();
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public Library() {
        listBook = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers(String message) {
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            observersLocal = new ArrayList<>(this.observers);
        }
        for (Observer obj : observersLocal) {
            obj.update(message);
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return null;
    }

    public void addBook(Book book) {
        listBook.add(book);
        System.out.println("Đã thêm sách vaò thư viện: " + book.getTitle());
        notifyObservers("Thư viện đã thêm sách: " + book.getTitle());
    }

    private static class SingletonHelper{
        private static final Library INSTANCE = new Library();
    }

    public static Library getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void searchBooks(SearchStrategy searchStrategy, String keyWord){
        if(listBook.isEmpty()) {
            System.out.println("Thu vien khong co sach nao!");
        }else {
            System.out.println("Kết quả tìm kiếm:");
            List<Book> results = searchStrategy.search(keyWord, listBook);
            if (results.isEmpty()) {
                System.out.println("Không tìm thấy sách nào.");
            } else {
                for (Book book : results) {
                    System.out.println("- " + book);
                }
            }
        }
    }

    public void borrowBook(String title, boolean extend, boolean specialEdition) {
        for (Book book : listBook) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                Borrow borrow = new BasicBorrow(book);

                if (extend) {
                    borrow = new ExtendBorrow(borrow);
                }

                if (specialEdition) {
                    borrow = new SpecialEditionBorrow(borrow);
                }
                borrow.borrow();

                return;
            }
        }
        System.out.println("Không tìm thấy sách: " + title);
    }

}
