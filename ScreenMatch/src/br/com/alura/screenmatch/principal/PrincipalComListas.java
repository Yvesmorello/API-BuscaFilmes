package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme filme1 = new Filme("O poderoso chefão", 1970);
        filme1.avalia(9);

        Filme filme2 = new Filme("Avatar", 2023);
        filme2.avalia(6);

        var filme3 = new Filme("Vingadores", 2010);
        filme3.avalia(10);

        Serie serie = new Serie("Lost", 2000);

        List<Titulo> lista = new LinkedList<>();

        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);
        lista.add(serie);

        for (Titulo item: lista){
            System.out.println(item.getNome());
            if(item instanceof Filme filme){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

//        lista.forEach(item -> System.out.println(item));  OUTRA OPÇÃO DO LAÇO FOREACH
//        lista.forEach(System.out::println);

        ArrayList<String> buscaPorArtista = new ArrayList<>();

        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Bruna");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        Collections.sort(lista);

        System.out.println("\nLista de titulos ordenados por nome: " + lista);
        System.out.println("Atores ordenados: " + buscaPorArtista);

        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));

        System.out.println("Lista de titulos ordenados por ano: " + lista);
    }
}
