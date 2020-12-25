package com.rubanelearning.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -7482375225107139573L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATE_TIMESTAMP")
	private Date createTimestamp;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATE_TIMESTAMP")
	private Date updateTimestamp;

	@Column(name = "MODIFY_REMARKS")
	private String modifyRemarks;

	@PrePersist
	@PreUpdate
	public void updateAuditFields() {
		Calendar calendar = Calendar.getInstance();
		if (getCreateTimestamp() == null) {
			setCreateTimestamp(calendar.getTime());
		}

		setUpdateTimestamp(calendar.getTime());
	}

}