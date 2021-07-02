package learn.hashmap;

import java.util.*;

public class FindDuplicateFiles {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : paths) {
            String[] dir_files_arr = s.split(" ");
            for (int i = 1; i< dir_files_arr.length; i++) {
                String dir = dir_files_arr[0];

                String content = dir_files_arr[i].split("\\(")[1];
                String content_clean = content.replace(")", "");
                String fileNameWithPath = dir + "/" + dir_files_arr[i].split("\\(")[0];

                if (map.containsKey(content_clean)) {
                    map.get(content_clean).add(fileNameWithPath);
                } else {
                    map.put(content_clean, new ArrayList<>(Collections.singletonList(fileNameWithPath)));
                }
            }
        }

        System.out.println(map);
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1) {
                res.add(map.get(s));
            }
        }
        return res;
    }
}
