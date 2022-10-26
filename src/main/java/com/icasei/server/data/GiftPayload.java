package com.icasei.server.data;

import lombok.Data;

@Data
public class GiftPayload {
    String title;
    String description;
    Double price;
    String imageBase64;
}
