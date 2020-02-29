import time
# 定义一个获取所有章节 URL 的函数
import random
import requests
import re
import lxml.html
etree = lxml.html.etree
chapters_count = 0
name = '123qwe4234'
fb = open('%s.txt' % name, 'w', encoding='utf-8')

header = [{
                  'User-Agent': 'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36'},
              {
                  'User-Agent': 'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50'},
              {'User-Agent': 'Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)'},
              {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1'},
              {'User-Agent': 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)'}
        ]

    # header 是用来伪装成浏览器发送请求，一般加上最好，header 信息可以通过浏览器查看，也可在网上搜索得到。

def get_url(url):
    req = requests.get(url,headers = header[random.randint(0,4)])
    result = req.content
    result = result.decode('gbk')
    title = etree.HTML(result).xpath('//div[@id="list"]/dl/dd')
    # print(title)
    list_url_ = []  # 定义一个空列表，来装处理后的各个章节的 url
    list_url_count = 0
    for title_1 in title:
        if title_1 :
            if list_url_count >= 289 :
                title_1 = title_1.xpath('a/@href')[0]
                # print(title_1)
                list_url_.append('https://www.xbiquge.cc/book/48629/' + title_1)

        list_url_count = list_url_count+1
    print('title_1')
    return list_url_

def get_contents(url):
    # print(url)
    req1 = requests.get(url,
                        headers=header[random.randint(0, 4)])  # 向目标网站发送 get 请求
    result1 = req1.content
    result1 = result1.decode('gbk')  # 查看网页源代码 看到 charset=gbk，即网页是用的 gbk 编码，故要用 gkb 的编码方式来解码，否则中文就会乱码。

    text_re = re.compile(r'<br><br>([\s\S]*?)</div>')  # 由于正文部分有很多的换行符，故要使用 [\s\S]

    text1 = re.findall(text_re, result1)  # 找出第第一部分的正文
    title = etree.HTML(result1).xpath('//div[@class="bookname"]/h1/text()')[0]
    # title = title[0]
    # 由于返回的 title 是列表，故取出列表中的第一项
    print(title)  # 打印出标题
    fb.write(title)
    fb.write('\n')
    # text1.append(text2[0])  # 把正文两个部分添加到同一列表中，方便处理
    text1 = '\r\n'.join(text1)  # 把两部分的正文连接成同一个个字符串
    text1 = text1.split('\r\n')  # 把字符串按照换行符分割
    text_1 = []  # 添加一个空列表，用来装处理后的正文
    for sentence in text1:
        sentence = sentence.strip()  # 去掉每一句两边的空格
        if '&nbsp;&nbsp;&nbsp;&nbsp;' in sentence:
            sentence = sentence.replace('&nbsp;&nbsp;&nbsp;&nbsp;', '')  # 去掉句子中的  
            if '<br />' in sentence:
                sentence = sentence.replace('<br />', '')  # 去掉句子中的 <br />
                text_1.append(sentence)
            else:
                text_1.append(sentence)
        elif '<br />' in sentence:
            sentence = sentence.replace('<br />', '')
            text_1.append(sentence)
        elif '-->><p class="text-danger text-center mg0">本章未完，点击下一页继续阅读</p>' in sentence:
            sentence = sentence.replace(r'-->><p class="text-danger text-center mg0">本章未完，点击下一页继续阅读</p>',
                                        '')  # 去掉 -->><p class="text-danger text-center mg0">本章未完，点击下一页继续阅读</p>
            text_1.append(sentence)
        else:
            text_1.append(sentence)
    count = text_1.count('')  # 统计列表中的空字符串
    for i in range(count):
        text_1.remove('')  # 移除所有的空字符串
    for sentence in text_1:
        # print(sentence)  # 打印出所有的正文
        fb.write(sentence)
        fb.write('\n')
    # print(chapters_count)
    print('  successful! ')
    # chapters_count = chapters_count + 1


if __name__ == '__main__':
    chapters_count = 0
    name = 'biquge_2_num2_289'
    fb = open('%s.txt' % name, 'w', encoding='utf-8')
    for url_txt in get_url('https://www.xbiquge.cc/book/48629/'):
        # print(url_txt)
        get_contents(url_txt)
        time.sleep(5)

    fb.close()