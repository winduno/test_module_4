package com.testpassmodul4.minh.service.nation;


import com.testpassmodul4.minh.model.Nation;
import com.testpassmodul4.minh.model.Province;
import com.testpassmodul4.minh.repository.INationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationService implements INationService {

    @Autowired
    private INationRepo nationRepo;

    @Override
    public Iterable<Nation> findAll() {
        return nationRepo.findAll();
    }

    @Override
    public Nation findById(Integer id) {
        return nationRepo.findById(id).get();
    }

    @Override
    public void save(Nation model) {
        nationRepo.save(model);
    }

    @Override
    public void remove(Integer id) {
        nationRepo.deleteById(id);
    }
}
