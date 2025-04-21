@POEI25P2G3-91
@REQ_POEI25P2G3-1
Feature: Update inactif
	#Impossibilité de mettre à jour l'adresse, le bouton "Update" est inactif.
	#Il ne se passe rien en cliquant sur le bouton "Update"
	#
	#!image-20250414-075834.png|width=106,height=137,alt="image-20250414-075834.png"!

	Background:
		#@POEI25P2G3-104
		Given the user is connected with an account with addresses

	#Dans l'espace page "My Address" l'utilisateur doit avoir la possibilité de mettre à jour ses informations
	@POEI25P2G3-58 @POEI25P2G3-89 @Confirmation @TNR
	Scenario: Modification des coordonnées 
		And the user is on the My Addresses page
		When the user clicks on the 'Update' button
		And the user modifies their name
		And the user clicks on the 'Validate' button
		Then the address details should be updated
		
