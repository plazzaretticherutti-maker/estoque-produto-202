public class Carro {
    // Atributos privados (Encapsulamento)
    private String placa;
    private double hodometro;
    private double consumo;
    private double capacidadeTanque;
    private double dispCombustivel;

    // construtor, getters e setters

    public double abastecer(double litros) {
        if (litros <= 0) {
            return 0.0;
        }
        double espacoDisponivel = this.capacidadeTanque - this.dispCombustivel;
        double litrosEfetivos = litros;
        if (litros > espacoDisponivel) {
            litrosEfetivos = espacoDisponivel; // Limita ao que cabe no tanque
        }
        this.dispCombustivel += litrosEfetivos;
        return litrosEfetivos;
    }

    public double percorrer(double km) {
        if (km <= 0 || this.consumo <= 0) {
            return 0.0;
        }

        double litrosNecessarios = km / this.consumo;
        double kmReal;

        if (litrosNecessarios > this.dispCombustivel) {
            // O combustível acaba antes de completar o percurso
            kmReal = this.dispCombustivel * this.consumo;
            this.dispCombustivel = 0.0;
        } else {
            // Consegue completar o percurso inteiro
            kmReal = km;
            this.dispCombustivel -= litrosNecessarios;
        }

        this.hodometro += kmReal;
        return kmReal;
    }

}
