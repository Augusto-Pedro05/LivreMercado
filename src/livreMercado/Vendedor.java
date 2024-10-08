/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livreMercado;

/**
 *
 * @author pedro
 */
public class Vendedor extends Pessoa{
    
    private Estoque estoque;

    public Vendedor(String nome) {
        super(nome);
        this.estoque = new Estoque();
    }
    
    public void adicioneProdutoAoEstoque(Produto produto, int quantidade){
        estoque.adicioneItem(produto, quantidade);
    }

    public Estoque getEstoque() {
        return estoque;
    }      
}
