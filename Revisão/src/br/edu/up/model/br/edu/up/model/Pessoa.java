package br.edu.up.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    protected String id;
    protected String nome;
    protected List<String[]> enderecos;

    public Pessoa(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.enderecos = new ArrayList<>();
    }

    public void addEndereco(String rua, String cidade){
        this.enderecos.add(new String[]{rua, cidade});
    }

    public List<String> toCSV() {
        List<String> linhasCSV = new ArrayList<>();

        if (enderecos.isEmpty()) {
            linhasCSV.add(id + ";" + nome + ";;;");
        } else {
            for (String[] endereco : enderecos) {
                linhasCSV.add(id + ";" + nome + ";" + endereco[0] + ";" + endereco[1]);
            }
        }
        return linhasCSV;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<String[]> getEnderecos(){
        return enderecos;
    }
    
}
