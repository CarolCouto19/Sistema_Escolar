package daoImplements;

import dao.IAlunoDAO;
import dao.ITurmaDAO;
import dataBase.sqlConn;
import model.Aluno;
import model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOImplements implements ITurmaDAO {

    @Override
    public List<Turma> listarTodasTurmas() {

        String sql = "select * from turma order by turno desc, nome asc";
        List<Turma> turmasEncontradas = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                turmasEncontradas.add(new Turma (
                        rs.getInt("idTurma"),
                        rs.getInt("instituicao_id"),
                        rs.getInt("professor_id"),
                        rs.getString("nome"),
                        rs.getInt("ano_letivo"),
                        rs.getString("turno"),
                        rs.getInt("vagas")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar os turmas: " + e.getMessage());
        }

        return turmasEncontradas;
    }

    @Override
    public List<Aluno> listarAlunoPorTurmaID(int idTurma) {
        String sql = "SELECT a.* " +
                "FROM matricula m " +
                "INNER JOIN aluno a  ON m.aluno_id = a.idAluno " +
                "WHERE m.turma_id = ? " +
                "ORDER BY a.nome ASC ";

        List<Aluno> alunosEncontrados = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idTurma);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alunosEncontrados.add(new Aluno(
                        rs.getInt("idAluno"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar os alunos por turma: " + e.getMessage());
        }

        return alunosEncontrados;
    }
}