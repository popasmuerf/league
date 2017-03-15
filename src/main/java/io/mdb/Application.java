package io.mdb;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by mikeyb on 3/5/17.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    private static final org.slf4j.Logger log= LoggerFactory.getLogger(Application.class);
    public static void main(String[] args){
        SpringApplication.run(Application.class,args) ;
    }
    @Autowired(required = false) //guaranteed to be created before Application from a dependency injection POV
    DataBaseLoader dataBaseLoader ;
    @Autowired//guaranteed to be created before Application from a dependency injection POV
    TeammateRepository teammateRepository ;
    @PostConstruct
    void seeTheRoster(){
        for(Teammate teammate: teammateRepository.findAll()){
            log.info(teammate.toString());
        }
    }
}
