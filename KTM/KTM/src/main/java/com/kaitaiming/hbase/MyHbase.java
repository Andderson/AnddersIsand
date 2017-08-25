//package com.kaitaiming.hbase;
//
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.Cell;
//import org.apache.hadoop.hbase.CellUtil;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.HColumnDescriptor;
//import org.apache.hadoop.hbase.HTableDescriptor;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.filter.CompareFilter;
//import org.apache.hadoop.hbase.filter.Filter;
//import org.apache.hadoop.hbase.filter.PrefixFilter;
//import org.apache.hadoop.hbase.filter.RowFilter;
//import org.apache.hadoop.hbase.filter.SubstringComparator;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import com.sun.jdi.Value;
//
//
//public class MyHbase {
//	public static Configuration config = null;
//	public static Connection connection = null;
//	public static Admin admin = null;
//    public long swenk = 12345678912L;
//	/**
//	 * 初始化连接
//	 */
//	public static void init() {
//		System.out.println("初始化连接开始");
//		Configuration conf = new Configuration();
//		// 配置zk主机
//		conf.set("hbase.zookeeper.quorum", "namenode,datanode2,datanode3");
//		// 配置端口
//		conf.set("hbase.zookeeper.property.clientPort", "2181");
//		// hbaseconfig加载配置
//		config = HBaseConfiguration.create(conf);
//		
//		try {
//			connection = ConnectionFactory.createConnection(config);
//			
//			admin = connection.getAdmin();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//	  
//    //关闭连接  
//    public    void close(){  
//        try {  
//            if(null != admin)  
//                admin.close();  
//            System.out.println("drop admin OK");
//            if(null != connection)  
//                connection.close();  
//            System.out.println("drop connection OK");
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        }  
//  
//    } 
//    public void isexsit(String tname,String[] cfname){
//    	init();
//    	TableName tableName = TableName.valueOf(tname);
//    	try {
//			if (admin.tableExists(tableName)) {
//				System.out.println("********************************************");
//				System.out.println("Table:" + tableName + " exist ！！！！！！！！");
//				System.out.println("********************************************");
//			} else {
//				HTableDescriptor table = new HTableDescriptor(tableName);
//				System.out.println("*******************"+table);
//				for (int i = 0; i < cfname.length; i++) {
//					table.addFamily(new HColumnDescriptor( cfname[i]));
//					System.out.println(cfname[i]);
//				}
//				admin.createTable(table);
//				System.out.println("********************************************");
//				System.out.println("create table success! TableName:[" + tableName + "] ");
//				System.out.println("********************************************");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	close();
//    }
//    public void create(String tname, String[] cfname){
//    	init();
//    	
//    	
//    }
//	/**
//	 * 创建表
//	 * 
//	 * @throws IOException
//	 * 
//	 * 
//	 */
//	public  void createtable(String tableName, String family) throws IOException {
//		init();
//		System.out.println("初始化连接结束");
//		String[]  cfname = {"ID","NAME","AGE"};
//		System.out.println("*******************");
//		isexsit(tableName,cfname);
//		
//		Table table = connection.getTable(TableName.valueOf(tableName));
//		String rk1 = "row_swenk_1";
//		String rk2 = "row_shiwenkang_2";
//		String rk3 = "col_swenk_3";
//		// 根据行键创建put对象，put包含对应参数信息
//		Put put = new Put(Bytes.toBytes(rk1));
//		Put put2 = new Put(Bytes.toBytes(rk2));
//		Put put3 = new Put(Bytes.toBytes(rk3));
//		// 补足信息
//		long  aa  = 4564564l;
//		Integer    bb  = 54555555 ;
//		put.addColumn(Bytes.toBytes(cfname[0]), Bytes.toBytes(cfname[0]), Bytes.toBytes(String.valueOf(1)));      //int
//		put.addColumn(Bytes.toBytes(cfname[1]), Bytes.toBytes(cfname[1]), Bytes.toBytes("第一个"));  //string
//		put.addColumn(Bytes.toBytes(cfname[2]), Bytes.toBytes(cfname[2]), Bytes.toBytes(String.valueOf(80)));    //int
//		table.put(put);
//		System.out.println("ADD AllColumn Success:" + rk1 + "!");
//		put2.addColumn(Bytes.toBytes(cfname[0]), Bytes.toBytes(cfname[0]), Bytes.toBytes(     String.valueOf(2)     ));
//		put2.addColumn(Bytes.toBytes(cfname[1]), Bytes.toBytes(cfname[1]), Bytes.toBytes(      "第二个"              ));
//		put2.addColumn(Bytes.toBytes(cfname[2]), Bytes.toBytes(cfname[2]), Bytes.toBytes(    String.valueOf(90)   ));
//		// 在table上提交
//		table.put(put2);
//		System.out.println("ADD AllColumn Success:" + rk2 + "!");
//		put3.addColumn(Bytes.toBytes(cfname[0]), Bytes.toBytes(cfname[0]), Bytes.toBytes(String.valueOf(3)));      //int
//		put3.addColumn(Bytes.toBytes(cfname[1]), Bytes.toBytes(cfname[1]), Bytes.toBytes("第三个"));  //string
//		put3.addColumn(Bytes.toBytes(cfname[2]), Bytes.toBytes(cfname[2]), Bytes.toBytes(String.valueOf(100)));    //int
//		table.put(put3);
//		System.out.println("ADD AllColumn Success:" + rk3 + "!");
//		
//		table.close();
//		close();
//	}
//	public void select(String tableName, String row) {
//		// TODO Auto-generated method stub
//		//初始化连接
//
//		init();
//		Table table = null;
//		String age =null;
//		Set<String> set = new HashSet<String>();
//		//更改后的值
//		Scan scan = new Scan();
//		try {
//			table = connection.getTable(TableName.valueOf(tableName));
//			//new SubstringComparator(rowkey:参数为行键内包含字段) 
////			Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(rowkey));
//			//根据行键前缀过滤
//			Filter filter = new PrefixFilter(Bytes.toBytes(row));
//			scan.setFilter(filter);
//			ResultScanner scanner = table.getScanner(scan);
//			//收集满足条件行键
//			for (Result result : scanner) {
//				for (Cell cell : result.listCells()) {
//					set.add(Bytes.toString(cell.getRowArray(),cell.getRowOffset(),cell.getRowLength()));
//					System.out.println("满足行键前缀为ROW的行键为："+Bytes.toString(cell.getRowArray(),cell.getRowOffset(),cell.getRowLength()));
//				}
//			}
//			//遍历行键  取车牌号
//			for (String result : set) {
//				//配置行键设置获取车牌号
//				Get getRn = new Get(Bytes.toBytes(result));
//				//配置行键设置获取claimid
//				Get getCi = new Get(Bytes.toBytes(result));
//				//配置更新
//				Put put = new Put(Bytes.toBytes(result));
//				
//				//配置车牌号列动作
//				getRn.addColumn(Bytes.toBytes("AGE"), Bytes.toBytes("AGE")); 
//				Result registritionNumber = table.get(getRn);
//				for (Cell resnumber : registritionNumber.listCells()) {
//					String res = Bytes.toString(resnumber.getValueArray(), resnumber.getValueOffset(), resnumber.getValueLength());
//					System.out.println("行键["+result+"]的数据行，AGE为："+res);
//					if (res.equals("100")) {
//						
//						//如果相等  取ID
//						getCi.addColumn(Bytes.toBytes("ID"), Bytes.toBytes("ID")); 
//						Result claimid = table.get(getCi);
//						for (Cell result2 : claimid.listCells()) {
//							long aa = (Long.parseLong(Bytes.toString(result2.getValueArray(),result2.getValueOffset(),result2.getValueLength())));
//							System.out.println("当岁数为["+res+"]时候，此人的ID："+aa);
//							age = String.valueOf(aa);
//							
//							System.out.println("更新前");
//							put.addColumn(Bytes.toBytes("ID"), Bytes.toBytes("ID"), Bytes.toBytes("9999999999"));
//							
//							table.put(put);
//							long bb = (Long.parseLong(Bytes.toString(result2.getValueArray(),result2.getValueOffset(),result2.getValueLength())));
//							System.out.println("更细金数据："+bb);
//							System.out.println("更新后");
//						}
//						//如果相等  就更新
//						
//						
//					}else {
//						System.out.println("小伙砸你不到110，"+res+"岁还敢出来造次????");
//					}
//			}
//				
//}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if (table!= null) {
//				try {
//					
//					table.close();
//					System.out.println("Table 成功关闭");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}	
//			}
//			close();
//			System.out.println(age);
//			System.out.println("连接成功关闭");
//		}
//	}
//
//	/**
//	 * 删除表 先disable 在delete
//	 * 
//	 * @param tableName
//	 */
//	public  void droptable(String tableName) {
//		init();
//		try {
//			if (admin.tableExists(TableName.valueOf(tableName))) {
//				System.out.println("");
//				admin.disableTable(TableName.valueOf(tableName));
//				admin.deleteTable(TableName.valueOf(tableName));
//				System.out.println("table:[" + tableName + "]  drop success！！！");
//
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		close();
//	}
//
//	/**
//	 * 添加数据
//	 * 
//	 * @param tableName
//	 *            表名
//	 * @param rlist
//	 *            行键list
//	 * 
//	 */
//	public  void add(String tableName, ArrayList<String> rlist) {
//		init();
//		// 遍历行健
//		Table table = null;
//		for (String rk : rlist) {
//
//			try {
//				// 通过hbseconfig建立连接
//				
//				// 连接到hbase的table
//				 table = connection.getTable(TableName.valueOf(tableName));
//				// 根据行键创建put对象，put包含对应参数信息
////				for (int j = 1; j < 11000000; j++) {
//					
//					Put put = new Put(Bytes.toBytes(rk));
//					// 补足信息
//					put.addColumn(Bytes.toBytes("ID"), Bytes.toBytes("ID"), Bytes.toBytes( String.valueOf(56) ));
//					put.addColumn(Bytes.toBytes("NAME"), Bytes.toBytes("NAME"), Bytes.toBytes("史文康"));
//					put.addColumn(Bytes.toBytes("AGE"), Bytes.toBytes("AGE"), Bytes.toBytes(String.valueOf(56)));
//					// 在table上提交
//					table.put(put);
//					System.out.println("ADD AllColumn Success:" + rk + "!");
////				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
////				finally {
////				if( table!=null){
////					try {
////						table.close();
////						
////					} catch (IOException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
////					}
////					
////				}
////			}
//			
//		}
//		
////		close();
//	}
//
//	/**
//	 * 删除数据
//	 * 
//	 * @param tablename
//	 *            表名
//	 * @param rlist
//	 *            行键list
//	 */
//	public static void deleteAllColumn(String tablename, ArrayList<String> rlist) {
//		for (String rk : rlist) {
//			try {
//				Connection connection = ConnectionFactory.createConnection(config);
//				Table table = connection.getTable(TableName.valueOf(tablename));
//				Delete del = new Delete(Bytes.toBytes(rk));
//				del.addColumn(Bytes.toBytes("col_1"), Bytes.toBytes("name")); // 删除制定列
//				table.delete(del);
//				System.out.println("Delete success:" + rk);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//	}
//
//	/**
//	 * 
//	 * @param tableName
//	 *            表名
//	 * @param rlist
//	 *            行键list
//	 * @param family
//	 *            列族
//	 * @param name
//	 *            列名
//	 */
//	public  void getresult(String tableName, String rowkey, String family, String name) {
//		// TODO Auto-generated method stub
//
//		
//			try {
//				init();
//				Table table = connection.getTable(TableName.valueOf(tableName));
//				// 获取GET操作
//				Get get = new Get(Bytes.toBytes(rowkey));
//				get.addColumn(Bytes.toBytes(family), Bytes.toBytes(name)); // 不指定列
//				Result result = table.get(get);
//				for (Cell cell : result.listCells()) {
//
//					System.out.println("family:"
//							+ Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength()));
//					System.out.println("colnum:" + Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(),
//							cell.getQualifierLength()));
//					System.out.println("value:"
//							+ Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength()));
//					System.out.println("-------------");
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		close();
//
//	}
//
//	/**
//	 * 全表扫描
//	 */
//	public static void scanresult(String tableName) {
//		// TODO Auto-generated method stub
//		long startTime=System.currentTimeMillis();  
//		Scan scan = new Scan();
//		try {
//			init();
//			Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator("col"));
//			
////			Filter filter = new PrefixFilter(Bytes.toBytes("col"));
//			scan.setFilter(filter);
//			Table table = connection.getTable(TableName.valueOf(tableName));
//			ResultScanner rsscan = table.getScanner(scan);
//			for (Result result : rsscan) {
//				System.out.println("***************************************************");
//				for (Cell cell : result.listCells()) {
//					System.out.println("family:"
//							+ Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength()));
//					System.out.println("qualifer:" + Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(),
//							cell.getQualifierLength()));
//					System.out.println("value:"+ Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
//					System.out.println("timestamp:" + cell.getTimestamp());
//				}
//			}
//			System.out.println("***************************************************");
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		long endTime=System.currentTimeMillis(); 
//		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//	}
//	/**
//	 * 过滤器 Filter----针对行键
//	 * @param tableName
//	 * @param rowkey
//	 */
//	public  void update(String tableName, String rowkey){
//		init();
//		ArrayList<String> rklist = new ArrayList<String>();
//		Set<String> set = new HashSet<String>();
//		//更改后的值
//		Table table = null;
//		Scan scan = new Scan();
//		try {
//			table = connection.getTable(TableName.valueOf(tableName));
//			//new SubstringComparator(rowkey:参数为行键内包含字段) 
//			Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL,new SubstringComparator(rowkey));
////			Filter filter = new PrefixFilter(Bytes.toBytes(rowkey));
//			scan.setFilter(filter);
//			ResultScanner scanner = table.getScanner(scan);
//			//收集满足条件行键
//			for (Result result : scanner) {
//				for (Cell cell : result.listCells()) {
//					set.add(Bytes.toString(cell.getRowArray(),cell.getRowOffset(),cell.getRowLength()));
//				}
//			}
//			int i = 0;
//			//遍历行键  对应行键更新
//			for (String result : set) {
//				System.out.println("*************************");
//				System.out.println("获取的行键为:"+result);
//				String [] rkstr = result.split("_");
//				String rkclaimnumber = rkstr[0];
//				String rkBrandInsuranceCompanyId = rkstr[1];
//				String rkClaimStage = rkstr[2];
////				String rkClaimId = rkstr[3];
////				String rkAcceptTime = rkstr[4];
//				System.out.println("rkclaimnumber:"+rkclaimnumber);
//				System.out.println("rkBrandInsuranceCompanyId:"+rkBrandInsuranceCompanyId);
//				System.out.println("rkClaimStage:"+rkClaimStage);
//				System.out.println("需要匹配的rowkey内容："+rowkey);
////				System.out.println("rkClaimId:"+rkClaimId);
////				System.out.println("rkAcceptTime:"+rkAcceptTime);
//				if (rkBrandInsuranceCompanyId.equals(rowkey) ) {
//					Put put = new Put(Bytes.toBytes(result));
//					//要更新的值
//					put.addColumn(Bytes.toBytes("ID"), Bytes.toBytes("ID"), Bytes.toBytes(String.valueOf(""))); 
//					table.put(put);	
//					i++;
//					System.out.println("第"+i+"次put成功");
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if (table!= null) {
//				try {
//					table.close();
//					System.out.println("Table 成功关闭");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}	
//			}
//			close();
//			System.out.println("连接成功关闭");
//		}
//	}
//}
