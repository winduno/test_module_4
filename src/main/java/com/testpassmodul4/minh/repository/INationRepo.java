package com.testpassmodul4.minh.repository;

import com.testpassmodul4.minh.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INationRepo extends JpaRepository<Nation, Integer> {
}
