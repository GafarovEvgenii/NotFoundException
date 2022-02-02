package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product first = new Book(1, "Jane Air", 150, "Sharlotte Bronte", 350, 1847);
    Product second = new Book(2, "The Wizard of Oz", 180, "L.F.Baum", 413, 1939);
    Product third = new TShirt(3, "Happy", 990, "White", "Large");
    Product fourth = new TShirt(4, "UnHappy", 1290, "Black", "Medium");

    @BeforeEach
    public void shouldStartManager() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    public void shouldRemoveId5() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });
    }


    @Test
    public void shouldRemoveId3() {
        repository.removeById(3);
        Product[] expected = new Product[]{first, second, fourth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}
