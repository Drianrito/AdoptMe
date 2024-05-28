package adocao.adote.me.gravacao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravaDados {
    public void gravaTextoArquivo(List<String> texto, String nomeArquivo) throws IOException{
        try (BufferedWriter gravador = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (String s : texto) {
                gravador.write(s + "\n");
            }
        }
    }
    public List<String> recuperaTextoArquivo(String nomeArquivo) throws IOException {
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = leitor.readLine();

            while (texto != null) {
                if (!texto.trim().isEmpty()) {
                    textoLido.add(texto);
                }
                texto = leitor.readLine();
            }
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
        return textoLido;
    }

}
