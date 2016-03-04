package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Tercihler;

@Service
public class TercihlerService {

	@Autowired
	private BaseDao baseDao;

	public Tercihler save(Tercihler entity) {
		baseDao.save(entity);
		return entity;
	}

	public Tercihler update(Tercihler entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Tercihler entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Tercihler> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Tercihler.class);
		List<Tercihler> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Tercihler getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Tercihler.class);
		criteria.add(Restrictions.eq("id", id));
		Tercihler tercihler = (Tercihler) criteria.uniqueResult();
		return tercihler;
	}

	@Transactional
	public Tercihler getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Tercihler.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Tercihler tercihler = (Tercihler) criteria.uniqueResult();

		return tercihler;
	}
}