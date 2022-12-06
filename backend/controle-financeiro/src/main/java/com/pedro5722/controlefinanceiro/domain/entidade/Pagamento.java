package com.pedro5722.controlefinanceiro.domain.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name="pagamento", schema = "financeiro")
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer ano;
    @Column(unique = true,nullable = false)
    private Integer numero;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(nullable = false,scale = 16, precision = 2)
    private BigDecimal valor;
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "id_empenho", referencedColumnName = "id")
    private Empenho empenho;

}
