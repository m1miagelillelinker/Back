package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit,Integer> {
}
