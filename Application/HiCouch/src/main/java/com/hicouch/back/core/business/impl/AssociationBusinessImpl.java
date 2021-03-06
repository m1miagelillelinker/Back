package com.hicouch.back.core.business.impl;

import com.hicouch.back.core.business.AssociationBusiness;
import com.hicouch.back.core.enumeration.HistoriqueTypeEnum;
import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.model.Association;
import com.hicouch.back.core.model.Historique;
import com.hicouch.back.core.model.User;
import com.hicouch.back.core.service.AssociationService;
import com.hicouch.back.core.service.HistoriqueService;
import com.hicouch.back.core.service.ProduitService;
import com.hicouch.back.core.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class AssociationBusinessImpl implements AssociationBusiness {

    private final AssociationService associationService;
    private final ProduitService produitService;
    private final UserService userService;
	private final EntityManager entityManager;
	private final HistoriqueService historiqueService;

    @Autowired
    public AssociationBusinessImpl(AssociationService associationService, ProduitService produitService, UserService userService, EntityManager entityManager,HistoriqueService historiqueService) {
        this.associationService = associationService;
        this.produitService = produitService;
        this.userService = userService;
        this.entityManager = entityManager;
        this.historiqueService = historiqueService;
    }
    
    @Override
	public Association createOrGetAssociation(String idProductA, String idfournA, String idProductB, String idfournB) throws BusinessException {
		return associationService
				.getAssociationByProduitAAndB(idProductA, idProductB)
				.orElse(createAssociation(idProductA, idfournA, idProductB, idfournB));
	}
    
    @Override
    public Association createAssociation(String idProductA, String idfournA, String idProductB, String idfournB) throws BusinessException {
		Query q = entityManager.createNativeQuery("SELECT NEXT VALUE FOR dbo.assocouple");
		int idPair = (Integer) q.getSingleResult();
		User user = userService.getCurrentUser();
		//On crée deux associations symetriques
		Association asso = new Association(idProductA, idfournA, idProductB, idfournB, idPair, user.getId());
		Association assoMirror = new Association(idProductB, idfournB, idProductA, idfournA, idPair, user.getId());

		try {
			associationService.saveAssociation(asso);
			associationService.saveAssociation(assoMirror);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new BusinessException();
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			throw new BusinessException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException();
		}

		historiqueService.createHistorique(asso.getIdPair(),userService.getCurrentUser().getId(), HistoriqueTypeEnum.ASSOCIATION);
		return asso;
    }

}
