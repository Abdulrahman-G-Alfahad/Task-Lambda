package CodedBTA.lambda_task.controller;

import CodedBTA.lambda_task.entity.GuestSuggestionEntity;
import CodedBTA.lambda_task.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class SuggestionStatusController {

    @Autowired
    private GuestSuggestionService guestSuggestionService;

    @GetMapping("/created")
    public ResponseEntity<List<GuestSuggestionEntity>> findAllCreated(){
        List<GuestSuggestionEntity> response = guestSuggestionService.findAllCreatedSuggestions();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/removed")
    public ResponseEntity<List<GuestSuggestionEntity>> findAllRemoved(){
        List<GuestSuggestionEntity> response = guestSuggestionService.findAllRemovedSuggestions();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/unique")
    public ResponseEntity<List<GuestSuggestionEntity>> findAllUnique(){
        List<GuestSuggestionEntity> response = guestSuggestionService.findNonDuplicate();
        return ResponseEntity.ok().body(response);
    }
}
