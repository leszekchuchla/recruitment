package org.example;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SomeService {

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private List<String> DAYS_OF_WEEK = List.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");

  public void calculateAndStore(String... parameters) {
    store(method(parameters));
  }

  public List<String> method(String... parameters) {
    for(String string:parameters) {
      if(!DAYS_OF_WEEK.contains(string)) {
        throw new IllegalArgumentException("Invalid day of week: " + string);
      }
    }

    if(parameters.length==0) {
      return new ArrayList<>();
    }
    else if(parameters.length==1) {
      String word="";
      for(int i=0;i<3;i++) {
        word = word+parameters[0].substring(i,i+1);
      }
      List<String> listToReturn = new ArrayList<>();
      listToReturn.add(word);
      return listToReturn;
    }
    else if(parameters.length > 1) {
      List<String> listToReturn = new ArrayList<>();

      for(int i=0;i<parameters.length;i++) {
        String word="";
        for(int j=0;j<3;j++) {
          word = word + parameters[i].substring(j, j + 1);
        }
        listToReturn.add(word);
      }
      return listToReturn;
    }
    return new ArrayList<>();
  }

  public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Transactional
  private void store(List<String> items) {
    String record="";
    for(String item:items) {
      if(record=="") {
        record=item;
      }
      else {
        record=record+","+item;
      }
    }
    namedParameterJdbcTemplate.update("INSERT INTO table (record) VALUES ('"+record+"')",Map.of());
  }

}
