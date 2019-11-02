

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author panxiufeng
 * @version Id: AdditionalParameters.java, v 0.1 2019/9/4 15:44 panxiufeng Exp $$
 */
public class AdditionalParameters {

    public AdditionalParameters(){}

    /**
     * 子节点列表
     */
    private Map<String,AceTreeItem> children = new LinkedHashMap<String,AceTreeItem>();


    public Map<String,AceTreeItem> getChildren()
    {
        return children ;
    }

    public void setChildren(Map<String,AceTreeItem> children )
    {
        this .children = children;
    }
}