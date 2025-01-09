package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresabancoswwgetfilterdata extends GXProcedure
{
   public empresabancoswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabancoswwgetfilterdata.class ), "" );
   }

   public empresabancoswwgetfilterdata( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      empresabancoswwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      empresabancoswwgetfilterdata.this.AV40DDOName = aP0;
      empresabancoswwgetfilterdata.this.AV41SearchTxt = aP1;
      empresabancoswwgetfilterdata.this.AV42SearchTxtTo = aP2;
      empresabancoswwgetfilterdata.this.aP3 = aP3;
      empresabancoswwgetfilterdata.this.aP4 = aP4;
      empresabancoswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV47EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      empresabancoswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV47EmpCod = GXt_int1 ;
      GXt_int3 = AV48CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      empresabancoswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV48CliCod = GXt_int3 ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaBancos", GXv_boolean6) ;
      empresabancoswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV40DDOName), "DDO_EMPBANDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPBANDESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV40DDOName), "DDO_EMPBANCBU") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPBANCBUOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV40DDOName), "DDO_EMPBANSUC") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPBANSUCOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV40DDOName), "DDO_EMPCUENTABANC") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPCUENTABANCOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV43OptionsJson = AV30Options.toJSonString(false) ;
      AV44OptionsDescJson = AV32OptionsDesc.toJSonString(false) ;
      AV45OptionIndexesJson = AV33OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV35Session.getValue("EmpresaBancosWWGridState"), "") == 0 )
      {
         AV37GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EmpresaBancosWWGridState"), null, null);
      }
      else
      {
         AV37GridState.fromxml(AV35Session.getValue("EmpresaBancosWWGridState"), null, null);
      }
      AV51GXV1 = 1 ;
      while ( AV51GXV1 <= AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV51GXV1));
         if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANDESCRIP") == 0 )
         {
            AV15TFEmpBanDescrip = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANDESCRIP_SEL") == 0 )
         {
            AV14TFEmpBanDescrip_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFEmpBanDescrip_Sels.fromJSonString(AV14TFEmpBanDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANCBU") == 0 )
         {
            AV18TFEmpBanCBU = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANCBU_SEL") == 0 )
         {
            AV17TFEmpBanCBU_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFEmpBanCBU_Sels.fromJSonString(AV17TFEmpBanCBU_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANSUC") == 0 )
         {
            AV21TFEmpBanSuc = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANSUC_SEL") == 0 )
         {
            AV20TFEmpBanSuc_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFEmpBanSuc_Sels.fromJSonString(AV20TFEmpBanSuc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPBANTIPCUEN_SEL") == 0 )
         {
            AV23TFEmpBanTipCuen_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFEmpBanTipCuen_Sels.fromJSonString(AV23TFEmpBanTipCuen_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCUENTABANC") == 0 )
         {
            AV26TFEmpCuentaBanc = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCUENTABANC_SEL") == 0 )
         {
            AV25TFEmpCuentaBanc_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV27TFEmpCuentaBanc_Sels.fromJSonString(AV25TFEmpCuentaBanc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV46MenuOpcCod = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV51GXV1 = (int)(AV51GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEMPBANDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV15TFEmpBanDescrip = AV41SearchTxt ;
      AV16TFEmpBanDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV53Empresabancoswwds_1_tfempbandescrip = AV15TFEmpBanDescrip ;
      AV54Empresabancoswwds_2_tfempbandescrip_sels = AV16TFEmpBanDescrip_Sels ;
      AV55Empresabancoswwds_3_tfempbancbu = AV18TFEmpBanCBU ;
      AV56Empresabancoswwds_4_tfempbancbu_sels = AV19TFEmpBanCBU_Sels ;
      AV57Empresabancoswwds_5_tfempbansuc = AV21TFEmpBanSuc ;
      AV58Empresabancoswwds_6_tfempbansuc_sels = AV22TFEmpBanSuc_Sels ;
      AV59Empresabancoswwds_7_tfempbantipcuen_sels = AV24TFEmpBanTipCuen_Sels ;
      AV60Empresabancoswwds_8_tfempcuentabanc = AV26TFEmpCuentaBanc ;
      AV61Empresabancoswwds_9_tfempcuentabanc_sels = AV27TFEmpCuentaBanc_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1967EmpBanDescrip ,
                                           AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                           A1968EmpBanCBU ,
                                           AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                           A1969EmpBanSuc ,
                                           AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                           A1970EmpBanTipCuen ,
                                           AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                           A1971EmpCuentaBanc ,
                                           AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                           Integer.valueOf(AV54Empresabancoswwds_2_tfempbandescrip_sels.size()) ,
                                           AV53Empresabancoswwds_1_tfempbandescrip ,
                                           Integer.valueOf(AV56Empresabancoswwds_4_tfempbancbu_sels.size()) ,
                                           AV55Empresabancoswwds_3_tfempbancbu ,
                                           Integer.valueOf(AV58Empresabancoswwds_6_tfempbansuc_sels.size()) ,
                                           AV57Empresabancoswwds_5_tfempbansuc ,
                                           Integer.valueOf(AV59Empresabancoswwds_7_tfempbantipcuen_sels.size()) ,
                                           Integer.valueOf(AV61Empresabancoswwds_9_tfempcuentabanc_sels.size()) ,
                                           AV60Empresabancoswwds_8_tfempcuentabanc ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV47EmpCod) ,
                                           Integer.valueOf(AV48CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV53Empresabancoswwds_1_tfempbandescrip = GXutil.concat( GXutil.rtrim( AV53Empresabancoswwds_1_tfempbandescrip), "%", "") ;
      lV55Empresabancoswwds_3_tfempbancbu = GXutil.concat( GXutil.rtrim( AV55Empresabancoswwds_3_tfempbancbu), "%", "") ;
      lV57Empresabancoswwds_5_tfempbansuc = GXutil.concat( GXutil.rtrim( AV57Empresabancoswwds_5_tfempbansuc), "%", "") ;
      lV60Empresabancoswwds_8_tfempcuentabanc = GXutil.concat( GXutil.rtrim( AV60Empresabancoswwds_8_tfempcuentabanc), "%", "") ;
      /* Using cursor P023Q2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV48CliCod), Short.valueOf(AV47EmpCod), lV53Empresabancoswwds_1_tfempbandescrip, lV55Empresabancoswwds_3_tfempbancbu, lV57Empresabancoswwds_5_tfempbansuc, lV60Empresabancoswwds_8_tfempcuentabanc});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk23Q2 = false ;
         A1966EmpBanCod = P023Q2_A1966EmpBanCod[0] ;
         A3CliCod = P023Q2_A3CliCod[0] ;
         A1EmpCod = P023Q2_A1EmpCod[0] ;
         A1971EmpCuentaBanc = P023Q2_A1971EmpCuentaBanc[0] ;
         A1970EmpBanTipCuen = P023Q2_A1970EmpBanTipCuen[0] ;
         A1969EmpBanSuc = P023Q2_A1969EmpBanSuc[0] ;
         A1968EmpBanCBU = P023Q2_A1968EmpBanCBU[0] ;
         A1967EmpBanDescrip = P023Q2_A1967EmpBanDescrip[0] ;
         A1967EmpBanDescrip = P023Q2_A1967EmpBanDescrip[0] ;
         AV34count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P023Q2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P023Q2_A1966EmpBanCod[0], A1966EmpBanCod) == 0 ) )
         {
            brk23Q2 = false ;
            A1EmpCod = P023Q2_A1EmpCod[0] ;
            AV34count = (long)(AV34count+1) ;
            brk23Q2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1967EmpBanDescrip)==0) )
         {
            AV29Option = A1967EmpBanDescrip ;
            AV28InsertIndex = 1 ;
            while ( ( AV28InsertIndex <= AV30Options.size() ) && ( GXutil.strcmp((String)AV30Options.elementAt(-1+AV28InsertIndex), AV29Option) < 0 ) )
            {
               AV28InsertIndex = (int)(AV28InsertIndex+1) ;
            }
            AV30Options.add(AV29Option, AV28InsertIndex);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV34count), "Z,ZZZ,ZZZ,ZZ9")), AV28InsertIndex);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk23Q2 )
         {
            brk23Q2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADEMPBANCBUOPTIONS' Routine */
      returnInSub = false ;
      AV18TFEmpBanCBU = AV41SearchTxt ;
      AV19TFEmpBanCBU_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV53Empresabancoswwds_1_tfempbandescrip = AV15TFEmpBanDescrip ;
      AV54Empresabancoswwds_2_tfempbandescrip_sels = AV16TFEmpBanDescrip_Sels ;
      AV55Empresabancoswwds_3_tfempbancbu = AV18TFEmpBanCBU ;
      AV56Empresabancoswwds_4_tfempbancbu_sels = AV19TFEmpBanCBU_Sels ;
      AV57Empresabancoswwds_5_tfempbansuc = AV21TFEmpBanSuc ;
      AV58Empresabancoswwds_6_tfempbansuc_sels = AV22TFEmpBanSuc_Sels ;
      AV59Empresabancoswwds_7_tfempbantipcuen_sels = AV24TFEmpBanTipCuen_Sels ;
      AV60Empresabancoswwds_8_tfempcuentabanc = AV26TFEmpCuentaBanc ;
      AV61Empresabancoswwds_9_tfempcuentabanc_sels = AV27TFEmpCuentaBanc_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1967EmpBanDescrip ,
                                           AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                           A1968EmpBanCBU ,
                                           AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                           A1969EmpBanSuc ,
                                           AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                           A1970EmpBanTipCuen ,
                                           AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                           A1971EmpCuentaBanc ,
                                           AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                           Integer.valueOf(AV54Empresabancoswwds_2_tfempbandescrip_sels.size()) ,
                                           AV53Empresabancoswwds_1_tfempbandescrip ,
                                           Integer.valueOf(AV56Empresabancoswwds_4_tfempbancbu_sels.size()) ,
                                           AV55Empresabancoswwds_3_tfempbancbu ,
                                           Integer.valueOf(AV58Empresabancoswwds_6_tfempbansuc_sels.size()) ,
                                           AV57Empresabancoswwds_5_tfempbansuc ,
                                           Integer.valueOf(AV59Empresabancoswwds_7_tfempbantipcuen_sels.size()) ,
                                           Integer.valueOf(AV61Empresabancoswwds_9_tfempcuentabanc_sels.size()) ,
                                           AV60Empresabancoswwds_8_tfempcuentabanc ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV48CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV47EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV53Empresabancoswwds_1_tfempbandescrip = GXutil.concat( GXutil.rtrim( AV53Empresabancoswwds_1_tfempbandescrip), "%", "") ;
      lV55Empresabancoswwds_3_tfempbancbu = GXutil.concat( GXutil.rtrim( AV55Empresabancoswwds_3_tfempbancbu), "%", "") ;
      lV57Empresabancoswwds_5_tfempbansuc = GXutil.concat( GXutil.rtrim( AV57Empresabancoswwds_5_tfempbansuc), "%", "") ;
      lV60Empresabancoswwds_8_tfempcuentabanc = GXutil.concat( GXutil.rtrim( AV60Empresabancoswwds_8_tfempcuentabanc), "%", "") ;
      /* Using cursor P023Q3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV48CliCod), Short.valueOf(AV47EmpCod), lV53Empresabancoswwds_1_tfempbandescrip, lV55Empresabancoswwds_3_tfempbancbu, lV57Empresabancoswwds_5_tfempbansuc, lV60Empresabancoswwds_8_tfempcuentabanc});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk23Q4 = false ;
         A1966EmpBanCod = P023Q3_A1966EmpBanCod[0] ;
         A3CliCod = P023Q3_A3CliCod[0] ;
         A1EmpCod = P023Q3_A1EmpCod[0] ;
         A1968EmpBanCBU = P023Q3_A1968EmpBanCBU[0] ;
         A1971EmpCuentaBanc = P023Q3_A1971EmpCuentaBanc[0] ;
         A1970EmpBanTipCuen = P023Q3_A1970EmpBanTipCuen[0] ;
         A1969EmpBanSuc = P023Q3_A1969EmpBanSuc[0] ;
         A1967EmpBanDescrip = P023Q3_A1967EmpBanDescrip[0] ;
         A1967EmpBanDescrip = P023Q3_A1967EmpBanDescrip[0] ;
         AV34count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P023Q3_A1968EmpBanCBU[0], A1968EmpBanCBU) == 0 ) )
         {
            brk23Q4 = false ;
            A1966EmpBanCod = P023Q3_A1966EmpBanCod[0] ;
            A3CliCod = P023Q3_A3CliCod[0] ;
            A1EmpCod = P023Q3_A1EmpCod[0] ;
            AV34count = (long)(AV34count+1) ;
            brk23Q4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1968EmpBanCBU)==0) )
         {
            AV29Option = A1968EmpBanCBU ;
            AV30Options.add(AV29Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV34count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk23Q4 )
         {
            brk23Q4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADEMPBANSUCOPTIONS' Routine */
      returnInSub = false ;
      AV21TFEmpBanSuc = AV41SearchTxt ;
      AV22TFEmpBanSuc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV53Empresabancoswwds_1_tfempbandescrip = AV15TFEmpBanDescrip ;
      AV54Empresabancoswwds_2_tfempbandescrip_sels = AV16TFEmpBanDescrip_Sels ;
      AV55Empresabancoswwds_3_tfempbancbu = AV18TFEmpBanCBU ;
      AV56Empresabancoswwds_4_tfempbancbu_sels = AV19TFEmpBanCBU_Sels ;
      AV57Empresabancoswwds_5_tfempbansuc = AV21TFEmpBanSuc ;
      AV58Empresabancoswwds_6_tfempbansuc_sels = AV22TFEmpBanSuc_Sels ;
      AV59Empresabancoswwds_7_tfempbantipcuen_sels = AV24TFEmpBanTipCuen_Sels ;
      AV60Empresabancoswwds_8_tfempcuentabanc = AV26TFEmpCuentaBanc ;
      AV61Empresabancoswwds_9_tfempcuentabanc_sels = AV27TFEmpCuentaBanc_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1967EmpBanDescrip ,
                                           AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                           A1968EmpBanCBU ,
                                           AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                           A1969EmpBanSuc ,
                                           AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                           A1970EmpBanTipCuen ,
                                           AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                           A1971EmpCuentaBanc ,
                                           AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                           Integer.valueOf(AV54Empresabancoswwds_2_tfempbandescrip_sels.size()) ,
                                           AV53Empresabancoswwds_1_tfempbandescrip ,
                                           Integer.valueOf(AV56Empresabancoswwds_4_tfempbancbu_sels.size()) ,
                                           AV55Empresabancoswwds_3_tfempbancbu ,
                                           Integer.valueOf(AV58Empresabancoswwds_6_tfempbansuc_sels.size()) ,
                                           AV57Empresabancoswwds_5_tfempbansuc ,
                                           Integer.valueOf(AV59Empresabancoswwds_7_tfempbantipcuen_sels.size()) ,
                                           Integer.valueOf(AV61Empresabancoswwds_9_tfempcuentabanc_sels.size()) ,
                                           AV60Empresabancoswwds_8_tfempcuentabanc ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV48CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV47EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV53Empresabancoswwds_1_tfempbandescrip = GXutil.concat( GXutil.rtrim( AV53Empresabancoswwds_1_tfempbandescrip), "%", "") ;
      lV55Empresabancoswwds_3_tfempbancbu = GXutil.concat( GXutil.rtrim( AV55Empresabancoswwds_3_tfempbancbu), "%", "") ;
      lV57Empresabancoswwds_5_tfempbansuc = GXutil.concat( GXutil.rtrim( AV57Empresabancoswwds_5_tfempbansuc), "%", "") ;
      lV60Empresabancoswwds_8_tfempcuentabanc = GXutil.concat( GXutil.rtrim( AV60Empresabancoswwds_8_tfempcuentabanc), "%", "") ;
      /* Using cursor P023Q4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV48CliCod), Short.valueOf(AV47EmpCod), lV53Empresabancoswwds_1_tfempbandescrip, lV55Empresabancoswwds_3_tfempbancbu, lV57Empresabancoswwds_5_tfempbansuc, lV60Empresabancoswwds_8_tfempcuentabanc});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk23Q6 = false ;
         A1966EmpBanCod = P023Q4_A1966EmpBanCod[0] ;
         A3CliCod = P023Q4_A3CliCod[0] ;
         A1EmpCod = P023Q4_A1EmpCod[0] ;
         A1969EmpBanSuc = P023Q4_A1969EmpBanSuc[0] ;
         A1971EmpCuentaBanc = P023Q4_A1971EmpCuentaBanc[0] ;
         A1970EmpBanTipCuen = P023Q4_A1970EmpBanTipCuen[0] ;
         A1968EmpBanCBU = P023Q4_A1968EmpBanCBU[0] ;
         A1967EmpBanDescrip = P023Q4_A1967EmpBanDescrip[0] ;
         A1967EmpBanDescrip = P023Q4_A1967EmpBanDescrip[0] ;
         AV34count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P023Q4_A1969EmpBanSuc[0], A1969EmpBanSuc) == 0 ) )
         {
            brk23Q6 = false ;
            A1966EmpBanCod = P023Q4_A1966EmpBanCod[0] ;
            A3CliCod = P023Q4_A3CliCod[0] ;
            A1EmpCod = P023Q4_A1EmpCod[0] ;
            AV34count = (long)(AV34count+1) ;
            brk23Q6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1969EmpBanSuc)==0) )
         {
            AV29Option = A1969EmpBanSuc ;
            AV30Options.add(AV29Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV34count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk23Q6 )
         {
            brk23Q6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADEMPCUENTABANCOPTIONS' Routine */
      returnInSub = false ;
      AV26TFEmpCuentaBanc = AV41SearchTxt ;
      AV27TFEmpCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV53Empresabancoswwds_1_tfempbandescrip = AV15TFEmpBanDescrip ;
      AV54Empresabancoswwds_2_tfempbandescrip_sels = AV16TFEmpBanDescrip_Sels ;
      AV55Empresabancoswwds_3_tfempbancbu = AV18TFEmpBanCBU ;
      AV56Empresabancoswwds_4_tfempbancbu_sels = AV19TFEmpBanCBU_Sels ;
      AV57Empresabancoswwds_5_tfempbansuc = AV21TFEmpBanSuc ;
      AV58Empresabancoswwds_6_tfempbansuc_sels = AV22TFEmpBanSuc_Sels ;
      AV59Empresabancoswwds_7_tfempbantipcuen_sels = AV24TFEmpBanTipCuen_Sels ;
      AV60Empresabancoswwds_8_tfempcuentabanc = AV26TFEmpCuentaBanc ;
      AV61Empresabancoswwds_9_tfempcuentabanc_sels = AV27TFEmpCuentaBanc_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A1967EmpBanDescrip ,
                                           AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                           A1968EmpBanCBU ,
                                           AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                           A1969EmpBanSuc ,
                                           AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                           A1970EmpBanTipCuen ,
                                           AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                           A1971EmpCuentaBanc ,
                                           AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                           Integer.valueOf(AV54Empresabancoswwds_2_tfempbandescrip_sels.size()) ,
                                           AV53Empresabancoswwds_1_tfempbandescrip ,
                                           Integer.valueOf(AV56Empresabancoswwds_4_tfempbancbu_sels.size()) ,
                                           AV55Empresabancoswwds_3_tfempbancbu ,
                                           Integer.valueOf(AV58Empresabancoswwds_6_tfempbansuc_sels.size()) ,
                                           AV57Empresabancoswwds_5_tfempbansuc ,
                                           Integer.valueOf(AV59Empresabancoswwds_7_tfempbantipcuen_sels.size()) ,
                                           Integer.valueOf(AV61Empresabancoswwds_9_tfempcuentabanc_sels.size()) ,
                                           AV60Empresabancoswwds_8_tfempcuentabanc ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV48CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV47EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV53Empresabancoswwds_1_tfempbandescrip = GXutil.concat( GXutil.rtrim( AV53Empresabancoswwds_1_tfempbandescrip), "%", "") ;
      lV55Empresabancoswwds_3_tfempbancbu = GXutil.concat( GXutil.rtrim( AV55Empresabancoswwds_3_tfempbancbu), "%", "") ;
      lV57Empresabancoswwds_5_tfempbansuc = GXutil.concat( GXutil.rtrim( AV57Empresabancoswwds_5_tfempbansuc), "%", "") ;
      lV60Empresabancoswwds_8_tfempcuentabanc = GXutil.concat( GXutil.rtrim( AV60Empresabancoswwds_8_tfempcuentabanc), "%", "") ;
      /* Using cursor P023Q5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV48CliCod), Short.valueOf(AV47EmpCod), lV53Empresabancoswwds_1_tfempbandescrip, lV55Empresabancoswwds_3_tfempbancbu, lV57Empresabancoswwds_5_tfempbansuc, lV60Empresabancoswwds_8_tfempcuentabanc});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk23Q8 = false ;
         A1966EmpBanCod = P023Q5_A1966EmpBanCod[0] ;
         A3CliCod = P023Q5_A3CliCod[0] ;
         A1EmpCod = P023Q5_A1EmpCod[0] ;
         A1971EmpCuentaBanc = P023Q5_A1971EmpCuentaBanc[0] ;
         A1970EmpBanTipCuen = P023Q5_A1970EmpBanTipCuen[0] ;
         A1969EmpBanSuc = P023Q5_A1969EmpBanSuc[0] ;
         A1968EmpBanCBU = P023Q5_A1968EmpBanCBU[0] ;
         A1967EmpBanDescrip = P023Q5_A1967EmpBanDescrip[0] ;
         A1967EmpBanDescrip = P023Q5_A1967EmpBanDescrip[0] ;
         AV34count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P023Q5_A1971EmpCuentaBanc[0], A1971EmpCuentaBanc) == 0 ) )
         {
            brk23Q8 = false ;
            A1966EmpBanCod = P023Q5_A1966EmpBanCod[0] ;
            A3CliCod = P023Q5_A3CliCod[0] ;
            A1EmpCod = P023Q5_A1EmpCod[0] ;
            AV34count = (long)(AV34count+1) ;
            brk23Q8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A1971EmpCuentaBanc)==0) )
         {
            AV29Option = A1971EmpCuentaBanc ;
            AV30Options.add(AV29Option, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV34count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk23Q8 )
         {
            brk23Q8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = empresabancoswwgetfilterdata.this.AV43OptionsJson;
      this.aP4[0] = empresabancoswwgetfilterdata.this.AV44OptionsDescJson;
      this.aP5[0] = empresabancoswwgetfilterdata.this.AV45OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV43OptionsJson = "" ;
      AV44OptionsDescJson = "" ;
      AV45OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV35Session = httpContext.getWebSession();
      AV37GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV38GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV15TFEmpBanDescrip = "" ;
      AV14TFEmpBanDescrip_SelsJson = "" ;
      AV16TFEmpBanDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFEmpBanCBU = "" ;
      AV17TFEmpBanCBU_SelsJson = "" ;
      AV19TFEmpBanCBU_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFEmpBanSuc = "" ;
      AV20TFEmpBanSuc_SelsJson = "" ;
      AV22TFEmpBanSuc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFEmpBanTipCuen_SelsJson = "" ;
      AV24TFEmpBanTipCuen_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFEmpCuentaBanc = "" ;
      AV25TFEmpCuentaBanc_SelsJson = "" ;
      AV27TFEmpCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46MenuOpcCod = "" ;
      A1967EmpBanDescrip = "" ;
      AV53Empresabancoswwds_1_tfempbandescrip = "" ;
      AV54Empresabancoswwds_2_tfempbandescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Empresabancoswwds_3_tfempbancbu = "" ;
      AV56Empresabancoswwds_4_tfempbancbu_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57Empresabancoswwds_5_tfempbansuc = "" ;
      AV58Empresabancoswwds_6_tfempbansuc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Empresabancoswwds_7_tfempbantipcuen_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60Empresabancoswwds_8_tfempcuentabanc = "" ;
      AV61Empresabancoswwds_9_tfempcuentabanc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV53Empresabancoswwds_1_tfempbandescrip = "" ;
      lV55Empresabancoswwds_3_tfempbancbu = "" ;
      lV57Empresabancoswwds_5_tfempbansuc = "" ;
      lV60Empresabancoswwds_8_tfempcuentabanc = "" ;
      A1968EmpBanCBU = "" ;
      A1969EmpBanSuc = "" ;
      A1970EmpBanTipCuen = "" ;
      A1971EmpCuentaBanc = "" ;
      P023Q2_A1966EmpBanCod = new String[] {""} ;
      P023Q2_A3CliCod = new int[1] ;
      P023Q2_A1EmpCod = new short[1] ;
      P023Q2_A1971EmpCuentaBanc = new String[] {""} ;
      P023Q2_A1970EmpBanTipCuen = new String[] {""} ;
      P023Q2_A1969EmpBanSuc = new String[] {""} ;
      P023Q2_A1968EmpBanCBU = new String[] {""} ;
      P023Q2_A1967EmpBanDescrip = new String[] {""} ;
      A1966EmpBanCod = "" ;
      AV29Option = "" ;
      P023Q3_A1966EmpBanCod = new String[] {""} ;
      P023Q3_A3CliCod = new int[1] ;
      P023Q3_A1EmpCod = new short[1] ;
      P023Q3_A1968EmpBanCBU = new String[] {""} ;
      P023Q3_A1971EmpCuentaBanc = new String[] {""} ;
      P023Q3_A1970EmpBanTipCuen = new String[] {""} ;
      P023Q3_A1969EmpBanSuc = new String[] {""} ;
      P023Q3_A1967EmpBanDescrip = new String[] {""} ;
      P023Q4_A1966EmpBanCod = new String[] {""} ;
      P023Q4_A3CliCod = new int[1] ;
      P023Q4_A1EmpCod = new short[1] ;
      P023Q4_A1969EmpBanSuc = new String[] {""} ;
      P023Q4_A1971EmpCuentaBanc = new String[] {""} ;
      P023Q4_A1970EmpBanTipCuen = new String[] {""} ;
      P023Q4_A1968EmpBanCBU = new String[] {""} ;
      P023Q4_A1967EmpBanDescrip = new String[] {""} ;
      P023Q5_A1966EmpBanCod = new String[] {""} ;
      P023Q5_A3CliCod = new int[1] ;
      P023Q5_A1EmpCod = new short[1] ;
      P023Q5_A1971EmpCuentaBanc = new String[] {""} ;
      P023Q5_A1970EmpBanTipCuen = new String[] {""} ;
      P023Q5_A1969EmpBanSuc = new String[] {""} ;
      P023Q5_A1968EmpBanCBU = new String[] {""} ;
      P023Q5_A1967EmpBanDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabancoswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P023Q2_A1966EmpBanCod, P023Q2_A3CliCod, P023Q2_A1EmpCod, P023Q2_A1971EmpCuentaBanc, P023Q2_A1970EmpBanTipCuen, P023Q2_A1969EmpBanSuc, P023Q2_A1968EmpBanCBU, P023Q2_A1967EmpBanDescrip
            }
            , new Object[] {
            P023Q3_A1966EmpBanCod, P023Q3_A3CliCod, P023Q3_A1EmpCod, P023Q3_A1968EmpBanCBU, P023Q3_A1971EmpCuentaBanc, P023Q3_A1970EmpBanTipCuen, P023Q3_A1969EmpBanSuc, P023Q3_A1967EmpBanDescrip
            }
            , new Object[] {
            P023Q4_A1966EmpBanCod, P023Q4_A3CliCod, P023Q4_A1EmpCod, P023Q4_A1969EmpBanSuc, P023Q4_A1971EmpCuentaBanc, P023Q4_A1970EmpBanTipCuen, P023Q4_A1968EmpBanCBU, P023Q4_A1967EmpBanDescrip
            }
            , new Object[] {
            P023Q5_A1966EmpBanCod, P023Q5_A3CliCod, P023Q5_A1EmpCod, P023Q5_A1971EmpCuentaBanc, P023Q5_A1970EmpBanTipCuen, P023Q5_A1969EmpBanSuc, P023Q5_A1968EmpBanCBU, P023Q5_A1967EmpBanDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV47EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV48CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV51GXV1 ;
   private int AV54Empresabancoswwds_2_tfempbandescrip_sels_size ;
   private int AV56Empresabancoswwds_4_tfempbancbu_sels_size ;
   private int AV58Empresabancoswwds_6_tfempbansuc_sels_size ;
   private int AV59Empresabancoswwds_7_tfempbantipcuen_sels_size ;
   private int AV61Empresabancoswwds_9_tfempcuentabanc_sels_size ;
   private int A3CliCod ;
   private int AV28InsertIndex ;
   private long AV34count ;
   private String scmdbuf ;
   private String A1970EmpBanTipCuen ;
   private String A1966EmpBanCod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk23Q2 ;
   private boolean brk23Q4 ;
   private boolean brk23Q6 ;
   private boolean brk23Q8 ;
   private String AV43OptionsJson ;
   private String AV44OptionsDescJson ;
   private String AV45OptionIndexesJson ;
   private String AV14TFEmpBanDescrip_SelsJson ;
   private String AV17TFEmpBanCBU_SelsJson ;
   private String AV20TFEmpBanSuc_SelsJson ;
   private String AV23TFEmpBanTipCuen_SelsJson ;
   private String AV25TFEmpCuentaBanc_SelsJson ;
   private String AV40DDOName ;
   private String AV41SearchTxt ;
   private String AV42SearchTxtTo ;
   private String AV15TFEmpBanDescrip ;
   private String AV18TFEmpBanCBU ;
   private String AV21TFEmpBanSuc ;
   private String AV26TFEmpCuentaBanc ;
   private String AV46MenuOpcCod ;
   private String A1967EmpBanDescrip ;
   private String AV53Empresabancoswwds_1_tfempbandescrip ;
   private String AV55Empresabancoswwds_3_tfempbancbu ;
   private String AV57Empresabancoswwds_5_tfempbansuc ;
   private String AV60Empresabancoswwds_8_tfempcuentabanc ;
   private String lV53Empresabancoswwds_1_tfempbandescrip ;
   private String lV55Empresabancoswwds_3_tfempbancbu ;
   private String lV57Empresabancoswwds_5_tfempbansuc ;
   private String lV60Empresabancoswwds_8_tfempcuentabanc ;
   private String A1968EmpBanCBU ;
   private String A1969EmpBanSuc ;
   private String A1971EmpCuentaBanc ;
   private String AV29Option ;
   private com.genexus.webpanels.WebSession AV35Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P023Q2_A1966EmpBanCod ;
   private int[] P023Q2_A3CliCod ;
   private short[] P023Q2_A1EmpCod ;
   private String[] P023Q2_A1971EmpCuentaBanc ;
   private String[] P023Q2_A1970EmpBanTipCuen ;
   private String[] P023Q2_A1969EmpBanSuc ;
   private String[] P023Q2_A1968EmpBanCBU ;
   private String[] P023Q2_A1967EmpBanDescrip ;
   private String[] P023Q3_A1966EmpBanCod ;
   private int[] P023Q3_A3CliCod ;
   private short[] P023Q3_A1EmpCod ;
   private String[] P023Q3_A1968EmpBanCBU ;
   private String[] P023Q3_A1971EmpCuentaBanc ;
   private String[] P023Q3_A1970EmpBanTipCuen ;
   private String[] P023Q3_A1969EmpBanSuc ;
   private String[] P023Q3_A1967EmpBanDescrip ;
   private String[] P023Q4_A1966EmpBanCod ;
   private int[] P023Q4_A3CliCod ;
   private short[] P023Q4_A1EmpCod ;
   private String[] P023Q4_A1969EmpBanSuc ;
   private String[] P023Q4_A1971EmpCuentaBanc ;
   private String[] P023Q4_A1970EmpBanTipCuen ;
   private String[] P023Q4_A1968EmpBanCBU ;
   private String[] P023Q4_A1967EmpBanDescrip ;
   private String[] P023Q5_A1966EmpBanCod ;
   private int[] P023Q5_A3CliCod ;
   private short[] P023Q5_A1EmpCod ;
   private String[] P023Q5_A1971EmpCuentaBanc ;
   private String[] P023Q5_A1970EmpBanTipCuen ;
   private String[] P023Q5_A1969EmpBanSuc ;
   private String[] P023Q5_A1968EmpBanCBU ;
   private String[] P023Q5_A1967EmpBanDescrip ;
   private GXSimpleCollection<String> AV24TFEmpBanTipCuen_Sels ;
   private GXSimpleCollection<String> AV59Empresabancoswwds_7_tfempbantipcuen_sels ;
   private GXSimpleCollection<String> AV30Options ;
   private GXSimpleCollection<String> AV32OptionsDesc ;
   private GXSimpleCollection<String> AV33OptionIndexes ;
   private GXSimpleCollection<String> AV16TFEmpBanDescrip_Sels ;
   private GXSimpleCollection<String> AV19TFEmpBanCBU_Sels ;
   private GXSimpleCollection<String> AV22TFEmpBanSuc_Sels ;
   private GXSimpleCollection<String> AV27TFEmpCuentaBanc_Sels ;
   private GXSimpleCollection<String> AV54Empresabancoswwds_2_tfempbandescrip_sels ;
   private GXSimpleCollection<String> AV56Empresabancoswwds_4_tfempbancbu_sels ;
   private GXSimpleCollection<String> AV58Empresabancoswwds_6_tfempbansuc_sels ;
   private GXSimpleCollection<String> AV61Empresabancoswwds_9_tfempcuentabanc_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV37GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV38GridStateFilterValue ;
}

final  class empresabancoswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P023Q2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1967EmpBanDescrip ,
                                          GXSimpleCollection<String> AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                          String A1968EmpBanCBU ,
                                          GXSimpleCollection<String> AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                          String A1969EmpBanSuc ,
                                          GXSimpleCollection<String> AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                          String A1970EmpBanTipCuen ,
                                          GXSimpleCollection<String> AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                          String A1971EmpCuentaBanc ,
                                          GXSimpleCollection<String> AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                          int AV54Empresabancoswwds_2_tfempbandescrip_sels_size ,
                                          String AV53Empresabancoswwds_1_tfempbandescrip ,
                                          int AV56Empresabancoswwds_4_tfempbancbu_sels_size ,
                                          String AV55Empresabancoswwds_3_tfempbancbu ,
                                          int AV58Empresabancoswwds_6_tfempbansuc_sels_size ,
                                          String AV57Empresabancoswwds_5_tfempbansuc ,
                                          int AV59Empresabancoswwds_7_tfempbantipcuen_sels_size ,
                                          int AV61Empresabancoswwds_9_tfempcuentabanc_sels_size ,
                                          String AV60Empresabancoswwds_8_tfempcuentabanc ,
                                          short A1EmpCod ,
                                          short AV47EmpCod ,
                                          int AV48CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.EmpBanCod AS EmpBanCod, T1.CliCod, T1.EmpCod, T1.EmpCuentaBanc, T1.EmpBanTipCuen, T1.EmpBanSuc, T1.EmpBanCBU, T2.BanDescrip AS EmpBanDescrip FROM (EmpresaBancos" ;
      scmdbuf += " T1 INNER JOIN Banco T2 ON T2.CliCod = T1.CliCod AND T2.BanCod = T1.EmpBanCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Empresabancoswwds_1_tfempbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Empresabancoswwds_2_tfempbandescrip_sels, "T2.BanDescrip IN (", ")")+")");
      }
      if ( ( AV56Empresabancoswwds_4_tfempbancbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Empresabancoswwds_3_tfempbancbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanCBU) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV56Empresabancoswwds_4_tfempbancbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Empresabancoswwds_4_tfempbancbu_sels, "T1.EmpBanCBU IN (", ")")+")");
      }
      if ( ( AV58Empresabancoswwds_6_tfempbansuc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Empresabancoswwds_5_tfempbansuc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanSuc) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV58Empresabancoswwds_6_tfempbansuc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Empresabancoswwds_6_tfempbansuc_sels, "T1.EmpBanSuc IN (", ")")+")");
      }
      if ( AV59Empresabancoswwds_7_tfempbantipcuen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Empresabancoswwds_7_tfempbantipcuen_sels, "T1.EmpBanTipCuen IN (", ")")+")");
      }
      if ( ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Empresabancoswwds_8_tfempcuentabanc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpCuentaBanc) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Empresabancoswwds_9_tfempcuentabanc_sels, "T1.EmpCuentaBanc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpBanCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P023Q3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1967EmpBanDescrip ,
                                          GXSimpleCollection<String> AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                          String A1968EmpBanCBU ,
                                          GXSimpleCollection<String> AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                          String A1969EmpBanSuc ,
                                          GXSimpleCollection<String> AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                          String A1970EmpBanTipCuen ,
                                          GXSimpleCollection<String> AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                          String A1971EmpCuentaBanc ,
                                          GXSimpleCollection<String> AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                          int AV54Empresabancoswwds_2_tfempbandescrip_sels_size ,
                                          String AV53Empresabancoswwds_1_tfempbandescrip ,
                                          int AV56Empresabancoswwds_4_tfempbancbu_sels_size ,
                                          String AV55Empresabancoswwds_3_tfempbancbu ,
                                          int AV58Empresabancoswwds_6_tfempbansuc_sels_size ,
                                          String AV57Empresabancoswwds_5_tfempbansuc ,
                                          int AV59Empresabancoswwds_7_tfempbantipcuen_sels_size ,
                                          int AV61Empresabancoswwds_9_tfempcuentabanc_sels_size ,
                                          String AV60Empresabancoswwds_8_tfempcuentabanc ,
                                          int A3CliCod ,
                                          int AV48CliCod ,
                                          short A1EmpCod ,
                                          short AV47EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.EmpBanCod AS EmpBanCod, T1.CliCod, T1.EmpCod, T1.EmpBanCBU, T1.EmpCuentaBanc, T1.EmpBanTipCuen, T1.EmpBanSuc, T2.BanDescrip AS EmpBanDescrip FROM (EmpresaBancos" ;
      scmdbuf += " T1 INNER JOIN Banco T2 ON T2.CliCod = T1.CliCod AND T2.BanCod = T1.EmpBanCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Empresabancoswwds_1_tfempbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Empresabancoswwds_2_tfempbandescrip_sels, "T2.BanDescrip IN (", ")")+")");
      }
      if ( ( AV56Empresabancoswwds_4_tfempbancbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Empresabancoswwds_3_tfempbancbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanCBU) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV56Empresabancoswwds_4_tfempbancbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Empresabancoswwds_4_tfempbancbu_sels, "T1.EmpBanCBU IN (", ")")+")");
      }
      if ( ( AV58Empresabancoswwds_6_tfempbansuc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Empresabancoswwds_5_tfempbansuc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanSuc) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV58Empresabancoswwds_6_tfempbansuc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Empresabancoswwds_6_tfempbansuc_sels, "T1.EmpBanSuc IN (", ")")+")");
      }
      if ( AV59Empresabancoswwds_7_tfempbantipcuen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Empresabancoswwds_7_tfempbantipcuen_sels, "T1.EmpBanTipCuen IN (", ")")+")");
      }
      if ( ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Empresabancoswwds_8_tfempcuentabanc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpCuentaBanc) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Empresabancoswwds_9_tfempcuentabanc_sels, "T1.EmpCuentaBanc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.EmpBanCBU" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P023Q4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1967EmpBanDescrip ,
                                          GXSimpleCollection<String> AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                          String A1968EmpBanCBU ,
                                          GXSimpleCollection<String> AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                          String A1969EmpBanSuc ,
                                          GXSimpleCollection<String> AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                          String A1970EmpBanTipCuen ,
                                          GXSimpleCollection<String> AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                          String A1971EmpCuentaBanc ,
                                          GXSimpleCollection<String> AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                          int AV54Empresabancoswwds_2_tfempbandescrip_sels_size ,
                                          String AV53Empresabancoswwds_1_tfempbandescrip ,
                                          int AV56Empresabancoswwds_4_tfempbancbu_sels_size ,
                                          String AV55Empresabancoswwds_3_tfempbancbu ,
                                          int AV58Empresabancoswwds_6_tfempbansuc_sels_size ,
                                          String AV57Empresabancoswwds_5_tfempbansuc ,
                                          int AV59Empresabancoswwds_7_tfempbantipcuen_sels_size ,
                                          int AV61Empresabancoswwds_9_tfempcuentabanc_sels_size ,
                                          String AV60Empresabancoswwds_8_tfempcuentabanc ,
                                          int A3CliCod ,
                                          int AV48CliCod ,
                                          short A1EmpCod ,
                                          short AV47EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.EmpBanCod AS EmpBanCod, T1.CliCod, T1.EmpCod, T1.EmpBanSuc, T1.EmpCuentaBanc, T1.EmpBanTipCuen, T1.EmpBanCBU, T2.BanDescrip AS EmpBanDescrip FROM (EmpresaBancos" ;
      scmdbuf += " T1 INNER JOIN Banco T2 ON T2.CliCod = T1.CliCod AND T2.BanCod = T1.EmpBanCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Empresabancoswwds_1_tfempbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Empresabancoswwds_2_tfempbandescrip_sels, "T2.BanDescrip IN (", ")")+")");
      }
      if ( ( AV56Empresabancoswwds_4_tfempbancbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Empresabancoswwds_3_tfempbancbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanCBU) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV56Empresabancoswwds_4_tfempbancbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Empresabancoswwds_4_tfempbancbu_sels, "T1.EmpBanCBU IN (", ")")+")");
      }
      if ( ( AV58Empresabancoswwds_6_tfempbansuc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Empresabancoswwds_5_tfempbansuc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanSuc) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV58Empresabancoswwds_6_tfempbansuc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Empresabancoswwds_6_tfempbansuc_sels, "T1.EmpBanSuc IN (", ")")+")");
      }
      if ( AV59Empresabancoswwds_7_tfempbantipcuen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Empresabancoswwds_7_tfempbantipcuen_sels, "T1.EmpBanTipCuen IN (", ")")+")");
      }
      if ( ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Empresabancoswwds_8_tfempcuentabanc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpCuentaBanc) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Empresabancoswwds_9_tfempcuentabanc_sels, "T1.EmpCuentaBanc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.EmpBanSuc" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P023Q5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1967EmpBanDescrip ,
                                          GXSimpleCollection<String> AV54Empresabancoswwds_2_tfempbandescrip_sels ,
                                          String A1968EmpBanCBU ,
                                          GXSimpleCollection<String> AV56Empresabancoswwds_4_tfempbancbu_sels ,
                                          String A1969EmpBanSuc ,
                                          GXSimpleCollection<String> AV58Empresabancoswwds_6_tfempbansuc_sels ,
                                          String A1970EmpBanTipCuen ,
                                          GXSimpleCollection<String> AV59Empresabancoswwds_7_tfempbantipcuen_sels ,
                                          String A1971EmpCuentaBanc ,
                                          GXSimpleCollection<String> AV61Empresabancoswwds_9_tfempcuentabanc_sels ,
                                          int AV54Empresabancoswwds_2_tfempbandescrip_sels_size ,
                                          String AV53Empresabancoswwds_1_tfempbandescrip ,
                                          int AV56Empresabancoswwds_4_tfempbancbu_sels_size ,
                                          String AV55Empresabancoswwds_3_tfempbancbu ,
                                          int AV58Empresabancoswwds_6_tfempbansuc_sels_size ,
                                          String AV57Empresabancoswwds_5_tfempbansuc ,
                                          int AV59Empresabancoswwds_7_tfempbantipcuen_sels_size ,
                                          int AV61Empresabancoswwds_9_tfempcuentabanc_sels_size ,
                                          String AV60Empresabancoswwds_8_tfempcuentabanc ,
                                          int A3CliCod ,
                                          int AV48CliCod ,
                                          short A1EmpCod ,
                                          short AV47EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[6];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT T1.EmpBanCod AS EmpBanCod, T1.CliCod, T1.EmpCod, T1.EmpCuentaBanc, T1.EmpBanTipCuen, T1.EmpBanSuc, T1.EmpBanCBU, T2.BanDescrip AS EmpBanDescrip FROM (EmpresaBancos" ;
      scmdbuf += " T1 INNER JOIN Banco T2 ON T2.CliCod = T1.CliCod AND T2.BanCod = T1.EmpBanCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Empresabancoswwds_1_tfempbandescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.BanDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV54Empresabancoswwds_2_tfempbandescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Empresabancoswwds_2_tfempbandescrip_sels, "T2.BanDescrip IN (", ")")+")");
      }
      if ( ( AV56Empresabancoswwds_4_tfempbancbu_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Empresabancoswwds_3_tfempbancbu)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanCBU) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV56Empresabancoswwds_4_tfempbancbu_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Empresabancoswwds_4_tfempbancbu_sels, "T1.EmpBanCBU IN (", ")")+")");
      }
      if ( ( AV58Empresabancoswwds_6_tfempbansuc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57Empresabancoswwds_5_tfempbansuc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpBanSuc) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV58Empresabancoswwds_6_tfempbansuc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58Empresabancoswwds_6_tfempbansuc_sels, "T1.EmpBanSuc IN (", ")")+")");
      }
      if ( AV59Empresabancoswwds_7_tfempbantipcuen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Empresabancoswwds_7_tfempbantipcuen_sels, "T1.EmpBanTipCuen IN (", ")")+")");
      }
      if ( ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Empresabancoswwds_8_tfempcuentabanc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.EmpCuentaBanc) like LOWER(?))");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV61Empresabancoswwds_9_tfempcuentabanc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Empresabancoswwds_9_tfempcuentabanc_sels, "T1.EmpCuentaBanc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.EmpCuentaBanc" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P023Q2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() );
            case 1 :
                  return conditional_P023Q3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() );
            case 2 :
                  return conditional_P023Q4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() );
            case 3 :
                  return conditional_P023Q5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P023Q2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P023Q3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P023Q4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P023Q5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 22);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 22);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 20);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 22);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 20);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 22);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 20);
               }
               return;
      }
   }

}

