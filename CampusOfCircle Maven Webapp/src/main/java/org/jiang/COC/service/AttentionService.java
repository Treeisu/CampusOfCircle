package org.jiang.COC.service;

import java.util.List;




import org.jiang.COC.model.Attention;





/**
 * 
 * @author cherry
 *
 */
public interface AttentionService {

	public void saveAttention(Attention attention);//保存实体
	public void deleteAttention(Attention attention);//删除实体
	public Attention getAttentionById(long Id);
	public List<Attention> findAttentionsByUserId(long userId);
	public List<Attention> findAttentionsByGroupId(long groupId);

}
