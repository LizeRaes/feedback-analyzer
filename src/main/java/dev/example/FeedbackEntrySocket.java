package dev.example;

import io.quarkiverse.langchain4j.ChatMemoryRemover;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.eclipse.microprofile.context.ManagedExecutor;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.io.UncheckedIOException;

@ServerEndpoint(value = "/processfeedback")
public class FeedbackEntrySocket {

    private static final Logger LOG = Logger.getLogger(FeedbackEntrySocket.class);
    private final ManagedExecutor managedExecutor;

    public FeedbackEntrySocket(ManagedExecutor managedExecutor) {
        this.managedExecutor = managedExecutor;
    }

    // TODO probably no need for this whole setup because we're not chatting
    @OnMessage
    public void onMessage(Session session, String formContent) throws Exception {
        if (formContent.equalsIgnoreCase("_ready_")) {
            return;
        }

        // we need to use a worker thread because OnMessage always runs on the event loop
        managedExecutor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    session.getBasicRemote().sendText("Thanks for your feedback. We'll let AI process it for us " +
                            "and analyze it together at the end of the session");
                    new FeedbackProcesserAgent().processFeedback(formContent);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                } catch (Exception e) {
                    LOG.error(e);
                }
            }
        });
    }

    @OnClose
    void onClose(Session session) {
    }

}
