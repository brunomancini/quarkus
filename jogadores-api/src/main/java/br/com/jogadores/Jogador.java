package br.com.jogadores;
public class Jogador {
   private String nome;
   private Integer idade;
   public String getNome() {
       return this.nome;
   }
   public Integer getIdade() {
       return this.idade;
   }
   public void setNome(String nome) {
       this.nome = nome;
   }
   public void setIdade(Integer idade) {
       this.idade = idade;
   }
}