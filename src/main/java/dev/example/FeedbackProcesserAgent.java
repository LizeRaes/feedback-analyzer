package dev.example;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
public class FeedbackProcesserAgent {
    public void processFeedback(String formContent){
        // TODO parse the JSON from form
        int age = 30;
        String nationality = "Swedish";
        String gender = "female";
        String feedback = "The speakers are going way too fast and the code is way too complex. Next time they should" +
                " wait for everyone and provide less material. At the other hand, the example shown is definitely " +
                "inspiring and a great real life use case";

        UserFeedback userFeedback = new UserFeedback(age, nationality, gender, feedback);
        // TODO store all in database in a smart retrievable way
        System.out.println(userFeedback);
    }
}
