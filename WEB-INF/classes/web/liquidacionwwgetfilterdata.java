package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionwwgetfilterdata extends GXProcedure
{
   public liquidacionwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionwwgetfilterdata.class ), "" );
   }

   public liquidacionwwgetfilterdata( int remoteHandle ,
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
      liquidacionwwgetfilterdata.this.aP5 = new String[] {""};
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
      liquidacionwwgetfilterdata.this.AV36DDOName = aP0;
      liquidacionwwgetfilterdata.this.AV34SearchTxt = aP1;
      liquidacionwwgetfilterdata.this.AV35SearchTxtTo = aP2;
      liquidacionwwgetfilterdata.this.aP3 = aP3;
      liquidacionwwgetfilterdata.this.aP4 = aP4;
      liquidacionwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV57EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      liquidacionwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV57EmpCod = GXt_int1 ;
      GXt_int3 = AV56CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      liquidacionwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV56CliCod = GXt_int3 ;
      AV39Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion", GXv_boolean6) ;
      liquidacionwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_LIQNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQNOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_LIQPERPALABRA") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQPERPALABRAOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_TLIQDESCAUX") == 0 )
         {
            /* Execute user subroutine: 'LOADTLIQDESCAUXOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_LIQERROR") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQERROROPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_LIQDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQDESCRIPOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV40OptionsJson = AV39Options.toJSonString(false) ;
      AV43OptionsDescJson = AV42OptionsDesc.toJSonString(false) ;
      AV45OptionIndexesJson = AV44OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV47Session.getValue("LiquidacionWWGridState"), "") == 0 )
      {
         AV49GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionWWGridState"), null, null);
      }
      else
      {
         AV49GridState.fromxml(AV47Session.getValue("LiquidacionWWGridState"), null, null);
      }
      AV113GXV1 = 1 ;
      while ( AV113GXV1 <= AV49GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV50GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV49GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV113GXV1));
         if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LIQRELNRO") == 0 )
         {
            AV97LiqRelNro = (int)(GXutil.lval( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV14TFLiqNro = (int)(GXutil.lval( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV15TFLiqNro_To = (int)(GXutil.lval( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV82TFLiqNombre = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV84TFLiqNombre_Sel = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV18TFLiqFecha = localUtil.ctod( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV19TFLiqFecha_To = localUtil.ctod( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV76TFLiqPerPalabra = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV75TFLiqPerPalabra_SelsJson = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV77TFLiqPerPalabra_Sels.fromJSonString(AV75TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV23TFLiqFecPago = localUtil.ctod( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV24TFLiqFecPago_To = localUtil.ctod( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESCAUX") == 0 )
         {
            AV105TFTLiqDescAux = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESCAUX_SEL") == 0 )
         {
            AV104TFTLiqDescAux_SelsJson = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV106TFTLiqDescAux_Sels.fromJSonString(AV104TFTLiqDescAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQMODTRA_SEL") == 0 )
         {
            AV107TFLiqModTra_SelsJson = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV108TFLiqModTra_Sels.fromJSonString(AV107TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFRECPAG_SEL") == 0 )
         {
            AV109TFLiqFrecPag_SelsJson = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV110TFLiqFrecPag_Sels.fromJSonString(AV109TFLiqFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQCNTLEG") == 0 )
         {
            AV59TFLiqCntLeg = (short)(GXutil.lval( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV60TFLiqCntLeg_To = (short)(GXutil.lval( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQERROR") == 0 )
         {
            AV79TFLiqError = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQERROR_SEL") == 0 )
         {
            AV78TFLiqError_SelsJson = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV80TFLiqError_Sels.fromJSonString(AV78TFLiqError_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP") == 0 )
         {
            AV16TFLiqDescrip = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP_SEL") == 0 )
         {
            AV65TFLiqDescrip_SelsJson = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV66TFLiqDescrip_Sels.fromJSonString(AV65TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQIMPBRUTO") == 0 )
         {
            AV63TFLiqImpBruto = CommonUtil.decimalVal( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV64TFLiqImpBruto_To = CommonUtil.decimalVal( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQIMPNETO") == 0 )
         {
            AV61TFLiqImpNeto = CommonUtil.decimalVal( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV62TFLiqImpNeto_To = CommonUtil.decimalVal( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV96MenuOpcCod = AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PERIODOLIQ") == 0 )
         {
            AV93PeriodoLiq = localUtil.ctod( AV50GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         AV113GXV1 = (int)(AV113GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLIQNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV82TFLiqNombre = AV34SearchTxt ;
      AV84TFLiqNombre_Sel = "" ;
      AV115Liquidacionwwds_1_periodoliq = AV93PeriodoLiq ;
      AV116Liquidacionwwds_2_liqrelnro = AV97LiqRelNro ;
      AV117Liquidacionwwds_3_tfliqnro = AV14TFLiqNro ;
      AV118Liquidacionwwds_4_tfliqnro_to = AV15TFLiqNro_To ;
      AV119Liquidacionwwds_5_tfliqnombre = AV82TFLiqNombre ;
      AV120Liquidacionwwds_6_tfliqnombre_sel = AV84TFLiqNombre_Sel ;
      AV121Liquidacionwwds_7_tfliqfecha = AV18TFLiqFecha ;
      AV122Liquidacionwwds_8_tfliqfecha_to = AV19TFLiqFecha_To ;
      AV123Liquidacionwwds_9_tfliqperpalabra = AV76TFLiqPerPalabra ;
      AV124Liquidacionwwds_10_tfliqperpalabra_sels = AV77TFLiqPerPalabra_Sels ;
      AV125Liquidacionwwds_11_tfliqfecpago = AV23TFLiqFecPago ;
      AV126Liquidacionwwds_12_tfliqfecpago_to = AV24TFLiqFecPago_To ;
      AV127Liquidacionwwds_13_tftliqdescaux = AV105TFTLiqDescAux ;
      AV128Liquidacionwwds_14_tftliqdescaux_sels = AV106TFTLiqDescAux_Sels ;
      AV129Liquidacionwwds_15_tfliqmodtra_sels = AV108TFLiqModTra_Sels ;
      AV130Liquidacionwwds_16_tfliqfrecpag_sels = AV110TFLiqFrecPag_Sels ;
      AV131Liquidacionwwds_17_tfliqcntleg = AV59TFLiqCntLeg ;
      AV132Liquidacionwwds_18_tfliqcntleg_to = AV60TFLiqCntLeg_To ;
      AV133Liquidacionwwds_19_tfliqerror = AV79TFLiqError ;
      AV134Liquidacionwwds_20_tfliqerror_sels = AV80TFLiqError_Sels ;
      AV135Liquidacionwwds_21_tfliqdescrip = AV16TFLiqDescrip ;
      AV136Liquidacionwwds_22_tfliqdescrip_sels = AV66TFLiqDescrip_Sels ;
      AV137Liquidacionwwds_23_tfliqimpbruto = AV63TFLiqImpBruto ;
      AV138Liquidacionwwds_24_tfliqimpbruto_to = AV64TFLiqImpBruto_To ;
      AV139Liquidacionwwds_25_tfliqimpneto = AV61TFLiqImpNeto ;
      AV140Liquidacionwwds_26_tfliqimpneto_to = AV62TFLiqImpNeto_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                           A2368TLiqDescAux ,
                                           AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                           A2409LiqModTra ,
                                           AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                           A766LiqError ,
                                           AV134Liquidacionwwds_20_tfliqerror_sels ,
                                           A271LiqDescrip ,
                                           AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                           Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro) ,
                                           Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to) ,
                                           AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                           AV121Liquidacionwwds_7_tfliqfecha ,
                                           AV122Liquidacionwwds_8_tfliqfecha_to ,
                                           Integer.valueOf(AV124Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                           AV123Liquidacionwwds_9_tfliqperpalabra ,
                                           AV125Liquidacionwwds_11_tfliqfecpago ,
                                           AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                           Integer.valueOf(AV128Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                           AV127Liquidacionwwds_13_tftliqdescaux ,
                                           Integer.valueOf(AV129Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                           Integer.valueOf(AV130Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                           Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg) ,
                                           Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to) ,
                                           Integer.valueOf(AV134Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                           AV133Liquidacionwwds_19_tfliqerror ,
                                           Integer.valueOf(AV136Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                           AV135Liquidacionwwds_21_tfliqdescrip ,
                                           AV137Liquidacionwwds_23_tfliqimpbruto ,
                                           AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                           AV139Liquidacionwwds_25_tfliqimpneto ,
                                           AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A874LiqNombre ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           Short.valueOf(A495LiqCntLeg) ,
                                           A497LiqImpBruto ,
                                           A496LiqImpNeto ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           AV115Liquidacionwwds_1_periodoliq ,
                                           A1729PeriodoLiq } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV123Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV123Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
      lV127Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV127Liquidacionwwds_13_tftliqdescaux), "%", "") ;
      lV133Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV133Liquidacionwwds_19_tfliqerror), "%", "") ;
      lV135Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV135Liquidacionwwds_21_tfliqdescrip), "%", "") ;
      /* Using cursor P006P2 */
      pr_default.execute(0, new Object[] {AV115Liquidacionwwds_1_periodoliq, Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to), AV120Liquidacionwwds_6_tfliqnombre_sel, AV121Liquidacionwwds_7_tfliqfecha, AV122Liquidacionwwds_8_tfliqfecha_to, lV123Liquidacionwwds_9_tfliqperpalabra, AV125Liquidacionwwds_11_tfliqfecpago, AV126Liquidacionwwds_12_tfliqfecpago_to, lV127Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to), lV133Liquidacionwwds_19_tfliqerror, lV135Liquidacionwwds_21_tfliqdescrip, AV137Liquidacionwwds_23_tfliqimpbruto, AV138Liquidacionwwds_24_tfliqimpbruto_to, AV139Liquidacionwwds_25_tfliqimpneto, AV140Liquidacionwwds_26_tfliqimpneto_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6P2 = false ;
         A1729PeriodoLiq = P006P2_A1729PeriodoLiq[0] ;
         A3CliCod = P006P2_A3CliCod[0] ;
         A1EmpCod = P006P2_A1EmpCod[0] ;
         A874LiqNombre = P006P2_A874LiqNombre[0] ;
         A2112LiqRelNro = P006P2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P006P2_n2112LiqRelNro[0] ;
         A496LiqImpNeto = P006P2_A496LiqImpNeto[0] ;
         A497LiqImpBruto = P006P2_A497LiqImpBruto[0] ;
         A271LiqDescrip = P006P2_A271LiqDescrip[0] ;
         A766LiqError = P006P2_A766LiqError[0] ;
         A495LiqCntLeg = P006P2_A495LiqCntLeg[0] ;
         A2414LiqFrecPag = P006P2_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P006P2_A2409LiqModTra[0] ;
         A2368TLiqDescAux = P006P2_A2368TLiqDescAux[0] ;
         A280LiqFecPago = P006P2_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P006P2_A748LiqPerPalabra[0] ;
         A98LiqFecha = P006P2_A98LiqFecha[0] ;
         A31LiqNro = P006P2_A31LiqNro[0] ;
         AV46count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && GXutil.dateCompare(GXutil.resetTime(P006P2_A1729PeriodoLiq[0]), GXutil.resetTime(A1729PeriodoLiq)) && ( GXutil.strcmp(P006P2_A874LiqNombre[0], A874LiqNombre) == 0 ) )
         {
            brk6P2 = false ;
            A3CliCod = P006P2_A3CliCod[0] ;
            A1EmpCod = P006P2_A1EmpCod[0] ;
            A31LiqNro = P006P2_A31LiqNro[0] ;
            AV46count = (long)(AV46count+1) ;
            brk6P2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A874LiqNombre)==0) )
         {
            AV38Option = A874LiqNombre ;
            AV39Options.add(AV38Option, 0);
            AV44OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV46count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6P2 )
         {
            brk6P2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLIQPERPALABRAOPTIONS' Routine */
      returnInSub = false ;
      AV76TFLiqPerPalabra = AV34SearchTxt ;
      AV77TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV115Liquidacionwwds_1_periodoliq = AV93PeriodoLiq ;
      AV116Liquidacionwwds_2_liqrelnro = AV97LiqRelNro ;
      AV117Liquidacionwwds_3_tfliqnro = AV14TFLiqNro ;
      AV118Liquidacionwwds_4_tfliqnro_to = AV15TFLiqNro_To ;
      AV119Liquidacionwwds_5_tfliqnombre = AV82TFLiqNombre ;
      AV120Liquidacionwwds_6_tfliqnombre_sel = AV84TFLiqNombre_Sel ;
      AV121Liquidacionwwds_7_tfliqfecha = AV18TFLiqFecha ;
      AV122Liquidacionwwds_8_tfliqfecha_to = AV19TFLiqFecha_To ;
      AV123Liquidacionwwds_9_tfliqperpalabra = AV76TFLiqPerPalabra ;
      AV124Liquidacionwwds_10_tfliqperpalabra_sels = AV77TFLiqPerPalabra_Sels ;
      AV125Liquidacionwwds_11_tfliqfecpago = AV23TFLiqFecPago ;
      AV126Liquidacionwwds_12_tfliqfecpago_to = AV24TFLiqFecPago_To ;
      AV127Liquidacionwwds_13_tftliqdescaux = AV105TFTLiqDescAux ;
      AV128Liquidacionwwds_14_tftliqdescaux_sels = AV106TFTLiqDescAux_Sels ;
      AV129Liquidacionwwds_15_tfliqmodtra_sels = AV108TFLiqModTra_Sels ;
      AV130Liquidacionwwds_16_tfliqfrecpag_sels = AV110TFLiqFrecPag_Sels ;
      AV131Liquidacionwwds_17_tfliqcntleg = AV59TFLiqCntLeg ;
      AV132Liquidacionwwds_18_tfliqcntleg_to = AV60TFLiqCntLeg_To ;
      AV133Liquidacionwwds_19_tfliqerror = AV79TFLiqError ;
      AV134Liquidacionwwds_20_tfliqerror_sels = AV80TFLiqError_Sels ;
      AV135Liquidacionwwds_21_tfliqdescrip = AV16TFLiqDescrip ;
      AV136Liquidacionwwds_22_tfliqdescrip_sels = AV66TFLiqDescrip_Sels ;
      AV137Liquidacionwwds_23_tfliqimpbruto = AV63TFLiqImpBruto ;
      AV138Liquidacionwwds_24_tfliqimpbruto_to = AV64TFLiqImpBruto_To ;
      AV139Liquidacionwwds_25_tfliqimpneto = AV61TFLiqImpNeto ;
      AV140Liquidacionwwds_26_tfliqimpneto_to = AV62TFLiqImpNeto_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                           A2368TLiqDescAux ,
                                           AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                           A2409LiqModTra ,
                                           AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                           A766LiqError ,
                                           AV134Liquidacionwwds_20_tfliqerror_sels ,
                                           A271LiqDescrip ,
                                           AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                           Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro) ,
                                           Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to) ,
                                           AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                           AV121Liquidacionwwds_7_tfliqfecha ,
                                           AV122Liquidacionwwds_8_tfliqfecha_to ,
                                           Integer.valueOf(AV124Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                           AV123Liquidacionwwds_9_tfliqperpalabra ,
                                           AV125Liquidacionwwds_11_tfliqfecpago ,
                                           AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                           Integer.valueOf(AV128Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                           AV127Liquidacionwwds_13_tftliqdescaux ,
                                           Integer.valueOf(AV129Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                           Integer.valueOf(AV130Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                           Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg) ,
                                           Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to) ,
                                           Integer.valueOf(AV134Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                           AV133Liquidacionwwds_19_tfliqerror ,
                                           Integer.valueOf(AV136Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                           AV135Liquidacionwwds_21_tfliqdescrip ,
                                           AV137Liquidacionwwds_23_tfliqimpbruto ,
                                           AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                           AV139Liquidacionwwds_25_tfliqimpneto ,
                                           AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A874LiqNombre ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           Short.valueOf(A495LiqCntLeg) ,
                                           A497LiqImpBruto ,
                                           A496LiqImpNeto ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           AV115Liquidacionwwds_1_periodoliq ,
                                           A1729PeriodoLiq } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV123Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV123Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
      lV127Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV127Liquidacionwwds_13_tftliqdescaux), "%", "") ;
      lV133Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV133Liquidacionwwds_19_tfliqerror), "%", "") ;
      lV135Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV135Liquidacionwwds_21_tfliqdescrip), "%", "") ;
      /* Using cursor P006P3 */
      pr_default.execute(1, new Object[] {AV115Liquidacionwwds_1_periodoliq, Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to), AV120Liquidacionwwds_6_tfliqnombre_sel, AV121Liquidacionwwds_7_tfliqfecha, AV122Liquidacionwwds_8_tfliqfecha_to, lV123Liquidacionwwds_9_tfliqperpalabra, AV125Liquidacionwwds_11_tfliqfecpago, AV126Liquidacionwwds_12_tfliqfecpago_to, lV127Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to), lV133Liquidacionwwds_19_tfliqerror, lV135Liquidacionwwds_21_tfliqdescrip, AV137Liquidacionwwds_23_tfliqimpbruto, AV138Liquidacionwwds_24_tfliqimpbruto_to, AV139Liquidacionwwds_25_tfliqimpneto, AV140Liquidacionwwds_26_tfliqimpneto_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6P4 = false ;
         A1729PeriodoLiq = P006P3_A1729PeriodoLiq[0] ;
         A3CliCod = P006P3_A3CliCod[0] ;
         A1EmpCod = P006P3_A1EmpCod[0] ;
         A748LiqPerPalabra = P006P3_A748LiqPerPalabra[0] ;
         A2112LiqRelNro = P006P3_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P006P3_n2112LiqRelNro[0] ;
         A496LiqImpNeto = P006P3_A496LiqImpNeto[0] ;
         A497LiqImpBruto = P006P3_A497LiqImpBruto[0] ;
         A271LiqDescrip = P006P3_A271LiqDescrip[0] ;
         A766LiqError = P006P3_A766LiqError[0] ;
         A495LiqCntLeg = P006P3_A495LiqCntLeg[0] ;
         A2414LiqFrecPag = P006P3_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P006P3_A2409LiqModTra[0] ;
         A2368TLiqDescAux = P006P3_A2368TLiqDescAux[0] ;
         A280LiqFecPago = P006P3_A280LiqFecPago[0] ;
         A98LiqFecha = P006P3_A98LiqFecha[0] ;
         A874LiqNombre = P006P3_A874LiqNombre[0] ;
         A31LiqNro = P006P3_A31LiqNro[0] ;
         AV46count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && GXutil.dateCompare(GXutil.resetTime(P006P3_A1729PeriodoLiq[0]), GXutil.resetTime(A1729PeriodoLiq)) && ( GXutil.strcmp(P006P3_A748LiqPerPalabra[0], A748LiqPerPalabra) == 0 ) )
         {
            brk6P4 = false ;
            A3CliCod = P006P3_A3CliCod[0] ;
            A1EmpCod = P006P3_A1EmpCod[0] ;
            A31LiqNro = P006P3_A31LiqNro[0] ;
            AV46count = (long)(AV46count+1) ;
            brk6P4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A748LiqPerPalabra)==0) )
         {
            AV38Option = A748LiqPerPalabra ;
            AV39Options.add(AV38Option, 0);
            AV44OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV46count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6P4 )
         {
            brk6P4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADTLIQDESCAUXOPTIONS' Routine */
      returnInSub = false ;
      AV105TFTLiqDescAux = AV34SearchTxt ;
      AV106TFTLiqDescAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV115Liquidacionwwds_1_periodoliq = AV93PeriodoLiq ;
      AV116Liquidacionwwds_2_liqrelnro = AV97LiqRelNro ;
      AV117Liquidacionwwds_3_tfliqnro = AV14TFLiqNro ;
      AV118Liquidacionwwds_4_tfliqnro_to = AV15TFLiqNro_To ;
      AV119Liquidacionwwds_5_tfliqnombre = AV82TFLiqNombre ;
      AV120Liquidacionwwds_6_tfliqnombre_sel = AV84TFLiqNombre_Sel ;
      AV121Liquidacionwwds_7_tfliqfecha = AV18TFLiqFecha ;
      AV122Liquidacionwwds_8_tfliqfecha_to = AV19TFLiqFecha_To ;
      AV123Liquidacionwwds_9_tfliqperpalabra = AV76TFLiqPerPalabra ;
      AV124Liquidacionwwds_10_tfliqperpalabra_sels = AV77TFLiqPerPalabra_Sels ;
      AV125Liquidacionwwds_11_tfliqfecpago = AV23TFLiqFecPago ;
      AV126Liquidacionwwds_12_tfliqfecpago_to = AV24TFLiqFecPago_To ;
      AV127Liquidacionwwds_13_tftliqdescaux = AV105TFTLiqDescAux ;
      AV128Liquidacionwwds_14_tftliqdescaux_sels = AV106TFTLiqDescAux_Sels ;
      AV129Liquidacionwwds_15_tfliqmodtra_sels = AV108TFLiqModTra_Sels ;
      AV130Liquidacionwwds_16_tfliqfrecpag_sels = AV110TFLiqFrecPag_Sels ;
      AV131Liquidacionwwds_17_tfliqcntleg = AV59TFLiqCntLeg ;
      AV132Liquidacionwwds_18_tfliqcntleg_to = AV60TFLiqCntLeg_To ;
      AV133Liquidacionwwds_19_tfliqerror = AV79TFLiqError ;
      AV134Liquidacionwwds_20_tfliqerror_sels = AV80TFLiqError_Sels ;
      AV135Liquidacionwwds_21_tfliqdescrip = AV16TFLiqDescrip ;
      AV136Liquidacionwwds_22_tfliqdescrip_sels = AV66TFLiqDescrip_Sels ;
      AV137Liquidacionwwds_23_tfliqimpbruto = AV63TFLiqImpBruto ;
      AV138Liquidacionwwds_24_tfliqimpbruto_to = AV64TFLiqImpBruto_To ;
      AV139Liquidacionwwds_25_tfliqimpneto = AV61TFLiqImpNeto ;
      AV140Liquidacionwwds_26_tfliqimpneto_to = AV62TFLiqImpNeto_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                           A2368TLiqDescAux ,
                                           AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                           A2409LiqModTra ,
                                           AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                           A766LiqError ,
                                           AV134Liquidacionwwds_20_tfliqerror_sels ,
                                           A271LiqDescrip ,
                                           AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                           Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro) ,
                                           Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to) ,
                                           AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                           AV121Liquidacionwwds_7_tfliqfecha ,
                                           AV122Liquidacionwwds_8_tfliqfecha_to ,
                                           Integer.valueOf(AV124Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                           AV123Liquidacionwwds_9_tfliqperpalabra ,
                                           AV125Liquidacionwwds_11_tfliqfecpago ,
                                           AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                           Integer.valueOf(AV128Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                           AV127Liquidacionwwds_13_tftliqdescaux ,
                                           Integer.valueOf(AV129Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                           Integer.valueOf(AV130Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                           Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg) ,
                                           Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to) ,
                                           Integer.valueOf(AV134Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                           AV133Liquidacionwwds_19_tfliqerror ,
                                           Integer.valueOf(AV136Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                           AV135Liquidacionwwds_21_tfliqdescrip ,
                                           AV137Liquidacionwwds_23_tfliqimpbruto ,
                                           AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                           AV139Liquidacionwwds_25_tfliqimpneto ,
                                           AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A874LiqNombre ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           Short.valueOf(A495LiqCntLeg) ,
                                           A497LiqImpBruto ,
                                           A496LiqImpNeto ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           AV115Liquidacionwwds_1_periodoliq ,
                                           A1729PeriodoLiq } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV123Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV123Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
      lV127Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV127Liquidacionwwds_13_tftliqdescaux), "%", "") ;
      lV133Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV133Liquidacionwwds_19_tfliqerror), "%", "") ;
      lV135Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV135Liquidacionwwds_21_tfliqdescrip), "%", "") ;
      /* Using cursor P006P4 */
      pr_default.execute(2, new Object[] {AV115Liquidacionwwds_1_periodoliq, Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to), AV120Liquidacionwwds_6_tfliqnombre_sel, AV121Liquidacionwwds_7_tfliqfecha, AV122Liquidacionwwds_8_tfliqfecha_to, lV123Liquidacionwwds_9_tfliqperpalabra, AV125Liquidacionwwds_11_tfliqfecpago, AV126Liquidacionwwds_12_tfliqfecpago_to, lV127Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to), lV133Liquidacionwwds_19_tfliqerror, lV135Liquidacionwwds_21_tfliqdescrip, AV137Liquidacionwwds_23_tfliqimpbruto, AV138Liquidacionwwds_24_tfliqimpbruto_to, AV139Liquidacionwwds_25_tfliqimpneto, AV140Liquidacionwwds_26_tfliqimpneto_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6P6 = false ;
         A1729PeriodoLiq = P006P4_A1729PeriodoLiq[0] ;
         A3CliCod = P006P4_A3CliCod[0] ;
         A1EmpCod = P006P4_A1EmpCod[0] ;
         A2368TLiqDescAux = P006P4_A2368TLiqDescAux[0] ;
         A2112LiqRelNro = P006P4_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P006P4_n2112LiqRelNro[0] ;
         A496LiqImpNeto = P006P4_A496LiqImpNeto[0] ;
         A497LiqImpBruto = P006P4_A497LiqImpBruto[0] ;
         A271LiqDescrip = P006P4_A271LiqDescrip[0] ;
         A766LiqError = P006P4_A766LiqError[0] ;
         A495LiqCntLeg = P006P4_A495LiqCntLeg[0] ;
         A2414LiqFrecPag = P006P4_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P006P4_A2409LiqModTra[0] ;
         A280LiqFecPago = P006P4_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P006P4_A748LiqPerPalabra[0] ;
         A98LiqFecha = P006P4_A98LiqFecha[0] ;
         A874LiqNombre = P006P4_A874LiqNombre[0] ;
         A31LiqNro = P006P4_A31LiqNro[0] ;
         AV46count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && GXutil.dateCompare(GXutil.resetTime(P006P4_A1729PeriodoLiq[0]), GXutil.resetTime(A1729PeriodoLiq)) && ( GXutil.strcmp(P006P4_A2368TLiqDescAux[0], A2368TLiqDescAux) == 0 ) )
         {
            brk6P6 = false ;
            A3CliCod = P006P4_A3CliCod[0] ;
            A1EmpCod = P006P4_A1EmpCod[0] ;
            A31LiqNro = P006P4_A31LiqNro[0] ;
            AV46count = (long)(AV46count+1) ;
            brk6P6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2368TLiqDescAux)==0) )
         {
            AV38Option = A2368TLiqDescAux ;
            AV39Options.add(AV38Option, 0);
            AV44OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV46count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6P6 )
         {
            brk6P6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADLIQERROROPTIONS' Routine */
      returnInSub = false ;
      AV79TFLiqError = AV34SearchTxt ;
      AV80TFLiqError_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV115Liquidacionwwds_1_periodoliq = AV93PeriodoLiq ;
      AV116Liquidacionwwds_2_liqrelnro = AV97LiqRelNro ;
      AV117Liquidacionwwds_3_tfliqnro = AV14TFLiqNro ;
      AV118Liquidacionwwds_4_tfliqnro_to = AV15TFLiqNro_To ;
      AV119Liquidacionwwds_5_tfliqnombre = AV82TFLiqNombre ;
      AV120Liquidacionwwds_6_tfliqnombre_sel = AV84TFLiqNombre_Sel ;
      AV121Liquidacionwwds_7_tfliqfecha = AV18TFLiqFecha ;
      AV122Liquidacionwwds_8_tfliqfecha_to = AV19TFLiqFecha_To ;
      AV123Liquidacionwwds_9_tfliqperpalabra = AV76TFLiqPerPalabra ;
      AV124Liquidacionwwds_10_tfliqperpalabra_sels = AV77TFLiqPerPalabra_Sels ;
      AV125Liquidacionwwds_11_tfliqfecpago = AV23TFLiqFecPago ;
      AV126Liquidacionwwds_12_tfliqfecpago_to = AV24TFLiqFecPago_To ;
      AV127Liquidacionwwds_13_tftliqdescaux = AV105TFTLiqDescAux ;
      AV128Liquidacionwwds_14_tftliqdescaux_sels = AV106TFTLiqDescAux_Sels ;
      AV129Liquidacionwwds_15_tfliqmodtra_sels = AV108TFLiqModTra_Sels ;
      AV130Liquidacionwwds_16_tfliqfrecpag_sels = AV110TFLiqFrecPag_Sels ;
      AV131Liquidacionwwds_17_tfliqcntleg = AV59TFLiqCntLeg ;
      AV132Liquidacionwwds_18_tfliqcntleg_to = AV60TFLiqCntLeg_To ;
      AV133Liquidacionwwds_19_tfliqerror = AV79TFLiqError ;
      AV134Liquidacionwwds_20_tfliqerror_sels = AV80TFLiqError_Sels ;
      AV135Liquidacionwwds_21_tfliqdescrip = AV16TFLiqDescrip ;
      AV136Liquidacionwwds_22_tfliqdescrip_sels = AV66TFLiqDescrip_Sels ;
      AV137Liquidacionwwds_23_tfliqimpbruto = AV63TFLiqImpBruto ;
      AV138Liquidacionwwds_24_tfliqimpbruto_to = AV64TFLiqImpBruto_To ;
      AV139Liquidacionwwds_25_tfliqimpneto = AV61TFLiqImpNeto ;
      AV140Liquidacionwwds_26_tfliqimpneto_to = AV62TFLiqImpNeto_To ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                           A2368TLiqDescAux ,
                                           AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                           A2409LiqModTra ,
                                           AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                           A766LiqError ,
                                           AV134Liquidacionwwds_20_tfliqerror_sels ,
                                           A271LiqDescrip ,
                                           AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                           Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro) ,
                                           Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to) ,
                                           AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                           AV121Liquidacionwwds_7_tfliqfecha ,
                                           AV122Liquidacionwwds_8_tfliqfecha_to ,
                                           Integer.valueOf(AV124Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                           AV123Liquidacionwwds_9_tfliqperpalabra ,
                                           AV125Liquidacionwwds_11_tfliqfecpago ,
                                           AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                           Integer.valueOf(AV128Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                           AV127Liquidacionwwds_13_tftliqdescaux ,
                                           Integer.valueOf(AV129Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                           Integer.valueOf(AV130Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                           Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg) ,
                                           Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to) ,
                                           Integer.valueOf(AV134Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                           AV133Liquidacionwwds_19_tfliqerror ,
                                           Integer.valueOf(AV136Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                           AV135Liquidacionwwds_21_tfliqdescrip ,
                                           AV137Liquidacionwwds_23_tfliqimpbruto ,
                                           AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                           AV139Liquidacionwwds_25_tfliqimpneto ,
                                           AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A874LiqNombre ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           Short.valueOf(A495LiqCntLeg) ,
                                           A497LiqImpBruto ,
                                           A496LiqImpNeto ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           AV115Liquidacionwwds_1_periodoliq ,
                                           A1729PeriodoLiq } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV123Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV123Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
      lV127Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV127Liquidacionwwds_13_tftliqdescaux), "%", "") ;
      lV133Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV133Liquidacionwwds_19_tfliqerror), "%", "") ;
      lV135Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV135Liquidacionwwds_21_tfliqdescrip), "%", "") ;
      /* Using cursor P006P5 */
      pr_default.execute(3, new Object[] {AV115Liquidacionwwds_1_periodoliq, Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to), AV120Liquidacionwwds_6_tfliqnombre_sel, AV121Liquidacionwwds_7_tfliqfecha, AV122Liquidacionwwds_8_tfliqfecha_to, lV123Liquidacionwwds_9_tfliqperpalabra, AV125Liquidacionwwds_11_tfliqfecpago, AV126Liquidacionwwds_12_tfliqfecpago_to, lV127Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to), lV133Liquidacionwwds_19_tfliqerror, lV135Liquidacionwwds_21_tfliqdescrip, AV137Liquidacionwwds_23_tfliqimpbruto, AV138Liquidacionwwds_24_tfliqimpbruto_to, AV139Liquidacionwwds_25_tfliqimpneto, AV140Liquidacionwwds_26_tfliqimpneto_to});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk6P8 = false ;
         A1729PeriodoLiq = P006P5_A1729PeriodoLiq[0] ;
         A3CliCod = P006P5_A3CliCod[0] ;
         A1EmpCod = P006P5_A1EmpCod[0] ;
         A766LiqError = P006P5_A766LiqError[0] ;
         A2112LiqRelNro = P006P5_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P006P5_n2112LiqRelNro[0] ;
         A496LiqImpNeto = P006P5_A496LiqImpNeto[0] ;
         A497LiqImpBruto = P006P5_A497LiqImpBruto[0] ;
         A271LiqDescrip = P006P5_A271LiqDescrip[0] ;
         A495LiqCntLeg = P006P5_A495LiqCntLeg[0] ;
         A2414LiqFrecPag = P006P5_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P006P5_A2409LiqModTra[0] ;
         A2368TLiqDescAux = P006P5_A2368TLiqDescAux[0] ;
         A280LiqFecPago = P006P5_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P006P5_A748LiqPerPalabra[0] ;
         A98LiqFecha = P006P5_A98LiqFecha[0] ;
         A874LiqNombre = P006P5_A874LiqNombre[0] ;
         A31LiqNro = P006P5_A31LiqNro[0] ;
         AV46count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && GXutil.dateCompare(GXutil.resetTime(P006P5_A1729PeriodoLiq[0]), GXutil.resetTime(A1729PeriodoLiq)) && ( GXutil.strcmp(P006P5_A766LiqError[0], A766LiqError) == 0 ) )
         {
            brk6P8 = false ;
            A3CliCod = P006P5_A3CliCod[0] ;
            A1EmpCod = P006P5_A1EmpCod[0] ;
            A31LiqNro = P006P5_A31LiqNro[0] ;
            AV46count = (long)(AV46count+1) ;
            brk6P8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A766LiqError)==0) )
         {
            AV38Option = A766LiqError ;
            AV39Options.add(AV38Option, 0);
            AV44OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV46count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6P8 )
         {
            brk6P8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADLIQDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV16TFLiqDescrip = AV34SearchTxt ;
      AV66TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV115Liquidacionwwds_1_periodoliq = AV93PeriodoLiq ;
      AV116Liquidacionwwds_2_liqrelnro = AV97LiqRelNro ;
      AV117Liquidacionwwds_3_tfliqnro = AV14TFLiqNro ;
      AV118Liquidacionwwds_4_tfliqnro_to = AV15TFLiqNro_To ;
      AV119Liquidacionwwds_5_tfliqnombre = AV82TFLiqNombre ;
      AV120Liquidacionwwds_6_tfliqnombre_sel = AV84TFLiqNombre_Sel ;
      AV121Liquidacionwwds_7_tfliqfecha = AV18TFLiqFecha ;
      AV122Liquidacionwwds_8_tfliqfecha_to = AV19TFLiqFecha_To ;
      AV123Liquidacionwwds_9_tfliqperpalabra = AV76TFLiqPerPalabra ;
      AV124Liquidacionwwds_10_tfliqperpalabra_sels = AV77TFLiqPerPalabra_Sels ;
      AV125Liquidacionwwds_11_tfliqfecpago = AV23TFLiqFecPago ;
      AV126Liquidacionwwds_12_tfliqfecpago_to = AV24TFLiqFecPago_To ;
      AV127Liquidacionwwds_13_tftliqdescaux = AV105TFTLiqDescAux ;
      AV128Liquidacionwwds_14_tftliqdescaux_sels = AV106TFTLiqDescAux_Sels ;
      AV129Liquidacionwwds_15_tfliqmodtra_sels = AV108TFLiqModTra_Sels ;
      AV130Liquidacionwwds_16_tfliqfrecpag_sels = AV110TFLiqFrecPag_Sels ;
      AV131Liquidacionwwds_17_tfliqcntleg = AV59TFLiqCntLeg ;
      AV132Liquidacionwwds_18_tfliqcntleg_to = AV60TFLiqCntLeg_To ;
      AV133Liquidacionwwds_19_tfliqerror = AV79TFLiqError ;
      AV134Liquidacionwwds_20_tfliqerror_sels = AV80TFLiqError_Sels ;
      AV135Liquidacionwwds_21_tfliqdescrip = AV16TFLiqDescrip ;
      AV136Liquidacionwwds_22_tfliqdescrip_sels = AV66TFLiqDescrip_Sels ;
      AV137Liquidacionwwds_23_tfliqimpbruto = AV63TFLiqImpBruto ;
      AV138Liquidacionwwds_24_tfliqimpbruto_to = AV64TFLiqImpBruto_To ;
      AV139Liquidacionwwds_25_tfliqimpneto = AV61TFLiqImpNeto ;
      AV140Liquidacionwwds_26_tfliqimpneto_to = AV62TFLiqImpNeto_To ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                           A2368TLiqDescAux ,
                                           AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                           A2409LiqModTra ,
                                           AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                           A766LiqError ,
                                           AV134Liquidacionwwds_20_tfliqerror_sels ,
                                           A271LiqDescrip ,
                                           AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                           Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro) ,
                                           Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to) ,
                                           AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                           AV121Liquidacionwwds_7_tfliqfecha ,
                                           AV122Liquidacionwwds_8_tfliqfecha_to ,
                                           Integer.valueOf(AV124Liquidacionwwds_10_tfliqperpalabra_sels.size()) ,
                                           AV123Liquidacionwwds_9_tfliqperpalabra ,
                                           AV125Liquidacionwwds_11_tfliqfecpago ,
                                           AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                           Integer.valueOf(AV128Liquidacionwwds_14_tftliqdescaux_sels.size()) ,
                                           AV127Liquidacionwwds_13_tftliqdescaux ,
                                           Integer.valueOf(AV129Liquidacionwwds_15_tfliqmodtra_sels.size()) ,
                                           Integer.valueOf(AV130Liquidacionwwds_16_tfliqfrecpag_sels.size()) ,
                                           Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg) ,
                                           Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to) ,
                                           Integer.valueOf(AV134Liquidacionwwds_20_tfliqerror_sels.size()) ,
                                           AV133Liquidacionwwds_19_tfliqerror ,
                                           Integer.valueOf(AV136Liquidacionwwds_22_tfliqdescrip_sels.size()) ,
                                           AV135Liquidacionwwds_21_tfliqdescrip ,
                                           AV137Liquidacionwwds_23_tfliqimpbruto ,
                                           AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                           AV139Liquidacionwwds_25_tfliqimpneto ,
                                           AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A874LiqNombre ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           Short.valueOf(A495LiqCntLeg) ,
                                           A497LiqImpBruto ,
                                           A496LiqImpNeto ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           AV115Liquidacionwwds_1_periodoliq ,
                                           A1729PeriodoLiq } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      lV123Liquidacionwwds_9_tfliqperpalabra = GXutil.padr( GXutil.rtrim( AV123Liquidacionwwds_9_tfliqperpalabra), 20, "%") ;
      lV127Liquidacionwwds_13_tftliqdescaux = GXutil.concat( GXutil.rtrim( AV127Liquidacionwwds_13_tftliqdescaux), "%", "") ;
      lV133Liquidacionwwds_19_tfliqerror = GXutil.concat( GXutil.rtrim( AV133Liquidacionwwds_19_tfliqerror), "%", "") ;
      lV135Liquidacionwwds_21_tfliqdescrip = GXutil.concat( GXutil.rtrim( AV135Liquidacionwwds_21_tfliqdescrip), "%", "") ;
      /* Using cursor P006P6 */
      pr_default.execute(4, new Object[] {AV115Liquidacionwwds_1_periodoliq, Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV117Liquidacionwwds_3_tfliqnro), Integer.valueOf(AV118Liquidacionwwds_4_tfliqnro_to), AV120Liquidacionwwds_6_tfliqnombre_sel, AV121Liquidacionwwds_7_tfliqfecha, AV122Liquidacionwwds_8_tfliqfecha_to, lV123Liquidacionwwds_9_tfliqperpalabra, AV125Liquidacionwwds_11_tfliqfecpago, AV126Liquidacionwwds_12_tfliqfecpago_to, lV127Liquidacionwwds_13_tftliqdescaux, Short.valueOf(AV131Liquidacionwwds_17_tfliqcntleg), Short.valueOf(AV132Liquidacionwwds_18_tfliqcntleg_to), lV133Liquidacionwwds_19_tfliqerror, lV135Liquidacionwwds_21_tfliqdescrip, AV137Liquidacionwwds_23_tfliqimpbruto, AV138Liquidacionwwds_24_tfliqimpbruto_to, AV139Liquidacionwwds_25_tfliqimpneto, AV140Liquidacionwwds_26_tfliqimpneto_to});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk6P10 = false ;
         A1729PeriodoLiq = P006P6_A1729PeriodoLiq[0] ;
         A3CliCod = P006P6_A3CliCod[0] ;
         A1EmpCod = P006P6_A1EmpCod[0] ;
         A271LiqDescrip = P006P6_A271LiqDescrip[0] ;
         A2112LiqRelNro = P006P6_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P006P6_n2112LiqRelNro[0] ;
         A496LiqImpNeto = P006P6_A496LiqImpNeto[0] ;
         A497LiqImpBruto = P006P6_A497LiqImpBruto[0] ;
         A766LiqError = P006P6_A766LiqError[0] ;
         A495LiqCntLeg = P006P6_A495LiqCntLeg[0] ;
         A2414LiqFrecPag = P006P6_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P006P6_A2409LiqModTra[0] ;
         A2368TLiqDescAux = P006P6_A2368TLiqDescAux[0] ;
         A280LiqFecPago = P006P6_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P006P6_A748LiqPerPalabra[0] ;
         A98LiqFecha = P006P6_A98LiqFecha[0] ;
         A874LiqNombre = P006P6_A874LiqNombre[0] ;
         A31LiqNro = P006P6_A31LiqNro[0] ;
         AV46count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && GXutil.dateCompare(GXutil.resetTime(P006P6_A1729PeriodoLiq[0]), GXutil.resetTime(A1729PeriodoLiq)) && ( GXutil.strcmp(P006P6_A271LiqDescrip[0], A271LiqDescrip) == 0 ) )
         {
            brk6P10 = false ;
            A3CliCod = P006P6_A3CliCod[0] ;
            A1EmpCod = P006P6_A1EmpCod[0] ;
            A31LiqNro = P006P6_A31LiqNro[0] ;
            AV46count = (long)(AV46count+1) ;
            brk6P10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A271LiqDescrip)==0) )
         {
            AV38Option = A271LiqDescrip ;
            AV39Options.add(AV38Option, 0);
            AV44OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV46count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6P10 )
         {
            brk6P10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   protected void cleanup( )
   {
      this.aP3[0] = liquidacionwwgetfilterdata.this.AV40OptionsJson;
      this.aP4[0] = liquidacionwwgetfilterdata.this.AV43OptionsDescJson;
      this.aP5[0] = liquidacionwwgetfilterdata.this.AV45OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV40OptionsJson = "" ;
      AV43OptionsDescJson = "" ;
      AV45OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV39Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV47Session = httpContext.getWebSession();
      AV49GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV50GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV82TFLiqNombre = "" ;
      AV84TFLiqNombre_Sel = "" ;
      AV18TFLiqFecha = GXutil.nullDate() ;
      AV19TFLiqFecha_To = GXutil.nullDate() ;
      AV76TFLiqPerPalabra = "" ;
      AV75TFLiqPerPalabra_SelsJson = "" ;
      AV77TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFLiqFecPago = GXutil.nullDate() ;
      AV24TFLiqFecPago_To = GXutil.nullDate() ;
      AV105TFTLiqDescAux = "" ;
      AV104TFTLiqDescAux_SelsJson = "" ;
      AV106TFTLiqDescAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV107TFLiqModTra_SelsJson = "" ;
      AV108TFLiqModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV109TFLiqFrecPag_SelsJson = "" ;
      AV110TFLiqFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV79TFLiqError = "" ;
      AV78TFLiqError_SelsJson = "" ;
      AV80TFLiqError_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFLiqDescrip = "" ;
      AV65TFLiqDescrip_SelsJson = "" ;
      AV66TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63TFLiqImpBruto = DecimalUtil.ZERO ;
      AV64TFLiqImpBruto_To = DecimalUtil.ZERO ;
      AV61TFLiqImpNeto = DecimalUtil.ZERO ;
      AV62TFLiqImpNeto_To = DecimalUtil.ZERO ;
      AV96MenuOpcCod = "" ;
      AV93PeriodoLiq = GXutil.nullDate() ;
      A874LiqNombre = "" ;
      AV115Liquidacionwwds_1_periodoliq = GXutil.nullDate() ;
      AV119Liquidacionwwds_5_tfliqnombre = "" ;
      AV120Liquidacionwwds_6_tfliqnombre_sel = "" ;
      AV121Liquidacionwwds_7_tfliqfecha = GXutil.nullDate() ;
      AV122Liquidacionwwds_8_tfliqfecha_to = GXutil.nullDate() ;
      AV123Liquidacionwwds_9_tfliqperpalabra = "" ;
      AV124Liquidacionwwds_10_tfliqperpalabra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV125Liquidacionwwds_11_tfliqfecpago = GXutil.nullDate() ;
      AV126Liquidacionwwds_12_tfliqfecpago_to = GXutil.nullDate() ;
      AV127Liquidacionwwds_13_tftliqdescaux = "" ;
      AV128Liquidacionwwds_14_tftliqdescaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV129Liquidacionwwds_15_tfliqmodtra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV130Liquidacionwwds_16_tfliqfrecpag_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV133Liquidacionwwds_19_tfliqerror = "" ;
      AV134Liquidacionwwds_20_tfliqerror_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV135Liquidacionwwds_21_tfliqdescrip = "" ;
      AV136Liquidacionwwds_22_tfliqdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV137Liquidacionwwds_23_tfliqimpbruto = DecimalUtil.ZERO ;
      AV138Liquidacionwwds_24_tfliqimpbruto_to = DecimalUtil.ZERO ;
      AV139Liquidacionwwds_25_tfliqimpneto = DecimalUtil.ZERO ;
      AV140Liquidacionwwds_26_tfliqimpneto_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV123Liquidacionwwds_9_tfliqperpalabra = "" ;
      lV127Liquidacionwwds_13_tftliqdescaux = "" ;
      lV133Liquidacionwwds_19_tfliqerror = "" ;
      lV135Liquidacionwwds_21_tfliqdescrip = "" ;
      A748LiqPerPalabra = "" ;
      A2368TLiqDescAux = "" ;
      A2409LiqModTra = "" ;
      A766LiqError = "" ;
      A271LiqDescrip = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      P006P2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P006P2_A3CliCod = new int[1] ;
      P006P2_A1EmpCod = new short[1] ;
      P006P2_A874LiqNombre = new String[] {""} ;
      P006P2_A2112LiqRelNro = new int[1] ;
      P006P2_n2112LiqRelNro = new boolean[] {false} ;
      P006P2_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P2_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P2_A271LiqDescrip = new String[] {""} ;
      P006P2_A766LiqError = new String[] {""} ;
      P006P2_A495LiqCntLeg = new short[1] ;
      P006P2_A2414LiqFrecPag = new byte[1] ;
      P006P2_A2409LiqModTra = new String[] {""} ;
      P006P2_A2368TLiqDescAux = new String[] {""} ;
      P006P2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P006P2_A748LiqPerPalabra = new String[] {""} ;
      P006P2_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006P2_A31LiqNro = new int[1] ;
      AV38Option = "" ;
      P006P3_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P006P3_A3CliCod = new int[1] ;
      P006P3_A1EmpCod = new short[1] ;
      P006P3_A748LiqPerPalabra = new String[] {""} ;
      P006P3_A2112LiqRelNro = new int[1] ;
      P006P3_n2112LiqRelNro = new boolean[] {false} ;
      P006P3_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P3_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P3_A271LiqDescrip = new String[] {""} ;
      P006P3_A766LiqError = new String[] {""} ;
      P006P3_A495LiqCntLeg = new short[1] ;
      P006P3_A2414LiqFrecPag = new byte[1] ;
      P006P3_A2409LiqModTra = new String[] {""} ;
      P006P3_A2368TLiqDescAux = new String[] {""} ;
      P006P3_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P006P3_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006P3_A874LiqNombre = new String[] {""} ;
      P006P3_A31LiqNro = new int[1] ;
      P006P4_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P006P4_A3CliCod = new int[1] ;
      P006P4_A1EmpCod = new short[1] ;
      P006P4_A2368TLiqDescAux = new String[] {""} ;
      P006P4_A2112LiqRelNro = new int[1] ;
      P006P4_n2112LiqRelNro = new boolean[] {false} ;
      P006P4_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P4_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P4_A271LiqDescrip = new String[] {""} ;
      P006P4_A766LiqError = new String[] {""} ;
      P006P4_A495LiqCntLeg = new short[1] ;
      P006P4_A2414LiqFrecPag = new byte[1] ;
      P006P4_A2409LiqModTra = new String[] {""} ;
      P006P4_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P006P4_A748LiqPerPalabra = new String[] {""} ;
      P006P4_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006P4_A874LiqNombre = new String[] {""} ;
      P006P4_A31LiqNro = new int[1] ;
      P006P5_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P006P5_A3CliCod = new int[1] ;
      P006P5_A1EmpCod = new short[1] ;
      P006P5_A766LiqError = new String[] {""} ;
      P006P5_A2112LiqRelNro = new int[1] ;
      P006P5_n2112LiqRelNro = new boolean[] {false} ;
      P006P5_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P5_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P5_A271LiqDescrip = new String[] {""} ;
      P006P5_A495LiqCntLeg = new short[1] ;
      P006P5_A2414LiqFrecPag = new byte[1] ;
      P006P5_A2409LiqModTra = new String[] {""} ;
      P006P5_A2368TLiqDescAux = new String[] {""} ;
      P006P5_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P006P5_A748LiqPerPalabra = new String[] {""} ;
      P006P5_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006P5_A874LiqNombre = new String[] {""} ;
      P006P5_A31LiqNro = new int[1] ;
      P006P6_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P006P6_A3CliCod = new int[1] ;
      P006P6_A1EmpCod = new short[1] ;
      P006P6_A271LiqDescrip = new String[] {""} ;
      P006P6_A2112LiqRelNro = new int[1] ;
      P006P6_n2112LiqRelNro = new boolean[] {false} ;
      P006P6_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P6_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P006P6_A766LiqError = new String[] {""} ;
      P006P6_A495LiqCntLeg = new short[1] ;
      P006P6_A2414LiqFrecPag = new byte[1] ;
      P006P6_A2409LiqModTra = new String[] {""} ;
      P006P6_A2368TLiqDescAux = new String[] {""} ;
      P006P6_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P006P6_A748LiqPerPalabra = new String[] {""} ;
      P006P6_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P006P6_A874LiqNombre = new String[] {""} ;
      P006P6_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006P2_A1729PeriodoLiq, P006P2_A3CliCod, P006P2_A1EmpCod, P006P2_A874LiqNombre, P006P2_A2112LiqRelNro, P006P2_n2112LiqRelNro, P006P2_A496LiqImpNeto, P006P2_A497LiqImpBruto, P006P2_A271LiqDescrip, P006P2_A766LiqError,
            P006P2_A495LiqCntLeg, P006P2_A2414LiqFrecPag, P006P2_A2409LiqModTra, P006P2_A2368TLiqDescAux, P006P2_A280LiqFecPago, P006P2_A748LiqPerPalabra, P006P2_A98LiqFecha, P006P2_A31LiqNro
            }
            , new Object[] {
            P006P3_A1729PeriodoLiq, P006P3_A3CliCod, P006P3_A1EmpCod, P006P3_A748LiqPerPalabra, P006P3_A2112LiqRelNro, P006P3_n2112LiqRelNro, P006P3_A496LiqImpNeto, P006P3_A497LiqImpBruto, P006P3_A271LiqDescrip, P006P3_A766LiqError,
            P006P3_A495LiqCntLeg, P006P3_A2414LiqFrecPag, P006P3_A2409LiqModTra, P006P3_A2368TLiqDescAux, P006P3_A280LiqFecPago, P006P3_A98LiqFecha, P006P3_A874LiqNombre, P006P3_A31LiqNro
            }
            , new Object[] {
            P006P4_A1729PeriodoLiq, P006P4_A3CliCod, P006P4_A1EmpCod, P006P4_A2368TLiqDescAux, P006P4_A2112LiqRelNro, P006P4_n2112LiqRelNro, P006P4_A496LiqImpNeto, P006P4_A497LiqImpBruto, P006P4_A271LiqDescrip, P006P4_A766LiqError,
            P006P4_A495LiqCntLeg, P006P4_A2414LiqFrecPag, P006P4_A2409LiqModTra, P006P4_A280LiqFecPago, P006P4_A748LiqPerPalabra, P006P4_A98LiqFecha, P006P4_A874LiqNombre, P006P4_A31LiqNro
            }
            , new Object[] {
            P006P5_A1729PeriodoLiq, P006P5_A3CliCod, P006P5_A1EmpCod, P006P5_A766LiqError, P006P5_A2112LiqRelNro, P006P5_n2112LiqRelNro, P006P5_A496LiqImpNeto, P006P5_A497LiqImpBruto, P006P5_A271LiqDescrip, P006P5_A495LiqCntLeg,
            P006P5_A2414LiqFrecPag, P006P5_A2409LiqModTra, P006P5_A2368TLiqDescAux, P006P5_A280LiqFecPago, P006P5_A748LiqPerPalabra, P006P5_A98LiqFecha, P006P5_A874LiqNombre, P006P5_A31LiqNro
            }
            , new Object[] {
            P006P6_A1729PeriodoLiq, P006P6_A3CliCod, P006P6_A1EmpCod, P006P6_A271LiqDescrip, P006P6_A2112LiqRelNro, P006P6_n2112LiqRelNro, P006P6_A496LiqImpNeto, P006P6_A497LiqImpBruto, P006P6_A766LiqError, P006P6_A495LiqCntLeg,
            P006P6_A2414LiqFrecPag, P006P6_A2409LiqModTra, P006P6_A2368TLiqDescAux, P006P6_A280LiqFecPago, P006P6_A748LiqPerPalabra, P006P6_A98LiqFecha, P006P6_A874LiqNombre, P006P6_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A2414LiqFrecPag ;
   private short AV57EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV59TFLiqCntLeg ;
   private short AV60TFLiqCntLeg_To ;
   private short AV131Liquidacionwwds_17_tfliqcntleg ;
   private short AV132Liquidacionwwds_18_tfliqcntleg_to ;
   private short A495LiqCntLeg ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV56CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV113GXV1 ;
   private int AV97LiqRelNro ;
   private int AV14TFLiqNro ;
   private int AV15TFLiqNro_To ;
   private int AV116Liquidacionwwds_2_liqrelnro ;
   private int AV117Liquidacionwwds_3_tfliqnro ;
   private int AV118Liquidacionwwds_4_tfliqnro_to ;
   private int AV124Liquidacionwwds_10_tfliqperpalabra_sels_size ;
   private int AV128Liquidacionwwds_14_tftliqdescaux_sels_size ;
   private int AV129Liquidacionwwds_15_tfliqmodtra_sels_size ;
   private int AV130Liquidacionwwds_16_tfliqfrecpag_sels_size ;
   private int AV134Liquidacionwwds_20_tfliqerror_sels_size ;
   private int AV136Liquidacionwwds_22_tfliqdescrip_sels_size ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private long AV46count ;
   private java.math.BigDecimal AV63TFLiqImpBruto ;
   private java.math.BigDecimal AV64TFLiqImpBruto_To ;
   private java.math.BigDecimal AV61TFLiqImpNeto ;
   private java.math.BigDecimal AV62TFLiqImpNeto_To ;
   private java.math.BigDecimal AV137Liquidacionwwds_23_tfliqimpbruto ;
   private java.math.BigDecimal AV138Liquidacionwwds_24_tfliqimpbruto_to ;
   private java.math.BigDecimal AV139Liquidacionwwds_25_tfliqimpneto ;
   private java.math.BigDecimal AV140Liquidacionwwds_26_tfliqimpneto_to ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private String AV76TFLiqPerPalabra ;
   private String AV123Liquidacionwwds_9_tfliqperpalabra ;
   private String scmdbuf ;
   private String lV123Liquidacionwwds_9_tfliqperpalabra ;
   private String A748LiqPerPalabra ;
   private String A2409LiqModTra ;
   private java.util.Date AV18TFLiqFecha ;
   private java.util.Date AV19TFLiqFecha_To ;
   private java.util.Date AV23TFLiqFecPago ;
   private java.util.Date AV24TFLiqFecPago_To ;
   private java.util.Date AV93PeriodoLiq ;
   private java.util.Date AV115Liquidacionwwds_1_periodoliq ;
   private java.util.Date AV121Liquidacionwwds_7_tfliqfecha ;
   private java.util.Date AV122Liquidacionwwds_8_tfliqfecha_to ;
   private java.util.Date AV125Liquidacionwwds_11_tfliqfecpago ;
   private java.util.Date AV126Liquidacionwwds_12_tfliqfecpago_to ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk6P2 ;
   private boolean n2112LiqRelNro ;
   private boolean brk6P4 ;
   private boolean brk6P6 ;
   private boolean brk6P8 ;
   private boolean brk6P10 ;
   private String AV40OptionsJson ;
   private String AV43OptionsDescJson ;
   private String AV45OptionIndexesJson ;
   private String AV75TFLiqPerPalabra_SelsJson ;
   private String AV104TFTLiqDescAux_SelsJson ;
   private String AV107TFLiqModTra_SelsJson ;
   private String AV109TFLiqFrecPag_SelsJson ;
   private String AV78TFLiqError_SelsJson ;
   private String AV65TFLiqDescrip_SelsJson ;
   private String AV36DDOName ;
   private String AV34SearchTxt ;
   private String AV35SearchTxtTo ;
   private String AV82TFLiqNombre ;
   private String AV84TFLiqNombre_Sel ;
   private String AV105TFTLiqDescAux ;
   private String AV79TFLiqError ;
   private String AV16TFLiqDescrip ;
   private String AV96MenuOpcCod ;
   private String A874LiqNombre ;
   private String AV119Liquidacionwwds_5_tfliqnombre ;
   private String AV120Liquidacionwwds_6_tfliqnombre_sel ;
   private String AV127Liquidacionwwds_13_tftliqdescaux ;
   private String AV133Liquidacionwwds_19_tfliqerror ;
   private String AV135Liquidacionwwds_21_tfliqdescrip ;
   private String lV127Liquidacionwwds_13_tftliqdescaux ;
   private String lV133Liquidacionwwds_19_tfliqerror ;
   private String lV135Liquidacionwwds_21_tfliqdescrip ;
   private String A2368TLiqDescAux ;
   private String A766LiqError ;
   private String A271LiqDescrip ;
   private String AV38Option ;
   private GXSimpleCollection<Byte> AV110TFLiqFrecPag_Sels ;
   private GXSimpleCollection<Byte> AV130Liquidacionwwds_16_tfliqfrecpag_sels ;
   private com.genexus.webpanels.WebSession AV47Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P006P2_A1729PeriodoLiq ;
   private int[] P006P2_A3CliCod ;
   private short[] P006P2_A1EmpCod ;
   private String[] P006P2_A874LiqNombre ;
   private int[] P006P2_A2112LiqRelNro ;
   private boolean[] P006P2_n2112LiqRelNro ;
   private java.math.BigDecimal[] P006P2_A496LiqImpNeto ;
   private java.math.BigDecimal[] P006P2_A497LiqImpBruto ;
   private String[] P006P2_A271LiqDescrip ;
   private String[] P006P2_A766LiqError ;
   private short[] P006P2_A495LiqCntLeg ;
   private byte[] P006P2_A2414LiqFrecPag ;
   private String[] P006P2_A2409LiqModTra ;
   private String[] P006P2_A2368TLiqDescAux ;
   private java.util.Date[] P006P2_A280LiqFecPago ;
   private String[] P006P2_A748LiqPerPalabra ;
   private java.util.Date[] P006P2_A98LiqFecha ;
   private int[] P006P2_A31LiqNro ;
   private java.util.Date[] P006P3_A1729PeriodoLiq ;
   private int[] P006P3_A3CliCod ;
   private short[] P006P3_A1EmpCod ;
   private String[] P006P3_A748LiqPerPalabra ;
   private int[] P006P3_A2112LiqRelNro ;
   private boolean[] P006P3_n2112LiqRelNro ;
   private java.math.BigDecimal[] P006P3_A496LiqImpNeto ;
   private java.math.BigDecimal[] P006P3_A497LiqImpBruto ;
   private String[] P006P3_A271LiqDescrip ;
   private String[] P006P3_A766LiqError ;
   private short[] P006P3_A495LiqCntLeg ;
   private byte[] P006P3_A2414LiqFrecPag ;
   private String[] P006P3_A2409LiqModTra ;
   private String[] P006P3_A2368TLiqDescAux ;
   private java.util.Date[] P006P3_A280LiqFecPago ;
   private java.util.Date[] P006P3_A98LiqFecha ;
   private String[] P006P3_A874LiqNombre ;
   private int[] P006P3_A31LiqNro ;
   private java.util.Date[] P006P4_A1729PeriodoLiq ;
   private int[] P006P4_A3CliCod ;
   private short[] P006P4_A1EmpCod ;
   private String[] P006P4_A2368TLiqDescAux ;
   private int[] P006P4_A2112LiqRelNro ;
   private boolean[] P006P4_n2112LiqRelNro ;
   private java.math.BigDecimal[] P006P4_A496LiqImpNeto ;
   private java.math.BigDecimal[] P006P4_A497LiqImpBruto ;
   private String[] P006P4_A271LiqDescrip ;
   private String[] P006P4_A766LiqError ;
   private short[] P006P4_A495LiqCntLeg ;
   private byte[] P006P4_A2414LiqFrecPag ;
   private String[] P006P4_A2409LiqModTra ;
   private java.util.Date[] P006P4_A280LiqFecPago ;
   private String[] P006P4_A748LiqPerPalabra ;
   private java.util.Date[] P006P4_A98LiqFecha ;
   private String[] P006P4_A874LiqNombre ;
   private int[] P006P4_A31LiqNro ;
   private java.util.Date[] P006P5_A1729PeriodoLiq ;
   private int[] P006P5_A3CliCod ;
   private short[] P006P5_A1EmpCod ;
   private String[] P006P5_A766LiqError ;
   private int[] P006P5_A2112LiqRelNro ;
   private boolean[] P006P5_n2112LiqRelNro ;
   private java.math.BigDecimal[] P006P5_A496LiqImpNeto ;
   private java.math.BigDecimal[] P006P5_A497LiqImpBruto ;
   private String[] P006P5_A271LiqDescrip ;
   private short[] P006P5_A495LiqCntLeg ;
   private byte[] P006P5_A2414LiqFrecPag ;
   private String[] P006P5_A2409LiqModTra ;
   private String[] P006P5_A2368TLiqDescAux ;
   private java.util.Date[] P006P5_A280LiqFecPago ;
   private String[] P006P5_A748LiqPerPalabra ;
   private java.util.Date[] P006P5_A98LiqFecha ;
   private String[] P006P5_A874LiqNombre ;
   private int[] P006P5_A31LiqNro ;
   private java.util.Date[] P006P6_A1729PeriodoLiq ;
   private int[] P006P6_A3CliCod ;
   private short[] P006P6_A1EmpCod ;
   private String[] P006P6_A271LiqDescrip ;
   private int[] P006P6_A2112LiqRelNro ;
   private boolean[] P006P6_n2112LiqRelNro ;
   private java.math.BigDecimal[] P006P6_A496LiqImpNeto ;
   private java.math.BigDecimal[] P006P6_A497LiqImpBruto ;
   private String[] P006P6_A766LiqError ;
   private short[] P006P6_A495LiqCntLeg ;
   private byte[] P006P6_A2414LiqFrecPag ;
   private String[] P006P6_A2409LiqModTra ;
   private String[] P006P6_A2368TLiqDescAux ;
   private java.util.Date[] P006P6_A280LiqFecPago ;
   private String[] P006P6_A748LiqPerPalabra ;
   private java.util.Date[] P006P6_A98LiqFecha ;
   private String[] P006P6_A874LiqNombre ;
   private int[] P006P6_A31LiqNro ;
   private GXSimpleCollection<String> AV77TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV108TFLiqModTra_Sels ;
   private GXSimpleCollection<String> AV124Liquidacionwwds_10_tfliqperpalabra_sels ;
   private GXSimpleCollection<String> AV129Liquidacionwwds_15_tfliqmodtra_sels ;
   private GXSimpleCollection<String> AV39Options ;
   private GXSimpleCollection<String> AV42OptionsDesc ;
   private GXSimpleCollection<String> AV44OptionIndexes ;
   private GXSimpleCollection<String> AV106TFTLiqDescAux_Sels ;
   private GXSimpleCollection<String> AV80TFLiqError_Sels ;
   private GXSimpleCollection<String> AV66TFLiqDescrip_Sels ;
   private GXSimpleCollection<String> AV128Liquidacionwwds_14_tftliqdescaux_sels ;
   private GXSimpleCollection<String> AV134Liquidacionwwds_20_tfliqerror_sels ;
   private GXSimpleCollection<String> AV136Liquidacionwwds_22_tfliqdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV49GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV50GridStateFilterValue ;
}

final  class liquidacionwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006P2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV134Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV117Liquidacionwwds_3_tfliqnro ,
                                          int AV118Liquidacionwwds_4_tfliqnro_to ,
                                          String AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV121Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV122Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV124Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV123Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV125Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV128Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV127Liquidacionwwds_13_tftliqdescaux ,
                                          int AV129Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV130Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV131Liquidacionwwds_17_tfliqcntleg ,
                                          short AV132Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV134Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV133Liquidacionwwds_19_tfliqerror ,
                                          int AV136Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV135Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV137Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV139Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          int A2112LiqRelNro ,
                                          int A3CliCod ,
                                          int AV56CliCod ,
                                          short A1EmpCod ,
                                          short AV57EmpCod ,
                                          java.util.Date AV115Liquidacionwwds_1_periodoliq ,
                                          java.util.Date A1729PeriodoLiq )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[20];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT PeriodoLiq, CliCod, EmpCod, LiqNombre, LiqRelNro, LiqImpNeto, LiqImpBruto, LiqDescrip, LiqError, LiqCntLeg, LiqFrecPag, LiqModTra, TLiqDescAux, LiqFecPago," ;
      scmdbuf += " LiqPerPalabra, LiqFecha, LiqNro FROM Liquidacion" ;
      addWhere(sWhereString, "(PeriodoLiq = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (0==AV117Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV118Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV123Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV124Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV125Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV126Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV127Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV128Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV129Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV129Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV130Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV130Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV131Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV132Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ( AV134Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV133Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( AV134Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV134Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV135Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV136Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV137Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV138Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV139Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV140Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PeriodoLiq, LiqNombre" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006P3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV134Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV117Liquidacionwwds_3_tfliqnro ,
                                          int AV118Liquidacionwwds_4_tfliqnro_to ,
                                          String AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV121Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV122Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV124Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV123Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV125Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV128Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV127Liquidacionwwds_13_tftliqdescaux ,
                                          int AV129Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV130Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV131Liquidacionwwds_17_tfliqcntleg ,
                                          short AV132Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV134Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV133Liquidacionwwds_19_tfliqerror ,
                                          int AV136Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV135Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV137Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV139Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          int A2112LiqRelNro ,
                                          int A3CliCod ,
                                          int AV56CliCod ,
                                          short A1EmpCod ,
                                          short AV57EmpCod ,
                                          java.util.Date AV115Liquidacionwwds_1_periodoliq ,
                                          java.util.Date A1729PeriodoLiq )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[20];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT PeriodoLiq, CliCod, EmpCod, LiqPerPalabra, LiqRelNro, LiqImpNeto, LiqImpBruto, LiqDescrip, LiqError, LiqCntLeg, LiqFrecPag, LiqModTra, TLiqDescAux, LiqFecPago," ;
      scmdbuf += " LiqFecha, LiqNombre, LiqNro FROM Liquidacion" ;
      addWhere(sWhereString, "(PeriodoLiq = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (0==AV117Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV118Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV123Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV124Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV125Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV126Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV127Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV128Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV129Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV129Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV130Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV130Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV131Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (0==AV132Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ( AV134Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV133Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( AV134Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV134Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV135Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      if ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV136Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV137Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int11[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV138Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int11[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV139Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int11[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV140Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int11[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PeriodoLiq, LiqPerPalabra" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006P4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV134Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV117Liquidacionwwds_3_tfliqnro ,
                                          int AV118Liquidacionwwds_4_tfliqnro_to ,
                                          String AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV121Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV122Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV124Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV123Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV125Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV128Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV127Liquidacionwwds_13_tftliqdescaux ,
                                          int AV129Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV130Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV131Liquidacionwwds_17_tfliqcntleg ,
                                          short AV132Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV134Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV133Liquidacionwwds_19_tfliqerror ,
                                          int AV136Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV135Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV137Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV139Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          int A2112LiqRelNro ,
                                          int A3CliCod ,
                                          int AV56CliCod ,
                                          short A1EmpCod ,
                                          short AV57EmpCod ,
                                          java.util.Date AV115Liquidacionwwds_1_periodoliq ,
                                          java.util.Date A1729PeriodoLiq )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[20];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT PeriodoLiq, CliCod, EmpCod, TLiqDescAux, LiqRelNro, LiqImpNeto, LiqImpBruto, LiqDescrip, LiqError, LiqCntLeg, LiqFrecPag, LiqModTra, LiqFecPago, LiqPerPalabra," ;
      scmdbuf += " LiqFecha, LiqNombre, LiqNro FROM Liquidacion" ;
      addWhere(sWhereString, "(PeriodoLiq = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (0==AV117Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( ! (0==AV118Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV123Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV124Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV125Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV126Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int14[10] = (byte)(1) ;
      }
      if ( ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV127Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int14[11] = (byte)(1) ;
      }
      if ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV128Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV129Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV129Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV130Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV130Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV131Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int14[12] = (byte)(1) ;
      }
      if ( ! (0==AV132Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int14[13] = (byte)(1) ;
      }
      if ( ( AV134Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV133Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int14[14] = (byte)(1) ;
      }
      if ( AV134Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV134Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV135Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[15] = (byte)(1) ;
      }
      if ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV136Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV137Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int14[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV138Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int14[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV139Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int14[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV140Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int14[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PeriodoLiq, TLiqDescAux" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P006P5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV134Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV117Liquidacionwwds_3_tfliqnro ,
                                          int AV118Liquidacionwwds_4_tfliqnro_to ,
                                          String AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV121Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV122Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV124Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV123Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV125Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV128Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV127Liquidacionwwds_13_tftliqdescaux ,
                                          int AV129Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV130Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV131Liquidacionwwds_17_tfliqcntleg ,
                                          short AV132Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV134Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV133Liquidacionwwds_19_tfliqerror ,
                                          int AV136Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV135Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV137Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV139Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          int A2112LiqRelNro ,
                                          int A3CliCod ,
                                          int AV56CliCod ,
                                          short A1EmpCod ,
                                          short AV57EmpCod ,
                                          java.util.Date AV115Liquidacionwwds_1_periodoliq ,
                                          java.util.Date A1729PeriodoLiq )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[20];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT PeriodoLiq, CliCod, EmpCod, LiqError, LiqRelNro, LiqImpNeto, LiqImpBruto, LiqDescrip, LiqCntLeg, LiqFrecPag, LiqModTra, TLiqDescAux, LiqFecPago, LiqPerPalabra," ;
      scmdbuf += " LiqFecha, LiqNombre, LiqNro FROM Liquidacion" ;
      addWhere(sWhereString, "(PeriodoLiq = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (0==AV117Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( ! (0==AV118Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV123Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int17[8] = (byte)(1) ;
      }
      if ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV124Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV125Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int17[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV126Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int17[10] = (byte)(1) ;
      }
      if ( ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV127Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int17[11] = (byte)(1) ;
      }
      if ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV128Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV129Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV129Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV130Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV130Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV131Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int17[12] = (byte)(1) ;
      }
      if ( ! (0==AV132Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int17[13] = (byte)(1) ;
      }
      if ( ( AV134Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV133Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int17[14] = (byte)(1) ;
      }
      if ( AV134Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV134Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV135Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int17[15] = (byte)(1) ;
      }
      if ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV136Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV137Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int17[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV138Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int17[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV139Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int17[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV140Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int17[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PeriodoLiq, LiqError" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P006P6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV124Liquidacionwwds_10_tfliqperpalabra_sels ,
                                          String A2368TLiqDescAux ,
                                          GXSimpleCollection<String> AV128Liquidacionwwds_14_tftliqdescaux_sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV129Liquidacionwwds_15_tfliqmodtra_sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV130Liquidacionwwds_16_tfliqfrecpag_sels ,
                                          String A766LiqError ,
                                          GXSimpleCollection<String> AV134Liquidacionwwds_20_tfliqerror_sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV136Liquidacionwwds_22_tfliqdescrip_sels ,
                                          int AV117Liquidacionwwds_3_tfliqnro ,
                                          int AV118Liquidacionwwds_4_tfliqnro_to ,
                                          String AV120Liquidacionwwds_6_tfliqnombre_sel ,
                                          java.util.Date AV121Liquidacionwwds_7_tfliqfecha ,
                                          java.util.Date AV122Liquidacionwwds_8_tfliqfecha_to ,
                                          int AV124Liquidacionwwds_10_tfliqperpalabra_sels_size ,
                                          String AV123Liquidacionwwds_9_tfliqperpalabra ,
                                          java.util.Date AV125Liquidacionwwds_11_tfliqfecpago ,
                                          java.util.Date AV126Liquidacionwwds_12_tfliqfecpago_to ,
                                          int AV128Liquidacionwwds_14_tftliqdescaux_sels_size ,
                                          String AV127Liquidacionwwds_13_tftliqdescaux ,
                                          int AV129Liquidacionwwds_15_tfliqmodtra_sels_size ,
                                          int AV130Liquidacionwwds_16_tfliqfrecpag_sels_size ,
                                          short AV131Liquidacionwwds_17_tfliqcntleg ,
                                          short AV132Liquidacionwwds_18_tfliqcntleg_to ,
                                          int AV134Liquidacionwwds_20_tfliqerror_sels_size ,
                                          String AV133Liquidacionwwds_19_tfliqerror ,
                                          int AV136Liquidacionwwds_22_tfliqdescrip_sels_size ,
                                          String AV135Liquidacionwwds_21_tfliqdescrip ,
                                          java.math.BigDecimal AV137Liquidacionwwds_23_tfliqimpbruto ,
                                          java.math.BigDecimal AV138Liquidacionwwds_24_tfliqimpbruto_to ,
                                          java.math.BigDecimal AV139Liquidacionwwds_25_tfliqimpneto ,
                                          java.math.BigDecimal AV140Liquidacionwwds_26_tfliqimpneto_to ,
                                          int A31LiqNro ,
                                          String A874LiqNombre ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          short A495LiqCntLeg ,
                                          java.math.BigDecimal A497LiqImpBruto ,
                                          java.math.BigDecimal A496LiqImpNeto ,
                                          int A2112LiqRelNro ,
                                          int A3CliCod ,
                                          int AV56CliCod ,
                                          short A1EmpCod ,
                                          short AV57EmpCod ,
                                          java.util.Date AV115Liquidacionwwds_1_periodoliq ,
                                          java.util.Date A1729PeriodoLiq )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int20 = new byte[20];
      Object[] GXv_Object21 = new Object[2];
      scmdbuf = "SELECT PeriodoLiq, CliCod, EmpCod, LiqDescrip, LiqRelNro, LiqImpNeto, LiqImpBruto, LiqError, LiqCntLeg, LiqFrecPag, LiqModTra, TLiqDescAux, LiqFecPago, LiqPerPalabra," ;
      scmdbuf += " LiqFecha, LiqNombre, LiqNro FROM Liquidacion" ;
      addWhere(sWhereString, "(PeriodoLiq = ?)");
      addWhere(sWhereString, "(LiqRelNro IS NULL)");
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (0==AV117Liquidacionwwds_3_tfliqnro) )
      {
         addWhere(sWhereString, "(LiqNro >= ?)");
      }
      else
      {
         GXv_int20[3] = (byte)(1) ;
      }
      if ( ! (0==AV118Liquidacionwwds_4_tfliqnro_to) )
      {
         addWhere(sWhereString, "(LiqNro <= ?)");
      }
      else
      {
         GXv_int20[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV120Liquidacionwwds_6_tfliqnombre_sel)==0) )
      {
         addWhere(sWhereString, "(LiqNombre = ( ?))");
      }
      else
      {
         GXv_int20[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV121Liquidacionwwds_7_tfliqfecha)) )
      {
         addWhere(sWhereString, "(LiqFecha >= ?)");
      }
      else
      {
         GXv_int20[6] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV122Liquidacionwwds_8_tfliqfecha_to)) )
      {
         addWhere(sWhereString, "(LiqFecha <= ?)");
      }
      else
      {
         GXv_int20[7] = (byte)(1) ;
      }
      if ( ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV123Liquidacionwwds_9_tfliqperpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int20[8] = (byte)(1) ;
      }
      if ( AV124Liquidacionwwds_10_tfliqperpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV124Liquidacionwwds_10_tfliqperpalabra_sels, "LiqPerPalabra IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV125Liquidacionwwds_11_tfliqfecpago)) )
      {
         addWhere(sWhereString, "(LiqFecPago >= ?)");
      }
      else
      {
         GXv_int20[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV126Liquidacionwwds_12_tfliqfecpago_to)) )
      {
         addWhere(sWhereString, "(LiqFecPago <= ?)");
      }
      else
      {
         GXv_int20[10] = (byte)(1) ;
      }
      if ( ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV127Liquidacionwwds_13_tftliqdescaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqDescAux) like LOWER(?))");
      }
      else
      {
         GXv_int20[11] = (byte)(1) ;
      }
      if ( AV128Liquidacionwwds_14_tftliqdescaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV128Liquidacionwwds_14_tftliqdescaux_sels, "TLiqDescAux IN (", ")")+")");
      }
      if ( AV129Liquidacionwwds_15_tfliqmodtra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV129Liquidacionwwds_15_tfliqmodtra_sels, "LiqModTra IN (", ")")+")");
      }
      if ( AV130Liquidacionwwds_16_tfliqfrecpag_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV130Liquidacionwwds_16_tfliqfrecpag_sels, "LiqFrecPag IN (", ")")+")");
      }
      if ( ! (0==AV131Liquidacionwwds_17_tfliqcntleg) )
      {
         addWhere(sWhereString, "(LiqCntLeg >= ?)");
      }
      else
      {
         GXv_int20[12] = (byte)(1) ;
      }
      if ( ! (0==AV132Liquidacionwwds_18_tfliqcntleg_to) )
      {
         addWhere(sWhereString, "(LiqCntLeg <= ?)");
      }
      else
      {
         GXv_int20[13] = (byte)(1) ;
      }
      if ( ( AV134Liquidacionwwds_20_tfliqerror_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV133Liquidacionwwds_19_tfliqerror)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqError) like LOWER(?))");
      }
      else
      {
         GXv_int20[14] = (byte)(1) ;
      }
      if ( AV134Liquidacionwwds_20_tfliqerror_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV134Liquidacionwwds_20_tfliqerror_sels, "LiqError IN (", ")")+")");
      }
      if ( ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV135Liquidacionwwds_21_tfliqdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int20[15] = (byte)(1) ;
      }
      if ( AV136Liquidacionwwds_22_tfliqdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV136Liquidacionwwds_22_tfliqdescrip_sels, "LiqDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV137Liquidacionwwds_23_tfliqimpbruto)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto >= ?)");
      }
      else
      {
         GXv_int20[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV138Liquidacionwwds_24_tfliqimpbruto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpBruto <= ?)");
      }
      else
      {
         GXv_int20[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV139Liquidacionwwds_25_tfliqimpneto)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto >= ?)");
      }
      else
      {
         GXv_int20[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV140Liquidacionwwds_26_tfliqimpneto_to)==0) )
      {
         addWhere(sWhereString, "(LiqImpNeto <= ?)");
      }
      else
      {
         GXv_int20[19] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PeriodoLiq, LiqDescrip" ;
      GXv_Object21[0] = scmdbuf ;
      GXv_Object21[1] = GXv_int20 ;
      return GXv_Object21 ;
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
                  return conditional_P006P2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).shortValue() , (java.util.Date)dynConstraints[47] , (java.util.Date)dynConstraints[48] );
            case 1 :
                  return conditional_P006P3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).shortValue() , (java.util.Date)dynConstraints[47] , (java.util.Date)dynConstraints[48] );
            case 2 :
                  return conditional_P006P4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).shortValue() , (java.util.Date)dynConstraints[47] , (java.util.Date)dynConstraints[48] );
            case 3 :
                  return conditional_P006P5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).shortValue() , (java.util.Date)dynConstraints[47] , (java.util.Date)dynConstraints[48] );
            case 4 :
                  return conditional_P006P6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , (String)dynConstraints[14] , (java.util.Date)dynConstraints[15] , (java.util.Date)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , ((Number) dynConstraints[26]).shortValue() , ((Number) dynConstraints[27]).intValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , ((Number) dynConstraints[35]).intValue() , (String)dynConstraints[36] , (java.util.Date)dynConstraints[37] , (java.util.Date)dynConstraints[38] , ((Number) dynConstraints[39]).shortValue() , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).shortValue() , ((Number) dynConstraints[46]).shortValue() , (java.util.Date)dynConstraints[47] , (java.util.Date)dynConstraints[48] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006P2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006P3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006P4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006P5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006P6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((byte[]) buf[11])[0] = rslt.getByte(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((byte[]) buf[11])[0] = rslt.getByte(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(15);
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((byte[]) buf[11])[0] = rslt.getByte(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(15);
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(15);
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(15);
               ((String[]) buf[16])[0] = rslt.getVarchar(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
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
                  stmt.setDate(sIdx, (java.util.Date)parms[20]);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 30);
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
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[20]);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 30);
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
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[20]);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 30);
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
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[20]);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 30);
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
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[20]);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[22]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[23]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 400);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[26]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[28], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[29]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[30]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 30);
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
                  stmt.setVarchar(sIdx, (String)parms[34], 400);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 400);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               return;
      }
   }

}

