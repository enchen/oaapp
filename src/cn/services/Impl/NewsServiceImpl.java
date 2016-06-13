package cn.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.beans.News;
import cn.dao.NewsDao;
import cn.services.NewsService;
@Service("newsService")
public class NewsServiceImpl implements NewsService {

	@Autowired
    private NewsDao newsDao;
	@Override
	public void insertNews(News news) {
		newsDao.insertNews(news);
		
	}

}
