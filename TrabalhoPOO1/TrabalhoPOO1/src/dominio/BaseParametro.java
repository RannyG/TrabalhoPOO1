package dominio;

public abstract class BaseParametro {
    protected int codigoVeiculo;
    protected String marcaVeiculo;
    protected String modeloVeiculo;
    protected int anoFabricacao;
    protected double precoVeiculo;

    public int getCodigoVeiculo() {
        return codigoVeiculo;
    }
    public void setCodigoVeiculo(int codigoVeiculo) {
        this.codigoVeiculo = codigoVeiculo;
    }
    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }
    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }
    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }
    public int getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    public double getPrecoVeiculo() {
        return precoVeiculo;
    }
    public void setPrecoVeiculo(double precoVeiculo) {
        this.precoVeiculo = precoVeiculo;
    }
    public BaseParametro(){
    }
    public BaseParametro(int codigoVeiculo, String marcaVeiculo, String modeloVeiculo, int anoFabricacao,
            double precoVeiculo) {
        this.codigoVeiculo = codigoVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoFabricacao = anoFabricacao;
        this.precoVeiculo = precoVeiculo;
    }
    
}
