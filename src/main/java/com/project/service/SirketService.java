package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Sirket;


@Service
public class SirketService {

	@Autowired
	private BaseDao baseDao;

	public Sirket save(Sirket entity) {
		baseDao.save(entity);
		return entity;
	}

	public Sirket update(Sirket entity) {
		baseDao.update(entity);
		return entity;
	}

	public boolean delete(Sirket entity) {
		baseDao.delete(entity);
		return true;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Sirket> getAll() {
		Criteria criteria = baseDao.getSession().createCriteria(Sirket.class);
		List<Sirket> liste = criteria.list();
		return liste;
	}

	@Transactional
	public Sirket getById(Long id) {
		Criteria criteria = baseDao.getSession().createCriteria(Sirket.class);
		criteria.add(Restrictions.eq("id", id));
		Sirket Sirket = (Sirket) criteria.uniqueResult();
		return Sirket;
	}
	@Transactional
	public Sirket getByName(String name) {
		Criteria criteria = baseDao.getSession().createCriteria(Sirket.class);
		criteria.add(Restrictions.eq("adi", name));
		Sirket Sirket = (Sirket) criteria.uniqueResult();
		return Sirket;
	}


	@Transactional
	public Sirket getUserByLessonName(String lessonname) {

		Criteria criteria = baseDao.getSession().createCriteria(Sirket.class);
		criteria.add(Restrictions.and(Restrictions
				.eq("lessonnname", lessonname)));
		Sirket Sirket = (Sirket) criteria.uniqueResult();

		return Sirket;
	}
}