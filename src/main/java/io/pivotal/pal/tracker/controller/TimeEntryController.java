package io.pivotal.pal.tracker.controller;

import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.repository.TimeEntryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class TimeEntryController {

    private final TimeEntryRepository repository;

    public TimeEntryController(TimeEntryRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {
        return ResponseEntity.created(null).body(repository.create(timeEntryToCreate));
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable(name = "id") long timeEntryId) {
        TimeEntry timeEntry = repository.find(timeEntryId);

        if (timeEntry == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(timeEntry);

    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable(name = "id") long timeEntryId, @RequestBody TimeEntry timeEntryToUpdate) {
        TimeEntry timeEntry = repository.update(timeEntryId, timeEntryToUpdate);

        if (timeEntry == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(timeEntry);
    }

    @DeleteMapping("time-entries/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id")long timeEntryId) {
        repository.delete(timeEntryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok().body(repository.list());
    }
}
