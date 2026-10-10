import java.util.List;

public class Menu {
    public void mostrarMenu(){
        System.out.println("===== BUSCADOR DE CEP =====");
        System.out.println("1 - Consultar CEP");
        System.out.println("2 - Ver histórico");
        System.out.println("3 - Limpar histórico");
        System.out.println("4 - Sair");
        System.out.println("============================");
    }

    public void mostrarHistorico(List<CEP> listaHistorico) {

        if (listaHistorico.isEmpty()){
            System.out.println("=====================");
            System.out.println("Sem histórico ainda ");
            System.out.println("=====================");
            System.out.println();
        }
        System.out.println("============= HISTÓRICO =============");

        for (CEP endereco : listaHistorico) {
            System.out.println();
            System.out.println("Cep: " + endereco.cep());
            System.out.println("Logradouro: " + endereco.logradouro());
            System.out.println("Complemento: " + endereco.complemento());
            System.out.println("Bairro: " + endereco.bairro());
            System.out.println("Localidade: " + endereco.localidade());
            System.out.println("Estado: " + endereco.estado());
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println();

        }
    }

}
