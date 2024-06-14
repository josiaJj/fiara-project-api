package school.hei.fiara.fiaraproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.Brand;
import school.hei.fiara.fiaraproject.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service

public class BrandService {
    @Autowired
    private BrandRepository brand ;
    public Optional<Brand> findById(Integer id){
        return brand.findById(id);
    }
    public List<Brand> findAll(){
        return  brand.findAll();
    }
    public  Brand save(Brand toSave){
        return  brand.save(toSave);
    }
    public  void delete (Integer id){
        brand.findById(id);
    }
}