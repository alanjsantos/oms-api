package com.omsapi.models;

import com.omsapi.models.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "request_stage")
public class RequestStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "realization_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date realizationDate;

    @Column(length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestState state;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
