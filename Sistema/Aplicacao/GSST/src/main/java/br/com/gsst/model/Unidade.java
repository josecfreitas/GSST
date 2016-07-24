package br.com.gsst.model;
// Generated 22/07/2016 22:11:44 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Unidade generated by hbm2java
 */
@Entity
@Table(name = "unidade", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = "cnpj"),
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "ie")}
)
public class Unidade implements java.io.Serializable {

    private int idUnidade;
    private Empresa empresa;
    private String nome;
    private String cnpj;
    private String ie;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String contato;
    private String email;
    private int numFuncionarios;
    private Set<Funcionario> funcionarios = new HashSet(0);
    private Set<Maquina> maquinas = new HashSet(0);

    public Unidade() {
    }

    public Unidade(int idUnidade, Empresa empresa, String nome, String cnpj, int numFuncionarios) {
        this.idUnidade = idUnidade;
        this.empresa = empresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
    }

    public Unidade(int idUnidade, Empresa empresa, String nome, String cnpj, String ie, String logradouro, String numero, String bairro, String complemento, String contato, String email, int numFuncionarios, Set funcionarios, Set maquinas) {
        this.idUnidade = idUnidade;
        this.empresa = empresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.ie = ie;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.contato = contato;
        this.email = email;
        this.numFuncionarios = numFuncionarios;
        this.funcionarios = funcionarios;
        this.maquinas = maquinas;
    }

    @Id

    @Column(name = "id_unidade", unique = true, nullable = false)
    public int getIdUnidade() {
        return this.idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "cnpj", unique = true, nullable = false)
    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Column(name = "ie", unique = true)
    public String getIe() {
        return this.ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    @Column(name = "logradouro")
    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Column(name = "numero")
    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(name = "bairro")
    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name = "complemento")
    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column(name = "contato")
    public String getContato() {
        return this.contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "num_funcionarios", nullable = false)
    public int getNumFuncionarios() {
        return this.numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidade")
    public Set<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidade")
    public Set<Maquina> getMaquinas() {
        return this.maquinas;
    }

    public void setMaquinas(Set maquinas) {
        this.maquinas = maquinas;
    }

}