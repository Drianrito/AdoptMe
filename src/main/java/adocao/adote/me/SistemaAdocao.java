package adocao.adote.me;
import adocao.adote.me.adocao.Adotados;
import adocao.adote.me.Exception.*;
import adocao.adote.me.tutor.Tutor;
import adocao.adote.me.animais.Animal;
import adocao.adote.me.gravacao.GravaDados;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SistemaAdocao implements SistemaInterface {

    public List<Animal> listaAnimal = new ArrayList<>();
    public List<Tutor> listaTutor = new ArrayList<>();
    public List<Adotados> listaAdotados = new ArrayList<>();
    private GravaDados gravador = new GravaDados();

    public static final String ARQUIVO_ANIMAIS = "animais.txt";
    public static final String ARQUIVO_TUTORES= "tutores.txt";
    public static final String ARQUIVO_ADOTADOS = "adotados.txt";

    public boolean existeAnimalComID(String id) {
        for (Animal a: listaAnimal){
            if(a.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public String QuantAnimaisParaAdocao() {
        try{
        int cont = 0;
        for (Animal a : listaAnimal) {
            if (a.getEhAdotado().equals("NAO")) {
                cont++;
            }
        }
        return "A quantidade de animais para adoção é igual a " +cont;}
        catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Informação fornecida está incorreta.");
    }
        return null;
    }

    public String QuantAnimaisAdotados() {
        int cont = 0;
        for (Animal a : listaAnimal) {
            if (a.getEhAdotado().equals("SIM")) {
                cont++;
            }
        }
        return "A quantidade de animais adotados é igual a " +cont;
    }
    public void cadastrarAnimal(String id, String nome, String especie, String raca,String tamanho , String genero,int idade ,String descricao )throws AnimalJaCadastradoException  {
        if (existeAnimalComID(id)) {
            throw new AnimalJaCadastradoException("Esse Animal já está cadastrado.");
        } else {
            Animal animal = new Animal(id, nome, especie, raca,tamanho, genero,idade, descricao, "NAO");
            listaAnimal.add(animal);
        }
    }

    public String pesquisarAnimalPeloID(String id) throws AnimalNaoExisteException {
        for (Animal a : listaAnimal) {
            if (existeAnimalComID(id)) {
                return a.toString();
            }else{for(Adotados ad: listaAdotados){
                    if(existeAnimalComID(id)) {
                        return ad.toString();
                    }
                    else{throw new AnimalNaoExisteException("Esse animal não existe.");
                    }
                }

            }

        }return null;
    }

    public void AdotarAnimal(String Id) throws IOException {

        boolean continuar = true;
        try {
            while (continuar) {
                for (Animal a : listaAnimal) {
                    if (a.getId().equals(Id)){
                        if(a.getEhAdotado().equals("SIM")){
                            JOptionPane.showMessageDialog(null, "Este animal já foi adotado.");
                            continuar = false;
                        }
                        else{
                        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Tutor já está cadastrado?\n 1.Sim \n 2.Não \n 3.Voltar"));
                        if (opcao == 1) {
                            String cpf = JOptionPane.showInputDialog("Digite o CPF:");
                            for (Tutor t : listaTutor) {
                                if (t.getCpf().equals(cpf)) {
                                    String nomeTutor = t.getNome();
                                    String cpfTutor = t.getCpf();
                                    String nomeAnimal = a.getNome();
                                    String especieAnimal = a.getEspecie();
                                    String idAnimal = a.getId();
                                    a.setEhAdotado("SIM");
                                    Adotados novoAdotado = new Adotados(nomeTutor, cpfTutor, nomeAnimal, idAnimal,especieAnimal );
                                    listaAdotados.add(novoAdotado);
                                    GravaListaAdotados(listaAdotados, "adotados.txt");
                                    GravaListaAnimais(listaAnimal,"animais.txt");
                                    JOptionPane.showMessageDialog(null,"Animal Adotado com sucesso!");
                                    continuar = false;

                                }
                            }
                        }
                        if (opcao == 2) {
                            String nomeTutor = JOptionPane.showInputDialog("Digite o nome:");
                            String generoTutor = JOptionPane.showInputDialog("Digite o genero");
                            int idadeTutor = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:"));
                            String cpf = JOptionPane.showInputDialog("Digite o CPF:");
                            String telefone = JOptionPane.showInputDialog("Digite o telefone:");
                            String rua = JOptionPane.showInputDialog("Digite a rua:");
                            String bairro = JOptionPane.showInputDialog("Digite o bairro:");
                            String cidade = JOptionPane.showInputDialog("Digite a cidade:");
                            String estado = JOptionPane.showInputDialog("Digite o estado:");
                            String cep = JOptionPane.showInputDialog("Digite o CEP:");
                            try {
                                cadastrarTutor(nomeTutor, generoTutor, idadeTutor, cpf, telefone, rua, bairro, cidade, estado, cep);
                                JOptionPane.showMessageDialog(null,"Tutor Cadastrado!");
                            } catch (TutorJaExisteException e) {
                                JOptionPane.showMessageDialog(null, "Tutor já existe.");
                            }
                        }
                        if(opcao == 3){
                            continuar =false;
                        }}
                    }
                }
            }
        }catch (NumberFormatException|  IOException e){
            JOptionPane.showMessageDialog(null,"Não foi possível encontrar Animal.","ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }



    public boolean existeTutorComCpf(String cpf) {
        for (Tutor a: listaTutor){
            if(a.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }
    public void cadastrarTutor(String nome, String genero, int idade, String cpf, String telefone,String rua, String bairro,String cidade, String cep,String estado) throws TutorJaExisteException, IOException {
        if(existeTutorComCpf(cpf)){
            throw new TutorJaExisteException("Esse tutor já está cadastrado.");
        }else{
            Tutor novoTutor= new Tutor(nome,genero,idade,cpf,telefone,rua,bairro,cidade,cep,estado);
            listaTutor.add(novoTutor);
            GravaListaTutor(listaTutor,"tutores.txt");
        }
    }
    public String pesquisarAnimalAdotado(String id) throws AnimalNaoExisteException {
        List<Adotados> animalAdotados = new ArrayList<>();
        for(Adotados ad: listaAdotados){
            if(ad.getIdAnimal().equals(id)){
                animalAdotados.add(ad);
            }
        }
        return animalAdotados.toString();
    }

    public String pesquisarTutor(String cpf) throws TutorNaoExisteException{
        for(Tutor t: listaTutor){
            if(t.getCpf().equals(cpf)){
                return t.toString();
            }
        } return null;
    }
    //GRAVA DADOS//
    public void CarregaListaAnimais() throws IOException {
        List<String> listaLeitura = gravador.recuperaTextoArquivo(ARQUIVO_ANIMAIS);
        for (String l : listaLeitura) {
            String[] animalArray = l.split("###");
            Animal animal = new Animal(animalArray[0], animalArray[1], animalArray[2], animalArray[3], animalArray[4], animalArray[5], Integer.parseInt(animalArray[6]), animalArray[7], animalArray[8]);
            listaAnimal.add(animal);
        }
    }

    public void GravaListaAnimais(List<Animal> listaAnimal, String file) throws IOException {
        List<String> gravaLista = new ArrayList<>();
        for (Animal a : this.listaAnimal) {
            gravaLista.add(a.getId() + "###" + a.getNome() + "###" + a.getEspecie() + "###" + a.getRaca() + "###" + a.getTamanho() + "###" + a.getGenero() + "###" + a.getIdade() + "###" + a.getDescricao() + "###" + a.getEhAdotado());
        }
        gravador.gravaTextoArquivo(gravaLista, ARQUIVO_ANIMAIS);
    }
    public void CarregaListaTutor() throws IOException  {
        List<String> listaLeitura = gravador.recuperaTextoArquivo(ARQUIVO_TUTORES);
        for (String l : listaLeitura) {
            String[] tutorArray = l.split("###");
            Tutor tutor = new Tutor(tutorArray[0],tutorArray[1],Integer.parseInt(tutorArray[2]) ,tutorArray[3] , tutorArray[4], tutorArray[5], tutorArray[6], tutorArray[7], tutorArray[8], tutorArray[9]);
            listaTutor.add(tutor);
        }

    }

    public void GravaListaTutor(List<Tutor> listaTutor, String file) throws IOException {
        List<String> gravaLista = new ArrayList<>();
        for (Tutor a : this.listaTutor) {
            gravaLista.add(a.getNome() +"###"+ a.getGenero()+ "###"+a.getIdade() + "###" + a.getCpf() + "###" + a.getTelefone()+"###"+a.getRua()+"###"+a.getBairro()+"###"+a.getCidade()+"###"+a.getCep()+"###"+a.getEstado());
        }
        gravador.gravaTextoArquivo(gravaLista, ARQUIVO_TUTORES);
    }
    public void CarregaListaAdotados() throws IOException  {
        List<String> listaLeitura = gravador.recuperaTextoArquivo(ARQUIVO_ADOTADOS);
        for (String l : listaLeitura) {
            String[] AdotadosArray = l.split("###");
            Adotados adotados = new Adotados(AdotadosArray[0],AdotadosArray[1],AdotadosArray[2] ,AdotadosArray[3] , AdotadosArray[4]);
            listaAdotados.add(adotados);
        }

    }

    public void GravaListaAdotados(List<Adotados> listaAdotados, String file) throws IOException {
        List<String> gravaLista = new ArrayList<>();
        for (Adotados a : this.listaAdotados) {
            gravaLista.add(a.getNomeTutor() +"###"+ a.getCpfTutor()+ "###"+a.getNomeAnimal() + "###" + a.getIdAnimal() + "###" + a.getEspecieAnimal());
        }
        gravador.gravaTextoArquivo(gravaLista, ARQUIVO_ADOTADOS);
    }
}
