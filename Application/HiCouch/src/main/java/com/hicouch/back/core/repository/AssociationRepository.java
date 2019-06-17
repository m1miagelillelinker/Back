package com.hicouch.back.core.repository;

import com.hicouch.back.core.model.Association;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociationRepository extends CrudRepository<Association,Integer> {
    void deleteById(int id);

    List<Association>  findAllByIdproduitA(String id);

    /**
     * @param id
     * @return an association
     */
    Optional<Association> findFirstByIdPair(int id);

    List<Association> findTop5ByOrderByCreatedatDesc();

    Association findByIdproduitAAndIdproduitB(String idProduitA, String idProduitB);

    List<Association> findAllBycreator(String creator);

}
