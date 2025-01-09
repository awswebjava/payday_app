package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paisbase_calculowwgetfilterdata extends GXProcedure
{
   public paisbase_calculowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paisbase_calculowwgetfilterdata.class ), "" );
   }

   public paisbase_calculowwgetfilterdata( int remoteHandle ,
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
      paisbase_calculowwgetfilterdata.this.aP5 = new String[] {""};
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
      paisbase_calculowwgetfilterdata.this.AV49DDOName = aP0;
      paisbase_calculowwgetfilterdata.this.AV50SearchTxt = aP1;
      paisbase_calculowwgetfilterdata.this.AV51SearchTxtTo = aP2;
      paisbase_calculowwgetfilterdata.this.aP3 = aP3;
      paisbase_calculowwgetfilterdata.this.aP4 = aP4;
      paisbase_calculowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV58EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      paisbase_calculowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV58EmpCod = GXt_int1 ;
      GXt_int3 = AV59CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      paisbase_calculowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV59CliCod = GXt_int3 ;
      AV39Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV41OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisbase_calculo", GXv_boolean6) ;
      paisbase_calculowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_PAIBASERELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADPAIBASERELREFOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV52OptionsJson = AV39Options.toJSonString(false) ;
      AV53OptionsDescJson = AV41OptionsDesc.toJSonString(false) ;
      AV54OptionIndexesJson = AV42OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV44Session.getValue("Paisbase_calculoWWGridState"), "") == 0 )
      {
         AV46GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Paisbase_calculoWWGridState"), null, null);
      }
      else
      {
         AV46GridState.fromxml(AV44Session.getValue("Paisbase_calculoWWGridState"), null, null);
      }
      AV63GXV1 = 1 ;
      while ( AV63GXV1 <= AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV47GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV63GXV1));
         if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPLUS") == 0 )
         {
            AV11TFPaiBasePlus = CommonUtil.decimalVal( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV12TFPaiBasePlus_To = CommonUtil.decimalVal( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDLIM") == 0 )
         {
            AV13TFPaiLicDLim = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFPaiLicDLim_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDSEMAN") == 0 )
         {
            AV15TFPaiLicDSeman = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV16TFPaiLicDSeman_To = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDMES") == 0 )
         {
            AV17TFPaiLicDMes = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV18TFPaiLicDMes_To = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDSEMES") == 0 )
         {
            AV19TFPaiLicDSemes = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV20TFPaiLicDSemes_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICDANUAL") == 0 )
         {
            AV21TFPaiLicDAnual = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFPaiLicDAnual_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICADJU_SEL") == 0 )
         {
            AV23TFPaiLicAdju_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICADJUOBL_SEL") == 0 )
         {
            AV24TFPaiLicAdjuObl_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICNECAUT_SEL") == 0 )
         {
            AV25TFPaiLicNecAut_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICINGMOT_SEL") == 0 )
         {
            AV26TFPaiLicIngMot_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAILICMOTOBL_SEL") == 0 )
         {
            AV27TFPaiLicMotObl_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPROMCNT1") == 0 )
         {
            AV28TFPaiBasePromCnt1 = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV29TFPaiBasePromCnt1_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPROMCNT2") == 0 )
         {
            AV30TFPaiBasePromCnt2 = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV31TFPaiBasePromCnt2_To = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASEPROMTCNT_SEL") == 0 )
         {
            AV32TFPaiBasePromTCnt_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV33TFPaiBasePromTCnt_Sels.fromJSonString(AV32TFPaiBasePromTCnt_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASERELREF") == 0 )
         {
            AV35TFPaiBaseRelRef = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPAIBASERELREF_SEL") == 0 )
         {
            AV34TFPaiBaseRelRef_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFPaiBaseRelRef_Sels.fromJSonString(AV34TFPaiBaseRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV55MenuOpcCod = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PAIBASECLASELEG") == 0 )
         {
            AV56PaiBaseClaseLeg = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PAIBASETIPO") == 0 )
         {
            AV57PaiBaseTipo = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV63GXV1 = (int)(AV63GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPAIBASERELREFOPTIONS' Routine */
      returnInSub = false ;
      AV35TFPaiBaseRelRef = AV50SearchTxt ;
      AV36TFPaiBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV65Paisbase_calculowwds_1_paibaseclaseleg = AV56PaiBaseClaseLeg ;
      AV66Paisbase_calculowwds_2_paibasetipo = AV57PaiBaseTipo ;
      AV67Paisbase_calculowwds_3_tfpaibaseplus = AV11TFPaiBasePlus ;
      AV68Paisbase_calculowwds_4_tfpaibaseplus_to = AV12TFPaiBasePlus_To ;
      AV69Paisbase_calculowwds_5_tfpailicdlim = AV13TFPaiLicDLim ;
      AV70Paisbase_calculowwds_6_tfpailicdlim_to = AV14TFPaiLicDLim_To ;
      AV71Paisbase_calculowwds_7_tfpailicdseman = AV15TFPaiLicDSeman ;
      AV72Paisbase_calculowwds_8_tfpailicdseman_to = AV16TFPaiLicDSeman_To ;
      AV73Paisbase_calculowwds_9_tfpailicdmes = AV17TFPaiLicDMes ;
      AV74Paisbase_calculowwds_10_tfpailicdmes_to = AV18TFPaiLicDMes_To ;
      AV75Paisbase_calculowwds_11_tfpailicdsemes = AV19TFPaiLicDSemes ;
      AV76Paisbase_calculowwds_12_tfpailicdsemes_to = AV20TFPaiLicDSemes_To ;
      AV77Paisbase_calculowwds_13_tfpailicdanual = AV21TFPaiLicDAnual ;
      AV78Paisbase_calculowwds_14_tfpailicdanual_to = AV22TFPaiLicDAnual_To ;
      AV79Paisbase_calculowwds_15_tfpailicadju_sel = AV23TFPaiLicAdju_Sel ;
      AV80Paisbase_calculowwds_16_tfpailicadjuobl_sel = AV24TFPaiLicAdjuObl_Sel ;
      AV81Paisbase_calculowwds_17_tfpailicnecaut_sel = AV25TFPaiLicNecAut_Sel ;
      AV82Paisbase_calculowwds_18_tfpailicingmot_sel = AV26TFPaiLicIngMot_Sel ;
      AV83Paisbase_calculowwds_19_tfpailicmotobl_sel = AV27TFPaiLicMotObl_Sel ;
      AV84Paisbase_calculowwds_20_tfpaibasepromcnt1 = AV28TFPaiBasePromCnt1 ;
      AV85Paisbase_calculowwds_21_tfpaibasepromcnt1_to = AV29TFPaiBasePromCnt1_To ;
      AV86Paisbase_calculowwds_22_tfpaibasepromcnt2 = AV30TFPaiBasePromCnt2 ;
      AV87Paisbase_calculowwds_23_tfpaibasepromcnt2_to = AV31TFPaiBasePromCnt2_To ;
      AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels = AV33TFPaiBasePromTCnt_Sels ;
      AV89Paisbase_calculowwds_25_tfpaibaserelref = AV35TFPaiBaseRelRef ;
      AV90Paisbase_calculowwds_26_tfpaibaserelref_sels = AV36TFPaiBaseRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1453PaiBasePromTCnt ,
                                           AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels ,
                                           A2054PaiBaseRelRef ,
                                           AV90Paisbase_calculowwds_26_tfpaibaserelref_sels ,
                                           AV67Paisbase_calculowwds_3_tfpaibaseplus ,
                                           AV68Paisbase_calculowwds_4_tfpaibaseplus_to ,
                                           Short.valueOf(AV69Paisbase_calculowwds_5_tfpailicdlim) ,
                                           Short.valueOf(AV70Paisbase_calculowwds_6_tfpailicdlim_to) ,
                                           Byte.valueOf(AV71Paisbase_calculowwds_7_tfpailicdseman) ,
                                           Byte.valueOf(AV72Paisbase_calculowwds_8_tfpailicdseman_to) ,
                                           Byte.valueOf(AV73Paisbase_calculowwds_9_tfpailicdmes) ,
                                           Byte.valueOf(AV74Paisbase_calculowwds_10_tfpailicdmes_to) ,
                                           Short.valueOf(AV75Paisbase_calculowwds_11_tfpailicdsemes) ,
                                           Short.valueOf(AV76Paisbase_calculowwds_12_tfpailicdsemes_to) ,
                                           Short.valueOf(AV77Paisbase_calculowwds_13_tfpailicdanual) ,
                                           Short.valueOf(AV78Paisbase_calculowwds_14_tfpailicdanual_to) ,
                                           Byte.valueOf(AV79Paisbase_calculowwds_15_tfpailicadju_sel) ,
                                           Byte.valueOf(AV80Paisbase_calculowwds_16_tfpailicadjuobl_sel) ,
                                           Byte.valueOf(AV81Paisbase_calculowwds_17_tfpailicnecaut_sel) ,
                                           Byte.valueOf(AV82Paisbase_calculowwds_18_tfpailicingmot_sel) ,
                                           Byte.valueOf(AV83Paisbase_calculowwds_19_tfpailicmotobl_sel) ,
                                           Short.valueOf(AV84Paisbase_calculowwds_20_tfpaibasepromcnt1) ,
                                           Short.valueOf(AV85Paisbase_calculowwds_21_tfpaibasepromcnt1_to) ,
                                           Short.valueOf(AV86Paisbase_calculowwds_22_tfpaibasepromcnt2) ,
                                           Short.valueOf(AV87Paisbase_calculowwds_23_tfpaibasepromcnt2_to) ,
                                           Integer.valueOf(AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels.size()) ,
                                           Integer.valueOf(AV90Paisbase_calculowwds_26_tfpaibaserelref_sels.size()) ,
                                           AV89Paisbase_calculowwds_25_tfpaibaserelref ,
                                           Short.valueOf(AV60PaiCod) ,
                                           A1444PaiBasePlus ,
                                           Short.valueOf(A1629PaiLicDLim) ,
                                           Byte.valueOf(A1630PaiLicDSeman) ,
                                           Byte.valueOf(A1631PaiLicDMes) ,
                                           Short.valueOf(A1632PaiLicDSemes) ,
                                           Short.valueOf(A1633PaiLicDAnual) ,
                                           Boolean.valueOf(A1634PaiLicAdju) ,
                                           Boolean.valueOf(A1635PaiLicAdjuObl) ,
                                           Boolean.valueOf(A1636PaiLicNecAut) ,
                                           Boolean.valueOf(A1637PaiLicIngMot) ,
                                           Boolean.valueOf(A1638PaiLicMotObl) ,
                                           Short.valueOf(A1451PaiBasePromCnt1) ,
                                           Short.valueOf(A1452PaiBasePromCnt2) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Byte.valueOf(AV65Paisbase_calculowwds_1_paibaseclaseleg) ,
                                           AV66Paisbase_calculowwds_2_paibasetipo ,
                                           Byte.valueOf(A1440PaiBaseClaseLeg) ,
                                           A1441PaiBaseTipo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING
                                           }
      });
      lV89Paisbase_calculowwds_25_tfpaibaserelref = GXutil.concat( GXutil.rtrim( AV89Paisbase_calculowwds_25_tfpaibaserelref), "%", "") ;
      /* Using cursor P01X82 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV65Paisbase_calculowwds_1_paibaseclaseleg), AV66Paisbase_calculowwds_2_paibasetipo, AV67Paisbase_calculowwds_3_tfpaibaseplus, AV68Paisbase_calculowwds_4_tfpaibaseplus_to, Short.valueOf(AV69Paisbase_calculowwds_5_tfpailicdlim), Short.valueOf(AV70Paisbase_calculowwds_6_tfpailicdlim_to), Byte.valueOf(AV71Paisbase_calculowwds_7_tfpailicdseman), Byte.valueOf(AV72Paisbase_calculowwds_8_tfpailicdseman_to), Byte.valueOf(AV73Paisbase_calculowwds_9_tfpailicdmes), Byte.valueOf(AV74Paisbase_calculowwds_10_tfpailicdmes_to), Short.valueOf(AV75Paisbase_calculowwds_11_tfpailicdsemes), Short.valueOf(AV76Paisbase_calculowwds_12_tfpailicdsemes_to), Short.valueOf(AV77Paisbase_calculowwds_13_tfpailicdanual), Short.valueOf(AV78Paisbase_calculowwds_14_tfpailicdanual_to), Short.valueOf(AV84Paisbase_calculowwds_20_tfpaibasepromcnt1), Short.valueOf(AV85Paisbase_calculowwds_21_tfpaibasepromcnt1_to), Short.valueOf(AV86Paisbase_calculowwds_22_tfpaibasepromcnt2), Short.valueOf(AV87Paisbase_calculowwds_23_tfpaibasepromcnt2_to), lV89Paisbase_calculowwds_25_tfpaibaserelref, Short.valueOf(AV60PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1X82 = false ;
         A1440PaiBaseClaseLeg = P01X82_A1440PaiBaseClaseLeg[0] ;
         A1441PaiBaseTipo = P01X82_A1441PaiBaseTipo[0] ;
         A2054PaiBaseRelRef = P01X82_A2054PaiBaseRelRef[0] ;
         A46PaiCod = P01X82_A46PaiCod[0] ;
         A1453PaiBasePromTCnt = P01X82_A1453PaiBasePromTCnt[0] ;
         A1452PaiBasePromCnt2 = P01X82_A1452PaiBasePromCnt2[0] ;
         A1451PaiBasePromCnt1 = P01X82_A1451PaiBasePromCnt1[0] ;
         A1638PaiLicMotObl = P01X82_A1638PaiLicMotObl[0] ;
         A1637PaiLicIngMot = P01X82_A1637PaiLicIngMot[0] ;
         A1636PaiLicNecAut = P01X82_A1636PaiLicNecAut[0] ;
         A1635PaiLicAdjuObl = P01X82_A1635PaiLicAdjuObl[0] ;
         A1634PaiLicAdju = P01X82_A1634PaiLicAdju[0] ;
         A1633PaiLicDAnual = P01X82_A1633PaiLicDAnual[0] ;
         A1632PaiLicDSemes = P01X82_A1632PaiLicDSemes[0] ;
         A1631PaiLicDMes = P01X82_A1631PaiLicDMes[0] ;
         A1630PaiLicDSeman = P01X82_A1630PaiLicDSeman[0] ;
         A1629PaiLicDLim = P01X82_A1629PaiLicDLim[0] ;
         A1444PaiBasePlus = P01X82_A1444PaiBasePlus[0] ;
         A1442PaiBaseCod1 = P01X82_A1442PaiBaseCod1[0] ;
         A1443PaiBaseCod2 = P01X82_A1443PaiBaseCod2[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01X82_A1440PaiBaseClaseLeg[0] == A1440PaiBaseClaseLeg ) && ( GXutil.strcmp(P01X82_A1441PaiBaseTipo[0], A1441PaiBaseTipo) == 0 ) && ( GXutil.strcmp(P01X82_A2054PaiBaseRelRef[0], A2054PaiBaseRelRef) == 0 ) )
         {
            brk1X82 = false ;
            A46PaiCod = P01X82_A46PaiCod[0] ;
            A1442PaiBaseCod1 = P01X82_A1442PaiBaseCod1[0] ;
            A1443PaiBaseCod2 = P01X82_A1443PaiBaseCod2[0] ;
            AV43count = (long)(AV43count+1) ;
            brk1X82 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2054PaiBaseRelRef)==0) )
         {
            AV38Option = A2054PaiBaseRelRef ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1X82 )
         {
            brk1X82 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = paisbase_calculowwgetfilterdata.this.AV52OptionsJson;
      this.aP4[0] = paisbase_calculowwgetfilterdata.this.AV53OptionsDescJson;
      this.aP5[0] = paisbase_calculowwgetfilterdata.this.AV54OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV52OptionsJson = "" ;
      AV53OptionsDescJson = "" ;
      AV54OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV39Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV44Session = httpContext.getWebSession();
      AV46GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV47GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11TFPaiBasePlus = DecimalUtil.ZERO ;
      AV12TFPaiBasePlus_To = DecimalUtil.ZERO ;
      AV32TFPaiBasePromTCnt_SelsJson = "" ;
      AV33TFPaiBasePromTCnt_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35TFPaiBaseRelRef = "" ;
      AV34TFPaiBaseRelRef_SelsJson = "" ;
      AV36TFPaiBaseRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55MenuOpcCod = "" ;
      AV57PaiBaseTipo = "" ;
      A2054PaiBaseRelRef = "" ;
      AV66Paisbase_calculowwds_2_paibasetipo = "" ;
      AV67Paisbase_calculowwds_3_tfpaibaseplus = DecimalUtil.ZERO ;
      AV68Paisbase_calculowwds_4_tfpaibaseplus_to = DecimalUtil.ZERO ;
      AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV89Paisbase_calculowwds_25_tfpaibaserelref = "" ;
      AV90Paisbase_calculowwds_26_tfpaibaserelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV89Paisbase_calculowwds_25_tfpaibaserelref = "" ;
      A1453PaiBasePromTCnt = "" ;
      A1444PaiBasePlus = DecimalUtil.ZERO ;
      A1441PaiBaseTipo = "" ;
      P01X82_A1440PaiBaseClaseLeg = new byte[1] ;
      P01X82_A1441PaiBaseTipo = new String[] {""} ;
      P01X82_A2054PaiBaseRelRef = new String[] {""} ;
      P01X82_A46PaiCod = new short[1] ;
      P01X82_A1453PaiBasePromTCnt = new String[] {""} ;
      P01X82_A1452PaiBasePromCnt2 = new short[1] ;
      P01X82_A1451PaiBasePromCnt1 = new short[1] ;
      P01X82_A1638PaiLicMotObl = new boolean[] {false} ;
      P01X82_A1637PaiLicIngMot = new boolean[] {false} ;
      P01X82_A1636PaiLicNecAut = new boolean[] {false} ;
      P01X82_A1635PaiLicAdjuObl = new boolean[] {false} ;
      P01X82_A1634PaiLicAdju = new boolean[] {false} ;
      P01X82_A1633PaiLicDAnual = new short[1] ;
      P01X82_A1632PaiLicDSemes = new short[1] ;
      P01X82_A1631PaiLicDMes = new byte[1] ;
      P01X82_A1630PaiLicDSeman = new byte[1] ;
      P01X82_A1629PaiLicDLim = new short[1] ;
      P01X82_A1444PaiBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01X82_A1442PaiBaseCod1 = new String[] {""} ;
      P01X82_A1443PaiBaseCod2 = new String[] {""} ;
      A1442PaiBaseCod1 = "" ;
      A1443PaiBaseCod2 = "" ;
      AV38Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paisbase_calculowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01X82_A1440PaiBaseClaseLeg, P01X82_A1441PaiBaseTipo, P01X82_A2054PaiBaseRelRef, P01X82_A46PaiCod, P01X82_A1453PaiBasePromTCnt, P01X82_A1452PaiBasePromCnt2, P01X82_A1451PaiBasePromCnt1, P01X82_A1638PaiLicMotObl, P01X82_A1637PaiLicIngMot, P01X82_A1636PaiLicNecAut,
            P01X82_A1635PaiLicAdjuObl, P01X82_A1634PaiLicAdju, P01X82_A1633PaiLicDAnual, P01X82_A1632PaiLicDSemes, P01X82_A1631PaiLicDMes, P01X82_A1630PaiLicDSeman, P01X82_A1629PaiLicDLim, P01X82_A1444PaiBasePlus, P01X82_A1442PaiBaseCod1, P01X82_A1443PaiBaseCod2
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15TFPaiLicDSeman ;
   private byte AV16TFPaiLicDSeman_To ;
   private byte AV17TFPaiLicDMes ;
   private byte AV18TFPaiLicDMes_To ;
   private byte AV23TFPaiLicAdju_Sel ;
   private byte AV24TFPaiLicAdjuObl_Sel ;
   private byte AV25TFPaiLicNecAut_Sel ;
   private byte AV26TFPaiLicIngMot_Sel ;
   private byte AV27TFPaiLicMotObl_Sel ;
   private byte AV56PaiBaseClaseLeg ;
   private byte AV65Paisbase_calculowwds_1_paibaseclaseleg ;
   private byte AV71Paisbase_calculowwds_7_tfpailicdseman ;
   private byte AV72Paisbase_calculowwds_8_tfpailicdseman_to ;
   private byte AV73Paisbase_calculowwds_9_tfpailicdmes ;
   private byte AV74Paisbase_calculowwds_10_tfpailicdmes_to ;
   private byte AV79Paisbase_calculowwds_15_tfpailicadju_sel ;
   private byte AV80Paisbase_calculowwds_16_tfpailicadjuobl_sel ;
   private byte AV81Paisbase_calculowwds_17_tfpailicnecaut_sel ;
   private byte AV82Paisbase_calculowwds_18_tfpailicingmot_sel ;
   private byte AV83Paisbase_calculowwds_19_tfpailicmotobl_sel ;
   private byte A1630PaiLicDSeman ;
   private byte A1631PaiLicDMes ;
   private byte A1440PaiBaseClaseLeg ;
   private short AV58EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV13TFPaiLicDLim ;
   private short AV14TFPaiLicDLim_To ;
   private short AV19TFPaiLicDSemes ;
   private short AV20TFPaiLicDSemes_To ;
   private short AV21TFPaiLicDAnual ;
   private short AV22TFPaiLicDAnual_To ;
   private short AV28TFPaiBasePromCnt1 ;
   private short AV29TFPaiBasePromCnt1_To ;
   private short AV30TFPaiBasePromCnt2 ;
   private short AV31TFPaiBasePromCnt2_To ;
   private short AV69Paisbase_calculowwds_5_tfpailicdlim ;
   private short AV70Paisbase_calculowwds_6_tfpailicdlim_to ;
   private short AV75Paisbase_calculowwds_11_tfpailicdsemes ;
   private short AV76Paisbase_calculowwds_12_tfpailicdsemes_to ;
   private short AV77Paisbase_calculowwds_13_tfpailicdanual ;
   private short AV78Paisbase_calculowwds_14_tfpailicdanual_to ;
   private short AV84Paisbase_calculowwds_20_tfpaibasepromcnt1 ;
   private short AV85Paisbase_calculowwds_21_tfpaibasepromcnt1_to ;
   private short AV86Paisbase_calculowwds_22_tfpaibasepromcnt2 ;
   private short AV87Paisbase_calculowwds_23_tfpaibasepromcnt2_to ;
   private short AV60PaiCod ;
   private short A1629PaiLicDLim ;
   private short A1632PaiLicDSemes ;
   private short A1633PaiLicDAnual ;
   private short A1451PaiBasePromCnt1 ;
   private short A1452PaiBasePromCnt2 ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV59CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV63GXV1 ;
   private int AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels_size ;
   private int AV90Paisbase_calculowwds_26_tfpaibaserelref_sels_size ;
   private long AV43count ;
   private java.math.BigDecimal AV11TFPaiBasePlus ;
   private java.math.BigDecimal AV12TFPaiBasePlus_To ;
   private java.math.BigDecimal AV67Paisbase_calculowwds_3_tfpaibaseplus ;
   private java.math.BigDecimal AV68Paisbase_calculowwds_4_tfpaibaseplus_to ;
   private java.math.BigDecimal A1444PaiBasePlus ;
   private String AV57PaiBaseTipo ;
   private String AV66Paisbase_calculowwds_2_paibasetipo ;
   private String scmdbuf ;
   private String A1453PaiBasePromTCnt ;
   private String A1441PaiBaseTipo ;
   private String A1442PaiBaseCod1 ;
   private String A1443PaiBaseCod2 ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1634PaiLicAdju ;
   private boolean A1635PaiLicAdjuObl ;
   private boolean A1636PaiLicNecAut ;
   private boolean A1637PaiLicIngMot ;
   private boolean A1638PaiLicMotObl ;
   private boolean brk1X82 ;
   private String AV52OptionsJson ;
   private String AV53OptionsDescJson ;
   private String AV54OptionIndexesJson ;
   private String AV32TFPaiBasePromTCnt_SelsJson ;
   private String AV34TFPaiBaseRelRef_SelsJson ;
   private String AV49DDOName ;
   private String AV50SearchTxt ;
   private String AV51SearchTxtTo ;
   private String AV35TFPaiBaseRelRef ;
   private String AV55MenuOpcCod ;
   private String A2054PaiBaseRelRef ;
   private String AV89Paisbase_calculowwds_25_tfpaibaserelref ;
   private String lV89Paisbase_calculowwds_25_tfpaibaserelref ;
   private String AV38Option ;
   private com.genexus.webpanels.WebSession AV44Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01X82_A1440PaiBaseClaseLeg ;
   private String[] P01X82_A1441PaiBaseTipo ;
   private String[] P01X82_A2054PaiBaseRelRef ;
   private short[] P01X82_A46PaiCod ;
   private String[] P01X82_A1453PaiBasePromTCnt ;
   private short[] P01X82_A1452PaiBasePromCnt2 ;
   private short[] P01X82_A1451PaiBasePromCnt1 ;
   private boolean[] P01X82_A1638PaiLicMotObl ;
   private boolean[] P01X82_A1637PaiLicIngMot ;
   private boolean[] P01X82_A1636PaiLicNecAut ;
   private boolean[] P01X82_A1635PaiLicAdjuObl ;
   private boolean[] P01X82_A1634PaiLicAdju ;
   private short[] P01X82_A1633PaiLicDAnual ;
   private short[] P01X82_A1632PaiLicDSemes ;
   private byte[] P01X82_A1631PaiLicDMes ;
   private byte[] P01X82_A1630PaiLicDSeman ;
   private short[] P01X82_A1629PaiLicDLim ;
   private java.math.BigDecimal[] P01X82_A1444PaiBasePlus ;
   private String[] P01X82_A1442PaiBaseCod1 ;
   private String[] P01X82_A1443PaiBaseCod2 ;
   private GXSimpleCollection<String> AV33TFPaiBasePromTCnt_Sels ;
   private GXSimpleCollection<String> AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels ;
   private GXSimpleCollection<String> AV39Options ;
   private GXSimpleCollection<String> AV41OptionsDesc ;
   private GXSimpleCollection<String> AV42OptionIndexes ;
   private GXSimpleCollection<String> AV36TFPaiBaseRelRef_Sels ;
   private GXSimpleCollection<String> AV90Paisbase_calculowwds_26_tfpaibaserelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV46GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV47GridStateFilterValue ;
}

final  class paisbase_calculowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01X82( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1453PaiBasePromTCnt ,
                                          GXSimpleCollection<String> AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels ,
                                          String A2054PaiBaseRelRef ,
                                          GXSimpleCollection<String> AV90Paisbase_calculowwds_26_tfpaibaserelref_sels ,
                                          java.math.BigDecimal AV67Paisbase_calculowwds_3_tfpaibaseplus ,
                                          java.math.BigDecimal AV68Paisbase_calculowwds_4_tfpaibaseplus_to ,
                                          short AV69Paisbase_calculowwds_5_tfpailicdlim ,
                                          short AV70Paisbase_calculowwds_6_tfpailicdlim_to ,
                                          byte AV71Paisbase_calculowwds_7_tfpailicdseman ,
                                          byte AV72Paisbase_calculowwds_8_tfpailicdseman_to ,
                                          byte AV73Paisbase_calculowwds_9_tfpailicdmes ,
                                          byte AV74Paisbase_calculowwds_10_tfpailicdmes_to ,
                                          short AV75Paisbase_calculowwds_11_tfpailicdsemes ,
                                          short AV76Paisbase_calculowwds_12_tfpailicdsemes_to ,
                                          short AV77Paisbase_calculowwds_13_tfpailicdanual ,
                                          short AV78Paisbase_calculowwds_14_tfpailicdanual_to ,
                                          byte AV79Paisbase_calculowwds_15_tfpailicadju_sel ,
                                          byte AV80Paisbase_calculowwds_16_tfpailicadjuobl_sel ,
                                          byte AV81Paisbase_calculowwds_17_tfpailicnecaut_sel ,
                                          byte AV82Paisbase_calculowwds_18_tfpailicingmot_sel ,
                                          byte AV83Paisbase_calculowwds_19_tfpailicmotobl_sel ,
                                          short AV84Paisbase_calculowwds_20_tfpaibasepromcnt1 ,
                                          short AV85Paisbase_calculowwds_21_tfpaibasepromcnt1_to ,
                                          short AV86Paisbase_calculowwds_22_tfpaibasepromcnt2 ,
                                          short AV87Paisbase_calculowwds_23_tfpaibasepromcnt2_to ,
                                          int AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels_size ,
                                          int AV90Paisbase_calculowwds_26_tfpaibaserelref_sels_size ,
                                          String AV89Paisbase_calculowwds_25_tfpaibaserelref ,
                                          short AV60PaiCod ,
                                          java.math.BigDecimal A1444PaiBasePlus ,
                                          short A1629PaiLicDLim ,
                                          byte A1630PaiLicDSeman ,
                                          byte A1631PaiLicDMes ,
                                          short A1632PaiLicDSemes ,
                                          short A1633PaiLicDAnual ,
                                          boolean A1634PaiLicAdju ,
                                          boolean A1635PaiLicAdjuObl ,
                                          boolean A1636PaiLicNecAut ,
                                          boolean A1637PaiLicIngMot ,
                                          boolean A1638PaiLicMotObl ,
                                          short A1451PaiBasePromCnt1 ,
                                          short A1452PaiBasePromCnt2 ,
                                          short A46PaiCod ,
                                          byte AV65Paisbase_calculowwds_1_paibaseclaseleg ,
                                          String AV66Paisbase_calculowwds_2_paibasetipo ,
                                          byte A1440PaiBaseClaseLeg ,
                                          String A1441PaiBaseTipo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[20];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PaiBaseClaseLeg, PaiBaseTipo, PaiBaseRelRef, PaiCod, PaiBasePromTCnt, PaiBasePromCnt2, PaiBasePromCnt1, PaiLicMotObl, PaiLicIngMot, PaiLicNecAut, PaiLicAdjuObl," ;
      scmdbuf += " PaiLicAdju, PaiLicDAnual, PaiLicDSemes, PaiLicDMes, PaiLicDSeman, PaiLicDLim, PaiBasePlus, PaiBaseCod1, PaiBaseCod2 FROM Paisbase_calculo" ;
      addWhere(sWhereString, "(PaiBaseClaseLeg = ? and PaiBaseTipo = ( ?))");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Paisbase_calculowwds_3_tfpaibaseplus)==0) )
      {
         addWhere(sWhereString, "(PaiBasePlus >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV68Paisbase_calculowwds_4_tfpaibaseplus_to)==0) )
      {
         addWhere(sWhereString, "(PaiBasePlus <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV69Paisbase_calculowwds_5_tfpailicdlim) )
      {
         addWhere(sWhereString, "(PaiLicDLim >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV70Paisbase_calculowwds_6_tfpailicdlim_to) )
      {
         addWhere(sWhereString, "(PaiLicDLim <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV71Paisbase_calculowwds_7_tfpailicdseman) )
      {
         addWhere(sWhereString, "(PaiLicDSeman >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (0==AV72Paisbase_calculowwds_8_tfpailicdseman_to) )
      {
         addWhere(sWhereString, "(PaiLicDSeman <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (0==AV73Paisbase_calculowwds_9_tfpailicdmes) )
      {
         addWhere(sWhereString, "(PaiLicDMes >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV74Paisbase_calculowwds_10_tfpailicdmes_to) )
      {
         addWhere(sWhereString, "(PaiLicDMes <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV75Paisbase_calculowwds_11_tfpailicdsemes) )
      {
         addWhere(sWhereString, "(PaiLicDSemes >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV76Paisbase_calculowwds_12_tfpailicdsemes_to) )
      {
         addWhere(sWhereString, "(PaiLicDSemes <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV77Paisbase_calculowwds_13_tfpailicdanual) )
      {
         addWhere(sWhereString, "(PaiLicDAnual >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV78Paisbase_calculowwds_14_tfpailicdanual_to) )
      {
         addWhere(sWhereString, "(PaiLicDAnual <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( AV79Paisbase_calculowwds_15_tfpailicadju_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicAdju = TRUE)");
      }
      if ( AV79Paisbase_calculowwds_15_tfpailicadju_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicAdju = FALSE)");
      }
      if ( AV80Paisbase_calculowwds_16_tfpailicadjuobl_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicAdjuObl = TRUE)");
      }
      if ( AV80Paisbase_calculowwds_16_tfpailicadjuobl_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicAdjuObl = FALSE)");
      }
      if ( AV81Paisbase_calculowwds_17_tfpailicnecaut_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicNecAut = TRUE)");
      }
      if ( AV81Paisbase_calculowwds_17_tfpailicnecaut_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicNecAut = FALSE)");
      }
      if ( AV82Paisbase_calculowwds_18_tfpailicingmot_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicIngMot = TRUE)");
      }
      if ( AV82Paisbase_calculowwds_18_tfpailicingmot_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicIngMot = FALSE)");
      }
      if ( AV83Paisbase_calculowwds_19_tfpailicmotobl_sel == 1 )
      {
         addWhere(sWhereString, "(PaiLicMotObl = TRUE)");
      }
      if ( AV83Paisbase_calculowwds_19_tfpailicmotobl_sel == 2 )
      {
         addWhere(sWhereString, "(PaiLicMotObl = FALSE)");
      }
      if ( ! (0==AV84Paisbase_calculowwds_20_tfpaibasepromcnt1) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt1 >= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (0==AV85Paisbase_calculowwds_21_tfpaibasepromcnt1_to) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt1 <= ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( ! (0==AV86Paisbase_calculowwds_22_tfpaibasepromcnt2) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt2 >= ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (0==AV87Paisbase_calculowwds_23_tfpaibasepromcnt2_to) )
      {
         addWhere(sWhereString, "(PaiBasePromCnt2 <= ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV88Paisbase_calculowwds_24_tfpaibasepromtcnt_sels, "PaiBasePromTCnt IN (", ")")+")");
      }
      if ( ( AV90Paisbase_calculowwds_26_tfpaibaserelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV89Paisbase_calculowwds_25_tfpaibaserelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(PaiBaseRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( AV90Paisbase_calculowwds_26_tfpaibaserelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV90Paisbase_calculowwds_26_tfpaibaserelref_sels, "PaiBaseRelRef IN (", ")")+")");
      }
      if ( ! (0==AV60PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiBaseClaseLeg, PaiBaseTipo, PaiBaseRelRef" ;
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
                  return conditional_P01X82(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).byteValue() , ((Number) dynConstraints[20]).byteValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , (String)dynConstraints[27] , ((Number) dynConstraints[28]).shortValue() , (java.math.BigDecimal)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , ((Number) dynConstraints[31]).byteValue() , ((Number) dynConstraints[32]).byteValue() , ((Number) dynConstraints[33]).shortValue() , ((Number) dynConstraints[34]).shortValue() , ((Boolean) dynConstraints[35]).booleanValue() , ((Boolean) dynConstraints[36]).booleanValue() , ((Boolean) dynConstraints[37]).booleanValue() , ((Boolean) dynConstraints[38]).booleanValue() , ((Boolean) dynConstraints[39]).booleanValue() , ((Number) dynConstraints[40]).shortValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).shortValue() , ((Number) dynConstraints[43]).byteValue() , (String)dynConstraints[44] , ((Number) dynConstraints[45]).byteValue() , (String)dynConstraints[46] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X82", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((byte[]) buf[15])[0] = rslt.getByte(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,4);
               ((String[]) buf[18])[0] = rslt.getString(19, 20);
               ((String[]) buf[19])[0] = rslt.getString(20, 20);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 4);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[24]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
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
                  stmt.setShort(sIdx, ((Number) parms[39]).shortValue());
               }
               return;
      }
   }

}

