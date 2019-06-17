

import com.hicouch.back.core.service.UserService;
    private UserService userService;
    public CommentaireBusinessImpl(CommentaireService commentaireService, AssociationService associationService, UserService userService) {
        commentaire.setIdUser(userService.getCurrentUser().getId());
        return commentaireService.addCommentaire(commentaire);
