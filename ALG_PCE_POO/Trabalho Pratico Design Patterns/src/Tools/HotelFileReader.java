package Tools;

import Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelFileReader {

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

    public ArrayList<Venda> vendaFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Venda> vendasArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            int idVenda = Integer.parseInt(linhaSeparada[0]);
            int idExperiencia = Integer.parseInt(linhaSeparada[1]);
            String tipoCliente = linhaSeparada[2];
            int ano = Integer.parseInt(linhaSeparada[3]);
            int mes = Integer.parseInt(linhaSeparada[4]);
            Venda venda = new Venda(idVenda, idExperiencia, tipoCliente, ano, mes);
            vendasArray.add(venda);
        }
        scanner.close();
        return vendasArray;
    }


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

    public ArrayList<Quarto> quartoFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Quarto> quartosArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            int num_quarto = Integer.parseInt(linhaSeparada[0]);
            int id_tipologia = Integer.parseInt(linhaSeparada[1]);
            double precoPorSemana = Double.parseDouble(linhaSeparada[2]);
            boolean disponivel = Boolean.parseBoolean(linhaSeparada[3]);
            Quarto quarto = new Quarto(num_quarto, id_tipologia, precoPorSemana, disponivel);
            quartosArray.add(quarto);
        }
        scanner.close();
        return quartosArray;
    }


    public ArrayList<Reserva> reservaFileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Reserva> reservasArray = new ArrayList<>();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] linhaSeparada = linha.split(",");
            int id = Integer.parseInt(linhaSeparada[0]);
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
        }
        scanner.close();
        return ratingsArray;
    }

}
