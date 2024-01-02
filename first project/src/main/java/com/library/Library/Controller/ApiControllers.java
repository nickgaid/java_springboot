package com.library.Library.Controller;

import com.library.Library.Models.Book;
import com.library.Library.Models.User;
import com.library.Library.Repository.BookRepo;
import com.library.Library.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookRepo bookRepo;

    @GetMapping(value="/")
    public String getPage(){
        return "Καλος ήρθες στην αρχική σελίδα!";
    }
    @GetMapping(value ="/user")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/saveUser")
    public String SaveUser(@RequestBody User user){
        userRepo.save(user);
        return "Επιτυχής αποθήκευση χρήστη!";
    }
    @PutMapping (value = "/updateUser/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User user){
        User updatedUser =userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setTk(user.getTk());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setStreet(user.getStreet());
        updatedUser.setCity(user.getCity());
        updatedUser.setBirthday(user.getBirthday());
        updatedUser.setGender(user.getGender());
        userRepo.save(updatedUser);
        return "Επιτυχής ανανέωση χρήστη!";

    }
    @DeleteMapping (value = "/deleteUser/{at}")
    public String deleteUser(@PathVariable int at){
        User deleteUser = userRepo.findById(at).get();
        userRepo.delete(deleteUser);
        return "Διαγραφή χρήστη με αριθμό μητρόου : "+at;

    }
    @GetMapping(value ="/book")
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    @PostMapping(value = "/saveBook")
    public String SaveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "Επιτυχής αποθήκευση βιβλίου";
    }
    @PutMapping (value = "/updateBook/{isbnPass}")
    public String updateBook(@PathVariable int isbnPass,@RequestBody Book book){
        Book updateBook =bookRepo.findById(isbnPass).get();
        updateBook.setTitle(book.getTitle());
        updateBook.setSummary(book.getSummary());
        updateBook.setReleaseDate(book.getReleaseDate());
        bookRepo.save(updateBook);
        return "Επιτυχής ανανέωση βιβλίου!";
    }


    @DeleteMapping (value = "/deleteBook/{isbnPass}")
    public String deleteBooks(@PathVariable int isbnPass){
        Book deleteBook = bookRepo.findById(isbnPass).get();
        bookRepo.delete(deleteBook);
        return "Διαγραφή βιβλίου με ISBN : "+isbnPass;

    }
}
