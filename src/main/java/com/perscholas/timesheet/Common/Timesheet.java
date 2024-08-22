package com.perscholas.timesheet.Common;

import java.time.LocalDateTime;

public record Timesheet(
        Integer id,
        String name,
        LocalDateTime punchInTime,
        LocalDateTime punchOutTime,
        Integer hoursWorked,
        Location location,
        Double payRate
) {
}
