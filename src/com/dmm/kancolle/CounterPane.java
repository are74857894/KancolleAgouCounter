package com.dmm.kancolle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * カウンターの部品をまとめたパネルのクラス
 */
public class CounterPane extends JPanel {
	/* ローカル変数 */
	private Counter counter;
	private String title;
	private int reach;
	private List<IntConsumer> extraAction;
	private JLabel status;
	private JLabel achieve;

	/**
	 * コンストラクタ
	 *
	 * @param title       カウンターのタイトル
	 * @param reach       カウンターの目標値
	 * @param extraAction ボタンを押したときの追加処理
	 */
	public CounterPane(String title, int reach, IntConsumer... extraAction) {
		this.title = title;
		this.reach = reach;
		this.extraAction = Arrays.asList(extraAction);

		// グリッドで均等に3列になるようにするレイアウト
		this.setLayout(new GridLayout(1, 3));

		/* ラベルをまとめるパネル */
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		this.add(labelPanel);
		/* カウンターをまとめるパネル */
		JPanel operatePanel = new JPanel();
		operatePanel.setLayout(new GridLayout(1, 2, 10, 10));
		this.add(operatePanel);
		JPanel resetPanel = new JPanel();
		resetPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		resetPanel.setLayout(new BorderLayout());
		this.add(resetPanel, BorderLayout.CENTER);

		/* 進捗表示用 */
		status = new JLabel();
		labelPanel.add(status);
		/* 達成表示用。邪魔だったら消す。 */
		achieve = new JLabel();
		labelPanel.add(achieve);

		/* カウンター本体。最低限ここさえあれば */
		JButton plusButton = new JButton("+1");
		plusButton.addActionListener(e -> updateCounter(1));
		operatePanel.add(plusButton);
		/* マイナスカウンターのほう。 */
		JButton minusButton = new JButton("-1");
		minusButton.addActionListener(e -> updateCounter(-1));
		operatePanel.add(minusButton);

		/* リセット処理 */
		JButton resetButton = new JButton("リセット");
		resetButton.addActionListener(e -> initCounter());
		resetPanel.add(resetButton);

		/* カウンターを初期化 */
		this.initCounter();
	}

	/**
	 * 進捗の表示を更新する
	 *
	 * @param n 前回からの差分
	 */
	private void updateCounter(int n) {
		status.setText(String.format("%s：%s", title, counter.updateCounter(n)));
		achieve.setText(counter.isReach() ? "達成" : "未達成");
		/* 追加処理をCounterに実行させる */
		extraAction.forEach(counter::accept);
	}

	/**
	 * 進捗の表示を初期化する
	 */
	public void initCounter() {
		counter = new Counter(reach);
		updateCounter(0);
	}
}
