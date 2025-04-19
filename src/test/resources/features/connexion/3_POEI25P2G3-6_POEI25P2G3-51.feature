@POEI25P2G3-92
@REQ_POEI25P2G3-6
Feature: US 6 - Déconnexion 
	#En tant qu' Utilisateur 
	#
	#Je souhaite Me déconnecter 
	#
	#Afin de Ne plus pouvoir accéder à mon espace client 
	#
	#Règles de gestion : 
	#
	#* RG1 : Dans l'espace la barre menu, un lien "Sign out" déclenche la déconnexion 
	#* RG2 : La page d'authentification s'affiche et le lien "Sign in" remplace le lien "Sign out" dans la barre menu

	Background:
		#@POEI25P2G3-51
		Given the user is connected and on the homepage

	#Dans l'espace la barre menu, un lien "Sign out" déclenche la déconnexion 
	#
	#La page d'authentification s'affiche et le lien "Sign in" remplace le lien "Sign out" dans la barre menu
	@POEI25P2G3-23 @POEI25P2G3-86 @TNR
	Scenario: Déconnexion - Barre Menu
		When the user clicks on the 'Sign out' link
		Then the user should be logged out
		And the login page should contain 'Sign in'
		
