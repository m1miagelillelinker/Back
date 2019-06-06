
#By User ID
http://localhost:8080/commentaire/ByUserId/?userId=1

#By Asso Pair Id
http://localhost:8080/commentaire/ByAssoPairId/?pairId=3

#new
{
	"commentaire":"blablabla",
	"idUser":1,
	"idPair":12
}
retourne le commentaire persisté

les deux methodes 
- http://localhost:8080/commentaire/hide/
- http://localhost:8080/commentaire/update/

peuveut etre appelées avec un POST comme celui ci:
{
    "id": 14,
    "commentaire": "texte",
    "note": 3,
    "idUser": 2,
    "idPair": 23,
    "status": 1,
    "createdat": "2019-06-06T15:43:56.880+0000",
    "updatedAt": "2019-06-06T15:43:56.880+0000"
}

hide result:(status updated)
{
    "id": 14,
    "commentaire": "blablablaUPDATED6",
    "note": 3,
    "idUser": 2,
    "idPair": 23,
    "status": 4,
    "createdat": "2019-06-06T15:43:56.880+0000",
    "updatedAt": "2019-06-06T15:47:33.263+0000"
}