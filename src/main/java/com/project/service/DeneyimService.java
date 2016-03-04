package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Deneyim;

@Service
public class DeneyimService {

	@Autowired
	private BaseDao baseDao;

	public Deneyim save(Deneyim entity) {
		baseDao.save(entity);
		return entity;
	}

	public Deneyim update(Deneyim entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Deneyim entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Deneyim> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Deneyim.class);
		List<Deneyim> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Deneyim getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Deneyim.class);
		criteria.add(Restrictions.eq("id", id));
		Deneyim deneyim = (Deneyim) criteria.uniqueResult();
		return deneyim;
	}

	@Transactional
	public Deneyim getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Deneyim.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Deneyim deneyim = (Deneyim) criteria.uniqueResult();

		return deneyim;
	}
}