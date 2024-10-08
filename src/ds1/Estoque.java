/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Estoque {
    
    private List<ItemEstoque> itens;

    public Estoque() {
        itens = new ArrayList<>();
    }
    /**
     Adiciona uma quantidade de um produto ao estoque.
     <p>
     O método verifica se o produto já existe no estoque. Se existir,
     a quantidade do item correspondente é aumentada. Caso contrário,
     um novo item de estoque é criado e adicionado à lista de itens do
     estoque.

     @param produto    O produto a ser adicionado ou atualizado no estoque.
     @param quantidade A quantidade a ser adicionada ao estoque do produto.
     */
    public void adicioneItem(Produto produto, int quantidade){
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                item.adicioneQuantidade(quantidade);
                return;
            }
        }
        itens.add(new ItemEstoque(produto, quantidade));
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }
    /**
     Retorna a quantidade disponível em estoque de um produto específico.
     <p>
     Este método verifica cada item no estoque e, se encontrar um item que
     corresponda ao produto passado como parâmetro, retorna a quantidade
     desse produto. Se o produto não estiver presente no estoque, retorna 0.

     @param produto O produto cuja quantidade em estoque deve ser verificada.

     @return A quantidade do produto em estoque, ou 0 se o produto não estiver disponível.
     */
    public int quantidadeEmEstoque(Produto produto){
        for(ItemEstoque item : itens){
            if(produto == item.getProduto()){
                return item.getQuantidade();
            }
        }
        return 0;
    }
    /**
     Reduz a quantidade disponível de um produto no estoque.
     <p>
     Este método procura pelo produto especificado na lista de itens do estoque.
     Se o produto for encontrado, sua quantidade será reduzida pela quantidade fornecida.
     Se a quantidade a ser reduzida for maior do que a quantidade disponível,
     uma exceção {@link IllegalArgumentException} será lançada para indicar
     que não há quantidade suficiente em estoque.
     </p>

     @param produto    O produto cuja quantidade deve ser reduzida no estoque.
     @param quantidade A quantidade a ser reduzida. Deve ser um número positivo.

     @throws IllegalArgumentException Se a quantidade a ser reduzida for maior
                                      do que a quantidade disponível para o produto.
     */
    public void reduzaQuantidade(Produto produto, int quantidade)throws IllegalArgumentException{
        for(ItemEstoque item : itens){
            if(item.getProduto() == produto){
                if (quantidade <= item.getQuantidade()){
                    item.removaQuantidade(quantidade);
                }else{
                    throw new IllegalArgumentException("A quantidade a ser removida é maior que a quantidade disponível");
                }
            }
        }
    } 
}
