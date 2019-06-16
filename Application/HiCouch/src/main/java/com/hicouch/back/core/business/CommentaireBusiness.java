package com.hicouch.back.core.business;

import com.hicouch.back.core.exception.BusinessException;
import com.hicouch.back.core.exception.DataProvidedException;
import com.hicouch.back.core.model.Commentaire;

public interface CommentaireBusiness {

    public Commentaire addCommentaire(Commentaire commentaire) throws BusinessException;
}
