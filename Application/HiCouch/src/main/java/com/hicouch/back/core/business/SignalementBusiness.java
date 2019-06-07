package com.hicouch.back.core.business;

import com.hicouch.back.core.dto.SignalementDTO;
import com.hicouch.back.core.exception.NoResultException;

public interface SignalementBusiness {
	
	SignalementDTO processSignalement(int signalementId,int status) throws NoResultException;
}
