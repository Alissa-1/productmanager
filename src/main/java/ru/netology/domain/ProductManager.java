package ru.netology.domain;

import ru.netology.repository.ProductRepository;

import java.util.Arrays;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.add(product);
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);  - contains возвращает true or false
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];

        for (Product product : repo.findAll()) {
            Product[] tmp = new Product[result.length + 1];

            if (matches(product, text)) {
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

// ДРУГОЙ СПОСОБ
//    public Product[] searchByl(String text) {
//        Product[] result = new Product[0];
//
//        for (Product product : repo.findAll()) {
//
//            if (matches(product, text)) {
//                result = Arrays.copyOf(result, result.length + 1); // ТАКАЯ ШТУЧКА
//                result[result.length - 1] = product;
//            }
//        }
//        return result;
//    }
}
