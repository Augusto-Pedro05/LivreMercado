/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livreMercado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Carrinho {
    
    private List<ItemCompra> itens;
    
    public Carrinho(){
        itens = new ArrayList<>();
    }
    public List<ItemCompra> getItens(){
        return itens;
    }
     /**
     Adiciona um item à lista de compras, verificando a disponibilidade em estoque do vendedor.
     <p>
     Este método realiza a verificação da quantidade disponível do produto no estoque do vendedor antes de
     adicioná-lo à compra. Se o produto já estiver presente na lista de itens, a quantidade é atualizada,
     desde que a quantidade total não exceda a disponível em estoque. Se o produto não estiver na lista,
     ele é adicionado somente se houver quantidade suficiente disponível.
     <p>
     <p>
     O método pode lançar uma exceção {@link IllegalArgumentException} nas seguintes situações:
     <ul>
     <li>Se a quantidade solicitada exceder a quantidade disponível em estoque.</li>
     <li>Se a quantidade total (já existente no carrinho mais a nova) ultrapassar a quantidade em estoque.</li>
     </ul>

     @param produto    O produto que se deseja adicionar à compra.
     @param vendedor   O vendedor do qual o produto está sendo adquirido.
     @param quantidade A quantidade do produto a ser adicionada à compra.
     */
    public void adicioneItem(Produto produto, Vendedor vendedor, int quantidade) throws IllegalArgumentException{
        int QuantidadeDisponivel = vendedor.getEstoque().quantidadeEmEstoque(produto); // pega a quantidade que o vendedor tem do item
        if(QuantidadeDisponivel >= quantidade){ // vê se o vendedor tem a quantidade requisitada
            for(ItemCompra item : itens ){
                if(item.getProduto().equals(produto)){// vê se tem o produto no carrinho(list<itemcompra> itens) <- esse é o carrinho
                    if(quantidade + item.getQuantidade() <= QuantidadeDisponivel){ // se a quantidade a se adicionar + a quantide que já tem está disponivel
                        item.setQuantidade(quantidade + item.getQuantidade());// seta essa nova quantidade
                        return; // sai do método
                    }else{
                        throw new IllegalArgumentException();
                    }
                }
            }  
        }
    }
    /**
     Remove um item de compra do carrinho com base no produto fornecido.
     <p>
     Este método verifica cada item de compra no carrinho e, se encontrar
     um item que corresponda ao produto passado como parâmetro, remove-o
     da lista de itens. O método encerra a operação após a remoção do primeiro
     item correspondente.

     @param produto O produto a ser removido do carrinho de compras.
     */
    public void removaItem(Produto produto){
        for (ItemCompra item: itens){           
            if (item.getProduto().equals(produto)){
            itens.remove(item);
            System.out.println(itens);
            } 
        }
    }
}
