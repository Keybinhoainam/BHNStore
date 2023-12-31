package B19DCCN445.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import B19DCCN445.domain.CartItem;



public interface CartItemResponsitory extends JpaRepository<CartItem, Long>{
	@Query("select ci from CartItem ci where ci.account.id = ?1")
	List<CartItem> findCartItem(Long id);
	@Query("delete from CartItem ci where ci.account.id = ?1")
	void DeleteCartItem(Long id);
}
