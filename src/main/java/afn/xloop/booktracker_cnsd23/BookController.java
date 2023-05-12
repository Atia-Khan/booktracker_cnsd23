package afn.xloop.booktracker_cnsd23;


import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo){
        this.repo = repo;
    }

    //localhost:8080/books
    @PostMapping("")
    public void createBook(@RequestBody Book book){
        this.repo.save(book);
        
    }

    @DeleteMapping("")
    public String deleteBook(@RequestBody Book book){
        this.repo.delete(book);
        return "Book Deleted ! " + book.getTitle();
    }

    @PutMapping("")
    public String updateBook(@RequestBody Book book){
        this.repo.update(book);
        return "Book updated as " + book.getTitle();
    }

    @GetMapping("/all")
    public Collection<Book> getAllBooks(){
        return this.repo.getAllBook();
    }

}
