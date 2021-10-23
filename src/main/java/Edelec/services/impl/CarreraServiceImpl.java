package Edelec.services.impl;
import com.example.edelec.entitys.Carrera;
import Edelec.repositories.CarreraRepository;
import org.springframework.stereotype.Service;
import Edelec.services.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService{

    private CarreraRepository carreraRepository;



    @Override
    public Carrera createsCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }
}
