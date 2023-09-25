package od;

import java.util.Scanner;

/**
 * @author Administrator
 * @description
 * @since 2023/8/15 11:52
 **/

/*
*
* 有一个特殊的5键键盘，上面有a，ctrl-c，ctrl-x，ctrlv，ctrl-a五个键
    a键在屏幕上输出一个字母a;c-c将当前洗择的字母复制到剪板;c-x将当前选择的字母复制到剪板，并清空选择的字母，c-v将当前剪贴贴板里的字母输出到屏幕， ctrl-a选择当前屏幕上的所有字母
注意:
1.剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
2.当屏幕上没有字母时，ctrl-a无效，
3.当没有选择字母时，ctr-c和ctrl-x无效
4.当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出
给定一系列键盘输入，输出最终屏幕上字母的数量

输入描述
输入为一行，为简化解析，用数字1 2 3 4 5代表a，ctrl-c，ctr-x，ctrl-v，ctr-a五个键的输入，数字用空格分隔

输出一个数字，为最终屏幕上字母的数量。
* */
public class Keyboard_5 {

    // 字符串
    private static String key = "";
    // 剪贴板
    private static String cv = "";
    // 选中
    private static String ca = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            input(Integer.parseInt(arr[i]));
        }
        System.out.println(key.length());
    }


    public static void input(int num) {
        switch (num) {
            case 1:
                if (ca.equals("")) {
                    key += 'a';
                } else {
                    ca = "";
                    key = "a";
                }
                break;
            case 2:
                cv = ca;
                break;
            case 3:
                cv = ca;
                ca = "";
                cv = "";
                break;
            case 4:
                if (ca.equals("")) {
                    key += cv;
                } else {
                    key = cv;
                    ca = "";
                }

                break;
            case 5:
                ca = key;
                break;

        }
    }

}
