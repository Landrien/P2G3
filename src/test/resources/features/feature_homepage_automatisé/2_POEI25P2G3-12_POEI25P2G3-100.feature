@POEI25P2G3-97
@REQ_POEI25P2G3-12
Feature: US1 : Accès à la page d’accueil 
	#En tant qu' Utilisateur, Je souhaite Accéder à la page accueil Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : RG1 : Une barre menu en noir contient les liens « Contact us » qui redirige vers la page de contact et « Sign in » vers la page d’authentification (barre menu présent sur toutes les pages du site) 
	#
	#RG2 : Des onglets "Women", "Dresses", "T-Shirts" redirige vers des articles en filtrés en fonction de la catégorie de l'onglet. Un onglet "BLOG" redirige vers le site prestashop (onglets présents sur toutes les pages du site) 
	#
	#RG3 : Des publicités à la une redirige vers le site partenaire prestashop

	Background:
		#@POEI25P2G3-100
		Given the user is on the homepage

	#Tests En tant qu' Utilisateur, Je souhaite Accéder à la page accueil Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : RG1 : Une barre menu en noir contient les liens « Contact us » qui redirige vers la page de contact et « Sign in » vers la page d’authentification (barre menu présent sur toutes les pages du site) 
	#
	#RG2 : Des onglets "Women", "Dresses", "T-Shirts" redirige vers des articles en filtrés en fonction de la catégorie de l'onglet. Un onglet "BLOG" redirige vers le site prestashop (onglets présents sur toutes les pages du site) 
	#
	#RG3 : Des publicités à la une redirige vers le site partenaire prestashop
	@POEI25P2G3-26 @POEI25P2G3-83 @TNR
	Scenario: Accès aux publicités à la une 
		When the user clicks on a featured advertisement  
		Then the user is redirected to the Prestashop website
		
