//package com.kaitaiming.rocketMq;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.util.Bytes;
//
//public class testHbase {
//	private static String  rowkey = null;
//	public static int dz(int i){  
//        String te="";  
//          if (i>10) {  
//           te+=dz(i/10)+"";  
//           
//          }  
//          System.out.println((i%10)+te);
//          return Integer.parseInt((i%10)+te);  
//    }  
//    public static int f(int n) {  
//        if (1 == n)   
//            return 1;  
//        else   
//            return n*f(n-1);  
//    }  
//    public static long method1(){
//    	
//    	rowkey = "1";
//		return 0;
//    	
//    }
//    
//    
//    public static long method2(){
//    	
//    	System.out.println(rowkey);
//		return 0;
//    	
//    }
//    
//    
//    
//    
//	public static void main(String[] args) throws IOException {
//		// deleteAllColumn("test", rowKey);
//		
////		System.out.println(dz(456));
////		System.out.println(f(5));
////		String tableName = "test03"; // 表名
////		String rowkey = null;
////		String family = "col_1";
////		String family2 = "col_2";
////		String row_key = "93300002700072574862_71885_1_6300595231696618366_20170808155716";
////		
////		String[] rlist = {"row"};
////		float b = 1201.2f;
//					  
////		String bbb = String.valueOf(asdasd);
////		System.out.println(bbb);
////		method1();
////		method2();
////		System.out.println(dz(120));
//		
//		
//		
//		
//		
////		/**
////		 * claim
////		 */
////		String tname = "hbase_claim";
////		String[] cfname = { "ClaimId", "TopInsuranceCompanyId", "InsuranceCompanyId", "ClaimNumber", "AcceptTime",
////				"TotalValue", "ClaimType", "IsMostRecent", "IsExistPhoto", "SystemCheckRusult", "checkState",
////				"claimStage", "caseType", "RegistrationNumber", "BrandInsuranceCompanyId" };
//		/**
//		 * claimreportinfo
//		 */
//		String tname = "hbase_claimreportinfo";
//		String[] cfname = { "id", "ClaimId", "Reporter", "ReporterContact", "ReportDate", "IsRemoteAccident",
//				"AccidentDate", "AccidentAddress", "AccidentReason", "AccidentType", "AccidentDescription",
//				"ReporterIsInsured", "ReporterIsDriver", "Driver", "DriverGender", "ReportedOnSite", "PolicyHolderName",
//				"PolicyHolderTel", "AccidentResponsibility", "DisposeDepartment", "DisposeType", "Remark",
//				"PoliceDisposeDesc", "reportMode", "historyDamageTimes" };
////		/**
////		 * investigationinfo
////		 */
////		String tname = "hbase_investigationinfo";
////		String[] cfname = { "Id", "claimId", "Investigator", "InvestigatorName", "InvestigationDate",
////				"InvestigationAddress", "AccidentReason", "AccidentType", "LossCategory", "ThirdPartyVehicleCount",
////				"RiskCategory", "ClaimSettlementType", "TotalRescueFee", "Remark", "InsuranceTypeId",
////				"accidentResponsibility", "disposeType", "urgency", "isSimpleClaim", "hasInjuredPerson", "sceneType",
////				"accidentAddress", "investigationComments", "Operator", "operationTime", "operationEquipmentType",
////				"payoutType" };
////		/**
////		 * insurancepolicyinfo
////		 */
////		String tname = "hbase_insurancepolicyinfo";
////		String[] cfname = { "Id", "PolicyNo", "InsuranceCompanyId", "policyIssuingOrg", "drivingLicenseOwner",
////				"purchasePrice", "specialAgreement", "insuredType", "customerType", "PolicyTypeId",
////				"InsuranceStartDate", "InsuranceEndDate", "Applicant", "InsuredPersonName", "InsuredPersonIDNumber",
////				"InsuredPersonAddress", "InsuredPersonTel", "Premium", "SignedDate", "isNewEquipmentInsured",
////				"isDesinatedDriver", "AccidentsCount", "VehicleId", "Remark", "channelCode", "channelName" };
////		/**
////		 * claiminsurancepolicy
////		 */
////		String tname = "hbase_claiminsurancepolicy";
////		String[] cfname = { "id", "claimId", "InsurancePolicyId", "vehicleId", "insuranceCompanyId" };
////		/**
////		 * policyriskcoverage
////		 */
////		String tname = "hbase_policyriskcoverage";
////		String[] cfname = { "id", "insurancePolicyId", "policyBillNo", "riskClassName", "riskClassCode",
////				"insuranceStartDate", "insuranceEndDate", "deductibleRate", "deductible", "premium", "insuranceAmount",
////				"remark" };
////		/**
////		 * LossAssessmentInfo
////		 */
////		String tname = "hbase_LossAssessmentInfo";
////		String[] cfname = { "Id", "ClaimId", "lossAssessingTime", "lossAssessingAddress", "lossAssessorName",
////				"lossAssessorCode", "RepairFactoryId", "repairFactoryType", "remark", "insuranceCompanyId",
////				"LossAssessmentComCode", "Operator", "operationTime", "operationEquipmentType", "operationEquipmentID",
////				"VehicleId", "rescueFee", "repairShopType" };
////		/**
////		 * accidentvehicle
////		 */
////		String tname = "hbase_accidentvehicle";
////		String[] cfname = { "Id", "claimId", "userType", "UsageAge", "PurchasePrice", "VehicleTypeId", "EngineNumber",
////				"GearboxType", "ApprovedPassenger", "ApprovedCapacity", "Displacement", "enginecapacity",
////				"ProductionDate", "RegistrationNumber", "WithNo", "VIN", "VehicleModelId", "isMainCar", "Manufacturer",
////				"VehicleBrandId", "NumberOfSeats", "VehicleSeriesId", "accidentCount", "VehicleModelName",
////				"createTime" };
////		/**
////		 * LossSparePart
////		 */
////		String tname = "hbase_LossSparePart";
////		String[] cfname = { "Id", "LossAssessmentId", "OEMCode", "VehiclePartId", "SparePartName", "RiskClass", "Price",
////				"Quantity", "PriceType", "isManuallyInputted", "Remark", "PriceSourceId", "ClaimId", "VehicleId",
////				"claimPartsName", "suggestQuantity", "suggestPrice", "createTime" };
////		/**
////		 * LossLabor
////		 */
////		String tname = "hbase_LossLabor";
////		String[] cfname = { "Id", "LossAssessmentId", "VehicleId", "ClaimId", "RepairedItemName", "RepairTypeId",
////				"VehiclePartId", "RepairTypeName", "RiskClass", "InputtedManually", "Price", "Quantity", "Remark",
////				"claimPartsName", "suggestPrice", "suggestQuantity" };
////		/**
////		 * LossAuxiliarySparePart
////		 */
////		String tname = "hbase_LossAuxiliarySparePart";
////		String[] cfname = { "Id", "claimId", "LossAssessmentId", "VehicleId", "SmallSparePartName", "VehiclePartId",
////				"RiskClass", "InputtedManually", "Price", "Quantity", "Remark" };
////		/**
////		 * vehicleclaimhistory
////		 */
////		String tname = "hbase_vehicleclaimhistory";
////		String[] cfname = { "id", "claimNumber", "reporter", "reportTime", "reporterPhone", "driverName", "vehicleNo",
////				"accidentDate", "accidentCause", "wholeCaseStatus", "endCaseDate", "dutyChineseName", "accidentType",
////				"claimId" };
////		/**
////		 * claimvehicle
////		 */
////		String tname = "hbase_claimvehicle";
////		String[] cfname = { "id", "vehicleId", "isMainCar", "claimId" };
////		/**
////		 * lossassessmentcomment
////		 */
////		String tname = "hbase_lossassessmentcomment";
////		String[] cfname = { "claimId", "lossAssessmentId", "claimNumber", "orgCode", "orgName", "commentAuthor", "role",
////				"datetime", "commentCode", "commentName", "comment" };
////		/**
////		 * vehiclehistory
////		 */
////		String tname = "hbase_vehiclehistory";
////		String[] cfname = { "id", "vin", "claimId", "claimNumber", "regNumber", "vehicleModelId", "vehicleSeriesId",
////				"vehicleBrandId", "accidentReason", "accidentAddress", "accidentDate", "repairFactoryName",
////				"repairFactoryTypeId" };
////		/**
////		 * outfixlosslabor
////		 */
////		String tname = "hbase_outfixlosslabor";
//		
////		String[] cfname = { "Id", "LossAssessmentId", "VehicleId", "ClaimId", "RepairedItemName", "RepairTypeId",
////				"VehiclePartId", "RepairTypeName", "RiskClass", "InputtedManually", "Price", "Quantity", "Remark",
////				"claimPartsName", "suggestPrice", "suggestQuantity" };
////		/**
////		 * claimtotalvaluechange
////		 */
////		String tname = "hbase_claimtotalvaluechange";
////		String[] cfname = { "claimId", "branchCompanyId", "claimNumber", "registritionNumber", "firstAcceptTime",
////				"systemCheckRusult", "firstTotalValue", "modelName", "lastAcceptTime", "lastTotalValue", "companyId" };
////
//		MyHbase hu = new MyHbase();
//		hu.isexsit(tname, cfname);
////		 hu.droptable(tname);
//		 
//		 
//		 
//		 ArrayList<String> rlist = new ArrayList<String>();
//		 for (int i = 0; i < 20; i++) {
//			 rlist.add("row"+"_"+i);
//		}
//		 String tableName = "test04";
////		 hu.close();
////		System.out.println(String.valueOf(b));
////		hu.scanresult("test03");
////		hu.update(tableName, "shiwenkang");
////		 hu.getresult("test03", row_key, "cf1", "BrandInsuranceCompanyId");
////		 hu.getresult("test03", "row_2", "col_1", "id");
////		hu.add(tableName, rlist);
////		hu.select( tableName,  "col") ;
////		 hu.createtable(tableName, family);
////		 hu.add(tableName,rlist); //添加方法
//		// deleteAllColumn(tableName, rlist); //删除方法
//		// getresult(tableName,rlist,family,"id");
////		 scanresult(tableName);
////		System.out.println(String.valueOf(System.currentTimeMillis()));// 1501652836120
//		 
////		 hu.droptable("hbase_claimreportinfo");
//		 
//
//	}
//}