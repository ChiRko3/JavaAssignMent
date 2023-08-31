package com.assignment;

import com.assignment.Models.Author;
import com.assignment.Models.Book;
import com.assignment.Repos.AuthorRepo;
import com.assignment.Repos.AuthorRepository;
import com.assignment.Repos.BookCrudRepo;
import com.assignment.Repos.BookRepo;
import com.assignment.service.AuthorService;
import com.assignment.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Assignment2ApplicationTests {

	@Autowired
	private AuthorService authorService;
	@MockBean
	private AuthorRepository authorRepository;
	@MockBean
	private AuthorRepo authorRepo;



	@Autowired
	private  BookService bookService;
	@MockBean
	private BookCrudRepo bookCrudRepo;
	@MockBean
	private BookRepo bookRepo;

	@Test
	public void findAll(){
		when(authorRepository.findAll()).thenReturn(Stream
				.of(new Author("1","Chirag", new String[]{"5911", "Shahdara", "Delhi"}), new Author("1","Chirag", new String[]{"5911", "Shahdara", "Delhi"})).collect(Collectors.toList()));

		assertEquals(2,authorService.findAll().size());
	}

	@Test
	public void insert(){
		Author a = new Author("2","Neeraj",new String[]{"13","ungieun","wgnherg"});
		when(authorRepository.insert(a)).thenReturn(a);

		assertEquals("Neeraj",authorService.insert(a).getName());
	}

	@Test

	public void searchByAuthor(){
		when(authorRepo.searchByAuthor(new String[]{"CHirag","Anuj","hubw"})).thenReturn(Stream
				.of(new Book(1,7,"APB0001","Horror"), new Book(2,59, "APB0250","Fiction")).collect(Collectors.toList()));
		assertEquals("Fiction",authorService.searchByAuthor(new String[]{"CHirag","Anuj","hubw"}).get(1).getGenre());
	}

	@Test
	public void searchAuthor(){
		when(authorRepo.searchAuthor("Chirag")).thenReturn(Stream
				.of(new Author("1","Chirag", new String[]{"5911", "Shahdara", "Delhi"}), new Author("1","Chirag", new String[]{"5911", "Shahdara", "Delhi"})).collect(Collectors.toList()));

		assertEquals("Delhi",authorService.searchAuthor("Chirag").get(1).getAddress()[2]);
	}


	@Test
	public void findALl(){
		when(bookCrudRepo.findAll()).thenReturn(Stream
				.of(new Book(1,7,"APB0001","Horror"), new Book(2,59, "APB0250","Fiction")).collect(Collectors.toList()));

		assertEquals(2,bookService.findAll().size());
	}

	@Test
	public void searchBooks(){
		when(bookRepo.searchBooks("Comedy")).thenReturn(Stream.of(new Book(1,7,"APB0001","Horror"), new Book(2,59, "APB0250","Fiction")).collect(Collectors.toList()));
		assertEquals(2,bookService.searchBooks("Comedy").size());
	}

	@Test
	public void bookInsert(){
		Book book = new Book(7,5911,"APB0001","Science");
		when(bookCrudRepo.insert(book)).thenReturn(book);

		assertEquals("Science",bookService.insert(book).getGenre());
	}
}
