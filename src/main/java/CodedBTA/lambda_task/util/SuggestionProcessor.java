package CodedBTA.lambda_task.util;

import CodedBTA.lambda_task.bo.CreateSuggestionRequest;

@FunctionalInterface
public interface SuggestionProcessor {
    void process(CreateSuggestionRequest suggestionText);
}
