package thread.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: zly
 * @Version: V1.0.0
 * @Since: 1.0
 * @Date: 2022/5/14
 */
@Data
@NoArgsConstructor
public class WindowsSellTicket {
    private int count;

    public WindowsSellTicket(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public synchronized int sellTicket(int amount){
        if (this.count>=amount){
            this.count -=amount;
            return amount;
        }else {
            return 0;
        }
    }

}
