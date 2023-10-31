package B19DCCN445.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import B19DCCN445.domain.Comment;
import B19DCCN445.responsitory.CommentResponsitory;
import B19DCCN445.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentResponsitory commentResponsitory;

	@Override
	public List<Comment> findByProduct(Long x) {
		return commentResponsitory.findByProduct(x);
	}

	@Override
	public <S extends Comment> S save(S entity) {
		return commentResponsitory.save(entity);
	}

	@Override
	public <S extends Comment> Optional<S> findOne(Example<S> example) {
		return commentResponsitory.findOne(example);
	}

	@Override
	public List<Comment> findAll() {
		return commentResponsitory.findAll();
	}

	@Override
	public Page<Comment> findAll(Pageable pageable) {
		return commentResponsitory.findAll(pageable);
	}

	@Override
	public List<Comment> findAll(Sort sort) {
		return commentResponsitory.findAll(sort);
	}

	@Override
	public List<Comment> findAllById(Iterable<Long> ids) {
		return commentResponsitory.findAllById(ids);
	}

	@Override
	public Optional<Comment> findById(Long id) {
		return commentResponsitory.findById(id);
	}

	@Override
	public <S extends Comment> List<S> saveAll(Iterable<S> entities) {
		return commentResponsitory.saveAll(entities);
	}

	@Override
	public void flush() {
		commentResponsitory.flush();
	}

	@Override
	public <S extends Comment> S saveAndFlush(S entity) {
		return commentResponsitory.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return commentResponsitory.existsById(id);
	}

	@Override
	public <S extends Comment> List<S> saveAllAndFlush(Iterable<S> entities) {
		return commentResponsitory.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Comment> Page<S> findAll(Example<S> example, Pageable pageable) {
		return commentResponsitory.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Comment> entities) {
		commentResponsitory.deleteInBatch(entities);
	}

	@Override
	public <S extends Comment> long count(Example<S> example) {
		return commentResponsitory.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Comment> entities) {
		commentResponsitory.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return commentResponsitory.count();
	}

	@Override
	public <S extends Comment> boolean exists(Example<S> example) {
		return commentResponsitory.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		commentResponsitory.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		commentResponsitory.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Comment entity) {
		commentResponsitory.delete(entity);
	}

	@Override
	public <S extends Comment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return commentResponsitory.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		commentResponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		commentResponsitory.deleteAllInBatch();
	}

	@Override
	public Comment getOne(Long id) {
		return commentResponsitory.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Comment> entities) {
		commentResponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		commentResponsitory.deleteAll();
	}

	@Override
	public Comment getById(Long id) {
		return commentResponsitory.getById(id);
	}

	@Override
	public <S extends Comment> List<S> findAll(Example<S> example) {
		return commentResponsitory.findAll(example);
	}

	@Override
	public <S extends Comment> List<S> findAll(Example<S> example, Sort sort) {
		return commentResponsitory.findAll(example, sort);
	}
	
}
