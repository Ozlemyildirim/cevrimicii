package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Referans;

@Service
public class ReferansService {

	@Autowired
	private BaseDao baseDao;

	public Referans save(Referans entity) {
		baseDao.save(entity);
		return entity;
	}

	public Referans update(Referans entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Referans entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Referans> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Referans.class);
		List<Referans> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Referans getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Referans.class);
		criteria.add(Restrictions.eq("id", id));
		Referans referans = (Referans) criteria.uniqueResult();
		return referans;
	}

	@Transactional
	public Referans getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Referans.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Referans referans = (Referans) criteria.uniqueResult();

		return referans;
	}
}