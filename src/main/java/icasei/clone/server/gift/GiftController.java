package icasei.clone.server.gift;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/gift")
@CrossOrigin(origins = "http://localhost:3000")
public class GiftController {

    @Autowired
    private GiftRepository giftRepository;

    @GetMapping(value = "/all")
    public List<Gift> getGifts() {
        return giftRepository.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createGift(GiftPayload payload) {
        Gift gift = new Gift(payload);
        giftRepository.save(gift);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Resource created.");
    }

    @PatchMapping(value = "/{id}/send")
    public ResponseEntity<String> sendGift(@PathVariable Long id) {
        Optional<Gift> gift = giftRepository.findById(id);

        if (gift.isPresent()) {
            gift.get().setAvailable(false);
            giftRepository.save(gift.get());

            return ResponseEntity.ok().body("Gift received.");
        } 

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Gift not found.");
    }
}
