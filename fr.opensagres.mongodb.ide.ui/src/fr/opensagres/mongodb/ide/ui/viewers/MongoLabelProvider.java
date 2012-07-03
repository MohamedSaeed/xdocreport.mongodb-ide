package fr.opensagres.mongodb.ide.ui.viewers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import fr.opensagres.mongodb.ide.core.model.TreeSimpleNode;
import fr.opensagres.mongodb.ide.ui.internal.ImageResources;

@SuppressWarnings("rawtypes")
public class MongoLabelProvider extends LabelProvider {

	private static MongoLabelProvider instance;

	public static MongoLabelProvider getInstance() {
		synchronized (MongoLabelProvider.class) {
			if (instance == null) {
				instance = new MongoLabelProvider();
			}
			return instance;
		}
	}

	@Override
	public String getText(Object element) {
		return ((TreeSimpleNode) element).getLabel();
	}

	@Override
	public Image getImage(Object element) {
		TreeSimpleNode node = (TreeSimpleNode) element;
		switch (node.getType()) {
		case Server:
			return ImageResources.getImage(ImageResources.IMG_SERVER_16);
		case Database:
			return ImageResources.getImage(ImageResources.IMG_DATABASE_16);
		case Collection:
			return ImageResources.getImage(ImageResources.IMG_COLLECTION_16);
		case Document:
			return ImageResources.getImage(ImageResources.IMG_DOCUMENT_16);
		case Error:
			return ImageResources.getImage(ImageResources.IMG_ERROR_16);
		default:
			return null;
		}
	}

}
