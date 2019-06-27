package com.hicouch.back.core.service.impl;

import com.hicouch.back.core.dto.AssociationDTO;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.factory.AssociationFactory;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.repository.AssociationRepository;
import com.hicouch.back.core.service.AssociationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AssociationServiceImpl implements AssociationService {

	private final AssociationRepository associationRepository;
	private final AssociationFactory associationFactory;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	public AssociationServiceImpl(AssociationRepository associationRepository, AssociationFactory associationFactory) {
		this.associationRepository = associationRepository;
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
	public int countAssosByIdUser(int iduser) {
		return associationRepository.countByIdUser(iduser);
	}

	@Override
	public Optional<Association> getAssociationByProduitAAndB(String idProduitA, String idProduitB) {
		return Optional.ofNullable(associationRepository.findByIdproduitAAndIdproduitB(idProduitA, idProduitB));
	}

	@Override
	public Association saveAssociation(Association association) {
		return associationRepository.save(association);
	}

    @Override
    public List<Association> getAssociationByIdPaire(int idPair) {
        return associationRepository.findAllByIdPair(idPair);
    }

    @Override
    public List<Association> getAllAssociationByIdUser(int userId) {
        return associationRepository.findAllByIdUser(userId);
    }
}
