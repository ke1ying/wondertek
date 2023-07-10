package com.miu.web.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author keying
 * @date 2022-12-11 11:21:03
 */
public class TerisTest  extends JFrame implements KeyListener {
    //游戏的行数26，列数12
    private static final int game_x=26,game_y=12;
    //文本域数据
    JTextArea[][] text;//text定义了每个格子是一个文本
    //二维数组
    int[][] date;//date定义了每个格子是一个值，此处规定1表示有方块，0表示无
    //游戏状态标签
    JLabel label1;
    //游戏分数标签
    JLabel label2;
    //判断游戏是否结束
    boolean isrunning;
    //用于存储所有方块的数组
    int[] allRect;
    //用于存储当前方块的变量
    int rect;
    //表示方块坐标
    int x,y;
    //线程休息时间
    int time=3000;
    //该变量用于计算得分
    int score=0;
    //定义一个标志变量，用于判断游戏是否暂停
    boolean game_pause=false;
    //定义一个变量用于记录暂停的次数
    int pause_times=0;
    public void initWindow() {
        //设置窗口大小
        this.setSize(600,850);
        //设置窗口是否可见
        this.setVisible(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置释放窗体
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小不可变
        this.setResizable(false);
        //设置标题
        this.setTitle("俄罗斯方块");
    }
    //初始化游戏界面
    public void initGamePanel() {
        JPanel game = new JPanel();//定义JPanel对象
        //调用setLayout方法来设置屏幕组件的格式布局
        game.setLayout(new GridLayout(game_x, game_y, 1, 1));//水平间距及竖直间距均为1
        //初始化面板，使用双重for循环来遍历游戏界面
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text[i].length; j++) {
                //设置文本域的行列数
                text[i][j] = new JTextArea(game_x, game_y);
                //设置文本与的背景颜色
                text[i][j].setBackground(Color.white);//设置背景为白色
                //添加键盘监听事件,需要实现keylisener接口
                text[i][j].addKeyListener(this);
                //初始化游戏边界
                if (j == 0 || j == text[i].length - 1 || i == text.length - 1) {//设置左右以及下边界
                    text[i][j].setBackground(Color.magenta);//设置边界颜色
                    date[i][j] = 1;//并令此处的date值为1，表示有方块
                }
                //设置文本域不可编辑
                text[i][j].setEditable(false);
                //文本域添加到主面板上
                game.add(text[i][j]);
            }
        }
        //将主面板添加到窗口当中
        this.setLayout(new BorderLayout());
        this.add(game,BorderLayout.CENTER);//把设置好的游戏区域添加到窗口的中心部位
    }
    public void initExplainPanel(){
        //创建游戏左说明面板
        JPanel explain_left=new JPanel();
        //创建游戏右说明面板
        JPanel explain_right=new JPanel();

        explain_left.setLayout(new GridLayout(5,1));//初始化格式布局，左侧4行一列
        explain_right.setLayout(new GridLayout(2,1));//右侧两行一列
        //初始化左说明面板
        //左侧添加说明文字
        explain_left.add(new JLabel("按空格键，方块变形"));
        explain_left.add(new JLabel("按左箭头，方块左移"));
        explain_left.add(new JLabel("按右箭头，方块右移"));
        explain_left.add(new JLabel("按下箭头，方块下落"));
        explain_left.add(new JLabel("按p暂停游戏"));
        //设置标签内容的颜色
        label1.setForeground(Color.red);
        //把游戏状态标签，游戏分数标签添加到右说明板
        explain_right.add(label1);
        explain_right.add(label2);
        //将左说明板添加到窗口左侧
        this.add(explain_left,BorderLayout.WEST);
        //将右说明板添加到窗口右侧
        this.add(explain_right,BorderLayout.EAST);
    }
    public TerisTest(){
        text=new JTextArea[game_x][game_y];//保证二维数组与图形界面大小一致
        date=new int[game_x][game_y];
        //初始化游戏状态标签
        label1=new JLabel("游戏状态：正在游戏中！");
        //初始化游戏分数标签
        label2=new JLabel("游戏得分：0");
        //初始化游戏开始的标志
        isrunning=true;
        //初始化存放方块的数组
        allRect=new int[]{0x00cc,0x8888,0x000f,0x888f,0xf888,0xf111,0x111f,0x0eee,0xffff,0x0008,0x0888,0x000e,0x0088,0x00c,0x08c8,0x00e4
                ,0x04c4,0x004e,0x08c4,0x006c,0x04c8,0x00c6};
        initGamePanel();//调用游戏界面方法,且此方法得在图形界面之前，否则无法显示。
        initExplainPanel();//调用提示面板
        initWindow();//空参构造调用初始化方法
    }
    public static void main(String[] args){

        TerisTest tertris=new TerisTest();
        // 游戏初始化
        // 游戏开始
        tertris.game_begin();
    }
    //开始游戏的方法
    public void game_begin(){
        while(true)/*由于游戏直到失败才会结束因此创建死循环*/{
            //判断游戏是否结束
            if(!isrunning){
                break;
            }
            //进行游戏
            game_run();
        }
        //在标签位置显示"游戏结束"
        label2.setText("游戏状态：游戏结束！");
    }
    //随机生成下落方块形状的方法
    public void ranRect(){
        Random random=new Random();
        rect=allRect[random.nextInt(22)];//仅需传值到22，刚好对应数组
    }
    //游戏运行方法
    public void game_run(){
        ranRect();//生成下落方块
        //方块下落位置
        x = 0;
        y = 5;
        for (int i = 0; i < game_x; i++)/*遍历整个26层*/{
            try {
                Thread.sleep(time);
                //thread.sleep源码有个throw语句抛出错误，因此需要try{}catch来承接。
                if(game_pause){
                    i--;//保持i值不变
                }else {
                    //判断方块是否可以下落
                    if (!canFall(x, y)) {
                        //将date值置为1，表示有方块占用
                        changDate(x, y);
                        //方块最多为4层，所以循环遍历4层，看是否有行可以进行消除
                        for (int j = x; j < x + 4; j++) {
                            int sum = 0;//统计多少列有方块
                            for (int k = 1; k <= (game_y - 2); k++) {
                                if (date[j][k] == 1) {
                                    sum++;
                                }
                            }
                            //判断是否有一行可以消除
                            if (sum == (game_y - 2)) {
                                removeRow(j);
                            }
                        }
                        //判断游戏是否失败
                        for (int j = 1; j <= (game_y - 2); j++) {
                            if (date[3][j] == 1) {
                                isrunning = false;
                                break;
                            }
                        }
                        break;
                    } else {
                        // 这里执行可以下落 调用fall
                        //层数+1
                        x++;
                        //方块下落一格
                        fall(x, y);
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //判断方块是否可以继续下落的方法
    public boolean canFall(int m,int n)
    /*判断方法：用0x8000的不断右移一位，来与ract中存储的图形相互比较，如果这个位置有方块，那么就去判断下一行的date值是否为1，
    如果是的话则它的下一行有方块无法下落了*/{
        int temp=0x8000;
        //遍历整个4*4方格
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if((temp&rect)!=0){
                    //判断该位置的下一行是否有方块
                    if(date[m+1][n]==1){
                        return false;
                    }
                }
                n++;
                temp>>=1;//temp右移一位
            }
            m++;
            n=n-4;//让n会到第一列
        }
        //可以下落
        return true;
    }
    //改变不可下降的方块对应的区域的值的方法
    public void changDate(int m,int n){
        int temp=0x8000;
        //遍历整个4*4的方块
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if((temp&rect)!=0){
                    date[m][n]=1;
                }
                n++;//比较先列后行的比较
                temp>>=1;
            }
            m++;
            n=n-4;
        }
    }
    //移除某一行的所有方块，并使以上方块全都掉落的方法
    public  void removeRow(int row){
        int temp=100;
        for(int i=row;i>=1;i--){
            for(int j=1;j<=(game_y-2);j++){
                //进行覆盖
                date[i][j]=date[i-1][j];
            }
        }
        //刷新游戏区域
        reflash(row);

        //方块加速
        if(time>temp){
            time-=10;
        }
        score+=temp;//没消除一层加100分
        //显示变化后的分数
        label2.setText("游戏得分："+score);
    }
    //刷新移除某一行后的游戏界面的方法
    public void reflash(int row){
        //遍历row行以上的游戏区域
        for(int i=row;i>=1;i--){
            for(int j=1;j<=(game_y-2);j++)/*减2是刨去了两边的墙壁*/{
                if(date[i][j]==1){
                    text[i][j].setBackground(Color.blue);
                }else{
                    text[i][j].setBackground(Color.white);
                }
            }
        }
    }
    //方块向下掉落一层的方法
    public void fall(int m,int n){
        if(m>0){
            //清除上一层方块
            clear(m-1,n);//由于之前在调用fall方法时层数+1，-1才是上一层坐标
        }
        //重新绘制方块
        draw(m,n);//仅需在该位置重新绘制计科
    }
    //清除方块掉落后，上一层有颜色地方的方法
    public void clear(int m,int n){
        int temp=0x8000;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if((temp&rect)!=0){
                    text[m][n].setBackground(Color.white);
                }
                n++;
                temp>>=1;
            }
            m++;
            n-=4;
        }
    }
    //重新绘制掉落后方块的方法
    public void draw(int m,int n){
        int temp=0x8000;
        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                if ((temp & rect) != 0) {
                    text[m][n].setBackground(Color.blue);
                }
                n++;
                temp>>=1;
            }
            m++;
            n-=4;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //控制游戏暂停
        if(e.getKeyChar()=='p'){
            //判断游戏是否结束
            if (!isrunning) {
                return;
            }
            pause_times++;
            //按下一次，暂停游戏
            if(pause_times==1){
                game_pause=true;
                label1.setText("游戏状态：暂停中！");
            }
            //按下两次，开始游戏
            if(pause_times==2){
                game_pause=false;
                pause_times=0;
                label1.setText("游戏状态：正在进行中！");
            }
        }
        //控制方块变形
        if( e.getKeyChar()==KeyEvent.VK_SPACE){
            //判断游戏是否结束
            if (!isrunning) {
                return;
            }
            //判断游戏是否暂停
            if(game_pause){
                return;
            }
            //定义变量来存储目前方块的索引
            int old;
            for(old=0;old<allRect.length;old++){
                //判断是否是当前方块
                if(rect==allRect[old]){
                    break;
                }
            }
            //定义变量，存储变形后的变量
            int next;
            //判断是方块
            if(old==0||old==7||old==8||old==9){
                return;
            }
            //清除当前方块
            clear(x,y);
            if(old==1||old==2){
                next=allRect[old==1?2:1];
                if(canTurn(next,x,y)){
                    rect=next;
                }
            }
            if(old>=3&&old<=6){
                next=allRect[old+1>6?3:old+1];
                if(canTurn(next,x,y)){
                    rect=next;
                }
            }
            if(old==10||old==11){
                next=allRect[old==10?11:10];
                if(canTurn(next,x,y)){
                    rect=next;
                }
            }
            if(old==12||old==13){
                next=allRect[old==12?13:12];
                if(canTurn(next,x,y)){
                    rect=next;
                }
            }
            if(old>=14&&old<=17){
                next=allRect[old+1>17?14:old+1];
                if(canTurn(next,x,y)){
                    rect=next;
                }
            }
            if(old==18||old==19){
                next=allRect[old==18?19:18];
                if(canTurn(next,x,y)){
                    rect=next;
                }
            }
            if(old==20||old==21){
                next=allRect[old==20?21:20];
                if(canTurn(next,x,y)){
                    rect=next;
                }
            }
            draw(x,y);
        }
    }
    //判断方块是否可以变形
    public boolean canTurn(int a,int m,int n){
        int temp=0x8000;
        //遍历整个方块
        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                if ((a & temp) != 0) {
                    if(date[m][n]==1){
                        return false;
                    }
                }
                n++;
                temp>>=1;
            }
            m++;
            n-=4;
        }
        //可以变形
        return true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //方块进行左移
        if (e.getKeyCode() == 37) /*小键盘对应数值为37*/{
            //帕努但游戏是否结束
            if (!isrunning) {
                return;
            }
            //判断游戏是否暂停
            if(game_pause){
                return;
            }
            //方块是否碰到左墙壁
            if (y <= 1) {
                return;
            }
            int temp = 0x8000;
            for (int i = x; i < x+4; i++) {
                for (int j = y; j < y+4; j++) {
                    if ((temp & rect) != 0) {
                        if(date[i][j-1]==1){
                            return;
                        }
                    }
                    temp>>=1;
                }
            }
            //清除目前方法
            clear(x,y);
            y--;
            draw(x,y);
        }
        //方块右移
        if (e.getKeyCode() == 39){
            //帕努但游戏是否结束
            if (!isrunning) {
                return;
            }
            //判断游戏是否暂停
            if(game_pause){
                return;
            }
            int temp=0x8000;
            int m=x,n=y;
            //储存最右边的坐标值
            int num=1;
            for(int i=0;i<4;i++) {
                for (int j = 0; j < 4; j++) {
                    if ((temp & rect) != 0) {
                        if(n>num){
                            num=n;
                        }
                    }
                    n++;
                    temp>>=1;
                }
                m++;
                n-=4;
            }
            //判断是否碰到右墙壁
            if(num>=(game_y-2)){
                return;
            }
            //方块右移途中是否碰到别的方块
            temp=0x8000;
            for (int i = x; i < x+4; i++) {
                for (int j = y; j < y + 4; j++) {
                    if ((temp & rect) != 0) {
                        if(date[i][j+1]==1){
                            return;
                        }
                    }
                    temp>>=1;
                }
            }
            //清除当前方块
            clear(x,y);
            y++;
            draw(x,y);
        }
        //方块进行下落
        if (e.getKeyCode() == 40){
            //判断游戏是否结束
            if (!isrunning) {
                return;
            }
            //判断方块是否可以下落
            if(!canFall(x,y)){
                return;
            }
            clear(x,y);
            x++;
            draw(x,y);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}