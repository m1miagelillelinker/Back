package com.hicouch.back.core.business;

import com.hicouch.back.core.exception.NoResultException;
import com.hicouch.back.core.model.Vote;

public interface VoteBusiness {
    Vote upsertVote(Vote vote) throws NoResultException;
}
