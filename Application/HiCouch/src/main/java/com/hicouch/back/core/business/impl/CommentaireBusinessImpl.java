

import com.hicouch.back.core.service.UserService;
    private UserService userService;
    public CommentaireBusinessImpl(CommentaireService commentaireService, AssociationService associationService, UserService userService) {
        commentaire.setIdUser(userService.getCurrentUser().getId());
        return commentaireService.addCommentaire(commentaire);

    @Autowired
    public CommentaireBusinessImpl(CommentaireService commentaireService, AssociationService associationService, UserService userService, HistoriqueService historiqueService) {
        super();
        this.commentaireService = commentaireService;
        this.associationService = associationService;
        this.userService = userService;
        this.historiqueService = historiqueService;
    }

    //TODO Faire en sorte que le SPAM ne soit pas possible (limiter le nombre de commentaires par minute par exemple
    public Commentaire addCommentaire(Commentaire commentaire) throws BusinessException, DataProvidedException {
        if ( ! associationService.checkIfIdPairExists(commentaire.getIdPair())){
            throw new BusinessException();
        }

        Commentaire commentaire1 = commentaireService.addCommentaire(commentaire);
        historiqueService.addToHistorique("Commentaire : "+commentaire1.getCommentaire(), userService.getCurrentUser().getId());
        return commentaire1;
    }


}
