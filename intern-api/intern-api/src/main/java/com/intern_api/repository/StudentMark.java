package com.intern_api.repository;

import com.intern_api.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMark extends JpaRepository<Mark,Integer> {
}
