package com.baginarius.spring5webapp.books;

import org.springframework.data.repository.CrudRepository;

interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
