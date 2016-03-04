package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Kayit;

@Service
public class KayitService {

	@Autowired
	private BaseDao baseDao;

	public Kayit save(Kayit entity) {
		baseDao.save(entity);
		return entity;
	}

	public Kayit update(Kayit entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Kayit entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Kayit> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Kayit.class);
		List<Kayit> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Kayit getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Kayit.class);
		criteria.add(Restrictions.eq("id", id));
		Kayit kayit = (Kayit) criteria.uniqueResult();
		return kayit;
	}

	@Transactional
	public Kayit getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Kayit.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Kayit kayit = (Kayit) criteria.uniqueResult();

		return kayit;
	}
}