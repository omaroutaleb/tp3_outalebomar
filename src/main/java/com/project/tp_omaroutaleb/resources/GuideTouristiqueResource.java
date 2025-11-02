package com.project.tp_omaroutaleb.resources;

import com.project.tp_omaroutaleb.llm.LlmClientForGuideTouristique;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/guide_touristique")  // Changé de "/guide" à "/guide_touristique"
public class GuideTouristiqueResource {

    private LlmClientForGuideTouristique llmClient;

    public GuideTouristiqueResource() {
        this.llmClient = new LlmClientForGuideTouristique();
    }

    @GET
    @Path("ville_ou_pays/{ville_ou_pays}")  // Changé de "lieu/{ville_ou_pays}"
    @Produces(MediaType.APPLICATION_JSON)
    public String villeOuPays(@PathParam("ville_ou_pays") String villeOuPays) {
        return llmClient.obtenirInfos(villeOuPays);
    }
}
