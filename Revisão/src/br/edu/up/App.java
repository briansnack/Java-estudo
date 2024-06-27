package br.edu.up;

import java.util.List;

import br.edu.up.daos.*;
import br.edu.up.model.*;

public class App {
    public static void main(String[] args) throws Exception {
        GerenciadorDeEnderecos gEnderecos = new GerenciadorDeEnderecos();
        GerenciadorDePessoas gPessoas = new GerenciadorDePessoas();

        List<Pessoa> listaDePessoas;
        listaDePessoas = gPessoas.getPessoa();
    
        List<String[]> listaDeEnderecos = gEnderecos.getEndereco();

        for (Pessoa pessoa : listaDePessoas){
            for (String[] endereco : listaDeEnderecos){
                if (pessoa.getId().equals(endereco[2].trim())) {
                    pessoa.addEndereco(endereco[0], endereco[1]);
                }
            }
        }

        // Exibir pessoas com endereço
        System.out.println("Lista de pessoas: ");
        if (listaDePessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas");
        } else {
            for (Pessoa p : listaDePessoas){
                System.out.println(p.toCSV());
            }
        }

        // Gravar o arquivo de pessoas com endereços
        if (gPessoas.gravar(listaDePessoas) == true) {
            System.out.println("Arquivo gravado com sucesso");
        } else {
            System.out.println("Falha ao gravar arquivo");
        }
    }
}