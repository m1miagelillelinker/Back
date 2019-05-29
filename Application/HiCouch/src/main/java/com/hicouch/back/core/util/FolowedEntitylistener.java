package com.hicouch.back.core.util;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class FolowedEntitylistener implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
    /*@Override
    public String getCurrentAuditor() {
        return "hicfrt";
    }*/
}
