package com.project.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Kullanici;

/**
 *
 * @author vektorel
 */
@Service
public class KullaniciService {

	@Autowired
	private transient BaseDao baseDao;
	
    public Kullanici save(Kullanici entity) {
    	baseDao.save(entity);
        return entity;
    }

    public Kullanici update(Kullanici entity) {
    	baseDao.update(entity);
        return entity;
    }

    public boolean delete(Kullanici entity) {
    	baseDao.delete(entity);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Transactional
	public List<Kullanici> getAll() {
        Criteria criteria = baseDao.getSession().createCriteria(Kullanici.class);
        List<Kullanici> kullanicis = baseDao.getByCriteria(criteria);
        return kullanicis;
    }

    @Transactional
    public Kullanici getById(Long id) {
        Criteria criteria = baseDao.getSession().createCriteria(Kullanici.class);
        criteria.add(Restrictions.eq("id", id));
        Kullanici kullanici = (Kullanici) criteria.uniqueResult();
        return kullanici;
    }
    
    @Transactional
        public Kullanici getUserByUsernameAndPwd(String username , String pwd) {            
        Criteria criteria = baseDao.getSession().createCriteria(Kullanici.class);
        criteria.add(Restrictions.and(Restrictions.eq("username", username),Restrictions.eq("password", pwd)));
        Kullanici  kullanici  = (Kullanici) criteria.uniqueResult();
        return kullanici;
    }
}