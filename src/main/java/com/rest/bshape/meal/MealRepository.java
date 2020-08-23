package com.rest.bshape.meal;

import com.rest.bshape.meal.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface MealRepository extends JpaRepository<Meal, Long> {
}