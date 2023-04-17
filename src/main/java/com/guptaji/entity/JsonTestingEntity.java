package com.guptaji.entity;

import com.fasterxml.jackson.databind.JsonNode;
import io.quarkiverse.hibernate.types.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Map;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class JsonTestingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;


    /*
            Input data to pass from swagger-ui
            {
              "name": "Naruto",
              "genre": "M",
              "age": 100,
              "anyJsonData": {
                "eligibility": {"key1": "valu1",
                                 "key2": "value2",
                                 "additionalProp2": {
                                                         "key1": ["valu1", "value2"]
                                                    }
                               }
                             }
            }
     */
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb") // or, json
    private Map<String, Object> anyJsonData;

    public JsonTestingEntity() {
        // default
    }

    public JsonTestingEntity(Long id, String name, String genre, int age, Map<String, Object> anyJsonData) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.age = age;
        this.anyJsonData = anyJsonData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Object> getAnyJsonData() {
        return anyJsonData;
    }

    public void setAnyJsonData(Map<String, Object> anyJsonData) {
        this.anyJsonData = anyJsonData;
    }

    @Override
    public String toString() {
        return "JsonTestingEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                ", anyJsonData=" + anyJsonData +
                '}';
    }
}
