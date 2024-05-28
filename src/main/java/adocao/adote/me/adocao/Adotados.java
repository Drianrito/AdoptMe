package adocao.adote.me.adocao;

import adocao.adote.me.tutor.Tutor;

public class Adotados {
    private String nomeTutor;
    private String cpfTutor;
    private String nomeAnimal;
    private String idAnimal;
    private String especieAnimal;
    public Adotados(String nomeTutor, String cpfTutor, String nomeAnimal, String idAnimal, String especieAnimal) {
        this.nomeTutor = nomeTutor;
        this.cpfTutor = cpfTutor;
        this.nomeAnimal = nomeAnimal;
        this.idAnimal = idAnimal;
        this.especieAnimal = especieAnimal;

    }
    public String getNomeTutor() {
        return nomeTutor;
    }

    public String getCpfTutor() {
        return cpfTutor;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public String toString(){
        return "\nTutor: " + nomeTutor + "\nAnimal: "+nomeAnimal + "\nID: "+idAnimal+"\nEspecie: "+especieAnimal;
    }
}
