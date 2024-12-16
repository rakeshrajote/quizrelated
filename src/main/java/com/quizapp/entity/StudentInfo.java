package com.quizapp.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is mandatory")
    private String emailId;

    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mono;

    @Min(value = 1, message = "Graduate years must be at least 1")
    private int graduateYears;

    @NotBlank(message = "Department name is mandatory")
    private String departmentName;

    @Min(value = 1900, message = "Invalid passout year")
    @Max(value = 2100, message = "Invalid passout year")
    private int passoutYears;

    @NotBlank(message = "College name is mandatory")
    private String collegeName;

    @ElementCollection
    @CollectionTable(name = "interest_domains", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "interest_domain")
    private List<String> interestDomain;



}

