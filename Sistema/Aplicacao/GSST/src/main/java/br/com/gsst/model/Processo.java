package br.com.gsst.model;
// Generated 22/07/2016 22:11:44 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Processo generated by hbm2java
 */
@Entity
@Table(name = "processo", schema = "public"
)
public class Processo implements java.io.Serializable {

    private int idProcesso;
    private Funcionario funcionarioByIdRelator;
    private Funcionario funcionarioByIdRespCorrecao;
    private Maquina maquina;
    private String localizacao;
    private String setor;
    private String medidaCorretiva;
    private Date data;
    private Date prazo;
    private BigDecimal multa;
    private Set<Nr> nrs = new HashSet(0);

    public Processo() {
    }

    public Processo(int idProcesso, Funcionario funcionarioByIdRelator, Maquina maquina) {
        this.idProcesso = idProcesso;
        this.funcionarioByIdRelator = funcionarioByIdRelator;
        this.maquina = maquina;
    }

    public Processo(int idProcesso, Funcionario funcionarioByIdRelator, Funcionario funcionarioByIdRespCorrecao, Maquina maquina, String localizacao, String setor, String medidaCorretiva, Date data, Date prazo, BigDecimal multa, Set nrs) {
        this.idProcesso = idProcesso;
        this.funcionarioByIdRelator = funcionarioByIdRelator;
        this.funcionarioByIdRespCorrecao = funcionarioByIdRespCorrecao;
        this.maquina = maquina;
        this.localizacao = localizacao;
        this.setor = setor;
        this.medidaCorretiva = medidaCorretiva;
        this.data = data;
        this.prazo = prazo;
        this.multa = multa;
        this.nrs = nrs;
    }

    @Id

    @Column(name = "id_processo", unique = true, nullable = false)
    public int getIdProcesso() {
        return this.idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relator", nullable = false)
    public Funcionario getFuncionarioByIdRelator() {
        return this.funcionarioByIdRelator;
    }

    public void setFuncionarioByIdRelator(Funcionario funcionarioByIdRelator) {
        this.funcionarioByIdRelator = funcionarioByIdRelator;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resp_correcao")
    public Funcionario getFuncionarioByIdRespCorrecao() {
        return this.funcionarioByIdRespCorrecao;
    }

    public void setFuncionarioByIdRespCorrecao(Funcionario funcionarioByIdRespCorrecao) {
        this.funcionarioByIdRespCorrecao = funcionarioByIdRespCorrecao;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_maquina", nullable = false)
    public Maquina getMaquina() {
        return this.maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    @Column(name = "localizacao")
    public String getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Column(name = "setor")
    public String getSetor() {
        return this.setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Column(name = "medida_corretiva")
    public String getMedidaCorretiva() {
        return this.medidaCorretiva;
    }

    public void setMedidaCorretiva(String medidaCorretiva) {
        this.medidaCorretiva = medidaCorretiva;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", length = 29)
    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "prazo", length = 13)
    public Date getPrazo() {
        return this.prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    @Column(name = "multa", precision = 10)
    public BigDecimal getMulta() {
        return this.multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "processo_nr", schema = "public", joinColumns = {
        @JoinColumn(name = "id_processo", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_nr", nullable = false, updatable = false)})
    public Set<Nr> getNrs() {
        return this.nrs;
    }

    public void setNrs(Set nrs) {
        this.nrs = nrs;
    }

}