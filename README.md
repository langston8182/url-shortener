# Objectif

URL shortener est une application web permettant de raccourcir une URL. L'agorithme de racourcissement utilise un encodage 62 bits comprenant l'ensemble des caractères a-zA-Z0-9.

# Technique

Spring boot est mise en avant dans ce projet.
1. Spring security : authentification basique par login / mot de passe en utilisant `UserDetailsService`
2. Spring data : création d'entités JPA. La transaction est utilisé dans les services, mais n'est pas necéssaire pour cette release.
3. Lombok : utile pour éviter d'écrire les getters / setters dans les classes entités. Necéssite de lancer le jar lombok pour permettre à Eclipse de compiler

# Usage

Authentification necéssaire pour utiliser la fonction de racourcissement.

| login | Mot de passe |
| ----- | :----------: |
| user  | user         |


Fonctionne sous les navigateurs récents tels Google chrome, IE, Firefox.
