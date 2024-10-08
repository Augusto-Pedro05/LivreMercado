/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds1;

/**
 *
 * @author pedro
 */
public class Produto {
    
    private String nome;
    private String modelo;
    private String marca;
    private Double preco;
    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public Double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto(String nome, String modelo, String marca, Double preco, Categoria categoria) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.categoria = categoria;
    }
    
}
