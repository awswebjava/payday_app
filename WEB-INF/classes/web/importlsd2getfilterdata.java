package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importlsd2getfilterdata extends GXProcedure
{
   public importlsd2getfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importlsd2getfilterdata.class ), "" );
   }

   public importlsd2getfilterdata( int remoteHandle ,
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
      importlsd2getfilterdata.this.aP5 = new String[] {""};
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
      importlsd2getfilterdata.this.AV54DDOName = aP0;
      importlsd2getfilterdata.this.AV52SearchTxt = aP1;
      importlsd2getfilterdata.this.AV53SearchTxtTo = aP2;
      importlsd2getfilterdata.this.aP3 = aP3;
      importlsd2getfilterdata.this.aP4 = aP4;
      importlsd2getfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV57Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV60OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV62OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(GXutil.upper( AV54DDOName), "DDO_IMPLIQDETPER") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQDETPEROPTIONS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV54DDOName), "DDO_IMPLIQDETCUIL") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQDETCUILOPTIONS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV54DDOName), "DDO_IMPLIQDETLEGSIS") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQDETLEGSISOPTIONS' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV54DDOName), "DDO_IMPLIQDETCONCOD") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQDETCONCODOPTIONS' */
         S151 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV54DDOName), "DDO_IMPLIQDETCONSISYDES") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQDETCONSISYDESOPTIONS' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV54DDOName), "DDO_IMPLIQDETSIGNO") == 0 )
      {
         /* Execute user subroutine: 'LOADIMPLIQDETSIGNOOPTIONS' */
         S171 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV58OptionsJson = AV57Options.toJSonString(false) ;
      AV61OptionsDescJson = AV60OptionsDesc.toJSonString(false) ;
      AV63OptionIndexesJson = AV62OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV65Session.getValue("ImportLSD2GridState"), "") == 0 )
      {
         AV67GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ImportLSD2GridState"), null, null);
      }
      else
      {
         AV67GridState.fromxml(AV65Session.getValue("ImportLSD2GridState"), null, null);
      }
      AV86GXV1 = 1 ;
      while ( AV86GXV1 <= AV67GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV68GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV67GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV86GXV1));
         if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CLICOD") == 0 )
         {
            AV70CliCod = (int)(GXutil.lval( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "EMPCOD") == 0 )
         {
            AV71EmpCod = (short)(GXutil.lval( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFICONOUPDATE") == 0 )
         {
            AV12TFiconoUpdateOperator = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Operator() ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETPER") == 0 )
         {
            AV17TFImpLiqDetPer = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETPER_SEL") == 0 )
         {
            AV16TFImpLiqDetPer_SelsJson = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFImpLiqDetPer_Sels.fromJSonString(AV16TFImpLiqDetPer_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCUIL") == 0 )
         {
            AV20TFImpLiqDetCUIL = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCUIL_SEL") == 0 )
         {
            AV19TFImpLiqDetCUIL_SelsJson = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV21TFImpLiqDetCUIL_Sels.fromJSonString(AV19TFImpLiqDetCUIL_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETLEGSIS") == 0 )
         {
            AV23TFImpLiqDetLegSis = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETLEGSIS_SEL") == 0 )
         {
            AV22TFImpLiqDetLegSis_SelsJson = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFImpLiqDetLegSis_Sels.fromJSonString(AV22TFImpLiqDetLegSis_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONCOD") == 0 )
         {
            AV26TFImpLiqDetConCod = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONCOD_SEL") == 0 )
         {
            AV25TFImpLiqDetConCod_SelsJson = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV27TFImpLiqDetConCod_Sels.fromJSonString(AV25TFImpLiqDetConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONSISYDES") == 0 )
         {
            AV80TFImpLiqDetConSisYDes = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCONSISYDES_SEL") == 0 )
         {
            AV79TFImpLiqDetConSisYDes_SelsJson = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV81TFImpLiqDetConSisYDes_Sels.fromJSonString(AV79TFImpLiqDetConSisYDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETCANTNUM") == 0 )
         {
            AV75TFImpLiqDetCantNum = CommonUtil.decimalVal( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV76TFImpLiqDetCantNum_To = CommonUtil.decimalVal( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETIMPNUM") == 0 )
         {
            AV77TFImpLiqDetImpNum = CommonUtil.decimalVal( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV78TFImpLiqDetImpNum_To = CommonUtil.decimalVal( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETSIGNO") == 0 )
         {
            AV35TFImpLiqDetSigno = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFIMPLIQDETSIGNO_SEL") == 0 )
         {
            AV34TFImpLiqDetSigno_SelsJson = AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFImpLiqDetSigno_Sels.fromJSonString(AV34TFImpLiqDetSigno_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV70CliCod = (int)(GXutil.lval( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV71EmpCod = (short)(GXutil.lval( AV68GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV86GXV1 = (int)(AV86GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADIMPLIQDETPEROPTIONS' Routine */
      returnInSub = false ;
      AV17TFImpLiqDetPer = AV52SearchTxt ;
      AV18TFImpLiqDetPer_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV88Importlsd2ds_1_clicod = AV70CliCod ;
      AV89Importlsd2ds_2_empcod = AV71EmpCod ;
      AV90Importlsd2ds_3_tficonoupdate = AV11TFiconoUpdate ;
      AV91Importlsd2ds_4_tficonoupdateoperator = AV12TFiconoUpdateOperator ;
      AV92Importlsd2ds_5_tfimpliqdetper = AV17TFImpLiqDetPer ;
      AV93Importlsd2ds_6_tfimpliqdetper_sels = AV18TFImpLiqDetPer_Sels ;
      AV94Importlsd2ds_7_tfimpliqdetcuil = AV20TFImpLiqDetCUIL ;
      AV95Importlsd2ds_8_tfimpliqdetcuil_sels = AV21TFImpLiqDetCUIL_Sels ;
      AV96Importlsd2ds_9_tfimpliqdetlegsis = AV23TFImpLiqDetLegSis ;
      AV97Importlsd2ds_10_tfimpliqdetlegsis_sels = AV24TFImpLiqDetLegSis_Sels ;
      AV98Importlsd2ds_11_tfimpliqdetconcod = AV26TFImpLiqDetConCod ;
      AV99Importlsd2ds_12_tfimpliqdetconcod_sels = AV27TFImpLiqDetConCod_Sels ;
      AV100Importlsd2ds_13_tfimpliqdetconsisydes = AV80TFImpLiqDetConSisYDes ;
      AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV81TFImpLiqDetConSisYDes_Sels ;
      AV102Importlsd2ds_15_tfimpliqdetcantnum = AV75TFImpLiqDetCantNum ;
      AV103Importlsd2ds_16_tfimpliqdetcantnum_to = AV76TFImpLiqDetCantNum_To ;
      AV104Importlsd2ds_17_tfimpliqdetimpnum = AV77TFImpLiqDetImpNum ;
      AV105Importlsd2ds_18_tfimpliqdetimpnum_to = AV78TFImpLiqDetImpNum_To ;
      AV106Importlsd2ds_19_tfimpliqdetsigno = AV35TFImpLiqDetSigno ;
      AV107Importlsd2ds_20_tfimpliqdetsigno_sels = AV36TFImpLiqDetSigno_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A661ImpLiqDetPer ,
                                           AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                           A663ImpLiqDetCUIL ,
                                           AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                           A712ImpLiqDetLegSis ,
                                           AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                           A666ImpLiqDetConCod ,
                                           AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                           A714ImpLiqDetConSisYDes ,
                                           AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                           A670ImpLiqDetSigno ,
                                           AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                           Short.valueOf(AV91Importlsd2ds_4_tficonoupdateoperator) ,
                                           Integer.valueOf(AV93Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                           AV92Importlsd2ds_5_tfimpliqdetper ,
                                           Integer.valueOf(AV95Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                           AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                           Integer.valueOf(AV97Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                           AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                           Integer.valueOf(AV99Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                           AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                           Integer.valueOf(AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                           AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                           AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                           AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                           AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                           AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                           Integer.valueOf(AV107Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                           AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                           A709ImpLiqDetError ,
                                           A715ImpLiqDetCantNum ,
                                           A716ImpLiqDetImpNum ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88Importlsd2ds_1_clicod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV89Importlsd2ds_2_empcod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV92Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV92Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
      lV94Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV94Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
      lV96Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV96Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
      lV98Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV98Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
      lV100Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV100Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
      lV106Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV106Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
      /* Using cursor P00OE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV88Importlsd2ds_1_clicod), Short.valueOf(AV89Importlsd2ds_2_empcod), lV92Importlsd2ds_5_tfimpliqdetper, lV94Importlsd2ds_7_tfimpliqdetcuil, lV96Importlsd2ds_9_tfimpliqdetlegsis, lV98Importlsd2ds_11_tfimpliqdetconcod, lV100Importlsd2ds_13_tfimpliqdetconsisydes, AV102Importlsd2ds_15_tfimpliqdetcantnum, AV103Importlsd2ds_16_tfimpliqdetcantnum_to, AV104Importlsd2ds_17_tfimpliqdetimpnum, AV105Importlsd2ds_18_tfimpliqdetimpnum_to, lV106Importlsd2ds_19_tfimpliqdetsigno});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkOE2 = false ;
         A3CliCod = P00OE2_A3CliCod[0] ;
         A1EmpCod = P00OE2_A1EmpCod[0] ;
         A661ImpLiqDetPer = P00OE2_A661ImpLiqDetPer[0] ;
         A709ImpLiqDetError = P00OE2_A709ImpLiqDetError[0] ;
         A670ImpLiqDetSigno = P00OE2_A670ImpLiqDetSigno[0] ;
         A716ImpLiqDetImpNum = P00OE2_A716ImpLiqDetImpNum[0] ;
         A715ImpLiqDetCantNum = P00OE2_A715ImpLiqDetCantNum[0] ;
         A714ImpLiqDetConSisYDes = P00OE2_A714ImpLiqDetConSisYDes[0] ;
         A666ImpLiqDetConCod = P00OE2_A666ImpLiqDetConCod[0] ;
         A712ImpLiqDetLegSis = P00OE2_A712ImpLiqDetLegSis[0] ;
         A663ImpLiqDetCUIL = P00OE2_A663ImpLiqDetCUIL[0] ;
         A88ImpLiqSec = P00OE2_A88ImpLiqSec[0] ;
         A90ImpLiqDetSec = P00OE2_A90ImpLiqDetSec[0] ;
         AV64count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00OE2_A661ImpLiqDetPer[0], A661ImpLiqDetPer) == 0 ) )
         {
            brkOE2 = false ;
            A3CliCod = P00OE2_A3CliCod[0] ;
            A1EmpCod = P00OE2_A1EmpCod[0] ;
            A88ImpLiqSec = P00OE2_A88ImpLiqSec[0] ;
            A90ImpLiqDetSec = P00OE2_A90ImpLiqDetSec[0] ;
            AV64count = (long)(AV64count+1) ;
            brkOE2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A661ImpLiqDetPer)==0) )
         {
            AV56Option = A661ImpLiqDetPer ;
            AV57Options.add(AV56Option, 0);
            AV62OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV64count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV57Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkOE2 )
         {
            brkOE2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADIMPLIQDETCUILOPTIONS' Routine */
      returnInSub = false ;
      AV20TFImpLiqDetCUIL = AV52SearchTxt ;
      AV21TFImpLiqDetCUIL_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV88Importlsd2ds_1_clicod = AV70CliCod ;
      AV89Importlsd2ds_2_empcod = AV71EmpCod ;
      AV90Importlsd2ds_3_tficonoupdate = AV11TFiconoUpdate ;
      AV91Importlsd2ds_4_tficonoupdateoperator = AV12TFiconoUpdateOperator ;
      AV92Importlsd2ds_5_tfimpliqdetper = AV17TFImpLiqDetPer ;
      AV93Importlsd2ds_6_tfimpliqdetper_sels = AV18TFImpLiqDetPer_Sels ;
      AV94Importlsd2ds_7_tfimpliqdetcuil = AV20TFImpLiqDetCUIL ;
      AV95Importlsd2ds_8_tfimpliqdetcuil_sels = AV21TFImpLiqDetCUIL_Sels ;
      AV96Importlsd2ds_9_tfimpliqdetlegsis = AV23TFImpLiqDetLegSis ;
      AV97Importlsd2ds_10_tfimpliqdetlegsis_sels = AV24TFImpLiqDetLegSis_Sels ;
      AV98Importlsd2ds_11_tfimpliqdetconcod = AV26TFImpLiqDetConCod ;
      AV99Importlsd2ds_12_tfimpliqdetconcod_sels = AV27TFImpLiqDetConCod_Sels ;
      AV100Importlsd2ds_13_tfimpliqdetconsisydes = AV80TFImpLiqDetConSisYDes ;
      AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV81TFImpLiqDetConSisYDes_Sels ;
      AV102Importlsd2ds_15_tfimpliqdetcantnum = AV75TFImpLiqDetCantNum ;
      AV103Importlsd2ds_16_tfimpliqdetcantnum_to = AV76TFImpLiqDetCantNum_To ;
      AV104Importlsd2ds_17_tfimpliqdetimpnum = AV77TFImpLiqDetImpNum ;
      AV105Importlsd2ds_18_tfimpliqdetimpnum_to = AV78TFImpLiqDetImpNum_To ;
      AV106Importlsd2ds_19_tfimpliqdetsigno = AV35TFImpLiqDetSigno ;
      AV107Importlsd2ds_20_tfimpliqdetsigno_sels = AV36TFImpLiqDetSigno_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A661ImpLiqDetPer ,
                                           AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                           A663ImpLiqDetCUIL ,
                                           AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                           A712ImpLiqDetLegSis ,
                                           AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                           A666ImpLiqDetConCod ,
                                           AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                           A714ImpLiqDetConSisYDes ,
                                           AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                           A670ImpLiqDetSigno ,
                                           AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                           Short.valueOf(AV91Importlsd2ds_4_tficonoupdateoperator) ,
                                           Integer.valueOf(AV93Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                           AV92Importlsd2ds_5_tfimpliqdetper ,
                                           Integer.valueOf(AV95Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                           AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                           Integer.valueOf(AV97Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                           AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                           Integer.valueOf(AV99Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                           AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                           Integer.valueOf(AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                           AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                           AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                           AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                           AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                           AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                           Integer.valueOf(AV107Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                           AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                           A709ImpLiqDetError ,
                                           A715ImpLiqDetCantNum ,
                                           A716ImpLiqDetImpNum ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88Importlsd2ds_1_clicod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV89Importlsd2ds_2_empcod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV92Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV92Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
      lV94Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV94Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
      lV96Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV96Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
      lV98Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV98Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
      lV100Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV100Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
      lV106Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV106Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
      /* Using cursor P00OE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV88Importlsd2ds_1_clicod), Short.valueOf(AV89Importlsd2ds_2_empcod), lV92Importlsd2ds_5_tfimpliqdetper, lV94Importlsd2ds_7_tfimpliqdetcuil, lV96Importlsd2ds_9_tfimpliqdetlegsis, lV98Importlsd2ds_11_tfimpliqdetconcod, lV100Importlsd2ds_13_tfimpliqdetconsisydes, AV102Importlsd2ds_15_tfimpliqdetcantnum, AV103Importlsd2ds_16_tfimpliqdetcantnum_to, AV104Importlsd2ds_17_tfimpliqdetimpnum, AV105Importlsd2ds_18_tfimpliqdetimpnum_to, lV106Importlsd2ds_19_tfimpliqdetsigno});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkOE4 = false ;
         A3CliCod = P00OE3_A3CliCod[0] ;
         A1EmpCod = P00OE3_A1EmpCod[0] ;
         A663ImpLiqDetCUIL = P00OE3_A663ImpLiqDetCUIL[0] ;
         A709ImpLiqDetError = P00OE3_A709ImpLiqDetError[0] ;
         A670ImpLiqDetSigno = P00OE3_A670ImpLiqDetSigno[0] ;
         A716ImpLiqDetImpNum = P00OE3_A716ImpLiqDetImpNum[0] ;
         A715ImpLiqDetCantNum = P00OE3_A715ImpLiqDetCantNum[0] ;
         A714ImpLiqDetConSisYDes = P00OE3_A714ImpLiqDetConSisYDes[0] ;
         A666ImpLiqDetConCod = P00OE3_A666ImpLiqDetConCod[0] ;
         A712ImpLiqDetLegSis = P00OE3_A712ImpLiqDetLegSis[0] ;
         A661ImpLiqDetPer = P00OE3_A661ImpLiqDetPer[0] ;
         A88ImpLiqSec = P00OE3_A88ImpLiqSec[0] ;
         A90ImpLiqDetSec = P00OE3_A90ImpLiqDetSec[0] ;
         AV64count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00OE3_A663ImpLiqDetCUIL[0], A663ImpLiqDetCUIL) == 0 ) )
         {
            brkOE4 = false ;
            A3CliCod = P00OE3_A3CliCod[0] ;
            A1EmpCod = P00OE3_A1EmpCod[0] ;
            A88ImpLiqSec = P00OE3_A88ImpLiqSec[0] ;
            A90ImpLiqDetSec = P00OE3_A90ImpLiqDetSec[0] ;
            AV64count = (long)(AV64count+1) ;
            brkOE4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A663ImpLiqDetCUIL)==0) )
         {
            AV56Option = A663ImpLiqDetCUIL ;
            AV57Options.add(AV56Option, 0);
            AV62OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV64count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV57Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkOE4 )
         {
            brkOE4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADIMPLIQDETLEGSISOPTIONS' Routine */
      returnInSub = false ;
      AV23TFImpLiqDetLegSis = AV52SearchTxt ;
      AV24TFImpLiqDetLegSis_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV88Importlsd2ds_1_clicod = AV70CliCod ;
      AV89Importlsd2ds_2_empcod = AV71EmpCod ;
      AV90Importlsd2ds_3_tficonoupdate = AV11TFiconoUpdate ;
      AV91Importlsd2ds_4_tficonoupdateoperator = AV12TFiconoUpdateOperator ;
      AV92Importlsd2ds_5_tfimpliqdetper = AV17TFImpLiqDetPer ;
      AV93Importlsd2ds_6_tfimpliqdetper_sels = AV18TFImpLiqDetPer_Sels ;
      AV94Importlsd2ds_7_tfimpliqdetcuil = AV20TFImpLiqDetCUIL ;
      AV95Importlsd2ds_8_tfimpliqdetcuil_sels = AV21TFImpLiqDetCUIL_Sels ;
      AV96Importlsd2ds_9_tfimpliqdetlegsis = AV23TFImpLiqDetLegSis ;
      AV97Importlsd2ds_10_tfimpliqdetlegsis_sels = AV24TFImpLiqDetLegSis_Sels ;
      AV98Importlsd2ds_11_tfimpliqdetconcod = AV26TFImpLiqDetConCod ;
      AV99Importlsd2ds_12_tfimpliqdetconcod_sels = AV27TFImpLiqDetConCod_Sels ;
      AV100Importlsd2ds_13_tfimpliqdetconsisydes = AV80TFImpLiqDetConSisYDes ;
      AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV81TFImpLiqDetConSisYDes_Sels ;
      AV102Importlsd2ds_15_tfimpliqdetcantnum = AV75TFImpLiqDetCantNum ;
      AV103Importlsd2ds_16_tfimpliqdetcantnum_to = AV76TFImpLiqDetCantNum_To ;
      AV104Importlsd2ds_17_tfimpliqdetimpnum = AV77TFImpLiqDetImpNum ;
      AV105Importlsd2ds_18_tfimpliqdetimpnum_to = AV78TFImpLiqDetImpNum_To ;
      AV106Importlsd2ds_19_tfimpliqdetsigno = AV35TFImpLiqDetSigno ;
      AV107Importlsd2ds_20_tfimpliqdetsigno_sels = AV36TFImpLiqDetSigno_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A661ImpLiqDetPer ,
                                           AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                           A663ImpLiqDetCUIL ,
                                           AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                           A712ImpLiqDetLegSis ,
                                           AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                           A666ImpLiqDetConCod ,
                                           AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                           A714ImpLiqDetConSisYDes ,
                                           AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                           A670ImpLiqDetSigno ,
                                           AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                           Short.valueOf(AV91Importlsd2ds_4_tficonoupdateoperator) ,
                                           Integer.valueOf(AV93Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                           AV92Importlsd2ds_5_tfimpliqdetper ,
                                           Integer.valueOf(AV95Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                           AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                           Integer.valueOf(AV97Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                           AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                           Integer.valueOf(AV99Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                           AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                           Integer.valueOf(AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                           AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                           AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                           AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                           AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                           AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                           Integer.valueOf(AV107Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                           AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                           A709ImpLiqDetError ,
                                           A715ImpLiqDetCantNum ,
                                           A716ImpLiqDetImpNum ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88Importlsd2ds_1_clicod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV89Importlsd2ds_2_empcod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV92Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV92Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
      lV94Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV94Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
      lV96Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV96Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
      lV98Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV98Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
      lV100Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV100Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
      lV106Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV106Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
      /* Using cursor P00OE4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV88Importlsd2ds_1_clicod), Short.valueOf(AV89Importlsd2ds_2_empcod), lV92Importlsd2ds_5_tfimpliqdetper, lV94Importlsd2ds_7_tfimpliqdetcuil, lV96Importlsd2ds_9_tfimpliqdetlegsis, lV98Importlsd2ds_11_tfimpliqdetconcod, lV100Importlsd2ds_13_tfimpliqdetconsisydes, AV102Importlsd2ds_15_tfimpliqdetcantnum, AV103Importlsd2ds_16_tfimpliqdetcantnum_to, AV104Importlsd2ds_17_tfimpliqdetimpnum, AV105Importlsd2ds_18_tfimpliqdetimpnum_to, lV106Importlsd2ds_19_tfimpliqdetsigno});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brkOE6 = false ;
         A3CliCod = P00OE4_A3CliCod[0] ;
         A1EmpCod = P00OE4_A1EmpCod[0] ;
         A712ImpLiqDetLegSis = P00OE4_A712ImpLiqDetLegSis[0] ;
         A709ImpLiqDetError = P00OE4_A709ImpLiqDetError[0] ;
         A670ImpLiqDetSigno = P00OE4_A670ImpLiqDetSigno[0] ;
         A716ImpLiqDetImpNum = P00OE4_A716ImpLiqDetImpNum[0] ;
         A715ImpLiqDetCantNum = P00OE4_A715ImpLiqDetCantNum[0] ;
         A714ImpLiqDetConSisYDes = P00OE4_A714ImpLiqDetConSisYDes[0] ;
         A666ImpLiqDetConCod = P00OE4_A666ImpLiqDetConCod[0] ;
         A663ImpLiqDetCUIL = P00OE4_A663ImpLiqDetCUIL[0] ;
         A661ImpLiqDetPer = P00OE4_A661ImpLiqDetPer[0] ;
         A88ImpLiqSec = P00OE4_A88ImpLiqSec[0] ;
         A90ImpLiqDetSec = P00OE4_A90ImpLiqDetSec[0] ;
         AV64count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P00OE4_A712ImpLiqDetLegSis[0], A712ImpLiqDetLegSis) == 0 ) )
         {
            brkOE6 = false ;
            A3CliCod = P00OE4_A3CliCod[0] ;
            A1EmpCod = P00OE4_A1EmpCod[0] ;
            A88ImpLiqSec = P00OE4_A88ImpLiqSec[0] ;
            A90ImpLiqDetSec = P00OE4_A90ImpLiqDetSec[0] ;
            AV64count = (long)(AV64count+1) ;
            brkOE6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A712ImpLiqDetLegSis)==0) )
         {
            AV56Option = A712ImpLiqDetLegSis ;
            AV57Options.add(AV56Option, 0);
            AV62OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV64count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV57Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkOE6 )
         {
            brkOE6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADIMPLIQDETCONCODOPTIONS' Routine */
      returnInSub = false ;
      AV26TFImpLiqDetConCod = AV52SearchTxt ;
      AV27TFImpLiqDetConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV88Importlsd2ds_1_clicod = AV70CliCod ;
      AV89Importlsd2ds_2_empcod = AV71EmpCod ;
      AV90Importlsd2ds_3_tficonoupdate = AV11TFiconoUpdate ;
      AV91Importlsd2ds_4_tficonoupdateoperator = AV12TFiconoUpdateOperator ;
      AV92Importlsd2ds_5_tfimpliqdetper = AV17TFImpLiqDetPer ;
      AV93Importlsd2ds_6_tfimpliqdetper_sels = AV18TFImpLiqDetPer_Sels ;
      AV94Importlsd2ds_7_tfimpliqdetcuil = AV20TFImpLiqDetCUIL ;
      AV95Importlsd2ds_8_tfimpliqdetcuil_sels = AV21TFImpLiqDetCUIL_Sels ;
      AV96Importlsd2ds_9_tfimpliqdetlegsis = AV23TFImpLiqDetLegSis ;
      AV97Importlsd2ds_10_tfimpliqdetlegsis_sels = AV24TFImpLiqDetLegSis_Sels ;
      AV98Importlsd2ds_11_tfimpliqdetconcod = AV26TFImpLiqDetConCod ;
      AV99Importlsd2ds_12_tfimpliqdetconcod_sels = AV27TFImpLiqDetConCod_Sels ;
      AV100Importlsd2ds_13_tfimpliqdetconsisydes = AV80TFImpLiqDetConSisYDes ;
      AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV81TFImpLiqDetConSisYDes_Sels ;
      AV102Importlsd2ds_15_tfimpliqdetcantnum = AV75TFImpLiqDetCantNum ;
      AV103Importlsd2ds_16_tfimpliqdetcantnum_to = AV76TFImpLiqDetCantNum_To ;
      AV104Importlsd2ds_17_tfimpliqdetimpnum = AV77TFImpLiqDetImpNum ;
      AV105Importlsd2ds_18_tfimpliqdetimpnum_to = AV78TFImpLiqDetImpNum_To ;
      AV106Importlsd2ds_19_tfimpliqdetsigno = AV35TFImpLiqDetSigno ;
      AV107Importlsd2ds_20_tfimpliqdetsigno_sels = AV36TFImpLiqDetSigno_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A661ImpLiqDetPer ,
                                           AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                           A663ImpLiqDetCUIL ,
                                           AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                           A712ImpLiqDetLegSis ,
                                           AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                           A666ImpLiqDetConCod ,
                                           AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                           A714ImpLiqDetConSisYDes ,
                                           AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                           A670ImpLiqDetSigno ,
                                           AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                           Short.valueOf(AV91Importlsd2ds_4_tficonoupdateoperator) ,
                                           Integer.valueOf(AV93Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                           AV92Importlsd2ds_5_tfimpliqdetper ,
                                           Integer.valueOf(AV95Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                           AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                           Integer.valueOf(AV97Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                           AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                           Integer.valueOf(AV99Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                           AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                           Integer.valueOf(AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                           AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                           AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                           AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                           AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                           AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                           Integer.valueOf(AV107Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                           AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                           A709ImpLiqDetError ,
                                           A715ImpLiqDetCantNum ,
                                           A716ImpLiqDetImpNum ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88Importlsd2ds_1_clicod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV89Importlsd2ds_2_empcod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV92Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV92Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
      lV94Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV94Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
      lV96Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV96Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
      lV98Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV98Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
      lV100Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV100Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
      lV106Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV106Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
      /* Using cursor P00OE5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV88Importlsd2ds_1_clicod), Short.valueOf(AV89Importlsd2ds_2_empcod), lV92Importlsd2ds_5_tfimpliqdetper, lV94Importlsd2ds_7_tfimpliqdetcuil, lV96Importlsd2ds_9_tfimpliqdetlegsis, lV98Importlsd2ds_11_tfimpliqdetconcod, lV100Importlsd2ds_13_tfimpliqdetconsisydes, AV102Importlsd2ds_15_tfimpliqdetcantnum, AV103Importlsd2ds_16_tfimpliqdetcantnum_to, AV104Importlsd2ds_17_tfimpliqdetimpnum, AV105Importlsd2ds_18_tfimpliqdetimpnum_to, lV106Importlsd2ds_19_tfimpliqdetsigno});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brkOE8 = false ;
         A3CliCod = P00OE5_A3CliCod[0] ;
         A1EmpCod = P00OE5_A1EmpCod[0] ;
         A666ImpLiqDetConCod = P00OE5_A666ImpLiqDetConCod[0] ;
         A709ImpLiqDetError = P00OE5_A709ImpLiqDetError[0] ;
         A670ImpLiqDetSigno = P00OE5_A670ImpLiqDetSigno[0] ;
         A716ImpLiqDetImpNum = P00OE5_A716ImpLiqDetImpNum[0] ;
         A715ImpLiqDetCantNum = P00OE5_A715ImpLiqDetCantNum[0] ;
         A714ImpLiqDetConSisYDes = P00OE5_A714ImpLiqDetConSisYDes[0] ;
         A712ImpLiqDetLegSis = P00OE5_A712ImpLiqDetLegSis[0] ;
         A663ImpLiqDetCUIL = P00OE5_A663ImpLiqDetCUIL[0] ;
         A661ImpLiqDetPer = P00OE5_A661ImpLiqDetPer[0] ;
         A88ImpLiqSec = P00OE5_A88ImpLiqSec[0] ;
         A90ImpLiqDetSec = P00OE5_A90ImpLiqDetSec[0] ;
         AV64count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P00OE5_A666ImpLiqDetConCod[0], A666ImpLiqDetConCod) == 0 ) )
         {
            brkOE8 = false ;
            A3CliCod = P00OE5_A3CliCod[0] ;
            A1EmpCod = P00OE5_A1EmpCod[0] ;
            A88ImpLiqSec = P00OE5_A88ImpLiqSec[0] ;
            A90ImpLiqDetSec = P00OE5_A90ImpLiqDetSec[0] ;
            AV64count = (long)(AV64count+1) ;
            brkOE8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A666ImpLiqDetConCod)==0) )
         {
            AV56Option = A666ImpLiqDetConCod ;
            AV57Options.add(AV56Option, 0);
            AV62OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV64count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV57Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkOE8 )
         {
            brkOE8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADIMPLIQDETCONSISYDESOPTIONS' Routine */
      returnInSub = false ;
      AV80TFImpLiqDetConSisYDes = AV52SearchTxt ;
      AV81TFImpLiqDetConSisYDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV88Importlsd2ds_1_clicod = AV70CliCod ;
      AV89Importlsd2ds_2_empcod = AV71EmpCod ;
      AV90Importlsd2ds_3_tficonoupdate = AV11TFiconoUpdate ;
      AV91Importlsd2ds_4_tficonoupdateoperator = AV12TFiconoUpdateOperator ;
      AV92Importlsd2ds_5_tfimpliqdetper = AV17TFImpLiqDetPer ;
      AV93Importlsd2ds_6_tfimpliqdetper_sels = AV18TFImpLiqDetPer_Sels ;
      AV94Importlsd2ds_7_tfimpliqdetcuil = AV20TFImpLiqDetCUIL ;
      AV95Importlsd2ds_8_tfimpliqdetcuil_sels = AV21TFImpLiqDetCUIL_Sels ;
      AV96Importlsd2ds_9_tfimpliqdetlegsis = AV23TFImpLiqDetLegSis ;
      AV97Importlsd2ds_10_tfimpliqdetlegsis_sels = AV24TFImpLiqDetLegSis_Sels ;
      AV98Importlsd2ds_11_tfimpliqdetconcod = AV26TFImpLiqDetConCod ;
      AV99Importlsd2ds_12_tfimpliqdetconcod_sels = AV27TFImpLiqDetConCod_Sels ;
      AV100Importlsd2ds_13_tfimpliqdetconsisydes = AV80TFImpLiqDetConSisYDes ;
      AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV81TFImpLiqDetConSisYDes_Sels ;
      AV102Importlsd2ds_15_tfimpliqdetcantnum = AV75TFImpLiqDetCantNum ;
      AV103Importlsd2ds_16_tfimpliqdetcantnum_to = AV76TFImpLiqDetCantNum_To ;
      AV104Importlsd2ds_17_tfimpliqdetimpnum = AV77TFImpLiqDetImpNum ;
      AV105Importlsd2ds_18_tfimpliqdetimpnum_to = AV78TFImpLiqDetImpNum_To ;
      AV106Importlsd2ds_19_tfimpliqdetsigno = AV35TFImpLiqDetSigno ;
      AV107Importlsd2ds_20_tfimpliqdetsigno_sels = AV36TFImpLiqDetSigno_Sels ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A661ImpLiqDetPer ,
                                           AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                           A663ImpLiqDetCUIL ,
                                           AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                           A712ImpLiqDetLegSis ,
                                           AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                           A666ImpLiqDetConCod ,
                                           AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                           A714ImpLiqDetConSisYDes ,
                                           AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                           A670ImpLiqDetSigno ,
                                           AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                           Short.valueOf(AV91Importlsd2ds_4_tficonoupdateoperator) ,
                                           Integer.valueOf(AV93Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                           AV92Importlsd2ds_5_tfimpliqdetper ,
                                           Integer.valueOf(AV95Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                           AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                           Integer.valueOf(AV97Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                           AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                           Integer.valueOf(AV99Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                           AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                           Integer.valueOf(AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                           AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                           AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                           AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                           AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                           AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                           Integer.valueOf(AV107Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                           AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                           A709ImpLiqDetError ,
                                           A715ImpLiqDetCantNum ,
                                           A716ImpLiqDetImpNum ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88Importlsd2ds_1_clicod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV89Importlsd2ds_2_empcod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV92Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV92Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
      lV94Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV94Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
      lV96Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV96Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
      lV98Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV98Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
      lV100Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV100Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
      lV106Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV106Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
      /* Using cursor P00OE6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV88Importlsd2ds_1_clicod), Short.valueOf(AV89Importlsd2ds_2_empcod), lV92Importlsd2ds_5_tfimpliqdetper, lV94Importlsd2ds_7_tfimpliqdetcuil, lV96Importlsd2ds_9_tfimpliqdetlegsis, lV98Importlsd2ds_11_tfimpliqdetconcod, lV100Importlsd2ds_13_tfimpliqdetconsisydes, AV102Importlsd2ds_15_tfimpliqdetcantnum, AV103Importlsd2ds_16_tfimpliqdetcantnum_to, AV104Importlsd2ds_17_tfimpliqdetimpnum, AV105Importlsd2ds_18_tfimpliqdetimpnum_to, lV106Importlsd2ds_19_tfimpliqdetsigno});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brkOE10 = false ;
         A3CliCod = P00OE6_A3CliCod[0] ;
         A1EmpCod = P00OE6_A1EmpCod[0] ;
         A714ImpLiqDetConSisYDes = P00OE6_A714ImpLiqDetConSisYDes[0] ;
         A709ImpLiqDetError = P00OE6_A709ImpLiqDetError[0] ;
         A670ImpLiqDetSigno = P00OE6_A670ImpLiqDetSigno[0] ;
         A716ImpLiqDetImpNum = P00OE6_A716ImpLiqDetImpNum[0] ;
         A715ImpLiqDetCantNum = P00OE6_A715ImpLiqDetCantNum[0] ;
         A666ImpLiqDetConCod = P00OE6_A666ImpLiqDetConCod[0] ;
         A712ImpLiqDetLegSis = P00OE6_A712ImpLiqDetLegSis[0] ;
         A663ImpLiqDetCUIL = P00OE6_A663ImpLiqDetCUIL[0] ;
         A661ImpLiqDetPer = P00OE6_A661ImpLiqDetPer[0] ;
         A88ImpLiqSec = P00OE6_A88ImpLiqSec[0] ;
         A90ImpLiqDetSec = P00OE6_A90ImpLiqDetSec[0] ;
         AV64count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( GXutil.strcmp(P00OE6_A714ImpLiqDetConSisYDes[0], A714ImpLiqDetConSisYDes) == 0 ) )
         {
            brkOE10 = false ;
            A3CliCod = P00OE6_A3CliCod[0] ;
            A1EmpCod = P00OE6_A1EmpCod[0] ;
            A88ImpLiqSec = P00OE6_A88ImpLiqSec[0] ;
            A90ImpLiqDetSec = P00OE6_A90ImpLiqDetSec[0] ;
            AV64count = (long)(AV64count+1) ;
            brkOE10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A714ImpLiqDetConSisYDes)==0) )
         {
            AV56Option = A714ImpLiqDetConSisYDes ;
            AV57Options.add(AV56Option, 0);
            AV62OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV64count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV57Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkOE10 )
         {
            brkOE10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADIMPLIQDETSIGNOOPTIONS' Routine */
      returnInSub = false ;
      AV35TFImpLiqDetSigno = AV52SearchTxt ;
      AV36TFImpLiqDetSigno_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV88Importlsd2ds_1_clicod = AV70CliCod ;
      AV89Importlsd2ds_2_empcod = AV71EmpCod ;
      AV90Importlsd2ds_3_tficonoupdate = AV11TFiconoUpdate ;
      AV91Importlsd2ds_4_tficonoupdateoperator = AV12TFiconoUpdateOperator ;
      AV92Importlsd2ds_5_tfimpliqdetper = AV17TFImpLiqDetPer ;
      AV93Importlsd2ds_6_tfimpliqdetper_sels = AV18TFImpLiqDetPer_Sels ;
      AV94Importlsd2ds_7_tfimpliqdetcuil = AV20TFImpLiqDetCUIL ;
      AV95Importlsd2ds_8_tfimpliqdetcuil_sels = AV21TFImpLiqDetCUIL_Sels ;
      AV96Importlsd2ds_9_tfimpliqdetlegsis = AV23TFImpLiqDetLegSis ;
      AV97Importlsd2ds_10_tfimpliqdetlegsis_sels = AV24TFImpLiqDetLegSis_Sels ;
      AV98Importlsd2ds_11_tfimpliqdetconcod = AV26TFImpLiqDetConCod ;
      AV99Importlsd2ds_12_tfimpliqdetconcod_sels = AV27TFImpLiqDetConCod_Sels ;
      AV100Importlsd2ds_13_tfimpliqdetconsisydes = AV80TFImpLiqDetConSisYDes ;
      AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels = AV81TFImpLiqDetConSisYDes_Sels ;
      AV102Importlsd2ds_15_tfimpliqdetcantnum = AV75TFImpLiqDetCantNum ;
      AV103Importlsd2ds_16_tfimpliqdetcantnum_to = AV76TFImpLiqDetCantNum_To ;
      AV104Importlsd2ds_17_tfimpliqdetimpnum = AV77TFImpLiqDetImpNum ;
      AV105Importlsd2ds_18_tfimpliqdetimpnum_to = AV78TFImpLiqDetImpNum_To ;
      AV106Importlsd2ds_19_tfimpliqdetsigno = AV35TFImpLiqDetSigno ;
      AV107Importlsd2ds_20_tfimpliqdetsigno_sels = AV36TFImpLiqDetSigno_Sels ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A661ImpLiqDetPer ,
                                           AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                           A663ImpLiqDetCUIL ,
                                           AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                           A712ImpLiqDetLegSis ,
                                           AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                           A666ImpLiqDetConCod ,
                                           AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                           A714ImpLiqDetConSisYDes ,
                                           AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                           A670ImpLiqDetSigno ,
                                           AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                           Short.valueOf(AV91Importlsd2ds_4_tficonoupdateoperator) ,
                                           Integer.valueOf(AV93Importlsd2ds_6_tfimpliqdetper_sels.size()) ,
                                           AV92Importlsd2ds_5_tfimpliqdetper ,
                                           Integer.valueOf(AV95Importlsd2ds_8_tfimpliqdetcuil_sels.size()) ,
                                           AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                           Integer.valueOf(AV97Importlsd2ds_10_tfimpliqdetlegsis_sels.size()) ,
                                           AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                           Integer.valueOf(AV99Importlsd2ds_12_tfimpliqdetconcod_sels.size()) ,
                                           AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                           Integer.valueOf(AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels.size()) ,
                                           AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                           AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                           AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                           AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                           AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                           Integer.valueOf(AV107Importlsd2ds_20_tfimpliqdetsigno_sels.size()) ,
                                           AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                           A709ImpLiqDetError ,
                                           A715ImpLiqDetCantNum ,
                                           A716ImpLiqDetImpNum ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88Importlsd2ds_1_clicod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV89Importlsd2ds_2_empcod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV92Importlsd2ds_5_tfimpliqdetper = GXutil.padr( GXutil.rtrim( AV92Importlsd2ds_5_tfimpliqdetper), 6, "%") ;
      lV94Importlsd2ds_7_tfimpliqdetcuil = GXutil.padr( GXutil.rtrim( AV94Importlsd2ds_7_tfimpliqdetcuil), 11, "%") ;
      lV96Importlsd2ds_9_tfimpliqdetlegsis = GXutil.concat( GXutil.rtrim( AV96Importlsd2ds_9_tfimpliqdetlegsis), "%", "") ;
      lV98Importlsd2ds_11_tfimpliqdetconcod = GXutil.padr( GXutil.rtrim( AV98Importlsd2ds_11_tfimpliqdetconcod), 10, "%") ;
      lV100Importlsd2ds_13_tfimpliqdetconsisydes = GXutil.concat( GXutil.rtrim( AV100Importlsd2ds_13_tfimpliqdetconsisydes), "%", "") ;
      lV106Importlsd2ds_19_tfimpliqdetsigno = GXutil.padr( GXutil.rtrim( AV106Importlsd2ds_19_tfimpliqdetsigno), 1, "%") ;
      /* Using cursor P00OE7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV88Importlsd2ds_1_clicod), Short.valueOf(AV89Importlsd2ds_2_empcod), lV92Importlsd2ds_5_tfimpliqdetper, lV94Importlsd2ds_7_tfimpliqdetcuil, lV96Importlsd2ds_9_tfimpliqdetlegsis, lV98Importlsd2ds_11_tfimpliqdetconcod, lV100Importlsd2ds_13_tfimpliqdetconsisydes, AV102Importlsd2ds_15_tfimpliqdetcantnum, AV103Importlsd2ds_16_tfimpliqdetcantnum_to, AV104Importlsd2ds_17_tfimpliqdetimpnum, AV105Importlsd2ds_18_tfimpliqdetimpnum_to, lV106Importlsd2ds_19_tfimpliqdetsigno});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brkOE12 = false ;
         A3CliCod = P00OE7_A3CliCod[0] ;
         A1EmpCod = P00OE7_A1EmpCod[0] ;
         A670ImpLiqDetSigno = P00OE7_A670ImpLiqDetSigno[0] ;
         A709ImpLiqDetError = P00OE7_A709ImpLiqDetError[0] ;
         A716ImpLiqDetImpNum = P00OE7_A716ImpLiqDetImpNum[0] ;
         A715ImpLiqDetCantNum = P00OE7_A715ImpLiqDetCantNum[0] ;
         A714ImpLiqDetConSisYDes = P00OE7_A714ImpLiqDetConSisYDes[0] ;
         A666ImpLiqDetConCod = P00OE7_A666ImpLiqDetConCod[0] ;
         A712ImpLiqDetLegSis = P00OE7_A712ImpLiqDetLegSis[0] ;
         A663ImpLiqDetCUIL = P00OE7_A663ImpLiqDetCUIL[0] ;
         A661ImpLiqDetPer = P00OE7_A661ImpLiqDetPer[0] ;
         A88ImpLiqSec = P00OE7_A88ImpLiqSec[0] ;
         A90ImpLiqDetSec = P00OE7_A90ImpLiqDetSec[0] ;
         AV64count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( GXutil.strcmp(P00OE7_A670ImpLiqDetSigno[0], A670ImpLiqDetSigno) == 0 ) )
         {
            brkOE12 = false ;
            A3CliCod = P00OE7_A3CliCod[0] ;
            A1EmpCod = P00OE7_A1EmpCod[0] ;
            A88ImpLiqSec = P00OE7_A88ImpLiqSec[0] ;
            A90ImpLiqDetSec = P00OE7_A90ImpLiqDetSec[0] ;
            AV64count = (long)(AV64count+1) ;
            brkOE12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A670ImpLiqDetSigno)==0) )
         {
            AV56Option = A670ImpLiqDetSigno ;
            AV57Options.add(AV56Option, 0);
            AV62OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV64count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV57Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkOE12 )
         {
            brkOE12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   protected void cleanup( )
   {
      this.aP3[0] = importlsd2getfilterdata.this.AV58OptionsJson;
      this.aP4[0] = importlsd2getfilterdata.this.AV61OptionsDescJson;
      this.aP5[0] = importlsd2getfilterdata.this.AV63OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV58OptionsJson = "" ;
      AV61OptionsDescJson = "" ;
      AV63OptionIndexesJson = "" ;
      AV57Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV65Session = httpContext.getWebSession();
      AV67GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV68GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV17TFImpLiqDetPer = "" ;
      AV16TFImpLiqDetPer_SelsJson = "" ;
      AV18TFImpLiqDetPer_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFImpLiqDetCUIL = "" ;
      AV19TFImpLiqDetCUIL_SelsJson = "" ;
      AV21TFImpLiqDetCUIL_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFImpLiqDetLegSis = "" ;
      AV22TFImpLiqDetLegSis_SelsJson = "" ;
      AV24TFImpLiqDetLegSis_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26TFImpLiqDetConCod = "" ;
      AV25TFImpLiqDetConCod_SelsJson = "" ;
      AV27TFImpLiqDetConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV80TFImpLiqDetConSisYDes = "" ;
      AV79TFImpLiqDetConSisYDes_SelsJson = "" ;
      AV81TFImpLiqDetConSisYDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75TFImpLiqDetCantNum = DecimalUtil.ZERO ;
      AV76TFImpLiqDetCantNum_To = DecimalUtil.ZERO ;
      AV77TFImpLiqDetImpNum = DecimalUtil.ZERO ;
      AV78TFImpLiqDetImpNum_To = DecimalUtil.ZERO ;
      AV35TFImpLiqDetSigno = "" ;
      AV34TFImpLiqDetSigno_SelsJson = "" ;
      AV36TFImpLiqDetSigno_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A661ImpLiqDetPer = "" ;
      AV90Importlsd2ds_3_tficonoupdate = "" ;
      AV11TFiconoUpdate = "" ;
      AV92Importlsd2ds_5_tfimpliqdetper = "" ;
      AV93Importlsd2ds_6_tfimpliqdetper_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV94Importlsd2ds_7_tfimpliqdetcuil = "" ;
      AV95Importlsd2ds_8_tfimpliqdetcuil_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV96Importlsd2ds_9_tfimpliqdetlegsis = "" ;
      AV97Importlsd2ds_10_tfimpliqdetlegsis_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98Importlsd2ds_11_tfimpliqdetconcod = "" ;
      AV99Importlsd2ds_12_tfimpliqdetconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Importlsd2ds_13_tfimpliqdetconsisydes = "" ;
      AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV102Importlsd2ds_15_tfimpliqdetcantnum = DecimalUtil.ZERO ;
      AV103Importlsd2ds_16_tfimpliqdetcantnum_to = DecimalUtil.ZERO ;
      AV104Importlsd2ds_17_tfimpliqdetimpnum = DecimalUtil.ZERO ;
      AV105Importlsd2ds_18_tfimpliqdetimpnum_to = DecimalUtil.ZERO ;
      AV106Importlsd2ds_19_tfimpliqdetsigno = "" ;
      AV107Importlsd2ds_20_tfimpliqdetsigno_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV92Importlsd2ds_5_tfimpliqdetper = "" ;
      lV94Importlsd2ds_7_tfimpliqdetcuil = "" ;
      lV96Importlsd2ds_9_tfimpliqdetlegsis = "" ;
      lV98Importlsd2ds_11_tfimpliqdetconcod = "" ;
      lV100Importlsd2ds_13_tfimpliqdetconsisydes = "" ;
      lV106Importlsd2ds_19_tfimpliqdetsigno = "" ;
      A663ImpLiqDetCUIL = "" ;
      A712ImpLiqDetLegSis = "" ;
      A666ImpLiqDetConCod = "" ;
      A714ImpLiqDetConSisYDes = "" ;
      A670ImpLiqDetSigno = "" ;
      A709ImpLiqDetError = "" ;
      A715ImpLiqDetCantNum = DecimalUtil.ZERO ;
      A716ImpLiqDetImpNum = DecimalUtil.ZERO ;
      P00OE2_A3CliCod = new int[1] ;
      P00OE2_A1EmpCod = new short[1] ;
      P00OE2_A661ImpLiqDetPer = new String[] {""} ;
      P00OE2_A709ImpLiqDetError = new String[] {""} ;
      P00OE2_A670ImpLiqDetSigno = new String[] {""} ;
      P00OE2_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE2_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE2_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OE2_A666ImpLiqDetConCod = new String[] {""} ;
      P00OE2_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OE2_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OE2_A88ImpLiqSec = new short[1] ;
      P00OE2_A90ImpLiqDetSec = new short[1] ;
      AV56Option = "" ;
      P00OE3_A3CliCod = new int[1] ;
      P00OE3_A1EmpCod = new short[1] ;
      P00OE3_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OE3_A709ImpLiqDetError = new String[] {""} ;
      P00OE3_A670ImpLiqDetSigno = new String[] {""} ;
      P00OE3_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE3_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE3_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OE3_A666ImpLiqDetConCod = new String[] {""} ;
      P00OE3_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OE3_A661ImpLiqDetPer = new String[] {""} ;
      P00OE3_A88ImpLiqSec = new short[1] ;
      P00OE3_A90ImpLiqDetSec = new short[1] ;
      P00OE4_A3CliCod = new int[1] ;
      P00OE4_A1EmpCod = new short[1] ;
      P00OE4_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OE4_A709ImpLiqDetError = new String[] {""} ;
      P00OE4_A670ImpLiqDetSigno = new String[] {""} ;
      P00OE4_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE4_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE4_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OE4_A666ImpLiqDetConCod = new String[] {""} ;
      P00OE4_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OE4_A661ImpLiqDetPer = new String[] {""} ;
      P00OE4_A88ImpLiqSec = new short[1] ;
      P00OE4_A90ImpLiqDetSec = new short[1] ;
      P00OE5_A3CliCod = new int[1] ;
      P00OE5_A1EmpCod = new short[1] ;
      P00OE5_A666ImpLiqDetConCod = new String[] {""} ;
      P00OE5_A709ImpLiqDetError = new String[] {""} ;
      P00OE5_A670ImpLiqDetSigno = new String[] {""} ;
      P00OE5_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE5_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE5_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OE5_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OE5_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OE5_A661ImpLiqDetPer = new String[] {""} ;
      P00OE5_A88ImpLiqSec = new short[1] ;
      P00OE5_A90ImpLiqDetSec = new short[1] ;
      P00OE6_A3CliCod = new int[1] ;
      P00OE6_A1EmpCod = new short[1] ;
      P00OE6_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OE6_A709ImpLiqDetError = new String[] {""} ;
      P00OE6_A670ImpLiqDetSigno = new String[] {""} ;
      P00OE6_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE6_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE6_A666ImpLiqDetConCod = new String[] {""} ;
      P00OE6_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OE6_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OE6_A661ImpLiqDetPer = new String[] {""} ;
      P00OE6_A88ImpLiqSec = new short[1] ;
      P00OE6_A90ImpLiqDetSec = new short[1] ;
      P00OE7_A3CliCod = new int[1] ;
      P00OE7_A1EmpCod = new short[1] ;
      P00OE7_A670ImpLiqDetSigno = new String[] {""} ;
      P00OE7_A709ImpLiqDetError = new String[] {""} ;
      P00OE7_A716ImpLiqDetImpNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE7_A715ImpLiqDetCantNum = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00OE7_A714ImpLiqDetConSisYDes = new String[] {""} ;
      P00OE7_A666ImpLiqDetConCod = new String[] {""} ;
      P00OE7_A712ImpLiqDetLegSis = new String[] {""} ;
      P00OE7_A663ImpLiqDetCUIL = new String[] {""} ;
      P00OE7_A661ImpLiqDetPer = new String[] {""} ;
      P00OE7_A88ImpLiqSec = new short[1] ;
      P00OE7_A90ImpLiqDetSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importlsd2getfilterdata__default(),
         new Object[] {
             new Object[] {
            P00OE2_A3CliCod, P00OE2_A1EmpCod, P00OE2_A661ImpLiqDetPer, P00OE2_A709ImpLiqDetError, P00OE2_A670ImpLiqDetSigno, P00OE2_A716ImpLiqDetImpNum, P00OE2_A715ImpLiqDetCantNum, P00OE2_A714ImpLiqDetConSisYDes, P00OE2_A666ImpLiqDetConCod, P00OE2_A712ImpLiqDetLegSis,
            P00OE2_A663ImpLiqDetCUIL, P00OE2_A88ImpLiqSec, P00OE2_A90ImpLiqDetSec
            }
            , new Object[] {
            P00OE3_A3CliCod, P00OE3_A1EmpCod, P00OE3_A663ImpLiqDetCUIL, P00OE3_A709ImpLiqDetError, P00OE3_A670ImpLiqDetSigno, P00OE3_A716ImpLiqDetImpNum, P00OE3_A715ImpLiqDetCantNum, P00OE3_A714ImpLiqDetConSisYDes, P00OE3_A666ImpLiqDetConCod, P00OE3_A712ImpLiqDetLegSis,
            P00OE3_A661ImpLiqDetPer, P00OE3_A88ImpLiqSec, P00OE3_A90ImpLiqDetSec
            }
            , new Object[] {
            P00OE4_A3CliCod, P00OE4_A1EmpCod, P00OE4_A712ImpLiqDetLegSis, P00OE4_A709ImpLiqDetError, P00OE4_A670ImpLiqDetSigno, P00OE4_A716ImpLiqDetImpNum, P00OE4_A715ImpLiqDetCantNum, P00OE4_A714ImpLiqDetConSisYDes, P00OE4_A666ImpLiqDetConCod, P00OE4_A663ImpLiqDetCUIL,
            P00OE4_A661ImpLiqDetPer, P00OE4_A88ImpLiqSec, P00OE4_A90ImpLiqDetSec
            }
            , new Object[] {
            P00OE5_A3CliCod, P00OE5_A1EmpCod, P00OE5_A666ImpLiqDetConCod, P00OE5_A709ImpLiqDetError, P00OE5_A670ImpLiqDetSigno, P00OE5_A716ImpLiqDetImpNum, P00OE5_A715ImpLiqDetCantNum, P00OE5_A714ImpLiqDetConSisYDes, P00OE5_A712ImpLiqDetLegSis, P00OE5_A663ImpLiqDetCUIL,
            P00OE5_A661ImpLiqDetPer, P00OE5_A88ImpLiqSec, P00OE5_A90ImpLiqDetSec
            }
            , new Object[] {
            P00OE6_A3CliCod, P00OE6_A1EmpCod, P00OE6_A714ImpLiqDetConSisYDes, P00OE6_A709ImpLiqDetError, P00OE6_A670ImpLiqDetSigno, P00OE6_A716ImpLiqDetImpNum, P00OE6_A715ImpLiqDetCantNum, P00OE6_A666ImpLiqDetConCod, P00OE6_A712ImpLiqDetLegSis, P00OE6_A663ImpLiqDetCUIL,
            P00OE6_A661ImpLiqDetPer, P00OE6_A88ImpLiqSec, P00OE6_A90ImpLiqDetSec
            }
            , new Object[] {
            P00OE7_A3CliCod, P00OE7_A1EmpCod, P00OE7_A670ImpLiqDetSigno, P00OE7_A709ImpLiqDetError, P00OE7_A716ImpLiqDetImpNum, P00OE7_A715ImpLiqDetCantNum, P00OE7_A714ImpLiqDetConSisYDes, P00OE7_A666ImpLiqDetConCod, P00OE7_A712ImpLiqDetLegSis, P00OE7_A663ImpLiqDetCUIL,
            P00OE7_A661ImpLiqDetPer, P00OE7_A88ImpLiqSec, P00OE7_A90ImpLiqDetSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV71EmpCod ;
   private short AV12TFiconoUpdateOperator ;
   private short AV89Importlsd2ds_2_empcod ;
   private short AV91Importlsd2ds_4_tficonoupdateoperator ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short A90ImpLiqDetSec ;
   private short Gx_err ;
   private int AV86GXV1 ;
   private int AV70CliCod ;
   private int AV88Importlsd2ds_1_clicod ;
   private int AV93Importlsd2ds_6_tfimpliqdetper_sels_size ;
   private int AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size ;
   private int AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size ;
   private int AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size ;
   private int AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ;
   private int AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size ;
   private int A3CliCod ;
   private long AV64count ;
   private java.math.BigDecimal AV75TFImpLiqDetCantNum ;
   private java.math.BigDecimal AV76TFImpLiqDetCantNum_To ;
   private java.math.BigDecimal AV77TFImpLiqDetImpNum ;
   private java.math.BigDecimal AV78TFImpLiqDetImpNum_To ;
   private java.math.BigDecimal AV102Importlsd2ds_15_tfimpliqdetcantnum ;
   private java.math.BigDecimal AV103Importlsd2ds_16_tfimpliqdetcantnum_to ;
   private java.math.BigDecimal AV104Importlsd2ds_17_tfimpliqdetimpnum ;
   private java.math.BigDecimal AV105Importlsd2ds_18_tfimpliqdetimpnum_to ;
   private java.math.BigDecimal A715ImpLiqDetCantNum ;
   private java.math.BigDecimal A716ImpLiqDetImpNum ;
   private String AV17TFImpLiqDetPer ;
   private String AV20TFImpLiqDetCUIL ;
   private String AV26TFImpLiqDetConCod ;
   private String AV35TFImpLiqDetSigno ;
   private String A661ImpLiqDetPer ;
   private String AV90Importlsd2ds_3_tficonoupdate ;
   private String AV11TFiconoUpdate ;
   private String AV92Importlsd2ds_5_tfimpliqdetper ;
   private String AV94Importlsd2ds_7_tfimpliqdetcuil ;
   private String AV98Importlsd2ds_11_tfimpliqdetconcod ;
   private String AV106Importlsd2ds_19_tfimpliqdetsigno ;
   private String scmdbuf ;
   private String lV92Importlsd2ds_5_tfimpliqdetper ;
   private String lV94Importlsd2ds_7_tfimpliqdetcuil ;
   private String lV98Importlsd2ds_11_tfimpliqdetconcod ;
   private String lV106Importlsd2ds_19_tfimpliqdetsigno ;
   private String A663ImpLiqDetCUIL ;
   private String A666ImpLiqDetConCod ;
   private String A670ImpLiqDetSigno ;
   private boolean returnInSub ;
   private boolean brkOE2 ;
   private boolean brkOE4 ;
   private boolean brkOE6 ;
   private boolean brkOE8 ;
   private boolean brkOE10 ;
   private boolean brkOE12 ;
   private String AV58OptionsJson ;
   private String AV61OptionsDescJson ;
   private String AV63OptionIndexesJson ;
   private String AV16TFImpLiqDetPer_SelsJson ;
   private String AV19TFImpLiqDetCUIL_SelsJson ;
   private String AV22TFImpLiqDetLegSis_SelsJson ;
   private String AV25TFImpLiqDetConCod_SelsJson ;
   private String AV79TFImpLiqDetConSisYDes_SelsJson ;
   private String AV34TFImpLiqDetSigno_SelsJson ;
   private String AV54DDOName ;
   private String AV52SearchTxt ;
   private String AV53SearchTxtTo ;
   private String AV23TFImpLiqDetLegSis ;
   private String AV80TFImpLiqDetConSisYDes ;
   private String AV96Importlsd2ds_9_tfimpliqdetlegsis ;
   private String AV100Importlsd2ds_13_tfimpliqdetconsisydes ;
   private String lV96Importlsd2ds_9_tfimpliqdetlegsis ;
   private String lV100Importlsd2ds_13_tfimpliqdetconsisydes ;
   private String A712ImpLiqDetLegSis ;
   private String A714ImpLiqDetConSisYDes ;
   private String A709ImpLiqDetError ;
   private String AV56Option ;
   private com.genexus.webpanels.WebSession AV65Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00OE2_A3CliCod ;
   private short[] P00OE2_A1EmpCod ;
   private String[] P00OE2_A661ImpLiqDetPer ;
   private String[] P00OE2_A709ImpLiqDetError ;
   private String[] P00OE2_A670ImpLiqDetSigno ;
   private java.math.BigDecimal[] P00OE2_A716ImpLiqDetImpNum ;
   private java.math.BigDecimal[] P00OE2_A715ImpLiqDetCantNum ;
   private String[] P00OE2_A714ImpLiqDetConSisYDes ;
   private String[] P00OE2_A666ImpLiqDetConCod ;
   private String[] P00OE2_A712ImpLiqDetLegSis ;
   private String[] P00OE2_A663ImpLiqDetCUIL ;
   private short[] P00OE2_A88ImpLiqSec ;
   private short[] P00OE2_A90ImpLiqDetSec ;
   private int[] P00OE3_A3CliCod ;
   private short[] P00OE3_A1EmpCod ;
   private String[] P00OE3_A663ImpLiqDetCUIL ;
   private String[] P00OE3_A709ImpLiqDetError ;
   private String[] P00OE3_A670ImpLiqDetSigno ;
   private java.math.BigDecimal[] P00OE3_A716ImpLiqDetImpNum ;
   private java.math.BigDecimal[] P00OE3_A715ImpLiqDetCantNum ;
   private String[] P00OE3_A714ImpLiqDetConSisYDes ;
   private String[] P00OE3_A666ImpLiqDetConCod ;
   private String[] P00OE3_A712ImpLiqDetLegSis ;
   private String[] P00OE3_A661ImpLiqDetPer ;
   private short[] P00OE3_A88ImpLiqSec ;
   private short[] P00OE3_A90ImpLiqDetSec ;
   private int[] P00OE4_A3CliCod ;
   private short[] P00OE4_A1EmpCod ;
   private String[] P00OE4_A712ImpLiqDetLegSis ;
   private String[] P00OE4_A709ImpLiqDetError ;
   private String[] P00OE4_A670ImpLiqDetSigno ;
   private java.math.BigDecimal[] P00OE4_A716ImpLiqDetImpNum ;
   private java.math.BigDecimal[] P00OE4_A715ImpLiqDetCantNum ;
   private String[] P00OE4_A714ImpLiqDetConSisYDes ;
   private String[] P00OE4_A666ImpLiqDetConCod ;
   private String[] P00OE4_A663ImpLiqDetCUIL ;
   private String[] P00OE4_A661ImpLiqDetPer ;
   private short[] P00OE4_A88ImpLiqSec ;
   private short[] P00OE4_A90ImpLiqDetSec ;
   private int[] P00OE5_A3CliCod ;
   private short[] P00OE5_A1EmpCod ;
   private String[] P00OE5_A666ImpLiqDetConCod ;
   private String[] P00OE5_A709ImpLiqDetError ;
   private String[] P00OE5_A670ImpLiqDetSigno ;
   private java.math.BigDecimal[] P00OE5_A716ImpLiqDetImpNum ;
   private java.math.BigDecimal[] P00OE5_A715ImpLiqDetCantNum ;
   private String[] P00OE5_A714ImpLiqDetConSisYDes ;
   private String[] P00OE5_A712ImpLiqDetLegSis ;
   private String[] P00OE5_A663ImpLiqDetCUIL ;
   private String[] P00OE5_A661ImpLiqDetPer ;
   private short[] P00OE5_A88ImpLiqSec ;
   private short[] P00OE5_A90ImpLiqDetSec ;
   private int[] P00OE6_A3CliCod ;
   private short[] P00OE6_A1EmpCod ;
   private String[] P00OE6_A714ImpLiqDetConSisYDes ;
   private String[] P00OE6_A709ImpLiqDetError ;
   private String[] P00OE6_A670ImpLiqDetSigno ;
   private java.math.BigDecimal[] P00OE6_A716ImpLiqDetImpNum ;
   private java.math.BigDecimal[] P00OE6_A715ImpLiqDetCantNum ;
   private String[] P00OE6_A666ImpLiqDetConCod ;
   private String[] P00OE6_A712ImpLiqDetLegSis ;
   private String[] P00OE6_A663ImpLiqDetCUIL ;
   private String[] P00OE6_A661ImpLiqDetPer ;
   private short[] P00OE6_A88ImpLiqSec ;
   private short[] P00OE6_A90ImpLiqDetSec ;
   private int[] P00OE7_A3CliCod ;
   private short[] P00OE7_A1EmpCod ;
   private String[] P00OE7_A670ImpLiqDetSigno ;
   private String[] P00OE7_A709ImpLiqDetError ;
   private java.math.BigDecimal[] P00OE7_A716ImpLiqDetImpNum ;
   private java.math.BigDecimal[] P00OE7_A715ImpLiqDetCantNum ;
   private String[] P00OE7_A714ImpLiqDetConSisYDes ;
   private String[] P00OE7_A666ImpLiqDetConCod ;
   private String[] P00OE7_A712ImpLiqDetLegSis ;
   private String[] P00OE7_A663ImpLiqDetCUIL ;
   private String[] P00OE7_A661ImpLiqDetPer ;
   private short[] P00OE7_A88ImpLiqSec ;
   private short[] P00OE7_A90ImpLiqDetSec ;
   private GXSimpleCollection<String> AV18TFImpLiqDetPer_Sels ;
   private GXSimpleCollection<String> AV21TFImpLiqDetCUIL_Sels ;
   private GXSimpleCollection<String> AV27TFImpLiqDetConCod_Sels ;
   private GXSimpleCollection<String> AV36TFImpLiqDetSigno_Sels ;
   private GXSimpleCollection<String> AV93Importlsd2ds_6_tfimpliqdetper_sels ;
   private GXSimpleCollection<String> AV95Importlsd2ds_8_tfimpliqdetcuil_sels ;
   private GXSimpleCollection<String> AV99Importlsd2ds_12_tfimpliqdetconcod_sels ;
   private GXSimpleCollection<String> AV107Importlsd2ds_20_tfimpliqdetsigno_sels ;
   private GXSimpleCollection<String> AV57Options ;
   private GXSimpleCollection<String> AV60OptionsDesc ;
   private GXSimpleCollection<String> AV62OptionIndexes ;
   private GXSimpleCollection<String> AV24TFImpLiqDetLegSis_Sels ;
   private GXSimpleCollection<String> AV81TFImpLiqDetConSisYDes_Sels ;
   private GXSimpleCollection<String> AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ;
   private GXSimpleCollection<String> AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV67GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV68GridStateFilterValue ;
}

final  class importlsd2getfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00OE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV91Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV93Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV92Importlsd2ds_5_tfimpliqdetper ,
                                          int AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          int A3CliCod ,
                                          int AV88Importlsd2ds_1_clicod ,
                                          short A1EmpCod ,
                                          short AV89Importlsd2ds_2_empcod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[12];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqDetPer, ImpLiqDetError, ImpLiqDetSigno, ImpLiqDetImpNum, ImpLiqDetCantNum, ImpLiqDetConSisYDes, ImpLiqDetConCod, ImpLiqDetLegSis, ImpLiqDetCUIL," ;
      scmdbuf += " ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int2[2] = (byte)(1) ;
      }
      if ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int2[3] = (byte)(1) ;
      }
      if ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int2[4] = (byte)(1) ;
      }
      if ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int2[5] = (byte)(1) ;
      }
      if ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int2[6] = (byte)(1) ;
      }
      if ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int2[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int2[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int2[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int2[10] = (byte)(1) ;
      }
      if ( ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int2[11] = (byte)(1) ;
      }
      if ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqDetPer" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P00OE3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV91Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV93Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV92Importlsd2ds_5_tfimpliqdetper ,
                                          int AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          int A3CliCod ,
                                          int AV88Importlsd2ds_1_clicod ,
                                          short A1EmpCod ,
                                          short AV89Importlsd2ds_2_empcod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[12];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqDetCUIL, ImpLiqDetError, ImpLiqDetSigno, ImpLiqDetImpNum, ImpLiqDetCantNum, ImpLiqDetConSisYDes, ImpLiqDetConCod, ImpLiqDetLegSis, ImpLiqDetPer," ;
      scmdbuf += " ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int5[2] = (byte)(1) ;
      }
      if ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int5[3] = (byte)(1) ;
      }
      if ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int5[4] = (byte)(1) ;
      }
      if ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int5[5] = (byte)(1) ;
      }
      if ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int5[6] = (byte)(1) ;
      }
      if ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int5[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int5[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int5[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int5[10] = (byte)(1) ;
      }
      if ( ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int5[11] = (byte)(1) ;
      }
      if ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqDetCUIL" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   protected Object[] conditional_P00OE4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV91Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV93Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV92Importlsd2ds_5_tfimpliqdetper ,
                                          int AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          int A3CliCod ,
                                          int AV88Importlsd2ds_1_clicod ,
                                          short A1EmpCod ,
                                          short AV89Importlsd2ds_2_empcod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[12];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqDetLegSis, ImpLiqDetError, ImpLiqDetSigno, ImpLiqDetImpNum, ImpLiqDetCantNum, ImpLiqDetConSisYDes, ImpLiqDetConCod, ImpLiqDetCUIL, ImpLiqDetPer," ;
      scmdbuf += " ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqDetLegSis" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P00OE5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV91Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV93Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV92Importlsd2ds_5_tfimpliqdetper ,
                                          int AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          int A3CliCod ,
                                          int AV88Importlsd2ds_1_clicod ,
                                          short A1EmpCod ,
                                          short AV89Importlsd2ds_2_empcod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[12];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqDetConCod, ImpLiqDetError, ImpLiqDetSigno, ImpLiqDetImpNum, ImpLiqDetCantNum, ImpLiqDetConSisYDes, ImpLiqDetLegSis, ImpLiqDetCUIL, ImpLiqDetPer," ;
      scmdbuf += " ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqDetConCod" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P00OE6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV91Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV93Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV92Importlsd2ds_5_tfimpliqdetper ,
                                          int AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          int A3CliCod ,
                                          int AV88Importlsd2ds_1_clicod ,
                                          short A1EmpCod ,
                                          short AV89Importlsd2ds_2_empcod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[12];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqDetConSisYDes, ImpLiqDetError, ImpLiqDetSigno, ImpLiqDetImpNum, ImpLiqDetCantNum, ImpLiqDetConCod, ImpLiqDetLegSis, ImpLiqDetCUIL, ImpLiqDetPer," ;
      scmdbuf += " ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      if ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqDetConSisYDes" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P00OE7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A661ImpLiqDetPer ,
                                          GXSimpleCollection<String> AV93Importlsd2ds_6_tfimpliqdetper_sels ,
                                          String A663ImpLiqDetCUIL ,
                                          GXSimpleCollection<String> AV95Importlsd2ds_8_tfimpliqdetcuil_sels ,
                                          String A712ImpLiqDetLegSis ,
                                          GXSimpleCollection<String> AV97Importlsd2ds_10_tfimpliqdetlegsis_sels ,
                                          String A666ImpLiqDetConCod ,
                                          GXSimpleCollection<String> AV99Importlsd2ds_12_tfimpliqdetconcod_sels ,
                                          String A714ImpLiqDetConSisYDes ,
                                          GXSimpleCollection<String> AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels ,
                                          String A670ImpLiqDetSigno ,
                                          GXSimpleCollection<String> AV107Importlsd2ds_20_tfimpliqdetsigno_sels ,
                                          short AV91Importlsd2ds_4_tficonoupdateoperator ,
                                          int AV93Importlsd2ds_6_tfimpliqdetper_sels_size ,
                                          String AV92Importlsd2ds_5_tfimpliqdetper ,
                                          int AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size ,
                                          String AV94Importlsd2ds_7_tfimpliqdetcuil ,
                                          int AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size ,
                                          String AV96Importlsd2ds_9_tfimpliqdetlegsis ,
                                          int AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size ,
                                          String AV98Importlsd2ds_11_tfimpliqdetconcod ,
                                          int AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size ,
                                          String AV100Importlsd2ds_13_tfimpliqdetconsisydes ,
                                          java.math.BigDecimal AV102Importlsd2ds_15_tfimpliqdetcantnum ,
                                          java.math.BigDecimal AV103Importlsd2ds_16_tfimpliqdetcantnum_to ,
                                          java.math.BigDecimal AV104Importlsd2ds_17_tfimpliqdetimpnum ,
                                          java.math.BigDecimal AV105Importlsd2ds_18_tfimpliqdetimpnum_to ,
                                          int AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size ,
                                          String AV106Importlsd2ds_19_tfimpliqdetsigno ,
                                          String A709ImpLiqDetError ,
                                          java.math.BigDecimal A715ImpLiqDetCantNum ,
                                          java.math.BigDecimal A716ImpLiqDetImpNum ,
                                          int A3CliCod ,
                                          int AV88Importlsd2ds_1_clicod ,
                                          short A1EmpCod ,
                                          short AV89Importlsd2ds_2_empcod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[12];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, ImpLiqDetSigno, ImpLiqDetError, ImpLiqDetImpNum, ImpLiqDetCantNum, ImpLiqDetConSisYDes, ImpLiqDetConCod, ImpLiqDetLegSis, ImpLiqDetCUIL, ImpLiqDetPer," ;
      scmdbuf += " ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 1 )
      {
         addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( AV91Importlsd2ds_4_tficonoupdateoperator == 2 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      if ( ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV92Importlsd2ds_5_tfimpliqdetper)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetPer) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV93Importlsd2ds_6_tfimpliqdetper_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV93Importlsd2ds_6_tfimpliqdetper_sels, "ImpLiqDetPer IN (", ")")+")");
      }
      if ( ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV94Importlsd2ds_7_tfimpliqdetcuil)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetCUIL) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV95Importlsd2ds_8_tfimpliqdetcuil_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV95Importlsd2ds_8_tfimpliqdetcuil_sels, "ImpLiqDetCUIL IN (", ")")+")");
      }
      if ( ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV96Importlsd2ds_9_tfimpliqdetlegsis)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetLegSis) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV97Importlsd2ds_10_tfimpliqdetlegsis_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV97Importlsd2ds_10_tfimpliqdetlegsis_sels, "ImpLiqDetLegSis IN (", ")")+")");
      }
      if ( ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV98Importlsd2ds_11_tfimpliqdetconcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConCod) like LOWER(?))");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV99Importlsd2ds_12_tfimpliqdetconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Importlsd2ds_12_tfimpliqdetconcod_sels, "ImpLiqDetConCod IN (", ")")+")");
      }
      if ( ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Importlsd2ds_13_tfimpliqdetconsisydes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetConSisYDes) like LOWER(?))");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Importlsd2ds_14_tfimpliqdetconsisydes_sels, "ImpLiqDetConSisYDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102Importlsd2ds_15_tfimpliqdetcantnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum >= ?)");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV103Importlsd2ds_16_tfimpliqdetcantnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetCantNum <= ?)");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV104Importlsd2ds_17_tfimpliqdetimpnum)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum >= ?)");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV105Importlsd2ds_18_tfimpliqdetimpnum_to)==0) )
      {
         addWhere(sWhereString, "(ImpLiqDetImpNum <= ?)");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV106Importlsd2ds_19_tfimpliqdetsigno)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ImpLiqDetSigno) like LOWER(?))");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( AV107Importlsd2ds_20_tfimpliqdetsigno_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV107Importlsd2ds_20_tfimpliqdetsigno_sels, "ImpLiqDetSigno IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ImpLiqDetSigno" ;
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
                  return conditional_P00OE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() );
            case 1 :
                  return conditional_P00OE3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() );
            case 2 :
                  return conditional_P00OE4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() );
            case 3 :
                  return conditional_P00OE5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() );
            case 4 :
                  return conditional_P00OE6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() );
            case 5 :
                  return conditional_P00OE7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00OE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00OE3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00OE4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00OE5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00OE6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00OE7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 11);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 6);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               ((String[]) buf[9])[0] = rslt.getString(10, 11);
               ((String[]) buf[10])[0] = rslt.getString(11, 6);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 11);
               ((String[]) buf[10])[0] = rslt.getString(11, 6);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 11);
               ((String[]) buf[10])[0] = rslt.getString(11, 6);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 11);
               ((String[]) buf[10])[0] = rslt.getString(11, 6);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
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
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 6);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 11);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               return;
      }
   }

}

