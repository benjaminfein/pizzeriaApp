package com.example.pizzeriaapp.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity//указывает что это сущность, тем самым ее аргументы являются столбцами таблицы данных
@Table(name = "products")//название таблицы
@Data//добавляет необходимое в класс сущности, а это - getter, setter, toString(), equals()
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id//указывает что данное поле - id
    @GeneratedValue(strategy = GenerationType.AUTO)//указывает что id будет автогенерируемым
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")//columnDefinition меняет тип данных, по умолчанию стоит varchar
    private String description;
    @Column(name = "price")
    private int price;
}
