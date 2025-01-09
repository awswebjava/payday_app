package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacioneswcgetfilterdata extends GXProcedure
{
   public liquidacioneswcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacioneswcgetfilterdata.class ), "" );
   }

   public liquidacioneswcgetfilterdata( int remoteHandle ,
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
      liquidacioneswcgetfilterdata.this.aP5 = new String[] {""};
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
      liquidacioneswcgetfilterdata.this.AV50DDOName = aP0;
      liquidacioneswcgetfilterdata.this.AV51SearchTxt = aP1;
      liquidacioneswcgetfilterdata.this.AV52SearchTxtTo = aP2;
      liquidacioneswcgetfilterdata.this.aP3 = aP3;
      liquidacioneswcgetfilterdata.this.aP4 = aP4;
      liquidacioneswcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajos", GXv_boolean2) ;
      liquidacioneswcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_LIQPERPALABRA") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQPERPALABRAOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_LIQNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQNOMBREOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV50DDOName), "DDO_TLIQCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADTLIQCODOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV53OptionsJson = AV40Options.toJSonString(false) ;
      AV54OptionsDescJson = AV42OptionsDesc.toJSonString(false) ;
      AV55OptionIndexesJson = AV43OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV45Session.getValue("liquidacionesWCGridState"), "") == 0 )
      {
         AV47GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "liquidacionesWCGridState"), null, null);
      }
      else
      {
         AV47GridState.fromxml(AV45Session.getValue("liquidacionesWCGridState"), null, null);
      }
      AV66GXV1 = 1 ;
      while ( AV66GXV1 <= AV47GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV48GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV47GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV66GXV1));
         if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV11TFLiqNro = (int)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFLiqNro_To = (int)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV13TFLiqFecha = localUtil.ctod( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV14TFLiqFecha_To = localUtil.ctod( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV16TFLiqPerPalabra = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV15TFLiqPerPalabra_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFLiqPerPalabra_Sels.fromJSonString(AV15TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV19TFLiqNombre = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV18TFLiqNombre_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFLiqNombre_Sels.fromJSonString(AV18TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV21TFLiqFecPago = localUtil.ctod( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV22TFLiqFecPago_To = localUtil.ctod( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV24TFTLiqCod = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV23TFTLiqCod_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV25TFTLiqCod_Sels.fromJSonString(AV23TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQMODTRA_SEL") == 0 )
         {
            AV60TFLiqModTra_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV61TFLiqModTra_Sels.fromJSonString(AV60TFLiqModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFRECPAG_SEL") == 0 )
         {
            AV62TFLiqFrecPag_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV63TFLiqFrecPag_Sels.fromJSonString(AV62TFLiqFrecPag_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV28TFLiqLegImpBasico = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV29TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV30TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV31TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUPROM") == 0 )
         {
            AV32TFLiqLegImpTotBruProm = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV33TFLiqLegImpTotBruProm_To = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV34TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV35TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV36TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV37TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV56CliCod = (int)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV57EmpCod = (short)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV59LegNumero = (int)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV66GXV1 = (int)(AV66GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLIQPERPALABRAOPTIONS' Routine */
      returnInSub = false ;
      AV16TFLiqPerPalabra = AV51SearchTxt ;
      AV17TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV17TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV20TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV25TFTLiqCod_Sels ,
                                           A2409LiqModTra ,
                                           AV61TFLiqModTra_Sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV63TFLiqFrecPag_Sels ,
                                           Integer.valueOf(AV11TFLiqNro) ,
                                           Integer.valueOf(AV12TFLiqNro_To) ,
                                           AV13TFLiqFecha ,
                                           AV14TFLiqFecha_To ,
                                           Integer.valueOf(AV17TFLiqPerPalabra_Sels.size()) ,
                                           AV16TFLiqPerPalabra ,
                                           Integer.valueOf(AV20TFLiqNombre_Sels.size()) ,
                                           AV19TFLiqNombre ,
                                           AV21TFLiqFecPago ,
                                           AV22TFLiqFecPago_To ,
                                           Integer.valueOf(AV25TFTLiqCod_Sels.size()) ,
                                           AV24TFTLiqCod ,
                                           Integer.valueOf(AV61TFLiqModTra_Sels.size()) ,
                                           Integer.valueOf(AV63TFLiqFrecPag_Sels.size()) ,
                                           AV28TFLiqLegImpBasico ,
                                           AV29TFLiqLegImpBasico_To ,
                                           AV30TFLiqLegImpTotBruto ,
                                           AV31TFLiqLegImpTotBruto_To ,
                                           AV32TFLiqLegImpTotBruProm ,
                                           AV33TFLiqLegImpTotBruProm_To ,
                                           AV34TFLiqLegImpTotBruSinSAC ,
                                           AV35TFLiqLegImpTotBruSinSAC_To ,
                                           AV36TFLiqLegImpTotRetGan ,
                                           AV37TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           Integer.valueOf(AV59LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV16TFLiqPerPalabra), 20, "%") ;
      lV19TFLiqNombre = GXutil.concat( GXutil.rtrim( AV19TFLiqNombre), "%", "") ;
      lV24TFTLiqCod = GXutil.concat( GXutil.rtrim( AV24TFTLiqCod), "%", "") ;
      /* Using cursor P01QO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV59LegNumero), Integer.valueOf(AV11TFLiqNro), Integer.valueOf(AV12TFLiqNro_To), AV13TFLiqFecha, AV14TFLiqFecha_To, lV16TFLiqPerPalabra, lV19TFLiqNombre, AV21TFLiqFecPago, AV22TFLiqFecPago_To, lV24TFTLiqCod, AV28TFLiqLegImpBasico, AV29TFLiqLegImpBasico_To, AV30TFLiqLegImpTotBruto, AV31TFLiqLegImpTotBruto_To, AV32TFLiqLegImpTotBruProm, AV33TFLiqLegImpTotBruProm_To, AV34TFLiqLegImpTotBruSinSAC, AV35TFLiqLegImpTotBruSinSAC_To, AV36TFLiqLegImpTotRetGan, AV37TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1QO2 = false ;
         A3CliCod = P01QO2_A3CliCod[0] ;
         A1EmpCod = P01QO2_A1EmpCod[0] ;
         A6LegNumero = P01QO2_A6LegNumero[0] ;
         A748LiqPerPalabra = P01QO2_A748LiqPerPalabra[0] ;
         A757LiqLegImpTotRetGan = P01QO2_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P01QO2_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P01QO2_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P01QO2_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P01QO2_A760LiqLegImpBasico[0] ;
         A2414LiqFrecPag = P01QO2_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QO2_A2409LiqModTra[0] ;
         A32TLiqCod = P01QO2_A32TLiqCod[0] ;
         n32TLiqCod = P01QO2_n32TLiqCod[0] ;
         A340TliqDesc = P01QO2_A340TliqDesc[0] ;
         A280LiqFecPago = P01QO2_A280LiqFecPago[0] ;
         A874LiqNombre = P01QO2_A874LiqNombre[0] ;
         A98LiqFecha = P01QO2_A98LiqFecha[0] ;
         A31LiqNro = P01QO2_A31LiqNro[0] ;
         A340TliqDesc = P01QO2_A340TliqDesc[0] ;
         A748LiqPerPalabra = P01QO2_A748LiqPerPalabra[0] ;
         A2414LiqFrecPag = P01QO2_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QO2_A2409LiqModTra[0] ;
         A280LiqFecPago = P01QO2_A280LiqFecPago[0] ;
         A874LiqNombre = P01QO2_A874LiqNombre[0] ;
         A98LiqFecha = P01QO2_A98LiqFecha[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01QO2_A3CliCod[0] == A3CliCod ) && ( P01QO2_A1EmpCod[0] == A1EmpCod ) && ( P01QO2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01QO2_A748LiqPerPalabra[0], A748LiqPerPalabra) == 0 ) )
         {
            brk1QO2 = false ;
            A31LiqNro = P01QO2_A31LiqNro[0] ;
            AV44count = (long)(AV44count+1) ;
            brk1QO2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A748LiqPerPalabra)==0) )
         {
            AV39Option = A748LiqPerPalabra ;
            AV40Options.add(AV39Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1QO2 )
         {
            brk1QO2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLIQNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV19TFLiqNombre = AV51SearchTxt ;
      AV20TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV17TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV20TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV25TFTLiqCod_Sels ,
                                           A2409LiqModTra ,
                                           AV61TFLiqModTra_Sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV63TFLiqFrecPag_Sels ,
                                           Integer.valueOf(AV11TFLiqNro) ,
                                           Integer.valueOf(AV12TFLiqNro_To) ,
                                           AV13TFLiqFecha ,
                                           AV14TFLiqFecha_To ,
                                           Integer.valueOf(AV17TFLiqPerPalabra_Sels.size()) ,
                                           AV16TFLiqPerPalabra ,
                                           Integer.valueOf(AV20TFLiqNombre_Sels.size()) ,
                                           AV19TFLiqNombre ,
                                           AV21TFLiqFecPago ,
                                           AV22TFLiqFecPago_To ,
                                           Integer.valueOf(AV25TFTLiqCod_Sels.size()) ,
                                           AV24TFTLiqCod ,
                                           Integer.valueOf(AV61TFLiqModTra_Sels.size()) ,
                                           Integer.valueOf(AV63TFLiqFrecPag_Sels.size()) ,
                                           AV28TFLiqLegImpBasico ,
                                           AV29TFLiqLegImpBasico_To ,
                                           AV30TFLiqLegImpTotBruto ,
                                           AV31TFLiqLegImpTotBruto_To ,
                                           AV32TFLiqLegImpTotBruProm ,
                                           AV33TFLiqLegImpTotBruProm_To ,
                                           AV34TFLiqLegImpTotBruSinSAC ,
                                           AV35TFLiqLegImpTotBruSinSAC_To ,
                                           AV36TFLiqLegImpTotRetGan ,
                                           AV37TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           Integer.valueOf(AV59LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV16TFLiqPerPalabra), 20, "%") ;
      lV19TFLiqNombre = GXutil.concat( GXutil.rtrim( AV19TFLiqNombre), "%", "") ;
      lV24TFTLiqCod = GXutil.concat( GXutil.rtrim( AV24TFTLiqCod), "%", "") ;
      /* Using cursor P01QO3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV59LegNumero), Integer.valueOf(AV11TFLiqNro), Integer.valueOf(AV12TFLiqNro_To), AV13TFLiqFecha, AV14TFLiqFecha_To, lV16TFLiqPerPalabra, lV19TFLiqNombre, AV21TFLiqFecPago, AV22TFLiqFecPago_To, lV24TFTLiqCod, AV28TFLiqLegImpBasico, AV29TFLiqLegImpBasico_To, AV30TFLiqLegImpTotBruto, AV31TFLiqLegImpTotBruto_To, AV32TFLiqLegImpTotBruProm, AV33TFLiqLegImpTotBruProm_To, AV34TFLiqLegImpTotBruSinSAC, AV35TFLiqLegImpTotBruSinSAC_To, AV36TFLiqLegImpTotRetGan, AV37TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1QO4 = false ;
         A3CliCod = P01QO3_A3CliCod[0] ;
         A1EmpCod = P01QO3_A1EmpCod[0] ;
         A6LegNumero = P01QO3_A6LegNumero[0] ;
         A874LiqNombre = P01QO3_A874LiqNombre[0] ;
         A757LiqLegImpTotRetGan = P01QO3_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P01QO3_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P01QO3_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P01QO3_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P01QO3_A760LiqLegImpBasico[0] ;
         A2414LiqFrecPag = P01QO3_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QO3_A2409LiqModTra[0] ;
         A32TLiqCod = P01QO3_A32TLiqCod[0] ;
         n32TLiqCod = P01QO3_n32TLiqCod[0] ;
         A340TliqDesc = P01QO3_A340TliqDesc[0] ;
         A280LiqFecPago = P01QO3_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P01QO3_A748LiqPerPalabra[0] ;
         A98LiqFecha = P01QO3_A98LiqFecha[0] ;
         A31LiqNro = P01QO3_A31LiqNro[0] ;
         A340TliqDesc = P01QO3_A340TliqDesc[0] ;
         A874LiqNombre = P01QO3_A874LiqNombre[0] ;
         A2414LiqFrecPag = P01QO3_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QO3_A2409LiqModTra[0] ;
         A280LiqFecPago = P01QO3_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P01QO3_A748LiqPerPalabra[0] ;
         A98LiqFecha = P01QO3_A98LiqFecha[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01QO3_A3CliCod[0] == A3CliCod ) && ( P01QO3_A1EmpCod[0] == A1EmpCod ) && ( P01QO3_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01QO3_A874LiqNombre[0], A874LiqNombre) == 0 ) )
         {
            brk1QO4 = false ;
            A31LiqNro = P01QO3_A31LiqNro[0] ;
            AV44count = (long)(AV44count+1) ;
            brk1QO4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A874LiqNombre)==0) )
         {
            AV39Option = A874LiqNombre ;
            AV40Options.add(AV39Option, 0);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1QO4 )
         {
            brk1QO4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADTLIQCODOPTIONS' Routine */
      returnInSub = false ;
      AV24TFTLiqCod = AV51SearchTxt ;
      AV25TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV17TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV20TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV25TFTLiqCod_Sels ,
                                           A2409LiqModTra ,
                                           AV61TFLiqModTra_Sels ,
                                           Byte.valueOf(A2414LiqFrecPag) ,
                                           AV63TFLiqFrecPag_Sels ,
                                           Integer.valueOf(AV11TFLiqNro) ,
                                           Integer.valueOf(AV12TFLiqNro_To) ,
                                           AV13TFLiqFecha ,
                                           AV14TFLiqFecha_To ,
                                           Integer.valueOf(AV17TFLiqPerPalabra_Sels.size()) ,
                                           AV16TFLiqPerPalabra ,
                                           Integer.valueOf(AV20TFLiqNombre_Sels.size()) ,
                                           AV19TFLiqNombre ,
                                           AV21TFLiqFecPago ,
                                           AV22TFLiqFecPago_To ,
                                           Integer.valueOf(AV25TFTLiqCod_Sels.size()) ,
                                           AV24TFTLiqCod ,
                                           Integer.valueOf(AV61TFLiqModTra_Sels.size()) ,
                                           Integer.valueOf(AV63TFLiqFrecPag_Sels.size()) ,
                                           AV28TFLiqLegImpBasico ,
                                           AV29TFLiqLegImpBasico_To ,
                                           AV30TFLiqLegImpTotBruto ,
                                           AV31TFLiqLegImpTotBruto_To ,
                                           AV32TFLiqLegImpTotBruProm ,
                                           AV33TFLiqLegImpTotBruProm_To ,
                                           AV34TFLiqLegImpTotBruSinSAC ,
                                           AV35TFLiqLegImpTotBruSinSAC_To ,
                                           AV36TFLiqLegImpTotRetGan ,
                                           AV37TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Integer.valueOf(AV56CliCod) ,
                                           Short.valueOf(AV57EmpCod) ,
                                           Integer.valueOf(AV59LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV16TFLiqPerPalabra), 20, "%") ;
      lV19TFLiqNombre = GXutil.concat( GXutil.rtrim( AV19TFLiqNombre), "%", "") ;
      lV24TFTLiqCod = GXutil.concat( GXutil.rtrim( AV24TFTLiqCod), "%", "") ;
      /* Using cursor P01QO4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV56CliCod), Short.valueOf(AV57EmpCod), Integer.valueOf(AV59LegNumero), Integer.valueOf(AV11TFLiqNro), Integer.valueOf(AV12TFLiqNro_To), AV13TFLiqFecha, AV14TFLiqFecha_To, lV16TFLiqPerPalabra, lV19TFLiqNombre, AV21TFLiqFecPago, AV22TFLiqFecPago_To, lV24TFTLiqCod, AV28TFLiqLegImpBasico, AV29TFLiqLegImpBasico_To, AV30TFLiqLegImpTotBruto, AV31TFLiqLegImpTotBruto_To, AV32TFLiqLegImpTotBruProm, AV33TFLiqLegImpTotBruProm_To, AV34TFLiqLegImpTotBruSinSAC, AV35TFLiqLegImpTotBruSinSAC_To, AV36TFLiqLegImpTotRetGan, AV37TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1QO6 = false ;
         A32TLiqCod = P01QO4_A32TLiqCod[0] ;
         n32TLiqCod = P01QO4_n32TLiqCod[0] ;
         A6LegNumero = P01QO4_A6LegNumero[0] ;
         A1EmpCod = P01QO4_A1EmpCod[0] ;
         A3CliCod = P01QO4_A3CliCod[0] ;
         A757LiqLegImpTotRetGan = P01QO4_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P01QO4_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P01QO4_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P01QO4_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P01QO4_A760LiqLegImpBasico[0] ;
         A2414LiqFrecPag = P01QO4_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QO4_A2409LiqModTra[0] ;
         A340TliqDesc = P01QO4_A340TliqDesc[0] ;
         A280LiqFecPago = P01QO4_A280LiqFecPago[0] ;
         A874LiqNombre = P01QO4_A874LiqNombre[0] ;
         A748LiqPerPalabra = P01QO4_A748LiqPerPalabra[0] ;
         A98LiqFecha = P01QO4_A98LiqFecha[0] ;
         A31LiqNro = P01QO4_A31LiqNro[0] ;
         A340TliqDesc = P01QO4_A340TliqDesc[0] ;
         A2414LiqFrecPag = P01QO4_A2414LiqFrecPag[0] ;
         A2409LiqModTra = P01QO4_A2409LiqModTra[0] ;
         A280LiqFecPago = P01QO4_A280LiqFecPago[0] ;
         A874LiqNombre = P01QO4_A874LiqNombre[0] ;
         A748LiqPerPalabra = P01QO4_A748LiqPerPalabra[0] ;
         A98LiqFecha = P01QO4_A98LiqFecha[0] ;
         AV44count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P01QO4_A3CliCod[0] == A3CliCod ) && ( P01QO4_A1EmpCod[0] == A1EmpCod ) && ( P01QO4_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01QO4_A32TLiqCod[0], A32TLiqCod) == 0 ) )
         {
            brk1QO6 = false ;
            A31LiqNro = P01QO4_A31LiqNro[0] ;
            AV44count = (long)(AV44count+1) ;
            brk1QO6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A340TliqDesc)==0) )
         {
            AV39Option = A32TLiqCod ;
            AV41OptionDesc = A340TliqDesc ;
            AV38InsertIndex = 1 ;
            while ( ( AV38InsertIndex <= AV40Options.size() ) && ( GXutil.strcmp((String)AV42OptionsDesc.elementAt(-1+AV38InsertIndex), AV41OptionDesc) < 0 ) )
            {
               AV38InsertIndex = (int)(AV38InsertIndex+1) ;
            }
            AV40Options.add(AV39Option, AV38InsertIndex);
            AV42OptionsDesc.add(AV41OptionDesc, AV38InsertIndex);
            AV43OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV44count), "Z,ZZZ,ZZZ,ZZ9")), AV38InsertIndex);
         }
         if ( AV40Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1QO6 )
         {
            brk1QO6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = liquidacioneswcgetfilterdata.this.AV53OptionsJson;
      this.aP4[0] = liquidacioneswcgetfilterdata.this.AV54OptionsDescJson;
      this.aP5[0] = liquidacioneswcgetfilterdata.this.AV55OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV53OptionsJson = "" ;
      AV54OptionsDescJson = "" ;
      AV55OptionIndexesJson = "" ;
      AV40Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV45Session = httpContext.getWebSession();
      AV47GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV48GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV13TFLiqFecha = GXutil.nullDate() ;
      AV14TFLiqFecha_To = GXutil.nullDate() ;
      AV16TFLiqPerPalabra = "" ;
      AV15TFLiqPerPalabra_SelsJson = "" ;
      AV17TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFLiqNombre = "" ;
      AV18TFLiqNombre_SelsJson = "" ;
      AV20TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFLiqFecPago = GXutil.nullDate() ;
      AV22TFLiqFecPago_To = GXutil.nullDate() ;
      AV24TFTLiqCod = "" ;
      AV23TFTLiqCod_SelsJson = "" ;
      AV25TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60TFLiqModTra_SelsJson = "" ;
      AV61TFLiqModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62TFLiqFrecPag_SelsJson = "" ;
      AV63TFLiqFrecPag_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV28TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV29TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV30TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV31TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV32TFLiqLegImpTotBruProm = DecimalUtil.ZERO ;
      AV33TFLiqLegImpTotBruProm_To = DecimalUtil.ZERO ;
      AV34TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV35TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV36TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV37TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV16TFLiqPerPalabra = "" ;
      lV19TFLiqNombre = "" ;
      lV24TFTLiqCod = "" ;
      A748LiqPerPalabra = "" ;
      A874LiqNombre = "" ;
      A32TLiqCod = "" ;
      A2409LiqModTra = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      A340TliqDesc = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      P01QO2_A3CliCod = new int[1] ;
      P01QO2_A1EmpCod = new short[1] ;
      P01QO2_A6LegNumero = new int[1] ;
      P01QO2_A748LiqPerPalabra = new String[] {""} ;
      P01QO2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO2_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO2_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO2_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO2_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO2_A2414LiqFrecPag = new byte[1] ;
      P01QO2_A2409LiqModTra = new String[] {""} ;
      P01QO2_A32TLiqCod = new String[] {""} ;
      P01QO2_n32TLiqCod = new boolean[] {false} ;
      P01QO2_A340TliqDesc = new String[] {""} ;
      P01QO2_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01QO2_A874LiqNombre = new String[] {""} ;
      P01QO2_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01QO2_A31LiqNro = new int[1] ;
      AV39Option = "" ;
      P01QO3_A3CliCod = new int[1] ;
      P01QO3_A1EmpCod = new short[1] ;
      P01QO3_A6LegNumero = new int[1] ;
      P01QO3_A874LiqNombre = new String[] {""} ;
      P01QO3_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO3_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO3_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO3_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO3_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO3_A2414LiqFrecPag = new byte[1] ;
      P01QO3_A2409LiqModTra = new String[] {""} ;
      P01QO3_A32TLiqCod = new String[] {""} ;
      P01QO3_n32TLiqCod = new boolean[] {false} ;
      P01QO3_A340TliqDesc = new String[] {""} ;
      P01QO3_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01QO3_A748LiqPerPalabra = new String[] {""} ;
      P01QO3_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01QO3_A31LiqNro = new int[1] ;
      P01QO4_A32TLiqCod = new String[] {""} ;
      P01QO4_n32TLiqCod = new boolean[] {false} ;
      P01QO4_A6LegNumero = new int[1] ;
      P01QO4_A1EmpCod = new short[1] ;
      P01QO4_A3CliCod = new int[1] ;
      P01QO4_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO4_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO4_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO4_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO4_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01QO4_A2414LiqFrecPag = new byte[1] ;
      P01QO4_A2409LiqModTra = new String[] {""} ;
      P01QO4_A340TliqDesc = new String[] {""} ;
      P01QO4_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01QO4_A874LiqNombre = new String[] {""} ;
      P01QO4_A748LiqPerPalabra = new String[] {""} ;
      P01QO4_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01QO4_A31LiqNro = new int[1] ;
      AV41OptionDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacioneswcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01QO2_A3CliCod, P01QO2_A1EmpCod, P01QO2_A6LegNumero, P01QO2_A748LiqPerPalabra, P01QO2_A757LiqLegImpTotRetGan, P01QO2_A759LiqLegImpTotBruSinSAC, P01QO2_A758LiqLegImpTotBruProm, P01QO2_A498LiqLegImpTotBruto, P01QO2_A760LiqLegImpBasico, P01QO2_A2414LiqFrecPag,
            P01QO2_A2409LiqModTra, P01QO2_A32TLiqCod, P01QO2_n32TLiqCod, P01QO2_A340TliqDesc, P01QO2_A280LiqFecPago, P01QO2_A874LiqNombre, P01QO2_A98LiqFecha, P01QO2_A31LiqNro
            }
            , new Object[] {
            P01QO3_A3CliCod, P01QO3_A1EmpCod, P01QO3_A6LegNumero, P01QO3_A874LiqNombre, P01QO3_A757LiqLegImpTotRetGan, P01QO3_A759LiqLegImpTotBruSinSAC, P01QO3_A758LiqLegImpTotBruProm, P01QO3_A498LiqLegImpTotBruto, P01QO3_A760LiqLegImpBasico, P01QO3_A2414LiqFrecPag,
            P01QO3_A2409LiqModTra, P01QO3_A32TLiqCod, P01QO3_n32TLiqCod, P01QO3_A340TliqDesc, P01QO3_A280LiqFecPago, P01QO3_A748LiqPerPalabra, P01QO3_A98LiqFecha, P01QO3_A31LiqNro
            }
            , new Object[] {
            P01QO4_A32TLiqCod, P01QO4_n32TLiqCod, P01QO4_A6LegNumero, P01QO4_A1EmpCod, P01QO4_A3CliCod, P01QO4_A757LiqLegImpTotRetGan, P01QO4_A759LiqLegImpTotBruSinSAC, P01QO4_A758LiqLegImpTotBruProm, P01QO4_A498LiqLegImpTotBruto, P01QO4_A760LiqLegImpBasico,
            P01QO4_A2414LiqFrecPag, P01QO4_A2409LiqModTra, P01QO4_A340TliqDesc, P01QO4_A280LiqFecPago, P01QO4_A874LiqNombre, P01QO4_A748LiqPerPalabra, P01QO4_A98LiqFecha, P01QO4_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A2414LiqFrecPag ;
   private short AV57EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV66GXV1 ;
   private int AV11TFLiqNro ;
   private int AV12TFLiqNro_To ;
   private int AV56CliCod ;
   private int AV59LegNumero ;
   private int AV17TFLiqPerPalabra_Sels_size ;
   private int AV20TFLiqNombre_Sels_size ;
   private int AV25TFTLiqCod_Sels_size ;
   private int AV61TFLiqModTra_Sels_size ;
   private int AV63TFLiqFrecPag_Sels_size ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV38InsertIndex ;
   private long AV44count ;
   private java.math.BigDecimal AV28TFLiqLegImpBasico ;
   private java.math.BigDecimal AV29TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV30TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV31TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV32TFLiqLegImpTotBruProm ;
   private java.math.BigDecimal AV33TFLiqLegImpTotBruProm_To ;
   private java.math.BigDecimal AV34TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV35TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV36TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV37TFLiqLegImpTotRetGan_To ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private String AV16TFLiqPerPalabra ;
   private String scmdbuf ;
   private String lV16TFLiqPerPalabra ;
   private String A748LiqPerPalabra ;
   private String A32TLiqCod ;
   private String A2409LiqModTra ;
   private java.util.Date AV13TFLiqFecha ;
   private java.util.Date AV14TFLiqFecha_To ;
   private java.util.Date AV21TFLiqFecPago ;
   private java.util.Date AV22TFLiqFecPago_To ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk1QO2 ;
   private boolean n32TLiqCod ;
   private boolean brk1QO4 ;
   private boolean brk1QO6 ;
   private String AV53OptionsJson ;
   private String AV54OptionsDescJson ;
   private String AV55OptionIndexesJson ;
   private String AV15TFLiqPerPalabra_SelsJson ;
   private String AV18TFLiqNombre_SelsJson ;
   private String AV23TFTLiqCod_SelsJson ;
   private String AV60TFLiqModTra_SelsJson ;
   private String AV62TFLiqFrecPag_SelsJson ;
   private String AV50DDOName ;
   private String AV51SearchTxt ;
   private String AV52SearchTxtTo ;
   private String AV19TFLiqNombre ;
   private String AV24TFTLiqCod ;
   private String lV19TFLiqNombre ;
   private String lV24TFTLiqCod ;
   private String A874LiqNombre ;
   private String A340TliqDesc ;
   private String AV39Option ;
   private String AV41OptionDesc ;
   private GXSimpleCollection<Byte> AV63TFLiqFrecPag_Sels ;
   private com.genexus.webpanels.WebSession AV45Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01QO2_A3CliCod ;
   private short[] P01QO2_A1EmpCod ;
   private int[] P01QO2_A6LegNumero ;
   private String[] P01QO2_A748LiqPerPalabra ;
   private java.math.BigDecimal[] P01QO2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P01QO2_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P01QO2_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P01QO2_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P01QO2_A760LiqLegImpBasico ;
   private byte[] P01QO2_A2414LiqFrecPag ;
   private String[] P01QO2_A2409LiqModTra ;
   private String[] P01QO2_A32TLiqCod ;
   private boolean[] P01QO2_n32TLiqCod ;
   private String[] P01QO2_A340TliqDesc ;
   private java.util.Date[] P01QO2_A280LiqFecPago ;
   private String[] P01QO2_A874LiqNombre ;
   private java.util.Date[] P01QO2_A98LiqFecha ;
   private int[] P01QO2_A31LiqNro ;
   private int[] P01QO3_A3CliCod ;
   private short[] P01QO3_A1EmpCod ;
   private int[] P01QO3_A6LegNumero ;
   private String[] P01QO3_A874LiqNombre ;
   private java.math.BigDecimal[] P01QO3_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P01QO3_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P01QO3_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P01QO3_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P01QO3_A760LiqLegImpBasico ;
   private byte[] P01QO3_A2414LiqFrecPag ;
   private String[] P01QO3_A2409LiqModTra ;
   private String[] P01QO3_A32TLiqCod ;
   private boolean[] P01QO3_n32TLiqCod ;
   private String[] P01QO3_A340TliqDesc ;
   private java.util.Date[] P01QO3_A280LiqFecPago ;
   private String[] P01QO3_A748LiqPerPalabra ;
   private java.util.Date[] P01QO3_A98LiqFecha ;
   private int[] P01QO3_A31LiqNro ;
   private String[] P01QO4_A32TLiqCod ;
   private boolean[] P01QO4_n32TLiqCod ;
   private int[] P01QO4_A6LegNumero ;
   private short[] P01QO4_A1EmpCod ;
   private int[] P01QO4_A3CliCod ;
   private java.math.BigDecimal[] P01QO4_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P01QO4_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P01QO4_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P01QO4_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P01QO4_A760LiqLegImpBasico ;
   private byte[] P01QO4_A2414LiqFrecPag ;
   private String[] P01QO4_A2409LiqModTra ;
   private String[] P01QO4_A340TliqDesc ;
   private java.util.Date[] P01QO4_A280LiqFecPago ;
   private String[] P01QO4_A874LiqNombre ;
   private String[] P01QO4_A748LiqPerPalabra ;
   private java.util.Date[] P01QO4_A98LiqFecha ;
   private int[] P01QO4_A31LiqNro ;
   private GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV25TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV61TFLiqModTra_Sels ;
   private GXSimpleCollection<String> AV40Options ;
   private GXSimpleCollection<String> AV42OptionsDesc ;
   private GXSimpleCollection<String> AV43OptionIndexes ;
   private GXSimpleCollection<String> AV20TFLiqNombre_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV47GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV48GridStateFilterValue ;
}

final  class liquidacioneswcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01QO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV20TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV25TFTLiqCod_Sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV61TFLiqModTra_Sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV63TFLiqFrecPag_Sels ,
                                          int AV11TFLiqNro ,
                                          int AV12TFLiqNro_To ,
                                          java.util.Date AV13TFLiqFecha ,
                                          java.util.Date AV14TFLiqFecha_To ,
                                          int AV17TFLiqPerPalabra_Sels_size ,
                                          String AV16TFLiqPerPalabra ,
                                          int AV20TFLiqNombre_Sels_size ,
                                          String AV19TFLiqNombre ,
                                          java.util.Date AV21TFLiqFecPago ,
                                          java.util.Date AV22TFLiqFecPago_To ,
                                          int AV25TFTLiqCod_Sels_size ,
                                          String AV24TFTLiqCod ,
                                          int AV61TFLiqModTra_Sels_size ,
                                          int AV63TFLiqFrecPag_Sels_size ,
                                          java.math.BigDecimal AV28TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV29TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV30TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV31TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV32TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV33TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV34TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV35TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV36TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV37TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          int AV56CliCod ,
                                          short AV57EmpCod ,
                                          int AV59LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[22];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqPerPalabra, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico," ;
      scmdbuf += " T3.LiqFrecPag, T3.LiqModTra, T1.TLiqCod, T2.TliqDesc, T3.LiqFecPago, T3.LiqNombre, T3.LiqFecha, T1.LiqNro FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ! (0==AV11TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (0==AV12TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV13TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha >= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV14TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha <= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ( AV17TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV16TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV17TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV17TFLiqPerPalabra_Sels, "T3.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV20TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV19TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( AV20TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20TFLiqNombre_Sels, "T3.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV21TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV22TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ( AV25TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV25TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV61TFLiqModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61TFLiqModTra_Sels, "T3.LiqModTra IN (", ")")+")");
      }
      if ( AV63TFLiqFrecPag_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63TFLiqFrecPag_Sels, "T3.LiqFrecPag IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqPerPalabra" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P01QO3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV20TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV25TFTLiqCod_Sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV61TFLiqModTra_Sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV63TFLiqFrecPag_Sels ,
                                          int AV11TFLiqNro ,
                                          int AV12TFLiqNro_To ,
                                          java.util.Date AV13TFLiqFecha ,
                                          java.util.Date AV14TFLiqFecha_To ,
                                          int AV17TFLiqPerPalabra_Sels_size ,
                                          String AV16TFLiqPerPalabra ,
                                          int AV20TFLiqNombre_Sels_size ,
                                          String AV19TFLiqNombre ,
                                          java.util.Date AV21TFLiqFecPago ,
                                          java.util.Date AV22TFLiqFecPago_To ,
                                          int AV25TFTLiqCod_Sels_size ,
                                          String AV24TFTLiqCod ,
                                          int AV61TFLiqModTra_Sels_size ,
                                          int AV63TFLiqFrecPag_Sels_size ,
                                          java.math.BigDecimal AV28TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV29TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV30TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV31TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV32TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV33TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV34TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV35TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV36TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV37TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          int AV56CliCod ,
                                          short AV57EmpCod ,
                                          int AV59LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[22];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqNombre, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico," ;
      scmdbuf += " T3.LiqFrecPag, T3.LiqModTra, T1.TLiqCod, T2.TliqDesc, T3.LiqFecPago, T3.LiqPerPalabra, T3.LiqFecha, T1.LiqNro FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ! (0==AV11TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int7[3] = (byte)(1) ;
      }
      if ( ! (0==AV12TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int7[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV13TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha >= ?)");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV14TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha <= ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( ( AV17TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV16TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( AV17TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV17TFLiqPerPalabra_Sels, "T3.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV20TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV19TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( AV20TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20TFLiqNombre_Sels, "T3.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV21TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV22TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ( AV25TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( AV25TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV61TFLiqModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61TFLiqModTra_Sels, "T3.LiqModTra IN (", ")")+")");
      }
      if ( AV63TFLiqFrecPag_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63TFLiqFrecPag_Sels, "T3.LiqFrecPag IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int7[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int7[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int7[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int7[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int7[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqNombre" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P01QO4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV20TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV25TFTLiqCod_Sels ,
                                          String A2409LiqModTra ,
                                          GXSimpleCollection<String> AV61TFLiqModTra_Sels ,
                                          byte A2414LiqFrecPag ,
                                          GXSimpleCollection<Byte> AV63TFLiqFrecPag_Sels ,
                                          int AV11TFLiqNro ,
                                          int AV12TFLiqNro_To ,
                                          java.util.Date AV13TFLiqFecha ,
                                          java.util.Date AV14TFLiqFecha_To ,
                                          int AV17TFLiqPerPalabra_Sels_size ,
                                          String AV16TFLiqPerPalabra ,
                                          int AV20TFLiqNombre_Sels_size ,
                                          String AV19TFLiqNombre ,
                                          java.util.Date AV21TFLiqFecPago ,
                                          java.util.Date AV22TFLiqFecPago_To ,
                                          int AV25TFTLiqCod_Sels_size ,
                                          String AV24TFTLiqCod ,
                                          int AV61TFLiqModTra_Sels_size ,
                                          int AV63TFLiqFrecPag_Sels_size ,
                                          java.math.BigDecimal AV28TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV29TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV30TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV31TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV32TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV33TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV34TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV35TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV36TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV37TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          int AV56CliCod ,
                                          short AV57EmpCod ,
                                          int AV59LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[22];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.TLiqCod, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico," ;
      scmdbuf += " T3.LiqFrecPag, T3.LiqModTra, T2.TliqDesc, T3.LiqFecPago, T3.LiqNombre, T3.LiqPerPalabra, T3.LiqFecha, T1.LiqNro FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      if ( ! (0==AV11TFLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro >= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( ! (0==AV12TFLiqNro_To) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV13TFLiqFecha)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha >= ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV14TFLiqFecha_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecha <= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ( AV17TFLiqPerPalabra_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV16TFLiqPerPalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqPerPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( AV17TFLiqPerPalabra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV17TFLiqPerPalabra_Sels, "T3.LiqPerPalabra IN (", ")")+")");
      }
      if ( ( AV20TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV19TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( AV20TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV20TFLiqNombre_Sels, "T3.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV21TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV22TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ( AV25TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV25TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV61TFLiqModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61TFLiqModTra_Sels, "T3.LiqModTra IN (", ")")+")");
      }
      if ( AV63TFLiqFrecPag_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63TFLiqFrecPag_Sels, "T3.LiqFrecPag IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.TLiqCod" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
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
                  return conditional_P01QO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , (java.util.Date)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (String)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).shortValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).shortValue() , ((Number) dynConstraints[48]).intValue() );
            case 1 :
                  return conditional_P01QO3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , (java.util.Date)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (String)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).shortValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).shortValue() , ((Number) dynConstraints[48]).intValue() );
            case 2 :
                  return conditional_P01QO4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , ((Number) dynConstraints[34]).intValue() , (java.util.Date)dynConstraints[35] , (java.util.Date)dynConstraints[36] , (String)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).shortValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).shortValue() , ((Number) dynConstraints[48]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01QO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01QO3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01QO4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((String[]) buf[15])[0] = rslt.getVarchar(15);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(13);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(16);
               ((int[]) buf[17])[0] = rslt.getInt(17);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((byte[]) buf[10])[0] = rslt.getByte(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(13);
               ((String[]) buf[14])[0] = rslt.getVarchar(14);
               ((String[]) buf[15])[0] = rslt.getString(15, 20);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(16);
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
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[32]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[43], 2);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[32]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[43], 2);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[26]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[27]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[28]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[29], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[32]);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 30);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[35], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[43], 2);
               }
               return;
      }
   }

}

