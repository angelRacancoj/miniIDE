package miniide.TreeControl;

import java.util.List;

/**
 *
 * @author angel
 */
public interface Inode {

    public TypeFile getTypeFile();

    public List<Inode> getChilds();

    public Inode getChild();

    @Override
    public String toString();
}
