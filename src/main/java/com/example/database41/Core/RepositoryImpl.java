package com.example.database41.Core;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepositoryImpl implements Reposytory {

    @PersistenceContext
    EntityManager entityManager;

    public void initial() {
        List<Persons> persons = List.of(
                Persons
                        .builder()
                        .embId(EmbId
                                .builder()
                                .name("Сергей")
                                .surname("Кравченко")
                                .age(28)
                                .build())
                        .phone_number("88841321684")
                        .city_of_living("Moscow")
                        .build(),
                Persons
                        .builder()
                        .embId(EmbId
                                .builder()
                                .name("Лев")
                                .surname("Котов")
                                .age(20)
                                .build())
                        .phone_number("8834534")
                        .city_of_living("Морс")
                        .build(),
                Persons
                        .builder()
                        .embId(EmbId
                                .builder()
                                .name("Василий")
                                .surname("Кремов")
                                .age(26)
                                .build())
                        .phone_number("881231231")
                        .city_of_living("Moscow")
                        .build()
        );
        persons.forEach(c -> entityManager.persist(c));
    }

    public List<Persons> getPersonsByCity(String city) {
        var query = entityManager.createNativeQuery("select * FROM PERSONS WHERE city_of_living = :city", Persons.class);
        query.setParameter("city", city);
        var pers = query.getResultList();

        return pers;
    };
}
