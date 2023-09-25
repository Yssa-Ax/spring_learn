package od;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * @description 1/N 2/N 3/Y 4/N 5/Y
 * @since 2023/8/17 9:14
 **/
public class DivideClasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        String msg = "";
        int per = 0;


        for (int i = 0; i < arr.length; i++) {
            String info = arr[i];
            if (!info.contains("/")) {
                msg = "ERROR";
                break;
            }
            String[] infos = info.split("/");
            int no = Integer.parseInt(infos[0]);
            String flag = infos[1];

            if (i == 0) {
                a.add(no);
                continue;
            }

            String[] perInfos = arr[per].split("/");
            int perNo = Integer.parseInt(perInfos[0]);

            per++;
            boolean contains = a.contains(perNo);

            if ("N".equals(flag)) {
                if (contains) {
                    b.add(no);
                    continue;
                }
                a.add(no);
            } else {
                if (contains) {
                    a.add(no);
                    continue;
                }
                b.add(no);
            }

        }

        if ("".equals(msg)) {
            System.out.println(a);
            System.out.println(b);
        } else {
            System.out.println(msg);
        }

    }

}
