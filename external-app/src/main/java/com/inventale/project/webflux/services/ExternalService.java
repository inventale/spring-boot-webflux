package com.inventale.project.webflux.services;

import com.inventale.project.model.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExternalService {
    @SneakyThrows
    public Result getAnswerToTheUltimateQuestionOfLifeTheUniverseAndEverything() {
        //long blocking operation
        Thread.sleep(2000);
        return new Result("42");
    }
}