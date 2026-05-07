package dao;

import model.Aluno;

public interface IAlunoDAO {
    //crud
    // C - Create
   void  salvar(Aluno aluno );
   // R - Read
    List<Aluno> listarTodosAlunos();
    // U - Update
    void atualizarAluno(Aluno aluno);
    // D - delete
    void excluirAluno(int id);

}
