package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.repository.AssociationRepository;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.factory.AssociationFactory;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.service.AssociationService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class AssociationServiceImpl implements AssociationService {

	private final AssociationRepository associationRepository;
	private final EntityManager entityManager;
	private final AssociationFactory associationFactory;

	@Autowired
	public AssociationServiceImpl(AssociationRepository associationRepository, EntityManager entityManager,
			AssociationFactory associationFactory) {
		this.associationRepository = associationRepository;
		this.entityManager = entityManager;
		this.associationFactory = associationFactory;
	}

	@Override
	public List<AssociationDTO> getAssociationsByIdProduct(String idProduct) throws Exception {
		return associationRepository.findAllByIdproduitA(idProduct)
				.stream()
				.map(associationFactory::getAssociationDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<AssociationDTO> getTopLastAssociations() throws Exception {
		return associationRepository.findTop5ByOrderByCreatedatDesc()
				.stream()
				.map(associationFactory::getAssociationDTO)
				.collect(Collectors.toList());
	}

	@Override
	public String deleteAssociation(int idAssociation) {
		associationRepository.deleteById(idAssociation);
		return "Le delete a ete fait";
	}

	@Override
	public Association createAssociation(String idProductA, String idfournA, String idProductB, String idfournB) throws Exception {


		//l'association existe deja? alors on retourne celle qui existe deja plutot qu'une erreur 500
		Optional<Association> assoExists = Optional.ofNullable(associationRepository.findByIdproduitAAndIdproduitB(idProductA, idProductB));
		if ( assoExists.isPresent() ){
			return assoExists.get();
		}

		LocalDateTime maintenant = LocalDateTime.now();

		//Query q = entityManager.createNativeQuery("SELECT NEXT VALUE FOR dbo.assocouple");
		//int idPair = (Integer) q.getSingleResult();

		Association asso = new Association();
		asso.setIdproduitA(idProductA);
		asso.setIdfournA(idfournA);
		asso.setIdproduitB(idProductB);
		asso.setIdfournB(idfournB);
		//asso.setIdPair(idPair);
		asso.setCreatedat(maintenant);
		asso.setUpdatedat(maintenant);

		Association assoMirror = new Association();
		assoMirror.setIdproduitA(idProductB);
		assoMirror.setIdfournA(idfournB);
		assoMirror.setIdproduitB(idProductA);
		assoMirror.setIdfournB(idfournA);
		//assoMirror.setIdPair(idPair);
		assoMirror.setCreatedat(maintenant);
		assoMirror.setUpdatedat(maintenant);

		try {
			associationRepository.save(asso);
			associationRepository.save(assoMirror);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return asso; //TODO Ne devrait'on pas retourner une ASSODTO?
	}
}
