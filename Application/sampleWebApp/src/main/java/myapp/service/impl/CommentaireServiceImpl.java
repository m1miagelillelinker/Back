package myapp.service.impl;

import myapp.repository.CommentaireRepository;
import myapp.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	
    @Autowired
    private CommentaireRepository commentaireRepository;

}
