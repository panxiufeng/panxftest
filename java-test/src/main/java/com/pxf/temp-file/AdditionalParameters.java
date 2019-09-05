/**
 * Software License Declaration.
 * <p>
 * wandaph.com, Co,. Ltd.
 * Copyright ? 2017 All Rights Reserved.
 * <p>
 * Copyright Notice
 * This documents is provided to wandaph contracting agent or authorized programmer only.
 * This source code is written and edited by wandaph Co,.Ltd Inc specially for financial
 * business contracting agent or authorized cooperative company, in order to help them to
 * install, programme or central control in certain project by themselves independently.
 * <p>
 * Disclaimer
 * If this source code is needed by the one neither contracting agent nor authorized programmer
 * during the use of the code, should contact to wandaph Co,. Ltd Inc, and get the confirmation
 * and agreement of three departments managers  - Research Department, Marketing Department and
 * Production Department.Otherwise wandaph will charge the fee according to the programme itself.
 * <p>
 * Any one,including contracting agent and authorized programmer,cannot share this code to
 * the third party without the agreement of wandaph. If Any problem cannot be solved in the
 * procedure of programming should be feedback to wandaph Co,. Ltd Inc in time, Thank you!
 */

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