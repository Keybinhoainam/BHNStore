package B19DCCN445.responsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import B19DCCN445.domain.Category;



@Repository
public interface CategoryReposity extends JpaRepository<Category, Long>{
	@Query("select c from Category c where c.name like %?1%")
	List<Category> findByNameContaining(String name);
//	Page<Category> findByNameContaining(String name,Pageable pageable);
}
