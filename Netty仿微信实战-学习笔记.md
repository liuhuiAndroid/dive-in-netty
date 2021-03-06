# 第1章 课程介绍
# 第2章 netty介绍与相关基础知识

## 2-1 初始netty

#### 什么是Netty

> Netty is an asynchronous event-driven network application framework for rapid development of maintainable high performance protocol servers & clients.

1. Netty是一个提供了易于使用的API的客户端/服务器框架

2. 并发高—NIO

3. 传输快—零拷贝

#### [netty 官网](https://netty.io/)

## 2-2 阻塞和非阻塞、同步和异步的概念

#### 阻塞和非阻塞

线程访问资源，该资源是否准备就绪的一种处理方式

#### 同步和异步

同步和异步是指访问数据的一种机制

## 2-3 BIO讲解

#### BIO

同步阻塞IO，Block IO

## 2-4 NIO讲解

#### NIO

同步非阻塞IO，New IO（Non-Block IO）

## 2-5 BIO NIO AIO的区别与理解

#### AIO

异步非阻塞IO

#### 生活实例

#### BIO NIO AIO的区别

BIO：发起请求 -> 一直阻塞 -> 处理完成

NIO：Selector主动轮询channel -> 处理请求 -> 处理完成

AIO：发起请求 -> 通知回调

## 2-7 netty的三种线程模型

#### Reactor线程模型

单线程模型：所有的IO操作都由同一个NIO线程处理的

多线程模型：由一组NIO线程处理IO操作

主从线程模型：一组线程池接受请求，一组线程池处理IO（推荐使用）

## 第3章 使用netty编写第一个hello netty 服务器
## 3-1 使用maven构建netty基础依赖

#### Hello Netty 服务器

构建一对主从线程组

定义服务器启动类

为服务器设置Channel

设置处理从线程池的助手类初始化器

监听启动和关闭服务器

```java
HelloServer
```

## 3-3 为channel设置初始化器

每一个channel由多个handler共同组成管道（pipeline）

handler是一个个助手类

```Java
HelloServerInitializer
```

## 3-4 编写自定义助手类

```Java
CustomHandler
```

## 3-5 hello服务器启动与讲解

```shell
curl http://192.168.1.4:8088
```

## 3-6 netty生命周期

```Java
channelRegistered()
channelUnregistered()
channelActive()
channelInactive()
channelReadComplete()
userEventTriggered()
userEventTriggered()
channelWritabilityChanged()
exceptionCaught()
handlerAdded()
handlerRemoved()
```

## 第4章 使用netty构建websocket服务器
## 4-1 实时通信相关概念讲解

#### 实时通信

Ajax 轮询

Long pull

websocket

## 4-2 编写websocket服务端启动类

```Java
WSServer
```

## 4-3 编写websocket子处理器initialzer

```Java
WSServerInitialzer
```

## 4-4 编写chatHandler对消息的处理

```Java
ChatHandler
```

## 4-5 基于js的websocket相关api介绍

1. ```js
   var socket = new WebSocket("ws://[ip]:[port]");
   ```

2. 生命周期：onopen()、onmessage()、onerror()、onclose()

3. 主动方法：Socket.send()、Socket.close()

## 4-6 简单实用hbuilder工具编写前端websocket

```html
index.html
```

## 4-7 测试web端携手移动端与后端netty聊天通信

## 第5章 使用MUI与H5+构建移动端app
5-1 MUI,H5+，Hbuilder介绍
5-2 创建项目，页面基本结构讲解
5-3 自定义标题栏样式
5-4 真机调试与原生标题栏样式更改
5-5 首页底部tab选项卡的使用，MUI图标库讲解
5-6 使用阿里图标库构建自己的icon库
5-7 tab选项卡切换页面（上）
5-8 tab选项卡切换页面（下）

## 第6章 使用springboot整合netty搭建后台
#### 6-1 数据库表设计

#### 6-2 使用mybatis逆向工具

#### 6-3 搭建springboot2.0工程

#### 6-4 springboot整合mybatis

#### 6-5 整合netty server

#### 6-6 完成netty整合springboot并且测试

## 第7章 用户注册/登录/个人信息
7-1 注册登录页面讲解与后端接口开发1
7-2 注册登录页面讲解与后端接口开发2
7-3 登录注册页面的判断事件与js自定义util
7-4 登录注册前后端联调
7-5 首页禁止返回和用户自动登录讲解
7-6 开发我的个人页面
7-7 动态初始化个人信息
7-8 打开个人头像页面
7-9 增加可选择菜单
7-10 为菜单增加事件绑定
7-11 选择照片与裁剪插件
7-12 文件服务器概览
7-13 安装tracker服务
7-14 安装storage服务
7-15 配置client并且上传测试图片
7-16 nginx安装与fastdfs配置（上）
7-17 nginx安装与fastdfs配置（下）
7-18 fastdfs 整合springboot
7-19 后端上传图片功能开发
7-20 上传图片前后端联调与测试
7-21 头像上传后跨页面调用自定义事件刷新
7-22 上传头像细节部分处理与openwindow的bug处理
7-23 下载头像到相册
7-24 修改昵称页面
7-25 修改昵称后端接口
7-26 修改昵称前后端联调
7-27 用户二维码生成
7-28 我的二维码作业布置
7-29 我的二维码作业讲解
7-30 用户退出以及简单小结

## 第8章 发现页面与通讯录相关功能开发
8-1 发现页面编码
8-2 搜索朋友账号接口（上）
8-3 搜索朋友账号接口（下）
8-4 搜索朋友前后端联调
8-5 搜索结果页讲解以及webview传参
8-6 发送添加好友请求接口编码
8-7 前后端连天发送好友请求
8-8 查询好友请求接口
8-9 朋友接受到请求页面联调开发
8-10 好友请求HTML动态渲染
8-11 同意或忽略事件动态绑定
8-12 同意或忽略controller
8-13 同意或忽略的service编写
8-14 好友请求忽略或拒绝前后台联调
8-15 构建扫描器
8-16 扫码器颜色自定义
8-17 扫码添加好友联调
8-18 延时加载预处理数据
8-19 mui 自带索引列表模板讲解
8-20 通讯录列表整合
8-21 图文列表和通讯录整合增加用户头像显示
8-22 查询用户的所有好友列表接口
8-23 手机端获取好友列表保存到本地
8-24 定义通讯录好友列表模型
8-25 通讯录列表渲染展现
8-26 好友请求接收方更新通讯录
## 第9章 聊天页面开发
9-1 聊天页面讲解与展示
9-2 header动态改为好友昵称，动态滚动到最新消息
9-3 发送按钮的颜色状态改变
9-4 弹出软键盘重新设置聊天窗口高度
9-5 发送消息前置条件网络状态判断
9-6 监听网络连接事件
9-7 发送消息html渲染
9-8 接收消息html渲染
9-9 发送消息与接收消息时的铃声播放
9-10 手机端websocket模型定义和发送消息
9-11 websocket接受消息的渲染_x264
9-12 服务器断开后的重连机制
9-13 chatHandler初步重构
9-14 构建聊天业务模型
9-15 chatHandler - 处理客户端连接
9-16 chatHandler - 保存聊天消息到数据库
9-17 chatHandler - 处理消息发送
9-18 chatHandler - 签收单条或多条消息
9-19 客户端onopen联调，初始化用户和channel关系
9-20 客户端发送消息与接收联调
9-21 接收方获得消息后重构渲染
9-22 客户端签收消息
9-23 websocket新增好友类型联调
9-24 保存聊天记录到本地
9-25 从本地获取聊天记录
9-26 初始化聊天记录和渲染
9-27 聊天快照业务简单讲解
9-28 保存聊天快照到本地
9-29 获取聊天快照
9-30 已读未读消息的设置与快照调用
9-31 展示聊天快照
9-32 未读消息小红点标记
9-33 点击快照开始聊天
9-34 未读消息标记已读
9-35 开发获取未读消息列表接口
9-36 前端获取未读消息列表
9-37 批量签收并且展示未读消息
9-38 聊天快照左滑删除效果
9-39 聊天快照右滑删除聊天记录与快照
## 第10章 使用netty编写心跳检测
10-1 心跳机制的概念与飞行模式
10-2 心跳HeartBeatHandler编码
10-3 配置空闲handler与超时时间设置
10-4 手机端与netty的心跳测试
10-5 前端keepalive保持，与心跳测试

## 第11章 后端云部署与app云打包
11-1 云服务器购买推荐及安全组介绍与关联
11-2 文件传输工具的使用
11-3 命令行工具的简单使用
11-4 云服务器配置JDK环境
11-5 云服务器安装tomcat
11-6 云服务器离线安装MariaDB
11-7 云服务器MariaDB安全设置与客户端连接调试
11-8 云服务器安装图片服务器的注意事项以及nginx反向代理tomcat服务器
11-9 springboot工程打包
11-10 打包文件上传到云服务器并且进行tomcat部署
11-11 app云打包