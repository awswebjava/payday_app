package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_base_calculowwgetfilterdata extends GXProcedure
{
   public convenio_base_calculowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_base_calculowwgetfilterdata.class ), "" );
   }

   public convenio_base_calculowwgetfilterdata( int remoteHandle ,
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
      convenio_base_calculowwgetfilterdata.this.aP5 = new String[] {""};
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
      convenio_base_calculowwgetfilterdata.this.AV58DDOName = aP0;
      convenio_base_calculowwgetfilterdata.this.AV59SearchTxt = aP1;
      convenio_base_calculowwgetfilterdata.this.AV60SearchTxtTo = aP2;
      convenio_base_calculowwgetfilterdata.this.aP3 = aP3;
      convenio_base_calculowwgetfilterdata.this.aP4 = aP4;
      convenio_base_calculowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV66EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      convenio_base_calculowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV66EmpCod = GXt_int1 ;
      GXt_int3 = AV67CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_base_calculowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV67CliCod = GXt_int3 ;
      AV48Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo", GXv_boolean6) ;
      convenio_base_calculowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV58DDOName), "DDO_CONVEBASERELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEBASERELREFOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV61OptionsJson = AV48Options.toJSonString(false) ;
      AV62OptionsDescJson = AV50OptionsDesc.toJSonString(false) ;
      AV63OptionIndexesJson = AV51OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV53Session.getValue("Convenio_base_calculoWWGridState"), "") == 0 )
      {
         AV55GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Convenio_base_calculoWWGridState"), null, null);
      }
      else
      {
         AV55GridState.fromxml(AV53Session.getValue("Convenio_base_calculoWWGridState"), null, null);
      }
      AV76GXV1 = 1 ;
      while ( AV76GXV1 <= AV55GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV56GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV55GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV76GXV1));
         if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPLUS") == 0 )
         {
            AV23TFConveBasePlus = CommonUtil.decimalVal( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV24TFConveBasePlus_To = CommonUtil.decimalVal( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDLIM") == 0 )
         {
            AV25TFConveLicDLim = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFConveLicDLim_To = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDSEMAN") == 0 )
         {
            AV27TFConveLicDSeman = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV28TFConveLicDSeman_To = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDMES_SEL") == 0 )
         {
            AV29TFConveLicDMes_SelsJson = AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV30TFConveLicDMes_Sels.fromJSonString(AV29TFConveLicDMes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDSEMES") == 0 )
         {
            AV31TFConveLicDSemes = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV32TFConveLicDSemes_To = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICDANUAL") == 0 )
         {
            AV33TFConveLicDAnual = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV34TFConveLicDAnual_To = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICADJU_SEL") == 0 )
         {
            AV35TFConveLicAdju_Sel = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICADJUOBL_SEL") == 0 )
         {
            AV36TFConveLicAdjuObl_Sel = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICNECAUT_SEL") == 0 )
         {
            AV37TFConveLicNecAut_Sel = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICINGMOT_SEL") == 0 )
         {
            AV38TFConveLicIngMot_Sel = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVELICMOTOBL_SEL") == 0 )
         {
            AV39TFConveLicMotObl_Sel = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMCNT1") == 0 )
         {
            AV40TFConveBasePromCnt1 = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV41TFConveBasePromCnt1_To = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMCNT2") == 0 )
         {
            AV42TFConveBasePromCnt2 = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV43TFConveBasePromCnt2_To = (short)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASEPROMTCNT_SEL") == 0 )
         {
            AV44TFConveBasePromTCnt_SelsJson = AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFConveBasePromTCnt_Sels.fromJSonString(AV44TFConveBasePromTCnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASERELREF") == 0 )
         {
            AV72TFConveBaseRelRef = AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEBASERELREF_SEL") == 0 )
         {
            AV71TFConveBaseRelRef_SelsJson = AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV73TFConveBaseRelRef_Sels.fromJSonString(AV71TFConveBaseRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV70MenuOpcCod = AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CONVEBASECLASELEG") == 0 )
         {
            AV64ConveBaseClaseLeg = (byte)(GXutil.lval( AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CONVEBASETIPO") == 0 )
         {
            AV65ConveBaseTipo = AV56GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV76GXV1 = (int)(AV76GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEBASERELREFOPTIONS' Routine */
      returnInSub = false ;
      AV72TFConveBaseRelRef = AV59SearchTxt ;
      AV73TFConveBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV78Convenio_base_calculowwds_1_convebaseclaseleg = AV64ConveBaseClaseLeg ;
      AV79Convenio_base_calculowwds_2_convebasetipo = AV65ConveBaseTipo ;
      AV80Convenio_base_calculowwds_3_tfconvebaseplus = AV23TFConveBasePlus ;
      AV81Convenio_base_calculowwds_4_tfconvebaseplus_to = AV24TFConveBasePlus_To ;
      AV82Convenio_base_calculowwds_5_tfconvelicdlim = AV25TFConveLicDLim ;
      AV83Convenio_base_calculowwds_6_tfconvelicdlim_to = AV26TFConveLicDLim_To ;
      AV84Convenio_base_calculowwds_7_tfconvelicdseman = AV27TFConveLicDSeman ;
      AV85Convenio_base_calculowwds_8_tfconvelicdseman_to = AV28TFConveLicDSeman_To ;
      AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels = AV30TFConveLicDMes_Sels ;
      AV87Convenio_base_calculowwds_10_tfconvelicdsemes = AV31TFConveLicDSemes ;
      AV88Convenio_base_calculowwds_11_tfconvelicdsemes_to = AV32TFConveLicDSemes_To ;
      AV89Convenio_base_calculowwds_12_tfconvelicdanual = AV33TFConveLicDAnual ;
      AV90Convenio_base_calculowwds_13_tfconvelicdanual_to = AV34TFConveLicDAnual_To ;
      AV91Convenio_base_calculowwds_14_tfconvelicadju_sel = AV35TFConveLicAdju_Sel ;
      AV92Convenio_base_calculowwds_15_tfconvelicadjuobl_sel = AV36TFConveLicAdjuObl_Sel ;
      AV93Convenio_base_calculowwds_16_tfconvelicnecaut_sel = AV37TFConveLicNecAut_Sel ;
      AV94Convenio_base_calculowwds_17_tfconvelicingmot_sel = AV38TFConveLicIngMot_Sel ;
      AV95Convenio_base_calculowwds_18_tfconvelicmotobl_sel = AV39TFConveLicMotObl_Sel ;
      AV96Convenio_base_calculowwds_19_tfconvebasepromcnt1 = AV40TFConveBasePromCnt1 ;
      AV97Convenio_base_calculowwds_20_tfconvebasepromcnt1_to = AV41TFConveBasePromCnt1_To ;
      AV98Convenio_base_calculowwds_21_tfconvebasepromcnt2 = AV42TFConveBasePromCnt2 ;
      AV99Convenio_base_calculowwds_22_tfconvebasepromcnt2_to = AV43TFConveBasePromCnt2_To ;
      AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = AV45TFConveBasePromTCnt_Sels ;
      AV101Convenio_base_calculowwds_24_tfconvebaserelref = AV72TFConveBaseRelRef ;
      AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels = AV73TFConveBaseRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Byte.valueOf(A1612ConveLicDMes) ,
                                           AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                           A1467ConveBasePromTCnt ,
                                           AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                           A2061ConveBaseRelRef ,
                                           AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                           AV80Convenio_base_calculowwds_3_tfconvebaseplus ,
                                           AV81Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                           Short.valueOf(AV82Convenio_base_calculowwds_5_tfconvelicdlim) ,
                                           Short.valueOf(AV83Convenio_base_calculowwds_6_tfconvelicdlim_to) ,
                                           Byte.valueOf(AV84Convenio_base_calculowwds_7_tfconvelicdseman) ,
                                           Byte.valueOf(AV85Convenio_base_calculowwds_8_tfconvelicdseman_to) ,
                                           Integer.valueOf(AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels.size()) ,
                                           Short.valueOf(AV87Convenio_base_calculowwds_10_tfconvelicdsemes) ,
                                           Short.valueOf(AV88Convenio_base_calculowwds_11_tfconvelicdsemes_to) ,
                                           Short.valueOf(AV89Convenio_base_calculowwds_12_tfconvelicdanual) ,
                                           Short.valueOf(AV90Convenio_base_calculowwds_13_tfconvelicdanual_to) ,
                                           Byte.valueOf(AV91Convenio_base_calculowwds_14_tfconvelicadju_sel) ,
                                           Byte.valueOf(AV92Convenio_base_calculowwds_15_tfconvelicadjuobl_sel) ,
                                           Byte.valueOf(AV93Convenio_base_calculowwds_16_tfconvelicnecaut_sel) ,
                                           Byte.valueOf(AV94Convenio_base_calculowwds_17_tfconvelicingmot_sel) ,
                                           Byte.valueOf(AV95Convenio_base_calculowwds_18_tfconvelicmotobl_sel) ,
                                           Short.valueOf(AV96Convenio_base_calculowwds_19_tfconvebasepromcnt1) ,
                                           Short.valueOf(AV97Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) ,
                                           Short.valueOf(AV98Convenio_base_calculowwds_21_tfconvebasepromcnt2) ,
                                           Short.valueOf(AV99Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) ,
                                           Integer.valueOf(AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels.size()) ,
                                           Integer.valueOf(AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels.size()) ,
                                           AV101Convenio_base_calculowwds_24_tfconvebaserelref ,
                                           AV69CliConvenio ,
                                           A1458ConveBasePlus ,
                                           Short.valueOf(A1610ConveLicDLim) ,
                                           Byte.valueOf(A1611ConveLicDSeman) ,
                                           Short.valueOf(A1613ConveLicDSemes) ,
                                           Short.valueOf(A1614ConveLicDAnual) ,
                                           Boolean.valueOf(A1615ConveLicAdju) ,
                                           Boolean.valueOf(A1616ConveLicAdjuObl) ,
                                           Boolean.valueOf(A1617ConveLicNecAut) ,
                                           Boolean.valueOf(A1618ConveLicIngMot) ,
                                           Boolean.valueOf(A1619ConveLicMotObl) ,
                                           Short.valueOf(A1465ConveBasePromCnt1) ,
                                           Short.valueOf(A1466ConveBasePromCnt2) ,
                                           A1565CliConvenio ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV67CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV68PaiCod) ,
                                           Byte.valueOf(AV78Convenio_base_calculowwds_1_convebaseclaseleg) ,
                                           AV79Convenio_base_calculowwds_2_convebasetipo ,
                                           Byte.valueOf(A1454ConveBaseClaseLeg) ,
                                           A1455ConveBaseTipo } ,
                                           new int[]{
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BYTE,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING
                                           }
      });
      lV101Convenio_base_calculowwds_24_tfconvebaserelref = GXutil.concat( GXutil.rtrim( AV101Convenio_base_calculowwds_24_tfconvebaserelref), "%", "") ;
      /* Using cursor P01H82 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV78Convenio_base_calculowwds_1_convebaseclaseleg), AV79Convenio_base_calculowwds_2_convebasetipo, Integer.valueOf(AV67CliCod), Short.valueOf(AV68PaiCod), AV80Convenio_base_calculowwds_3_tfconvebaseplus, AV81Convenio_base_calculowwds_4_tfconvebaseplus_to, Short.valueOf(AV82Convenio_base_calculowwds_5_tfconvelicdlim), Short.valueOf(AV83Convenio_base_calculowwds_6_tfconvelicdlim_to), Byte.valueOf(AV84Convenio_base_calculowwds_7_tfconvelicdseman), Byte.valueOf(AV85Convenio_base_calculowwds_8_tfconvelicdseman_to), Short.valueOf(AV87Convenio_base_calculowwds_10_tfconvelicdsemes), Short.valueOf(AV88Convenio_base_calculowwds_11_tfconvelicdsemes_to), Short.valueOf(AV89Convenio_base_calculowwds_12_tfconvelicdanual), Short.valueOf(AV90Convenio_base_calculowwds_13_tfconvelicdanual_to), Short.valueOf(AV96Convenio_base_calculowwds_19_tfconvebasepromcnt1), Short.valueOf(AV97Convenio_base_calculowwds_20_tfconvebasepromcnt1_to), Short.valueOf(AV98Convenio_base_calculowwds_21_tfconvebasepromcnt2), Short.valueOf(AV99Convenio_base_calculowwds_22_tfconvebasepromcnt2_to), lV101Convenio_base_calculowwds_24_tfconvebaserelref, AV69CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1H82 = false ;
         A1454ConveBaseClaseLeg = P01H82_A1454ConveBaseClaseLeg[0] ;
         A1455ConveBaseTipo = P01H82_A1455ConveBaseTipo[0] ;
         A3CliCod = P01H82_A3CliCod[0] ;
         A1564CliPaiConve = P01H82_A1564CliPaiConve[0] ;
         A2061ConveBaseRelRef = P01H82_A2061ConveBaseRelRef[0] ;
         A1565CliConvenio = P01H82_A1565CliConvenio[0] ;
         A1467ConveBasePromTCnt = P01H82_A1467ConveBasePromTCnt[0] ;
         A1466ConveBasePromCnt2 = P01H82_A1466ConveBasePromCnt2[0] ;
         A1465ConveBasePromCnt1 = P01H82_A1465ConveBasePromCnt1[0] ;
         A1619ConveLicMotObl = P01H82_A1619ConveLicMotObl[0] ;
         A1618ConveLicIngMot = P01H82_A1618ConveLicIngMot[0] ;
         A1617ConveLicNecAut = P01H82_A1617ConveLicNecAut[0] ;
         A1616ConveLicAdjuObl = P01H82_A1616ConveLicAdjuObl[0] ;
         A1615ConveLicAdju = P01H82_A1615ConveLicAdju[0] ;
         A1614ConveLicDAnual = P01H82_A1614ConveLicDAnual[0] ;
         A1613ConveLicDSemes = P01H82_A1613ConveLicDSemes[0] ;
         A1612ConveLicDMes = P01H82_A1612ConveLicDMes[0] ;
         A1611ConveLicDSeman = P01H82_A1611ConveLicDSeman[0] ;
         A1610ConveLicDLim = P01H82_A1610ConveLicDLim[0] ;
         A1458ConveBasePlus = P01H82_A1458ConveBasePlus[0] ;
         A1456ConveBaseCod1 = P01H82_A1456ConveBaseCod1[0] ;
         A1457ConveBaseCod2 = P01H82_A1457ConveBaseCod2[0] ;
         AV52count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01H82_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(P01H82_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( GXutil.strcmp(P01H82_A2061ConveBaseRelRef[0], A2061ConveBaseRelRef) == 0 ) )
         {
            brk1H82 = false ;
            A3CliCod = P01H82_A3CliCod[0] ;
            A1564CliPaiConve = P01H82_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01H82_A1565CliConvenio[0] ;
            A1456ConveBaseCod1 = P01H82_A1456ConveBaseCod1[0] ;
            A1457ConveBaseCod2 = P01H82_A1457ConveBaseCod2[0] ;
            AV52count = (long)(AV52count+1) ;
            brk1H82 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2061ConveBaseRelRef)==0) )
         {
            AV47Option = A2061ConveBaseRelRef ;
            AV48Options.add(AV47Option, 0);
            AV51OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV52count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV48Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1H82 )
         {
            brk1H82 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenio_base_calculowwgetfilterdata.this.AV61OptionsJson;
      this.aP4[0] = convenio_base_calculowwgetfilterdata.this.AV62OptionsDescJson;
      this.aP5[0] = convenio_base_calculowwgetfilterdata.this.AV63OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV61OptionsJson = "" ;
      AV62OptionsDescJson = "" ;
      AV63OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV48Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV53Session = httpContext.getWebSession();
      AV55GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV56GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV23TFConveBasePlus = DecimalUtil.ZERO ;
      AV24TFConveBasePlus_To = DecimalUtil.ZERO ;
      AV29TFConveLicDMes_SelsJson = "" ;
      AV30TFConveLicDMes_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV44TFConveBasePromTCnt_SelsJson = "" ;
      AV45TFConveBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72TFConveBaseRelRef = "" ;
      AV71TFConveBaseRelRef_SelsJson = "" ;
      AV73TFConveBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70MenuOpcCod = "" ;
      AV65ConveBaseTipo = "" ;
      A2061ConveBaseRelRef = "" ;
      AV79Convenio_base_calculowwds_2_convebasetipo = "" ;
      AV80Convenio_base_calculowwds_3_tfconvebaseplus = DecimalUtil.ZERO ;
      AV81Convenio_base_calculowwds_4_tfconvebaseplus_to = DecimalUtil.ZERO ;
      AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV101Convenio_base_calculowwds_24_tfconvebaserelref = "" ;
      AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV101Convenio_base_calculowwds_24_tfconvebaserelref = "" ;
      A1467ConveBasePromTCnt = "" ;
      AV69CliConvenio = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      A1565CliConvenio = "" ;
      A1455ConveBaseTipo = "" ;
      P01H82_A1454ConveBaseClaseLeg = new byte[1] ;
      P01H82_A1455ConveBaseTipo = new String[] {""} ;
      P01H82_A3CliCod = new int[1] ;
      P01H82_A1564CliPaiConve = new short[1] ;
      P01H82_A2061ConveBaseRelRef = new String[] {""} ;
      P01H82_A1565CliConvenio = new String[] {""} ;
      P01H82_A1467ConveBasePromTCnt = new String[] {""} ;
      P01H82_A1466ConveBasePromCnt2 = new short[1] ;
      P01H82_A1465ConveBasePromCnt1 = new short[1] ;
      P01H82_A1619ConveLicMotObl = new boolean[] {false} ;
      P01H82_A1618ConveLicIngMot = new boolean[] {false} ;
      P01H82_A1617ConveLicNecAut = new boolean[] {false} ;
      P01H82_A1616ConveLicAdjuObl = new boolean[] {false} ;
      P01H82_A1615ConveLicAdju = new boolean[] {false} ;
      P01H82_A1614ConveLicDAnual = new short[1] ;
      P01H82_A1613ConveLicDSemes = new short[1] ;
      P01H82_A1612ConveLicDMes = new byte[1] ;
      P01H82_A1611ConveLicDSeman = new byte[1] ;
      P01H82_A1610ConveLicDLim = new short[1] ;
      P01H82_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01H82_A1456ConveBaseCod1 = new String[] {""} ;
      P01H82_A1457ConveBaseCod2 = new String[] {""} ;
      A1456ConveBaseCod1 = "" ;
      A1457ConveBaseCod2 = "" ;
      AV47Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_base_calculowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01H82_A1454ConveBaseClaseLeg, P01H82_A1455ConveBaseTipo, P01H82_A3CliCod, P01H82_A1564CliPaiConve, P01H82_A2061ConveBaseRelRef, P01H82_A1565CliConvenio, P01H82_A1467ConveBasePromTCnt, P01H82_A1466ConveBasePromCnt2, P01H82_A1465ConveBasePromCnt1, P01H82_A1619ConveLicMotObl,
            P01H82_A1618ConveLicIngMot, P01H82_A1617ConveLicNecAut, P01H82_A1616ConveLicAdjuObl, P01H82_A1615ConveLicAdju, P01H82_A1614ConveLicDAnual, P01H82_A1613ConveLicDSemes, P01H82_A1612ConveLicDMes, P01H82_A1611ConveLicDSeman, P01H82_A1610ConveLicDLim, P01H82_A1458ConveBasePlus,
            P01H82_A1456ConveBaseCod1, P01H82_A1457ConveBaseCod2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV27TFConveLicDSeman ;
   private byte AV28TFConveLicDSeman_To ;
   private byte AV35TFConveLicAdju_Sel ;
   private byte AV36TFConveLicAdjuObl_Sel ;
   private byte AV37TFConveLicNecAut_Sel ;
   private byte AV38TFConveLicIngMot_Sel ;
   private byte AV39TFConveLicMotObl_Sel ;
   private byte AV64ConveBaseClaseLeg ;
   private byte AV78Convenio_base_calculowwds_1_convebaseclaseleg ;
   private byte AV84Convenio_base_calculowwds_7_tfconvelicdseman ;
   private byte AV85Convenio_base_calculowwds_8_tfconvelicdseman_to ;
   private byte AV91Convenio_base_calculowwds_14_tfconvelicadju_sel ;
   private byte AV92Convenio_base_calculowwds_15_tfconvelicadjuobl_sel ;
   private byte AV93Convenio_base_calculowwds_16_tfconvelicnecaut_sel ;
   private byte AV94Convenio_base_calculowwds_17_tfconvelicingmot_sel ;
   private byte AV95Convenio_base_calculowwds_18_tfconvelicmotobl_sel ;
   private byte A1612ConveLicDMes ;
   private byte A1611ConveLicDSeman ;
   private byte A1454ConveBaseClaseLeg ;
   private short AV66EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV25TFConveLicDLim ;
   private short AV26TFConveLicDLim_To ;
   private short AV31TFConveLicDSemes ;
   private short AV32TFConveLicDSemes_To ;
   private short AV33TFConveLicDAnual ;
   private short AV34TFConveLicDAnual_To ;
   private short AV40TFConveBasePromCnt1 ;
   private short AV41TFConveBasePromCnt1_To ;
   private short AV42TFConveBasePromCnt2 ;
   private short AV43TFConveBasePromCnt2_To ;
   private short AV82Convenio_base_calculowwds_5_tfconvelicdlim ;
   private short AV83Convenio_base_calculowwds_6_tfconvelicdlim_to ;
   private short AV87Convenio_base_calculowwds_10_tfconvelicdsemes ;
   private short AV88Convenio_base_calculowwds_11_tfconvelicdsemes_to ;
   private short AV89Convenio_base_calculowwds_12_tfconvelicdanual ;
   private short AV90Convenio_base_calculowwds_13_tfconvelicdanual_to ;
   private short AV96Convenio_base_calculowwds_19_tfconvebasepromcnt1 ;
   private short AV97Convenio_base_calculowwds_20_tfconvebasepromcnt1_to ;
   private short AV98Convenio_base_calculowwds_21_tfconvebasepromcnt2 ;
   private short AV99Convenio_base_calculowwds_22_tfconvebasepromcnt2_to ;
   private short A1610ConveLicDLim ;
   private short A1613ConveLicDSemes ;
   private short A1614ConveLicDAnual ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short A1564CliPaiConve ;
   private short AV68PaiCod ;
   private short Gx_err ;
   private int AV67CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV76GXV1 ;
   private int AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels_size ;
   private int AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size ;
   private int AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels_size ;
   private int A3CliCod ;
   private long AV52count ;
   private java.math.BigDecimal AV23TFConveBasePlus ;
   private java.math.BigDecimal AV24TFConveBasePlus_To ;
   private java.math.BigDecimal AV80Convenio_base_calculowwds_3_tfconvebaseplus ;
   private java.math.BigDecimal AV81Convenio_base_calculowwds_4_tfconvebaseplus_to ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private String AV65ConveBaseTipo ;
   private String AV79Convenio_base_calculowwds_2_convebasetipo ;
   private String scmdbuf ;
   private String A1467ConveBasePromTCnt ;
   private String AV69CliConvenio ;
   private String A1565CliConvenio ;
   private String A1455ConveBaseTipo ;
   private String A1456ConveBaseCod1 ;
   private String A1457ConveBaseCod2 ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1615ConveLicAdju ;
   private boolean A1616ConveLicAdjuObl ;
   private boolean A1617ConveLicNecAut ;
   private boolean A1618ConveLicIngMot ;
   private boolean A1619ConveLicMotObl ;
   private boolean brk1H82 ;
   private String AV61OptionsJson ;
   private String AV62OptionsDescJson ;
   private String AV63OptionIndexesJson ;
   private String AV29TFConveLicDMes_SelsJson ;
   private String AV44TFConveBasePromTCnt_SelsJson ;
   private String AV71TFConveBaseRelRef_SelsJson ;
   private String AV58DDOName ;
   private String AV59SearchTxt ;
   private String AV60SearchTxtTo ;
   private String AV72TFConveBaseRelRef ;
   private String AV70MenuOpcCod ;
   private String A2061ConveBaseRelRef ;
   private String AV101Convenio_base_calculowwds_24_tfconvebaserelref ;
   private String lV101Convenio_base_calculowwds_24_tfconvebaserelref ;
   private String AV47Option ;
   private GXSimpleCollection<Byte> AV30TFConveLicDMes_Sels ;
   private GXSimpleCollection<Byte> AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels ;
   private com.genexus.webpanels.WebSession AV53Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01H82_A1454ConveBaseClaseLeg ;
   private String[] P01H82_A1455ConveBaseTipo ;
   private int[] P01H82_A3CliCod ;
   private short[] P01H82_A1564CliPaiConve ;
   private String[] P01H82_A2061ConveBaseRelRef ;
   private String[] P01H82_A1565CliConvenio ;
   private String[] P01H82_A1467ConveBasePromTCnt ;
   private short[] P01H82_A1466ConveBasePromCnt2 ;
   private short[] P01H82_A1465ConveBasePromCnt1 ;
   private boolean[] P01H82_A1619ConveLicMotObl ;
   private boolean[] P01H82_A1618ConveLicIngMot ;
   private boolean[] P01H82_A1617ConveLicNecAut ;
   private boolean[] P01H82_A1616ConveLicAdjuObl ;
   private boolean[] P01H82_A1615ConveLicAdju ;
   private short[] P01H82_A1614ConveLicDAnual ;
   private short[] P01H82_A1613ConveLicDSemes ;
   private byte[] P01H82_A1612ConveLicDMes ;
   private byte[] P01H82_A1611ConveLicDSeman ;
   private short[] P01H82_A1610ConveLicDLim ;
   private java.math.BigDecimal[] P01H82_A1458ConveBasePlus ;
   private String[] P01H82_A1456ConveBaseCod1 ;
   private String[] P01H82_A1457ConveBaseCod2 ;
   private GXSimpleCollection<String> AV45TFConveBasePromTCnt_Sels ;
   private GXSimpleCollection<String> AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ;
   private GXSimpleCollection<String> AV48Options ;
   private GXSimpleCollection<String> AV50OptionsDesc ;
   private GXSimpleCollection<String> AV51OptionIndexes ;
   private GXSimpleCollection<String> AV73TFConveBaseRelRef_Sels ;
   private GXSimpleCollection<String> AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV55GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV56GridStateFilterValue ;
}

final  class convenio_base_calculowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01H82( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte A1612ConveLicDMes ,
                                          GXSimpleCollection<Byte> AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels ,
                                          String A1467ConveBasePromTCnt ,
                                          GXSimpleCollection<String> AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels ,
                                          String A2061ConveBaseRelRef ,
                                          GXSimpleCollection<String> AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels ,
                                          java.math.BigDecimal AV80Convenio_base_calculowwds_3_tfconvebaseplus ,
                                          java.math.BigDecimal AV81Convenio_base_calculowwds_4_tfconvebaseplus_to ,
                                          short AV82Convenio_base_calculowwds_5_tfconvelicdlim ,
                                          short AV83Convenio_base_calculowwds_6_tfconvelicdlim_to ,
                                          byte AV84Convenio_base_calculowwds_7_tfconvelicdseman ,
                                          byte AV85Convenio_base_calculowwds_8_tfconvelicdseman_to ,
                                          int AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels_size ,
                                          short AV87Convenio_base_calculowwds_10_tfconvelicdsemes ,
                                          short AV88Convenio_base_calculowwds_11_tfconvelicdsemes_to ,
                                          short AV89Convenio_base_calculowwds_12_tfconvelicdanual ,
                                          short AV90Convenio_base_calculowwds_13_tfconvelicdanual_to ,
                                          byte AV91Convenio_base_calculowwds_14_tfconvelicadju_sel ,
                                          byte AV92Convenio_base_calculowwds_15_tfconvelicadjuobl_sel ,
                                          byte AV93Convenio_base_calculowwds_16_tfconvelicnecaut_sel ,
                                          byte AV94Convenio_base_calculowwds_17_tfconvelicingmot_sel ,
                                          byte AV95Convenio_base_calculowwds_18_tfconvelicmotobl_sel ,
                                          short AV96Convenio_base_calculowwds_19_tfconvebasepromcnt1 ,
                                          short AV97Convenio_base_calculowwds_20_tfconvebasepromcnt1_to ,
                                          short AV98Convenio_base_calculowwds_21_tfconvebasepromcnt2 ,
                                          short AV99Convenio_base_calculowwds_22_tfconvebasepromcnt2_to ,
                                          int AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size ,
                                          int AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels_size ,
                                          String AV101Convenio_base_calculowwds_24_tfconvebaserelref ,
                                          String AV69CliConvenio ,
                                          java.math.BigDecimal A1458ConveBasePlus ,
                                          short A1610ConveLicDLim ,
                                          byte A1611ConveLicDSeman ,
                                          short A1613ConveLicDSemes ,
                                          short A1614ConveLicDAnual ,
                                          boolean A1615ConveLicAdju ,
                                          boolean A1616ConveLicAdjuObl ,
                                          boolean A1617ConveLicNecAut ,
                                          boolean A1618ConveLicIngMot ,
                                          boolean A1619ConveLicMotObl ,
                                          short A1465ConveBasePromCnt1 ,
                                          short A1466ConveBasePromCnt2 ,
                                          String A1565CliConvenio ,
                                          int A3CliCod ,
                                          int AV67CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV68PaiCod ,
                                          byte AV78Convenio_base_calculowwds_1_convebaseclaseleg ,
                                          String AV79Convenio_base_calculowwds_2_convebasetipo ,
                                          byte A1454ConveBaseClaseLeg ,
                                          String A1455ConveBaseTipo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[20];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT ConveBaseClaseLeg, ConveBaseTipo, CliCod, CliPaiConve, ConveBaseRelRef, CliConvenio, ConveBasePromTCnt, ConveBasePromCnt2, ConveBasePromCnt1, ConveLicMotObl," ;
      scmdbuf += " ConveLicIngMot, ConveLicNecAut, ConveLicAdjuObl, ConveLicAdju, ConveLicDAnual, ConveLicDSemes, ConveLicDMes, ConveLicDSeman, ConveLicDLim, ConveBasePlus, ConveBaseCod1," ;
      scmdbuf += " ConveBaseCod2 FROM Convenio_base_calculo" ;
      addWhere(sWhereString, "(ConveBaseClaseLeg = ? and ConveBaseTipo = ( ?))");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Convenio_base_calculowwds_3_tfconvebaseplus)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV81Convenio_base_calculowwds_4_tfconvebaseplus_to)==0) )
      {
         addWhere(sWhereString, "(ConveBasePlus <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV82Convenio_base_calculowwds_5_tfconvelicdlim) )
      {
         addWhere(sWhereString, "(ConveLicDLim >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (0==AV83Convenio_base_calculowwds_6_tfconvelicdlim_to) )
      {
         addWhere(sWhereString, "(ConveLicDLim <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (0==AV84Convenio_base_calculowwds_7_tfconvelicdseman) )
      {
         addWhere(sWhereString, "(ConveLicDSeman >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV85Convenio_base_calculowwds_8_tfconvelicdseman_to) )
      {
         addWhere(sWhereString, "(ConveLicDSeman <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV86Convenio_base_calculowwds_9_tfconvelicdmes_sels, "ConveLicDMes IN (", ")")+")");
      }
      if ( ! (0==AV87Convenio_base_calculowwds_10_tfconvelicdsemes) )
      {
         addWhere(sWhereString, "(ConveLicDSemes >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV88Convenio_base_calculowwds_11_tfconvelicdsemes_to) )
      {
         addWhere(sWhereString, "(ConveLicDSemes <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV89Convenio_base_calculowwds_12_tfconvelicdanual) )
      {
         addWhere(sWhereString, "(ConveLicDAnual >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV90Convenio_base_calculowwds_13_tfconvelicdanual_to) )
      {
         addWhere(sWhereString, "(ConveLicDAnual <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( AV91Convenio_base_calculowwds_14_tfconvelicadju_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdju = TRUE)");
      }
      if ( AV91Convenio_base_calculowwds_14_tfconvelicadju_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdju = FALSE)");
      }
      if ( AV92Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = TRUE)");
      }
      if ( AV92Convenio_base_calculowwds_15_tfconvelicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicAdjuObl = FALSE)");
      }
      if ( AV93Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = TRUE)");
      }
      if ( AV93Convenio_base_calculowwds_16_tfconvelicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicNecAut = FALSE)");
      }
      if ( AV94Convenio_base_calculowwds_17_tfconvelicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = TRUE)");
      }
      if ( AV94Convenio_base_calculowwds_17_tfconvelicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicIngMot = FALSE)");
      }
      if ( AV95Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = TRUE)");
      }
      if ( AV95Convenio_base_calculowwds_18_tfconvelicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(ConveLicMotObl = FALSE)");
      }
      if ( ! (0==AV96Convenio_base_calculowwds_19_tfconvebasepromcnt1) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (0==AV97Convenio_base_calculowwds_20_tfconvebasepromcnt1_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( ! (0==AV98Convenio_base_calculowwds_21_tfconvebasepromcnt2) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (0==AV99Convenio_base_calculowwds_22_tfconvebasepromcnt2_to) )
      {
         addWhere(sWhereString, "(ConveBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV100Convenio_base_calculowwds_23_tfconvebasepromtcnt_sels, "ConveBasePromTCnt IN (", ")")+")");
      }
      if ( ( AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV101Convenio_base_calculowwds_24_tfconvebaserelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveBaseRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV102Convenio_base_calculowwds_25_tfconvebaserelref_sels, "ConveBaseRelRef IN (", ")")+")");
      }
      if ( ! (GXutil.strcmp("", AV69CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveBaseClaseLeg, ConveBaseTipo, ConveBaseRelRef" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01H82(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).byteValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , (String)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).shortValue() , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Boolean) dynConstraints[38]).booleanValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , (String)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).shortValue() , ((Number) dynConstraints[47]).byteValue() , (String)dynConstraints[48] , ((Number) dynConstraints[49]).byteValue() , (String)dynConstraints[50] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01H82", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((byte[]) buf[16])[0] = rslt.getByte(17);
               ((byte[]) buf[17])[0] = rslt.getByte(18);
               ((short[]) buf[18])[0] = rslt.getShort(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,4);
               ((String[]) buf[20])[0] = rslt.getString(21, 20);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
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
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[27]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[28]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[29]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[30]).shortValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[31]).shortValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[32]).shortValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[33]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 40);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[39], 20);
               }
               return;
      }
   }

}

