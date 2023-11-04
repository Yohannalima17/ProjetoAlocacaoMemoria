package P3_SO;

public class Main {
    public static void main(String[] args) {
        int memorySize = 1000;
        int simulationDuration = 100; // segundos
        Memoria memoria = new Memoria(memorySize);
        GeradorDeProcessos geradorDeProcessos = new GeradorDeProcessos();

        int totalProcessosGerados = 0;
        int totalProcessosAlocados = 0;
        int totalProcessosDescartados = 0;
        int totalPorcentagemOcupacao = 0;

        for (int segundo = 1; segundo <= simulationDuration; segundo++) {
            Processo processo1 = geradorDeProcessos.gerarProcessoAleatorio();
            Processo processo2 = geradorDeProcessos.gerarProcessoAleatorio();
            totalProcessosGerados += 2;

            if (memoria.alocar(processo1)) {
                totalProcessosAlocados++;
            }
            if (memoria.alocar(processo2)) {
                totalProcessosAlocados++;
            }

            if (segundo % 2 == 0) {
                memoria.desalocar();
            }

            totalPorcentagemOcupacao += memoria.getOcupacaoPorcentagem();
        }

        double tamanhoMedio = (double) memorySize / totalProcessosGerados;
        double ocupacaoMedia = (double) totalPorcentagemOcupacao / simulationDuration;
        double taxaDescarte = 100 - ((double) totalProcessosAlocados / totalProcessosGerados * 100);

        System.out.println("Tamanho Médio dos Processos Gerados: " + tamanhoMedio);
        System.out.println("Ocupação Média da Memória: " + ocupacaoMedia + "%");
        System.out.println("Taxa de Descarte: " + taxaDescarte + "%");
    }
}