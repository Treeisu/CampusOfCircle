package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.PraiseDaoImpl;
import org.jiang.COC.daoImpl.PushInfoDaoImpl;
import org.jiang.COC.model.PraiseInfo;
import org.jiang.COC.model.PushInfo;
import org.jiang.COC.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class PraiseServiceImpl implements PraiseService {
	@Autowired
	private PraiseDaoImpl praiseDaoImpl;
	@Autowired
	private PushInfoDaoImpl pushInfoDaoImpl;
	
	@Override
	@Transactional
	public void savePraise(PraiseInfo praiseInfo) {
		// TODO Auto-generated method stub
		long wbId=praiseInfo.getWbId();
		praiseDaoImpl.savePraise(praiseInfo);
		//数量+1
		PushInfo pushInfo=pushInfoDaoImpl.getPushIfoBywbId(wbId);
		pushInfo.setPraiseNum(pushInfo.getPraiseNum()+1);
		pushInfoDaoImpl.updatePushInfo(pushInfo);
	}

	@Override
	@Transactional
	public List<PraiseInfo> findBywbIdAnduserId(long userId,long wbId){
		// TODO Auto-generated method stub
		List<PraiseInfo> list=praiseDaoImpl.findBywbIdAnduserId(userId, wbId);		
		return list;
	}


	@Override
	@Transactional
	public void deletePraise(long userId,long wbId){
		// TODO Auto-generated method stub
		List<PraiseInfo> list=praiseDaoImpl.findBywbIdAnduserId(userId, wbId);
		for(PraiseInfo praiseInfo:list){
			praiseDaoImpl.deletePraise(praiseInfo);
			//数量-1
			PushInfo pushInfo=pushInfoDaoImpl.getPushIfoBywbId(wbId);
			pushInfo.setPraiseNum(pushInfo.getPraiseNum()-1);
			pushInfoDaoImpl.updatePushInfo(pushInfo);
		}
	}

	

}
