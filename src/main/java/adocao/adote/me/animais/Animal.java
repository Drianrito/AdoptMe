package adocao.adote.me.animais;
import java.util.Objects;

public class Animal {

    private String id;
    private String nome;
    private String raca;
    private String tamanho;
    private String especie;
    private String descricao;
    private String genero;
    private int idade;
    private String ehAdotado;


    public Animal(String id, String nome, String especie,String raca ,String tamanho , String genero, int idade, String descricao, String ehAdotado) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.tamanho = tamanho;
        this.especie = especie;
        this.descricao = descricao;
        this.genero = genero;
        this.idade = idade;
        this.ehAdotado = ehAdotado;
    }

    public Animal() {
        this("", "", "", "", "", "", 0, "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEhAdotado() {
        return ehAdotado;
    }

    public void setEhAdotado(String ehAdotado) {
        this.ehAdotado = ehAdotado;
    }

    @Override
    public String toString() {
        return "\nID: " + this.id + "\nEspécie: " + this.especie + "\nRaça: " + this.raca + "\nNome: " + this.nome + "\nGênero: " + this.genero + "\nIdade: " + this.idade + "\nTamanho: " + this.tamanho + "\nDescrição: " + this.descricao + "\nAdotado: " +this.ehAdotado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}