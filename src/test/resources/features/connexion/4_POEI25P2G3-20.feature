@POEI25P2G3-92
@REQ_POEI25P2G3-20
Feature: US5 : Ré-initialiser le mot de passe oublié
	#En tant qu' Utilisateur Je souhaite réinitialiser mon mot de passe oublié Afin d’accéder à mon compte client 
	#
	#Règles de gestion : 
	#
	#RG1 : Dans la page d'authentification, un lien "Forgot your password?" redirige l'utilisation vers la page de réinitialisation du compte. Un champ permet de saisir l'email du compte, et un bouton "Retrieve Password" génére l'envoi d'un mail de réinitialisation 
	#
	#RG2 : Le mail contient un lien de réinitialisation permettant l'envoi d'un mail avec un nouveau mot de passe
		
	#Tests En tant qu' Utilisateur Je souhaite Ré-initialiser mon mot de passe oublié Afin de D’accéder à mon compte client 
	#
	#Règles de gestion : 
	#
	#RG1 : Dans la page d'authentification, un lien "Forgot your password?" redirige l'utilisation vers la page de réinitialisation du compte. Un champ permet de saisir l'email du compte, et un bouton "Retrieve Password" génére l'envoi d'un mail de réinitialisation
	@POEI25P2G3-56 @TNR
	Scenario: Lien Forgot your password
		Given the user is on the Authentication page
		When the user clicks on the 'Forgot your password' link
		Then the user is redirected to the password reset page

	# TESTED : VALID