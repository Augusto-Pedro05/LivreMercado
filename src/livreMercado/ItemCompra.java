/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livreMercado;

/**
 *
 * @author pedro
 */
public class ItemCompra {
    
    private Produto produto;
    private int quantidade;
    private Vendedor vendedor;
    
    
    /**
     Construtor que cria um novo item de compra, associando um produto, um vendedor e a quantidade desejada.
     <p>
     Este método inicializa as propriedades do item de compra com os parâmetros fornecidos.
     Ele verifica se o produto e o vendedor são válidos (não nulos) e se a quantidade é um valor positivo.
     Caso contrário, lança uma exceção {@link IllegalArgumentException}.
     A quantidade deve ser um número inteiro maior que zero para que o item de compra seja considerado válido.

     @param produto    O produto a ser comprado, que deve ser um objeto válido.
     @param vendedor   O vendedor do produto, que deve ser um objeto válido.
     @param quantidade A quantidade do produto a ser comprada, que deve ser maior que zero.

     @throws IllegalArgumentException Se o produto ou o vendedor forem nulos, ou se a quantidade for menor ou igual a zero.
     */
    public ItemCompra(Produto produto, Vendedor vendedor, int quantidade)throws IllegalArgumentException{
        if (produto != null){
            this.produto = produto;
        }else{
            throw new IllegalArgumentException("Nenhum produto foi especificado");
        }
        if (vendedor != null){
            this.vendedor = vendedor;
        }else{
            throw new IllegalArgumentException("Nenhum vendedor foi especificado");
        }
        if (quantidade > 0){
            this.quantidade = quantidade;
        }else{
            throw new IllegalArgumentException("A quantidade deve ser pelo menos um valor maior que 0");
        } 
    }
    
    public Produto getProduto(){
        return produto;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public Vendedor getVendedor(){
        return vendedor;
    }

    public void setQuantidade(int i){
        quantidade = i;
    }
}
