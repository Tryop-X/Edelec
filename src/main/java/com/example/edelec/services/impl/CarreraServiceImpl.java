package com.example.edelec.services.impl;
import com.example.edelec.entitys.Carrera;
import com.example.edelec.repositories.CarreraRepository;
import org.springframework.stereotype.Service;
import com.example.edelec.services.CarreraService;

<<<<<<< HEAD
@Service
public class CarreraServiceImpl implements CarreraService{

    private CarreraRepository carreraRepository;



    @Override
    public Carrera createsCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
=======
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
    public Carrera getCarreraById (Long IdCarrera) {
        Optional<Carrera> carreraFromDb=carreraRepository.findById(IdCarrera);
        return carreraFromDb.orElseThrow(RuntimeException::new);
    }




    @Override
    public Carrera updateCarrera(Carrera carrera) {
        Carrera carreraFromDb=carreraRepository.findById(carrera.getIdCarrera())
                .orElse(new Carrera());
        carreraFromDb.setNombreCarrera(carrera.getNombreCarrera());
        carreraFromDb.setDescripcionUniversidad(carrera.getDescripcionUniversidad());
        carreraFromDb.setSalarioPromedio(carrera.getSalarioPromedio());
        carreraFromDb.setTasadeEmpleabilidad(carrera.getTasadeEmpleabilidad());
        return carreraRepository.save(carreraFromDb);
    }


    @Override
    public void deleteCarrera(Long IdCarrera) {
        Carrera carrerafromDb=carreraRepository.findById(IdCarrera)
                .orElseThrow(RuntimeException::new);
        carreraRepository.delete(carrerafromDb);
>>>>>>> a12fa5675f3614a4d4f59a67db95bd404f6016c3
    }
}
