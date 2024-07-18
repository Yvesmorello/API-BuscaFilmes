package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBuscaAPI {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String nomeFIlme = "";
        List<Titulo> listaTitulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

while(!nomeFIlme.equalsIgnoreCase("sair")) {

    System.out.println("Digite o nome do filme: ");
    var nomeFilme = scanner.nextLine();

    if (nomeFilme.equalsIgnoreCase("sair")) {
        break;
    }

    String endereco = "https://www.omdbapi.com/?t=" + nomeFilme.replace(" ", "+") + "&apikey=9ce1e8d2";

    try {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);


        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);

        Titulo meuTitulo = new Titulo(meuTituloOmdb);
        System.out.println("Titulo convertido: ");
        System.out.println(meuTitulo);

        listaTitulos.add(meuTitulo);

    } catch (NumberFormatException e) {
        System.out.println("Ocorreu um erro: ");
        System.out.println(e.getMessage());
    } catch (IllegalArgumentException e) {
        System.out.println("Algum erro de argumento na busca, verifique o endereço!");
    } catch (ErroDeConversaoDeAnoException e) {
        System.out.println(e.getMensagem());
    }
}
        System.out.println(listaTitulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(listaTitulos));
        escrita.close();

        System.out.println("Programa finalizado com sucesso!");


    }
}
