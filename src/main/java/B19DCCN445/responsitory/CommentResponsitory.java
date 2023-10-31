package B19DCCN445.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import B19DCCN445.domain.Comment;


@Repository
public interface CommentResponsitory extends JpaRepository<Comment, Long>{
	@Query("select cm from Comment cm where cm.productId=?1")
	List<Comment> findByProduct(Long x);
}
