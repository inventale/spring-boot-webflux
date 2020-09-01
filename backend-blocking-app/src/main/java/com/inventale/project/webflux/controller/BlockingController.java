package com.inventale.project.webflux.controller;

import com.inventale.project.model.Result;
import com.inventale.project.webflux.services.BlockingHttpClientService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Timed
public class BlockingController {
    private final BlockingHttpClientService blockingHttpClientService;

    @Autowired
    public BlockingController(
            BlockingHttpClientService blockingHttpClientService
    ) {
        this.blockingHttpClientService = blockingHttpClientService;
    }

    @RequestMapping(value = "/answer-blocking", method = { RequestMethod.GET })
    public Result answerBlocking() {
        log.info("BlockingController, the thread is {}", Thread.currentThread().getName());
        Result result = blockingHttpClientService.getAnswer();
        log.info("BlockingController, result is {}", result);
        return result;
    }
}
