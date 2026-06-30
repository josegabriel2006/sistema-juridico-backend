package br.com.josedev.sistemaJuridico.service;

import br.com.josedev.sistemaJuridico.model.Schedule;
import br.com.josedev.sistemaJuridico.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda de id: " + id + ", não encontrado."));
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Schedule schedule, Long id) {
        Schedule existing = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda de id: " + id + ", não encontrada."));
        existing.setTypeSchedule(schedule.getTypeSchedule());
        existing.setDateTime(schedule.getDateTime());
        existing.setLocation(schedule.getLocation());
        existing.setProcess(schedule.getProcess());
        existing.setClient(schedule.getClient());
        existing.setStatusSchedule(schedule.getStatusSchedule());
        existing.setObservations(schedule.getObservations());
        return scheduleRepository.save(existing);
    }

    public void deleteScheduleById(Long id) {
        scheduleRepository.deleteById(id);
    }
}