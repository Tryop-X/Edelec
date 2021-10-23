package com.example.edelec.services.impl;
import com.example.edelec.entitys.Carrera;
import com.example.edelec.repositories.CarreraRepository;
import org.springframework.stereotype.Service;
import com.example.edelec.services.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService{

    private CarreraRepository carreraRepository;



    @Override
    public Carrera createsCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }
}
