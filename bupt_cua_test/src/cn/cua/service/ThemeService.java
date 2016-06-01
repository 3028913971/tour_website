package cn.cua.service;

import java.util.List;

import cn.cua.dao.ThemeInfoDAO;
import cn.cua.domain.ThemeInfo;

public class ThemeService {
	private ThemeInfoDAO themeInfoDao = new ThemeInfoDAO();

	public ThemeInfo load(int themeId){
		return themeInfoDao.load(themeId);
	}

	public List<ThemeInfo> findAll(){
		return themeInfoDao.findAll();
	}

	public void add(ThemeInfo model) throws ThemeException{
		List<ThemeInfo> themeInfos = themeInfoDao.findByThemeName(model.getThemeName());
		if(themeInfos.size()!=0){
			throw new ThemeException("该主题已经存在！");
		}else{
			themeInfoDao.add(model);
		}
	}

	public void delete(int themeId) {
		themeInfoDao.delete(themeId);
	}

	public void edit(ThemeInfo model) throws ThemeException {
		List<ThemeInfo> themeInfos = themeInfoDao.findByThemeName(model.getThemeName());
		if(themeInfos.size()!=0&&themeInfos.get(0).getThemeId()!=model.getThemeId()){
			throw new ThemeException("该主题已经存在！");
		}else{
			themeInfoDao.edit(model);
		}
		
	}

	public int getThemeAmount() {
		return themeInfoDao.getThemeAmount();
	}

}
