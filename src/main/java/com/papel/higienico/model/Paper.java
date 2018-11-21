package com.papel.higienico.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.io.Serializable;

@Entity
@Table(name = "papel_higienico")
@EntityListeners(AuditingEntityListener.class)
public class Paper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String description;

    public String getBrand() {
    	return this.brand;
    }
    public void setBrand(String text) {
    	this.brand= text;
    }
    public String getDescription() {
    	return this.description;
    }
    public void setDescription(String text) {
    	this.description= text;
    }
}
