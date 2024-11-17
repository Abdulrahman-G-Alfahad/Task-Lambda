package CodedBTA.lambda_task.util;

@FunctionalInterface
public interface SuggestionProcessor {
    void process(String suggestionText);
}
