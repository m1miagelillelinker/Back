DROP TABLE IF EXISTS [signalement]
DROP TABLE IF EXISTS [user_association]
DROP TABLE IF EXISTS [abonnement]
DROP TABLE IF EXISTS [badges_user]
DROP TABLE IF EXISTS [tag_produit]
DROP TABLE IF EXISTS [vote]
DROP TABLE IF EXISTS [commentaire]
DROP TABLE IF EXISTS [produit]
DROP TABLE IF EXISTS [association]
DROP TABLE IF EXISTS [utilisateur]
DROP TABLE IF EXISTS [badges]
DROP TABLE IF EXISTS [fournisseurs]
DROP TABLE IF EXISTS [tag]
DROP TABLE IF EXISTS [status]
DROP TABLE IF EXISTS [historique]

--Création de la sequence pour les abonnements
drop SEQUENCE IF EXISTS assocouple;
create SEQUENCE assocouple AS int;
ALTER SEQUENCE assocouple RESTART WITH 0;

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='utilisateur' and xtype='U')
CREATE TABLE [utilisateur] (
	Id integer NOT NULL IDENTITY,
	firstname varchar(250),
	lastname varchar(250),
	gender integer,
	email varchar(250) NOT NULL,
	typeuser integer,
	pseudo varchar(250),
	score integer DEFAULT 0,
	password varchar(64),
	idstatus integer ,
	picture text ,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
	lastlogin datetime NULL DEFAULT GETDATE(),
	loginscount integer ,
	idauth0 varchar(50) ,
  CONSTRAINT [PK_UTILISATEUR] PRIMARY KEY CLUSTERED
  (
  [Id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

CREATE UNIQUE INDEX [utilisateur_email] ON [utilisateur] ([email]);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='fournisseurs' and xtype='U')
CREATE TABLE [fournisseurs] (
  [id] tinyint NOT NULL IDENTITY PRIMARY KEY,
  [libelle] varchar(20) NOT NULL,
  [url] varchar(200) NOT NULL,
  [requestMethod] varchar(20) NOT NULL,
  [apikey] varchar(20) NULL,
  [type] varchar(20) NOT NULL
);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='produit' and xtype='U')
CREATE TABLE [produit] (
	id integer NOT NULL IDENTITY,
	idProduit varchar(20) NOT NULL UNIQUE,
	name varchar(250) NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [PK_PRODUIT] PRIMARY KEY CLUSTERED
  (
  [idProduit] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='commentaire' and xtype='U')
CREATE TABLE [commentaire] (
	id integer NOT NULL IDENTITY,
	Commentaire varchar(250),
	Note integer DEFAULT 0,
	iduser integer NOT NULL,
	idpair integer NOT NULL,
	status integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
	creator varchar(20) NULL,
	modificator varchar(20) NULL,
  CONSTRAINT [PK_COMMENTAIRE] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='association' and xtype='U')
CREATE TABLE [association] (
	id integer NOT NULL IDENTITY,
	--idfournA tinyint NOT NULL,
	idfournA varchar(20) NOT NULL,
	idproduitA varchar(20) NOT NULL,
	--idfournB tinyint NOT NULL,
	idfournB varchar(20) NOT NULL,
	idproduitB varchar(20) NOT NULL,
	idpair integer NOT NULL,
	note integer NOT NULL DEFAULT 0,
	status integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
	creator varchar(20) NULL,
	modificator varchar(20) NOT NULL,
	iduser integer NOT NULL,
  CONSTRAINT [PK_ASSOCIATION] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);
-- Ajout d'une contrainte d'unicité sur le couple produitA et produitB
CREATE UNIQUE INDEX [association_idproduitA_idproduitB] ON [association] ([idproduitA], [idproduitB]);

--ajout d'un index sur l'attribut idpair qui sera present dans 3 tables differentes
CREATE INDEX [IDX_association_idpair] ON [association] ([idpair]);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='vote' and xtype='U')
CREATE TABLE [vote] (
	id integer NOT NULL IDENTITY,
	idpair integer,
	idcommentaire integer,
	vote integer,
	type varchar(20) NOT NULL,
	iduser integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
	creator varchar(20) NULL,
  CONSTRAINT [PK_VOTE] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='historique' and xtype='U')
CREATE TABLE [historique] (
	id integer NOT NULL IDENTITY,
	iduser integer NOT NULL,
	idfollow integer NULL,
	idasso integer NULL,
	type varchar(20) NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	creator varchar(20) NULL,
  CONSTRAINT [PK_HISTORIQUE] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='tag_produit' and xtype='U')
CREATE TABLE [tag_produit] (
	id integer NOT NULL IDENTITY,
	idproduit varchar(20) NOT NULL,
	idtag integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [PK_TAG_PRODUIT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='tag' and xtype='U')
CREATE TABLE [tag] (
	id integer NOT NULL IDENTITY,
	value varchar(250),
	status integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [PK_TAG] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='status' and xtype='U')
CREATE TABLE [status] (
	id integer NOT NULL IDENTITY,
	libelle varchar(250),
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [PK_STATUS] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='badges_user' and xtype='U')
CREATE TABLE [badges_user] (
	id integer NOT NULL IDENTITY,
	iduser integer NOT NULL UNIQUE,
	idbadge integer NOT NULL UNIQUE,
	dateunlock datetime NULL DEFAULT GETDATE(),
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [PK_BADGES_USER] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='abonnement' and xtype='U')
CREATE TABLE [abonnement] (
	id integer NOT NULL IDENTITY,
	follower integer NOT NULL,
	follows integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [PK_ABONNEMENT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='badges' and xtype='U')
CREATE TABLE [badges] (
	id integer NOT NULL IDENTITY,
	badge varchar(250),
	imgUrl varchar(250),
	seuil integer NOT NULL,
	status integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
    applyOn varchar(50) NULL,
  CONSTRAINT [PK_BADGES] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='user_association' and xtype='U')
CREATE TABLE [user_association] (
	id integer NOT NULL IDENTITY,
	iduser integer NOT NULL,
	idpair integer NOT NULL,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
  CONSTRAINT [PK_USER_ASSOCIATION] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

);

IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='signalement' and xtype='U')
CREATE TABLE [signalement] (
	id integer NOT NULL IDENTITY,
	typeSignalement varchar(20) CHECK (typeSignalement IN('utilisateur', 'comment')),
	SignaledUserId integer,
	SignaledCommentId integer,
	message varchar(250),
	iduser integer NOT NULL,
	status integer NOT NULL,
	moderatorId integer,
	createdat datetime NULL DEFAULT GETDATE(),
	updatedat datetime NULL DEFAULT GETDATE(),
	creator varchar(20) NULL,
	modificator varchar(20) NULL,
  CONSTRAINT [PK_SIGNALEMENT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)
);

--status

ALTER TABLE [utilisateur] drop CONSTRAINT IF EXISTS [utilisateur_fk0];
ALTER TABLE [commentaire] drop CONSTRAINT IF EXISTS [commentaire_fk2];
ALTER TABLE [tag] drop CONSTRAINT IF EXISTS [tag_fk0];
ALTER TABLE [signalement] drop CONSTRAINT IF EXISTS [signalement_fk3];


ALTER TABLE [utilisateur] WITH CHECK ADD CONSTRAINT [utilisateur_fk0] FOREIGN KEY ([idstatus]) REFERENCES [status]([id])
ON UPDATE NO ACTION
ALTER TABLE [utilisateur] CHECK CONSTRAINT [utilisateur_fk0]


ALTER TABLE [commentaire] WITH CHECK ADD CONSTRAINT [commentaire_fk2] FOREIGN KEY ([status]) REFERENCES [status]([id])
ON UPDATE NO ACTION
ALTER TABLE [commentaire] CHECK CONSTRAINT [commentaire_fk2]

ALTER TABLE [tag] WITH CHECK ADD CONSTRAINT [tag_fk0] FOREIGN KEY ([status]) REFERENCES [status]([id])
ON UPDATE NO ACTION
ALTER TABLE [tag] CHECK CONSTRAINT [tag_fk0]

ALTER TABLE [signalement] WITH CHECK ADD CONSTRAINT [signalement_fk3] FOREIGN KEY ([status]) REFERENCES [status]([id])
ON UPDATE NO ACTION

ALTER TABLE [signalement] CHECK CONSTRAINT [signalement_fk3]

ALTER TABLE [association] WITH CHECK ADD CONSTRAINT [association_status] FOREIGN KEY ([status]) REFERENCES [status]([id])
ON UPDATE NO ACTION

ALTER TABLE [association] CHECK CONSTRAINT [association_status]

--fin status

--badges
ALTER TABLE [badges] drop CONSTRAINT IF EXISTS [badges_fk1];
ALTER TABLE [badges] WITH CHECK ADD CONSTRAINT [badges_fk1]  FOREIGN KEY ([status]) REFERENCES [dbo].[status] ([id]);

ALTER TABLE [badges_user] drop CONSTRAINT IF EXISTS [badges_user_fk1];

ALTER TABLE [badges_user] WITH CHECK ADD CONSTRAINT [badges_user_fk1] FOREIGN KEY ([idbadge]) REFERENCES [badges]([id])
ON UPDATE NO ACTION

ALTER TABLE [badges_user] CHECK CONSTRAINT [badges_user_fk1]

--fin badges


--association plus de FK
/*
ALTER TABLE [commentaire] drop CONSTRAINT IF EXISTS [commentaire_fk1];
ALTER TABLE [vote] drop CONSTRAINT IF EXISTS [vote_fk0];
ALTER TABLE [user_association] drop CONSTRAINT IF EXISTS [user_association_fk1];

ALTER TABLE [commentaire] WITH CHECK ADD CONSTRAINT [commentaire_fk1] FOREIGN KEY ([idassoc]) REFERENCES [association]([idpair])
ON UPDATE NO ACTION

ALTER TABLE [commentaire] CHECK CONSTRAINT [commentaire_fk1]

ALTER TABLE [vote] WITH CHECK ADD CONSTRAINT [vote_fk0] FOREIGN KEY ([idassoc]) REFERENCES [association]([idpair])
ON UPDATE NO ACTION

ALTER TABLE [vote] CHECK CONSTRAINT [vote_fk0]

ALTER TABLE [user_association] WITH CHECK ADD CONSTRAINT [user_association_fk1] FOREIGN KEY ([idasso]) REFERENCES [association]([idpair])
ON UPDATE NO ACTION

ALTER TABLE [user_association] CHECK CONSTRAINT [user_association_fk1]
*/

--fin association

--tag

-- ALTER TABLE [tag_produit] drop CONSTRAINT IF EXISTS [tag_produit_fk1];
-- ALTER TABLE [tag_produit] WITH CHECK ADD CONSTRAINT [tag_produit_fk1] FOREIGN KEY ([idtag]) REFERENCES [tag]([id]) ON UPDATE NO ACTION
-- ALTER TABLE [tag_produit] CHECK CONSTRAINT [tag_produit_fk1]


--fin tag

--commentaire

ALTER TABLE [signalement] drop CONSTRAINT IF EXISTS [signalement_fk1];

ALTER TABLE [signalement] WITH CHECK ADD CONSTRAINT [signalement_fk1] FOREIGN KEY ([SignaledCommentId]) REFERENCES [commentaire]([id])
ON UPDATE NO ACTION

ALTER TABLE [signalement] CHECK CONSTRAINT [signalement_fk1]


--fin commentaire



--drop contraintes
ALTER TABLE [commentaire] drop CONSTRAINT IF EXISTS [commentaire_fk0];
ALTER TABLE [commentaire] drop CONSTRAINT IF EXISTS [commentaire_fk1];
ALTER TABLE [vote] drop CONSTRAINT IF EXISTS [vote_fk1];
ALTER TABLE [badges_user] drop CONSTRAINT IF EXISTS [badges_user_fk0];
ALTER TABLE [abonnement] drop CONSTRAINT IF EXISTS [abonnement_fk0];
ALTER TABLE [abonnement] drop CONSTRAINT IF EXISTS [abonnement_fk1];
ALTER TABLE [user_association] drop CONSTRAINT IF EXISTS [user_association_fk0];
ALTER TABLE [signalement] drop CONSTRAINT IF EXISTS [signalement_fk0];
ALTER TABLE [signalement] drop CONSTRAINT IF EXISTS [signalement_fk2];
ALTER TABLE [signalement] drop CONSTRAINT IF EXISTS [signalement_fk4];

ALTER TABLE [commentaire] WITH CHECK ADD CONSTRAINT [commentaire_fk0] FOREIGN KEY ([iduser]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [commentaire] CHECK CONSTRAINT [commentaire_fk0]

ALTER TABLE [commentaire] WITH CHECK ADD CONSTRAINT [commentaire_fk1] FOREIGN KEY ([status]) REFERENCES [status]([id])
ON UPDATE NO ACTION

ALTER TABLE [commentaire] CHECK CONSTRAINT [commentaire_fk1]


ALTER TABLE [vote] WITH CHECK ADD CONSTRAINT [vote_fk1] FOREIGN KEY ([iduser]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [vote] CHECK CONSTRAINT [vote_fk1]

ALTER TABLE [badges_user] WITH CHECK ADD CONSTRAINT [badges_user_fk0] FOREIGN KEY ([iduser]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [badges_user] CHECK CONSTRAINT [badges_user_fk0]


ALTER TABLE [abonnement] WITH CHECK ADD CONSTRAINT [abonnement_fk0] FOREIGN KEY ([follower]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [abonnement] CHECK CONSTRAINT [abonnement_fk0]

ALTER TABLE [abonnement] WITH CHECK ADD CONSTRAINT [abonnement_fk1] FOREIGN KEY ([follows]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [abonnement] CHECK CONSTRAINT [abonnement_fk1]

ALTER TABLE [user_association] WITH CHECK ADD CONSTRAINT [user_association_fk0] FOREIGN KEY ([iduser]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [user_association] CHECK CONSTRAINT [user_association_fk0]

ALTER TABLE [signalement] WITH CHECK ADD CONSTRAINT [signalement_fk0] FOREIGN KEY ([SignaledUserId]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [signalement] CHECK CONSTRAINT [signalement_fk0]

ALTER TABLE [signalement] WITH CHECK ADD CONSTRAINT [signalement_fk2] FOREIGN KEY ([iduser]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [signalement] CHECK CONSTRAINT [signalement_fk2]

ALTER TABLE [signalement] WITH CHECK ADD CONSTRAINT [signalement_fk4] FOREIGN KEY ([moderatorId]) REFERENCES [utilisateur]([Id])
ON UPDATE NO ACTION

ALTER TABLE [signalement] CHECK CONSTRAINT [signalement_fk4]

--fin utilisateur


--produit

ALTER TABLE [association] drop CONSTRAINT IF EXISTS [association_fk0];
ALTER TABLE [association] drop CONSTRAINT IF EXISTS [association_fk1];
ALTER TABLE [tag_produit] drop CONSTRAINT IF EXISTS [tag_produit_fk0];

-- ALTER TABLE [association] WITH CHECK ADD CONSTRAINT [association_fk0] FOREIGN KEY ([idproduitA]) REFERENCES [produit]([idProduit]) ON UPDATE NO ACTION
-- ALTER TABLE [association] CHECK CONSTRAINT [association_fk0]
-- ALTER TABLE [association] WITH CHECK ADD CONSTRAINT [association_fk1] FOREIGN KEY ([idproduitB]) REFERENCES [produit]([idProduit]) ON UPDATE NO ACTION
-- ALTER TABLE [association] CHECK CONSTRAINT [association_fk1]
-- ALTER TABLE [tag_produit] WITH CHECK ADD CONSTRAINT [tag_produit_fk0] FOREIGN KEY ([idproduit]) REFERENCES [produit]([idProduit]) ON UPDATE NO ACTION
-- ALTER TABLE [tag_produit] CHECK CONSTRAINT [tag_produit_fk0]

--fin produit


--fournisseur TODO a integrer plus tard
-- ALTER TABLE [association] ADD FOREIGN KEY ([idfournA]) REFERENCES [fournisseurs] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
-- ALTER TABLE [association] ADD FOREIGN KEY ([idfournB]) REFERENCES [fournisseurs] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION

--fin fournisseur

CREATE UNIQUE INDEX [commentaire_iduser_Commentaire] ON [dbo].[commentaire] ([iduser], [Commentaire]);

