package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product item1 = new Book(1, "nameqwerty1", 60, "author1");
    Product item2 = new Book(2, "name2", 70, "author2");
    Product item3 = new Smartphone(3, "name3", 80, "manuf3");
    Product item4 = new Smartphone(4, "nameqwerty4", 90, "manuf4");
    Product item5 = new Smartphone(5, "name5", 100, "man5");

    @BeforeEach
    public void setup() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
    }

    @Test
    public void shouldFindAllIfEmptyRepo() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllIfNotEmptyRepo() {

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneProductInEmptyRepo() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        repo.add(item4);

        Product[] expected = {item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneProductInNotEmptyRepo() {
        repo.add(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTwoProductsInNotEmptyRepo() {
        repo.add(item4);
        repo.add(item5);

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOneProduct() {
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTwoProducts() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());

        Product[] expected = {item3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAllProducts() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}
