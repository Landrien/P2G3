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

	#RG2 : Des onglets "Women", "Dresses", "T-Shirts" redirige vers des articles en filtrés en fonction de la catégorie de l'onglet. Un onglet "BLOG" redirige vers le site prestashop (onglets présents sur toutes les pages du site)
	@POEI25P2G3-79 @POEI25P2G3-83 @TNR
	Scenario Outline: Navigation onglet blog
		Given the user is on the "<page>" page
		When The user clicks on the Blog tab
		Then the user is redirected to the Prestashop blog website
		
		Scenarios:
		  | page |
		  | homepage|
		  | authentication |
		  | search_results |
		  | article_detail |

	# TESTED : VALID

	#Tests En tant qu' Utilisateur, Je souhaite Accéder à la page accueil Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : RG1 : Une barre menu en noir contient les liens « Contact us » qui redirige vers la page de contact et « Sign in » vers la page d’authentification (barre menu présent sur toutes les pages du site)
	@POEI25P2G3-78 @POEI25P2G3-83 @TNR
	Scenario Outline: Accès à la page Sign in via la barre menu noire
		Given the user is on the "<page>" page
		When the user clicks on the links Sign in
		Then the user is redirected to the Authentication page
		
		Scenarios:
		  | page |
		  | homepage |
		  | search_results |
		  | article_detail |

	# TESTED : VALID

	#Tests En tant qu' Utilisateur, Je souhaite Accéder à la page accueil Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : RG1 : Une barre menu en noir contient les liens « Contact us » qui redirige vers la page de contact et « Sign in » vers la page d’authentification (barre menu présent sur toutes les pages du site) 
	#
	#RG2 : Des onglets "Women", "Dresses", "T-Shirts" redirige vers des articles en filtrés en fonction de la catégorie de l'onglet. Un onglet "BLOG" redirige vers le site prestashop (onglets présents sur toutes les pages du site) 
	#
	#RG3 : Des publicités à la une redirige vers le site partenaire prestashop
	@POEI25P2G3-26 @POEI25P2G3-83 @TNR
	Scenario: Accès aux publicités à la une 
		Given the user is on the homepage  
		When the user clicks on a featured advertisement  
		Then the user is redirected to the Prestashop website

	# TESTED : VALID

	#RG2 : Des onglets "Women", "Dresses", "T-Shirts" redirige vers des articles en filtrés en fonction de la catégorie de l'onglet. Un onglet "BLOG" redirige vers le site prestashop (onglets présents sur toutes les pages du site)
	@POEI25P2G3-25 @POEI25P2G3-83 @TNR
	Scenario Outline: Navigation par catégories 
		Given the user is on the "<page>" page
		When the user clicks on the "<tab>" tab
		Then the user is redirected to a page displaying "<tab>" items
		
		Examples:
		  | page           | tab      |
		  | homepage       | Women    |
		  | search_results | Dresses  |
		  | article_detail | T-Shirts |

	# TESTED : VALID

	#Tests En tant qu' Utilisateur, Je souhaite Accéder à la page accueil Afin de Gérer mes commandes et mes informations personnelles 
	#
	#Règles de gestion : RG1 : Une barre menu en noir contient les liens « Contact us » qui redirige vers la page de contact et « Sign in » vers la page d’authentification (barre menu présent sur toutes les pages du site)
	@POEI25P2G3-24 @POEI25P2G3-83 @TNR
	Scenario Outline: Accès à la page Contact us via la barre menu noire
		Given the user is on the "<page>" page
		When the user clicks on the links Contact us
		Then the user is redirected to the Contact page
		
		Scenarios:
		  | page |
		  | homepage |
		  | authentication |
		  | search_results |
		  | article_detail |

	# TESTED : VALID