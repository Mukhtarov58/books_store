package com.example.books_store;


import com.example.books_store.bookRepository.BookRepository;
import com.example.books_store.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        bookRepository.deleteAll();
    }

    @Test
    public void testFindAll() throws Exception {
        Book book1 = new Book();
        book1.setName("Book One");
        book1.setAuthor("Author One");
        book1.setPublicationYear(2001);

        Book book2 = new Book();
        book2.setName("Book Two");
        book2.setAuthor("Author Two");
        book2.setPublicationYear(2002);

        bookRepository.saveAll(Arrays.asList(book1, book2));


        MvcResult mvcResult = mockMvc.perform(get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andReturn();


        String jsonResponse = mvcResult.getResponse().getContentAsString();
        List<Book> books = Arrays.asList(objectMapper.readValue(jsonResponse, Book[].class));
        assertEquals(2, books.size());
    }
}