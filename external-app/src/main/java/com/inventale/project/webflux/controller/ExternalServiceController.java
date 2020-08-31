package com.inventale.project.webflux.controller;

import com.inventale.project.model.Result;
import com.inventale.project.webflux.services.ExternalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExternalServiceController {
    private final ExternalService externalService;

    @Autowired
    public ExternalServiceController(
            ExternalService externalService
    ) {
        this.externalService = externalService;
    }

    @RequestMapping(value = "/answer", method = { RequestMethod.GET })
    public Result getAnswerToTheUltimateQuestionOfLifeTheUniverseAndEverything() {
        return externalService.getAnswerToTheUltimateQuestionOfLifeTheUniverseAndEverything();
    }
}
