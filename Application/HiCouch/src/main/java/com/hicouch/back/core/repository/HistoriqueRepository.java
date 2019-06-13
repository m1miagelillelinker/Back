package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Historique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriqueRepository extends CrudRepository<Historique,Integer> {

    List<Historique> findAllByIdUser(Integer id);

}
