# Objectif

URL shortener est une application web permettant de raccourcir une URL. L'agorithme de racourcissement utilise un encodage 62 bits comprenant l'ensemble des caractères a-zA-Z0-9.

# Sécurité
Authentification (user / mot de passe) nécéssaire pour accéder à l'application. Le mot de passe est sauvegardé en base de données en utilisant l'encodeur BCrypt qui a le gros avantage d'être différent à chaque appel.

Pour des raisons d'attaque de base de données, les URL raccourcies ne sont pas sauvegardées dans la base de donnée.

Pour les besoins du projet, l'authentification par défaut de spring security est utilisé.

Une authorisation est necéssaire pour accéder à l'URL `http://localhost:8080/url/encode`. Seul un utilisateur avec le role "ADMIN" peux y accéder.

# Technique

Spring boot est mise en avant dans ce projet.
1. Spring security : authentification basique par login / mot de passe en utilisant `UserDetailsService`
2. Spring data : création d'entités JPA. La transaction est utilisé dans les services, mais n'est pas necéssaire pour cette release.
3. Thymeleaf pour la partie vue, permet d'accéder facilement au controleur.
4. Bootstrap pour le CSS.
5. Lombok : utile pour éviter d'écrire les getters / setters dans les classes entités. Necéssite de lancer le jar lombok pour permettre à Eclipse de compiler.
6. JUnit pour les tests unitaires.
7. Base de données H2 in Memory. Les données sont réinitialisées à chaque redemarrage de l'application.

# Installation

Importer le projet maven sous l'IDE de votre choix. Les différents jars devraient s'installer automatiquement sur votre repository Maven.
Lancer la classe `/url-shortener/src/main/java/com/notarius/urlshortener/urlshortener/UrlShortenerApplication.java`

Pour lancer l'application taper l'url : `http://localhost:8080`

# Usage

Authentification necéssaire pour utiliser la fonction de racourcissement.

| login | Mot de passe |
| ----- | :----------: |
| user  | user         |

Fonctionne sous tous les navigateurs récents tels Google chrome, IE, Firefox.

Bien entendu, même si l'application permet de raccourcir n'importe quelle URL, seules les URLs dont le domaine correspond au serveur sur lequel est déployé l'application fonctionneront.

# Contributeur

Cyril Marchive - 2018
