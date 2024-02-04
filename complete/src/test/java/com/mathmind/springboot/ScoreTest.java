package com.mathmind.springboot;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

//@SpringBootTest
//@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ScoreTest {

//    @Test
//    public void givenSingletonScope_whenSetName_thenEqualNames() {
       /* ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("scopes.xml");

        Score scoreSingletonA = (Score) applicationContext.getBean("scoreSingleton");
        Score scoreSingletonB = (Score) applicationContext.getBean("scoreSingleton");

        scoreSingletonA.setPoint(1234);
        Assertions.assertEquals(1234, scoreSingletonB.getPoint());

        ((AbstractApplicationContext) applicationContext).close();*/
//    }
}
