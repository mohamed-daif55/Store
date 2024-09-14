package com.its.store.repo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByDate(LocalDate date);

}
