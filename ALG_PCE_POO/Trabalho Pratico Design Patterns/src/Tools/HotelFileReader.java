package Tools;

import Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe responsável por ler ficheiros CSV fornecidos.
 * Converte cada linha em objetos do modelo correspondente
 */
public class HotelFileReader {

    /**
     * Lê o ficheiro dos utilizadores e retorna uma lista de Utilizador
     * @param filePath Caminho para o ficheiro CSV dos utilizadores
     * @return Lista de utilizadores
     * @throws FileNotFoundException
     */
    public ArrayList<Utilizador> utilizadorFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Utilizador> utilizadoresArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String username = linhaSeparada[0];
            String password = linhaSeparada[1];
            String tipo_acesso = linhaSeparada[2];
            Utilizador utilizador = new Utilizador(username, password, tipo_acesso);
            utilizadoresArray.add(utilizador);
        }

        scanner.close();
        return utilizadoresArray;
    }

    /**
     * Lê o ficheiro de vendas de experiências e devolve uma lista de Venda.
     * @param filePath Caminho para o ficheiro CSV das vendas
     * @return Lista de Vendas
     * @throws FileNotFoundException
     */
    public ArrayList<Venda> vendaFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Venda> vendasArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String idVenda = linhaSeparada[0];
            String idExperiencia = (linhaSeparada[1]);
            String tipoCliente = linhaSeparada[2];
            int ano = Integer.parseInt(linhaSeparada[3]);
            int mes = Integer.parseInt(linhaSeparada[4]);
            Venda venda = new Venda(idVenda, idExperiencia, tipoCliente, ano, mes);
            vendasArray.add(venda);
        }
        scanner.close();
        return vendasArray;
    }


    /**
     * Lê o ficheiro de clientes e devolve uma lista de Cliente.
     * @param filePath Caminho para o ficheiro CSV de clientes.
     * @return Lista de Clientes
     * @throws FileNotFoundException
     */
    public ArrayList<Cliente> clienteFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Cliente> clientesArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            String telemovel = linhaSeparada[4];
            String dataNascimento = linhaSeparada[5];
            boolean consentimentoMarketing = Boolean.parseBoolean(linhaSeparada[6]);

            Cliente cliente = new Cliente(id, nome, nacionalidade, email, telemovel, dataNascimento, consentimentoMarketing);
            clientesArray.add(cliente);
        }
        scanner.close();
        return clientesArray;
    }


    /**
     * Lê o ficheiro de experiências e devolve uma lista de Experiencia.
     * @param filePath Caminho para o ficheiro CSV de experiências.
     * @return Lista de experiências
     * @throws FileNotFoundException
     */
    public ArrayList<Experiencia> experienciaFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Experiencia> experienciasArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String id_guia_experiencia = linhaSeparada[2];
            double precoAdulto = Double.parseDouble(linhaSeparada[3]);
            double precoCrianca = Double.parseDouble(linhaSeparada[4]);
            Experiencia experiencia = new Experiencia(id, nome, id_guia_experiencia, precoAdulto, precoCrianca);
            experienciasArray.add(experiencia);
        }
        scanner.close();
        return experienciasArray;
    }

    /**
     * Lê o ficheiro de guias de experiência e devolve uma lista de Guia Experiencia.
     * @param filePath Caminho para o ficheiro CSV de guias de experiência
     * @return Lista de guias de experiências
     * @throws FileNotFoundException
     */
    public ArrayList<GuiaExperiencia> guiaExperienciaFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<GuiaExperiencia> guiaExperienciasArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            String nome = linhaSeparada[1];
            String nacionalidade = linhaSeparada[2];
            String email = linhaSeparada[3];
            String telemovel = linhaSeparada[4];
            GuiaExperiencia guiaExperiencia = new GuiaExperiencia(id, nome, nacionalidade, email, telemovel);
            guiaExperienciasArray.add(guiaExperiencia);
        }
        scanner.close();
        return guiaExperienciasArray;
    }

    /**
     * Lê o ficheiro de quartos e devolve uma lista de Quarto.
     * @param filePath Caminho para o ficheiro CSV de quartos.
     * @return Lista de quartos.
     * @throws FileNotFoundException
     */
    public ArrayList<Quarto> quartoFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Quarto> quartosArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            if (linhaSeparada.length >= 2) {
                int num_quarto = Integer.parseInt(linhaSeparada[0]);
                int id_tipologia = Integer.parseInt(linhaSeparada[1]);
                double precoPorSemana = 0.0;
                boolean disponivel = true;
                Quarto quarto = new Quarto(num_quarto, id_tipologia, precoPorSemana, disponivel);
                quartosArray.add(quarto);
            }
        }
        scanner.close();
        return quartosArray;
    }


    /**
     * Lê o ficheiro de reservas e devolve uma lista de Reserva.
     * @param filePath Caminho para o ficheiro CSV de reservas.
     * @return Lista de reservas.
     * @throws FileNotFoundException
     */
    public ArrayList<Reserva> reservaFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Reserva> reservasArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = linhaSeparada[0];
            int num_quarto = Integer.parseInt(linhaSeparada[1]);
            String id_cliente = (linhaSeparada[2]);
            int ano = Integer.parseInt(linhaSeparada[3]);
            int mes = Integer.parseInt(linhaSeparada[4]);
            int semana = Integer.parseInt(linhaSeparada[5]);
            Reserva reserva = new Reserva(id, num_quarto, id_cliente, ano, mes, semana);
            reservasArray.add(reserva);
        }
        scanner.close();
        return reservasArray;


    }

    /**
     * Lê o ficheiro de tipologias e devolve uma lista de Tipologia.
     * @param filePath Caminho para o ficheiro CSV de tipologias.
     * @return Lista de tipologias.
     * @throws FileNotFoundException
     */
    public ArrayList<Tipologia> tipologiaFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Tipologia> tipologiasArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            int idTipologia = Integer.parseInt(linhaSeparada[0]);
            String descricao = (linhaSeparada[1]);
            double precoPorsemana = Double.parseDouble((linhaSeparada[2]));
            Tipologia tipologia = new Tipologia(idTipologia, descricao, precoPorsemana);

            tipologiasArray.add(tipologia);
        }
        scanner.close();
        return tipologiasArray;
    }

    /**
     * Lê o ficheiro de ratings de experiências e devolve uma lista de Rating.
     * @param filePath Caminho para o ficheiro CSV de ratings.
     * @return Lista de ratings.
     * @throws FileNotFoundException
     */
    public ArrayList<Rating> ratingFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Rating> ratingsArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            String id = (linhaSeparada[0]);
            String id_experiencia = (linhaSeparada[1]);
            double rating_experiencia = Double.parseDouble((linhaSeparada[2]));
            double rating_guia = Double.parseDouble((linhaSeparada[3]));
            Rating rating = new Rating(id, id_experiencia, rating_experiencia, rating_guia);
            ratingsArray.add(rating);
        }
        scanner.close();
        return ratingsArray;
    }

}
