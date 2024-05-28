package adocao.adote.me.tutor;



import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String nome;
    private String genero;
    private int idade;
    private String cpf;
    private String telefone;
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public Tutor(String nome, String genero, int idade, String cpf, String telefone, String rua, String bairro, String cidade, String cep, String estado) {
        this.nome = nome;
        this.genero=genero;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro =bairro;
        this.cidade = cidade;
        this.cep =cep;
        this.estado=estado;

    }
    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {return "Tutor: "+ this.nome + "\nIdade: " + idade + "\nCPF: "+this.cpf + "\nEndereço: " + this.rua + ", " + this.bairro +", " +cidade+", "+estado+", "+estado+", " +cep+ "\nTelefone: " +telefone;
    }
}
