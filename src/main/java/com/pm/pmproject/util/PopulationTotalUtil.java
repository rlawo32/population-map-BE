package com.pm.pmproject.util;

import com.pm.pmproject.dto.*;

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

    public static Long populationTotal20s(String gender, List<Population20sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM20() + list.get(i).getPopAgeM21() + list.get(i).getPopAgeM22() +
                    list.get(i).getPopAgeM23() + list.get(i).getPopAgeM24() + list.get(i).getPopAgeM25() +
                    list.get(i).getPopAgeM26() + list.get(i).getPopAgeM27() + list.get(i).getPopAgeM28() +
                    list.get(i).getPopAgeM29();
        } else {
            result = list.get(i).getPopAgeW20() + list.get(i).getPopAgeW21() + list.get(i).getPopAgeW22() +
                    list.get(i).getPopAgeW23() + list.get(i).getPopAgeW24() + list.get(i).getPopAgeW25() +
                    list.get(i).getPopAgeW26() + list.get(i).getPopAgeW27() + list.get(i).getPopAgeW28() +
                    list.get(i).getPopAgeW29();
        }

        return result;
    }

    public static Long populationTotal30s(String gender, List<Population30sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM30() + list.get(i).getPopAgeM31() + list.get(i).getPopAgeM32() +
                    list.get(i).getPopAgeM33() + list.get(i).getPopAgeM34() + list.get(i).getPopAgeM35() +
                    list.get(i).getPopAgeM36() + list.get(i).getPopAgeM37() + list.get(i).getPopAgeM38() +
                    list.get(i).getPopAgeM39();
        } else {
            result = list.get(i).getPopAgeW30() + list.get(i).getPopAgeW31() + list.get(i).getPopAgeW32() +
                    list.get(i).getPopAgeW33() + list.get(i).getPopAgeW34() + list.get(i).getPopAgeW35() +
                    list.get(i).getPopAgeW36() + list.get(i).getPopAgeW37() + list.get(i).getPopAgeW38() +
                    list.get(i).getPopAgeW39();
        }

        return result;
    }

    public static Long populationTotal40s(String gender, List<Population40sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM40() + list.get(i).getPopAgeM41() + list.get(i).getPopAgeM42() +
                    list.get(i).getPopAgeM43() + list.get(i).getPopAgeM44() + list.get(i).getPopAgeM45() +
                    list.get(i).getPopAgeM46() + list.get(i).getPopAgeM47() + list.get(i).getPopAgeM48() +
                    list.get(i).getPopAgeM49();
        } else {
            result = list.get(i).getPopAgeW40() + list.get(i).getPopAgeW41() + list.get(i).getPopAgeW42() +
                    list.get(i).getPopAgeW43() + list.get(i).getPopAgeW44() + list.get(i).getPopAgeW45() +
                    list.get(i).getPopAgeW46() + list.get(i).getPopAgeW47() + list.get(i).getPopAgeW48() +
                    list.get(i).getPopAgeW49();
        }

        return result;
    }

    public static Long populationTotal50s(String gender, List<Population50sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM50() + list.get(i).getPopAgeM51() + list.get(i).getPopAgeM52() +
                    list.get(i).getPopAgeM53() + list.get(i).getPopAgeM54() + list.get(i).getPopAgeM55() +
                    list.get(i).getPopAgeM56() + list.get(i).getPopAgeM57() + list.get(i).getPopAgeM58() +
                    list.get(i).getPopAgeM59();
        } else {
            result = list.get(i).getPopAgeW50() + list.get(i).getPopAgeW51() + list.get(i).getPopAgeW52() +
                    list.get(i).getPopAgeW53() + list.get(i).getPopAgeW54() + list.get(i).getPopAgeW55() +
                    list.get(i).getPopAgeW56() + list.get(i).getPopAgeW57() + list.get(i).getPopAgeW58() +
                    list.get(i).getPopAgeW59();
        }

        return result;
    }

    public static Long populationTotal60s(String gender, List<Population60sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM60() + list.get(i).getPopAgeM61() + list.get(i).getPopAgeM62() +
                    list.get(i).getPopAgeM63() + list.get(i).getPopAgeM64() + list.get(i).getPopAgeM65() +
                    list.get(i).getPopAgeM66() + list.get(i).getPopAgeM67() + list.get(i).getPopAgeM68() +
                    list.get(i).getPopAgeM69();
        } else {
            result = list.get(i).getPopAgeW60() + list.get(i).getPopAgeW61() + list.get(i).getPopAgeW62() +
                    list.get(i).getPopAgeW63() + list.get(i).getPopAgeW64() + list.get(i).getPopAgeW65() +
                    list.get(i).getPopAgeW66() + list.get(i).getPopAgeW67() + list.get(i).getPopAgeW68() +
                    list.get(i).getPopAgeW69();
        }

        return result;
    }

    public static Long populationTotal70s(String gender, List<Population70sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM70() + list.get(i).getPopAgeM71() + list.get(i).getPopAgeM72() +
                    list.get(i).getPopAgeM73() + list.get(i).getPopAgeM74() + list.get(i).getPopAgeM75() +
                    list.get(i).getPopAgeM76() + list.get(i).getPopAgeM77() + list.get(i).getPopAgeM78() +
                    list.get(i).getPopAgeM79();
        } else {
            result = list.get(i).getPopAgeW70() + list.get(i).getPopAgeW71() + list.get(i).getPopAgeW72() +
                    list.get(i).getPopAgeW73() + list.get(i).getPopAgeW74() + list.get(i).getPopAgeW75() +
                    list.get(i).getPopAgeW76() + list.get(i).getPopAgeW77() + list.get(i).getPopAgeW78() +
                    list.get(i).getPopAgeW79();
        }

        return result;
    }

    public static Long populationTotal80s(String gender, List<Population80sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM80() + list.get(i).getPopAgeM81() + list.get(i).getPopAgeM82() +
                    list.get(i).getPopAgeM83() + list.get(i).getPopAgeM84() + list.get(i).getPopAgeM85() +
                    list.get(i).getPopAgeM86() + list.get(i).getPopAgeM87() + list.get(i).getPopAgeM88() +
                    list.get(i).getPopAgeM89();
        } else {
            result = list.get(i).getPopAgeW80() + list.get(i).getPopAgeW81() + list.get(i).getPopAgeW82() +
                    list.get(i).getPopAgeW83() + list.get(i).getPopAgeW84() + list.get(i).getPopAgeW85() +
                    list.get(i).getPopAgeW86() + list.get(i).getPopAgeW87() + list.get(i).getPopAgeW88() +
                    list.get(i).getPopAgeW89();
        }

        return result;
    }

    public static Long populationTotal90s(String gender, List<Population90sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM90() + list.get(i).getPopAgeM91() + list.get(i).getPopAgeM92() +
                    list.get(i).getPopAgeM93() + list.get(i).getPopAgeM94() + list.get(i).getPopAgeM95() +
                    list.get(i).getPopAgeM96() + list.get(i).getPopAgeM97() + list.get(i).getPopAgeM98() +
                    list.get(i).getPopAgeM99();
        } else {
            result = list.get(i).getPopAgeW90() + list.get(i).getPopAgeW91() + list.get(i).getPopAgeW92() +
                    list.get(i).getPopAgeW93() + list.get(i).getPopAgeW94() + list.get(i).getPopAgeW95() +
                    list.get(i).getPopAgeW96() + list.get(i).getPopAgeW97() + list.get(i).getPopAgeW98() +
                    list.get(i).getPopAgeW99();
        }

        return result;
    }

    public static Long populationTotal100s(String gender, List<Population100sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAgeM100() + list.get(i).getPopAgeM101() + list.get(i).getPopAgeM102() +
                    list.get(i).getPopAgeM103() + list.get(i).getPopAgeM104() + list.get(i).getPopAgeM105() +
                    list.get(i).getPopAgeM106() + list.get(i).getPopAgeM107() + list.get(i).getPopAgeM108() +
                    list.get(i).getPopAgeM109();
        } else {
            result = list.get(i).getPopAgeW100() + list.get(i).getPopAgeW101() + list.get(i).getPopAgeW102() +
                    list.get(i).getPopAgeW103() + list.get(i).getPopAgeW104() + list.get(i).getPopAgeW105() +
                    list.get(i).getPopAgeW106() + list.get(i).getPopAgeW107() + list.get(i).getPopAgeW108() +
                    list.get(i).getPopAgeW109();
        }

        return result;
    }
}
