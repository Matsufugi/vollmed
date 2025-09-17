## 💻 Sobre o projeto


Desafio: 

Voll.med é uma clínica médica fictícia que precisa de um aplicativo para gestão de consultas. O aplicativo deve possuir funcionalidades que permitam **o cadastro de médicos e de pacientes, e também o agendamento e cancelamento de consultas.**

## ⚙️ Funcionalidades

- [x] CRUD de médicos;
- [x] CRUD de pacientes;
- [x] Agendamento de consultas(em breve);
- [x] Cancelamento de consultas(em breve);
<BR>

**🚀 Tecnologias que devem ser utilizadas:**

<p align="left">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="spring" width="40" height="40"/>
  <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/maven/maven-original.svg" alt="maven" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" alt="postgresql" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/hibernate/hibernate-original.svg" alt="hibernate" width="40" height="40"/>
</p>



---

<br>

## ▶️ Como Rodar o Projeto

***Clonar o repositório***
```
git clone https://github.com/matsufugi/vollmed.git
```
***Acessar a pasta***

```
cd vollmed
```
***Instalar dependências***
```
mvn install
```
***Rodar a aplicação***
```
mvn spring-boot:run
```

# 📌 Endpoints Principais
<br>

1️⃣ Login
**POST** -> /login
```
{
    "login":"user@voll.med",
    "senha":"909090"
}
```
2️⃣ Cadastrar Médico
**GET** -> /medicos
```
{
  "ativo": "true",
  "nome":"Carlos Rodrigues",
  "email":"carlos.rodrigues@email.com",
  "crm":"122266",
  "telefone":"11988667958",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
      "logradouro": "rua 1",
      "bairro": "bairro",
      "cep": "12345678",
      "cidade": "Brasilia",
      "uf": "DF",
      "numero": "1",
      "complemento": "complemento"
  }
}
```

3️⃣ Listar Médicos
**GET**
```
http://localhost:8080/medicos
```

4️⃣ Atualizar Médico
**PUT** -> /medicos
```
{
    "Id": 1,
    "nome": "Clara Azevedo"
}
```

5️⃣ Deletar Médico
**DELETE**
```
http://localhost:8080/medicos/{id}
```
6️⃣ Detalhar Médicos
**GET**
```
http://localhost:8080/consultas/{id}
```
7️⃣ Agendar Consulta
**POST** -> /consultas
```
{
    "idPaciente": 1,
    "idMedico": 2,
    "data": "2025-09-14T02:00"
}
```
---

<br>

## Agradecimentos

Projeto desenvolvido por Matheus Alves durante a trilha de carreira Java na [Alura](https://www.alura.com.br/)

Obrigado pela sua visita !! 

---
