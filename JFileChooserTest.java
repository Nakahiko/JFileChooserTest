import javax.swing.*;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.event.*;

public class JFileChooserTest extends JFrame implements ActionListener{

	JLabel label;
	//読み込みは違う関数になるからグローバル変数にしとく

	public static void main(String[] args){
		
		JFileChooserTest frame = new JFileChooserTest();
		//フレームの宣言
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//バツ押されたら閉じるよ
		
		frame.setBounds(100, 100, 300, 200);
		//場所と大きさはこんな感じで
		
		frame.setTitle("タイトル");
		//バーに出るタイトルを指定
		
		frame.setVisible(true);
		//フレームの表示
		
	}

	JFileChooserTest(){
		
		JButton button = new JButton("file select");
		//ボタンを宣言
		
		button.addActionListener(this);
		//下で宣言したイベントに引っかかるようにしたよ


		JPanel buttonPanel = new JPanel();
		//パネル（コンテナみたいなもん）を宣言
		
		buttonPanel.add(button);
		//パネルの中にボタンをぶっこむよ
		

		label = new JLabel("none");
		//ラベル（文字表示）を宣言

		JPanel labelPanel = new JPanel();
		//またパネル作って
		
		labelPanel.add(label);
		//ラベルをぶっこむ

		getContentPane().add(labelPanel, BorderLayout.CENTER);
		//いまいち分からないんだけど、ラベルのパネルを上に配置してるらしい
		
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		//ボタンのパネルを下に配置してるらしい
		
	}

	public void actionPerformed(ActionEvent e){　//ボタン押したり、テキスト入力完了したら呼び出されるらしい
		
		JFileChooser filechooser = new JFileChooser();
		//JFileChooser（ファイル選択の際の一連の機能）を定義

		int selected = filechooser.showOpenDialog(this);
		//ダイアログを宣言（ダイアログでの操作が格納される）
		
		if (selected == JFileChooser.APPROVE_OPTION){　//しっかり開いたら
			
			File file = filechooser.getSelectedFile();
			//ファイルをFile型の変数に格納
			
			///////////////////////////////////////////////////////こっからファイルを扱える
			
			label.setText(file.getName());
			//ラベルのテキストをファイル名に変更
			
			////////////////////////////////////////////////////////ここまでファイルを扱える
			
		}else if (selected == JFileChooser.CANCEL_OPTION){　//閉じちゃったりしたら
		
			label.setText("キャンセルされました");
			//ラベルにその旨を表示
			
		}else if (selected == JFileChooser.ERROR_OPTION){　//エラーだとこっち
		
			label.setText("エラー又は取消しがありました");
			//ラベルにその旨を表示
			
		}
	}
}
