import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    static void main() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        CriarArquivosJSON arquivosJSON = new CriarArquivosJSON();
        List<CEP> listaHistorico = new ArrayList<>();
        HistoricoCEP historicoCEP = new HistoricoCEP(listaHistorico);
        ConsumirGson conversor = new ConsumirGson();
        ValidadorCEP validadorCEP = new ValidadorCEP();
        Menu menu = new Menu();

        File arquivo = new File("historico.json");
        if (arquivo.exists()) {
            String json = arquivosJSON.lerArquivo();
            List<CEP> lista = conversor.converterJsonParaLista(json);
            historicoCEP.adicionarHistorico(lista);
        }

        int condicao = 0;
        while (condicao != 4) {

            menu.mostrarMenu();

            try {
            condicao = scanner.nextInt();

                if (condicao != 1 && condicao != 2 && condicao != 3 && condicao != 4) {
                    System.out.println("! Opção inválida !");
                    System.out.println("Tente novamente : ");
                    System.out.println();
                }
                }

            catch (InputMismatchException e) {
                System.out.println("! Opção inválida !");
                System.out.println("Tente novamente : ");
                System.out.println();
                scanner.next();
                }


            if (condicao == 1) {
                int voltarMenu = 0;
                while (voltarMenu == 0){

                System.out.println("=============================================");
                System.out.println("Diga o seu CEP para o envio da encomenda : ");
                System.out.println();
                System.out.println("Caso queira voltar ao menu pressione 0 ");
                System.out.println("=============================================");

                    ConsumirApi api = new ConsumirApi();

                    String cep = scanner.next();
                    if (cep.equals("0")) {
                        break;
                    }else {

                     try {

                         validadorCEP.validarCep(cep);

                    } catch (CepInvalidoException e){
                        System.out.println("=============================================");
                        System.out.println("CEP inválido");
                        System.out.println("Verifique se o CEP possui 8 dígitos numéricos");
                        System.out.println("=============================================");
                        System.out.println();
                        break;
                    }

                        try {
                            HttpResponse<String> resposta = api.consultar(cep);

                            if (resposta.body().contains("erro")){
                                System.out.println("===================");
                                System.out.println("CEP não encontrado");
                                System.out.println("===================");
                                break;
                            }

                            CEP endereco = conversor.converterJsonParaObejto(resposta.body());

                            historicoCEP.verificarCEpRepetido(endereco);


                        } catch (IOException e) {
                            System.out.println("! Ocorreu um erro na comunicação com a API !");
                        } catch (InterruptedException e) {
                            System.out.println("! A operação foi interrompida !");
                        }

                        break;
                    }


                }}


            if (condicao == 2){

                menu.mostrarHistorico(historicoCEP.getListaHistorico());

            }

            if (condicao == 3){
                int voltarMenu =2;
                while(voltarMenu == 2) {

                System.out.println("Tem certeza que deseja apagar o histórico?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int condicaoApagarHist = scanner.nextInt();

                if (condicaoApagarHist != 1 && condicaoApagarHist != 2){
                    System.out.println("! Opção inválida !");
                    System.out.println("Tente novamente : ");
                    System.out.println();
                }
                if (condicaoApagarHist == 1){
                    historicoCEP.limparHist();
                    arquivosJSON.limparArquivo();
                    break;
                } if (condicaoApagarHist == 2){
                    break;
                    }

                }
            }

            if (condicao==4){


                String listaJsonConvertido = conversor.converterListaParaJson(historicoCEP.getListaHistorico());

                arquivosJSON.transformarAquivo(listaJsonConvertido);

            }
        }

        System.out.println("Obrigado volte sempre :) ");

    }
}