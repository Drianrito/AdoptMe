package adocao.adote.me;
import adocao.adote.me.Exception.*;
import javax.swing.*;
import java.io.IOException;
public class AdoteMePrograma {

    public static void main(String[] args) {

        SistemaAdocao sistema = new SistemaAdocao();
        try {
            sistema.CarregaListaAnimais();
            sistema.CarregaListaTutor();
            sistema.CarregaListaAdotados();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Arquivo nao encontrado","ERRO",JOptionPane.ERROR_MESSAGE);
        }
        boolean continuar = true;
        while(continuar){

                int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                                         Bem Vindo a AdoteME                    \s
                                         1.Cadastrar Animal
                                         2.Animais para Adoção
                                         3.Pesquisar Animal
                                         4.Pesquisar Animal Adotado
                                         5.Pesquisar Tutor
                                         6.Adotar Animal
                                         7.Animais adotados
                                         8.Sair do Programa"""


                ));
                switch (opcao) {
                    case 1:
                       String id= JOptionPane.showInputDialog("Digite o ID:");
                       String nome= JOptionPane.showInputDialog("Digite o nome:");
                       String especie= JOptionPane.showInputDialog("Digite a espécie:");
                       String raca =JOptionPane.showInputDialog("Digite a raça:");
                       String tamanho= JOptionPane.showInputDialog("Digite o tamanho:");
                       String genero=JOptionPane.showInputDialog("Digite o gênero:");
                       int idade= Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:"));
                       String descricao= JOptionPane.showInputDialog("Digite a descrição:");
                        try {
                           sistema.cadastrarAnimal(id, nome, especie, raca,tamanho, genero,idade , descricao);
                           try {
                               sistema.GravaListaAnimais(sistema.listaAnimal,"animais.txt");
                           } catch (IOException e) {

                               JOptionPane.showMessageDialog(null,"Arquivo nao encontrado.","ERRO",JOptionPane.ERROR_MESSAGE);
                           }
                           JOptionPane.showMessageDialog(null,"Novo animal cadastrado!");
                       } catch (NumberFormatException |AnimalJaCadastradoException  e) {
                           JOptionPane.showMessageDialog(null, "Falha no cadastro, animal ja cadastrado.","ERRO",JOptionPane.ERROR_MESSAGE);
                       }
                    case 2:
                        JOptionPane.showMessageDialog(null,sistema.QuantAnimaisParaAdocao());
                        break;
                    case 3:
                        String pesquisaID = JOptionPane.showInputDialog("Qual o ID do animal?");
                        try {
                            JOptionPane.showMessageDialog(null,sistema.pesquisarAnimalPeloID(pesquisaID));
                        } catch (AnimalNaoExisteException e) {
                            JOptionPane.showMessageDialog(null,"Animal nao existe.","ERRO",JOptionPane.ERROR_MESSAGE);
                        }
                        break;

                    case 4:
                        String pesquisarAnimalAdotado = JOptionPane.showInputDialog("Digite o ID do Animal Adotado:");
                        try {
                            JOptionPane.showMessageDialog(null,sistema.pesquisarAnimalAdotado(pesquisarAnimalAdotado));
                        } catch (AnimalNaoExisteException e) {
                            JOptionPane.showMessageDialog(null,"Tutor não existe.");
                        }
                        break;

                    case 5:
                        String pesquisarTutor = JOptionPane.showInputDialog("Digite o CPF do Tutor:");
                        try {
                            JOptionPane.showMessageDialog(null,sistema.pesquisarTutor(pesquisarTutor));
                        } catch (TutorNaoExisteException e) {
                            JOptionPane.showMessageDialog(null,"Tutor não existe.");
                        }
                        break;

                    case 6:
                        String idDigitado = JOptionPane.showInputDialog("Digite o ID do animal a ser adotado:");
                        try {
                            sistema.AdotarAnimal(idDigitado);
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,"Dado Fornecido é incorreto.","ERRO",JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 7:

                        JOptionPane.showMessageDialog(null,sistema.QuantAnimaisAdotados());
                        break;

                    case 8:
                        String[] opcoes = {"Sim", "Não"};
                        int resposta = JOptionPane.showOptionDialog(null,
                                "Deseja realmente sair do progama?",
                                "Sair",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcoes,
                                opcoes[0]);
                        if( resposta == JOptionPane.YES_OPTION){
                            continuar=false;
                            break;
                        }
                }
            }
        }
    }
