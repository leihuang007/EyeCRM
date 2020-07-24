/**
 * 
 */
package cn.live.shinobi_hl.common.utils.filetools.intf;

import java.util.List;

/**
 * @author Huanglei
 * 
 */
public interface FileGenerator<T extends Object> {

	public static final int PATIENT_LIST = 0;
	public static final int OFFICER_LIST = 1;

	String generateFile(int type, List<T> contents) throws Exception;
}
