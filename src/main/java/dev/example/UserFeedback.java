package dev.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

import java.util.ArrayList;
import java.util.List;

public class UserFeedback {
    private int birthYear;
    private String nationality;
    private String gender;
    private String feedback;
    private List<AtomicFeedback> atomicFeedbackList;

    public UserFeedback(int age, String nationality, String gender, String feedback) {
        this.birthYear = java.time.Year.now().getValue() - age;
        this.nationality = nationality;
        this.feedback = feedback;
        this.gender = gender;

        ChatLanguageModel model = OpenAiChatModel.withApiKey(System.getenv("OPENAI_API_KEY"));
        FeedbackAnalyzerAgent analyzer =
                AiServices.create(FeedbackAnalyzerAgent.class, model);
        this.atomicFeedbackList = analyzer.generateAtomicFeedbackComponents(feedback);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonFeedback{");
        sb.append("birthYear=").append(birthYear);
        sb.append(", nationality='").append(nationality).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", feedback='").append(feedback).append('\'');
        sb.append(", atomicFeedbackList=").append(atomicFeedbackList);
        sb.append('}');
        return sb.toString();
    }

}