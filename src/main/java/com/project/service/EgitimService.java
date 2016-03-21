package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Egitim;

@Service
public class EgitimService {

	@Autowired
	private BaseDao baseDao;

	public Egitim save(Egitim entity) {
		baseDao.save(entity);
		return entity;
	}

	public Egitim update(Egitim entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Egitim entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Egitim> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Egitim.class);
		List<Egitim> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Egitim getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Egitim.class);
		criteria.add(Restrictions.eq("id", id));
		Egitim egitim = (Egitim) criteria.uniqueResult();
		return egitim;
	}

	@Transactional
	public Egitim getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Egitim.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Egitim egitim = (Egitim) criteria.uniqueResult();

		return egitim;
	}
}