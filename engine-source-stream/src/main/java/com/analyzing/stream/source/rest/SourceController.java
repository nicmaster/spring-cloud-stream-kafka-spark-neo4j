package com.analyzing.stream.source.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.analyzing.stream.domain.TraceEvent;
import com.analyzing.stream.source.service.EngineSource;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class SourceController {
    private EngineSource engineSource;

    @Autowired
    public SourceController(final EngineSource engineSource){
        this.engineSource = engineSource;
    }

    @RequestMapping(value = "/trace/event", method = POST, consumes = {APPLICATION_JSON_VALUE})
    @ResponseStatus(ACCEPTED)
    public void traceEvent(@RequestBody TraceEvent traceEvent){
        engineSource.sourceEvent(traceEvent);
    }
}
