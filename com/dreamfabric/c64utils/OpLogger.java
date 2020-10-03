package com.dreamfabric.c64utils;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;

import javax.swing.JButton;

/**
 * 
 */

/**
 * Logs 6510 opcodes executed by the emulator.
 * 
 * @author mzatt
 *
 */
public class OpLogger implements ActionListener {

	private final static OpLogger instance = new OpLogger();

	private OpLogger() {
		try {
			wr = new FileWriter("D:\\Users\\mzatt\\Projects\\Ja64 Runtime\\opcodes.txt");
		} catch (Exception e) {
			e.printStackTrace();;
			System.exit(-1);
		}
	}

	public static OpLogger instance() {
		return instance;
	}

	private Writer wr = null;
	private boolean isLogging = false;

	public void log(int opCode) {
		if (isLogging) {
			try {
				wr.write(opCode + "\n");
				wr.flush();
			} catch (Exception e) {
				e.printStackTrace();;
				System.exit(-1);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		isLogging = !isLogging;
		((JButton) e.getSource()).setText("Toggle OpLogger [" + (isLogging ? "ON" : "OFF") + "]");
	}
}
