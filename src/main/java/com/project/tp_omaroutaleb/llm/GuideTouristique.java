package com.project.tp_omaroutaleb.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

@SystemMessage(
        "Tu es un guide touristique. " +
                "Indique EXACTEMENT 2 endroits à visiter (pas plus, pas moins) et " +
                "le prix moyen d'un repas dans la devise du pays. " +
                "Format OBLIGATOIRE pour le prix: un seul nombre suivi de l'espace et du code devise en 3 lettres (exemple: 20 EUR). " +
                "Retourne EXACTEMENT 2 endroits dans le tableau."
)
public interface GuideTouristique {
    @UserMessage("Informations touristiques sur {{it}}")
    InfosTouristiques obtenirInfosTouristiques(String villeOuPays);
}
