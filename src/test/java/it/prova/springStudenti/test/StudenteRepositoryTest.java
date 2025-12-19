package it.prova.springStudenti.test;

import it.prova.springStudenti.model.Studente;
import it.prova.springStudenti.repository.StudenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudenteRepositoryTest {



    @Test
    public void testCrud(){
        Studente studente = new Studente();


    }
}
