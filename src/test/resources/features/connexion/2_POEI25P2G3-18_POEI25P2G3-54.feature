@POEI25P2G3-92
@REQ_POEI25P2G3-18
Feature: US4 : Connexion au compte client 
	#En tant qu' Utilisateur Je souhaite Me connecter à mon compte Afin de Gérer mon compte client Règles de gestion : 
	#
	#RG1 : La page d'authentification est accessible s'effectue depuis la page "Authentification" 
	#
	#RG2 : En se connectant à son compte l'écran "My Account" doit s'afficher 
	#
	#RG3 : les nom, prénom de l'utilisateur apparaît dans la barre menu 
	#
	#RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affiche

	Background:
		#@POEI25P2G3-54
		Given the user has an account with a valid email address

	#Tests En tant qu' Utilisateur Je souhaite Me connecter à mon compte Afin de Gérer mon compte client Règles de gestion : 
	#
	#RG4 : En cas de connexion avec un mot de passe erroné, un message "Invalid password" s'affiche
	@POEI25P2G3-53 @POEI25P2G3-86 @Confirmation @TNR
	Scenario: Connexion échouée mot de passe invalide
		Given the user is on the Authentication page
		When the user enters a valid sign in email address
		And the user enters an incorrect password
		Then an error message Invalid password is displayed
		
	#Tests En tant qu' Utilisateur Je souhaite Me connecter à mon compte Afin de Gérer mon compte client Règles de gestion : 
	#
	#RG2 : En se connectant à son compte l'écran "My Account" doit s'afficher 
	#
	#RG3 : les nom, prénom de l'utilisateur apparaît dans la barre menu
	@POEI25P2G3-52 @POEI25P2G3-86 @TNR
	Scenario: Connexion réussie
		Given the user is on the Authentication page
		When the user enters a valid sign in email address
		And the user enters the password associated with their account
		And the user click on the button
		Then the My Account page is displayed  
		And the user's first and last name appear in the menu bar
		
