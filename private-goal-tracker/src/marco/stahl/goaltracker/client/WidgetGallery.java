package marco.stahl.goaltracker.client;

import marco.stahl.goaltracker.client.utilwidgets.TableRow;
import marco.stahl.goaltracker.client.utilwidgets.TableRowPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.googlecode.gwt.crypto.bouncycastle.DataLengthException;
import com.googlecode.gwt.crypto.bouncycastle.InvalidCipherTextException;
import com.googlecode.gwt.crypto.client.TripleDesCipher;
import com.googlecode.gwt.crypto.util.Str;

public class WidgetGallery implements EntryPoint {

	
	
	private RootPanel rootPanel;

	@Override
	public void onModuleLoad() {
		rootPanel = RootPanel.get();

		addTableRowTest();

		addCryptoTest();

	}

	private void addTableRowTest() {
		addHeader("TableRowPanel");
		TableRowPanel tableRowPanel = new TableRowPanel();
		tableRowPanel.addTableRow(new TableRow("Hu", "Toll"));
		tableRowPanel.addTableRow(new TableRow("Huhuhuhu", "Toll", "Supi!"));
		rootPanel.add(tableRowPanel);
	}

	private void addCryptoTest() {
		// key beetween 16 and 24 chars		
		addHeader("CryptoTest");
		final String password = "HalloMyFriends!!";
		final byte[] key = Str.toBytes(password.toCharArray());
		GWT.log("Key="+key.length);
		final TextBox plain = new TextBox();
		plain.setText("Hallo");
		final TextBox encrypted = new TextBox();
		rootPanel.add(plain);
		rootPanel.add(encrypted);
		rootPanel.add(new Button("Encrypt", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TripleDesCipher cipher = new TripleDesCipher();
				cipher.setKey(key);
				try {
					String enc = cipher
							.encrypt(String.valueOf(plain.getText()));
					encrypted.setText(enc);
				} catch (DataLengthException e1) {
					e1.printStackTrace();
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				} catch (InvalidCipherTextException e1) {
					e1.printStackTrace();
				}
			}
		}));
		rootPanel.add(new Button("Decrypt", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TripleDesCipher cipher = new TripleDesCipher();
				cipher.setKey(key);
				try {
					String plainText = cipher
							.decrypt(String.valueOf(encrypted.getText()));
					plain.setText(plainText);
				} catch (DataLengthException e1) {
					e1.printStackTrace();
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				} catch (InvalidCipherTextException e1) {
					e1.printStackTrace();
				}
			}
		}));
	}
	

	private void addHeader(String s) {
		rootPanel.add(new HTML("<h2>" + s + "</h2>"));
	}

}
