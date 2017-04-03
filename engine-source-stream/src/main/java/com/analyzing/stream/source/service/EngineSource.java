package com.analyzing.stream.source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import com.analyzing.stream.domain.TraceEvent;

@EnableBinding(Source.class)
public class EngineSource {

    private Source source;

    @Autowired
    public EngineSource(final Source source){
        this.source = source;
    }

    public void sourceEvent(final TraceEvent traceEvent) {
        source.output().send(MessageBuilder.withPayload(traceEvent).build());
    }
}
