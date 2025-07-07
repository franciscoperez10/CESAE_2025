package Models;

/**
 * Representa a avaliação (Rating) de uma experiência e do guia associado
 */

public class Rating {
    private String id;
    private String id_experiencia;
    private double rating_experiencia;
    private double rating_guia;

    public Rating(String id, String id_experiencia, double rating_experiencia, double rating_guia) {
        this.id = id;
        this.id_experiencia = id_experiencia;
        this.rating_experiencia = rating_experiencia;
        this.rating_guia = rating_guia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_experiencia() {
        return id_experiencia;
    }

    public void setId_experiencia(String id_experiencia) {
        this.id_experiencia = id_experiencia;
    }

    public double getRating_experiencia() {
        return rating_experiencia;
    }

    public void setRating_experiencia(double rating_experiencia) {
        this.rating_experiencia = rating_experiencia;
    }

    public double getRating_guia() {
        return rating_guia;
    }

    public void setRating_guia(double rating_guia) {
        this.rating_guia = rating_guia;
    }

    /**
     * Retorna os dados do Objeto Rating
     */
    @Override
    public String toString() {
        return "Rating ID: " + id +
                " | Experiência: " + id_experiencia +
                " | Rating da Experiência: " + rating_experiencia +
                " | Rating do Guia: " + rating_guia;
    }
}
