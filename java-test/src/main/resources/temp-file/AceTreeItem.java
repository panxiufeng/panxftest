
/**
 *
 * @author panxiufeng
 * @version Id: AceTreeItem.java, v 0.1 2019/9/4 15:06 panxiufeng Exp $$
 */
public class AceTreeItem {

    private Integer id;
    private Integer parentId;
    private Integer sort;
    private String text;
    private String type ; //节点的类型："item":文件  "folder":目录
    private AdditionalParameters additionalParameters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AdditionalParameters getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(AdditionalParameters additionalParameters) {
        this.additionalParameters = additionalParameters;
    }
}