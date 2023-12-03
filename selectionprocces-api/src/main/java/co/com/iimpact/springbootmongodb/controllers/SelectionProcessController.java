package co.com.iimpact.springbootmongodb.controllers;

import co.com.iimpact.springbootmongodb.dtos.SelectionProccesDTO;
import co.com.iimpact.springbootmongodb.models.SelectionProcess;
import co.com.iimpact.springbootmongodb.services.SelectionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/i-impact/selectionProcess")
public class SelectionProcessController {

    @Autowired
    private SelectionProcessService service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllSelectionProcesses(){
        List<SelectionProcess> selectionProcesses = service.allSelectionProcesses();

        if (!selectionProcesses.isEmpty()){
            return new ResponseEntity<List<SelectionProcess>>(selectionProcesses, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("No selection processes available", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findSelectionProcessById(@PathVariable String id){
        Optional<SelectionProcess> selectionProcessOptional = service.findSelectionProcessById(id);

        if (selectionProcessOptional.isPresent()){
            SelectionProcess selectionProcess = selectionProcessOptional.get();
            return new ResponseEntity<>(selectionProcess, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Organization not founded", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public SelectionProcess postSelectionProcess(@RequestBody SelectionProccesDTO selectionProccesDTO){
        SelectionProcess selectionProcess = new SelectionProcess(selectionProccesDTO.get_id(), selectionProccesDTO.getState(),
                selectionProccesDTO.getIdVolunteer(), selectionProccesDTO.getIdVolunteering());
        service.addNewSelectionProcess(selectionProcess);
        return selectionProcess;
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> deleteSelectionProcess(@PathVariable String id) {
        Optional<SelectionProcess> selectionprocessOptional = service.findSelectionProcessById(id);

        if (selectionprocessOptional.isPresent()) {
            SelectionProcess selectionProcess = selectionprocessOptional.get();
            service.deleteSelectionProcess(selectionProcess);
            return new ResponseEntity<>("Selection process deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Selection process no longer existed", HttpStatus.NOT_FOUND);
        }
    }

}
