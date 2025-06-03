package TrabalhoI.src.utils;

import src.model.Categoria;
import src.model.Veiculo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class ImportaCSV {

    private static final String CAMINHO_CATEGORIAS = Paths.get("src", "utils", "Categorias.csv").toString();
    private static final String CAMINHO_VEICULOS = Paths.get("src", "utils", "Veiculos.csv").toString();

    
    public static void importarCategorias() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_CATEGORIAS))) {
            String linha;
            br.readLine();
            
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    String nome = dados[1].trim();
                    int identificador = Integer.parseInt(dados[0].trim());
                    Categoria.cadastrarCategoria(nome, identificador);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de categorias: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter dados do arquivo de categorias: " + e.getMessage());
        }
    }
    
    public static void importarVeiculos() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_VEICULOS))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 7) {
                    String placa = dados[0].trim();
                    String modelo = dados[1].trim();
                    String marca = dados[2].trim();
                    int ano = Integer.parseInt(dados[3].trim());
                    int potencia = Integer.parseInt(dados[4].trim());
                    int lugares = Integer.parseInt(dados[5].trim());
                    int idCategoria = Integer.parseInt(dados[6].trim());
                    
                    Categoria categoria = Categoria.buscarCategoria(idCategoria);
                    if (categoria != null) {
                        Veiculo.cadastrarVeiculo(placa, modelo, marca, ano, potencia, lugares, categoria);
                    } else {
                        System.out.println("Categoria com ID " + idCategoria + " não encontrada. Veículo não cadastrado.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de veículos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter dados do arquivo de veículos: " + e.getMessage());
        }
    }
    public static void importarDados() {
        importarCategorias();
        importarVeiculos();
    }
}