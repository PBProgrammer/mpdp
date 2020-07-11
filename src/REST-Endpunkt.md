import com.section9.rubbel.models.DTC;
import com.section9.rubbel.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = {"https://mrtx87.github.io","http://mrtx87.github.io","http://mrtx87.github.io/Streamapp","https://mrtx87.github.io/Streamapp","http://localhost", "http://localhost:4200", "https://localhost:4200"})
public class RestController {


    @Autowired
    AppService appService;

    @GetMapping(path = {"/start-new-rubbel-game-session"})
    public ResponseEntity<DTC> requestNewRubbelGameSession() {
        // player id
        // game session id
        DTC responseDTC = appService.createRubbelGameSession();
        if (responseDTC != null) {
            return ResponseEntity.ok().body(responseDTC);
        }
        return ResponseEntity.badRequest().build();
    }




    @GetMapping(path = {"/join-rubbel-game-session/{gameSessionId}"})
    public ResponseEntity<DTC> joinRubbelGameSession(@PathVariable("gameSessionId") UUID gameSessionId) {
        // player id
        // game session id
        DTC responseDTC = appService.joinRubbelGameSession(gameSessionId);
        if (responseDTC != null) {
            return ResponseEntity.ok().body(responseDTC);
        }
        return ResponseEntity.badRequest().build();
    }

//    @GetMapping(path = {"/create-room"})
//    public ResponseEntity<DataTransferContainer> requestCreateRoom() {
//        DataTransferContainer responseDTC = appService.createRoom();
//        if (responseDTC != null) {
//            return ResponseEntity.ok().body(responseDTC);
//        }
//        return ResponseEntity.badRequest().build();
//    }

//    @PostMapping(path = {"/join-room/{roomId}"})
//    public ResponseEntity<DataTransferContainer> requestJoinRoom(@PathVariable("roomId") UUID roomId, @RequestBody DataTransferContainer requestDTC) {
//        DataTransferContainer responseDTC = appService.joinRoom(roomId, requestDTC);
//        if (responseDTC != null) {
//            return ResponseEntity.ok().body(responseDTC);
//        }
//        return ResponseEntity.notFound().build();
//    }


}