package CodedBTA.lambda_task.controller;

import CodedBTA.lambda_task.bo.CreateSuggestionRequest;
import CodedBTA.lambda_task.entity.GuestSuggestionEntity;
import CodedBTA.lambda_task.service.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuggestionController {

    @Autowired
    private GuestSuggestionService guestSuggestionService;

    @PostMapping("/suggestions")
    public ResponseEntity<GuestSuggestionEntity> process(@RequestBody CreateSuggestionRequest request){
        guestSuggestionService.printAndProcessSuggestion(request.getSuggestionText());
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<GuestSuggestionEntity>> listResponseEntity(){
        List<GuestSuggestionEntity> allSuggestions = guestSuggestionService.findAll();
        return ResponseEntity.ok().body(allSuggestions);
    }

}
