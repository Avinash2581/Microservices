package com.alibou.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.alibou.demo.customId.CustomIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="micro_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
    @GenericGenerator(
            name = "hotel_seq",
            type = com.alibou.demo.customId.CustomIdGenerator.class,
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "user_"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = 
                    		"%05d")
            }
    )
	private String userId;
	
	@NotBlank
	@Column(nullable = false,length=20)
	private String fname;
	
	@NotBlank
	@Column(nullable = false)
	private String lname;
	
	@NotBlank
	@Column(nullable=false,unique=true)
	private String email;
	
	@NotBlank
	 private String about;
	 
	 @Column(nullable=false)
	 private Date date;
	 
	 @Transient
	 private List<Rating> ratings =new ArrayList<>();

	
	 

	
}
