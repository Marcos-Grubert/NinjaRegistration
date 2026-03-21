package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
    // O JOIN FETCH faz o Hibernate trazer o Ninja e a Mission em um único SELECT
    @Query("SELECT n FROM NinjaModel n JOIN FETCH n.mission")
    List<NinjaModel> findAllWithMissions();
}
