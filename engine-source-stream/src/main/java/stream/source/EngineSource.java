package stream.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class EngineSource {

    private Source source;

    @Autowired
    public EngineSource(Source source){
        this.source = source;
    }

    public void sourceMessage(final String message) {
        source.output().send(MessageBuilder.withPayload(message).build());
    }
}
