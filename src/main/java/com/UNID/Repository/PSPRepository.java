package com.UNID.Repository;

import com.UNID.Entity.PSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PSPRepository extends JpaRepository<PSP, Integer> {
}