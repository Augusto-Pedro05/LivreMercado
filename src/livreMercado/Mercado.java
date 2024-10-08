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
public class Mercado {
    
    private List<Categoria> categorias;
    private List<Comprador> compradores;
    private List<Vendedor> vendedores;
    /**
     Construtor que inicializa um novo mercado com listas vazias de categorias, vendedores e compradores.
     */
    public Mercado(){
        this.categorias = new ArrayList<>();
        this.compradores = new ArrayList<>();
        this.vendedores = new ArrayList<>();
    }
    /**
     Adiciona uma nova categoria ao mercado.
     <p>
     Este método verifica se a categoria já está presente na lista
     de categorias. Se não estiver, a categoria é adicionada.

     @param categoria A categoria a ser adicionada ao mercado.
     */
    public void adicioneCategoria(Categoria categoria){
        if (!categorias.contains(categoria)){
            categorias.add(categoria);
        }
    }
     /**
     Adiciona um novo comprador ao mercado.
     <p>
     Este método verifica se o comprador já está presente na lista
     de compradores. Se não estiver, o comprador é adicionado.

     @param comprador O comprador a ser adicionado ao mercado.
     */
    public void adicioneComprador(Comprador comprador){
        if (!compradores.contains(comprador)){
            compradores.add(comprador);
        }
    }
    /**
     Adiciona um novo vendedor ao mercado.
     <p>
     Este método verifica se o vendedor já está presente na lista
     de vendedores. Se não estiver, o vendedor é adicionado.

     @param vendedor O vendedor a ser adicionado ao mercado.
     */
    public void adicioneVendedor(Vendedor vendedor){
        if (!vendedores.contains(vendedor)){
            vendedores.add(vendedor);
        }
    }
    
    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Comprador> getCompradores() {
        return compradores;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }
}
