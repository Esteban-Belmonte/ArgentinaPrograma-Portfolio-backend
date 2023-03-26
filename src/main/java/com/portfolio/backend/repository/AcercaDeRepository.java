
package com.portfolio.backend.repository;

import com.portfolio.backend.model.AcercaDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcercaDeRepository extends JpaRepository <AcercaDe, Long> {
    
}
