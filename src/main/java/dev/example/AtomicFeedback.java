package dev.example;
import dev.langchain4j.model.output.structured.Description;

import java.util.List;

// Enum for feedback categories
enum Category {
    IdeaSuggestion,
    Problem,
    PositiveFeedback,
    Undefined
}

public class AtomicFeedback {
    @Description("to be left empty")
    private List<String> solutions;
    // TODO fix tag management from preset, or dynamically added
    @Description("""
            applicable topic categories, picked from: 
            example, speakers, timing, complexity, 
            inspiration, usefulness, hunger, 
            room, temperature, readability, 
            atmosphere, helpfulness, boredom
            """)
    private List<String> tags;
    @Description("applicable category")
    private Category category;
    @Description("% of urgency, ranging from 0 (no urgence whatsoever) to 100 (needs fixing in this hour). should be " +
            "0 for positive feedback")
    private int urgency;
    @Description("% of severity, ranging from 0 (no problem whatsoever) to 100 (person(s) will die if this is not " +
            "fixed). should be 0 for positive feedback")
    private int severity;
    @Description("% of people in the scope are affected by this problem or solution. should be 0 for positive feedback")
    private int impact;
    @Description("the literal part(s) of the original UserFeedback that is relevant for this AtomicFeedback part")
    private String feedback;

    // Constructor
    public AtomicFeedback(List<String> solutions, List<String> tags, Category category, int urgency, int severity, int impact, String feedback) {
        this.solutions = solutions;
        this.tags = tags;
        this.category = category;
        this.urgency = urgency;
        this.severity = severity;
        this.impact = impact;
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "AtomicFeedback{" +
                "solutions=" + solutions +
                ", tags=" + tags +
                ", category=" + category +
                ", urgency=" + urgency +
                ", severity=" + severity +
                ", impact=" + impact +
                ", feedback='" + feedback + '\'' +
                '}';
    }


    // Getters and setters for each field
    public List<String> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<String> solutions) {
        this.solutions = solutions;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
