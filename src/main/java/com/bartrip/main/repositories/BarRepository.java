package com.bartrip.main.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bartrip.main.entity.Bar.Bar;

public interface BarRepository extends JpaRepository<Bar, Long> {

}
