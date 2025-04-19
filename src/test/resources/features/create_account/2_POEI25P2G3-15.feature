@POEI25P2G3-96
@REQ_POEI25P2G3-15
Feature: US2 : Création d’un compte client
	#En tant qu' Utilisateur Je souhaite Créer un compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : 
	#
	#RG1 : La page de création de compte est accessible s'effectue depuis la page "Authentification" 
	#
	#RG2 : Dans le champ "Email adress", il est nécessaire de renseigner une adresse mail valide (au format XXX@YYY.zz) et de cliquer sur le bouton "Create an account". Un message "Invalid email address" apparaît si le format n'est pas respecté, sinon la page "Create an account" s'affiche 
	#
	#RG3 : Dans la page "Create an account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" : - En sélectionnant le genre - En saisissant son nom et prénom - En vérifiant/modifiant l'adresse mail, si l'email est modifié avec un format non conforme, le message "Email is invalid" s'affiche et la création du compte est bloquée) - En saisissant un mot de passe (minimum 5 caractères, sinon le message "password is invalid" s'affiche et la création du compte ne s'effectue pas) - Saisissant sa date de naissance (non obligatoire) - En cochant "Sign up for our newsletter!" (non obligatoire) - En validant avec un bouton "REGISTER" : la page "My account s'affiche avec un message "Your account has been created."

	#La page de création de compte est accessible s'effectue depuis la page "Authentification"
	#
	#Dans le champ "Email adress", il est nécessaire de renseigner une adresse mail valide (au format XXX@YYY.zz) et de cliquer sur le bouton "Create an account". Un message "Invalid email address" apparaît si le format n'est pas respecté, sinon la page "Create an account" s'affiche
	@POEI25P2G3-34 @POEI25P2G3-84 @TNR
	Scenario: Création de compte avec adresse email invalide
		Given the user is on the Authentication page
		When the user enters an email address with an invalid format
		And the user clicks on the Create an account button
		Then an error message Invalid email address is displayed

	# TESTED : VALID

	#La page de création de compte est accessible s'effectue depuis la page "Authentification"
	#
	#Dans le champ "Email adress", il est nécessaire de renseigner une adresse mail valide (au format XXX@YYY.zz) et de cliquer sur le bouton "Create an account".
	@POEI25P2G3-32 @POEI25P2G3-84 @TNR
	Scenario: Création de compte avec adresse email valide
		Given the user is on the Authentication page
		When the user enters a valid create email address
		And the user clicks on the Create an account button
		Then the Create an account page is displayed

	# TESTED : VALID