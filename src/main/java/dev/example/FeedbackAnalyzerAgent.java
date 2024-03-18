package dev.example;

import java.util.List;

public interface FeedbackAnalyzerAgent {
    // Method to generate atomic feedback components
    public List<AtomicFeedback> generateAtomicFeedbackComponents(String feedback);
}
