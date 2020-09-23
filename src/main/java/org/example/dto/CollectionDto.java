package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CollectionDto {
    private String name;
    private String description;
    private String image;
    private String userEmail;
}
