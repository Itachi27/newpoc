package com.example.activity.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.activity.model.Activity;
public interface ActivityRepository extends JpaRepository<Activity, Long> {
  List<Activity> findBycompleted(boolean completed);
  List<Activity> findByTitleContaining(String title);
}

