--1-Status
INSERT INTO [dbo].[status] ([libelle], [createdat], [updatedat]) VALUES ('toModerate', getdate(), getdate());
INSERT INTO [dbo].[status] ([libelle], [createdat], [updatedat]) VALUES ('ok', getdate(), getdate());
INSERT INTO [dbo].[status] ([libelle], [createdat], [updatedat]) VALUES ('blocked', getdate(), getdate());
INSERT INTO [dbo].[status] ([libelle], [createdat], [updatedat]) VALUES ('hidden', getdate(), getdate());

--2-frn
INSERT INTO [dbo].[fournisseurs] ([libelle], [url], [requestMethod], [apikey], [type])
VALUES ('omdb', 'http://www.omdbapi.com/', 'GET', '9b0bebec', 'video');
INSERT INTO [dbo].[fournisseurs] ([libelle], [url], [requestMethod], [apikey], [type])
VALUES ('googlebooks', 'https://www.googleapis.com/books/v1/', 'GET', NULL, 'book');


INSERT INTO [dbo].[badges] ([badge], [createdat], [updatedat], [imgUrl], [seuil], [status], [applyOn])
VALUES ('Youngling', getdate(), getdate(), 'https://hicouchphp.azurewebsites.net/img/youngling.png', '1', '4','association');
INSERT INTO [dbo].[badges] ([badge], [createdat], [updatedat], [imgUrl], [seuil], [status], [applyOn])
VALUES ('Padawan', getdate(), getdate(), 'https://hicouchphp.azurewebsites.net/img/padawan.png', '5', '4','commentaire');
INSERT INTO [dbo].[badges] ([badge], [createdat], [updatedat], [imgUrl], [seuil], [status], [applyOn])
VALUES ('Knight', getdate(), getdate(), 'https://hicouchphp.azurewebsites.net/img/knight.png', '10', '4','association');
INSERT INTO [dbo].[badges] ([badge], [createdat], [updatedat], [imgUrl], [seuil], [status], [applyOn])
VALUES ('Master', getdate(), getdate(), 'https://hicouchphp.azurewebsites.net/img/master.png', '15', '4','commentaire');
INSERT INTO [dbo].[badges] ([badge], [createdat], [updatedat], [imgUrl], [seuil], [status], [applyOn])
VALUES ('Grand Master', getdate(), getdate(), 'https://hicouchphp.azurewebsites.net/img/grandmaster.jpg	', '20', '4','association');


--auth0 test 
INSERT INTO [dbo].[utilisateur] ([firstname], [lastname], [gender], [email], [typeuser], [pseudo], [score], [password], [idstatus], [picture], [createdat], [updatedat], [lastlogin], [loginscount], [idauth0])
VALUES ('auth0Test', 'auth0Test', NULL, 'test@auth0.com', '0', 'auth0Test', '0', NULL, '2', NULL, getdate(), getdate(), getdate(), NULL, 'MbpxkjbtDz0vJX4oBnYSL2QI6mjG0oAc@clients');


/* plus necessaire on alimente avec l'ihm
--3-users
INSERT INTO [dbo].[utilisateur] ([firstname], [lastname], [gender], [email], [typeuser], [pseudo], [score], [password], [idstatus], [picture], [createdat], [updatedat], [lastlogin], [loginscount], [idauth0])
VALUES ('Jean', 'Pierre', NULL, 'jpp@gmail.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO [dbo].[utilisateur] ([firstname], [lastname], [gender], [email], [typeuser], [pseudo], [score], [password], [idstatus], [picture], [createdat], [updatedat], [lastlogin], [loginscount], [idauth0])
VALUES ('Marc', 'Durand', NULL, 'mdurand@gmail.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO [dbo].[utilisateur] ([firstname], [lastname], [gender], [email], [typeuser], [pseudo], [score], [password], [idstatus], [picture], [createdat], [updatedat], [lastlogin], [loginscount], [idauth0])
VALUES ('Paul', 'Jacques', NULL, 'pj@gmail.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO [dbo].[utilisateur] ([firstname], [lastname], [gender], [email], [typeuser], [pseudo], [score], [password], [idstatus], [picture], [createdat], [updatedat], [lastlogin], [loginscount], [idauth0])
VALUES ('Pascal', 'Obispo', NULL, 'po@gmail.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- plus de table produit requise
-- INSERT INTO [dbo].[produit] ([idProduit], [name], [createdat], [updatedat]) VALUES ('a', 'harry', getdate(), getdate());
-- INSERT INTO [dbo].[produit] ([idProduit], [name], [createdat], [updatedat]) VALUES ('b', 'phoenix', getdate(), getdate());

--4-signalements
INSERT INTO [dbo].[signalement] ([typeSignalement], [SignaledUserId], [SignaledCommentId], [message], [iduser], [status], [moderatorId], [createdat], [updatedat])
VALUES ('utilisateur', '1', NULL, 'test', '1', '1', '1', getdate(), getdate());

--5-asso
INSERT INTO [dbo].[association] ([idproduitA], [idfournA], [idproduitB], [idfournB], [idpair], [status], [createdat], [updatedat])
VALUES ('tt0944947', 'film','tt6320628', 'film', '1', 2, getdate(), getdate());
INSERT INTO [dbo].[association] ([idproduitA], [idfournA], [idproduitB], [idfournB], [idpair], [status], [createdat], [updatedat])
VALUES ('tt6320628', 'film','tt0944947', 'film', '1', 2, getdate(), getdate());

--6-Commentaire
INSERT INTO [dbo].[commentaire] ([Commentaire], [Note], [iduser], [idpair], [status], [createdat], [updatedat])
VALUES ('bof', '0', '1', '1', '2', getdate(), getdate());
INSERT INTO [dbo].[commentaire] ([Commentaire], [Note], [iduser], [idpair], [status], [createdat], [updatedat])
VALUES ('top', '0', '1', '2', '2', getdate(), getdate());
INSERT INTO [dbo].[commentaire] ([Commentaire], [Note], [iduser], [idpair], [status], [createdat], [updatedat])
VALUES ('+1', '0', '1', '3', '2', getdate(), getdate());
*/