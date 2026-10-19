//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Frota frota = new Frota();
        int opcao;
        String placa;
        double consumo, capacidade, litros, km, kmAux, litrosAux;
        Carro carroAux;
        do {
            opcao = Input.in(
                    """
                    1 - Inserir carro
                    2 - Consultar carro
                    3 - Remover carro
                    4 - Percorrer KM com carro
                    5 - Abastecer carro
                    0 - Sair
                    """);
            switch (opcao) {

                case 1:
                    placa = Input.st("Informe a placa:");
                    consumo = Input.db("Informe o consumo: ");
                    capacidade = Input.db("Informe a capac: ");
                    frota.adicionarCarro(new Carro(placa, consumo, capacidade));
                    break;
                case 2:
                    placa = Input.st("Informe a placa: ");
                    carroAux = frota.pesquisarPlaca(placa);
                    if (carroAux == null) {
                        System.out.println("Carro não encontrado");
                    } else {
                        System.out.println("Hodômetro: " + carroAux.getHodometro()
                                + "\nCombustível: " + carroAux.getDispCombustivel());
                    }
                    break;

                case 3:
                    placa = Input.st("Informe a placa: ");
                    carroAux = frota.pesquisarPlaca(placa);
                    if (carroAux == null) {
                        System.out.println("Carro não encontrado");
                    } else {
                        frota.removerCarro(carroAux.getPlaca());
                    }
                    break;
                case 4:
                    placa = Input.st("Informe a placa: ");
                    carroAux = frota.pesquisarPlaca(placa);
                    if (carroAux == null) {
                        System.out.println("Carro não encontrado");
                    } else {
                        km = Input.db("Informe a KM: ");
                        kmAux = carroAux.percorrer(km);
                        if (km > kmAux) {
                            System.out.println("Acabou combustível no km " + kmAux);
                        } else {
                            System.out.println("KM percorrida!");
                        }
                    }
                    break;

                case 5:
                    placa = Input.st("Informe a placa: ");
                    carroAux = frota.pesquisarPlaca(placa);
                    if (carroAux == null) {
                        System.out.println("Carro não encontrado");
                    } else {
                        litros = Input.db("Informe Litros: ");
                        litrosAux = carroAux.abastecer(litros);
                        System.out.println("Abastecidos " + litrosAux + " litros");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;

            }// Fim do switch

        } while (opcao != 0);

    } //Fim do main
}