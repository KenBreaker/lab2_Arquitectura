package com.papel.higienico.repository;

import com.papel.higienico.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelHigienicoRepository extends JpaRepository<Paper, Long> {

}