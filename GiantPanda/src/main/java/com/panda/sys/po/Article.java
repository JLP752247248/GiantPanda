package com.panda.sys.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
@Table(name="SYS_ARTICLE")
public class Article {

	@Id
	@Column(name="articleId")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="seq_article")
	@TableGenerator( name = "seq_article",pkColumnValue="seq_article",allocationSize=1,initialValue=1000000001,
	table = "hibernate_sequence", pkColumnName = "seq_name", valueColumnName = "next_val")
	private int articleId;
	
	@ManyToOne()
	@JoinColumn(name="USERID")
	@JSONField(serialize=false)
	private UserInfo userInfo;
	
	@Column(name="articleName")
	private String articleName;
	
	@OneToMany(mappedBy="article",cascade={CascadeType.ALL},orphanRemoval=true,fetch=FetchType.LAZY)
	private List<Attachment> attachements;
	
	
	
	
}
