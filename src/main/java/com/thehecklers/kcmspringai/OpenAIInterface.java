package com.thehecklers.kcmspringai;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/v1")
public interface OpenAIInterface {
    //    See this for reference for AOAI:
    //    https://learn.microsoft.com/en-us/rest/api/cognitiveservices/accountmanagement/models/list?view=rest-cognitiveservices-accountmanagement-2023-05-01&tabs=HTTP
    @GetExchange(value = "/models", accept = "application/json")
    ModelList listModels();
}
