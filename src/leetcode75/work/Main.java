package leetcode75.work;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Option> options = new ArrayList<>();
        Option option = new Option(UUID.fromString("230a96a7-1e22-49d3-b631-016cba2df95d"), null, 1.0);
        Option childOption = new Option(UUID.fromString("230a96a7-1e22-49d3-b631-016cba2df96d"), UUID.fromString("230a96a7-1e22-49d3-b631-016cba2df95d"), 2.0);
        Option childChildOption = new Option(UUID.fromString("230a96a7-1e22-49d3-b631-016cba2df86d"), UUID.fromString("230a96a7-1e22-49d3-b631-016cba2df96d"), 3.0);
        options.add(option);
        options.add(childOption);
        options.add(childChildOption);
//        getLastOption(options);
//        System.out.println(calculatePriceOfLastOptionWithParents(options));
    }

    private static Option getLastOption(final List<Option> options) {
        Set<UUID> parents = new HashSet<>();

        for (Option option : options) {
            if (option.parentId() != null) {
                parents.add(option.parentId());
            }
        }

        Option lastChildWithParent = null;

        for (Option option : options) {
            if (!parents.contains(option.id())) {
                lastChildWithParent = option;
            }
        }
        return lastChildWithParent;
    }

    private static Option calculatePriceOfLastOption(final List<Option> options) {
        if (options.size() == 1) {
            return options.get(0);
        }
        Map<UUID, Option> pricesMap = new HashMap<>();
        Double totalPrice = 0.0;
        for (Option option : options) {
            pricesMap.put(option.id(), option);
        }

        Option lastChildWithParent = null;
        Set<UUID> parents = new HashSet<>();
        for (Option option : options) {
            if (option.parentId() != null) {
                parents.add(option.parentId());
            }
            if (!parents.contains(option.id())) {
                lastChildWithParent = option;
            }
        }

        if (lastChildWithParent != null) {
            totalPrice = pricesMap.get(lastChildWithParent.id()).price();

            UUID parentId = lastChildWithParent.parentId();
            while (parentId != null && pricesMap.containsKey(parentId)) {
                Option parent = pricesMap.get(parentId);
                totalPrice += parent.price();
                parentId = parent.parentId();
            }
            return new Option(lastChildWithParent.id(), lastChildWithParent.parentId(), totalPrice);
        }
        return null;
    }

    private static UUID getParentId(Set<UUID> parents, UUID childId) {
        for (UUID parentId : parents) {
            if (childId.equals(parentId)) {
                return parentId;
            }
        }
        return null;
    }
}
