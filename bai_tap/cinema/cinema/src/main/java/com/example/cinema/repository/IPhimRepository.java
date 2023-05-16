package com.example.cinema.repository;

import com.example.cinema.model.Phim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhimRepository extends JpaRepository<Phim,Integer> {
}
