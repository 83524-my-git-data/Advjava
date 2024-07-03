package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Tag;

public interface TagDao extends JpaRepository<Tag,Long> {

}
