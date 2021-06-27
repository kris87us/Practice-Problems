package learn.sorting;

import java.util.*;

public class FindDuplicateInFileSystem {
    public static void main(String[] args) {
        System.out.print(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));
    }
    public static List<List<String>> findDuplicate(String[] paths) {
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
            res.add(map.get(s));
        }
        return res;
    }
}
