package dominio;

public class Veiculo extends BaseParametro {
    public Veiculo(){
        super();
    }
    public Veiculo(int codigoVeiculo, String marcaVeiculo, String modeloVeiculo, int anoFabricacao, double precoVeiculo){
        super(codigoVeiculo, marcaVeiculo, modeloVeiculo, anoFabricacao, precoVeiculo);
    }
}
