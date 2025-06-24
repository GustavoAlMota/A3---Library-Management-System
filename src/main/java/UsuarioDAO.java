
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public static boolean existe(Usuario u) throws Exception {
        String sql = "select * from tb_usuario where "
                + "nome = ? and senha = ?";
        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public static void cadastraUsuario(Usuario u) throws Exception {
        String sql = "insert into tb_usuario values (?,?,?,?,?)";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            ps.setString(3, u.getTipo());
            ps.setString(4, u.getPreferenciaLivro1());
            ps.setString(5, u.getPreferenciaLivro2());
            ps.execute();
        }
    }

    public static boolean consultaUsuario(Usuario u) throws Exception {
        String sql = "select * from tb_usuario where "
                + "nome = ? and senha = ?";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    u.setTipo(rs.getString(3));
                    if (u.getTipo().equals("comum")) {
                        u.setPreferenciaLivro1(rs.getString(4));
                        u.setPreferenciaLivro2(rs.getString(5));

                    }
                    return true;
                } else {

                    return false;
                }
            }
        }
    }

    public static void alterarUsuario(Usuario u) throws Exception {
        String sql;
        if (u.getTipo().equals("comum")) {
            sql = "UPDATE tb_usuario SET senha = ?, preferencia_livro_1 = ?, preferencia_livro_2 = ? WHERE nome = ?";
        } else {
            sql = "UPDATE tb_usuario SET senha = ? WHERE nome = ?";
        }

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u.getSenha());

            if (u.getTipo().equals("comum")) {
                ps.setString(2, u.getPreferenciaLivro1());
                ps.setString(3, u.getPreferenciaLivro2());
                ps.setString(4, u.getNome());
            } else {
                ps.setString(2, u.getNome());
            }

            ps.executeUpdate();
        }
    }

    public static boolean removerUsuario(String titulo) throws Exception {
        String sql = "DELETE FROM tb_usuario WHERE nome = ?";

        try (Connection conn = ConexaoBD.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);
            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0; // retorna true se algum livro foi removido
        }
    }

}
