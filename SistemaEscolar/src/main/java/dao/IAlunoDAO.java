package dao;

import model.Aluno;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {
    // CRUD

    // C - Create
    void salvar(Aluno aluno);

    // R - Read
    List<Aluno> listarTodosAlunos();

    // U- Update
    void atualizar(Aluno aluno);

    // D - Delete
    void excluirAluno(int id);

    // GetById
    //Aluno obterPorId(int id);
    Optional<Aluno> obterPorId(int id);

}