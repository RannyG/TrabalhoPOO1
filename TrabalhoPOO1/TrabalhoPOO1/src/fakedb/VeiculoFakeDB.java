package fakedb;

import java.util.ArrayList;

import dominio.Veiculo;

public class VeiculoFakeDB extends BaseFakeDB<Veiculo> {

    @Override
    protected void preencherDados() {
        this.tabelaVeiculo = new ArrayList<Veiculo>();
        this.tabelaVeiculo.add(new Veiculo(1, "Fiat", "Mobi", 2021, 35000.0));
        this.tabelaVeiculo.add(new Veiculo(2, "VolksWagen", "Gol", 2019, 44000.0));
        this.tabelaVeiculo.add(new Veiculo(3, "BMW", "X1", 2022, 350000.0));

    }
    public VeiculoFakeDB(){
        super();
    }
    
}
