@POEI25P2G3-95
@REQ_POEI25P2G3-9
Feature: US 8 - Champ Recherche
	#Tests En tant qu' Utilisateur 
	#
	#Je souhaite Avoir un champ de recherche et sa loupe de confirmation 
	#
	#Afin d' Effectuer des recherches d'articles sur tout le site 
	#
	#Règles de gestion : 
	#
	#* RG1 : Le champ et la loupe doivent être ancrés en entête (présent sur toutes les pages du site) 
	#* RG2 : Le champ de recherche propose des suggestions d'articles à l'utilisateur au fur et à mesure de sa saisie, en cas de sélection d'une de ces proposition d'articles, la loupe renvoie directement vers l'article 
	#* RG3 : En cas de saisie "libre" (non séléction d'un article suggéré). La loupe de recherche renvoie vers la page "Search" avec des résultats d'articles pertinents en fonction de la saisie

	#Le champ de recherche propose des suggestions d'articles à l'utilisateur au fur et à mesure de sa saisie, en cas de sélection d'une de ces proposition d'articles, la loupe renvoie directement vers l'article.
	@POEI25P2G3-47 @POEI25P2G3-87 @TNR
	Scenario: Proposition de recherche ciblée
		Given the user is on the homepage
		When the user clicks on the search field
		And the user enters the text "dres" in the search bar
		And the user clicks on the suggestion "Printed Dress"
		Then the user should be redirected to the "Printed Dress" article page

	# TESTED : VALID

	#En cas de saisie "libre" (non séléction d'un article suggéré). La loupe de recherche renvoie vers la page "Search" avec des résultats d'articles pertinents en fonction de la saisie
	@POEI25P2G3-41 @POEI25P2G3-87 @TNR
	Scenario: Proposition de recherche libre
		Given the user is on the homepage
		When the user clicks on the search field
		And the user enters the text "dresse" in the search bar
		And the user clicks on the magnifying glass
		Then the user should be redirected to the "dresse" search results page

	# TESTED : VALID

	#Le champ et la loupe doivent être ancrés en entête (présent sur toutes les pages du site)
	@POEI25P2G3-40 @POEI25P2G3-87 @TNR
	Scenario Outline: Champ Recherche sur toute les pages
		Given the user is on the "<page>" page
		Then the "<page>" page should contain the search field
		And the "<page>" page should contain the magnifying glass
		
		  Examples:
		    | page           |
			| homepage       |
			| authentication |
		    | search_results |
		    | article_detail |

	# TESTED : VALID