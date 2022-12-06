package com.pedro5722.controlefinanceiro.domain.entidade;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name="empenho", schema = "financeiro")
public class Empenho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer ano;
    @Column(nullable = false, unique = true)
    private Integer numero;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(nullable = false, scale = 16, precision = 2)
    private BigDecimal valor;
    private String observacao;
    @OneToMany(mappedBy = "empenho")
    private List<Pagamento> pagamentos;
    @ManyToOne
    @JoinColumn(name = "id_despesa", referencedColumnName = "id")
    private Despesa despesa;

}
