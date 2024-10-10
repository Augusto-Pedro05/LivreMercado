/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livreMercado;

/**
 *
 * @author pedro
 */
public class Comprador extends Pessoa{
    
    private Carrinho carrinho;

    public Comprador(String nome){
        super(nome);
        carrinho = new Carrinho();
    }
    
    public void adicioneAoCarrinho(Produto produto, Vendedor vendedor, int quantidade){
        carrinho.adicioneItem(produto, vendedor, quantidade);
        System.out.println("Produto adicionado ao carrinho:" + carrinho);
    }
    /**
     Efetua a compra dos itens presentes no carrinho do comprador.
     <p>
     Este método percorre todos os itens no carrinho, obtendo para cada um o produto, o vendedor e a quantidade desejada.
     Em seguida, tenta reduzir a quantidade do produto no estoque do vendedor correspondente utilizando o método
     {@link Estoque#reduzaQuantidade(Produto, int)}. Se a redução for bem-sucedida, a quantidade do item no carrinho é zerada
     para indicar que a compra foi concluída. Caso ocorra uma exceção {@link IllegalArgumentException} durante essa operação,
     ela é capturada, mas não é tratada, permitindo que o processo continue com os demais itens. Nesse caso (compra do item
     nao realizada, a quantidade
     que deveria ser comprada continua no item do carrinho.
     <p>
     Após tentar efetuar a compra de todos os itens, o método remove os itens cujo estoque foi zerado do carrinho (ou seja,
     a compra foi realizada), garantindo que o carrinho esteja pronto para novas compras e que contenha apenas os itens
     que nao puderam ser comprados.
     <p>
     Este método não retorna nenhum valor e modifica o estado do carrinho e do estoque dos vendedores.
     */
    public void efetuarCompra(){
        for(ItemCompra item : carrinho.getItens()){
            boolean erro = false;
            Produto produto = item.getProduto();
            Vendedor vendedor = item.getVendedor();
            int quantidade = item.getQuantidade();
            try{
                vendedor.getEstoque().reduzaQuantidade(produto, quantidade);
            }catch(IllegalArgumentException e){erro = true;}
            if (!erro){
                item.setQuantidade(0);
            }
        }
        for(ItemCompra item : carrinho.getItens()){
            if (item.getQuantidade() <= 0){
                carrinho.getItens().remove(item);
            }
        }
    }
    
    public Carrinho getCarrinho() {
        return carrinho;
    }
}
