package br.com.rh;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Funcionario {
    @Min(value = 18, message = "O empregado deve ter 18 ou mais anos")
    private Integer idade;

    @NotBlank(message = "O nome deve ser informado")
    private String nome;

    @Pattern(regexp = "SP|São Paulo", message = "O empregado deve ser do estado de São Paulo")
    private String estado;

    @Pattern(regexp = "[\\d]{2,3}[\\d]{4,5}[\\d]{5}", message = "Telefone inválido")
    private String telefone;

    @Pattern(regexp = "[\\d]{1,3}\\.[\\d]{3}\\.[\\d]{3}\\-[\\d]{2}", message = "CPF inválido")
    private String cpf;
    
    @Pattern(regexp = "[a-z_-\\.]+@[a-z_-\\.]+", message = "Email inválido")
    private String email;

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}