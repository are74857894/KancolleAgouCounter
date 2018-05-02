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

   	private JPanel countSWin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {


			public void run() {
				
				try {
					 AgouCounter frame = new AgouCounter ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int	countBossBattle=0;
	int countBattle=0;
	int countBossWin=0;
	int countSwin=0;

	private JButton btnBossBattleMCount;
	private JButton btnBossButtleReset;
	private JButton btnBossBattleCount;
	/**
	 * Create the frame.
	 */

	boolean top = false;

	public AgouCounter() {
		setTitle("艦これあ号カウンター");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 380);
		countSWin = new JPanel();
		countSWin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(countSWin);
		countSWin.setLayout(null);

		JLabel countLblBoss = new JLabel("ボス到達数：0/24");/*ボス到達数*/
		countLblBoss.setBounds(17, 105, 118, 16);
				countSWin.add(countLblBoss);

				JLabel kiratuke= new JLabel("");
				kiratuke.setBounds(268, 304, 118, 16);/*キラ付けカウンター用。邪魔だったら消す*/
					kiratuke.setForeground(Color.BLACK);
							countSWin.add(kiratuke);

		JLabel tasseiBoss= new JLabel("未達成");
		tasseiBoss.setBounds(17, 130, 50, 25);/*達成表示用。邪魔だったら消す。*/
			tasseiBoss.setForeground(Color.BLACK);
								countSWin.add(tasseiBoss);

		JLabel tasseiBattle = new JLabel("未達成");
								tasseiBattle.setBounds(17, 65, 45, 16);
								countSWin.add(tasseiBattle);
								{

									btnBossBattleCount = new JButton("+1");
									btnBossBattleCount.setBounds(147, 95, 50, 60);/*カウンター本体。最低限ここさえあれば*/
		btnBossBattleCount.addActionListener(e -> clickBtnBossBattleCount(countLblBoss, tasseiBoss));
		countSWin.add(btnBossBattleCount);
	}


		btnBossBattleMCount = new JButton("-1");
		btnBossBattleMCount.setBounds(206, 95, 50, 60);/*マイナスカウンターのほう。*/
		btnBossBattleMCount.addActionListener(e -> clickBtnBossBattleMCount(countLblBoss, kiratuke, tasseiBoss));
		countSWin.add(btnBossBattleMCount);

		btnBossButtleReset = new JButton("リセット");
		btnBossButtleReset.setBounds(268, 95, 100, 60);/*リセット処理*/
		btnBossButtleReset.addActionListener(e -> clickBtnBossButtleReset(countLblBoss, kiratuke, tasseiBoss));
		countSWin.add(btnBossButtleReset);

		JLabel countLblBattle = new JLabel("戦闘数：0/36");/*ここから出撃数カウンター*/
		countLblBattle.setBounds(17, 47, 96, 16);
		countSWin.add(countLblBattle);

		JButton btnCountBattle = new JButton("+1");
		btnCountBattle.setBounds(147, 32, 50, 60);
		btnCountBattle.addActionListener(e -> clickBtnCountBattle(countLblBattle, kiratuke, tasseiBattle));
		countSWin.add(btnCountBattle);

		JButton btnCountMBattle = new JButton("-1");
		btnCountMBattle.addActionListener(e -> clickBtnCountMBattle(countLblBattle, kiratuke, tasseiBattle));
		btnCountMBattle.setBounds(206, 32, 50, 60);
		countSWin.add(btnCountMBattle);

		JButton btnBattleReset = new JButton("リセット");
		btnBattleReset.addActionListener(e -> clickBtnBattleReset(countLblBattle, tasseiBattle));
		btnBattleReset.setBounds(268, 32, 100, 60);
		countSWin.add(btnBattleReset);

		JLabel countLblSwin = new JLabel("S勝利数：0/6");/*ここからS勝利数カウンター*/
		countLblSwin.setBounds(17, 158, 96, 16);
		countSWin.add(countLblSwin);

		JLabel tasseiSwin = new JLabel("未達成");
		tasseiSwin.setBounds(17, 187, 57, 16);
		countSWin.add(tasseiSwin);

		JButton btnCountSwin = new JButton("+1");
        btnCountSwin.addActionListener(e -> clickBtnCountSwin(countLblSwin, tasseiSwin));
		btnCountSwin.setBounds(147, 158, 50, 60);
		countSWin.add(btnCountSwin);

		JButton btnCountMSwin = new JButton("-1");
        btnCountMSwin.addActionListener(e -> clickBtnCountMSwin(countLblSwin, tasseiSwin));
		btnCountMSwin.setBounds(206, 158, 50, 60);
		countSWin.add(btnCountMSwin);

		JButton btnSwinReset = new JButton("リセット");
		btnSwinReset.addActionListener(e -> clickBtnSwinReset(countLblSwin, tasseiSwin));
		btnSwinReset.setBounds(268, 158, 100, 60);
		countSWin.add(btnSwinReset);

		JLabel countLblBossWin = new JLabel("ボス勝利数：0/12");
		countLblBossWin.setBounds(17, 222, 118, 16);
		countSWin.add(countLblBossWin);

		JLabel tasseiBossWin = new JLabel("未達成");
		tasseiBossWin.setBounds(17, 245, 57, 16);
		countSWin.add(tasseiBossWin);

		JButton btnBossWin = new JButton("+1");/*ここからボス勝利*/
		btnBossWin.addActionListener(e -> clickBtnBossWin(countLblBossWin, tasseiBossWin));
		btnBossWin.setBounds(147, 223, 50, 60);
		countSWin.add(btnBossWin);

		JButton btnMBossWin = new JButton("-1");
		btnMBossWin.addActionListener(e -> clickBtnMBossWin(countLblBossWin, tasseiBossWin));
		btnMBossWin.setBounds(206, 223, 50, 60);
		countSWin.add(btnMBossWin);

		JButton btnBossWinReset = new JButton("リセット");
		btnBossWinReset.addActionListener(e -> clickBtnBossWinReset(countLblBossWin, tasseiBossWin));
		btnBossWinReset.setBounds(268, 223, 100, 60);
		countSWin.add(btnBossWinReset);


		JCheckBox frontCheck = new JCheckBox("常に最前面表示");
		frontCheck.addActionListener(e -> clickFrontCheck(frontCheck));
		frontCheck.setBounds(17, 9, 129, 25);
		countSWin.add(frontCheck);

		JButton btnallReset = new JButton("オールリセット");
		btnallReset.addActionListener(e -> clickBtnallReset(countLblBoss, tasseiBoss, countLblBattle, tasseiBattle,
                countLblSwin, tasseiSwin, countLblBossWin, tasseiBossWin));
		btnallReset.setBounds(116, 298, 150, 25);
		countSWin.add(btnallReset);
	}

    private void clickBtnBossBattleCount(JLabel countLblBoss, JLabel tasseiBoss){
        countBossBattle++;
        countLblBoss.setText("ボス到達数："+countBossBattle+"/24");
        if(countBossBattle>=24) {
            tasseiBoss.setText("達成！");/*24回終わった時に出す文字。色とか悩み中*/
        }
        if(countBossBattle<24){
            tasseiBoss.setText("未達成");

        }
    }
    private void clickBtnBossBattleMCount(JLabel countLblBoss, JLabel kiratuke, JLabel tasseiBoss){
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
    private void clickBtnBossButtleReset(JLabel countLblBoss, JLabel kiratuke, JLabel tasseiBoss){
        countBossBattle=0;

        countLblBoss.setText("ボス到達数："+countBossBattle+"/24");
        tasseiBoss.setText("未達成");
        kiratuke.setText("");
    }
    private void clickBtnCountBattle(JLabel countLblBattle, JLabel kiratuke, JLabel tasseiBattle){
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
    private void clickBtnCountMBattle(JLabel countLblBattle, JLabel kiratuke, JLabel tasseiBattle){
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
    private void clickBtnBattleReset(JLabel countLblBattle, JLabel tasseiBattle){
        countBattle = 0;
        countLblBattle.setText("戦闘数："+countBattle+"/36");
        tasseiBattle.setText("未達成");
    }
    private void clickBtnCountSwin(JLabel countLblSwin, JLabel tasseiSwin){
        countSwin++;
        countLblSwin.setText("S勝利数："+countSwin+"/6");
        if(countSwin>=6)
            tasseiSwin.setText("達成！");
        if(countSwin<6) {
            tasseiSwin.setText("未達成");
        }
    }
    private void clickBtnCountMSwin(JLabel countLblSwin, JLabel tasseiSwin){
        countSwin--;
        countLblSwin.setText("S勝利数："+countSwin+"/6");
        if(countSwin>=6)
            tasseiSwin.setText("達成！");
        if(countSwin<6) {
            tasseiSwin.setText("未達成");
        }
    }
    private void clickBtnSwinReset(JLabel countLblSwin, JLabel tasseiSwin){
        countSwin=0;
        countLblSwin.setText("S勝利数："+countSwin+"/6");
        if(countSwin<6);
        tasseiSwin.setText("未達成");
    }
    private void clickBtnBossWin(JLabel countLblBossWin, JLabel tasseiBossWin){
        countBossWin++;
        countLblBossWin.setText("ボス勝利数："+countBossWin+"/12");
        if(countBossWin>=12);
        tasseiBossWin.setText("達成！");
        if(countBossWin<12){
            tasseiBossWin.setText("未達成");
        }
    }
    private void clickBtnMBossWin(JLabel countLblBossWin, JLabel tasseiBossWin){
        countBossWin--;
        countLblBossWin.setText("ボス勝利数："+countBossWin+"/12");
        if(countBossWin>=12);
        tasseiBossWin.setText("達成！");
        if(countBossWin<12) {
            tasseiBossWin.setText("未達成");
        }
    }
    private void clickBtnBossWinReset(JLabel countLblBossWin, JLabel tasseiBossWin){
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
    private void clickBtnallReset(JLabel countLblBoss, JLabel tasseiBoss, JLabel countLblBattle, JLabel tasseiBattle,
                                  JLabel countLblSwin, JLabel tasseiSwin, JLabel countLblBossWin, JLabel tasseiBossWin){
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
