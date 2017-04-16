package com.danielc.web.crawler.service;

import com.danielc.web.crawler.config.AppConfig;
import com.danielc.web.crawler.model.Page;
import com.danielc.web.crawler.repository.PageRepository;
import com.danielc.web.crawler.repository.UrlRepository;

import java.util.Collection;

public interface Crawler {

  void setConfig(AppConfig config);

  void setRepositories(UrlRepository urlRepository, PageRepository pageRepository);

  void crawl(String baseUrl);

}
