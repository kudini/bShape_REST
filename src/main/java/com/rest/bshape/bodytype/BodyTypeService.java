package com.rest.bshape.bodytype;

import com.rest.bshape.sevices.GenericService;
import com.rest.bshape.exeption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodyTypeService implements GenericService<BodyType> {

    @Autowired
    private BodyTypeRepository bodyTypeRepository;

    @Override
    public List<BodyType> findAll() {
        return this.bodyTypeRepository.findAll();
    }

    @Override
    public Optional<BodyType> findById(Long id) {
        return this.bodyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BodyType not found with id :" + id));
    }

    @Override
    public BodyType create(BodyType bodyType) {
        return this.bodyTypeRepository.save(bodyType);
    }

    @Override
    public BodyType update(BodyType bodyType, Long id) {
        BodyType existingBodyType = this.bodyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BodyType not found with id:" + id));
        existingBodyType.setTypeOfBody(bodyType.getTypeOfBody());
        return this.bodyTypeRepository.save(existingBodyType);
    }

    @Override
    public ResponseEntity<BodyType> delete(Long id) {
        BodyType existingBodyType = this.bodyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BodyType not found with id:" + id));
        this.bodyTypeRepository.delete(existingBodyType);
        return ResponseEntity.ok().build();
    }
}