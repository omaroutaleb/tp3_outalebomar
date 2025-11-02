package com.project.tp_omaroutaleb.llm;

import com.google.gson.Gson;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

public class    LlmClientForGuideTouristique {

    private GuideTouristique guideTouristique;

    private Gson gson;

    public LlmClientForGuideTouristique() {
        String apiKey = System.getenv("GEMINI_API_KEY");

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.0-flash-exp")
                .build();

        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(chatMemory)
                .build();
        this.gson = new Gson();
    }

    public String obtenirInfos(String villeOuPays) {
        InfosTouristiques infos = guideTouristique.obtenirInfosTouristiques(villeOuPays);
        return gson.toJson(infos);
    }
}
