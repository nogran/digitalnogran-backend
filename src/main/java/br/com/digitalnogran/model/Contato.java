package br.com.digitalnogran.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * A anotação @Entity indica que a classe é uma entidade, ou seja,
 * ele será utilizada para gerar uma tabela no Banco de Dados.
 * 
 * A anotação @Table indica o nome da tabela no Banco de dados.
 * Caso ela não seja declarada, o Banco criará a tabela com o mesmo
 * nome da classe.
 */

@Entity
@Table(name = "tb_contato")
public class Contato {
	/**
	 * A anotação @Id inidica que o atributo é a chave primária da tabela.
	 * 
	 * A anotação @GeneratedValue indica que a chave primária será gerada
	 * automaticamente pelo Banco de Dados.
	 * 
	 * O parâmetro strategy indica como a Chave Primária será gerada. 
	 * 
     * A opção GenerationType.IDENTITY indica que será uma sequência numérica iniciando
	 * em 1 e será responsabilidade do Banco de dados gerar esta sequência, ou seja,
	 * a propriedade auto_increment do SQL. 
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * A anotação @NotNull indica que um atributo não pode ser nulo.
	 * 
	 * O parâmtero message insere uma mensagem que será exibida caso o
	 * atributo seja nulo.
	 * 
     * A anotação @NotBlank indica que um atributo não pode ser nulo e 
	 * também não pode ser deixado em branco (vazio).
	 * 
	 * A anotação @Size tem a função de definir o tamanho minimo e máximo de
	 * caracteres de um atributo String. Não é obrigatório definir os 2 parâmetros, 
	 * você pode definir apenas um deles de acordo com as necessidades do seu
     * projeto.
	 * 
	 * Para utilizar as anotações acima, foi inserido a Dependência Validation
	 * na criação do projeto, tambem e possivel inserir manualmente no arquivo pom.xml
	 * 
	 */
	
	@NotBlank(message = "O atributo nome é obrigatório e não pode utilizar espaços em branco!") 
	@Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres.")
	private String nome; 	
	
	@NotNull(message = "O atributo telefone é obrigatório!")
	@Size(min = 10, max = 14, message = "O atributo telefone deve conter no mínimo 10 e no máximo 14 caracteres.")
	private String telefone;	
	
	@NotNull(message = "O atributo E-mail é obrigatório!")
	@Email
	private String email;	
	
	@NotNull(message = "O atributo Mensagem é obrigatório!")
	private String mensagem;
	

	/**
	 * A anotação @UpdateTimestamp Indica que o atributo receberá um Timestamp (Data e hora do sistema).
	 */
	@UpdateTimestamp
	private LocalDateTime data;
	
	/**
	 * 
	 * Os Métodos Get e Set obrigatoriamente devem ser criados para todos os atributos
     * da Classe, inclusive os novos atributos que forem adicionados no decorrer do
     * processo de Desenvolvimento.
	 * 
	 */	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
