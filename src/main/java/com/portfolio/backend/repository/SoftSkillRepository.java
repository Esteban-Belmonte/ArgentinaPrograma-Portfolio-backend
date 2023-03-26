
package com.portfolio.backend.repository;

import com.portfolio.backend.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends JpaRepository <SoftSkill, Long> {
    
}
