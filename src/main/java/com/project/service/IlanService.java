package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Ilan;

@Service
public class IlanService {

	@Autowired
	private BaseDao baseDao;

	public Ilan save(Ilan entity) {
		baseDao.save(entity);
		return entity;
	}

	public Ilan update(Ilan entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Ilan entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Ilan> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Ilan.class);
		List<Ilan> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Ilan getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Ilan.class);
		criteria.add(Restrictions.eq("id", id));
		Ilan ilan = (Ilan) criteria.uniqueResult();
		return ilan;
	}

	@Transactional
	public Ilan getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Ilan.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Ilan ilan = (Ilan) criteria.uniqueResult();

		return ilan;
	}
}