package com.codeid.ushopay.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="product_images",schema = "oe")
public class ProductImages extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private Integer prodImId;

    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "file_size")
    private float fileSize;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_uri")
    private String fileUri;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;    
}