package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Ýlan;

@Service
public class ÝlanService {

	@Autowired
	private BaseDao baseDao;

	public Ýlan save(Ýlan entity) {
		baseDao.save(entity);
		return entity;
	}

	public Ýlan update(Ýlan entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Ýlan entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Ýlan> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Ýlan.class);
		List<Ýlan> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Ýlan getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Ýlan.class);
		criteria.add(Restrictions.eq("id", id));
		Ýlan ilan = (Ýlan) criteria.uniqueResult();
		return ilan;
	}

	@Transactional
	public Ýlan getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Ýlan.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Ýlan ilan = (Ýlan) criteria.uniqueResult();

		return ilan;
	}
}