package br.com.josedev.sistemaJuridico.controller;

import br.com.josedev.sistemaJuridico.model.Schedule;
import br.com.josedev.sistemaJuridico.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<?>> getAllProcesses() {
        return ResponseEntity.ok().body(scheduleService.getAllSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getAllSchedulesById(@PathVariable Long id) {
        return ResponseEntity.ok().body(scheduleService.getScheduleById(id));
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        System.out.println("Agenda criada: " + schedule.getProcess());
        scheduleService.createSchedule(schedule);
        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateProcess(@RequestBody Schedule schedule, @PathVariable Long id) {
        Schedule updatedSchedule = scheduleService.updateSchedule(schedule, id);
        if (updatedSchedule == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcessById(@PathVariable Long id) {
        scheduleService.deleteScheduleById(id);
        return ResponseEntity.ok().build();
    }

}
