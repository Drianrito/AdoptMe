package adocao.adote.me;

import adocao.adote.me.Exception.AnimalJaCadastradoException;
import adocao.adote.me.Exception.AnimalNaoExisteException;
import adocao.adote.me.Exception.TutorJaExisteException;
import adocao.adote.me.Exception.TutorNaoExisteException;

import java.io.IOException;

public interface SistemaInterface {


    public boolean existeAnimalComID(String id);

    public void cadastrarAnimal(String id, String nome, String especie, String raca,String tamanho , String genero,int idade ,String descricao)throws AnimalJaCadastradoException;

    public void cadastrarTutor(String nome, String genero, int idade, String cpf, String telefone,String rua, String bairro,String cidade, String cep,String estado) throws TutorJaExisteException, IOException;
    public String pesquisarAnimalAdotado(String id) throws AnimalNaoExisteException;
    public boolean existeTutorComCpf(String cpf);
    public void AdotarAnimal(String Id) throws AnimalNaoExisteException, IOException;
    public String pesquisarAnimalPeloID(String id) throws AnimalNaoExisteException;
    public String pesquisarTutor(String cpf) throws TutorNaoExisteException;



    }
