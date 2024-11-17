package CodedBTA.lambda_task.service;

import CodedBTA.lambda_task.entity.GuestSuggestionEntity;
import CodedBTA.lambda_task.repository.GuestSuggestionRepository;
import CodedBTA.lambda_task.util.SuggestionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSuggestionService {

    @Autowired
    private GuestSuggestionRepository guestSuggestionRepository;

    SuggestionProcessor processSuggestion = (suggestionText -> {
        GuestSuggestionEntity suggestion = new GuestSuggestionEntity();
        suggestion.setSuggestionText(suggestionText);
        suggestion.setRate(0d);
        guestSuggestionRepository.save(suggestion);
    });

    public void printAndProcessSuggestion(String text){
        processSuggestion.process(text);
    }

    public List<GuestSuggestionEntity> findAll(){
        return guestSuggestionRepository.findAll();
    }
}
