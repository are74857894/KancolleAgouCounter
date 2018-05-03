package com.dmm.kancolle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

/**
 * あ号カウンターのウィンドウクラス
 */
public class AgouCounter extends JFrame {
	/* ローカル変数 */
	private List<CounterPane> counterList;

	/**
	 * アプリケーションを起動する
	 */
	public static void main(String[] args) {
		// インスタンスを生成してsetVisibleを設定すれば投げっぱなしでいい
		SwingUtilities.invokeLater(() -> new AgouCounter().setVisible(true));
	}

	/**
	 * コンストラクタ
	 */
	private AgouCounter() {
		setTitle("艦これあ号カウンター");

		/* JFrameの大きさ設定と画面上のセンタリング */
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		/* 一番上の部分 */
		JPanel header = new JPanel();
		header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		header.setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(header, BorderLayout.NORTH);
		JCheckBox frontCheck = new JCheckBox("常に最前面表示");
		frontCheck.addActionListener(e -> showDisplayFront(frontCheck.isSelected()));
		header.add(frontCheck, BorderLayout.NORTH);

		/* 一番下の部分 */
		JPanel footer = new JPanel();
		footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		footer.setLayout(new GridLayout(1, 3, 10, 10));
		getContentPane().add(footer, BorderLayout.SOUTH);
		/* レイアウト用ダミー */
		footer.add(new JPanel());

		/* リセットボタン */
		JButton btnallReset = new JButton("オールリセット");
		btnallReset.addActionListener(e -> resetAll());
		footer.add(btnallReset);
		/* キラ付けカウンター用。邪魔だったら消す */
		JLabel kiratuke = new JLabel("");
		footer.add(kiratuke);

		/* カウンターが縦に並ぶようにする */
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(4, 1, 0, 10));
		getContentPane().add(container, BorderLayout.CENTER);

		/* カウンターの初期化 */
		counterList = Arrays.asList(
				/* ボス到達数 */
				new CounterPane("ボス到達数", 24),
				/* 出撃数カウンター */
				new CounterPane("戦闘数", 36, n ->
						/*1-1キラ付けカウンター。３の倍数で出現するので目安に。*/
						kiratuke.setText(n % 3 == 0 && n > 0 ? "キラキラ☆" : "")
				),
				/* S勝利数カウンター */
				new CounterPane("S勝利数", 6),
				/* ボス勝利 */
				new CounterPane("ボス勝利数", 12)
		);
		/* カウンターの追加 */
		counterList.forEach(container::add);
	}

	/**
	 * 最前面表示にするかを切り替える
	 */
	private void showDisplayFront(boolean isEnable) {
		setAlwaysOnTop(isEnable);/*最前面表示*/
	}

	/**
	 * 全てのカウントをリセットする
	 */
	private void resetAll() {
		counterList.forEach(CounterPane::initCounter);
	}
}
