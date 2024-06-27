package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeEnderecos {
    private String nomeDoArquivo = "C:\\Users\\Brian\\Desktop\\Java-estudo\\Revisão\\Enderecos.csv";

    public List<String[]> getEndereco(){
        List<String[]> listaDeEnderecos = new ArrayList<>();

        try {
            // Ler um arquivo de texto
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);

            // Ignorar cabeçalho
            leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                listaDeEnderecos.add(dados);
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }
        return listaDeEnderecos;
    }
}
