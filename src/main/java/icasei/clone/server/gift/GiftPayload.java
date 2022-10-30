package icasei.clone.server.gift;

import lombok.Data;

@Data
public class GiftPayload {
    String title;
    String description;
    Double price;
    String imageBase64;
}
