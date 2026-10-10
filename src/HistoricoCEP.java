import java.util.ArrayList;
import java.util.List;

public class HistoricoCEP {

    private List<CEP> listaHistorico;

    public HistoricoCEP(List<CEP> listaHistorico) {
        this.listaHistorico = listaHistorico;
    }

    public void verificarCEpRepetido(CEP endereco){
        boolean cepRepetido = false;
        for (CEP enderecoHistorico : listaHistorico){
            int cepIgual = enderecoHistorico.cep().compareTo(endereco.cep());
            if (cepIgual == 0) {
                cepRepetido = true;
                System.out.println("===========================");
                System.out.println("CEP repetido ");
                System.out.println("Não adicionado ao histórico");
                System.out.println("===========================");
            }
        }
        if (!cepRepetido){
            listaHistorico.add(endereco);
        }

    }

    public void limparHist(){

        listaHistorico.clear();
    }

    public void adicionarHistorico(List<CEP> lista){
            listaHistorico.addAll(lista);
    }


    public List<CEP> getListaHistorico() {
        return listaHistorico;
    }

}
