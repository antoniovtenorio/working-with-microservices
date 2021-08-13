package one.dio.experts.shoppingcarts.controller;

import one.dio.experts.shoppingcarts.model.Cart;
import one.dio.experts.shoppingcarts.model.Item;
import one.dio.experts.shoppingcarts.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable Integer id, @RequestBody Item item){
        Optional<Cart> saveCart = cartRepository.findById(id);
        Cart cart;
        if(saveCart.equals(Optional.empty())){
            cart = new Cart(id);
        } else {
            cart = saveCart.get();
        }
        cart.getItems().add(item);

        return cartRepository.save(cart);
    }
    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable Integer id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cartRepository.deleteById(id);
    }
}
