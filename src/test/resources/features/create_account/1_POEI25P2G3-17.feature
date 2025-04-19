@POEI25P2G3-98
@REQ_POEI25P2G3-17
Feature: US3 : Gestion du compte client
	#En tant qu' Utilisateur Je souhaite Gérer mon compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : 
	#
	#RG1 : Dans l'espace "My Account", l'utilisateur doit pouvoir gérer : . Son historique de commande . Ses avoirs . Ses adresses de livraison. Ses informations personnelles 
	#
	#RG2 : Si aucune adresse n'a encore été sauvegardée, un bouton "Add my first Address" est disponible" nous redirigeant vers la page de saisie d'adresse 
	#
	#RG3 : Un bouton "Home" redirige le site sur la page d'accueil

	#Tests En tant qu' Utilisateur Je souhaite Gérer mon compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#RG3 : Un bouton "Home" redirige le site sur la page d'accueil
	@POEI25P2G3-46 @POEI25P2G3-85 @TNR
	Scenario: Redirection page d'accueil
		Given the user is connected with an account and no registered addresses
		When the user clicks on the Home button
		Then the user is redirected to the homepage

	# TESTED : TO DEBUG