# masterfruit-fruitloop

## Règle du jeu 
- Au lancement du jeu l’appli génère une combinaison de 4 fruits distincts et ordonnés
	- 	La séquence « fraise framboise banane citron » sera différente de « citron fraise framboise banane » 
	- 	Il ne peut pas y avoir 2 fois le même fruit dans une combinaison

- L’utilisateur a 10 essais pour trouver la combinaison
	- A chaque proposition il est notifié si des fruits de sa proposition sont présents dans la solution et s’ils sont bien placés ou pas
	- Exemple : 
		- L’ordinateur a choisi fraise framboise banane citron
		- Le joueur propose fraise raisin framboise kiwi
		- L’ordinateur lui indiquera qu’il y en a un bien placé et un mal placé 

-  A chaque fois que l’utilisateur fait une proposition, celle-ci et son résultat son gardés dans un historique visible par l’utilisateur en permanence.


## Les indices
- L’utilisateur peut accepter de perdre 2 essais en échange d’un premier indice et 3 essais supplémentaires en échange d’un 2ème  indice
- Sur le premier indice l’ordinateur dévoile pour chaque position si le fruit correspondant est avec pépin
	- Sur l’exemple précédent, lorsque l’utilisateur joue son premier joker l’ordinateur lui indique
	- False False False True
- Sur le deuxième indice l’ordinateur dévoile pour chaque position si le fruit correspondant s’épluche
	- Sur l’exemple précédent, lorsque l’utilisateur joue son deuxième joker l’ordinateur lui indique
	- False False True True


## Fin du jeu
- Si l’utilisateur réussi à trouver la combinaison son score augmente du nombre d’essai qui lui restait et on lui propose de recommencer une partie
- S’il quitte ou s’il arrive au bout de ses essais sans trouver, le jeu s’arrête et on lui annonce le nombre de partie qu’il a gagné et son score total. 
	- Il peut alors enregistrer son score en donnant son nom
- De retour sur l’écran d’accueil il a la possibilité 
	- De redémarrer une partie.
	- De voir les scores
	- De quitter le jeu
