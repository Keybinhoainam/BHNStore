package B19DCCN445.responsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import B19DCCN445.domain.OrderDetail;


@Repository
public interface OrderDetailResponsitory extends JpaRepository<OrderDetail, Long>{
	@Query("select od from OrderDetail od where od.order.orderId = ?1")
	List<OrderDetail> findByOrderId(Long id);
}
