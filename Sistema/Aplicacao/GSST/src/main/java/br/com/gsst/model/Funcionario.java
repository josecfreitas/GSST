package br.com.gsst.model;
// Generated 22/07/2016 15:45:22 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Funcionario generated by hbm2java
 */
@Entity
@Table(name = "funcionario", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = "cpf"),
    @UniqueConstraint(columnNames = "email")}
)
public class Funcionario implements java.io.Serializable {

    private int idFuncionario;
    private Funcionario funcionario;
    private Unidade unidade;
    private String nome;
    private String funcao;
    private String cpf;
    @NotEmpty(message = "{funcionario.email.empty}")
    @Email(message = "{funcionario.email.formato}")
    private String email;
    private String contato;
    private String setor;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private Set<Processo> processosForIdRelator = new HashSet(0);
    private Set<Processo> processosForIdRespCorrecao = new HashSet(0);
    private Usuario usuario;
    private Set<Funcionario> funcionarios = new HashSet(0);

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nome, String funcao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.funcao = funcao;
    }

    public Funcionario(int idFuncionario, Funcionario funcionario, Unidade unidade, String nome, String funcao, String cpf, String email, String contato, String setor, String logradouro, String numero, String bairro, String complemento, Set<Processo> processosForIdRelator, Set<Processo> processosForIdRespCorrecao, Usuario usuario, Set<Funcionario> funcionarios) {
        this.idFuncionario = idFuncionario;
        this.funcionario = funcionario;
        this.unidade = unidade;
        this.nome = nome;
        this.funcao = funcao;
        this.cpf = cpf;
        this.email = email;
        this.contato = contato;
        this.setor = setor;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.processosForIdRelator = processosForIdRelator;
        this.processosForIdRespCorrecao = processosForIdRespCorrecao;
        this.usuario = usuario;
        this.funcionarios = funcionarios;
    }

    @Id

    @Column(name = "id_funcionario", unique = true, nullable = false)
    public int getIdFuncionario() {
        return this.idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chefe")
    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidade")
    public Unidade getUnidade() {
        return this.unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Column(name = "nome", nullable = false)
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "funcao", nullable = false)
    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Column(name = "cpf", unique = true)
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "contato")
    public String getContato() {
        return this.contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Column(name = "setor")
    public String getSetor() {
        return this.setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionarioByIdRelator")
    public Set<Processo> getProcessosForIdRelator() {
        return this.processosForIdRelator;
    }

    public void setProcessosForIdRelator(Set processosForIdRelator) {
        this.processosForIdRelator = processosForIdRelator;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionarioByIdRespCorrecao")
    public Set<Processo> getProcessosForIdRespCorrecao() {
        return this.processosForIdRespCorrecao;
    }

    public void setProcessosForIdRespCorrecao(Set processosForIdRespCorrecao) {
        this.processosForIdRespCorrecao = processosForIdRespCorrecao;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "funcionario")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
    public Set<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }

}
