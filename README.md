# 🎓 Sistema Escolar

Sistema de gerenciamento escolar desenvolvido com foco no aprendizado de modelagem de banco de dados, relacionamentos SQL e consultas envolvendo alunos, turmas e matrículas.

## 📚 Sobre o Projeto

O projeto simula um sistema escolar simples, permitindo o gerenciamento de:

- Turmas
- Alunos
- Matrículas

Além disso, o sistema realiza consultas relacionando as tabelas para exibir os alunos vinculados a cada turma.

---

## 🛠️ Tecnologias Utilizadas

- MySQL
- SQL
- Git
- GitHub

---

## 🗂️ Estrutura do Banco

O banco de dados é composto pelas seguintes tabelas principais:

### 👨‍🎓 Aluno
Responsável pelo armazenamento dos dados dos alunos.

### 🏫 Turma
Responsável pelas turmas cadastradas no sistema.

### 📝 Matrícula
Tabela intermediária responsável por relacionar alunos e turmas.

---

## 🔗 Relacionamentos

O sistema utiliza relacionamento entre tabelas através de chaves estrangeiras:

- Uma turma pode possuir vários alunos
- Um aluno pode estar matriculado em uma turma
- A tabela `matricula` faz a ligação entre `aluno` e `turma`

---

## ⚙️ Funcionalidades

- ✅ Cadastro de turmas
- ✅ Cadastro de alunos
- ✅ Realização de matrículas
- ✅ Listagem de turmas
- ✅ Exibição dos alunos pertencentes a cada turma
- ✅ Consultas utilizando `JOIN`

---

## 🧠 Exemplo de Consulta

```sql
SELECT 
    turma.nome_turma,
    aluno.nome_aluno
FROM matricula
INNER JOIN turma 
    ON matricula.id_turma = turma.id_turma
INNER JOIN aluno 
    ON matricula.id_aluno = aluno.id_aluno;
