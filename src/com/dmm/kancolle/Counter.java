package com.dmm.kancolle;

import java.util.function.IntConsumer;

/**
 * カウンターのロジックを担うクラス
 */
public class Counter {
	/* ローカル変数 */
	private int reach;
	private int current;

	/**
	 * コンストラクタ
	 *
	 * @param reach カウンターの目標値
	 */
	public Counter(int reach) {
		this.reach = reach;
		current = 0;
	}

	/**
	 * カウンターを更新する
	 *
	 * @param n 前回からの差分
	 * @return 現在の進捗の文字列
	 */
	public String updateCounter(int n) {
		current += n;
		return toString();
	}

	/**
	 * カウンターが目標値に達しているか判定する
	 *
	 * @return 目標値に達していればtrue、さもなければfalse
	 */
	public boolean isReach() {
		return reach <= current;
	}

	/**
	 * 渡された処理を現在のカウンターの値で実行する
	 *
	 * @param consumer 実行したい処理のConsumer
	 */
	public void accept(IntConsumer consumer) {
		consumer.accept(current);
	}

	@Override
	public String toString() {
		return String.format("%d/%d", current, reach);
	}
}
