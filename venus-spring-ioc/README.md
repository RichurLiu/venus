### IoC

#### 1.依赖查找
- 根据Bean名称查找
    - 实时查找
    - 延迟查找
- 根据bean类型查找
    - 单个Bean对象
    - 集合Bean对象
- 根据Bean名称和类型查找
- 根据Java注解查找
    - 单个Bean对象
    - 集合Bean对象

#### 2.依赖注入（再看23）
- 根据Bean名称注入
- 根据bean类型注入
    - 单个Bean对象
    - 集合Bean对象
- 注入容器内建Bean对象
- 注入非Bean对象
- 注入类型
    - 实时查找
    - 延迟查找

#### 3.依赖来源
- 自定义Bean
- 容器内建Bean对象
- 容器自建依赖

#### 4.配置元信息
- Bean定义配置
    - 基于XML文件
    - 基于Properties文件
    - 基于Java注解
    - 基于Java API
- IoC容器配置
    - 基于XML文件
    - 基于Java注解
    - 基于Java API
- 外部化属性配置
    - 基于Java注解

#### 5.容器
- BeanFactory 和 ApplicationContext 的区别

BeanFactory是更底层的实现，ApplicationContext复合了BeanFactory，并提供了贡多的更能。

#### 6.Spring 应用上下文
- 面向切面（AOP）
- 配置元信息（Configuration Meta）
- 资源管理（Resources）
- 事件（Events）
- 国际化
- 注解（Annotation）
- Environment抽象

#### 7.使用Spring IoC 容器

#### 8.Spring IoC 容器生命周期

#### 9.面试精选

