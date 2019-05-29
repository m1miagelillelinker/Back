package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Association;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationRepository extends CrudRepository<Association,Integer> {
    void deleteById(int id);

    List<Association>  findAllByIdproduitA(String id);

    List<Association> findTop5ByOrderByCreatedatDesc();

    Association findByIdproduitAAndIdproduitB(String idProduitA, String idProduitB);

}
