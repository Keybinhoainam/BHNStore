package B19DCCN445.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import B19DCCN445.domain.Order;



public interface OrderResponsitory extends JpaRepository<Order, Long>{

}
