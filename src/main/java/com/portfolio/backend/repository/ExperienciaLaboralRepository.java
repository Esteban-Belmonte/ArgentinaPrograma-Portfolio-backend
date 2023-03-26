
package com.portfolio.backend.repository;

import com.portfolio.backend.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExperienciaLaboralRepository extends JpaRepository <ExperienciaLaboral, Long> {
    
}
