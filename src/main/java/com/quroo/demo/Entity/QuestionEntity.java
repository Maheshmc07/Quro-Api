package com.quroo.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    @Column
     String title;
    @Column
    String body;
    @OneToMany
            @Embedded
    List<TopicEntity> topicList=new ArrayList<>();
    @Temporal(TemporalType.TIME)
            @CreatedBy
    Date CreatedAT;


   // UserEntity user_id;


}
