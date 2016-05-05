package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Duyuru;

@Service
public class DuyuruService {

	@Autowired
	private BaseDao baseDao;

	public Duyuru save(Duyuru entity) {
		baseDao.save(entity);
		return entity;
	}

	public Duyuru update(Duyuru entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Duyuru entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Duyuru> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Duyuru.class);
		List<Duyuru> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Duyuru getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Duyuru.class);
		criteria.add(Restrictions.eq("id", id));
		Duyuru ilan = (Duyuru) criteria.uniqueResult();
		return ilan;
	}

	@Transactional
	public Duyuru getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Duyuru.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Duyuru ilan = (Duyuru) criteria.uniqueResult();

		return ilan;
	}
}