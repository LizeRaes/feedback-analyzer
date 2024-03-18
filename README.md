# Purpose

This is a port of the Spring Boot demo of Langchain4j to Quarkus

NOTE: it currently uses langchain4j 0.25

# Using it

Set your OpenAI key in the `quarkus.langchain4j.openai.api-key` property of `application.properties`.
The same thing can also be accomplished by using the `QUARKUS_LANGCHAIN4J_OPENAI_API_KEY` environment variable

```bash
mvn quarkus:dev
```

and then simply open `http://localhost:8080`
