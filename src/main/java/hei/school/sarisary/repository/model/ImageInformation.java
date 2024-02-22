package hei.school.sarisary.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "image_info")
@Entity

public class ImageInformation {
    @Id
    private String id;
    @Column(name = "original_url")
    private String originalUrl;
    @Column(name = "transformed_url")
    private String transformedUrl;
}
