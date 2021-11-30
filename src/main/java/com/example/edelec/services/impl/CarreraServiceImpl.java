package com.example.edelec.services.impl;
import com.example.edelec.entitys.Carrera;
import com.example.edelec.repositories.CarreraRepository;
import org.springframework.stereotype.Service;
import com.example.edelec.services.CarreraService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService{

    private final CarreraRepository carreraRepository;


    public CarreraServiceImpl(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }



    @Transactional
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
