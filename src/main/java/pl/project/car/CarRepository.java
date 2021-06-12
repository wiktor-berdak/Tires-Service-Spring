package pl.project.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT c FROM Car c WHERE c.user.userId=:userId")
    List<Car> findAllCarsByUserid(@Param("userId") Integer userId);

}
