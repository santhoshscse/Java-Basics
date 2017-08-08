package common;

import java.util.HashMap;

class Tree {
	public int x;
	public Tree l;
	public Tree r;
}

public class TreeTraverse {
	HashMap<Integer, Integer> map = new HashMap<>();
	int max = 0;

	public static void main(String[] args) {
		TreeTraverse prob = new TreeTraverse();
		System.out.println(prob.solution(null));
		Tree t1 = new Tree();
		t1.x = 1;
		System.out.println(prob.solution(t1));
		t1.l = new Tree();
		t1.l.x = 1;
		System.out.println(prob.solution(t1));
		t1.l.x = 1;
		System.out.println(prob.solution(t1));
		t1.l.l = new Tree();
		t1.l.l.x = 1;
		System.out.println(prob.solution(t1));
		t1.l.l.l = new Tree();
		t1.l.l.l.x = 1;
		System.out.println(prob.solution(t1));
		t1.l.r = new Tree();
		t1.l.r.x = 1;
		System.out.println(prob.solution(null));
	}

	public int solution(Tree t) {
		max = 0;
		travese(t, 0);
		return max;
	}

	private void travese(Tree t, int count) {
		if (t == null) {
			if (count > max) {
				max = count;
			}
			return;
		}
		if (map.containsKey(t.x) && map.get(t.x) != 0) {
			map.put(t.x, map.get(t.x) + 1);
		} else {
			map.put(t.x, 1);
			count += 1;
		}
		travese(t.l, count);
		travese(t.r, count);
		map.put(t.x, map.get(t.x) - 1);
	}
}
