package wecc.examples.springboot.rest.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@ApiModel(description = "Class representing a product")
public class Product {

    @NotBlank
    @ApiModelProperty(notes = "Unique identifier of the product", example = "CODE001", required = true)
    private String code;
    @ApiModelProperty(notes = "Name of the product", example = "Lata de coca-cola")
    private String name;
    @ApiModelProperty(notes = "Description of the product", example = "Lata de coca-cola de 33cl")
    private String description;
    @Min(0)
    @ApiModelProperty(notes = "Price of the product", example = "0.51")
    private BigDecimal price;

    public Product(String code, String name, String description, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}