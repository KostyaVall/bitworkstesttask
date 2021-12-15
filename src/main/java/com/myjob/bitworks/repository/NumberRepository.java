package com.myjob.bitworks.repository;

import com.myjob.bitworks.model.Number;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Integer> {

}
