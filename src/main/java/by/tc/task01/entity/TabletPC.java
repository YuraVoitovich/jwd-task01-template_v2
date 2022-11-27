package by.tc.task01.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TabletPC extends Appliance {
    private Integer BATTERY_CAPACITY;
    private Integer DISPLAY_INCHES;
    private Integer MEMORY_ROM;
    private Integer FLASH_MEMORY_CAPACITY;
    private String COLOR;
}
