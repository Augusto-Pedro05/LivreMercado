/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livreMercado;

import java.util.ArrayList;
import java.util.List;

//...
/**
 *
 * @author pedro
 */
public class Categoria {
    
    private String nome;
    private List<Produto> produtos;
    private List<Categoria> subcategorias;

    public Categoria(String nome) {
        this.nome = nome;
        produtos = new ArrayList<>();
        subcategorias = new ArrayList<>();
    }
     /**
     Adiciona um produto à categoria, garantindo que sua categoria esteja sempre atualizada.
     <p>
     Este método verifica se o produto já está na lista de produtos da categoria. Se não estiver,
     ele é adicionado à lista. Em seguida, o método atualiza a categoria do produto para a categoria atual,
     removendo-o de qualquer categoria anterior, se necessário. Isso assegura que o produto mantenha
     a associação correta com sua nova categoria, mesmo que já estivesse presente na lista.
     </p>

     @param produto O produto a ser adicionado à categoria.
     */
    public void adicioneProduto(Produto produto){
        if(!produtos.contains(produto)){
            produtos.add(produto);
            System.out.println("Foi adicionado o produto "+produto.getNome()+" à categoria ");
        }
        for(Produto produtoProcurado : produtos){
            if(produtoProcurado.equals(produto)){
                produtoProcurado.setCategoria(this);
                System.out.println("Foi adicionado ao produto "+produtoProcurado.getNome()+" a categoria "+produtoProcurado.getCategoria().getNome());
            }
        }
    }
    
    public void adicioneSubcategoria(Categoria subcategoria){
        subcategorias.add(subcategoria);
    }
     /**
     Remove uma categoria do sistema, permitindo a opção de remoção permanente ou temporária.
     <p>
     Este método permite que uma categoria seja removida de maneira permanente ou que sua remoção seja
     temporária. Na remoção temporária, a subcategoria é removida e nada mais precisa ser feito feito.
     Se a remoção for permanente, a categoria é excluída de forma definitiva. Nesse caso, todos os produtos que eram
     da categoria removida passam a ser da categoria à qual ela pertencia. Além disso, na remoção
     permanente, todas as subcategorias daquela que foi removida passam a ser subcategorias da categoria
     à qual ela pertencia.
     </p>
     <p>
     A remoção temporária é útil para gerenciar categorias que podem ser reintegradas posteriormente,
     possivelmente em outro ramo da árvore de categorias, enquanto a remoção permanente é aplicada
     quando a categoria não é mais necessária. O método garante que as referências a produtos ou
     subcategorias relacionadas sejam movidos adequadamente durante o processo de remoção.
     </p>

     @param categoria  A categoria a ser removida.
     @param permanente Indica se a remoção deve ser permanente (true) ou temporária (false).

     @throws IllegalArgumentException Se a categoria não existir no sistema.
     */
    public void removaSubcategoria(Categoria subcategoria, boolean permanente){
        if (permanente){
            for(Produto produto : produtos){
                if(produto.getCategoria().equals(subcategoria)){
                    produto.setCategoria(this);
                }
            }
            for(Categoria categoriaProcurada : subcategorias){
                if(categoriaProcurada.equals(subcategoria)){
                    for(Categoria subcategoriaProcurada : categoriaProcurada.getSubcategorias()){
                        this.getSubcategorias().add(subcategoriaProcurada);
                    }
                }
            }
        }
        if(subcategorias.contains(subcategoria)){
            System.out.println("Foi removida a categoria "+subcategoria.getNome());
            subcategorias.remove(subcategoria);
        }
    }
    
    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }
    
}