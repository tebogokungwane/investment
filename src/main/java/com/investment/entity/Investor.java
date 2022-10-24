package com.investment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Investor  {

    @Id
    @SequenceGenerator(
            name = "investor_sequence",
            sequenceName = "investor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "investor_sequence"
    )

    private Long investorId;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String address;
    private String mobileNumber;
    private String emailAddress;

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.EAGER, cascade = CascadeType.ALL
            //cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "investor_id",
            referencedColumnName = "investorId"
    )
    private List<Product> products = new ArrayList<>();

}
