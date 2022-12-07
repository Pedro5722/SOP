package com.pedro5722.controlefinanceiro.api.controller;

import com.pedro5722.controlefinanceiro.domain.entidade.Empenho;
import com.pedro5722.controlefinanceiro.domain.services.DespesaServices;
import com.pedro5722.controlefinanceiro.domain.services.EmpenhoServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public ResponseEntity<Empenho> save(Empenho empenho){
        empenho = empenhoServices.save(empenho);
        return ResponseEntity.ok(empenho);
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> deleteById(@RequestParam Long id){
        empenhoServices.deleteById(id);
        return new ResponseEntity<String>("Empenho excluido com sucesso", HttpStatus.OK);
    }
}
