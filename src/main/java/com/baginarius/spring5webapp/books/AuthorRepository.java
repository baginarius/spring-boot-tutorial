package com.baginarius.spring5webapp.books;

import org.springframework.data.repository.CrudRepository;

interface AuthorRepository extends CrudRepository<Author, Long> {
}
