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

	Background:
		#@POEI25P2G3-103
		Given the user is connected with an account and no registered addresses

	#Tests En tant qu' Utilisateur Je souhaite Gérer mon compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#RG3 : Un bouton "Home" redirige le site sur la page d'accueil
	@POEI25P2G3-46 @POEI25P2G3-85 @TNR
	Scenario: Redirection page d'accueil
		When the user clicks on the home logo
		Then the user is redirected to the homepage
		
	#Tests En tant qu' Utilisateur Je souhaite Gérer mon compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#RG2 : Si aucune adresse n'a encore été sauvegardée, un bouton "Add my first Address" est disponible" nous redirigeant vers la page de saisie d'adresse
	@POEI25P2G3-44 @POEI25P2G3-85 @TNR
	Scenario: Bouton Add my first Address
		When the user clicks on Add my first Address button 
		Then the user is redirected to the address entry page
		
	#Tests En tant qu' Utilisateur Je souhaite Gérer mon compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : 
	#
	#RG1 : Dans l'espace "My Account", l'utilisateur doit pouvoir gérer : . Son historique de commande . Ses avoirs . Ses adresses de livraison. Ses informations personnelles
	@POEI25P2G3-42 @POEI25P2G3-85 @TNR
	Scenario Outline: Affichage des sections de gestion compte et commande
		When the user clicks on "<section>" section
		Then the user is redirected to the "<section>" section page
				
		Examples:
			| section              |
			| Order History        |
			| Credits              |
			| Delivery Addresses   |
			| Personal Information |
		
