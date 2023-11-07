package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {

    public void salvaEndereco(List<Endereco> listaDeEndereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritaJson = new FileWriter("Enderecos.json");


        for (Endereco enderecos : listaDeEndereco){
            escritaJson.write(gson.toJson(enderecos));

        }

        escritaJson.close();


    }

}
