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

	#Tests En tant qu' Utilisateur Je souhaite Créer un compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#RG3 : Dans la page "Create an account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" : - En sélectionnant le genre - En saisissant son nom et prénom - En vérifiant/modifiant l'adresse mail, si l'email est modifié avec un format non conforme, le message "Email is invalid" s'affiche et la création du compte est bloquée) - En saisissant un mot de passe (minimum 5 caractères, sinon le message "password is invalid" s'affiche et la création du compte ne s'effectue pas) - Saisissant sa date de naissance (non obligatoire) - En cochant "Sign up for our newsletter!" (non obligatoire) - En validant avec un bouton "REGISTER" : la page "My account s'affiche avec un message "Your account has been created."
	@POEI25P2G3-39 @POEI25P2G3-84 @TNR
	Scenario Outline: Enregistrer un compte client avec un mot de passe invalide
		Given the user is on the Create an account page
		When the user enters a "<bad-password>" invalid password
		And the user clicks on the Register button
		Then a Password is invalid message is displayed
		
		Examples: 
		  | bad-password  |
		  | abcd      |
		  |           |

	# TESTED : VALID

	#Tests En tant qu' Utilisateur Je souhaite Créer un compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#RG3 : Dans la page "Create an account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" : - En sélectionnant le genre - En saisissant son nom et prénom - En vérifiant/modifiant l'adresse mail, si l'email est modifié avec un format non conforme, le message "Email is invalid" s'affiche et la création du compte est bloquée) - En saisissant un mot de passe (minimum 5 caractères, sinon le message "password is invalid" s'affiche et la création du compte ne s'effectue pas) - Saisissant sa date de naissance (non obligatoire) - En cochant "Sign up for our newsletter!" (non obligatoire) - En validant avec un bouton "REGISTER" : la page "My account s'affiche avec un message "Your account has been created."
	@POEI25P2G3-38 @POEI25P2G3-84 @TNR
	Scenario: Enregistrer un compte client avec une modification d'email invalide
		Given the user is on the Create an account page
		When the user selects a gender
		And the user enters their last name
		And the user enters their first name
		And the user modifies their email address to an invalid format
		And the user enters a password with at least '5' characters
		And the user clicks on the Register button
		Then an Email is invalid message is displayed

	# TESTED : VALID

	#Tests En tant qu' Utilisateur Je souhaite Créer un compte client Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : 
	#
	#RG1 : La page de création de compte est accessible s'effectue depuis la page "Authentification" 
	#
	#RG2 : Dans le champ "Email adress", il est nécessaire de renseigner une adresse mail valide (au format XXX@YYY.zz) et de cliquer sur le bouton "Create an account". Un message "Invalid email address" apparaît si le format n'est pas respecté, sinon la page "Create an account" s'affiche 
	#
	#RG3 : Dans la page "Create an account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" : - En sélectionnant le genre - En saisissant son nom et prénom - En vérifiant/modifiant l'adresse mail, si l'email est modifié avec un format non conforme, le message "Email is invalid" s'affiche et la création du compte est bloquée) - En saisissant un mot de passe (minimum 5 caractères, sinon le message "password is invalid" s'affiche et la création du compte ne s'effectue pas) - Saisissant sa date de naissance (non obligatoire) - En cochant "Sign up for our newsletter!" (non obligatoire) - En validant avec un bouton "REGISTER" : la page "My account s'affiche avec un message "Your account has been created."
	@POEI25P2G3-80 @POEI25P2G3-84 @TNR
	Scenario: Enregistrer un compte client avec info valides (sans les options facultatives)
		Given the user is on the Create an account page
		When the user selects a gender  
		And the user enters their last name  
		And the user enters their first name  
		And the user modifies their email address with a valid format
		And the user enters a password with at least '5' characters
		And the user clicks on the Register button
		Then the message 'Your account has been created' is displayed
		
	# TESTED : VALID

	#Tests En tant qu' Utilisateur Je souhaite Créer un compte client Afin de Gérer mes commandes et mes informations personnelles
	#
	#Règles de gestion :
	#
	#RG3 : Dans la page "Create an account", l'utilisateur doit pouvoir créer un compte dans le pavé "Register" : - En sélectionnant le genre - En saisissant son nom et prénom - En vérifiant/modifiant l'adresse mail, si l'email est modifié avec un format non conforme, le message "Email is invalid" s'affiche et la création du compte est bloquée) - En saisissant un mot de passe (minimum 5 caractères, sinon le message "password is invalid" s'affiche et la création du compte ne s'effectue pas) - Saisissant sa date de naissance (non obligatoire) - En cochant "Sign up for our newsletter!" (non obligatoire) - En validant avec un bouton "REGISTER" : la page "My account s'affiche avec un message "Your account has been created."
	@POEI25P2G3-35 @POEI25P2G3-84 @TNR
	Scenario: Enregistrer un compte client avec info valides (avec les options facultatives)
		Given the user is on the Create an account page
		When the user selects a gender
		And the user enters their last name
		And the user enters their first name
		And the user modifies their email address with a valid format
		And the user enters a password with at least '5' characters
		And the user enters their date of birth
		And the user checks the Sign up for our newsletter checkbox
		And the user clicks on the Register button
		Then the message 'Your account has been created' is displayed

	# TESTED : VALID