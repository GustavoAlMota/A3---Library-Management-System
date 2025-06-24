public class Usuario {
    private String nome;
    private String senha;
    private String tipo;
    private String preferenciaLivro1;
    private String preferenciaLivro2;

    public Usuario(String nome, String senha, String tipo, String preferenciaLivro1, String preferenciaLivro2) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.preferenciaLivro1 = preferenciaLivro1;
        this.preferenciaLivro2 = preferenciaLivro2;
    }

    public Usuario() {
    }
    
    public Usuario (String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreferenciaLivro1() {
        return preferenciaLivro1;
    }

    public void setPreferenciaLivro1(String preferenciaLivro1) {
        this.preferenciaLivro1 = preferenciaLivro1;
    }

    public String getPreferenciaLivro2() {
        return preferenciaLivro2;
    }

    public void setPreferenciaLivro2(String preferenciaLivro2) {
        this.preferenciaLivro2 = preferenciaLivro2;
    }
    
}
