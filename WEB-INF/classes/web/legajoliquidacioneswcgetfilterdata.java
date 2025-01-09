package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajoliquidacioneswcgetfilterdata extends GXProcedure
{
   public legajoliquidacioneswcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajoliquidacioneswcgetfilterdata.class ), "" );
   }

   public legajoliquidacioneswcgetfilterdata( int remoteHandle ,
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
      legajoliquidacioneswcgetfilterdata.this.aP5 = new String[] {""};
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
      legajoliquidacioneswcgetfilterdata.this.AV31DDOName = aP0;
      legajoliquidacioneswcgetfilterdata.this.AV29SearchTxt = aP1;
      legajoliquidacioneswcgetfilterdata.this.AV30SearchTxtTo = aP2;
      legajoliquidacioneswcgetfilterdata.this.aP3 = aP3;
      legajoliquidacioneswcgetfilterdata.this.aP4 = aP4;
      legajoliquidacioneswcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajo", GXv_boolean2) ;
      legajoliquidacioneswcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_LIQPERPALABRA") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_LIQNOMBRE") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_TLIQCOD") == 0 )
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
      AV35OptionsJson = AV34Options.toJSonString(false) ;
      AV38OptionsDescJson = AV37OptionsDesc.toJSonString(false) ;
      AV40OptionIndexesJson = AV39OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV42Session.getValue("LegajoLiquidacionesWCGridState"), "") == 0 )
      {
         AV44GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LegajoLiquidacionesWCGridState"), null, null);
      }
      else
      {
         AV44GridState.fromxml(AV42Session.getValue("LegajoLiquidacionesWCGridState"), null, null);
      }
      AV61GXV1 = 1 ;
      while ( AV61GXV1 <= AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV45GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV61GXV1));
         if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNRO") == 0 )
         {
            AV11TFLiqNro = (int)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFLiqNro_To = (int)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV13TFLiqFecha = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV14TFLiqFecha_To = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA") == 0 )
         {
            AV16TFLiqPerPalabra = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERPALABRA_SEL") == 0 )
         {
            AV15TFLiqPerPalabra_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFLiqPerPalabra_Sels.fromJSonString(AV15TFLiqPerPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV57TFLiqNombre = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV56TFLiqNombre_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFLiqNombre_Sels.fromJSonString(AV56TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV18TFLiqFecPago = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV19TFLiqFecPago_To = localUtil.ctod( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV21TFTLiqCod = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV20TFTLiqCod_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFTLiqCod_Sels.fromJSonString(AV20TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQCLASE_SEL") == 0 )
         {
            AV23TFLiqClase_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFLiqClase_Sels.fromJSonString(AV23TFLiqClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV54TFLiqLegImpBasico = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV55TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV27TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV28TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUPROM") == 0 )
         {
            AV25TFLiqLegImpTotBruProm = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV26TFLiqLegImpTotBruProm_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV52TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV53TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV50TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV51TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV47CliCod = (int)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV48EmpCod = (short)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV49LegNumero = (int)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV61GXV1 = (int)(AV61GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLIQPERPALABRAOPTIONS' Routine */
      returnInSub = false ;
      AV16TFLiqPerPalabra = AV29SearchTxt ;
      AV17TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV17TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV58TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV22TFTLiqCod_Sels ,
                                           Byte.valueOf(A268LiqClase) ,
                                           AV24TFLiqClase_Sels ,
                                           Integer.valueOf(AV11TFLiqNro) ,
                                           Integer.valueOf(AV12TFLiqNro_To) ,
                                           AV13TFLiqFecha ,
                                           AV14TFLiqFecha_To ,
                                           Integer.valueOf(AV17TFLiqPerPalabra_Sels.size()) ,
                                           AV16TFLiqPerPalabra ,
                                           Integer.valueOf(AV58TFLiqNombre_Sels.size()) ,
                                           AV57TFLiqNombre ,
                                           AV18TFLiqFecPago ,
                                           AV19TFLiqFecPago_To ,
                                           Integer.valueOf(AV22TFTLiqCod_Sels.size()) ,
                                           AV21TFTLiqCod ,
                                           Integer.valueOf(AV24TFLiqClase_Sels.size()) ,
                                           AV54TFLiqLegImpBasico ,
                                           AV55TFLiqLegImpBasico_To ,
                                           AV27TFLiqLegImpTotBruto ,
                                           AV28TFLiqLegImpTotBruto_To ,
                                           AV25TFLiqLegImpTotBruProm ,
                                           AV26TFLiqLegImpTotBruProm_To ,
                                           AV52TFLiqLegImpTotBruSinSAC ,
                                           AV53TFLiqLegImpTotBruSinSAC_To ,
                                           AV50TFLiqLegImpTotRetGan ,
                                           AV51TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Integer.valueOf(AV47CliCod) ,
                                           Short.valueOf(AV48EmpCod) ,
                                           Integer.valueOf(AV49LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV16TFLiqPerPalabra), 20, "%") ;
      lV57TFLiqNombre = GXutil.concat( GXutil.rtrim( AV57TFLiqNombre), "%", "") ;
      lV21TFTLiqCod = GXutil.concat( GXutil.rtrim( AV21TFTLiqCod), "%", "") ;
      /* Using cursor P00S22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV47CliCod), Short.valueOf(AV48EmpCod), Integer.valueOf(AV49LegNumero), Integer.valueOf(AV11TFLiqNro), Integer.valueOf(AV12TFLiqNro_To), AV13TFLiqFecha, AV14TFLiqFecha_To, lV16TFLiqPerPalabra, lV57TFLiqNombre, AV18TFLiqFecPago, AV19TFLiqFecPago_To, lV21TFTLiqCod, AV54TFLiqLegImpBasico, AV55TFLiqLegImpBasico_To, AV27TFLiqLegImpTotBruto, AV28TFLiqLegImpTotBruto_To, AV25TFLiqLegImpTotBruProm, AV26TFLiqLegImpTotBruProm_To, AV52TFLiqLegImpTotBruSinSAC, AV53TFLiqLegImpTotBruSinSAC_To, AV50TFLiqLegImpTotRetGan, AV51TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkS22 = false ;
         A3CliCod = P00S22_A3CliCod[0] ;
         A1EmpCod = P00S22_A1EmpCod[0] ;
         A6LegNumero = P00S22_A6LegNumero[0] ;
         A748LiqPerPalabra = P00S22_A748LiqPerPalabra[0] ;
         A757LiqLegImpTotRetGan = P00S22_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P00S22_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P00S22_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P00S22_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P00S22_A760LiqLegImpBasico[0] ;
         A268LiqClase = P00S22_A268LiqClase[0] ;
         n268LiqClase = P00S22_n268LiqClase[0] ;
         A32TLiqCod = P00S22_A32TLiqCod[0] ;
         n32TLiqCod = P00S22_n32TLiqCod[0] ;
         A340TliqDesc = P00S22_A340TliqDesc[0] ;
         A280LiqFecPago = P00S22_A280LiqFecPago[0] ;
         A874LiqNombre = P00S22_A874LiqNombre[0] ;
         A98LiqFecha = P00S22_A98LiqFecha[0] ;
         A31LiqNro = P00S22_A31LiqNro[0] ;
         A340TliqDesc = P00S22_A340TliqDesc[0] ;
         A748LiqPerPalabra = P00S22_A748LiqPerPalabra[0] ;
         A268LiqClase = P00S22_A268LiqClase[0] ;
         n268LiqClase = P00S22_n268LiqClase[0] ;
         A280LiqFecPago = P00S22_A280LiqFecPago[0] ;
         A874LiqNombre = P00S22_A874LiqNombre[0] ;
         A98LiqFecha = P00S22_A98LiqFecha[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00S22_A3CliCod[0] == A3CliCod ) && ( P00S22_A1EmpCod[0] == A1EmpCod ) && ( P00S22_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P00S22_A748LiqPerPalabra[0], A748LiqPerPalabra) == 0 ) )
         {
            brkS22 = false ;
            A31LiqNro = P00S22_A31LiqNro[0] ;
            AV41count = (long)(AV41count+1) ;
            brkS22 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A748LiqPerPalabra)==0) )
         {
            AV33Option = A748LiqPerPalabra ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkS22 )
         {
            brkS22 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLIQNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV57TFLiqNombre = AV29SearchTxt ;
      AV58TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV17TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV58TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV22TFTLiqCod_Sels ,
                                           Byte.valueOf(A268LiqClase) ,
                                           AV24TFLiqClase_Sels ,
                                           Integer.valueOf(AV11TFLiqNro) ,
                                           Integer.valueOf(AV12TFLiqNro_To) ,
                                           AV13TFLiqFecha ,
                                           AV14TFLiqFecha_To ,
                                           Integer.valueOf(AV17TFLiqPerPalabra_Sels.size()) ,
                                           AV16TFLiqPerPalabra ,
                                           Integer.valueOf(AV58TFLiqNombre_Sels.size()) ,
                                           AV57TFLiqNombre ,
                                           AV18TFLiqFecPago ,
                                           AV19TFLiqFecPago_To ,
                                           Integer.valueOf(AV22TFTLiqCod_Sels.size()) ,
                                           AV21TFTLiqCod ,
                                           Integer.valueOf(AV24TFLiqClase_Sels.size()) ,
                                           AV54TFLiqLegImpBasico ,
                                           AV55TFLiqLegImpBasico_To ,
                                           AV27TFLiqLegImpTotBruto ,
                                           AV28TFLiqLegImpTotBruto_To ,
                                           AV25TFLiqLegImpTotBruProm ,
                                           AV26TFLiqLegImpTotBruProm_To ,
                                           AV52TFLiqLegImpTotBruSinSAC ,
                                           AV53TFLiqLegImpTotBruSinSAC_To ,
                                           AV50TFLiqLegImpTotRetGan ,
                                           AV51TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Integer.valueOf(AV47CliCod) ,
                                           Short.valueOf(AV48EmpCod) ,
                                           Integer.valueOf(AV49LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV16TFLiqPerPalabra), 20, "%") ;
      lV57TFLiqNombre = GXutil.concat( GXutil.rtrim( AV57TFLiqNombre), "%", "") ;
      lV21TFTLiqCod = GXutil.concat( GXutil.rtrim( AV21TFTLiqCod), "%", "") ;
      /* Using cursor P00S23 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV47CliCod), Short.valueOf(AV48EmpCod), Integer.valueOf(AV49LegNumero), Integer.valueOf(AV11TFLiqNro), Integer.valueOf(AV12TFLiqNro_To), AV13TFLiqFecha, AV14TFLiqFecha_To, lV16TFLiqPerPalabra, lV57TFLiqNombre, AV18TFLiqFecPago, AV19TFLiqFecPago_To, lV21TFTLiqCod, AV54TFLiqLegImpBasico, AV55TFLiqLegImpBasico_To, AV27TFLiqLegImpTotBruto, AV28TFLiqLegImpTotBruto_To, AV25TFLiqLegImpTotBruProm, AV26TFLiqLegImpTotBruProm_To, AV52TFLiqLegImpTotBruSinSAC, AV53TFLiqLegImpTotBruSinSAC_To, AV50TFLiqLegImpTotRetGan, AV51TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkS24 = false ;
         A3CliCod = P00S23_A3CliCod[0] ;
         A1EmpCod = P00S23_A1EmpCod[0] ;
         A6LegNumero = P00S23_A6LegNumero[0] ;
         A874LiqNombre = P00S23_A874LiqNombre[0] ;
         A757LiqLegImpTotRetGan = P00S23_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P00S23_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P00S23_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P00S23_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P00S23_A760LiqLegImpBasico[0] ;
         A268LiqClase = P00S23_A268LiqClase[0] ;
         n268LiqClase = P00S23_n268LiqClase[0] ;
         A32TLiqCod = P00S23_A32TLiqCod[0] ;
         n32TLiqCod = P00S23_n32TLiqCod[0] ;
         A340TliqDesc = P00S23_A340TliqDesc[0] ;
         A280LiqFecPago = P00S23_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P00S23_A748LiqPerPalabra[0] ;
         A98LiqFecha = P00S23_A98LiqFecha[0] ;
         A31LiqNro = P00S23_A31LiqNro[0] ;
         A340TliqDesc = P00S23_A340TliqDesc[0] ;
         A874LiqNombre = P00S23_A874LiqNombre[0] ;
         A268LiqClase = P00S23_A268LiqClase[0] ;
         n268LiqClase = P00S23_n268LiqClase[0] ;
         A280LiqFecPago = P00S23_A280LiqFecPago[0] ;
         A748LiqPerPalabra = P00S23_A748LiqPerPalabra[0] ;
         A98LiqFecha = P00S23_A98LiqFecha[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P00S23_A3CliCod[0] == A3CliCod ) && ( P00S23_A1EmpCod[0] == A1EmpCod ) && ( P00S23_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P00S23_A874LiqNombre[0], A874LiqNombre) == 0 ) )
         {
            brkS24 = false ;
            A31LiqNro = P00S23_A31LiqNro[0] ;
            AV41count = (long)(AV41count+1) ;
            brkS24 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A874LiqNombre)==0) )
         {
            AV33Option = A874LiqNombre ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkS24 )
         {
            brkS24 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADTLIQCODOPTIONS' Routine */
      returnInSub = false ;
      AV21TFTLiqCod = AV29SearchTxt ;
      AV22TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A748LiqPerPalabra ,
                                           AV17TFLiqPerPalabra_Sels ,
                                           A874LiqNombre ,
                                           AV58TFLiqNombre_Sels ,
                                           A32TLiqCod ,
                                           AV22TFTLiqCod_Sels ,
                                           Byte.valueOf(A268LiqClase) ,
                                           AV24TFLiqClase_Sels ,
                                           Integer.valueOf(AV11TFLiqNro) ,
                                           Integer.valueOf(AV12TFLiqNro_To) ,
                                           AV13TFLiqFecha ,
                                           AV14TFLiqFecha_To ,
                                           Integer.valueOf(AV17TFLiqPerPalabra_Sels.size()) ,
                                           AV16TFLiqPerPalabra ,
                                           Integer.valueOf(AV58TFLiqNombre_Sels.size()) ,
                                           AV57TFLiqNombre ,
                                           AV18TFLiqFecPago ,
                                           AV19TFLiqFecPago_To ,
                                           Integer.valueOf(AV22TFTLiqCod_Sels.size()) ,
                                           AV21TFTLiqCod ,
                                           Integer.valueOf(AV24TFLiqClase_Sels.size()) ,
                                           AV54TFLiqLegImpBasico ,
                                           AV55TFLiqLegImpBasico_To ,
                                           AV27TFLiqLegImpTotBruto ,
                                           AV28TFLiqLegImpTotBruto_To ,
                                           AV25TFLiqLegImpTotBruProm ,
                                           AV26TFLiqLegImpTotBruProm_To ,
                                           AV52TFLiqLegImpTotBruSinSAC ,
                                           AV53TFLiqLegImpTotBruSinSAC_To ,
                                           AV50TFLiqLegImpTotRetGan ,
                                           AV51TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A98LiqFecha ,
                                           A280LiqFecPago ,
                                           A340TliqDesc ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A758LiqLegImpTotBruProm ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           Integer.valueOf(AV47CliCod) ,
                                           Short.valueOf(AV48EmpCod) ,
                                           Integer.valueOf(AV49LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLiqPerPalabra = GXutil.padr( GXutil.rtrim( AV16TFLiqPerPalabra), 20, "%") ;
      lV57TFLiqNombre = GXutil.concat( GXutil.rtrim( AV57TFLiqNombre), "%", "") ;
      lV21TFTLiqCod = GXutil.concat( GXutil.rtrim( AV21TFTLiqCod), "%", "") ;
      /* Using cursor P00S24 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV47CliCod), Short.valueOf(AV48EmpCod), Integer.valueOf(AV49LegNumero), Integer.valueOf(AV11TFLiqNro), Integer.valueOf(AV12TFLiqNro_To), AV13TFLiqFecha, AV14TFLiqFecha_To, lV16TFLiqPerPalabra, lV57TFLiqNombre, AV18TFLiqFecPago, AV19TFLiqFecPago_To, lV21TFTLiqCod, AV54TFLiqLegImpBasico, AV55TFLiqLegImpBasico_To, AV27TFLiqLegImpTotBruto, AV28TFLiqLegImpTotBruto_To, AV25TFLiqLegImpTotBruProm, AV26TFLiqLegImpTotBruProm_To, AV52TFLiqLegImpTotBruSinSAC, AV53TFLiqLegImpTotBruSinSAC_To, AV50TFLiqLegImpTotRetGan, AV51TFLiqLegImpTotRetGan_To});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brkS26 = false ;
         A32TLiqCod = P00S24_A32TLiqCod[0] ;
         n32TLiqCod = P00S24_n32TLiqCod[0] ;
         A6LegNumero = P00S24_A6LegNumero[0] ;
         A1EmpCod = P00S24_A1EmpCod[0] ;
         A3CliCod = P00S24_A3CliCod[0] ;
         A757LiqLegImpTotRetGan = P00S24_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P00S24_A759LiqLegImpTotBruSinSAC[0] ;
         A758LiqLegImpTotBruProm = P00S24_A758LiqLegImpTotBruProm[0] ;
         A498LiqLegImpTotBruto = P00S24_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P00S24_A760LiqLegImpBasico[0] ;
         A268LiqClase = P00S24_A268LiqClase[0] ;
         n268LiqClase = P00S24_n268LiqClase[0] ;
         A340TliqDesc = P00S24_A340TliqDesc[0] ;
         A280LiqFecPago = P00S24_A280LiqFecPago[0] ;
         A874LiqNombre = P00S24_A874LiqNombre[0] ;
         A748LiqPerPalabra = P00S24_A748LiqPerPalabra[0] ;
         A98LiqFecha = P00S24_A98LiqFecha[0] ;
         A31LiqNro = P00S24_A31LiqNro[0] ;
         A340TliqDesc = P00S24_A340TliqDesc[0] ;
         A268LiqClase = P00S24_A268LiqClase[0] ;
         n268LiqClase = P00S24_n268LiqClase[0] ;
         A280LiqFecPago = P00S24_A280LiqFecPago[0] ;
         A874LiqNombre = P00S24_A874LiqNombre[0] ;
         A748LiqPerPalabra = P00S24_A748LiqPerPalabra[0] ;
         A98LiqFecha = P00S24_A98LiqFecha[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P00S24_A3CliCod[0] == A3CliCod ) && ( P00S24_A1EmpCod[0] == A1EmpCod ) && ( P00S24_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P00S24_A32TLiqCod[0], A32TLiqCod) == 0 ) )
         {
            brkS26 = false ;
            A31LiqNro = P00S24_A31LiqNro[0] ;
            AV41count = (long)(AV41count+1) ;
            brkS26 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A340TliqDesc)==0) )
         {
            AV33Option = A32TLiqCod ;
            AV36OptionDesc = A340TliqDesc ;
            AV32InsertIndex = 1 ;
            while ( ( AV32InsertIndex <= AV34Options.size() ) && ( GXutil.strcmp((String)AV37OptionsDesc.elementAt(-1+AV32InsertIndex), AV36OptionDesc) < 0 ) )
            {
               AV32InsertIndex = (int)(AV32InsertIndex+1) ;
            }
            AV34Options.add(AV33Option, AV32InsertIndex);
            AV37OptionsDesc.add(AV36OptionDesc, AV32InsertIndex);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), AV32InsertIndex);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkS26 )
         {
            brkS26 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = legajoliquidacioneswcgetfilterdata.this.AV35OptionsJson;
      this.aP4[0] = legajoliquidacioneswcgetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = legajoliquidacioneswcgetfilterdata.this.AV40OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV35OptionsJson = "" ;
      AV38OptionsDescJson = "" ;
      AV40OptionIndexesJson = "" ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV42Session = httpContext.getWebSession();
      AV44GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV45GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV13TFLiqFecha = GXutil.nullDate() ;
      AV14TFLiqFecha_To = GXutil.nullDate() ;
      AV16TFLiqPerPalabra = "" ;
      AV15TFLiqPerPalabra_SelsJson = "" ;
      AV17TFLiqPerPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57TFLiqNombre = "" ;
      AV56TFLiqNombre_SelsJson = "" ;
      AV58TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFLiqFecPago = GXutil.nullDate() ;
      AV19TFLiqFecPago_To = GXutil.nullDate() ;
      AV21TFTLiqCod = "" ;
      AV20TFTLiqCod_SelsJson = "" ;
      AV22TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFLiqClase_SelsJson = "" ;
      AV24TFLiqClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV54TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV55TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV27TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV28TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV25TFLiqLegImpTotBruProm = DecimalUtil.ZERO ;
      AV26TFLiqLegImpTotBruProm_To = DecimalUtil.ZERO ;
      AV52TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV53TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV50TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV51TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV16TFLiqPerPalabra = "" ;
      lV57TFLiqNombre = "" ;
      lV21TFTLiqCod = "" ;
      A748LiqPerPalabra = "" ;
      A874LiqNombre = "" ;
      A32TLiqCod = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      A340TliqDesc = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A758LiqLegImpTotBruProm = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      P00S22_A3CliCod = new int[1] ;
      P00S22_A1EmpCod = new short[1] ;
      P00S22_A6LegNumero = new int[1] ;
      P00S22_A748LiqPerPalabra = new String[] {""} ;
      P00S22_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S22_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S22_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S22_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S22_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S22_A268LiqClase = new byte[1] ;
      P00S22_n268LiqClase = new boolean[] {false} ;
      P00S22_A32TLiqCod = new String[] {""} ;
      P00S22_n32TLiqCod = new boolean[] {false} ;
      P00S22_A340TliqDesc = new String[] {""} ;
      P00S22_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P00S22_A874LiqNombre = new String[] {""} ;
      P00S22_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00S22_A31LiqNro = new int[1] ;
      AV33Option = "" ;
      P00S23_A3CliCod = new int[1] ;
      P00S23_A1EmpCod = new short[1] ;
      P00S23_A6LegNumero = new int[1] ;
      P00S23_A874LiqNombre = new String[] {""} ;
      P00S23_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S23_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S23_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S23_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S23_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S23_A268LiqClase = new byte[1] ;
      P00S23_n268LiqClase = new boolean[] {false} ;
      P00S23_A32TLiqCod = new String[] {""} ;
      P00S23_n32TLiqCod = new boolean[] {false} ;
      P00S23_A340TliqDesc = new String[] {""} ;
      P00S23_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P00S23_A748LiqPerPalabra = new String[] {""} ;
      P00S23_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00S23_A31LiqNro = new int[1] ;
      P00S24_A32TLiqCod = new String[] {""} ;
      P00S24_n32TLiqCod = new boolean[] {false} ;
      P00S24_A6LegNumero = new int[1] ;
      P00S24_A1EmpCod = new short[1] ;
      P00S24_A3CliCod = new int[1] ;
      P00S24_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S24_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S24_A758LiqLegImpTotBruProm = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S24_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S24_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00S24_A268LiqClase = new byte[1] ;
      P00S24_n268LiqClase = new boolean[] {false} ;
      P00S24_A340TliqDesc = new String[] {""} ;
      P00S24_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P00S24_A874LiqNombre = new String[] {""} ;
      P00S24_A748LiqPerPalabra = new String[] {""} ;
      P00S24_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00S24_A31LiqNro = new int[1] ;
      AV36OptionDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajoliquidacioneswcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00S22_A3CliCod, P00S22_A1EmpCod, P00S22_A6LegNumero, P00S22_A748LiqPerPalabra, P00S22_A757LiqLegImpTotRetGan, P00S22_A759LiqLegImpTotBruSinSAC, P00S22_A758LiqLegImpTotBruProm, P00S22_A498LiqLegImpTotBruto, P00S22_A760LiqLegImpBasico, P00S22_A268LiqClase,
            P00S22_n268LiqClase, P00S22_A32TLiqCod, P00S22_n32TLiqCod, P00S22_A340TliqDesc, P00S22_A280LiqFecPago, P00S22_A874LiqNombre, P00S22_A98LiqFecha, P00S22_A31LiqNro
            }
            , new Object[] {
            P00S23_A3CliCod, P00S23_A1EmpCod, P00S23_A6LegNumero, P00S23_A874LiqNombre, P00S23_A757LiqLegImpTotRetGan, P00S23_A759LiqLegImpTotBruSinSAC, P00S23_A758LiqLegImpTotBruProm, P00S23_A498LiqLegImpTotBruto, P00S23_A760LiqLegImpBasico, P00S23_A268LiqClase,
            P00S23_n268LiqClase, P00S23_A32TLiqCod, P00S23_n32TLiqCod, P00S23_A340TliqDesc, P00S23_A280LiqFecPago, P00S23_A748LiqPerPalabra, P00S23_A98LiqFecha, P00S23_A31LiqNro
            }
            , new Object[] {
            P00S24_A32TLiqCod, P00S24_n32TLiqCod, P00S24_A6LegNumero, P00S24_A1EmpCod, P00S24_A3CliCod, P00S24_A757LiqLegImpTotRetGan, P00S24_A759LiqLegImpTotBruSinSAC, P00S24_A758LiqLegImpTotBruProm, P00S24_A498LiqLegImpTotBruto, P00S24_A760LiqLegImpBasico,
            P00S24_A268LiqClase, P00S24_n268LiqClase, P00S24_A340TliqDesc, P00S24_A280LiqFecPago, P00S24_A874LiqNombre, P00S24_A748LiqPerPalabra, P00S24_A98LiqFecha, P00S24_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A268LiqClase ;
   private short AV48EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV61GXV1 ;
   private int AV11TFLiqNro ;
   private int AV12TFLiqNro_To ;
   private int AV47CliCod ;
   private int AV49LegNumero ;
   private int AV17TFLiqPerPalabra_Sels_size ;
   private int AV58TFLiqNombre_Sels_size ;
   private int AV22TFTLiqCod_Sels_size ;
   private int AV24TFLiqClase_Sels_size ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV32InsertIndex ;
   private long AV41count ;
   private java.math.BigDecimal AV54TFLiqLegImpBasico ;
   private java.math.BigDecimal AV55TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV27TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV28TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV25TFLiqLegImpTotBruProm ;
   private java.math.BigDecimal AV26TFLiqLegImpTotBruProm_To ;
   private java.math.BigDecimal AV52TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV53TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV50TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV51TFLiqLegImpTotRetGan_To ;
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
   private java.util.Date AV13TFLiqFecha ;
   private java.util.Date AV14TFLiqFecha_To ;
   private java.util.Date AV18TFLiqFecPago ;
   private java.util.Date AV19TFLiqFecPago_To ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brkS22 ;
   private boolean n268LiqClase ;
   private boolean n32TLiqCod ;
   private boolean brkS24 ;
   private boolean brkS26 ;
   private String AV35OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV40OptionIndexesJson ;
   private String AV15TFLiqPerPalabra_SelsJson ;
   private String AV56TFLiqNombre_SelsJson ;
   private String AV20TFTLiqCod_SelsJson ;
   private String AV23TFLiqClase_SelsJson ;
   private String AV31DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV57TFLiqNombre ;
   private String AV21TFTLiqCod ;
   private String lV57TFLiqNombre ;
   private String lV21TFTLiqCod ;
   private String A874LiqNombre ;
   private String A340TliqDesc ;
   private String AV33Option ;
   private String AV36OptionDesc ;
   private GXSimpleCollection<Byte> AV24TFLiqClase_Sels ;
   private com.genexus.webpanels.WebSession AV42Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00S22_A3CliCod ;
   private short[] P00S22_A1EmpCod ;
   private int[] P00S22_A6LegNumero ;
   private String[] P00S22_A748LiqPerPalabra ;
   private java.math.BigDecimal[] P00S22_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P00S22_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P00S22_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P00S22_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P00S22_A760LiqLegImpBasico ;
   private byte[] P00S22_A268LiqClase ;
   private boolean[] P00S22_n268LiqClase ;
   private String[] P00S22_A32TLiqCod ;
   private boolean[] P00S22_n32TLiqCod ;
   private String[] P00S22_A340TliqDesc ;
   private java.util.Date[] P00S22_A280LiqFecPago ;
   private String[] P00S22_A874LiqNombre ;
   private java.util.Date[] P00S22_A98LiqFecha ;
   private int[] P00S22_A31LiqNro ;
   private int[] P00S23_A3CliCod ;
   private short[] P00S23_A1EmpCod ;
   private int[] P00S23_A6LegNumero ;
   private String[] P00S23_A874LiqNombre ;
   private java.math.BigDecimal[] P00S23_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P00S23_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P00S23_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P00S23_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P00S23_A760LiqLegImpBasico ;
   private byte[] P00S23_A268LiqClase ;
   private boolean[] P00S23_n268LiqClase ;
   private String[] P00S23_A32TLiqCod ;
   private boolean[] P00S23_n32TLiqCod ;
   private String[] P00S23_A340TliqDesc ;
   private java.util.Date[] P00S23_A280LiqFecPago ;
   private String[] P00S23_A748LiqPerPalabra ;
   private java.util.Date[] P00S23_A98LiqFecha ;
   private int[] P00S23_A31LiqNro ;
   private String[] P00S24_A32TLiqCod ;
   private boolean[] P00S24_n32TLiqCod ;
   private int[] P00S24_A6LegNumero ;
   private short[] P00S24_A1EmpCod ;
   private int[] P00S24_A3CliCod ;
   private java.math.BigDecimal[] P00S24_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P00S24_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P00S24_A758LiqLegImpTotBruProm ;
   private java.math.BigDecimal[] P00S24_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P00S24_A760LiqLegImpBasico ;
   private byte[] P00S24_A268LiqClase ;
   private boolean[] P00S24_n268LiqClase ;
   private String[] P00S24_A340TliqDesc ;
   private java.util.Date[] P00S24_A280LiqFecPago ;
   private String[] P00S24_A874LiqNombre ;
   private String[] P00S24_A748LiqPerPalabra ;
   private java.util.Date[] P00S24_A98LiqFecha ;
   private int[] P00S24_A31LiqNro ;
   private GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ;
   private GXSimpleCollection<String> AV22TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV37OptionsDesc ;
   private GXSimpleCollection<String> AV39OptionIndexes ;
   private GXSimpleCollection<String> AV58TFLiqNombre_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV44GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV45GridStateFilterValue ;
}

final  class legajoliquidacioneswcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00S22( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV58TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV22TFTLiqCod_Sels ,
                                          byte A268LiqClase ,
                                          GXSimpleCollection<Byte> AV24TFLiqClase_Sels ,
                                          int AV11TFLiqNro ,
                                          int AV12TFLiqNro_To ,
                                          java.util.Date AV13TFLiqFecha ,
                                          java.util.Date AV14TFLiqFecha_To ,
                                          int AV17TFLiqPerPalabra_Sels_size ,
                                          String AV16TFLiqPerPalabra ,
                                          int AV58TFLiqNombre_Sels_size ,
                                          String AV57TFLiqNombre ,
                                          java.util.Date AV18TFLiqFecPago ,
                                          java.util.Date AV19TFLiqFecPago_To ,
                                          int AV22TFTLiqCod_Sels_size ,
                                          String AV21TFTLiqCod ,
                                          int AV24TFLiqClase_Sels_size ,
                                          java.math.BigDecimal AV54TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV55TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV27TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV28TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV25TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV26TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV52TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV53TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV50TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV51TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          int AV47CliCod ,
                                          short AV48EmpCod ,
                                          int AV49LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[22];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqPerPalabra, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico," ;
      scmdbuf += " T3.LiqClase, T1.TLiqCod, T2.TliqDesc, T3.LiqFecPago, T3.LiqNombre, T3.LiqFecha, T1.LiqNro FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion T2 ON T2.CliCod" ;
      scmdbuf += " = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro)" ;
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
      if ( ( AV58TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( AV58TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFLiqNombre_Sels, "T3.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV19TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ( AV22TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV22TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV24TFLiqClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV24TFLiqClase_Sels, "T3.LiqClase IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV27TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLiqLegImpTotRetGan_To)==0) )
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

   protected Object[] conditional_P00S23( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV58TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV22TFTLiqCod_Sels ,
                                          byte A268LiqClase ,
                                          GXSimpleCollection<Byte> AV24TFLiqClase_Sels ,
                                          int AV11TFLiqNro ,
                                          int AV12TFLiqNro_To ,
                                          java.util.Date AV13TFLiqFecha ,
                                          java.util.Date AV14TFLiqFecha_To ,
                                          int AV17TFLiqPerPalabra_Sels_size ,
                                          String AV16TFLiqPerPalabra ,
                                          int AV58TFLiqNombre_Sels_size ,
                                          String AV57TFLiqNombre ,
                                          java.util.Date AV18TFLiqFecPago ,
                                          java.util.Date AV19TFLiqFecPago_To ,
                                          int AV22TFTLiqCod_Sels_size ,
                                          String AV21TFTLiqCod ,
                                          int AV24TFLiqClase_Sels_size ,
                                          java.math.BigDecimal AV54TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV55TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV27TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV28TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV25TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV26TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV52TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV53TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV50TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV51TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          int AV47CliCod ,
                                          short AV48EmpCod ,
                                          int AV49LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[22];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.EmpCod, T1.LegNumero, T3.LiqNombre, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico," ;
      scmdbuf += " T3.LiqClase, T1.TLiqCod, T2.TliqDesc, T3.LiqFecPago, T3.LiqPerPalabra, T3.LiqFecha, T1.LiqNro FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion T2 ON T2.CliCod" ;
      scmdbuf += " = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro)" ;
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
      if ( ( AV58TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( AV58TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFLiqNombre_Sels, "T3.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV19TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ( AV22TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( AV22TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV24TFLiqClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV24TFLiqClase_Sels, "T3.LiqClase IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV27TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int7[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int7[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int7[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int7[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLiqLegImpTotRetGan_To)==0) )
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

   protected Object[] conditional_P00S24( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A748LiqPerPalabra ,
                                          GXSimpleCollection<String> AV17TFLiqPerPalabra_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV58TFLiqNombre_Sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV22TFTLiqCod_Sels ,
                                          byte A268LiqClase ,
                                          GXSimpleCollection<Byte> AV24TFLiqClase_Sels ,
                                          int AV11TFLiqNro ,
                                          int AV12TFLiqNro_To ,
                                          java.util.Date AV13TFLiqFecha ,
                                          java.util.Date AV14TFLiqFecha_To ,
                                          int AV17TFLiqPerPalabra_Sels_size ,
                                          String AV16TFLiqPerPalabra ,
                                          int AV58TFLiqNombre_Sels_size ,
                                          String AV57TFLiqNombre ,
                                          java.util.Date AV18TFLiqFecPago ,
                                          java.util.Date AV19TFLiqFecPago_To ,
                                          int AV22TFTLiqCod_Sels_size ,
                                          String AV21TFTLiqCod ,
                                          int AV24TFLiqClase_Sels_size ,
                                          java.math.BigDecimal AV54TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV55TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV27TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV28TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV25TFLiqLegImpTotBruProm ,
                                          java.math.BigDecimal AV26TFLiqLegImpTotBruProm_To ,
                                          java.math.BigDecimal AV52TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV53TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV50TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV51TFLiqLegImpTotRetGan_To ,
                                          int A31LiqNro ,
                                          java.util.Date A98LiqFecha ,
                                          java.util.Date A280LiqFecPago ,
                                          String A340TliqDesc ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A758LiqLegImpTotBruProm ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          int AV47CliCod ,
                                          short AV48EmpCod ,
                                          int AV49LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[22];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.TLiqCod, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqLegImpTotRetGan, T1.LiqLegImpTotBruSinSAC, T1.LiqLegImpTotBruProm, T1.LiqLegImpTotBruto, T1.LiqLegImpBasico," ;
      scmdbuf += " T3.LiqClase, T2.TliqDesc, T3.LiqFecPago, T3.LiqNombre, T3.LiqPerPalabra, T3.LiqFecha, T1.LiqNro FROM ((LiquidacionLegajo T1 LEFT JOIN TipoLiquidacion T2 ON T2.CliCod" ;
      scmdbuf += " = T1.CliCod AND T2.TLiqCod = T1.TLiqCod) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro = T1.LiqNro)" ;
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
      if ( ( AV58TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV57TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T3.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( AV58TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFLiqNombre_Sels, "T3.LiqNombre IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV18TFLiqFecPago)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV19TFLiqFecPago_To)) )
      {
         addWhere(sWhereString, "(T3.LiqFecPago <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ( AV22TFTLiqCod_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFTLiqCod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.TliqDesc) like LOWER(?))");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV22TFTLiqCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFTLiqCod_Sels, "T1.TLiqCod IN (", ")")+")");
      }
      if ( AV24TFLiqClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV24TFLiqClase_Sels, "T3.LiqClase IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV27TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFLiqLegImpTotBruProm)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm >= ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFLiqLegImpTotBruProm_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruProm <= ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(T1.LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLiqLegImpTotRetGan_To)==0) )
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
                  return conditional_P00S22(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (java.util.Date)dynConstraints[32] , (java.util.Date)dynConstraints[33] , (String)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).shortValue() , ((Number) dynConstraints[45]).intValue() );
            case 1 :
                  return conditional_P00S23(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (java.util.Date)dynConstraints[32] , (java.util.Date)dynConstraints[33] , (String)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).shortValue() , ((Number) dynConstraints[45]).intValue() );
            case 2 :
                  return conditional_P00S24(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.util.Date)dynConstraints[16] , (java.util.Date)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (java.util.Date)dynConstraints[32] , (java.util.Date)dynConstraints[33] , (String)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , ((Number) dynConstraints[41]).shortValue() , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).shortValue() , ((Number) dynConstraints[45]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00S22", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00S23", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00S24", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(13);
               ((String[]) buf[15])[0] = rslt.getVarchar(14);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
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
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(13);
               ((String[]) buf[15])[0] = rslt.getString(14, 20);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
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
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(11);
               ((java.util.Date[]) buf[13])[0] = rslt.getGXDate(12);
               ((String[]) buf[14])[0] = rslt.getVarchar(13);
               ((String[]) buf[15])[0] = rslt.getString(14, 20);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
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

