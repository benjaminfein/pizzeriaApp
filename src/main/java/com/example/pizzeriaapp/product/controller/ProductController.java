package com.example.pizzeriaapp.product.controller;

import com.example.pizzeriaapp.product.model.Product;
import com.example.pizzeriaapp.product.service.ProductService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String getAllProducts(@RequestParam(name = "title", required = false) String title, Model model) {
        /*
        RequestParam - мы указываем title как запрашиваемый параметр, однако при помощи required мы определяем что он
        не обязательный
         */
        model.addAttribute("products", productService.getAllProducts(title));
        /*
        model.addAttribute используется для передачи данных с памяти(репозиторий) в сам html, где
        products - название нашего списка, которое будет в последующем использоваться в html,
        а productService.getAllProduct() - метод, который выводит все продукты из нашего списка
        */
        return "products";//вывод нашей станички html из папки templates
    }

    @GetMapping("/product/{id}")
    public String aboutProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/";//Обновляет страничку с новым продуктом
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {//@PathVariable позволяет получить переменную из ссылки, для этого в ссылке написаны {id}
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
