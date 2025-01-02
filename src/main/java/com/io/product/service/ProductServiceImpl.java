package com.io.product.service;

import com.io.product.config.WebFluxConfig;
import com.io.product.dto.UserDto;
import com.io.product.entity.Product;
import com.io.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private WebClient webClient;
    @Autowired
    private ProductRepo repo;

    @Value("${USER_URL}")
    private String baseUrl;

    public ProductServiceImpl(WebFluxConfig webClient) {
        this.webClient = webClient.webClientBuilder().build();
    }
    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public Product findOne(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        System.out.println("Printing Base Url From Property file"+ baseUrl);
        return repo.findAll();
    }

    @Override
    public UserDto getUser(Long id){

        return webClient.get().uri(baseUrl+"/user/"+id).retrieve().bodyToMono(UserDto.class).block();
    }
}
