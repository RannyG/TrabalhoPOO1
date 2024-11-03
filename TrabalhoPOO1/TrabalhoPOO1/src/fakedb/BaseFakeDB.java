package fakedb;

import java.util.ArrayList;

public abstract class BaseFakeDB<TDominio> {
    protected ArrayList<TDominio> tabelaVeiculo;

    public ArrayList<TDominio> getTabela(){
        return tabelaVeiculo;
    }
    protected abstract void preencherDados();

    public BaseFakeDB(){
        this.preencherDados();
    }
}
