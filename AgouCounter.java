import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AgouCounter extends JFrame {
    private int	countBossBattle = 0;
    private int countBattle = 0;
    private int countBossWin = 0;
    private int countSwin = 0;
    private boolean top = false;

   	private JPanel countSWin;
    private JButton btnBossBattleMCount;
    private JButton btnBossButtleReset;
    private JButton btnBossBattleCount;
    private JLabel kiratuke;
    private JLabel countLblBoss;
    private JLabel tasseiBoss;
    private JLabel countLblBattle;
    private JLabel tasseiBattle;
    private JLabel countLblSwin;
    private JLabel tasseiSwin;
    private JLabel countLblBossWin;
    private JLabel tasseiBossWin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(() -> {
            AgouCounter frame = new AgouCounter();
            frame.setVisible(true);
        });
	}

	/**
     * Create the frame.
	 */
	public AgouCounter() {
		setTitle("艦これあ号カウンター");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 380);
		countSWin = new JPanel();
		countSWin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(countSWin);
		countSWin.setLayout(null);

		countLblBoss = new JLabel("ボス到達数：0/24");/*ボス到達数*/
		countLblBoss.setBounds(17, 105, 118, 16);
		countSWin.add(countLblBoss);

		kiratuke= new JLabel("");
		kiratuke.setBounds(268, 304, 118, 16);/*キラ付けカウンター用。邪魔だったら消す*/
		kiratuke.setForeground(Color.BLACK);
		countSWin.add(kiratuke);

		tasseiBoss= new JLabel("未達成");
		tasseiBoss.setBounds(17, 130, 50, 25);/*達成表示用。邪魔だったら消す。*/
		tasseiBoss.setForeground(Color.BLACK);
		countSWin.add(tasseiBoss);

		tasseiBattle = new JLabel("未達成");
		tasseiBattle.setBounds(17, 65, 45, 16);
		countSWin.add(tasseiBattle);

		btnBossBattleCount = new JButton("+1");
        btnBossBattleCount.setBounds(147, 95, 50, 60);/*カウンター本体。最低限ここさえあれば*/
		btnBossBattleCount.addActionListener(e -> clickBtnBossBattleCount());
		countSWin.add(btnBossBattleCount);

		btnBossBattleMCount = new JButton("-1");
		btnBossBattleMCount.setBounds(206, 95, 50, 60);/*マイナスカウンターのほう。*/
		btnBossBattleMCount.addActionListener(e -> clickBtnBossBattleMCount());
		countSWin.add(btnBossBattleMCount);

		btnBossButtleReset = new JButton("リセット");
		btnBossButtleReset.setBounds(268, 95, 100, 60);/*リセット処理*/
		btnBossButtleReset.addActionListener(e -> clickBtnBossButtleReset());
		countSWin.add(btnBossButtleReset);

		countLblBattle = new JLabel("戦闘数：0/36");/*ここから出撃数カウンター*/
		countLblBattle.setBounds(17, 47, 96, 16);
		countSWin.add(countLblBattle);

		JButton btnCountBattle = new JButton("+1");
		btnCountBattle.setBounds(147, 32, 50, 60);
		btnCountBattle.addActionListener(e -> clickBtnCountBattle());
		countSWin.add(btnCountBattle);

		JButton btnCountMBattle = new JButton("-1");
		btnCountMBattle.addActionListener(e -> clickBtnCountMBattle());
		btnCountMBattle.setBounds(206, 32, 50, 60);
		countSWin.add(btnCountMBattle);

		JButton btnBattleReset = new JButton("リセット");
		btnBattleReset.addActionListener(e -> clickBtnBattleReset());
		btnBattleReset.setBounds(268, 32, 100, 60);
		countSWin.add(btnBattleReset);

		countLblSwin = new JLabel("S勝利数：0/6");/*ここからS勝利数カウンター*/
		countLblSwin.setBounds(17, 158, 96, 16);
		countSWin.add(countLblSwin);

		tasseiSwin = new JLabel("未達成");
		tasseiSwin.setBounds(17, 187, 57, 16);
		countSWin.add(tasseiSwin);

		JButton btnCountSwin = new JButton("+1");
        btnCountSwin.addActionListener(e -> clickBtnCountSwin());
		btnCountSwin.setBounds(147, 158, 50, 60);
		countSWin.add(btnCountSwin);

		JButton btnCountMSwin = new JButton("-1");
        btnCountMSwin.addActionListener(e -> clickBtnCountMSwin());
		btnCountMSwin.setBounds(206, 158, 50, 60);
		countSWin.add(btnCountMSwin);

		JButton btnSwinReset = new JButton("リセット");
		btnSwinReset.addActionListener(e -> clickBtnSwinReset());
		btnSwinReset.setBounds(268, 158, 100, 60);
		countSWin.add(btnSwinReset);

		countLblBossWin = new JLabel("ボス勝利数：0/12");
		countLblBossWin.setBounds(17, 222, 118, 16);
		countSWin.add(countLblBossWin);

		tasseiBossWin = new JLabel("未達成");
		tasseiBossWin.setBounds(17, 245, 57, 16);
		countSWin.add(tasseiBossWin);

		JButton btnBossWin = new JButton("+1");/*ここからボス勝利*/
		btnBossWin.addActionListener(e -> clickBtnBossWin());
		btnBossWin.setBounds(147, 223, 50, 60);
		countSWin.add(btnBossWin);

		JButton btnMBossWin = new JButton("-1");
		btnMBossWin.addActionListener(e -> clickBtnMBossWin());
		btnMBossWin.setBounds(206, 223, 50, 60);
		countSWin.add(btnMBossWin);

		JButton btnBossWinReset = new JButton("リセット");
		btnBossWinReset.addActionListener(e -> clickBtnBossWinReset());
		btnBossWinReset.setBounds(268, 223, 100, 60);
		countSWin.add(btnBossWinReset);


		JCheckBox frontCheck = new JCheckBox("常に最前面表示");
		frontCheck.addActionListener(e -> clickFrontCheck(frontCheck));
		frontCheck.setBounds(17, 9, 129, 25);
		countSWin.add(frontCheck);

		JButton btnallReset = new JButton("オールリセット");
		btnallReset.addActionListener(e -> clickBtnallReset());
		btnallReset.setBounds(116, 298, 150, 25);
		countSWin.add(btnallReset);
	}

    private void clickBtnBossBattleCount(){
        countBossBattle++;
        countLblBoss.setText("ボス到達数："+countBossBattle+"/24");
        if(countBossBattle>=24) {
            tasseiBoss.setText("達成！");/*24回終わった時に出す文字。色とか悩み中*/
        }
        if(countBossBattle<24){
            tasseiBoss.setText("未達成");

        }
    }
    private void clickBtnBossBattleMCount(){
        countBossBattle--;
        countLblBoss.setText("ボス到達数："+countBossBattle+"/24");
        if(countBossBattle%3==0) {
            kiratuke.setText("アハ★");/*1-1キラ付けカウンター。３の倍数で出現するので目安に。*/
        }
        if(countBossBattle%3!=0) {
            kiratuke.setText("");
            if(countBossBattle>=24) {
                tasseiBoss.setText("達成！");/*24回終わった時に出す文字。色とか悩み中*/
            }
            if(countBossBattle<24){
                tasseiBoss.setText("未達成");
            }
        }
    }
    private void clickBtnBossButtleReset(){
        countBossBattle=0;

        countLblBoss.setText("ボス到達数："+countBossBattle+"/24");
        tasseiBoss.setText("未達成");
        kiratuke.setText("");
    }
    private void clickBtnCountBattle(){
        countBattle++;
        countLblBattle.setText("戦闘数："+countBattle+"/36");
        if(countBattle>=36)
            tasseiBattle.setText("達成!");
        if(countBattle<36)
            tasseiBattle.setText("未達成");
        if(countBattle%3==0) {
            kiratuke.setText("キラキラ☆");/*1-1キラ付けカウンター。３の倍数で出現するので目安に。*/
        }
        if(countBattle%3!=0) {
            kiratuke.setText("");

        }
    }
    private void clickBtnCountMBattle(){
        countBattle--;
        countLblBattle.setText("戦闘数："+countBattle+"/36");
        if(countBattle>=36)
            tasseiBattle.setText("達成!");
        if(countBattle<36){
            tasseiBattle.setText("未達成");
            if(countBattle%3==0) {
                kiratuke.setText("キラキラ☆");/*1-1キラ付けカウンター。３の倍数で出現するので目安に。*/
            }
            if(countBattle%3!=0) {
                kiratuke.setText("");
            }
        }
    }
    private void clickBtnBattleReset(){
        countBattle = 0;
        countLblBattle.setText("戦闘数："+countBattle+"/36");
        tasseiBattle.setText("未達成");
    }
    private void clickBtnCountSwin(){
        countSwin++;
        countLblSwin.setText("S勝利数："+countSwin+"/6");
        if(countSwin>=6)
            tasseiSwin.setText("達成！");
        if(countSwin<6) {
            tasseiSwin.setText("未達成");
        }
    }
    private void clickBtnCountMSwin(){
        countSwin--;
        countLblSwin.setText("S勝利数："+countSwin+"/6");
        if(countSwin>=6)
            tasseiSwin.setText("達成！");
        if(countSwin<6) {
            tasseiSwin.setText("未達成");
        }
    }
    private void clickBtnSwinReset(){
        countSwin=0;
        countLblSwin.setText("S勝利数："+countSwin+"/6");
        if(countSwin<6);
        tasseiSwin.setText("未達成");
    }
    private void clickBtnBossWin(){
        countBossWin++;
        countLblBossWin.setText("ボス勝利数："+countBossWin+"/12");
        if(countBossWin>=12);
        tasseiBossWin.setText("達成！");
        if(countBossWin<12){
            tasseiBossWin.setText("未達成");
        }
    }
    private void clickBtnMBossWin(){
        countBossWin--;
        countLblBossWin.setText("ボス勝利数："+countBossWin+"/12");
        if(countBossWin>=12);
        tasseiBossWin.setText("達成！");
        if(countBossWin<12) {
            tasseiBossWin.setText("未達成");
        }
    }
    private void clickBtnBossWinReset(){
        countBossWin=0;
        countLblBossWin.setText("ボス勝利数："+countBossWin+"/12");
        tasseiBossWin.setText("未達成");
    }
    private void clickFrontCheck(JCheckBox frontCheck){
        if(frontCheck.isSelected()) {
            top = true;
        }else {
            top = false;

        }
        setAlwaysOnTop(top);/*最前面表示*/
    }
    private void clickBtnallReset(){
        countBossBattle=0;
        countBattle=0;
        countBossWin=0;
        countSwin=0;
        countLblBoss.setText("ボス到達数："+countBossBattle+"/24");
        countLblBattle.setText("戦闘数："+countBattle+"/36");
        countLblSwin.setText("S勝利数："+countSwin+"/6");
        countLblBossWin.setText("ボス勝利数："+countBossWin+"/12");
        tasseiBoss.setText("未達成");
        tasseiBattle.setText("未達成");
        tasseiSwin.setText("未達成");
        tasseiBossWin.setText("未達成");
    }
}
