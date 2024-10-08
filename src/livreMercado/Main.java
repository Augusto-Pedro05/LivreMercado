/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package livreMercado;

/**
 *
 * @author pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mercado Livre = new Mercado();
        Vendedor Josias = new Vendedor("Josias");
        Comprador Vampeta = new Comprador("Vampeta");
        Categoria Verdinha = new Categoria("Verdinha");
        Categoria Boa = new Categoria("Boa");
        Produto Pureza = new Produto("Pureza de Morango","de Morando","Antartica",3.50,Verdinha);
        Produto Pureza2 = new Produto("Pureza de Maracuja","de Marajuca","Antartica",3.50,Verdinha);
        Produto Pureza3 = new Produto("Pureza de Uva","de Uva","Antartica",3.50,Verdinha);
       
        Livre.adicioneComprador(Vampeta);
        Livre.adicioneVendedor(Josias);
        Livre.adicioneCategoria(Verdinha); // vamos adicionar a categoria verdinha
        Verdinha.adicioneProduto(Pureza); // vamos adicionar um produto a nossa categoria verdinha
        Verdinha.adicioneSubcategoria(Boa); // vamos criar uma subcategoria chamada boa
        Boa.adicioneProduto(Pureza2);// vamos adicionar um produto a essa subcategoria
        //System.out.println(Boa.getProdutos());//Produto@1e80bfe8 da subcategoria boa
        for(Produto produto : Boa.getProdutos()){
            System.out.println(produto.getNome());
        }
        //System.out.println(Verdinha.getProdutos()); // vamos ver quantos produtos temos na categoria verdinha
        for(Produto produto : Verdinha.getProdutos()){
            System.out.println(produto.getNome());
        }
        Verdinha.removaSubcategoria(Boa, true); // removemos a subcategoria boa, e isso deveria colocar os itens de "boa" para "verdinha"
        //System.out.println(Verdinha.getProdutos()); // pra ver se foi adicionada a categoria "principal"
        for(Produto produto : Verdinha.getProdutos()){
            System.out.println(produto.getNome());
        }
    }
    
}
