package B19DCCN445;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity

@Table(name="BaiViet")
public class BaiViet implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column(columnDefinition="varchar2(1000)")
	private String content;
	@Column(columnDefinition="varchar2(1000)")
	private String preContent;
	@Column
	private String author;
	@Column
	private Date createAt;
	
	@ManyToOne
	@JoinColumn(name="accountId")
	private Category account;

	public BaiViet() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Category getAccount() {
		return account;
	}

	public void setAccount(Category account) {
		this.account = account;
	}
	
	
	
}
