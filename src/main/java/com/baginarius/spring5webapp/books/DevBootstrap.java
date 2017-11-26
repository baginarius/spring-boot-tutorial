package com.baginarius.spring5webapp.books;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initSampleData() {

        Author krajewski = new Author("Marek", "Krajewski");
        Book festungBreslau = new Book("Festung Breslau", "454335", "Znak");
        krajewski.getBooks().add(festungBreslau);
        festungBreslau.getAuthors().add(krajewski);
        authorRepository.save(krajewski);
        bookRepository.save(festungBreslau);

        Author gwiazdowski = new Author("Robert", "Gwiazdowski");
        Book emerytalnaKatastrofa = new Book("Emertyalna katastrofa", "628292", "Zysk");
        gwiazdowski.getBooks().add(emerytalnaKatastrofa);
        emerytalnaKatastrofa.getAuthors().add(gwiazdowski);
        authorRepository.save(gwiazdowski);
        bookRepository.save(emerytalnaKatastrofa);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initSampleData();
    }
}
