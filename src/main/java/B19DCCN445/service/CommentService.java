package B19DCCN445.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import B19DCCN445.domain.Comment;



public interface CommentService {

	<S extends Comment> List<S> findAll(Example<S> example, Sort sort);

	<S extends Comment> List<S> findAll(Example<S> example);

	Comment getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Comment> entities);

	Comment getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Comment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Comment entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Comment> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Comment> entities);

	<S extends Comment> long count(Example<S> example);

	void deleteInBatch(Iterable<Comment> entities);

	<S extends Comment> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Comment> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Comment> S saveAndFlush(S entity);

	void flush();

	<S extends Comment> List<S> saveAll(Iterable<S> entities);

	Optional<Comment> findById(Long id);

	List<Comment> findAllById(Iterable<Long> ids);

	List<Comment> findAll(Sort sort);

	Page<Comment> findAll(Pageable pageable);

	List<Comment> findAll();

	<S extends Comment> Optional<S> findOne(Example<S> example);

	<S extends Comment> S save(S entity);

	List<Comment> findByProduct(Long x);

}
