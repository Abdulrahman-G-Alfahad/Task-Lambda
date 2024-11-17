package CodedBTA.lambda_task.bo;

public class CreateSuggestionRequest {

    private Double rate;

    private String suggestionText;



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
}
