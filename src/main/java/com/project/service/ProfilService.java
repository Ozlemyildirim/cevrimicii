package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Profil;

@Service
public class ProfilService {

	@Autowired
	private BaseDao baseDao;

	public Profil save(Profil entity) {
		baseDao.save(entity);
		return entity;
	}

	public Profil update(Profil entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Profil entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Profil> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Profil.class);
		List<Profil> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Profil getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Profil.class);
		criteria.add(Restrictions.eq("id", id));
		Profil profil = (Profil) criteria.uniqueResult();
		return profil;
	}

	@Transactional
	public Profil getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Profil.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Profil profil = (Profil) criteria.uniqueResult();

		return profil;
	}
}