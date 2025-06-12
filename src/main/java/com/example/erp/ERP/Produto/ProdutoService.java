    package com.example.erp.ERP.Produto;

    import com.example.erp.ERP.Config.TratadorDeErros;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class ProdutoService {

        private final ProdutoRepository repository;

        public ProdutoService(ProdutoRepository repository) {
            this.repository = repository;
        }

        public Produto criarUmProduto(Produto produto){
            return repository.save(produto);
        }

        public Produto buscarUmProduto(Long id){
            return repository.findById(id).orElseThrow(()->
                    new TratadorDeErros.RecursoNaoEncontradoException("Produto com id " + id + "não encontrado"));
        }

        public List<Produto> retornaUmListaDeProduto(){
           return repository.findAll();
        }

        public Produto atualizarProduto( Long id , Produto produtoNovo){
            Produto produtoExistente = repository.findById(id).orElseThrow(()->new TratadorDeErros.RecursoNaoEncontradoException("Produto com o id" + id + "não encontrado"));

            produtoExistente.setNome(produtoNovo.getNome());
            produtoExistente.setCategoria(produtoNovo.getCategoria());
            produtoExistente.setQuantidade(produtoNovo.getQuantidade());
            produtoExistente.setPrecoUN(produtoNovo.getPrecoUN());
            return repository.save(produtoExistente);
        }

        public void deletarProduto(Long id){
            Produto produto = repository.findById(id).
                    orElseThrow(()-> new TratadorDeErros.RecursoNaoEncontradoException("Produto com id" + id + "não encontrado"));
            repository.delete(produto);
        }
    }
