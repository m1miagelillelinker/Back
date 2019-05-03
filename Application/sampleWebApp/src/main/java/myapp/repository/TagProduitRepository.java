package myapp.repository;

import org.springframework.data.repository.CrudRepository;

import myapp.model.TagProduit;

public interface TagProduitRepository extends CrudRepository<TagProduit,Integer> {

}
