package br.edu.up.daos;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.model.Pessoa;

public class GerenciadorDePessoas {
    private String header = "ID;Nome;Rua;Cidade;";
    private String nomeDoArquivoLeitura = "C:\\Users\\Brian\\Desktop\\Java-estudo\\Revisão\\Pessoas.csv";
    private String nomeDoArquivoGravacao = "C:\\Users\\Brian\\Desktop\\Java-estudo\\Revisão\\PessoasComEndereco.csv";

    public List<Pessoa> getPessoa(){
        List<Pessoa> listaDePessoas = new ArrayList<>();

        try {
            // Ler um arquivo de texto
            File arquivoLeitura = new File(nomeDoArquivoLeitura);
            Scanner leitor = new Scanner(arquivoLeitura);

            // Ignorar cabeçalho
            leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                String id = dados[0];
                String nome = dados[1];

                Pessoa pessoa = new Pessoa(id, nome);
                listaDePessoas.add(pessoa);
            }

            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }
        return listaDePessoas;
    }

    public boolean gravar(List<Pessoa> pessoas){
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivoGravacao);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);

            for(Pessoa pessoa : pessoas){
                gravador.println(pessoa.toCSV());
            }
            gravador.close();

            return true;
        } catch (IOException e) {
            System.err.println("Não foi possível gravar o arquivo!");
        }
        return false;
    }
}
