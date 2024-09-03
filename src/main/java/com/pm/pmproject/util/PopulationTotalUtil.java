package com.pm.pmproject.util;

import com.pm.pmproject.dto.*;

import java.util.List;

public class PopulationTotalUtil {

    public static Long populationTotal0s(String gender, List<Population0sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge0M() + list.get(i).getPopAge1M() + list.get(i).getPopAge2M() +
                    list.get(i).getPopAge3M() + list.get(i).getPopAge4M() + list.get(i).getPopAge5M() +
                    list.get(i).getPopAge6M() + list.get(i).getPopAge7M() + list.get(i).getPopAge8M() +
                    list.get(i).getPopAge9M();
        } else {
            result = list.get(i).getPopAge0W() + list.get(i).getPopAge1W() + list.get(i).getPopAge2W() +
                    list.get(i).getPopAge3W() + list.get(i).getPopAge4W() + list.get(i).getPopAge5W() +
                    list.get(i).getPopAge6W() + list.get(i).getPopAge7W() + list.get(i).getPopAge8W() +
                    list.get(i).getPopAge9W();
        }

        return result;
    }

    public static Long populationTotal10s(String gender, List<Population10sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge10M() + list.get(i).getPopAge11M() + list.get(i).getPopAge12M() +
                    list.get(i).getPopAge13M() + list.get(i).getPopAge14M() + list.get(i).getPopAge15M() +
                    list.get(i).getPopAge16M() + list.get(i).getPopAge17M() + list.get(i).getPopAge18M() +
                    list.get(i).getPopAge19M();
        } else {
            result = list.get(i).getPopAge10W() + list.get(i).getPopAge11W() + list.get(i).getPopAge12W() +
                    list.get(i).getPopAge13W() + list.get(i).getPopAge14W() + list.get(i).getPopAge15W() +
                    list.get(i).getPopAge16W() + list.get(i).getPopAge17W() + list.get(i).getPopAge18W() +
                    list.get(i).getPopAge19W();
        }

        return result;
    }

    public static Long populationTotal20s(String gender, List<Population20sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge20M() + list.get(i).getPopAge21M() + list.get(i).getPopAge22M() +
                    list.get(i).getPopAge23M() + list.get(i).getPopAge24M() + list.get(i).getPopAge25M() +
                    list.get(i).getPopAge26M() + list.get(i).getPopAge27M() + list.get(i).getPopAge28M() +
                    list.get(i).getPopAge29M();
        } else {
            result = list.get(i).getPopAge20W() + list.get(i).getPopAge21W() + list.get(i).getPopAge22W() +
                    list.get(i).getPopAge23W() + list.get(i).getPopAge24W() + list.get(i).getPopAge25W() +
                    list.get(i).getPopAge26W() + list.get(i).getPopAge27W() + list.get(i).getPopAge28W() +
                    list.get(i).getPopAge29W();
        }

        return result;
    }

    public static Long populationTotal30s(String gender, List<Population30sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge30M() + list.get(i).getPopAge31M() + list.get(i).getPopAge32M() +
                    list.get(i).getPopAge33M() + list.get(i).getPopAge34M() + list.get(i).getPopAge35M() +
                    list.get(i).getPopAge36M() + list.get(i).getPopAge37M() + list.get(i).getPopAge38M() +
                    list.get(i).getPopAge39M();
        } else {
            result = list.get(i).getPopAge30W() + list.get(i).getPopAge31W() + list.get(i).getPopAge32W() +
                    list.get(i).getPopAge33W() + list.get(i).getPopAge34W() + list.get(i).getPopAge35W() +
                    list.get(i).getPopAge36W() + list.get(i).getPopAge37W() + list.get(i).getPopAge38W() +
                    list.get(i).getPopAge39W();
        }

        return result;
    }

    public static Long populationTotal40s(String gender, List<Population40sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge40M() + list.get(i).getPopAge41M() + list.get(i).getPopAge42M() +
                    list.get(i).getPopAge43M() + list.get(i).getPopAge44M() + list.get(i).getPopAge45M() +
                    list.get(i).getPopAge46M() + list.get(i).getPopAge47M() + list.get(i).getPopAge48M() +
                    list.get(i).getPopAge49M();
        } else {
            result = list.get(i).getPopAge40W() + list.get(i).getPopAge41W() + list.get(i).getPopAge42W() +
                    list.get(i).getPopAge43W() + list.get(i).getPopAge44W() + list.get(i).getPopAge45W() +
                    list.get(i).getPopAge46W() + list.get(i).getPopAge47W() + list.get(i).getPopAge48W() +
                    list.get(i).getPopAge49W();
        }

        return result;
    }

    public static Long populationTotal50s(String gender, List<Population50sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge50M() + list.get(i).getPopAge51M() + list.get(i).getPopAge52M() +
                    list.get(i).getPopAge53M() + list.get(i).getPopAge54M() + list.get(i).getPopAge55M() +
                    list.get(i).getPopAge56M() + list.get(i).getPopAge57M() + list.get(i).getPopAge58M() +
                    list.get(i).getPopAge59M();
        } else {
            result = list.get(i).getPopAge50W() + list.get(i).getPopAge51W() + list.get(i).getPopAge52W() +
                    list.get(i).getPopAge53W() + list.get(i).getPopAge54W() + list.get(i).getPopAge55W() +
                    list.get(i).getPopAge56W() + list.get(i).getPopAge57W() + list.get(i).getPopAge58W() +
                    list.get(i).getPopAge59W();
        }

        return result;
    }

    public static Long populationTotal60s(String gender, List<Population60sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge60M() + list.get(i).getPopAge61M() + list.get(i).getPopAge62M() +
                    list.get(i).getPopAge63M() + list.get(i).getPopAge64M() + list.get(i).getPopAge65M() +
                    list.get(i).getPopAge66M() + list.get(i).getPopAge67M() + list.get(i).getPopAge68M() +
                    list.get(i).getPopAge69M();
        } else {
            result = list.get(i).getPopAge60W() + list.get(i).getPopAge61W() + list.get(i).getPopAge62W() +
                    list.get(i).getPopAge63W() + list.get(i).getPopAge64W() + list.get(i).getPopAge65W() +
                    list.get(i).getPopAge66W() + list.get(i).getPopAge67W() + list.get(i).getPopAge68W() +
                    list.get(i).getPopAge69W();
        }

        return result;
    }

    public static Long populationTotal70s(String gender, List<Population70sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge70M() + list.get(i).getPopAge71M() + list.get(i).getPopAge72M() +
                    list.get(i).getPopAge73M() + list.get(i).getPopAge74M() + list.get(i).getPopAge75M() +
                    list.get(i).getPopAge76M() + list.get(i).getPopAge77M() + list.get(i).getPopAge78M() +
                    list.get(i).getPopAge79M();
        } else {
            result = list.get(i).getPopAge70W() + list.get(i).getPopAge71W() + list.get(i).getPopAge72W() +
                    list.get(i).getPopAge73W() + list.get(i).getPopAge74W() + list.get(i).getPopAge75W() +
                    list.get(i).getPopAge76W() + list.get(i).getPopAge77W() + list.get(i).getPopAge78W() +
                    list.get(i).getPopAge79W();
        }

        return result;
    }

    public static Long populationTotal80s(String gender, List<Population80sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge80M() + list.get(i).getPopAge81M() + list.get(i).getPopAge82M() +
                    list.get(i).getPopAge83M() + list.get(i).getPopAge84M() + list.get(i).getPopAge85M() +
                    list.get(i).getPopAge86M() + list.get(i).getPopAge87M() + list.get(i).getPopAge88M() +
                    list.get(i).getPopAge89M();
        } else {
            result = list.get(i).getPopAge80W() + list.get(i).getPopAge81W() + list.get(i).getPopAge82W() +
                    list.get(i).getPopAge83W() + list.get(i).getPopAge84W() + list.get(i).getPopAge85W() +
                    list.get(i).getPopAge86W() + list.get(i).getPopAge87W() + list.get(i).getPopAge88W() +
                    list.get(i).getPopAge89W();
        }

        return result;
    }

    public static Long populationTotal90s(String gender, List<Population90sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge90M() + list.get(i).getPopAge91M() + list.get(i).getPopAge92M() +
                    list.get(i).getPopAge93M() + list.get(i).getPopAge94M() + list.get(i).getPopAge95M() +
                    list.get(i).getPopAge96M() + list.get(i).getPopAge97M() + list.get(i).getPopAge98M() +
                    list.get(i).getPopAge99M();
        } else {
            result = list.get(i).getPopAge90W() + list.get(i).getPopAge91W() + list.get(i).getPopAge92W() +
                    list.get(i).getPopAge93W() + list.get(i).getPopAge94W() + list.get(i).getPopAge95W() +
                    list.get(i).getPopAge96W() + list.get(i).getPopAge97W() + list.get(i).getPopAge98W() +
                    list.get(i).getPopAge99W();
        }

        return result;
    }

    public static Long populationTotal100s(String gender, List<Population100sDto> list, int i) {
        Long result;

        if(gender.equals("M")) {
            result = list.get(i).getPopAge100M() + list.get(i).getPopAge101M() + list.get(i).getPopAge102M() +
                    list.get(i).getPopAge103M() + list.get(i).getPopAge104M() + list.get(i).getPopAge105M() +
                    list.get(i).getPopAge106M() + list.get(i).getPopAge107M() + list.get(i).getPopAge108M() +
                    list.get(i).getPopAge109M();
        } else {
            result = list.get(i).getPopAge100W() + list.get(i).getPopAge101W() + list.get(i).getPopAge102W() +
                    list.get(i).getPopAge103W() + list.get(i).getPopAge104W() + list.get(i).getPopAge105W() +
                    list.get(i).getPopAge106W() + list.get(i).getPopAge107W() + list.get(i).getPopAge108W() +
                    list.get(i).getPopAge109W();
        }

        return result;
    }
}
