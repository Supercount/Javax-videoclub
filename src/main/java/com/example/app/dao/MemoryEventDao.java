package com.example.app.dao;

import com.example.app.dao.base.EventDao;
import com.example.app.dao.entity.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryEventDao implements EventDao {

    private static List<Event> events = new ArrayList<>();
    private static Long id=1L;

    @Override
    public Long save(Event event) {
        event.setId(id);
        events.add(event);
        return id++;
    }

    @Override
    public List<Event> findAll() {
        return Collections.unmodifiableList(events);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.events.stream()
                .filter(event -> event.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Event eventToUpdate) {
        boolean isUpdate=false;
        List<Event> tempList = new ArrayList<>();
        for (Event e:events) {
            if (e.getId() == eventToUpdate.getId()) {
                e = eventToUpdate;
                isUpdate=true;
            }
            tempList.add(e);
        }
        this.events = tempList;
        return isUpdate;
    }


    @Override
    public void delete(Long id) {
        this.events = this.events.stream()
                .filter(event -> event.getId() != id)
                .collect(Collectors.toList());
    }
}
