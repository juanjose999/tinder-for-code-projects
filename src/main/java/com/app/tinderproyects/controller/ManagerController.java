package com.app.tinderproyects.controller;

import com.app.tinderproyects.dtos.manager.ManagerDto;
import com.app.tinderproyects.dtos.manager.ManagerResponseDto;
import com.app.tinderproyects.service.manager.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/manager")
@CrossOrigin("*")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping
    private ResponseEntity<List<ManagerResponseDto>> AllManager(){
        return ResponseEntity.ok(managerService.allManager());
    }

    @GetMapping("{id}")
    private ResponseEntity<ManagerResponseDto> findManagerById(@PathVariable Long id){
        return ResponseEntity.of(managerService.findManagerById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ManagerResponseDto> saveManager(@RequestBody ManagerDto managerDto){
        return ResponseEntity.ok(managerService.saveManger(managerDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ManagerResponseDto> updateManager(@PathVariable Long id, @RequestBody ManagerDto managerDto){
        return ResponseEntity.ok(managerService.updateManager(id, managerDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteManger(@PathVariable Long id){
        return ResponseEntity.ok(managerService.deleteManagerById(id));
    }


}
