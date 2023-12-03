package co.com.iimpact.springbootmongodb.services;

import co.com.iimpact.springbootmongodb.models.SelectionProcess;
import co.com.iimpact.springbootmongodb.repositories.SelectionProccesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelectionProcessService {

    @Autowired
    private SelectionProccesRepository repository;

    public List<SelectionProcess> allSelectionProcesses(){ return repository.findAll();}

    public Optional<SelectionProcess> findSelectionProcessById(String id){ return repository.findById(id); }

    public void addNewSelectionProcess(SelectionProcess selectionProcess){ repository.save(selectionProcess); }

    public void deleteSelectionProcess(SelectionProcess selectionProcess){ repository.deleteById(selectionProcess.get_id()); }

}
