package com.panda.app.po;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
/*@Entity
@Table(name="APP_FILE")*/
public class UserFile {
	@Id
	@Column(name="USERFILEID")
    @GeneratedValue(generator = "assignedGenerator")
    @GenericGenerator(name = "assignedGenerator", strategy = "assigned") 
	int userfileId;
	@Column(name="FILENAME")
	String fileName;
}
