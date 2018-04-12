package com.senecasoap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senecasoap.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
