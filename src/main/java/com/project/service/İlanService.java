package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.�lan;

@Service
public class �lanService {

	@Autowired
	private BaseDao baseDao;

	public �lan save(�lan entity) {
		baseDao.save(entity);
		return entity;
	}

	public �lan update(�lan entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(�lan entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<�lan> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(�lan.class);
		List<�lan> liste = criteria.list();
		return liste;
	}

	@Transactional
	public �lan getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(�lan.class);
		criteria.add(Restrictions.eq("id", id));
		�lan ilan = (�lan) criteria.uniqueResult();
		return ilan;
	}

	@Transactional
	public �lan getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(�lan.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		�lan ilan = (�lan) criteria.uniqueResult();

		return ilan;
	}
}