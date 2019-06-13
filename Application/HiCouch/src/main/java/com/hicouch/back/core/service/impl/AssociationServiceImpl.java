package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.model.User;
import com.hicouch.back.core.repository.AssociationRepository;
import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.factory.AssociationFactory;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.service.AssociationService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	public AssociationServiceImpl(AssociationRepository associationRepository, EntityManager entityManager, AssociationFactory associationFactory) {
		this.associationRepository = associationRepository;
		this.entityManager = entityManager;
		this.associationFactory = associationFactory;
	}

	@Override
	public List<AssociationDTO> getAssociationsByIdProduct(String idProduct) throws BusinessException {
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
	public AssociationDTO getAssociationByIdPair(int idPair){
		return associationFactory.getAssociationDTO(associationRepository.findFirstByIdPair(idPair).get());
	}

	@Override
	public boolean checkIfIdPairExists(int idPair) {
		return associationRepository.findFirstByIdPair(idPair).isPresent();
	}

	@Override
	public String deleteAssociation(int idAssociation) {
		associationRepository.deleteById(idAssociation);
		return "Le delete a ete fait";
	}

	@Override
	public Association createAssociation(String idProductA, String idfournA, String idProductB, String idfournB, Integer iduser) throws BusinessException {


		//l'association existe deja? alors on retourne celle qui existe deja plutot qu'une erreur 500
		Optional<Association> assoExists = Optional.ofNullable(associationRepository.findByIdproduitAAndIdproduitB(idProductA, idProductB));
		if ( assoExists.isPresent() ){
			return assoExists.get();
		}

		LocalDateTime maintenant = LocalDateTime.now();

		Query q = entityManager.createNativeQuery("SELECT NEXT VALUE FOR dbo.assocouple");
		int idPair = (Integer) q.getSingleResult();

		//On crée deux associations symetriques
		Association asso = new Association(idProductA, idfournA, idProductB, idfournB, idPair, iduser);
		Association assoMirror = new Association(idProductB, idfournB, idProductA, idfournA, idPair, iduser);

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
			throw new BusinessException();
		}
		return asso; //TODO Ne devrait'on pas retourner une ASSODTO?
	}

	@Override
	public int countAssosByIdUser(int iduser) {
		return associationRepository.countByIdUser(iduser);
	}
}
