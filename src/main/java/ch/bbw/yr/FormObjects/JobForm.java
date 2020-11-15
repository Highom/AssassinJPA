/**
 * @Author: Yannick Ruck
 * @Date: 15/11/2020
 */
package ch.bbw.yr.FormObjects;

import java.util.List;
import java.util.stream.Collectors;

public class JobForm {
    private String assassin;
    private String target;
    private List<String> weaponsUsed;
    private List<String> _weaponsUsed;

    public int getAssassin() {
        return Integer.parseInt(assassin);
    }

    public int getTarget() {
        return Integer.parseInt(target);
    }

    public List<Integer> getWeaponsUsed() {
        return weaponsUsed.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
