package hust.soict.dsai.aims.screen;
import javax.swing.*;
import hust.soict.dsai.aims.media.Media;
import java.awt.*;

public class MediaStore extends JPanel {
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new java.awt.Font(title.getFont().getName(), java.awt.Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setAlignmentX(CENTER_ALIGNMENT);
		
		container.add(btnAddToCart);
		if (media.isPlayable()) {
			container.add(btnPlay);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
	}
}
