package io.mdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by mikeyb on 3/14/17.
 */
@Service
//@Profile("!production")
public class DataBaseLoader {
    private  TeammateRepository teammateRepository;
    private   TeamRepository teamRepository;
    @Autowired
    public DataBaseLoader(TeammateRepository teammateRepository , TeamRepository teamRepository){
        this.teammateRepository = teammateRepository;
        this.teamRepository =teamRepository;
    }
    @PostConstruct
    private void initDataBase(){
        Team springBootTeam = new Team("Spring Boot Badgers");
        teamRepository.save(springBootTeam);
        Teammate greg = new Teammate("Greg","Turnquist");
        greg.setPosistion("2nd base");
        greg.setTeam(springBootTeam);
        teammateRepository.save(greg);
        Teammate roy = new Teammate("Roy","Clarkson");
        roy.setPosistion("1st base");
        roy.setTeam(springBootTeam);
        teammateRepository.save(roy);
        Teammate phil = new Teammate("Phil","Webb");
        phil.setPosistion("pitcher");
        phil.setTeam(springBootTeam);
        teammateRepository.save(phil);
    }
}
