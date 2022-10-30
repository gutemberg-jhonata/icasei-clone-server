package icasei.clone.server.gift;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "gifts")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;
    
    @Column(nullable = false)
    Double price;

    @Lob
    String imageBase64;

    @Column(nullable = false)
    Boolean available = true;

    String description;

    public Gift() {}

    public Gift(GiftPayload payload) {
        this.title = payload.getTitle();
        this.description = payload.getDescription();
        this.price = payload.getPrice();
        this.imageBase64 = payload.getImageBase64();
    }
}
