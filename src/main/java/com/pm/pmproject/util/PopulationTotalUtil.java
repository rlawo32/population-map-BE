package com.pm.pmproject.util;

import com.pm.pmproject.dto.Population0sDto;
import com.pm.pmproject.dto.Population10sDto;

import java.util.List;

public class PopulationTotalUtil {

    public static Long populationTotal0s(String gender, List<Population0sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM0() + list.get(i).getPopAgeM1() + list.get(i).getPopAgeM2() +
                    list.get(i).getPopAgeM3() + list.get(i).getPopAgeM4() + list.get(i).getPopAgeM5() +
                    list.get(i).getPopAgeM6() + list.get(i).getPopAgeM7() + list.get(i).getPopAgeM8() +
                    list.get(i).getPopAgeM9();
        } else {
            result = list.get(i).getPopAgeW0() + list.get(i).getPopAgeW1() + list.get(i).getPopAgeW2() +
                    list.get(i).getPopAgeW3() + list.get(i).getPopAgeW4() + list.get(i).getPopAgeW5() +
                    list.get(i).getPopAgeW6() + list.get(i).getPopAgeW7() + list.get(i).getPopAgeW8() +
                    list.get(i).getPopAgeW9();
        }

        return result;
    }

    public static Long populationTotal10s(String gender, List<Population10sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM10() + list.get(i).getPopAgeM11() + list.get(i).getPopAgeM12() +
                    list.get(i).getPopAgeM13() + list.get(i).getPopAgeM14() + list.get(i).getPopAgeM15() +
                    list.get(i).getPopAgeM16() + list.get(i).getPopAgeM17() + list.get(i).getPopAgeM18() +
                    list.get(i).getPopAgeM19();
        } else {
            result = list.get(i).getPopAgeW10() + list.get(i).getPopAgeW11() + list.get(i).getPopAgeW12() +
                    list.get(i).getPopAgeW13() + list.get(i).getPopAgeW14() + list.get(i).getPopAgeW15() +
                    list.get(i).getPopAgeW16() + list.get(i).getPopAgeW17() + list.get(i).getPopAgeW18() +
                    list.get(i).getPopAgeW19();
        }

        return result;
    }
}
