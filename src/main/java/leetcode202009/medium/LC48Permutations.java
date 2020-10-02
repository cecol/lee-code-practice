package leetcode202009.medium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class LC48Permutations {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        var LC = new LC48Permutations();
        var r = LC.permute(new int[]{1, 2, 3});
        for (List<Integer> i : r) System.out.println(i.stream().map(Object::toString).collect(Collectors.joining(",")));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        per(r, Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<Integer>());
        return r;
    }

    public void per(List<List<Integer>> r, List<Integer> rest, List<Integer> concat) {
        if (rest.isEmpty()) {
            r.add(new ArrayList<>(concat));
        } else {
            for (int i = 0; i < rest.size(); i++) {
                Integer e = rest.remove(i);
                concat.add(e);
                per(r, rest, concat);
                rest.add(i, e);
                concat.remove(concat.size() - 1);
            }
        }
    }
}
