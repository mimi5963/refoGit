package com.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestInsertFormVO {
    private Long id;
    private String name;
    private String address;

    //menu와 연관관계
    private List<RestaurantMenuVO> menus;

    public RestInsertFormVO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setMenuRestId() {
        this.menus.forEach((menu) -> {
            menu.setRestaurantId(this.id);
        });
    }
}
