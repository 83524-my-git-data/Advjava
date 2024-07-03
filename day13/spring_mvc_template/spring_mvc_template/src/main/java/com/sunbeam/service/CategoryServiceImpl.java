package com.sunbeam.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sunbeam.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }
}

