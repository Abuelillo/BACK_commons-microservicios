package com.micro.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

//public class CommonServiceImp<E,R extends CrudRepository<E,Long>> implements CommonService<E> {
public class CommonServiceImp<E,R extends PagingAndSortingRepository<E,Long>> implements CommonService<E> {
	@Autowired
	protected R repo;
	 
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return repo.findAll();
		}

	@Override
	@Transactional
	public Optional<E> findById(Long id) {
		return repo.findById(id);
		}

	@Override
	@Transactional
	public E save(E entity) {
		return repo.save(entity);
		}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repo.deleteById(id);
		}

	@Override
	public Page<E> findAll(Pageable pageable) {		
		return repo.findAll(pageable);
	}

}
