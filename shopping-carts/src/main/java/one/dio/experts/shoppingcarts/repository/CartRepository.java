package one.dio.experts.shoppingcarts.repository;

import one.dio.experts.shoppingcarts.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
