@POEI25P2G3-97
@REQ_POEI25P2G3-7
Feature: US 7 - Logo
	#En tant qu' Utilisateur 
	#
	#Je souhaite Voir le logo du Site "Your Logo What a new experience" en gris 
	#
	#Règles de gestion : 
	#
	#* RG1 : Le logo contient un lien qui doit rediriger le site sur la page accueil 
	#* RG2 : Le logo doit être présent sur toutes les pages du site

	#Le logo contient un lien qui doit rediriger le site sur la page accueil
	@POEI25P2G3-33 @POEI25P2G3-83 @TNR
	Scenario Outline: Logo - Redirection page d'accueil
		Given the user is on the "<page>" page
		When the user clicks on the home logo
		Then the user is redirected to the homepage
		
		Scenarios:
		  | page |
		  | authentication |
			| search_results |
			| article_detail |
		
