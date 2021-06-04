package com.example.demo;

import com.example.demo.NumerZamowienia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NrZamowieniaRepo extends JpaRepository <NumerZamowienia, String> {

}

