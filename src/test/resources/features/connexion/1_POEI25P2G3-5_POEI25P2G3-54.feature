@POEI25P2G3-92
@REQ_POEI25P2G3-5
Feature: Mot de passe
	#En saisissant un mot de passe erroné, l'utilisateur peut tout de même accéder à son espace.
	#Test effectué avec plusieurs mots de passe différents

	Background:
		#@POEI25P2G3-54
		Given the user has an account with a valid email address

	#Tests En tant qu' Utilisateur Je souhaite Me connecter à mon compte Afin de Gérer mon compte client Règles de gestion : 
	#
	#RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affiche
	@POEI25P2G3-53 @POEI25P2G3-86 @Confirmation @TNR
	Scenario: Connexion échouée mot de passe invalide
		Given the user is on the Authentication page
		When the user enters a valid email address
		And the user enters an incorrect password
		Then an error message Invalid password is displayed
		
