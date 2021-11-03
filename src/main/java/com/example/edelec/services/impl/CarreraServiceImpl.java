package com.example.edelec.services.impl;
import com.example.edelec.entitys.Carrera;
import com.example.edelec.repositories.CarreraRepository;
import org.springframework.stereotype.Service;
import com.example.edelec.services.CarreraService;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService{

    private final CarreraRepository carreraRepository;


    public CarreraServiceImpl(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }



    @Override
    public Carrera createCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public List<Carrera> getAllCarrera() {
        return carreraRepository.findAll();
    }


    @Override
    public Carrera getCarreraById (Integer IdCarrera) {
        return carreraRepository.findById(IdCarrera).orElse(new Carrera());
    }



    @Override
    public Carrera updateCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }


    @Override
    public void deleteCarrera(Integer IdCarrera) {
        carreraRepository.deleteById(IdCarrera);
    }
}
