package model;

public class UserExDue {
    private  String nome ;
    private String provincia ;
    private String saluto ;

    public UserExDue(String nome, String provincia, String saluto) {
        this.nome = nome;
        this.provincia = provincia;
        this.saluto = saluto ;
    }

    public String getNome() {
        return nome;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getSaluto() {
        return saluto;
    }
}
