package pl.project.pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PackRepository extends JpaRepository<Pack, Integer> {
    @Query(value = "SELECT p.packId FROM Pack p where p.position = 0")
    int findFirstEmptyPlaceToStorePack();
}

