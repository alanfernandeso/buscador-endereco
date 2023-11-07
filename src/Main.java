import modelos.ConsultaCep;
import modelos.Endereco;
import modelos.GeradorDeArquivo;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
        int opcaoMenu = 0;

        String menu = """
                ======== MENU ==========
                [1] Consultar endereço.
                [2] Exibir endereços salvos.
                [3] Sair
                """;

        while (opcaoMenu != 3) {

            System.out.println(menu);
            opcaoMenu = scan.nextInt();

            while (opcaoMenu == 1){

                System.out.println("Digite o CEP (apenas números): ");
                String cep = scan.next();

                try {
                    ConsultaCep consultaCep = new ConsultaCep();
                    Endereco novoEndereco = consultaCep.buscaEndereco(cep);
                    enderecos.add(novoEndereco);

                    for(Endereco listaDeEnderecos : enderecos) {
                        System.out.println(listaDeEnderecos.toString());
                    }

                    System.out.println("[1] CONTINUAR - [2] SALVAR - [3] MENU PRINCIPAL");
                    int opcaoSubMenu = scan.nextInt();

                    if(opcaoSubMenu == 2) {
                        GeradorDeArquivo arquivo = new GeradorDeArquivo();
                        arquivo.salvaEndereco(enderecos);
                        System.out.println("Endereços salvos!");
                        break;
                    } else if (opcaoSubMenu == 3) {
                        break;
                    }

                }catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando a aplicação.");
                }

            }

            if (opcaoMenu == 2) {
                for (Endereco enderecosSalvos : enderecos){
                    System.out.println(enderecosSalvos);
                }
            }
        }


    }
}