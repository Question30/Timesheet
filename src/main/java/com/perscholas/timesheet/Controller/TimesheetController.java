package com.perscholas.timesheet.Controller;

import com.perscholas.timesheet.Common.Timesheet;
import com.perscholas.timesheet.Common.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/timesheets")
@RestController
public class TimesheetController {

    private final TimesheetRepository timesheetRepository;

    @Autowired
    public TimesheetController(TimesheetRepository timesheetRepository){
        this.timesheetRepository = timesheetRepository;
    }

    //Getting all of our timesheets
    @GetMapping("")
    public List<Timesheet> home(){
        return timesheetRepository.findAll();
    }

    //Post a timesheet
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createTimesheet(@RequestBody Timesheet timesheet){
        timesheetRepository.createTimesheet(timesheet);
    }

    //Get by id
    @GetMapping("/{id}")
    public Timesheet getTimesheetById(@PathVariable Integer id){
        Optional<Timesheet> timesheet = timesheetRepository.findById(id);

        if(timesheet.isEmpty()){
            throw new RuntimeException();
        }

        return timesheet.get();

    }

    //Put a timesheet
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateTimesheetById(@RequestBody Timesheet timesheet, @PathVariable Integer id){
        timesheetRepository.update(timesheet, id);
    }


    //Delete a timesheet
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTimesheet(@PathVariable Integer id){
        timesheetRepository.delete(id);
    }

}
