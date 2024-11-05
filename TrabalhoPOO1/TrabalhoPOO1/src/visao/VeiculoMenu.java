package visao;

import java.util.ArrayList;

import dominio.Veiculo;
import servico.VeiculoServico;

public class VeiculoMenu extends BaseMenu {

    private VeiculoServico srvc;
    public VeiculoMenu(){
        super();
        this.srvc = new VeiculoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while (opcao != 9) {
            Util.LimparConsole();
            System.out.println("Lista de veículos cadastrados");
            System.out.println("1 - Listar veículos");
            System.out.println("2 - Localizar veículo");
            System.out.println("3 - Adicionar veículo");
            System.out.println("4 - Atualizar lista");
            System.out.println("5 - Remover veículo");
            System.out.println("9 - Sair");
            System.out.println("Selecione uma das opções:");
            opcao =  this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("Listando veículos");
        ArrayList<Veiculo> lista = this.srvc.Navegar();
        for (Veiculo vei : lista) {
            this.Imprimir(vei);
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        System.out.println("Localizando veículo");
        System.out.println("Informe o código do veículo que deseja localizar");
        int cod = this.scanner.nextInt();
        Veiculo vei = this.srvc.Ler(cod);
        if (vei!=null) {
            this.Imprimir(vei);
        }else{
            System.out.println("ERRO - Código de veículo não encontrado");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando veículo");
        System.out.println("Informe a marca do veículo:");
        String marca = this.scanner.next();
        System.out.println("informe o modelo:");
        String modelo = this.scanner.next();
        System.out.println("Informe o ano de fabricação do veículo:");
        int anoFab = this.scanner.nextInt();
        System.out.println("Informe o valor do veículo");
        double valorVei = this.scanner.nextDouble();
        Veiculo vei = new Veiculo();
        vei.setMarcaVeiculo(marca);
        vei.setModeloVeiculo(modelo);
        vei.setAnoFabricacao(anoFab);
        vei.setPrecoVeiculo(valorVei);
        if (this.srvc.Adicionar(vei) != null) {
            System.out.println("-------------------------------");
            System.out.println("Informações do veículo adicionado abaixo");
            this.Imprimir(vei);
            System.out.println("VEÍCULO ADICIONADO COM SUCESSO");
        }else{
            System.out.println("ERRO - Não foi possível adicionar o veículo");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        System.out.println("Atualizando Veículo");
        System.out.println("Informe o código do veículo que deseja alterar");
        int cod = this.scanner.nextInt();
        Veiculo vei = this.srvc.Ler(cod);
        if (vei != null) {
        System.out.println("-------------------------------");
        System.out.println("Veículo selecionado para alteração:");
        this.Imprimir(vei);
            System.out.println("Informe o novo Valor");
            double novovalor = this.scanner.nextDouble();
            vei.setPrecoVeiculo(novovalor);
            if (this.srvc.Editar(vei) != null) {
                this.Imprimir(vei);
                System.out.println("ALTERAÇÃO REALIZADA COM SUCESSO");
            }else{
                System.out.println("ERRO - Alteração não pode ser concluida");
            }
        }else{
            System.out.println("ERRO - Código do veículo não encontrado");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        System.out.println("Removendo veículo");
        System.out.println("Informe o código do veículo que deseja remover");
        int cod = this.scanner.nextInt();
        Veiculo vei = this.srvc.Ler(cod);
        if (vei!=null) {
            if (this.srvc.Deletar(cod) != null) {
                System.out.println("-------------------------------");
                System.out.println("Informações do veículo removido abaixo");
                this.Imprimir(vei);
                System.out.println("VEÍCULO REMOVIDO COM SUCESSO");
            }else{
                System.out.println("ERRO - Veículo não pode ser removido");
            }
        }else{
            System.out.println("ERRO - Código de veículo não encontrado");
        }
        System.out.println("Aperte <ENTER> para continuar");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void Imprimir(Veiculo vei){
        System.out.println("=================================================");
        System.out.println("Informações do veículo ");
        System.out.println("Código do veículo: " + vei.getCodigoVeiculo());
        System.out.println("Marca do veículo: " +vei.getMarcaVeiculo());
        System.out.println("Modelo do veículo: " + vei.getModeloVeiculo());
        System.out.println("Ano de fabricação: " + vei.getAnoFabricacao());
        System.out.println("Valor do veículo: " + vei.getPrecoVeiculo());
        System.out.println("=================================================");
    }
    
}
