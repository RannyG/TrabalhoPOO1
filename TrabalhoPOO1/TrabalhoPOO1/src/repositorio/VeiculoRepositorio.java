package repositorio;

import dominio.Veiculo;
import fakedb.VeiculoFakeDB;

public class VeiculoRepositorio extends BaseRepositorio<Veiculo>{

    private VeiculoFakeDB db;

    public VeiculoRepositorio(){
        this.db = new VeiculoFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public Veiculo Read(int chave) {
        for (Veiculo vei : this.dados){
            if (vei.getCodigoVeiculo() == chave) {
                return vei;
            }
        }
        return null;
    }

    @Override
    public Veiculo Edit(Veiculo instancia) {
        Veiculo vei = this.Read(instancia.getCodigoVeiculo());
        if (vei != null) {
            vei.setPrecoVeiculo(instancia.getPrecoVeiculo());
            return vei;
        }else{
            return null;
        }
    }   

    @Override
    public Veiculo Add(Veiculo instancia) {
        int proxchave = this.dados.getLast().getCodigoVeiculo() +1;
        instancia.setCodigoVeiculo(proxchave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Veiculo Delete(int chave) {
        Veiculo vei = this.Read(chave);
        if (vei != null) {
            this.dados.remove(vei);
            return vei;
        }else{
            return null;
        }
    }
    
}
