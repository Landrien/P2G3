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
	#RG2 : Si aucune adresse n'a encore été sauvegardée, un bouton "Add my first Address" est disponible" nous redirigeant vers la page de saisie d'adresse
	@POEI25P2G3-44 @POEI25P2G3-85 @TNR
	Scenario: Bouton Add my first Address
		Given the user is connected with the default account
		And there are no registered addresses
		And the user is on the My account page
		When the user clicks on Add my first Address button 
		Then the user is redirected to the address entry page

	# TESTED : VALID