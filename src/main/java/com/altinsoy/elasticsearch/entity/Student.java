package com.altinsoy.elasticsearch.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "students")
public class Student {

    @Id
    private String id;

    @Field(name = "name", type = FieldType.Text)
    private String name;

    @Field(name = "surName", type = FieldType.Text)
    private String surName;

    @Field(name = "age", type = FieldType.Integer)
    private String age;

    @Field(name = "birthLocation", type = FieldType.Text)
    private String birthLocation;

}
