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
        Comprador comprador = new Comprador("gabriel");
        Vendedor vendedor = new Vendedor("pedro");
        Estoque estoque = new Estoque();
        Categoria foda = new Categoria("foda");
        Produto paoDeQueijo = new Produto("pao de queijo", "novo", "balduco", 3.00, foda);
        Produto coco = new Produto("coco", "coco", "coco", 2.50, foda);

        vendedor.adicioneProdutoAoEstoque(paoDeQueijo, 10);
        comprador.adicioneAoCarrinho(paoDeQueijo, vendedor, 5);
        //comprador.adicioneAoCarrinho(paoDeQueijo, vendedor, 3);
        //comprador.removerDoCarrinho(paoDeQueijo);
        vendedor.adicioneProdutoAoEstoque(coco, 5);
        comprador.adicioneAoCarrinho(coco, vendedor, 4);

        // testando adicioneProdutoAoCarrinho()
        for(ItemCompra item : comprador.getCarrinho().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        comprador.efetuarCompra();

        //testando efetuarCompra()
        for(ItemCompra item : comprador.getCarrinho().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        for(ItemEstoque item : vendedor.getEstoque().getItens()){
            System.out.println(item.getProduto().getNome());
            System.out.println(item.getQuantidade());
        }

        //testando adicioneProduto() -> classe categoria
        System.out.println(paoDeQueijo.getCategoria().getNome());
        Categoria legal = new Categoria("legal");
        legal.adicioneProduto(paoDeQueijo);
        System.out.println(paoDeQueijo.getCategoria().getNome());
        System.out.println();

        //testando removaSubcategoria()

        Categoria abacaxi = new Categoria("abacaxi");
        Categoria divertidamente = new Categoria("divertidamente");
        abacaxi.adicioneSubcategoria(divertidamente);
        abacaxi.adicioneProduto(coco);
        legal.adicioneSubcategoria(foda);
        legal.adicioneSubcategoria(abacaxi);

        for (Categoria categoria : legal.getSubcategorias()){
            System.out.println(categoria.getNome());
        }
        for (Produto produto : legal.getProdutos()){
            System.out.println(produto.getNome());
        }

        legal.removaSubcategoria(abacaxi, true);

        for (Categoria categoria : legal.getSubcategorias()){
            System.out.println(categoria.getNome());
        }
        for (Produto produto : legal.getProdutos()){
            System.out.println(produto.getNome());
        }

        //legal.removaSubcategoria(abacaxi, true);
    }
    
}
