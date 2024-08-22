package com.perscholas.timesheet;

import com.perscholas.timesheet.Common.Location;
import com.perscholas.timesheet.Common.Timesheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@SpringBootApplication
public class TimesheetApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(TimesheetApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args ->{

			Timesheet timesheet1 = new Timesheet(1, "August 19th",
					LocalDateTime.now(), LocalDateTime.now().plus(8,
					ChronoUnit.HOURS), 8, Location.OFFICE, 30.0);

			Timesheet timesheet2 = new Timesheet(2, "August 20th",
					LocalDateTime.now(), LocalDateTime.now().plus(8,
					ChronoUnit.HOURS), 8, Location.OFFICE, 30.0);

			Timesheet timesheet3 = new Timesheet(3, "August 21th",
					LocalDateTime.now(), LocalDateTime.now().plus(8,
					ChronoUnit.HOURS), 8, Location.OFFICE, 30.0);

			List<Timesheet> timesheets = List.of(timesheet1, timesheet2, timesheet3);

//			LOGGER.info("Timesheet Application up and running {}", timesheet1);
//			LOGGER.warn("I am warning you!!! {}", timesheet2);
			LOGGER.error("error! {}", timesheets);
		};
	}

}
