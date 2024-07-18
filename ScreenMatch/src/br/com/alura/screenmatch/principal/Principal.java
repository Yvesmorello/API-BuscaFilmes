package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefão", 1970);

        System.out.println("\n*************************************\n");

        filme1.setDuracaoEmMinutos(180);

        filme1.exibeFichaTecnica();
        System.out.println("Duração do filme: " + filme1.getDuracaoEmMinutos());

        filme1.avalia(8);
        filme1.avalia(5);
        filme1.avalia(10);

        System.out.println("Total de avaliações: " + filme1.getTotalAvaliacao());
        System.out.println(String.format("Media das avaliações: %.2f", filme1.getMediaAvaliacoes()));

        System.out.println("\n*************************************\n");

        Filme filme2 = new Filme("Avatar", 2023);
        filme2.setDuracaoEmMinutos(200);
        filme2.exibeFichaTecnica();

        System.out.println("Duração do filme: " + filme2.getDuracaoEmMinutos());

        filme2.avalia(5);
        filme2.avalia(6);
        filme2.avalia(10);

        System.out.println("Total de avaliações: " + filme2.getTotalAvaliacao());
        System.out.println(String.format("Media das avaliações: %.2f", filme2.getMediaAvaliacoes()));

        System.out.println("\n*************************************\n");

        var filme3 = new Filme("Vingadores", 2010);
        filme3.setDuracaoEmMinutos(250);
        filme3.exibeFichaTecnica();
        filme3.avalia(10);

        System.out.println("\n*************************************\n");


        Serie serie = new Serie("Lost", 2000);

        serie.exibeFichaTecnica();
        serie.setTemporadas(10);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(50);
        System.out.println("Duração da serie: " + serie.getDuracaoEmMinutos());

        serie.avalia(8);
        serie.avalia(5);
        serie.avalia(10);

        System.out.println("Total de avaliações: " + serie.getTotalAvaliacao());
        System.out.println(String.format("Media das avaliações: %.2f", serie.getMediaAvaliacoes()));

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();

        calculadora.inclui(filme1);
        calculadora.inclui(filme2);
        calculadora.inclui(serie);

        System.out.println("\n********************************************************\n");

        System.out.println("Duração total para ver os filmes e series: " + calculadora.getTempoTotal() + " minutos!");

        System.out.println("\n********************************************************\n");

        FiltroRecomendacao filtro = new FiltroRecomendacao();

        filtro.filtra(filme1);


        System.out.println("\n********************************************************\n");

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);


        System.out.println("\n********************************************************\n");

        ArrayList<Filme> listaFilmes = new ArrayList<>();

        listaFilmes.add(filme1);
        listaFilmes.add(filme2);
        listaFilmes.add(filme3);

        System.out.println("Tamanho da lista: " + listaFilmes.size());
        System.out.println("Primeiro filme da lista: " + listaFilmes.get(0).getNome());
        System.out.println(listaFilmes);

        }
}
