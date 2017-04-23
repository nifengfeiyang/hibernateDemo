级联（cascade）属性
1、CascadeType.ALL（包括增、删、改、查，联动操作），其实查不算在内，查Fetch
2、CascadeType.MERGE（合并的join）--不重要
3、CascadeType.PERSIST（保存的时候在级联）
4、CascadeType.REFRESH（刷新说明：比如现在我查询出了数据，另外一个人在我查询数据之后，他对数据做了修改，这是才会级联上，hibernate会自动刷新我查询出来的数据）
5、CascadeType.REMOVE （只要在删除操作时才会级联）
6、我们一般都只设置CascadeType.ALL就OK了，
7、Cascade不是必须的，他的作用只是可以让我们快速的开发，我们也可以通过手动增、删、改、查

Fetch捉取策略
1、FetchType.EAGER（渴望的，希望马上得到）
a)    一对多关系，比如通过get()方法来get出一的一端，他只会出一条SQL语句，不会自动去查询多的一端，如果设置FetchType.EAGER，会讲他的关联对象查询出来
b)    如果是load的话，他不会发出SQL语句，因为load支持延迟加载，只有真正获取数据时才会发SQL
2、FetchType.LAZY（懒加载）
a)    只有真正获取数据时才发出SQL语句
3、默认是：FetchType.LAZY（一对多）
4、默认是：FetchType.EAGER（多对一）
5、一般使用默认就可以了