package visao;

import java.util.ArrayList;

import dominio.Veiculo;
import servico.VeiculoServico;

public class VeiculoVisao{
    private VeiculoServico srvc;
    public VeiculoVisao(){
        this.srvc = new VeiculoServico(); 
    }
    public void Exibir(){
        ArrayList<Veiculo> lista = this.srvc.Navegar();
        System.out.println("==============================");
        for (Veiculo vei : lista) {
            this.Imprimir(vei);
        }
    }
    public void Imprimir(Veiculo novoVei){
        System.out.println("Informações do Veiculo: ");
        System.out.println("Código do Veiculo: "+ novoVei.getCodigoVeiculo());
        System.out.println("Modelo do Veiculo: " + novoVei.getModeloVeiculo());
        System.out.println("Marca do Veiculo: " + novoVei.getMarcaVeiculo());
        System.out.println("Ano de Fabricação do Veiculo" + novoVei.getAnoFabricacao());
        System.out.println("Valor do Veiculo: " + novoVei.getPrecoVeiculo());
    }

    public void Criar(Veiculo novoVeiculo){
        this.srvc.Adicionar(novoVeiculo);
    }

    public void Editar(int chave, Veiculo alterarVeiculo){
        Veiculo vei = this.srvc.Ler(chave);
        if (vei != null) {
            vei.setPrecoVeiculo(alterarVeiculo.getPrecoVeiculo());
        }else{
            System.out.println("Código do veiculo não encontrado...");
        }
    }

    public void Remover(int chave){
        Veiculo vei = this.srvc.Ler(chave);
        if (vei!=null) {
            this.srvc.Deletar(chave);
        }else{
            System.out.println("Código do veiculo não encontrado...");
        }
    }
}
