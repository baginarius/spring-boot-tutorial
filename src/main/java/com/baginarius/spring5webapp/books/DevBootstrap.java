package com.baginarius.spring5webapp.books;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initSampleData() {

        Author krajewski = new Author("Marek", "Krajewski");
        Publisher znak = new Publisher("Znak", "Warszawa");
        Book festungBreslau = new Book("Festung Breslau", "454335");
        krajewski.getBooks().add(festungBreslau);
        festungBreslau.getAuthors().add(krajewski);
        festungBreslau.setPublisher(znak);
        publisherRepository.save(znak);
        authorRepository.save(krajewski);
        bookRepository.save(festungBreslau);

        Author gwiazdowski = new Author("Robert", "Gwiazdowski");
        Publisher zysk = new Publisher("Zysk", "Warszawa");
        Book emerytalnaKatastrofa = new Book("Emertyalna katastrofa", "628292");
        emerytalnaKatastrofa.setPublisher(zysk);
        gwiazdowski.getBooks().add(emerytalnaKatastrofa);
        emerytalnaKatastrofa.getAuthors().add(gwiazdowski);
        publisherRepository.save(zysk);
        authorRepository.save(gwiazdowski);
        bookRepository.save(emerytalnaKatastrofa);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initSampleData();
    }
}
