package com.panda.sys.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="SYS_ATTACHEMENT")
public class Attachment {

	@Id
	@Column(name="ATTACHMENTID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="seq_attachement")
	@TableGenerator( name = "seq_attachement",pkColumnValue="seq_attachement",allocationSize=1,initialValue=1000000001,
	table = "hibernate_sequence", pkColumnName = "seq_name", valueColumnName = "next_val")
	private int attachmentId;
	
	@ManyToOne()
	@JoinColumn(name="ARTICLEID")
	@JSONField(serialize=false)
	private Article article;
	
	@Column(name="ATTACHMENTNAME")
	private String attachmentName;
}
