package samples.demo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author bill
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("company")
public class CompanyPO {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("address")
    private String address;

    @TableField("salary")
    private Double salary;
}
