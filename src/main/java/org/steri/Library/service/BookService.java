package org.steri.Library.service;

import org.steri.Library.entity.Book;

public interface BookService {
    Book createBook(Book book);
    void deleteBook(Long id);
}
