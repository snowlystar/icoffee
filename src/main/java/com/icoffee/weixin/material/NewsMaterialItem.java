package com.icoffee.weixin.material;

import java.util.Arrays;

public class NewsMaterialItem extends MaterialItem {
	public static class NewsContent {
        NewsItem news_item[];

		public NewsItem[] getNews_item() {
			return news_item;
		}

		public void setNews_item(NewsItem[] news_item) {
			this.news_item = news_item;
		}

		@Override
		public String toString() {
			return String.format("NewsContent [news_item=%s]", Arrays.toString(news_item));
		}
	}
	private NewsContent content;
	public NewsContent getContent() {
		return content;
	}
	public void setContent(NewsContent content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return super.toString() + String.format("\nNewsMaterialItem [content=%s]\n", content);
	}
}

