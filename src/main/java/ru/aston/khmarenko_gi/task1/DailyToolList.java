package ru.aston.khmarenko_gi.task1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DailyToolList implements ToolCalculation {

    private final List<Tool> toolList;

    private final BigDecimal INIT_SUM;

    DailyToolList(List<Tool> toolList, BigDecimal INIT_SUM) {
        this.toolList = toolList;
        this.INIT_SUM = INIT_SUM;
    }

    @Override
    public BigDecimal calcDailyAmount(BigDecimal counter) {
        BigDecimal k = INIT_SUM;
        for (Tool tool : toolList) {
            k = k.add(tool.getServicePrice());
        }
        return k;
    }

    @Override
    public String toString() {
        List<String> listSorted = new ArrayList<>();
        for (Tool tool : toolList) {
            listSorted.add(tool.getUser().getSourName() + " " + tool.getUser().getName() + " Id: " +
                    tool.getId() + " price: " + tool.getServicePrice());
        }
        Collections.sort(listSorted);
        return listSorted.toString();
    }
}
