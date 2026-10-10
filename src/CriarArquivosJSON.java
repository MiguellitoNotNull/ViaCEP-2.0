import java.io.*;


public class CriarArquivosJSON {

    public CriarArquivosJSON() throws FileNotFoundException {
    }

    public void transformarAquivo (String json) throws IOException {

        FileWriter arquivoCEP = new FileWriter("historico.json");
        arquivoCEP.write(json);
        arquivoCEP.close();

    }



    public String lerArquivo() throws IOException {

        FileReader arquivo = new FileReader("historico.json");
        BufferedReader leitor = new BufferedReader(arquivo);
        StringBuilder guardarLeitura = new StringBuilder();

        String linhaLida = leitor.readLine();

        while (linhaLida != null) {
             guardarLeitura.append(linhaLida);
            linhaLida = leitor.readLine();
        }

        leitor.close();
        return guardarLeitura.toString();

    }

    public void limparArquivo() throws IOException {
        FileWriter limparHistorico = new FileWriter("historico.json");
        limparHistorico.write("[]");
        limparHistorico.close();
    }

}
