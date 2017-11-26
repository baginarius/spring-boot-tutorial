package com.baginarius.spring5webapp.books;

import org.springframework.data.repository.CrudRepository;

interface BookRepository extends CrudRepository<Book, Long> {
}
