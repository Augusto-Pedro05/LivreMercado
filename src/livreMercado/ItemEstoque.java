/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livreMercado;

/**
 *
 * @author pedro
 */
public class ItemEstoque {
    
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public void adicioneQuantidade(int quantidade){
        this.quantidade += quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public void removaQuantidade(int quantidade)throws IllegalArgumentException{
        if (this.quantidade <= 0){
            throw new IllegalArgumentException("A quantidade de itens é menor que a quantidade de itens que se quer remover!");
        }else{
            this.quantidade -= quantidade;
        }
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    
}
