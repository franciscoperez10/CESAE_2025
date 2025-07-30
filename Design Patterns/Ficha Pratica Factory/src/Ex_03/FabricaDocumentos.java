package Ex_03;

public class FabricaDocumentos {
    public static Document criarDocumento(String tipoDocumento,String autor, String nome) {
        switch (tipoDocumento.toLowerCase()) {
            case "texto":
                return new Texto(autor, nome, tipoDocumento);
            case "cálculo":
                return new Calculo(autor, nome, tipoDocumento);
            case "apresentação":
                return new Apresentação(autor, nome, tipoDocumento);
            default:
                throw new IllegalArgumentException("Tipo de documento não reconhecido: "+tipoDocumento);

        }
    }
}
