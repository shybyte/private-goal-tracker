package marco.stahl.goaltracker.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MainMenu extends Widget {

	public enum MenuItem {

		GOAL_LIST("list", "Goal List"), STATS("stats", "Stats"), OPTIONS(
				"options", "Options");

		private final String id;
		private final String displayName;

		MenuItem(String id, String displayName) {
			this.id = id;
			this.displayName = displayName;
		}

		public String getId() {
			return id;
		}

		public String getDisplayName() {
			return displayName;
		}

		public boolean belongsTo(String token) {
			return token.startsWith(id);
		}
	}

	private static MainMenuUiBinder uiBinder = GWT
			.create(MainMenuUiBinder.class);

	interface MainMenuUiBinder extends UiBinder<UListElement, MainMenu> {
	}

	@Inject
	public MainMenu() {
		setElement(uiBinder.createAndBindUi(this));
		display("");
	}
	
	public void clear() {
		Element element = getElement();
		element.setInnerHTML("bla");
		Window.alert("hu"+this);
	}

	public void display(String selectedMenuItemToken) {
		Element element = getElement();
		element.setInnerHTML("");
		Document document = Document.get();
		for (MenuItem menuItem : MenuItem.values()) {
			LIElement li = document.createLIElement();
			if (menuItem.belongsTo(selectedMenuItemToken)) {
				li.setInnerText(menuItem.getDisplayName());
			} else {
				AnchorElement a = document.createAnchorElement();
				a.setHref("#" + menuItem.getId());
				a.setInnerText(menuItem.getDisplayName());
				li.appendChild(a);
			}
			element.appendChild(li);
		}
	}

}
