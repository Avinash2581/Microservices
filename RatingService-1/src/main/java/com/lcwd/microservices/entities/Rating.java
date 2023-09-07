package com.lcwd.microservices.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lcwd.microservices.customId.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    @GenericGenerator(
            name = "rating_seq",
            type = com.lcwd.microservices.customId.CustomIdGenerator.class,
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "rating_"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = 
                    		"%04d")
            }
    )
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
