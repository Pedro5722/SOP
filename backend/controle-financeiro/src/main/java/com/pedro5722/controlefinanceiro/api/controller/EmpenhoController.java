package com.pedro5722.controlefinanceiro.api.controller;

import com.pedro5722.controlefinanceiro.api.dto.EmpenhoDTO;
import com.pedro5722.controlefinanceiro.domain.entidade.Empenho;
import com.pedro5722.controlefinanceiro.domain.services.EmpenhoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empenho")
public class EmpenhoController {
    @Autowired
    private EmpenhoServices empenhoServices;

    @GetMapping()
    public ResponseEntity<List<Empenho>> findAll(){
        List<Empenho> empenhos = empenhoServices.findAll();
        return ResponseEntity.ok().body(empenhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empenho> findById(@PathVariable Long id){
        Empenho empenho = empenhoServices.findById(id);
        return ResponseEntity.ok(empenho);
    }
    @PostMapping
    public ResponseEntity<Empenho> save(@RequestBody EmpenhoDTO empenhoDTO){
        Empenho empenho = Empenho.builder()
                .ano(empenhoDTO.getAno())
                .numero(empenhoDTO.getNumero())
                .data(empenhoDTO.getData())
                .valor(empenhoDTO.getValor())
                .observacao(empenhoDTO.getObservacao())
                .build();
        empenho = empenhoServices.save(empenho);
        return ResponseEntity.ok(empenho);
    }
    @PutMapping
    public ResponseEntity<Empenho> update(@RequestBody EmpenhoDTO empenhoDTO){
        Empenho empenho = Empenho.builder()
                .ano(empenhoDTO.getAno())
                .numero(empenhoDTO.getNumero())
                .data(empenhoDTO.getData())
                .valor(empenhoDTO.getValor())
                .observacao(empenhoDTO.getObservacao())
                .build();
        empenho = empenhoServices.save(empenho);
        return ResponseEntity.ok(empenho);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        empenhoServices.deleteById(id);
        return new ResponseEntity<String>("Empenho excluido com sucesso", HttpStatus.OK);
    }
}
