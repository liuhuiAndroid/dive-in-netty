# 第1章 课程介绍

## 1-1 Netty深入剖析

#### Netty是什么？

异步事件驱动框架，用于快速开发高性能服务端和客户端

封装了JDK底层BIO和NIO模型，提供高度可用的API

自带编解码器解决拆包粘包问题，用户只用关心业务逻辑

精心设计的reactor线程模型支持高并发海量连接

自带各种协议栈让你处理任何一种通用协议都几乎不用亲自动手

# 第2章 Netty基本组件

## 2-1 一个简单的socket例子

1. 监听端口
2. 创建新连接
3. 服务端接收客户端发送的数据
4. 服务端处理业务逻辑
5. 服务端发送数据给客户端

## 2-2 Netty对于socket的抽象

1. 监听端口：NioEventLoop
2. 创建新连接：Channel
3. 服务端接收客户端发送的数据：ByteBuf
4. 服务端处理业务逻辑：ChannelHandler、Pipeline
5. 服务端发送数据给客户端：

## 2-3 Netty组件简单介绍

NioEventLoop：相当于Thread

Channel：相当于Socket

ByteBuf：IO Bytes

Pipeline：逻辑处理链

ChannelHandler：Logic

# 第3章 Netty服务端启动

## 3-1 服务端启动demo
## 3-2 服务端Channel的创建

#### 问题：

服务端的socket在哪里初始化？

在哪里accept连接？

#### Netty服务端启动步骤

1. 创建服务端Channel

   ```java
   1. bind()【用户代码入口】
   2. initAndRegister()【初始化并注册】
   3. newChannel()【创建服务端channel】
   4. init()【初始化服务端channel】
   
   其中，反射创建服务端Channel
   1. newSocket()【通过jdk来创建底层jdk channel】
   2. NioServerSocketChannelConfig()【tcp参数配置类】
   3. AbstractNioChannel()
       configureBlocking(false)【阻塞模式】
       AbstractChannel()【构造函数创建id，unsafe，pipeline】
   ```

2. 初始化服务端Channel

   ```
   init()【初始化入口】
   	set ChannelOptions,ChannelAttrs
   	set ChildOptions,ChildAttrs
   	config handler【配置服务端pipeline】
   	add ServerBootstrapAcceptor【添加连接器】
   ```

3. 注册selector

   ```
   AbstractChannel.register(channel)【入口】
   	this.eventLoop = eventLoop【绑定线程】
   	register0()【实际注册】
   		doRegister()【调用jdk底层注册】
   		invokeHandlerAddedIfNeeded()
   		fireChannelRegistered()【传播事件】
   ```

4. 端口绑定

   ```
   AbstractBootstrap.bind()【入口】
   	doBind()
   		channel.bind()【jdk底层绑定】
   	pipeline.fireChannelActive()【传播事件】
   		HeadContext.readIfIsAutoRead()
   ```

## 3-6 服务端启动总结

```
newChannel() -> init() -> register() -> doBind()
```

# 第4章 NioEventLoop

## 4-1 NioEventLoop概述

## 4-2 NioEventLoop创建概述

## 4-3 ThreadPerTaskThread

## 4-4 创建NioEventLoop线程

## 4-5 创建线程选择器

## 4-6 NioEventLoop的启动

## 4-7 NioEventLoop执行概述

## 4-8 检测IO事件

## 4-9 处理IO事件

## 4-10 -reactor线程任务的执行

## 4-11 -NioEventLoop总结

# 第5章 新连接接入

## 5-1 新连接接入概述

## 5-2 新连接检测

## 5-3 NioSocketChannel的创建

## 5-4 Channel的分类

## 5-5 新连接NioEventLoop的分配和selector注册

## 5-6 NioSocketChannel读事件的注册

## 5-7 新连接接入总结

# 第6章 pipeline

6-1 pipeline概述
6-2 pipeline初始化
6-3 添加ChannelHandler
6-4 删除ChannelHandler
6-5 inBound事件的传播
6-6 outBound事件的传播
6-7 异常的传播
6-8 pipeline总结.mp4

# 第7章 ByteBuf

7-1 内存分配概述
7-2 ByteBuf结构以及重要api
7-3 ByteBuf分类
7-4 内存分配器ByteBufAllocator分析
7-5 UnPooledByteBufAllocator分析
7-6 PooledByteBufAllocator概述
7-7 directArena分配direct内存的流程
7-8 内存规格的介绍
7-9 缓存数据结构
7-10 命中缓存的分配流程
7-11 arena、chunk、page、subpage概念
7-12 page 级别内存分配
7-13 subpage 级别的内存分配
7-14 ByteBuf的回收
7-15 总结

# 第8章 Netty解码

8-1 Netty解码概述
8-2 抽象解码器ByteToMessageDecoder
8-3 基于固定长度解码器分析
8-4 行解码器分析
8-5 基于分隔符解码器分析
8-6 基于长度域解码器参数分析
8-7 基于长度域解码器分析
8-8 解码器总结

# 第9章 Netty编码及writeAndFlush()

9-1 Netty编码概述
9-2 writeAndFlush()抽象步骤
9-3 抽象编码器MessageToByteEncoder
9-4 写buffer队列
9-5 刷新buffer队列
9-6 总结

# 第10章 Netty性能优化工具类解析

10-1 性能优化工具类概述
10-2 FastThreadLocal的使用
10-3 FastThreadLocal的创建和get()实现
10-4 FastThreadLocal的set实现
10-5 Recycler的使用
10-6 Recycler的创建
10-7 从Recycler中获取对象
10-8 同线程回收对象
10-9 异线程回收对象
10-10 异线程收割对象
10-11 性能优化工具类总结

# 第11章 Netty设计模式应用

11-1 单例模式在Netty里面的应用
11-2 策略模式在Netty里面的应用
11-3 装饰者模式在Netty里面的应用
11-4 观察者模式在Netty里面的应用
11-5 迭代器模式在Netty里面的应用
11-6 责任链模式在Netty里面的应用

# 第12章 Netty高性能并发调优

12-1 性能调优概述
12-2 单机百万连接模拟与瓶颈
12-3 单机百万连接调优过程
12-4 Netty应用级别性能瓶颈
12-5 Netty应用级别性能调优过程

# 第13章 课程总结

13-1 课程回顾和总结