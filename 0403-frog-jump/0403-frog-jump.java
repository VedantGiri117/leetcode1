class Solution {
    public boolean canCross(int[] stones) {
        // Map: stone position -> set of jump sizes that landed on it
        Map<Integer, Set<Integer>> mp = new HashMap<>();

        // Initialize stone 1 as reachable with a jump of 1
        Set<Integer> initialJumps = new HashSet<>();
        initialJumps.add(1);
        mp.put(1, initialJumps);

        for (int i = 1; i < stones.length; i++) {
            int currentStone = stones[i];

            // If the frog can never reach this stone, skip it
            if (!mp.containsKey(currentStone)) {
                continue;
            }

            // Copy the set to safely iterate over it
            Set<Integer> jumps = new HashSet<>(mp.get(currentStone));

            for (int jumpSize : jumps) {
                // Branch 1: jump of size k
                int nextPos1 = currentStone + jumpSize;
                if (!mp.containsKey(nextPos1)) {
                    mp.put(nextPos1, new HashSet<>());
                }
                mp.get(nextPos1).add(jumpSize);

                // Branch 2: jump of size k + 1
                int nextPos2 = currentStone + jumpSize + 1;
                if (!mp.containsKey(nextPos2)) {
                    mp.put(nextPos2, new HashSet<>());
                }
                mp.get(nextPos2).add(jumpSize + 1);

                // Branch 3: jump of size k - 1 (must be > 0)
                if (jumpSize - 1 > 0) {
                    int nextPos3 = currentStone + jumpSize - 1;
                    if (!mp.containsKey(nextPos3)) {
                        mp.put(nextPos3, new HashSet<>());
                    }
                    mp.get(nextPos3).add(jumpSize - 1);
                }
            }
        }

        int lastStone = stones[stones.length - 1];
        return mp.containsKey(lastStone) && !mp.get(lastStone).isEmpty();
    }
}