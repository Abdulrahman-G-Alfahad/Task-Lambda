package CodedBTA.lambda_task.service;

import CodedBTA.lambda_task.bo.CreateSuggestionRequest;
import CodedBTA.lambda_task.entity.GuestSuggestionEntity;
import CodedBTA.lambda_task.repository.GuestSuggestionRepository;
import CodedBTA.lambda_task.util.SuggestionProcessor;
import CodedBTA.lambda_task.util.SuggestionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionService {

    @Autowired
    private GuestSuggestionRepository guestSuggestionRepository;

    SuggestionProcessor processSuggestion = (request -> {
        GuestSuggestionEntity suggestion = new GuestSuggestionEntity();
        suggestion.setSuggestionText(request.getSuggestionText());
        suggestion.setRate(request.getRate());
        suggestion.setStatus(request.getStatus());
        guestSuggestionRepository.save(suggestion);
    });

    public void printAndProcessSuggestion(CreateSuggestionRequest request){
        processSuggestion.process(request);
    }

    public List<GuestSuggestionEntity> findAll(){
        return guestSuggestionRepository.findAll();
    }

    public List<GuestSuggestionEntity> findAllCreatedSuggestions(){
        return findAll().stream().filter(suggestion -> suggestion.getStatus().equals(SuggestionStatus.CREATE)).collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return findAll().stream().filter(suggestion -> suggestion.getStatus().equals(SuggestionStatus.REMOVE)).collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> findNonDuplicate() {
        Set<String> seen = new HashSet<>();

        return findAll().stream().filter(suggestion -> seen.add(suggestion.getStatus() + "|" + suggestion.getSuggestionText() + "|" + suggestion.getRate())).collect(Collectors.toList());
    }


}
