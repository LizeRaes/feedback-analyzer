package dev.example;

import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = BookingTools.class, retriever = EmbeddingStoreRetriever.class)
interface CustomerSupportAgent {

    @SystemMessage({
            "You are a customer support agent of a car rental company named 'Miles of Smiles'.",
            "Before providing information about booking or cancelling booking, you MUST always check:",
            "booking number, customer name and surname.",
            "Today is {{current_date}}."
    })
    String chat(@MemoryId Object session, @UserMessage String userMessage);
}
