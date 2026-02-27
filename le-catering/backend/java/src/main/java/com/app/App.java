package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@RestController
@SuppressWarnings("null")
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private final ContactRepository repository;

    public App(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return repository.save(contact);
    }
}

@Entity
@Table(name = "contact")
class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Column(name = "nb_customers")
    private int nbCustomers;

    private LocalDateTime date;

    private String message;

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getNbCustomers() { return nbCustomers; }
    public void setNbCustomers(int nbCustomers) { this.nbCustomers = nbCustomers; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

interface ContactRepository extends JpaRepository<Contact, Long> {}