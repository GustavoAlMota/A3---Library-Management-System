
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 825151985
 */
public class LivroDAO {

    public static boolean consultaLivro(Livro l) throws Exception {
        String sql = "SELECT * FROM tb_livros WHERE titulo = ?";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Preencher os outros atributos do livro, se desejado
                    l.setAutor(rs.getString("autor"));
                    l.setTipo(rs.getString("tipo"));
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void cadastraLivro(Livro u) throws Exception {
        String sql = "INSERT INTO tb_livros (autor, titulo, tipo, nome) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getTitulo());
            ps.setString(2, u.getAutor());
            ps.setString(3, u.getTipo());
            ps.setString(4, u.getNomeUsuario());
            ps.execute();
        }
    }

    public void listarLivro() throws SQLException {
        String sql = "SELECT autor, titulo , tipo from tb_livros";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rs.getString("titulo");
                rs.getString("autor");
                rs.getString("tipo");

            }

        }
    }

    public static String listarLivrosComoTexto() throws Exception {
        String sql = "SELECT cod_livro , autor, titulo , tipo FROM tb_livros";
        String livros = "";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                livros += "Codigo: " + rs.getString("cod_livro") + "\n";
                livros += "Autor: " + rs.getString("autor") + "\n";
                livros += "Título: " + rs.getString("titulo") + "\n";
                livros += "Tipo: " + rs.getString("tipo") + "\n";
                livros += "---------------------------\n";
            }
        }

        return livros;
    }

    public static boolean removerLivro(String titulo) throws Exception {
        String sql = "DELETE FROM tb_livros WHERE titulo = ?";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;
        }
    }

    public static String listarLivrosTextoPorUsuario(String nomeUsuario) throws Exception {
        String livros = "";
        String sql = "SELECT cod_livro, autor, titulo, tipo FROM tb_livros WHERE nome = ?";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nomeUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                livros += "Codigo: " + rs.getString("cod_livro") + "\n";
                livros += "Autor: " + rs.getString("autor") + "\n";
                livros += "Título: " + rs.getString("titulo") + "\n";
                livros += "Tipo: " + rs.getString("tipo") + "\n";
                livros += "---------------------------\n";
            }
        }

        if (livros.isEmpty()) {
            return "Nenhum livro encontrado para o usuário: " + nomeUsuario;
        }

        return livros;
    }

}


/*try (Connection conn = ConexaoBD.obtemConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, autor);
        ps.setString(2, tipo);
        ps.setString(3, titulo);

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Livro não encontrado para atualizar", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar livro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }*/
