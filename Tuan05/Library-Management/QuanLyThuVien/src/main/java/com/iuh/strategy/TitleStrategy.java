package com.iuh.strategy;

import com.iuh.entity.Book;

import java.util.List;

public class TitleStrategy implements SearchStrategy{
    @Override
    public List<Book> search(String keyWord, List<Book> listBook) {
        return listBook.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyWord.toLowerCase()))
                .toList();
    }
}
