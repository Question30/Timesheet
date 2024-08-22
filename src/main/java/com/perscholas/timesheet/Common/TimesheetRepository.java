package com.perscholas.timesheet.Common;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TimesheetRepository {

   private final List<Timesheet> timesheets = new ArrayList<>();

   @PostConstruct
    private void init(){
       System.out.println("Timesheet Repository is created");
       Timesheet timesheet1 = new Timesheet(1, "August 19th",
               LocalDateTime.now(), LocalDateTime.now().plus(8,
               ChronoUnit.HOURS), 8, Location.OFFICE, 30.0);

       Timesheet timesheet2 = new Timesheet(2, "August 20th",
               LocalDateTime.now(), LocalDateTime.now().plus(8,
               ChronoUnit.HOURS), 8, Location.OFFICE, 30.0);

       Timesheet timesheet3 = new Timesheet(3, "August 21st",
               LocalDateTime.now(), LocalDateTime.now().plus(8,
               ChronoUnit.HOURS), 8, Location.OFFICE, 30.0);

       timesheets.addAll(List.of(timesheet1, timesheet2, timesheet3));
       System.out.println("Finished creating Timesheets");
   }

    public List<Timesheet> findAll(){
       return timesheets;
   }

   public void createTimesheet(Timesheet timesheet){
      timesheets.add(timesheet);
   }

   public Optional<Timesheet> findById(Integer id){
      return timesheets.stream().filter(timesheet -> timesheet.id().equals(id)).findFirst();
   }

   public void update(Timesheet timesheet, Integer id){
      Optional<Timesheet> existingTimesheet = findById(id);

      if(existingTimesheet.isPresent()){
         timesheets.set(timesheets.indexOf(existingTimesheet.get()), timesheet);
      }
   }

   public void delete(Integer id){
      Optional<Timesheet> timesheet = findById(id);

      if(timesheet.isPresent()){
         timesheets.remove(timesheet.get());
      }
   }

}
