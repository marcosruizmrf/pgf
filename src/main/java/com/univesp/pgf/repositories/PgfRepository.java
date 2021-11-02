package com.univesp.pgf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.univesp.pgf.domain.Pgf;

@Repository
public interface PgfRepository extends JpaRepository<Pgf, Integer> {

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar ASC")
	List<Pgf> findAllOpen();

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar ASC")
	List<Pgf> findAllClose();

}
