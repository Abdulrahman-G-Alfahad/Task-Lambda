package CodedBTA.lambda_task.bo;

import CodedBTA.lambda_task.util.SuggestionStatus;

public class CreateSuggestionRequest {

    private Double rate;

    private String suggestionText;

    private SuggestionStatus status;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public SuggestionStatus getStatus() {
        return status;
    }

    public void setStatus(SuggestionStatus status) {
        this.status = status;
    }
}
