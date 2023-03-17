package com.example.database41.Core;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Persons {

    @EmbeddedId
    private EmbId embId;

    private String phone_number;

    private String city_of_living;

}
