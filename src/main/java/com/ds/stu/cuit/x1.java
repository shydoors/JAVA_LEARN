package com.ds.stu.cuit;
import javax.swing.*;
/**
 * 监听事件所用的库
 * */
public class x1{
    public static void main(String[] args) {
        JFrame win = new JFrame("登录界面");
        JPanel panel = new JPanel();//添加画布
        win.add(panel);//将画布放在控制框上
        JButton btn = new JButton("登录");
/**        btn.addActionListener(new ActionListener() {
 *         @Override
 *         public void actionPerformed(ActionEvent e) {
 *         JOptionPane.showMessageDialog(win,"周航真帅！");
 *           }
 *           });
 */
          btn.addActionListener(e -> JOptionPane.showMessageDialog(win,"周航真帅！"));
/**这两个代码是一样的，都是匿名类*/

        panel.add(btn);
        win.setSize(400, 400);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);/**关闭窗户时退出程序 */
        win.setVisible(true);
    }
}