package com.project.tp_omaroutaleb.llm;

import java.util.List;

public record InfosTouristiques(
        String ville_ou_pays,
        List<String> endroits_a_visiter,
        String prix_moyen_repas
) {}

//Monsieur j'ai a ajouter cette record pour forcer la reponse du format json, j'ai a essaié de la montionner dans le prompte mais même cela il me donne format txt