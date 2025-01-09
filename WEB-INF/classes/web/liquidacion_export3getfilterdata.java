package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacion_export3getfilterdata extends GXProcedure
{
   public liquidacion_export3getfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacion_export3getfilterdata.class ), "" );
   }

   public liquidacion_export3getfilterdata( int remoteHandle ,
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
      liquidacion_export3getfilterdata.this.aP5 = new String[] {""};
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
      liquidacion_export3getfilterdata.this.AV80DDOName = aP0;
      liquidacion_export3getfilterdata.this.AV81SearchTxt = aP1;
      liquidacion_export3getfilterdata.this.AV82SearchTxtTo = aP2;
      liquidacion_export3getfilterdata.this.aP3 = aP3;
      liquidacion_export3getfilterdata.this.aP4 = aP4;
      liquidacion_export3getfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV87EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      liquidacion_export3getfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV87EmpCod = GXt_int1 ;
      GXt_int3 = AV88CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      liquidacion_export3getfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV88CliCod = GXt_int3 ;
      AV70Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV72OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV73OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXv_SdtWWPContext5[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV9WWPContext = GXv_SdtWWPContext5[0] ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LEGID") == 0 )
      {
         /* Execute user subroutine: 'LOADLEGIDOPTIONS' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LEGNOMAPE") == 0 )
      {
         /* Execute user subroutine: 'LOADLEGNOMAPEOPTIONS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LIQNOMBRE") == 0 )
      {
         /* Execute user subroutine: 'LOADLIQNOMBREOPTIONS' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_SECDESCRIP") == 0 )
      {
         /* Execute user subroutine: 'LOADSECDESCRIPOPTIONS' */
         S151 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LEGOSODES") == 0 )
      {
         /* Execute user subroutine: 'LOADLEGOSODESOPTIONS' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LEGCUENTABANC") == 0 )
      {
         /* Execute user subroutine: 'LOADLEGCUENTABANCOPTIONS' */
         S171 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LEGCLASE") == 0 )
      {
         /* Execute user subroutine: 'LOADLEGCLASEOPTIONS' */
         S181 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LIQDESCRIP") == 0 )
      {
         /* Execute user subroutine: 'LOADLIQDESCRIPOPTIONS' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LIQFECHA") == 0 )
      {
         /* Execute user subroutine: 'LOADLIQFECHAOPTIONS' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LIQPERSINDIA") == 0 )
      {
         /* Execute user subroutine: 'LOADLIQPERSINDIAOPTIONS' */
         S211 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_TLIQDESC") == 0 )
      {
         /* Execute user subroutine: 'LOADTLIQDESCOPTIONS' */
         S221 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LIQFECPAGO") == 0 )
      {
         /* Execute user subroutine: 'LOADLIQFECPAGOOPTIONS' */
         S231 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_DCONCODIGO") == 0 )
      {
         /* Execute user subroutine: 'LOADDCONCODIGOOPTIONS' */
         S241 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_DCONDESCRIP") == 0 )
      {
         /* Execute user subroutine: 'LOADDCONDESCRIPOPTIONS' */
         S251 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_CONCLASIFAUX") == 0 )
      {
         /* Execute user subroutine: 'LOADCONCLASIFAUXOPTIONS' */
         S261 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(GXutil.upper( AV80DDOName), "DDO_LIQDLOGRECAL") == 0 )
      {
         /* Execute user subroutine: 'LOADLIQDLOGRECALOPTIONS' */
         S271 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV83OptionsJson = AV70Options.toJSonString(false) ;
      AV84OptionsDescJson = AV72OptionsDesc.toJSonString(false) ;
      AV85OptionIndexesJson = AV73OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV75Session.getValue("liquidacion_export3GridState"), "") == 0 )
      {
         AV77GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "liquidacion_export3GridState"), null, null);
      }
      else
      {
         AV77GridState.fromxml(AV75Session.getValue("liquidacion_export3GridState"), null, null);
      }
      AV106GXV1 = 1 ;
      while ( AV106GXV1 <= AV77GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV78GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV77GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV106GXV1));
         if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID") == 0 )
         {
            AV12TFLegId = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGID_SEL") == 0 )
         {
            AV11TFLegId_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFLegId_Sels.fromJSonString(AV11TFLegId_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE") == 0 )
         {
            AV15TFLegNomApe = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGNOMAPE_SEL") == 0 )
         {
            AV14TFLegNomApe_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFLegNomApe_Sels.fromJSonString(AV14TFLegNomApe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE") == 0 )
         {
            AV18TFLiqNombre = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNOMBRE_SEL") == 0 )
         {
            AV17TFLiqNombre_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFLiqNombre_Sels.fromJSonString(AV17TFLiqNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP") == 0 )
         {
            AV21TFSecDescrip = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP_SEL") == 0 )
         {
            AV20TFSecDescrip_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFSecDescrip_Sels.fromJSonString(AV20TFSecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGOSODES") == 0 )
         {
            AV98TFLegOsoDes = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGOSODES_SEL") == 0 )
         {
            AV97TFLegOsoDes_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV99TFLegOsoDes_Sels.fromJSonString(AV97TFLegOsoDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENTABANC") == 0 )
         {
            AV29TFLegCuentaBanc = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCUENTABANC_SEL") == 0 )
         {
            AV28TFLegCuentaBanc_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV30TFLegCuentaBanc_Sels.fromJSonString(AV28TFLegCuentaBanc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGMODTRA_SEL") == 0 )
         {
            AV100TFLegModTra_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV101TFLegModTra_Sels.fromJSonString(AV100TFLegModTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGCLASE_SEL") == 0 )
         {
            AV31TFLegClase_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV32TFLegClase_Sels.fromJSonString(AV31TFLegClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGTIPOTARIFA_SEL") == 0 )
         {
            AV102TFLegTipoTarifa_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV103TFLegTipoTarifa_Sels.fromJSonString(AV102TFLegTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP") == 0 )
         {
            AV37TFLiqDescrip = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDESCRIP_SEL") == 0 )
         {
            AV36TFLiqDescrip_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFLiqDescrip_Sels.fromJSonString(AV36TFLiqDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA") == 0 )
         {
            AV40TFLiqFecha = localUtil.ctod( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECHA_SEL") == 0 )
         {
            AV39TFLiqFecha_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFLiqFecha_Sels.fromJSonString(AV39TFLiqFecha_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERSINDIA") == 0 )
         {
            AV43TFLiqPerSinDia = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQPERSINDIA_SEL") == 0 )
         {
            AV42TFLiqPerSinDia_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFLiqPerSinDia_Sels.fromJSonString(AV42TFLiqPerSinDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC") == 0 )
         {
            AV46TFTliqDesc = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQDESC_SEL") == 0 )
         {
            AV45TFTliqDesc_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFTliqDesc_Sels.fromJSonString(AV45TFTliqDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO") == 0 )
         {
            AV49TFLiqFecPago = localUtil.ctod( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQFECPAGO_SEL") == 0 )
         {
            AV48TFLiqFecPago_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFLiqFecPago_Sels.fromJSonString(AV48TFLiqFecPago_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV52TFDConCodigo = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV51TFDConCodigo_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFDConCodigo_Sels.fromJSonString(AV51TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV55TFDConDescrip = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV54TFDConDescrip_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV56TFDConDescrip_Sels.fromJSonString(AV54TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV57TFDTipoConCod_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV58TFDTipoConCod_Sels.fromJSonString(AV57TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX") == 0 )
         {
            AV60TFConClasifAux = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCLASIFAUX_SEL") == 0 )
         {
            AV59TFConClasifAux_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV61TFConClasifAux_Sels.fromJSonString(AV59TFConClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCANTI") == 0 )
         {
            AV62TFLiqDCanti = CommonUtil.decimalVal( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV63TFLiqDCanti_To = CommonUtil.decimalVal( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPCALCU") == 0 )
         {
            AV66TFLiqDImpCalcu = CommonUtil.decimalVal( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV67TFLiqDImpCalcu_To = CommonUtil.decimalVal( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDLOGRECAL") == 0 )
         {
            AV93TFLiqDLogRecal = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDLOGRECAL_SEL") == 0 )
         {
            AV92TFLiqDLogRecal_SelsJson = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV94TFLiqDLogRecal_Sels.fromJSonString(AV92TFLiqDLogRecal_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV64TFLiqDImpReCalcu = CommonUtil.decimalVal( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV65TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV95MenuOpcCod = AV78GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV106GXV1 = (int)(AV106GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGIDOPTIONS' Routine */
      returnInSub = false ;
      AV12TFLegId = AV81SearchTxt ;
      AV13TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1M92 = false ;
         A6LegNumero = P01M92_A6LegNumero[0] ;
         A1580LegOsoCod = P01M92_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M92_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M92_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M92_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M92_A31LiqNro[0] ;
         A32TLiqCod = P01M92_A32TLiqCod[0] ;
         n32TLiqCod = P01M92_n32TLiqCod[0] ;
         A3CliCod = P01M92_A3CliCod[0] ;
         A1EmpCod = P01M92_A1EmpCod[0] ;
         A93LegId = P01M92_A93LegId[0] ;
         n93LegId = P01M92_n93LegId[0] ;
         A764LiqDImpReCalcu = P01M92_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M92_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M92_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M92_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M92_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M92_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M92_A464DTipoConCod[0] ;
         A393DConDescrip = P01M92_A393DConDescrip[0] ;
         A394DConCodigo = P01M92_A394DConCodigo[0] ;
         A280LiqFecPago = P01M92_A280LiqFecPago[0] ;
         A340TliqDesc = P01M92_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M92_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M92_A98LiqFecha[0] ;
         A271LiqDescrip = P01M92_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M92_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M92_A235LegClase[0] ;
         A2404LegModTra = P01M92_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M92_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M92_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M92_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M92_A329SecDescrip[0] ;
         n329SecDescrip = P01M92_n329SecDescrip[0] ;
         A874LiqNombre = P01M92_A874LiqNombre[0] ;
         A591LegNomApe = P01M92_A591LegNomApe[0] ;
         A81LiqDSecuencial = P01M92_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M92_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M92_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M92_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M92_n1579LegSecCodigo[0] ;
         A93LegId = P01M92_A93LegId[0] ;
         n93LegId = P01M92_n93LegId[0] ;
         A2417LegTipoTarifa = P01M92_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M92_A235LegClase[0] ;
         A2404LegModTra = P01M92_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M92_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M92_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M92_A591LegNomApe[0] ;
         A2225LegOsoDes = P01M92_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M92_A329SecDescrip[0] ;
         n329SecDescrip = P01M92_n329SecDescrip[0] ;
         A32TLiqCod = P01M92_A32TLiqCod[0] ;
         n32TLiqCod = P01M92_n32TLiqCod[0] ;
         A280LiqFecPago = P01M92_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M92_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M92_A98LiqFecha[0] ;
         A271LiqDescrip = P01M92_A271LiqDescrip[0] ;
         A874LiqNombre = P01M92_A874LiqNombre[0] ;
         A340TliqDesc = P01M92_A340TliqDesc[0] ;
         AV74count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01M92_A3CliCod[0] == A3CliCod ) && ( P01M92_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P01M92_A93LegId[0], A93LegId) == 0 ) )
         {
            brk1M92 = false ;
            A6LegNumero = P01M92_A6LegNumero[0] ;
            A31LiqNro = P01M92_A31LiqNro[0] ;
            A81LiqDSecuencial = P01M92_A81LiqDSecuencial[0] ;
            AV74count = (long)(AV74count+1) ;
            brk1M92 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A93LegId)==0) )
         {
            AV69Option = A93LegId ;
            AV70Options.add(AV69Option, 0);
            AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1M92 )
         {
            brk1M92 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLEGNOMAPEOPTIONS' Routine */
      returnInSub = false ;
      AV15TFLegNomApe = AV81SearchTxt ;
      AV16TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M93 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1M94 = false ;
         A6LegNumero = P01M93_A6LegNumero[0] ;
         A1580LegOsoCod = P01M93_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M93_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M93_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M93_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M93_A31LiqNro[0] ;
         A32TLiqCod = P01M93_A32TLiqCod[0] ;
         n32TLiqCod = P01M93_n32TLiqCod[0] ;
         A3CliCod = P01M93_A3CliCod[0] ;
         A1EmpCod = P01M93_A1EmpCod[0] ;
         A591LegNomApe = P01M93_A591LegNomApe[0] ;
         A764LiqDImpReCalcu = P01M93_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M93_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M93_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M93_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M93_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M93_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M93_A464DTipoConCod[0] ;
         A393DConDescrip = P01M93_A393DConDescrip[0] ;
         A394DConCodigo = P01M93_A394DConCodigo[0] ;
         A280LiqFecPago = P01M93_A280LiqFecPago[0] ;
         A340TliqDesc = P01M93_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M93_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M93_A98LiqFecha[0] ;
         A271LiqDescrip = P01M93_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M93_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M93_A235LegClase[0] ;
         A2404LegModTra = P01M93_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M93_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M93_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M93_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M93_A329SecDescrip[0] ;
         n329SecDescrip = P01M93_n329SecDescrip[0] ;
         A874LiqNombre = P01M93_A874LiqNombre[0] ;
         A93LegId = P01M93_A93LegId[0] ;
         n93LegId = P01M93_n93LegId[0] ;
         A81LiqDSecuencial = P01M93_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M93_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M93_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M93_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M93_n1579LegSecCodigo[0] ;
         A591LegNomApe = P01M93_A591LegNomApe[0] ;
         A2417LegTipoTarifa = P01M93_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M93_A235LegClase[0] ;
         A2404LegModTra = P01M93_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M93_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M93_n238LegCuentaBanc[0] ;
         A93LegId = P01M93_A93LegId[0] ;
         n93LegId = P01M93_n93LegId[0] ;
         A2225LegOsoDes = P01M93_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M93_A329SecDescrip[0] ;
         n329SecDescrip = P01M93_n329SecDescrip[0] ;
         A32TLiqCod = P01M93_A32TLiqCod[0] ;
         n32TLiqCod = P01M93_n32TLiqCod[0] ;
         A280LiqFecPago = P01M93_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M93_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M93_A98LiqFecha[0] ;
         A271LiqDescrip = P01M93_A271LiqDescrip[0] ;
         A874LiqNombre = P01M93_A874LiqNombre[0] ;
         A340TliqDesc = P01M93_A340TliqDesc[0] ;
         AV74count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01M93_A3CliCod[0] == A3CliCod ) && ( P01M93_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P01M93_A591LegNomApe[0], A591LegNomApe) == 0 ) )
         {
            brk1M94 = false ;
            A6LegNumero = P01M93_A6LegNumero[0] ;
            A31LiqNro = P01M93_A31LiqNro[0] ;
            A81LiqDSecuencial = P01M93_A81LiqDSecuencial[0] ;
            AV74count = (long)(AV74count+1) ;
            brk1M94 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A591LegNomApe)==0) )
         {
            AV69Option = A591LegNomApe ;
            AV70Options.add(AV69Option, 0);
            AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1M94 )
         {
            brk1M94 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADLIQNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV18TFLiqNombre = AV81SearchTxt ;
      AV19TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M94 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A6LegNumero = P01M94_A6LegNumero[0] ;
         A1580LegOsoCod = P01M94_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M94_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M94_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M94_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M94_A31LiqNro[0] ;
         A32TLiqCod = P01M94_A32TLiqCod[0] ;
         n32TLiqCod = P01M94_n32TLiqCod[0] ;
         A1EmpCod = P01M94_A1EmpCod[0] ;
         A3CliCod = P01M94_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M94_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M94_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M94_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M94_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M94_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M94_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M94_A464DTipoConCod[0] ;
         A393DConDescrip = P01M94_A393DConDescrip[0] ;
         A394DConCodigo = P01M94_A394DConCodigo[0] ;
         A280LiqFecPago = P01M94_A280LiqFecPago[0] ;
         A340TliqDesc = P01M94_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M94_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M94_A98LiqFecha[0] ;
         A271LiqDescrip = P01M94_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M94_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M94_A235LegClase[0] ;
         A2404LegModTra = P01M94_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M94_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M94_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M94_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M94_A329SecDescrip[0] ;
         n329SecDescrip = P01M94_n329SecDescrip[0] ;
         A874LiqNombre = P01M94_A874LiqNombre[0] ;
         A591LegNomApe = P01M94_A591LegNomApe[0] ;
         A93LegId = P01M94_A93LegId[0] ;
         n93LegId = P01M94_n93LegId[0] ;
         A81LiqDSecuencial = P01M94_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M94_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M94_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M94_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M94_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M94_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M94_A235LegClase[0] ;
         A2404LegModTra = P01M94_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M94_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M94_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M94_A591LegNomApe[0] ;
         A93LegId = P01M94_A93LegId[0] ;
         n93LegId = P01M94_n93LegId[0] ;
         A2225LegOsoDes = P01M94_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M94_A329SecDescrip[0] ;
         n329SecDescrip = P01M94_n329SecDescrip[0] ;
         A32TLiqCod = P01M94_A32TLiqCod[0] ;
         n32TLiqCod = P01M94_n32TLiqCod[0] ;
         A280LiqFecPago = P01M94_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M94_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M94_A98LiqFecha[0] ;
         A271LiqDescrip = P01M94_A271LiqDescrip[0] ;
         A874LiqNombre = P01M94_A874LiqNombre[0] ;
         A340TliqDesc = P01M94_A340TliqDesc[0] ;
         if ( ! (GXutil.strcmp("", A874LiqNombre)==0) )
         {
            AV69Option = A874LiqNombre ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADSECDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV21TFSecDescrip = AV81SearchTxt ;
      AV22TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M95 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A6LegNumero = P01M95_A6LegNumero[0] ;
         A1580LegOsoCod = P01M95_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M95_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M95_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M95_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M95_A31LiqNro[0] ;
         A32TLiqCod = P01M95_A32TLiqCod[0] ;
         n32TLiqCod = P01M95_n32TLiqCod[0] ;
         A1EmpCod = P01M95_A1EmpCod[0] ;
         A3CliCod = P01M95_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M95_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M95_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M95_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M95_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M95_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M95_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M95_A464DTipoConCod[0] ;
         A393DConDescrip = P01M95_A393DConDescrip[0] ;
         A394DConCodigo = P01M95_A394DConCodigo[0] ;
         A280LiqFecPago = P01M95_A280LiqFecPago[0] ;
         A340TliqDesc = P01M95_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M95_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M95_A98LiqFecha[0] ;
         A271LiqDescrip = P01M95_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M95_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M95_A235LegClase[0] ;
         A2404LegModTra = P01M95_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M95_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M95_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M95_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M95_A329SecDescrip[0] ;
         n329SecDescrip = P01M95_n329SecDescrip[0] ;
         A874LiqNombre = P01M95_A874LiqNombre[0] ;
         A591LegNomApe = P01M95_A591LegNomApe[0] ;
         A93LegId = P01M95_A93LegId[0] ;
         n93LegId = P01M95_n93LegId[0] ;
         A81LiqDSecuencial = P01M95_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M95_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M95_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M95_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M95_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M95_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M95_A235LegClase[0] ;
         A2404LegModTra = P01M95_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M95_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M95_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M95_A591LegNomApe[0] ;
         A93LegId = P01M95_A93LegId[0] ;
         n93LegId = P01M95_n93LegId[0] ;
         A2225LegOsoDes = P01M95_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M95_A329SecDescrip[0] ;
         n329SecDescrip = P01M95_n329SecDescrip[0] ;
         A32TLiqCod = P01M95_A32TLiqCod[0] ;
         n32TLiqCod = P01M95_n32TLiqCod[0] ;
         A280LiqFecPago = P01M95_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M95_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M95_A98LiqFecha[0] ;
         A271LiqDescrip = P01M95_A271LiqDescrip[0] ;
         A874LiqNombre = P01M95_A874LiqNombre[0] ;
         A340TliqDesc = P01M95_A340TliqDesc[0] ;
         if ( ! (GXutil.strcmp("", A329SecDescrip)==0) )
         {
            AV69Option = A329SecDescrip ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADLEGOSODESOPTIONS' Routine */
      returnInSub = false ;
      AV98TFLegOsoDes = AV81SearchTxt ;
      AV99TFLegOsoDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M96 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A6LegNumero = P01M96_A6LegNumero[0] ;
         A1580LegOsoCod = P01M96_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M96_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M96_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M96_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M96_A31LiqNro[0] ;
         A32TLiqCod = P01M96_A32TLiqCod[0] ;
         n32TLiqCod = P01M96_n32TLiqCod[0] ;
         A1EmpCod = P01M96_A1EmpCod[0] ;
         A3CliCod = P01M96_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M96_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M96_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M96_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M96_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M96_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M96_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M96_A464DTipoConCod[0] ;
         A393DConDescrip = P01M96_A393DConDescrip[0] ;
         A394DConCodigo = P01M96_A394DConCodigo[0] ;
         A280LiqFecPago = P01M96_A280LiqFecPago[0] ;
         A340TliqDesc = P01M96_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M96_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M96_A98LiqFecha[0] ;
         A271LiqDescrip = P01M96_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M96_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M96_A235LegClase[0] ;
         A2404LegModTra = P01M96_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M96_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M96_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M96_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M96_A329SecDescrip[0] ;
         n329SecDescrip = P01M96_n329SecDescrip[0] ;
         A874LiqNombre = P01M96_A874LiqNombre[0] ;
         A591LegNomApe = P01M96_A591LegNomApe[0] ;
         A93LegId = P01M96_A93LegId[0] ;
         n93LegId = P01M96_n93LegId[0] ;
         A81LiqDSecuencial = P01M96_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M96_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M96_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M96_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M96_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M96_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M96_A235LegClase[0] ;
         A2404LegModTra = P01M96_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M96_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M96_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M96_A591LegNomApe[0] ;
         A93LegId = P01M96_A93LegId[0] ;
         n93LegId = P01M96_n93LegId[0] ;
         A2225LegOsoDes = P01M96_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M96_A329SecDescrip[0] ;
         n329SecDescrip = P01M96_n329SecDescrip[0] ;
         A32TLiqCod = P01M96_A32TLiqCod[0] ;
         n32TLiqCod = P01M96_n32TLiqCod[0] ;
         A280LiqFecPago = P01M96_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M96_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M96_A98LiqFecha[0] ;
         A271LiqDescrip = P01M96_A271LiqDescrip[0] ;
         A874LiqNombre = P01M96_A874LiqNombre[0] ;
         A340TliqDesc = P01M96_A340TliqDesc[0] ;
         if ( ! (GXutil.strcmp("", A2225LegOsoDes)==0) )
         {
            AV69Option = A2225LegOsoDes ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADLEGCUENTABANCOPTIONS' Routine */
      returnInSub = false ;
      AV29TFLegCuentaBanc = AV81SearchTxt ;
      AV30TFLegCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M97 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A6LegNumero = P01M97_A6LegNumero[0] ;
         A1580LegOsoCod = P01M97_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M97_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M97_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M97_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M97_A31LiqNro[0] ;
         A32TLiqCod = P01M97_A32TLiqCod[0] ;
         n32TLiqCod = P01M97_n32TLiqCod[0] ;
         A1EmpCod = P01M97_A1EmpCod[0] ;
         A3CliCod = P01M97_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M97_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M97_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M97_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M97_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M97_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M97_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M97_A464DTipoConCod[0] ;
         A393DConDescrip = P01M97_A393DConDescrip[0] ;
         A394DConCodigo = P01M97_A394DConCodigo[0] ;
         A280LiqFecPago = P01M97_A280LiqFecPago[0] ;
         A340TliqDesc = P01M97_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M97_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M97_A98LiqFecha[0] ;
         A271LiqDescrip = P01M97_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M97_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M97_A235LegClase[0] ;
         A2404LegModTra = P01M97_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M97_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M97_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M97_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M97_A329SecDescrip[0] ;
         n329SecDescrip = P01M97_n329SecDescrip[0] ;
         A874LiqNombre = P01M97_A874LiqNombre[0] ;
         A591LegNomApe = P01M97_A591LegNomApe[0] ;
         A93LegId = P01M97_A93LegId[0] ;
         n93LegId = P01M97_n93LegId[0] ;
         A81LiqDSecuencial = P01M97_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M97_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M97_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M97_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M97_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M97_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M97_A235LegClase[0] ;
         A2404LegModTra = P01M97_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M97_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M97_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M97_A591LegNomApe[0] ;
         A93LegId = P01M97_A93LegId[0] ;
         n93LegId = P01M97_n93LegId[0] ;
         A2225LegOsoDes = P01M97_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M97_A329SecDescrip[0] ;
         n329SecDescrip = P01M97_n329SecDescrip[0] ;
         A32TLiqCod = P01M97_A32TLiqCod[0] ;
         n32TLiqCod = P01M97_n32TLiqCod[0] ;
         A280LiqFecPago = P01M97_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M97_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M97_A98LiqFecha[0] ;
         A271LiqDescrip = P01M97_A271LiqDescrip[0] ;
         A874LiqNombre = P01M97_A874LiqNombre[0] ;
         A340TliqDesc = P01M97_A340TliqDesc[0] ;
         if ( ! (GXutil.strcmp("", A238LegCuentaBanc)==0) )
         {
            AV69Option = A238LegCuentaBanc ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(5);
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADLEGCLASEOPTIONS' Routine */
      returnInSub = false ;
      AV32TFLegClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "") ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M98 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A6LegNumero = P01M98_A6LegNumero[0] ;
         A1580LegOsoCod = P01M98_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M98_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M98_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M98_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M98_A31LiqNro[0] ;
         A32TLiqCod = P01M98_A32TLiqCod[0] ;
         n32TLiqCod = P01M98_n32TLiqCod[0] ;
         A1EmpCod = P01M98_A1EmpCod[0] ;
         A3CliCod = P01M98_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M98_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M98_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M98_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M98_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M98_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M98_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M98_A464DTipoConCod[0] ;
         A393DConDescrip = P01M98_A393DConDescrip[0] ;
         A394DConCodigo = P01M98_A394DConCodigo[0] ;
         A280LiqFecPago = P01M98_A280LiqFecPago[0] ;
         A340TliqDesc = P01M98_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M98_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M98_A98LiqFecha[0] ;
         A271LiqDescrip = P01M98_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M98_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M98_A235LegClase[0] ;
         A2404LegModTra = P01M98_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M98_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M98_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M98_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M98_A329SecDescrip[0] ;
         n329SecDescrip = P01M98_n329SecDescrip[0] ;
         A874LiqNombre = P01M98_A874LiqNombre[0] ;
         A591LegNomApe = P01M98_A591LegNomApe[0] ;
         A93LegId = P01M98_A93LegId[0] ;
         n93LegId = P01M98_n93LegId[0] ;
         A81LiqDSecuencial = P01M98_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M98_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M98_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M98_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M98_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M98_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M98_A235LegClase[0] ;
         A2404LegModTra = P01M98_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M98_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M98_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M98_A591LegNomApe[0] ;
         A93LegId = P01M98_A93LegId[0] ;
         n93LegId = P01M98_n93LegId[0] ;
         A2225LegOsoDes = P01M98_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M98_A329SecDescrip[0] ;
         n329SecDescrip = P01M98_n329SecDescrip[0] ;
         A32TLiqCod = P01M98_A32TLiqCod[0] ;
         n32TLiqCod = P01M98_n32TLiqCod[0] ;
         A280LiqFecPago = P01M98_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M98_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M98_A98LiqFecha[0] ;
         A271LiqDescrip = P01M98_A271LiqDescrip[0] ;
         A874LiqNombre = P01M98_A874LiqNombre[0] ;
         A340TliqDesc = P01M98_A340TliqDesc[0] ;
         if ( ! (0==A235LegClase) )
         {
            AV69Option = GXutil.str( A235LegClase, 1, 0) ;
            AV71OptionDesc = GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)A235LegClase), "")) ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV72OptionsDesc.elementAt(-1+AV68InsertIndex), AV71OptionDesc) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV72OptionsDesc.elementAt(-1+AV68InsertIndex), AV71OptionDesc) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV72OptionsDesc.add(AV71OptionDesc, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(6);
      }
      pr_default.close(6);
   }

   public void S191( )
   {
      /* 'LOADLIQDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV37TFLiqDescrip = AV81SearchTxt ;
      AV38TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M99 */
      pr_default.execute(7, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A6LegNumero = P01M99_A6LegNumero[0] ;
         A1580LegOsoCod = P01M99_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M99_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M99_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M99_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M99_A31LiqNro[0] ;
         A32TLiqCod = P01M99_A32TLiqCod[0] ;
         n32TLiqCod = P01M99_n32TLiqCod[0] ;
         A1EmpCod = P01M99_A1EmpCod[0] ;
         A3CliCod = P01M99_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M99_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M99_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M99_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M99_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M99_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M99_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M99_A464DTipoConCod[0] ;
         A393DConDescrip = P01M99_A393DConDescrip[0] ;
         A394DConCodigo = P01M99_A394DConCodigo[0] ;
         A280LiqFecPago = P01M99_A280LiqFecPago[0] ;
         A340TliqDesc = P01M99_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M99_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M99_A98LiqFecha[0] ;
         A271LiqDescrip = P01M99_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M99_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M99_A235LegClase[0] ;
         A2404LegModTra = P01M99_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M99_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M99_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M99_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M99_A329SecDescrip[0] ;
         n329SecDescrip = P01M99_n329SecDescrip[0] ;
         A874LiqNombre = P01M99_A874LiqNombre[0] ;
         A591LegNomApe = P01M99_A591LegNomApe[0] ;
         A93LegId = P01M99_A93LegId[0] ;
         n93LegId = P01M99_n93LegId[0] ;
         A81LiqDSecuencial = P01M99_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M99_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M99_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M99_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M99_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M99_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M99_A235LegClase[0] ;
         A2404LegModTra = P01M99_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M99_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M99_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M99_A591LegNomApe[0] ;
         A93LegId = P01M99_A93LegId[0] ;
         n93LegId = P01M99_n93LegId[0] ;
         A2225LegOsoDes = P01M99_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M99_A329SecDescrip[0] ;
         n329SecDescrip = P01M99_n329SecDescrip[0] ;
         A32TLiqCod = P01M99_A32TLiqCod[0] ;
         n32TLiqCod = P01M99_n32TLiqCod[0] ;
         A280LiqFecPago = P01M99_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M99_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M99_A98LiqFecha[0] ;
         A271LiqDescrip = P01M99_A271LiqDescrip[0] ;
         A874LiqNombre = P01M99_A874LiqNombre[0] ;
         A340TliqDesc = P01M99_A340TliqDesc[0] ;
         if ( ! (GXutil.strcmp("", A271LiqDescrip)==0) )
         {
            AV69Option = A271LiqDescrip ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(7);
      }
      pr_default.close(7);
   }

   public void S201( )
   {
      /* 'LOADLIQFECHAOPTIONS' Routine */
      returnInSub = false ;
      AV40TFLiqFecha = localUtil.ctod( AV81SearchTxt, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      AV41TFLiqFecha_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      pr_default.dynParam(8, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M910 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A6LegNumero = P01M910_A6LegNumero[0] ;
         A1580LegOsoCod = P01M910_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M910_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M910_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M910_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M910_A31LiqNro[0] ;
         A32TLiqCod = P01M910_A32TLiqCod[0] ;
         n32TLiqCod = P01M910_n32TLiqCod[0] ;
         A1EmpCod = P01M910_A1EmpCod[0] ;
         A3CliCod = P01M910_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M910_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M910_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M910_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M910_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M910_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M910_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M910_A464DTipoConCod[0] ;
         A393DConDescrip = P01M910_A393DConDescrip[0] ;
         A394DConCodigo = P01M910_A394DConCodigo[0] ;
         A280LiqFecPago = P01M910_A280LiqFecPago[0] ;
         A340TliqDesc = P01M910_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M910_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M910_A98LiqFecha[0] ;
         A271LiqDescrip = P01M910_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M910_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M910_A235LegClase[0] ;
         A2404LegModTra = P01M910_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M910_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M910_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M910_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M910_A329SecDescrip[0] ;
         n329SecDescrip = P01M910_n329SecDescrip[0] ;
         A874LiqNombre = P01M910_A874LiqNombre[0] ;
         A591LegNomApe = P01M910_A591LegNomApe[0] ;
         A93LegId = P01M910_A93LegId[0] ;
         n93LegId = P01M910_n93LegId[0] ;
         A81LiqDSecuencial = P01M910_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M910_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M910_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M910_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M910_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M910_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M910_A235LegClase[0] ;
         A2404LegModTra = P01M910_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M910_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M910_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M910_A591LegNomApe[0] ;
         A93LegId = P01M910_A93LegId[0] ;
         n93LegId = P01M910_n93LegId[0] ;
         A2225LegOsoDes = P01M910_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M910_A329SecDescrip[0] ;
         n329SecDescrip = P01M910_n329SecDescrip[0] ;
         A32TLiqCod = P01M910_A32TLiqCod[0] ;
         n32TLiqCod = P01M910_n32TLiqCod[0] ;
         A280LiqFecPago = P01M910_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M910_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M910_A98LiqFecha[0] ;
         A271LiqDescrip = P01M910_A271LiqDescrip[0] ;
         A874LiqNombre = P01M910_A874LiqNombre[0] ;
         A340TliqDesc = P01M910_A340TliqDesc[0] ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A98LiqFecha)) )
         {
            AV69Option = localUtil.dtoc( A98LiqFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(8);
      }
      pr_default.close(8);
   }

   public void S211( )
   {
      /* 'LOADLIQPERSINDIAOPTIONS' Routine */
      returnInSub = false ;
      AV43TFLiqPerSinDia = AV81SearchTxt ;
      AV44TFLiqPerSinDia_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(9, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV87EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M911 */
      pr_default.execute(9, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(9) != 101) )
      {
         brk1M913 = false ;
         A6LegNumero = P01M911_A6LegNumero[0] ;
         A1580LegOsoCod = P01M911_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M911_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M911_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M911_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M911_A31LiqNro[0] ;
         A32TLiqCod = P01M911_A32TLiqCod[0] ;
         n32TLiqCod = P01M911_n32TLiqCod[0] ;
         A3CliCod = P01M911_A3CliCod[0] ;
         A1EmpCod = P01M911_A1EmpCod[0] ;
         A513LiqPerSinDia = P01M911_A513LiqPerSinDia[0] ;
         A764LiqDImpReCalcu = P01M911_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M911_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M911_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M911_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M911_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M911_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M911_A464DTipoConCod[0] ;
         A393DConDescrip = P01M911_A393DConDescrip[0] ;
         A394DConCodigo = P01M911_A394DConCodigo[0] ;
         A280LiqFecPago = P01M911_A280LiqFecPago[0] ;
         A340TliqDesc = P01M911_A340TliqDesc[0] ;
         A98LiqFecha = P01M911_A98LiqFecha[0] ;
         A271LiqDescrip = P01M911_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M911_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M911_A235LegClase[0] ;
         A2404LegModTra = P01M911_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M911_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M911_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M911_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M911_A329SecDescrip[0] ;
         n329SecDescrip = P01M911_n329SecDescrip[0] ;
         A874LiqNombre = P01M911_A874LiqNombre[0] ;
         A591LegNomApe = P01M911_A591LegNomApe[0] ;
         A93LegId = P01M911_A93LegId[0] ;
         n93LegId = P01M911_n93LegId[0] ;
         A81LiqDSecuencial = P01M911_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M911_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M911_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M911_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M911_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M911_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M911_A235LegClase[0] ;
         A2404LegModTra = P01M911_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M911_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M911_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M911_A591LegNomApe[0] ;
         A93LegId = P01M911_A93LegId[0] ;
         n93LegId = P01M911_n93LegId[0] ;
         A2225LegOsoDes = P01M911_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M911_A329SecDescrip[0] ;
         n329SecDescrip = P01M911_n329SecDescrip[0] ;
         A32TLiqCod = P01M911_A32TLiqCod[0] ;
         n32TLiqCod = P01M911_n32TLiqCod[0] ;
         A513LiqPerSinDia = P01M911_A513LiqPerSinDia[0] ;
         A280LiqFecPago = P01M911_A280LiqFecPago[0] ;
         A98LiqFecha = P01M911_A98LiqFecha[0] ;
         A271LiqDescrip = P01M911_A271LiqDescrip[0] ;
         A874LiqNombre = P01M911_A874LiqNombre[0] ;
         A340TliqDesc = P01M911_A340TliqDesc[0] ;
         AV74count = 0 ;
         while ( (pr_default.getStatus(9) != 101) && ( GXutil.strcmp(P01M911_A513LiqPerSinDia[0], A513LiqPerSinDia) == 0 ) )
         {
            brk1M913 = false ;
            A6LegNumero = P01M911_A6LegNumero[0] ;
            A31LiqNro = P01M911_A31LiqNro[0] ;
            A3CliCod = P01M911_A3CliCod[0] ;
            A1EmpCod = P01M911_A1EmpCod[0] ;
            A81LiqDSecuencial = P01M911_A81LiqDSecuencial[0] ;
            AV74count = (long)(AV74count+1) ;
            brk1M913 = true ;
            pr_default.readNext(9);
         }
         if ( ! (GXutil.strcmp("", A513LiqPerSinDia)==0) )
         {
            AV69Option = A513LiqPerSinDia ;
            AV70Options.add(AV69Option, 0);
            AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1M913 )
         {
            brk1M913 = true ;
            pr_default.readNext(9);
         }
      }
      pr_default.close(9);
   }

   public void S221( )
   {
      /* 'LOADTLIQDESCOPTIONS' Routine */
      returnInSub = false ;
      AV46TFTliqDesc = AV81SearchTxt ;
      AV47TFTliqDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(10, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M912 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(10) != 101) )
      {
         A6LegNumero = P01M912_A6LegNumero[0] ;
         A1580LegOsoCod = P01M912_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M912_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M912_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M912_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M912_A31LiqNro[0] ;
         A32TLiqCod = P01M912_A32TLiqCod[0] ;
         n32TLiqCod = P01M912_n32TLiqCod[0] ;
         A1EmpCod = P01M912_A1EmpCod[0] ;
         A3CliCod = P01M912_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M912_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M912_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M912_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M912_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M912_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M912_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M912_A464DTipoConCod[0] ;
         A393DConDescrip = P01M912_A393DConDescrip[0] ;
         A394DConCodigo = P01M912_A394DConCodigo[0] ;
         A280LiqFecPago = P01M912_A280LiqFecPago[0] ;
         A340TliqDesc = P01M912_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M912_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M912_A98LiqFecha[0] ;
         A271LiqDescrip = P01M912_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M912_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M912_A235LegClase[0] ;
         A2404LegModTra = P01M912_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M912_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M912_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M912_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M912_A329SecDescrip[0] ;
         n329SecDescrip = P01M912_n329SecDescrip[0] ;
         A874LiqNombre = P01M912_A874LiqNombre[0] ;
         A591LegNomApe = P01M912_A591LegNomApe[0] ;
         A93LegId = P01M912_A93LegId[0] ;
         n93LegId = P01M912_n93LegId[0] ;
         A81LiqDSecuencial = P01M912_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M912_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M912_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M912_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M912_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M912_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M912_A235LegClase[0] ;
         A2404LegModTra = P01M912_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M912_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M912_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M912_A591LegNomApe[0] ;
         A93LegId = P01M912_A93LegId[0] ;
         n93LegId = P01M912_n93LegId[0] ;
         A2225LegOsoDes = P01M912_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M912_A329SecDescrip[0] ;
         n329SecDescrip = P01M912_n329SecDescrip[0] ;
         A32TLiqCod = P01M912_A32TLiqCod[0] ;
         n32TLiqCod = P01M912_n32TLiqCod[0] ;
         A280LiqFecPago = P01M912_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M912_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M912_A98LiqFecha[0] ;
         A271LiqDescrip = P01M912_A271LiqDescrip[0] ;
         A874LiqNombre = P01M912_A874LiqNombre[0] ;
         A340TliqDesc = P01M912_A340TliqDesc[0] ;
         if ( ! (GXutil.strcmp("", A340TliqDesc)==0) )
         {
            AV69Option = A340TliqDesc ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(10);
      }
      pr_default.close(10);
   }

   public void S231( )
   {
      /* 'LOADLIQFECPAGOOPTIONS' Routine */
      returnInSub = false ;
      AV49TFLiqFecPago = localUtil.ctod( AV81SearchTxt, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      AV50TFLiqFecPago_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "") ;
      pr_default.dynParam(11, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M913 */
      pr_default.execute(11, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(11) != 101) )
      {
         A6LegNumero = P01M913_A6LegNumero[0] ;
         A1580LegOsoCod = P01M913_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M913_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M913_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M913_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M913_A31LiqNro[0] ;
         A32TLiqCod = P01M913_A32TLiqCod[0] ;
         n32TLiqCod = P01M913_n32TLiqCod[0] ;
         A1EmpCod = P01M913_A1EmpCod[0] ;
         A3CliCod = P01M913_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M913_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M913_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M913_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M913_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M913_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M913_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M913_A464DTipoConCod[0] ;
         A393DConDescrip = P01M913_A393DConDescrip[0] ;
         A394DConCodigo = P01M913_A394DConCodigo[0] ;
         A280LiqFecPago = P01M913_A280LiqFecPago[0] ;
         A340TliqDesc = P01M913_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M913_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M913_A98LiqFecha[0] ;
         A271LiqDescrip = P01M913_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M913_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M913_A235LegClase[0] ;
         A2404LegModTra = P01M913_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M913_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M913_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M913_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M913_A329SecDescrip[0] ;
         n329SecDescrip = P01M913_n329SecDescrip[0] ;
         A874LiqNombre = P01M913_A874LiqNombre[0] ;
         A591LegNomApe = P01M913_A591LegNomApe[0] ;
         A93LegId = P01M913_A93LegId[0] ;
         n93LegId = P01M913_n93LegId[0] ;
         A81LiqDSecuencial = P01M913_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M913_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M913_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M913_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M913_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M913_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M913_A235LegClase[0] ;
         A2404LegModTra = P01M913_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M913_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M913_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M913_A591LegNomApe[0] ;
         A93LegId = P01M913_A93LegId[0] ;
         n93LegId = P01M913_n93LegId[0] ;
         A2225LegOsoDes = P01M913_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M913_A329SecDescrip[0] ;
         n329SecDescrip = P01M913_n329SecDescrip[0] ;
         A32TLiqCod = P01M913_A32TLiqCod[0] ;
         n32TLiqCod = P01M913_n32TLiqCod[0] ;
         A280LiqFecPago = P01M913_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M913_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M913_A98LiqFecha[0] ;
         A271LiqDescrip = P01M913_A271LiqDescrip[0] ;
         A874LiqNombre = P01M913_A874LiqNombre[0] ;
         A340TliqDesc = P01M913_A340TliqDesc[0] ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A280LiqFecPago)) )
         {
            AV69Option = localUtil.dtoc( A280LiqFecPago, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) == 0 ) )
            {
               AV74count = GXutil.lval( (String)AV73OptionIndexes.elementAt(-1+AV68InsertIndex)) ;
               AV74count = (long)(AV74count+1) ;
               AV73OptionIndexes.removeItem(AV68InsertIndex);
               AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), AV68InsertIndex);
            }
            else
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
               AV73OptionIndexes.add("1", AV68InsertIndex);
            }
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(11);
      }
      pr_default.close(11);
   }

   public void S241( )
   {
      /* 'LOADDCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV52TFDConCodigo = AV81SearchTxt ;
      AV53TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(12, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV87EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M914 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(12) != 101) )
      {
         brk1M917 = false ;
         A6LegNumero = P01M914_A6LegNumero[0] ;
         A1580LegOsoCod = P01M914_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M914_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M914_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M914_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M914_A31LiqNro[0] ;
         A32TLiqCod = P01M914_A32TLiqCod[0] ;
         n32TLiqCod = P01M914_n32TLiqCod[0] ;
         A3CliCod = P01M914_A3CliCod[0] ;
         A1EmpCod = P01M914_A1EmpCod[0] ;
         A394DConCodigo = P01M914_A394DConCodigo[0] ;
         A764LiqDImpReCalcu = P01M914_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M914_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M914_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M914_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M914_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M914_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M914_A464DTipoConCod[0] ;
         A393DConDescrip = P01M914_A393DConDescrip[0] ;
         A280LiqFecPago = P01M914_A280LiqFecPago[0] ;
         A340TliqDesc = P01M914_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M914_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M914_A98LiqFecha[0] ;
         A271LiqDescrip = P01M914_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M914_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M914_A235LegClase[0] ;
         A2404LegModTra = P01M914_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M914_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M914_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M914_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M914_A329SecDescrip[0] ;
         n329SecDescrip = P01M914_n329SecDescrip[0] ;
         A874LiqNombre = P01M914_A874LiqNombre[0] ;
         A591LegNomApe = P01M914_A591LegNomApe[0] ;
         A93LegId = P01M914_A93LegId[0] ;
         n93LegId = P01M914_n93LegId[0] ;
         A81LiqDSecuencial = P01M914_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M914_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M914_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M914_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M914_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M914_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M914_A235LegClase[0] ;
         A2404LegModTra = P01M914_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M914_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M914_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M914_A591LegNomApe[0] ;
         A93LegId = P01M914_A93LegId[0] ;
         n93LegId = P01M914_n93LegId[0] ;
         A2225LegOsoDes = P01M914_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M914_A329SecDescrip[0] ;
         n329SecDescrip = P01M914_n329SecDescrip[0] ;
         A32TLiqCod = P01M914_A32TLiqCod[0] ;
         n32TLiqCod = P01M914_n32TLiqCod[0] ;
         A280LiqFecPago = P01M914_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M914_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M914_A98LiqFecha[0] ;
         A271LiqDescrip = P01M914_A271LiqDescrip[0] ;
         A874LiqNombre = P01M914_A874LiqNombre[0] ;
         A340TliqDesc = P01M914_A340TliqDesc[0] ;
         AV74count = 0 ;
         while ( (pr_default.getStatus(12) != 101) && ( GXutil.strcmp(P01M914_A394DConCodigo[0], A394DConCodigo) == 0 ) )
         {
            brk1M917 = false ;
            A6LegNumero = P01M914_A6LegNumero[0] ;
            A31LiqNro = P01M914_A31LiqNro[0] ;
            A3CliCod = P01M914_A3CliCod[0] ;
            A1EmpCod = P01M914_A1EmpCod[0] ;
            A81LiqDSecuencial = P01M914_A81LiqDSecuencial[0] ;
            AV74count = (long)(AV74count+1) ;
            brk1M917 = true ;
            pr_default.readNext(12);
         }
         if ( ! (GXutil.strcmp("", A394DConCodigo)==0) )
         {
            AV69Option = A394DConCodigo ;
            AV70Options.add(AV69Option, 0);
            AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1M917 )
         {
            brk1M917 = true ;
            pr_default.readNext(12);
         }
      }
      pr_default.close(12);
   }

   public void S251( )
   {
      /* 'LOADDCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV55TFDConDescrip = AV81SearchTxt ;
      AV56TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(13, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M915 */
      pr_default.execute(13, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(13) != 101) )
      {
         brk1M919 = false ;
         A6LegNumero = P01M915_A6LegNumero[0] ;
         A1580LegOsoCod = P01M915_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M915_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M915_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M915_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M915_A31LiqNro[0] ;
         A32TLiqCod = P01M915_A32TLiqCod[0] ;
         n32TLiqCod = P01M915_n32TLiqCod[0] ;
         A3CliCod = P01M915_A3CliCod[0] ;
         A1EmpCod = P01M915_A1EmpCod[0] ;
         A393DConDescrip = P01M915_A393DConDescrip[0] ;
         A764LiqDImpReCalcu = P01M915_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M915_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M915_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M915_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M915_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M915_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M915_A464DTipoConCod[0] ;
         A394DConCodigo = P01M915_A394DConCodigo[0] ;
         A280LiqFecPago = P01M915_A280LiqFecPago[0] ;
         A340TliqDesc = P01M915_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M915_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M915_A98LiqFecha[0] ;
         A271LiqDescrip = P01M915_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M915_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M915_A235LegClase[0] ;
         A2404LegModTra = P01M915_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M915_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M915_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M915_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M915_A329SecDescrip[0] ;
         n329SecDescrip = P01M915_n329SecDescrip[0] ;
         A874LiqNombre = P01M915_A874LiqNombre[0] ;
         A591LegNomApe = P01M915_A591LegNomApe[0] ;
         A93LegId = P01M915_A93LegId[0] ;
         n93LegId = P01M915_n93LegId[0] ;
         A81LiqDSecuencial = P01M915_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M915_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M915_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M915_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M915_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M915_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M915_A235LegClase[0] ;
         A2404LegModTra = P01M915_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M915_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M915_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M915_A591LegNomApe[0] ;
         A93LegId = P01M915_A93LegId[0] ;
         n93LegId = P01M915_n93LegId[0] ;
         A2225LegOsoDes = P01M915_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M915_A329SecDescrip[0] ;
         n329SecDescrip = P01M915_n329SecDescrip[0] ;
         A32TLiqCod = P01M915_A32TLiqCod[0] ;
         n32TLiqCod = P01M915_n32TLiqCod[0] ;
         A280LiqFecPago = P01M915_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M915_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M915_A98LiqFecha[0] ;
         A271LiqDescrip = P01M915_A271LiqDescrip[0] ;
         A874LiqNombre = P01M915_A874LiqNombre[0] ;
         A340TliqDesc = P01M915_A340TliqDesc[0] ;
         AV74count = 0 ;
         while ( (pr_default.getStatus(13) != 101) && ( P01M915_A3CliCod[0] == A3CliCod ) && ( P01M915_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P01M915_A393DConDescrip[0], A393DConDescrip) == 0 ) )
         {
            brk1M919 = false ;
            A6LegNumero = P01M915_A6LegNumero[0] ;
            A31LiqNro = P01M915_A31LiqNro[0] ;
            A81LiqDSecuencial = P01M915_A81LiqDSecuencial[0] ;
            AV74count = (long)(AV74count+1) ;
            brk1M919 = true ;
            pr_default.readNext(13);
         }
         if ( ! (GXutil.strcmp("", A393DConDescrip)==0) )
         {
            AV69Option = A393DConDescrip ;
            AV70Options.add(AV69Option, 0);
            AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1M919 )
         {
            brk1M919 = true ;
            pr_default.readNext(13);
         }
      }
      pr_default.close(13);
   }

   public void S261( )
   {
      /* 'LOADCONCLASIFAUXOPTIONS' Routine */
      returnInSub = false ;
      AV60TFConClasifAux = AV81SearchTxt ;
      AV61TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(14, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(AV87EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M916 */
      pr_default.execute(14, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(14) != 101) )
      {
         A6LegNumero = P01M916_A6LegNumero[0] ;
         A1580LegOsoCod = P01M916_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M916_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M916_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M916_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M916_A31LiqNro[0] ;
         A32TLiqCod = P01M916_A32TLiqCod[0] ;
         n32TLiqCod = P01M916_n32TLiqCod[0] ;
         A1EmpCod = P01M916_A1EmpCod[0] ;
         A3CliCod = P01M916_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01M916_A764LiqDImpReCalcu[0] ;
         A1072LiqDLogRecal = P01M916_A1072LiqDLogRecal[0] ;
         A275LiqDImpCalcu = P01M916_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M916_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M916_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M916_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M916_A464DTipoConCod[0] ;
         A393DConDescrip = P01M916_A393DConDescrip[0] ;
         A394DConCodigo = P01M916_A394DConCodigo[0] ;
         A280LiqFecPago = P01M916_A280LiqFecPago[0] ;
         A340TliqDesc = P01M916_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M916_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M916_A98LiqFecha[0] ;
         A271LiqDescrip = P01M916_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M916_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M916_A235LegClase[0] ;
         A2404LegModTra = P01M916_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M916_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M916_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M916_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M916_A329SecDescrip[0] ;
         n329SecDescrip = P01M916_n329SecDescrip[0] ;
         A874LiqNombre = P01M916_A874LiqNombre[0] ;
         A591LegNomApe = P01M916_A591LegNomApe[0] ;
         A93LegId = P01M916_A93LegId[0] ;
         n93LegId = P01M916_n93LegId[0] ;
         A81LiqDSecuencial = P01M916_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M916_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M916_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M916_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M916_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M916_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M916_A235LegClase[0] ;
         A2404LegModTra = P01M916_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M916_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M916_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M916_A591LegNomApe[0] ;
         A93LegId = P01M916_A93LegId[0] ;
         n93LegId = P01M916_n93LegId[0] ;
         A2225LegOsoDes = P01M916_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M916_A329SecDescrip[0] ;
         n329SecDescrip = P01M916_n329SecDescrip[0] ;
         A32TLiqCod = P01M916_A32TLiqCod[0] ;
         n32TLiqCod = P01M916_n32TLiqCod[0] ;
         A280LiqFecPago = P01M916_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M916_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M916_A98LiqFecha[0] ;
         A271LiqDescrip = P01M916_A271LiqDescrip[0] ;
         A874LiqNombre = P01M916_A874LiqNombre[0] ;
         A340TliqDesc = P01M916_A340TliqDesc[0] ;
         if ( ! (GXutil.strcmp("", AV96ConClasifAux)==0) )
         {
            AV69Option = AV96ConClasifAux ;
            AV68InsertIndex = 1 ;
            while ( ( AV68InsertIndex <= AV70Options.size() ) && ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) < 0 ) )
            {
               AV68InsertIndex = (int)(AV68InsertIndex+1) ;
            }
            if ( ( ( AV68InsertIndex == AV70Options.size() + 1 ) ) || ( GXutil.strcmp((String)AV70Options.elementAt(-1+AV68InsertIndex), AV69Option) != 0 ) )
            {
               AV70Options.add(AV69Option, AV68InsertIndex);
            }
         }
         pr_default.readNext(14);
      }
      pr_default.close(14);
   }

   public void S271( )
   {
      /* 'LOADLIQDLOGRECALOPTIONS' Routine */
      returnInSub = false ;
      AV93TFLiqDLogRecal = AV81SearchTxt ;
      AV94TFLiqDLogRecal_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(15, new Object[]{ new Object[]{
                                           A93LegId ,
                                           AV13TFLegId_Sels ,
                                           A591LegNomApe ,
                                           AV16TFLegNomApe_Sels ,
                                           A874LiqNombre ,
                                           AV19TFLiqNombre_Sels ,
                                           A329SecDescrip ,
                                           AV22TFSecDescrip_Sels ,
                                           A2225LegOsoDes ,
                                           AV99TFLegOsoDes_Sels ,
                                           A238LegCuentaBanc ,
                                           AV30TFLegCuentaBanc_Sels ,
                                           A2404LegModTra ,
                                           AV101TFLegModTra_Sels ,
                                           Byte.valueOf(A235LegClase) ,
                                           AV32TFLegClase_Sels ,
                                           A2417LegTipoTarifa ,
                                           AV103TFLegTipoTarifa_Sels ,
                                           A271LiqDescrip ,
                                           AV38TFLiqDescrip_Sels ,
                                           A98LiqFecha ,
                                           AV41TFLiqFecha_Sels ,
                                           A513LiqPerSinDia ,
                                           AV44TFLiqPerSinDia_Sels ,
                                           A340TliqDesc ,
                                           AV47TFTliqDesc_Sels ,
                                           A280LiqFecPago ,
                                           AV50TFLiqFecPago_Sels ,
                                           A394DConCodigo ,
                                           AV53TFDConCodigo_Sels ,
                                           A393DConDescrip ,
                                           AV56TFDConDescrip_Sels ,
                                           A464DTipoConCod ,
                                           AV58TFDTipoConCod_Sels ,
                                           A1072LiqDLogRecal ,
                                           AV94TFLiqDLogRecal_Sels ,
                                           Integer.valueOf(AV13TFLegId_Sels.size()) ,
                                           AV12TFLegId ,
                                           Integer.valueOf(AV16TFLegNomApe_Sels.size()) ,
                                           AV15TFLegNomApe ,
                                           Integer.valueOf(AV19TFLiqNombre_Sels.size()) ,
                                           AV18TFLiqNombre ,
                                           Integer.valueOf(AV22TFSecDescrip_Sels.size()) ,
                                           Integer.valueOf(AV99TFLegOsoDes_Sels.size()) ,
                                           Integer.valueOf(AV30TFLegCuentaBanc_Sels.size()) ,
                                           Integer.valueOf(AV101TFLegModTra_Sels.size()) ,
                                           Integer.valueOf(AV32TFLegClase_Sels.size()) ,
                                           Integer.valueOf(AV103TFLegTipoTarifa_Sels.size()) ,
                                           Integer.valueOf(AV38TFLiqDescrip_Sels.size()) ,
                                           Integer.valueOf(AV41TFLiqFecha_Sels.size()) ,
                                           Integer.valueOf(AV44TFLiqPerSinDia_Sels.size()) ,
                                           AV43TFLiqPerSinDia ,
                                           Integer.valueOf(AV47TFTliqDesc_Sels.size()) ,
                                           Integer.valueOf(AV50TFLiqFecPago_Sels.size()) ,
                                           Integer.valueOf(AV53TFDConCodigo_Sels.size()) ,
                                           AV52TFDConCodigo ,
                                           Integer.valueOf(AV56TFDConDescrip_Sels.size()) ,
                                           AV55TFDConDescrip ,
                                           Integer.valueOf(AV58TFDTipoConCod_Sels.size()) ,
                                           AV62TFLiqDCanti ,
                                           AV63TFLiqDCanti_To ,
                                           AV66TFLiqDImpCalcu ,
                                           AV67TFLiqDImpCalcu_To ,
                                           Integer.valueOf(AV94TFLiqDLogRecal_Sels.size()) ,
                                           AV93TFLiqDLogRecal ,
                                           AV64TFLiqDImpReCalcu ,
                                           AV65TFLiqDImpReCalcu_To ,
                                           A269LiqDCanti ,
                                           A275LiqDImpCalcu ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV88CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV87EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.SHORT
                                           }
      });
      lV12TFLegId = GXutil.padr( GXutil.rtrim( AV12TFLegId), 20, "%") ;
      lV15TFLegNomApe = GXutil.concat( GXutil.rtrim( AV15TFLegNomApe), "%", "") ;
      lV18TFLiqNombre = GXutil.concat( GXutil.rtrim( AV18TFLiqNombre), "%", "") ;
      lV43TFLiqPerSinDia = GXutil.padr( GXutil.rtrim( AV43TFLiqPerSinDia), 20, "%") ;
      lV52TFDConCodigo = GXutil.padr( GXutil.rtrim( AV52TFDConCodigo), 10, "%") ;
      lV55TFDConDescrip = GXutil.concat( GXutil.rtrim( AV55TFDConDescrip), "%", "") ;
      lV93TFLiqDLogRecal = GXutil.concat( GXutil.rtrim( AV93TFLiqDLogRecal), "%", "") ;
      /* Using cursor P01M917 */
      pr_default.execute(15, new Object[] {Integer.valueOf(AV88CliCod), Short.valueOf(AV87EmpCod), lV12TFLegId, lV15TFLegNomApe, lV18TFLiqNombre, lV43TFLiqPerSinDia, lV52TFDConCodigo, lV55TFDConDescrip, AV62TFLiqDCanti, AV63TFLiqDCanti_To, AV66TFLiqDImpCalcu, AV67TFLiqDImpCalcu_To, lV93TFLiqDLogRecal, AV64TFLiqDImpReCalcu, AV65TFLiqDImpReCalcu_To});
      while ( (pr_default.getStatus(15) != 101) )
      {
         brk1M922 = false ;
         A6LegNumero = P01M917_A6LegNumero[0] ;
         A1580LegOsoCod = P01M917_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M917_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M917_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M917_n1579LegSecCodigo[0] ;
         A31LiqNro = P01M917_A31LiqNro[0] ;
         A32TLiqCod = P01M917_A32TLiqCod[0] ;
         n32TLiqCod = P01M917_n32TLiqCod[0] ;
         A3CliCod = P01M917_A3CliCod[0] ;
         A1EmpCod = P01M917_A1EmpCod[0] ;
         A1072LiqDLogRecal = P01M917_A1072LiqDLogRecal[0] ;
         A764LiqDImpReCalcu = P01M917_A764LiqDImpReCalcu[0] ;
         A275LiqDImpCalcu = P01M917_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01M917_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01M917_A269LiqDCanti[0] ;
         n269LiqDCanti = P01M917_n269LiqDCanti[0] ;
         A464DTipoConCod = P01M917_A464DTipoConCod[0] ;
         A393DConDescrip = P01M917_A393DConDescrip[0] ;
         A394DConCodigo = P01M917_A394DConCodigo[0] ;
         A280LiqFecPago = P01M917_A280LiqFecPago[0] ;
         A340TliqDesc = P01M917_A340TliqDesc[0] ;
         A513LiqPerSinDia = P01M917_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M917_A98LiqFecha[0] ;
         A271LiqDescrip = P01M917_A271LiqDescrip[0] ;
         A2417LegTipoTarifa = P01M917_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M917_A235LegClase[0] ;
         A2404LegModTra = P01M917_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M917_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M917_n238LegCuentaBanc[0] ;
         A2225LegOsoDes = P01M917_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M917_A329SecDescrip[0] ;
         n329SecDescrip = P01M917_n329SecDescrip[0] ;
         A874LiqNombre = P01M917_A874LiqNombre[0] ;
         A591LegNomApe = P01M917_A591LegNomApe[0] ;
         A93LegId = P01M917_A93LegId[0] ;
         n93LegId = P01M917_n93LegId[0] ;
         A81LiqDSecuencial = P01M917_A81LiqDSecuencial[0] ;
         A1580LegOsoCod = P01M917_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01M917_n1580LegOsoCod[0] ;
         A1579LegSecCodigo = P01M917_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P01M917_n1579LegSecCodigo[0] ;
         A2417LegTipoTarifa = P01M917_A2417LegTipoTarifa[0] ;
         A235LegClase = P01M917_A235LegClase[0] ;
         A2404LegModTra = P01M917_A2404LegModTra[0] ;
         A238LegCuentaBanc = P01M917_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P01M917_n238LegCuentaBanc[0] ;
         A591LegNomApe = P01M917_A591LegNomApe[0] ;
         A93LegId = P01M917_A93LegId[0] ;
         n93LegId = P01M917_n93LegId[0] ;
         A2225LegOsoDes = P01M917_A2225LegOsoDes[0] ;
         A329SecDescrip = P01M917_A329SecDescrip[0] ;
         n329SecDescrip = P01M917_n329SecDescrip[0] ;
         A32TLiqCod = P01M917_A32TLiqCod[0] ;
         n32TLiqCod = P01M917_n32TLiqCod[0] ;
         A280LiqFecPago = P01M917_A280LiqFecPago[0] ;
         A513LiqPerSinDia = P01M917_A513LiqPerSinDia[0] ;
         A98LiqFecha = P01M917_A98LiqFecha[0] ;
         A271LiqDescrip = P01M917_A271LiqDescrip[0] ;
         A874LiqNombre = P01M917_A874LiqNombre[0] ;
         A340TliqDesc = P01M917_A340TliqDesc[0] ;
         AV74count = 0 ;
         while ( (pr_default.getStatus(15) != 101) && ( GXutil.strcmp(P01M917_A1072LiqDLogRecal[0], A1072LiqDLogRecal) == 0 ) )
         {
            brk1M922 = false ;
            A6LegNumero = P01M917_A6LegNumero[0] ;
            A31LiqNro = P01M917_A31LiqNro[0] ;
            A3CliCod = P01M917_A3CliCod[0] ;
            A1EmpCod = P01M917_A1EmpCod[0] ;
            A81LiqDSecuencial = P01M917_A81LiqDSecuencial[0] ;
            AV74count = (long)(AV74count+1) ;
            brk1M922 = true ;
            pr_default.readNext(15);
         }
         if ( ! (GXutil.strcmp("", A1072LiqDLogRecal)==0) )
         {
            AV69Option = A1072LiqDLogRecal ;
            AV70Options.add(AV69Option, 0);
            AV73OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV74count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV70Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1M922 )
         {
            brk1M922 = true ;
            pr_default.readNext(15);
         }
      }
      pr_default.close(15);
   }

   protected void cleanup( )
   {
      this.aP3[0] = liquidacion_export3getfilterdata.this.AV83OptionsJson;
      this.aP4[0] = liquidacion_export3getfilterdata.this.AV84OptionsDescJson;
      this.aP5[0] = liquidacion_export3getfilterdata.this.AV85OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV83OptionsJson = "" ;
      AV84OptionsDescJson = "" ;
      AV85OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV70Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV72OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV75Session = httpContext.getWebSession();
      AV77GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV78GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFLegId = "" ;
      AV11TFLegId_SelsJson = "" ;
      AV13TFLegId_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFLegNomApe = "" ;
      AV14TFLegNomApe_SelsJson = "" ;
      AV16TFLegNomApe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFLiqNombre = "" ;
      AV17TFLiqNombre_SelsJson = "" ;
      AV19TFLiqNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFSecDescrip = "" ;
      AV20TFSecDescrip_SelsJson = "" ;
      AV22TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV98TFLegOsoDes = "" ;
      AV97TFLegOsoDes_SelsJson = "" ;
      AV99TFLegOsoDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29TFLegCuentaBanc = "" ;
      AV28TFLegCuentaBanc_SelsJson = "" ;
      AV30TFLegCuentaBanc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100TFLegModTra_SelsJson = "" ;
      AV101TFLegModTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31TFLegClase_SelsJson = "" ;
      AV32TFLegClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV102TFLegTipoTarifa_SelsJson = "" ;
      AV103TFLegTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37TFLiqDescrip = "" ;
      AV36TFLiqDescrip_SelsJson = "" ;
      AV38TFLiqDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFLiqFecha = GXutil.nullDate() ;
      AV39TFLiqFecha_SelsJson = "" ;
      AV41TFLiqFecha_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV43TFLiqPerSinDia = "" ;
      AV42TFLiqPerSinDia_SelsJson = "" ;
      AV44TFLiqPerSinDia_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFTliqDesc = "" ;
      AV45TFTliqDesc_SelsJson = "" ;
      AV47TFTliqDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFLiqFecPago = GXutil.nullDate() ;
      AV48TFLiqFecPago_SelsJson = "" ;
      AV50TFLiqFecPago_Sels = new GXSimpleCollection<java.util.Date>(java.util.Date.class, "internal", "");
      AV52TFDConCodigo = "" ;
      AV51TFDConCodigo_SelsJson = "" ;
      AV53TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFDConDescrip = "" ;
      AV54TFDConDescrip_SelsJson = "" ;
      AV56TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV57TFDTipoConCod_SelsJson = "" ;
      AV58TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60TFConClasifAux = "" ;
      AV59TFConClasifAux_SelsJson = "" ;
      AV61TFConClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62TFLiqDCanti = DecimalUtil.ZERO ;
      AV63TFLiqDCanti_To = DecimalUtil.ZERO ;
      AV66TFLiqDImpCalcu = DecimalUtil.ZERO ;
      AV67TFLiqDImpCalcu_To = DecimalUtil.ZERO ;
      AV93TFLiqDLogRecal = "" ;
      AV92TFLiqDLogRecal_SelsJson = "" ;
      AV94TFLiqDLogRecal_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV65TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      AV95MenuOpcCod = "" ;
      scmdbuf = "" ;
      lV12TFLegId = "" ;
      lV15TFLegNomApe = "" ;
      lV18TFLiqNombre = "" ;
      lV43TFLiqPerSinDia = "" ;
      lV52TFDConCodigo = "" ;
      lV55TFDConDescrip = "" ;
      lV93TFLiqDLogRecal = "" ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      A874LiqNombre = "" ;
      A329SecDescrip = "" ;
      A2225LegOsoDes = "" ;
      A238LegCuentaBanc = "" ;
      A2404LegModTra = "" ;
      A2417LegTipoTarifa = "" ;
      A271LiqDescrip = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A513LiqPerSinDia = "" ;
      A340TliqDesc = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A464DTipoConCod = "" ;
      A1072LiqDLogRecal = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      P01M92_A6LegNumero = new int[1] ;
      P01M92_A1580LegOsoCod = new String[] {""} ;
      P01M92_n1580LegOsoCod = new boolean[] {false} ;
      P01M92_A1579LegSecCodigo = new String[] {""} ;
      P01M92_n1579LegSecCodigo = new boolean[] {false} ;
      P01M92_A31LiqNro = new int[1] ;
      P01M92_A32TLiqCod = new String[] {""} ;
      P01M92_n32TLiqCod = new boolean[] {false} ;
      P01M92_A3CliCod = new int[1] ;
      P01M92_A1EmpCod = new short[1] ;
      P01M92_A93LegId = new String[] {""} ;
      P01M92_n93LegId = new boolean[] {false} ;
      P01M92_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M92_A1072LiqDLogRecal = new String[] {""} ;
      P01M92_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M92_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M92_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M92_n269LiqDCanti = new boolean[] {false} ;
      P01M92_A464DTipoConCod = new String[] {""} ;
      P01M92_A393DConDescrip = new String[] {""} ;
      P01M92_A394DConCodigo = new String[] {""} ;
      P01M92_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M92_A340TliqDesc = new String[] {""} ;
      P01M92_A513LiqPerSinDia = new String[] {""} ;
      P01M92_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M92_A271LiqDescrip = new String[] {""} ;
      P01M92_A2417LegTipoTarifa = new String[] {""} ;
      P01M92_A235LegClase = new byte[1] ;
      P01M92_A2404LegModTra = new String[] {""} ;
      P01M92_A238LegCuentaBanc = new String[] {""} ;
      P01M92_n238LegCuentaBanc = new boolean[] {false} ;
      P01M92_A2225LegOsoDes = new String[] {""} ;
      P01M92_A329SecDescrip = new String[] {""} ;
      P01M92_n329SecDescrip = new boolean[] {false} ;
      P01M92_A874LiqNombre = new String[] {""} ;
      P01M92_A591LegNomApe = new String[] {""} ;
      P01M92_A81LiqDSecuencial = new int[1] ;
      A1580LegOsoCod = "" ;
      A1579LegSecCodigo = "" ;
      A32TLiqCod = "" ;
      AV69Option = "" ;
      P01M93_A6LegNumero = new int[1] ;
      P01M93_A1580LegOsoCod = new String[] {""} ;
      P01M93_n1580LegOsoCod = new boolean[] {false} ;
      P01M93_A1579LegSecCodigo = new String[] {""} ;
      P01M93_n1579LegSecCodigo = new boolean[] {false} ;
      P01M93_A31LiqNro = new int[1] ;
      P01M93_A32TLiqCod = new String[] {""} ;
      P01M93_n32TLiqCod = new boolean[] {false} ;
      P01M93_A3CliCod = new int[1] ;
      P01M93_A1EmpCod = new short[1] ;
      P01M93_A591LegNomApe = new String[] {""} ;
      P01M93_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M93_A1072LiqDLogRecal = new String[] {""} ;
      P01M93_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M93_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M93_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M93_n269LiqDCanti = new boolean[] {false} ;
      P01M93_A464DTipoConCod = new String[] {""} ;
      P01M93_A393DConDescrip = new String[] {""} ;
      P01M93_A394DConCodigo = new String[] {""} ;
      P01M93_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M93_A340TliqDesc = new String[] {""} ;
      P01M93_A513LiqPerSinDia = new String[] {""} ;
      P01M93_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M93_A271LiqDescrip = new String[] {""} ;
      P01M93_A2417LegTipoTarifa = new String[] {""} ;
      P01M93_A235LegClase = new byte[1] ;
      P01M93_A2404LegModTra = new String[] {""} ;
      P01M93_A238LegCuentaBanc = new String[] {""} ;
      P01M93_n238LegCuentaBanc = new boolean[] {false} ;
      P01M93_A2225LegOsoDes = new String[] {""} ;
      P01M93_A329SecDescrip = new String[] {""} ;
      P01M93_n329SecDescrip = new boolean[] {false} ;
      P01M93_A874LiqNombre = new String[] {""} ;
      P01M93_A93LegId = new String[] {""} ;
      P01M93_n93LegId = new boolean[] {false} ;
      P01M93_A81LiqDSecuencial = new int[1] ;
      P01M94_A6LegNumero = new int[1] ;
      P01M94_A1580LegOsoCod = new String[] {""} ;
      P01M94_n1580LegOsoCod = new boolean[] {false} ;
      P01M94_A1579LegSecCodigo = new String[] {""} ;
      P01M94_n1579LegSecCodigo = new boolean[] {false} ;
      P01M94_A31LiqNro = new int[1] ;
      P01M94_A32TLiqCod = new String[] {""} ;
      P01M94_n32TLiqCod = new boolean[] {false} ;
      P01M94_A1EmpCod = new short[1] ;
      P01M94_A3CliCod = new int[1] ;
      P01M94_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M94_A1072LiqDLogRecal = new String[] {""} ;
      P01M94_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M94_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M94_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M94_n269LiqDCanti = new boolean[] {false} ;
      P01M94_A464DTipoConCod = new String[] {""} ;
      P01M94_A393DConDescrip = new String[] {""} ;
      P01M94_A394DConCodigo = new String[] {""} ;
      P01M94_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M94_A340TliqDesc = new String[] {""} ;
      P01M94_A513LiqPerSinDia = new String[] {""} ;
      P01M94_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M94_A271LiqDescrip = new String[] {""} ;
      P01M94_A2417LegTipoTarifa = new String[] {""} ;
      P01M94_A235LegClase = new byte[1] ;
      P01M94_A2404LegModTra = new String[] {""} ;
      P01M94_A238LegCuentaBanc = new String[] {""} ;
      P01M94_n238LegCuentaBanc = new boolean[] {false} ;
      P01M94_A2225LegOsoDes = new String[] {""} ;
      P01M94_A329SecDescrip = new String[] {""} ;
      P01M94_n329SecDescrip = new boolean[] {false} ;
      P01M94_A874LiqNombre = new String[] {""} ;
      P01M94_A591LegNomApe = new String[] {""} ;
      P01M94_A93LegId = new String[] {""} ;
      P01M94_n93LegId = new boolean[] {false} ;
      P01M94_A81LiqDSecuencial = new int[1] ;
      P01M95_A6LegNumero = new int[1] ;
      P01M95_A1580LegOsoCod = new String[] {""} ;
      P01M95_n1580LegOsoCod = new boolean[] {false} ;
      P01M95_A1579LegSecCodigo = new String[] {""} ;
      P01M95_n1579LegSecCodigo = new boolean[] {false} ;
      P01M95_A31LiqNro = new int[1] ;
      P01M95_A32TLiqCod = new String[] {""} ;
      P01M95_n32TLiqCod = new boolean[] {false} ;
      P01M95_A1EmpCod = new short[1] ;
      P01M95_A3CliCod = new int[1] ;
      P01M95_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M95_A1072LiqDLogRecal = new String[] {""} ;
      P01M95_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M95_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M95_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M95_n269LiqDCanti = new boolean[] {false} ;
      P01M95_A464DTipoConCod = new String[] {""} ;
      P01M95_A393DConDescrip = new String[] {""} ;
      P01M95_A394DConCodigo = new String[] {""} ;
      P01M95_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M95_A340TliqDesc = new String[] {""} ;
      P01M95_A513LiqPerSinDia = new String[] {""} ;
      P01M95_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M95_A271LiqDescrip = new String[] {""} ;
      P01M95_A2417LegTipoTarifa = new String[] {""} ;
      P01M95_A235LegClase = new byte[1] ;
      P01M95_A2404LegModTra = new String[] {""} ;
      P01M95_A238LegCuentaBanc = new String[] {""} ;
      P01M95_n238LegCuentaBanc = new boolean[] {false} ;
      P01M95_A2225LegOsoDes = new String[] {""} ;
      P01M95_A329SecDescrip = new String[] {""} ;
      P01M95_n329SecDescrip = new boolean[] {false} ;
      P01M95_A874LiqNombre = new String[] {""} ;
      P01M95_A591LegNomApe = new String[] {""} ;
      P01M95_A93LegId = new String[] {""} ;
      P01M95_n93LegId = new boolean[] {false} ;
      P01M95_A81LiqDSecuencial = new int[1] ;
      P01M96_A6LegNumero = new int[1] ;
      P01M96_A1580LegOsoCod = new String[] {""} ;
      P01M96_n1580LegOsoCod = new boolean[] {false} ;
      P01M96_A1579LegSecCodigo = new String[] {""} ;
      P01M96_n1579LegSecCodigo = new boolean[] {false} ;
      P01M96_A31LiqNro = new int[1] ;
      P01M96_A32TLiqCod = new String[] {""} ;
      P01M96_n32TLiqCod = new boolean[] {false} ;
      P01M96_A1EmpCod = new short[1] ;
      P01M96_A3CliCod = new int[1] ;
      P01M96_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M96_A1072LiqDLogRecal = new String[] {""} ;
      P01M96_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M96_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M96_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M96_n269LiqDCanti = new boolean[] {false} ;
      P01M96_A464DTipoConCod = new String[] {""} ;
      P01M96_A393DConDescrip = new String[] {""} ;
      P01M96_A394DConCodigo = new String[] {""} ;
      P01M96_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M96_A340TliqDesc = new String[] {""} ;
      P01M96_A513LiqPerSinDia = new String[] {""} ;
      P01M96_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M96_A271LiqDescrip = new String[] {""} ;
      P01M96_A2417LegTipoTarifa = new String[] {""} ;
      P01M96_A235LegClase = new byte[1] ;
      P01M96_A2404LegModTra = new String[] {""} ;
      P01M96_A238LegCuentaBanc = new String[] {""} ;
      P01M96_n238LegCuentaBanc = new boolean[] {false} ;
      P01M96_A2225LegOsoDes = new String[] {""} ;
      P01M96_A329SecDescrip = new String[] {""} ;
      P01M96_n329SecDescrip = new boolean[] {false} ;
      P01M96_A874LiqNombre = new String[] {""} ;
      P01M96_A591LegNomApe = new String[] {""} ;
      P01M96_A93LegId = new String[] {""} ;
      P01M96_n93LegId = new boolean[] {false} ;
      P01M96_A81LiqDSecuencial = new int[1] ;
      P01M97_A6LegNumero = new int[1] ;
      P01M97_A1580LegOsoCod = new String[] {""} ;
      P01M97_n1580LegOsoCod = new boolean[] {false} ;
      P01M97_A1579LegSecCodigo = new String[] {""} ;
      P01M97_n1579LegSecCodigo = new boolean[] {false} ;
      P01M97_A31LiqNro = new int[1] ;
      P01M97_A32TLiqCod = new String[] {""} ;
      P01M97_n32TLiqCod = new boolean[] {false} ;
      P01M97_A1EmpCod = new short[1] ;
      P01M97_A3CliCod = new int[1] ;
      P01M97_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M97_A1072LiqDLogRecal = new String[] {""} ;
      P01M97_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M97_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M97_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M97_n269LiqDCanti = new boolean[] {false} ;
      P01M97_A464DTipoConCod = new String[] {""} ;
      P01M97_A393DConDescrip = new String[] {""} ;
      P01M97_A394DConCodigo = new String[] {""} ;
      P01M97_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M97_A340TliqDesc = new String[] {""} ;
      P01M97_A513LiqPerSinDia = new String[] {""} ;
      P01M97_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M97_A271LiqDescrip = new String[] {""} ;
      P01M97_A2417LegTipoTarifa = new String[] {""} ;
      P01M97_A235LegClase = new byte[1] ;
      P01M97_A2404LegModTra = new String[] {""} ;
      P01M97_A238LegCuentaBanc = new String[] {""} ;
      P01M97_n238LegCuentaBanc = new boolean[] {false} ;
      P01M97_A2225LegOsoDes = new String[] {""} ;
      P01M97_A329SecDescrip = new String[] {""} ;
      P01M97_n329SecDescrip = new boolean[] {false} ;
      P01M97_A874LiqNombre = new String[] {""} ;
      P01M97_A591LegNomApe = new String[] {""} ;
      P01M97_A93LegId = new String[] {""} ;
      P01M97_n93LegId = new boolean[] {false} ;
      P01M97_A81LiqDSecuencial = new int[1] ;
      P01M98_A6LegNumero = new int[1] ;
      P01M98_A1580LegOsoCod = new String[] {""} ;
      P01M98_n1580LegOsoCod = new boolean[] {false} ;
      P01M98_A1579LegSecCodigo = new String[] {""} ;
      P01M98_n1579LegSecCodigo = new boolean[] {false} ;
      P01M98_A31LiqNro = new int[1] ;
      P01M98_A32TLiqCod = new String[] {""} ;
      P01M98_n32TLiqCod = new boolean[] {false} ;
      P01M98_A1EmpCod = new short[1] ;
      P01M98_A3CliCod = new int[1] ;
      P01M98_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M98_A1072LiqDLogRecal = new String[] {""} ;
      P01M98_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M98_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M98_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M98_n269LiqDCanti = new boolean[] {false} ;
      P01M98_A464DTipoConCod = new String[] {""} ;
      P01M98_A393DConDescrip = new String[] {""} ;
      P01M98_A394DConCodigo = new String[] {""} ;
      P01M98_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M98_A340TliqDesc = new String[] {""} ;
      P01M98_A513LiqPerSinDia = new String[] {""} ;
      P01M98_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M98_A271LiqDescrip = new String[] {""} ;
      P01M98_A2417LegTipoTarifa = new String[] {""} ;
      P01M98_A235LegClase = new byte[1] ;
      P01M98_A2404LegModTra = new String[] {""} ;
      P01M98_A238LegCuentaBanc = new String[] {""} ;
      P01M98_n238LegCuentaBanc = new boolean[] {false} ;
      P01M98_A2225LegOsoDes = new String[] {""} ;
      P01M98_A329SecDescrip = new String[] {""} ;
      P01M98_n329SecDescrip = new boolean[] {false} ;
      P01M98_A874LiqNombre = new String[] {""} ;
      P01M98_A591LegNomApe = new String[] {""} ;
      P01M98_A93LegId = new String[] {""} ;
      P01M98_n93LegId = new boolean[] {false} ;
      P01M98_A81LiqDSecuencial = new int[1] ;
      AV71OptionDesc = "" ;
      P01M99_A6LegNumero = new int[1] ;
      P01M99_A1580LegOsoCod = new String[] {""} ;
      P01M99_n1580LegOsoCod = new boolean[] {false} ;
      P01M99_A1579LegSecCodigo = new String[] {""} ;
      P01M99_n1579LegSecCodigo = new boolean[] {false} ;
      P01M99_A31LiqNro = new int[1] ;
      P01M99_A32TLiqCod = new String[] {""} ;
      P01M99_n32TLiqCod = new boolean[] {false} ;
      P01M99_A1EmpCod = new short[1] ;
      P01M99_A3CliCod = new int[1] ;
      P01M99_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M99_A1072LiqDLogRecal = new String[] {""} ;
      P01M99_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M99_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M99_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M99_n269LiqDCanti = new boolean[] {false} ;
      P01M99_A464DTipoConCod = new String[] {""} ;
      P01M99_A393DConDescrip = new String[] {""} ;
      P01M99_A394DConCodigo = new String[] {""} ;
      P01M99_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M99_A340TliqDesc = new String[] {""} ;
      P01M99_A513LiqPerSinDia = new String[] {""} ;
      P01M99_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M99_A271LiqDescrip = new String[] {""} ;
      P01M99_A2417LegTipoTarifa = new String[] {""} ;
      P01M99_A235LegClase = new byte[1] ;
      P01M99_A2404LegModTra = new String[] {""} ;
      P01M99_A238LegCuentaBanc = new String[] {""} ;
      P01M99_n238LegCuentaBanc = new boolean[] {false} ;
      P01M99_A2225LegOsoDes = new String[] {""} ;
      P01M99_A329SecDescrip = new String[] {""} ;
      P01M99_n329SecDescrip = new boolean[] {false} ;
      P01M99_A874LiqNombre = new String[] {""} ;
      P01M99_A591LegNomApe = new String[] {""} ;
      P01M99_A93LegId = new String[] {""} ;
      P01M99_n93LegId = new boolean[] {false} ;
      P01M99_A81LiqDSecuencial = new int[1] ;
      P01M910_A6LegNumero = new int[1] ;
      P01M910_A1580LegOsoCod = new String[] {""} ;
      P01M910_n1580LegOsoCod = new boolean[] {false} ;
      P01M910_A1579LegSecCodigo = new String[] {""} ;
      P01M910_n1579LegSecCodigo = new boolean[] {false} ;
      P01M910_A31LiqNro = new int[1] ;
      P01M910_A32TLiqCod = new String[] {""} ;
      P01M910_n32TLiqCod = new boolean[] {false} ;
      P01M910_A1EmpCod = new short[1] ;
      P01M910_A3CliCod = new int[1] ;
      P01M910_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M910_A1072LiqDLogRecal = new String[] {""} ;
      P01M910_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M910_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M910_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M910_n269LiqDCanti = new boolean[] {false} ;
      P01M910_A464DTipoConCod = new String[] {""} ;
      P01M910_A393DConDescrip = new String[] {""} ;
      P01M910_A394DConCodigo = new String[] {""} ;
      P01M910_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M910_A340TliqDesc = new String[] {""} ;
      P01M910_A513LiqPerSinDia = new String[] {""} ;
      P01M910_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M910_A271LiqDescrip = new String[] {""} ;
      P01M910_A2417LegTipoTarifa = new String[] {""} ;
      P01M910_A235LegClase = new byte[1] ;
      P01M910_A2404LegModTra = new String[] {""} ;
      P01M910_A238LegCuentaBanc = new String[] {""} ;
      P01M910_n238LegCuentaBanc = new boolean[] {false} ;
      P01M910_A2225LegOsoDes = new String[] {""} ;
      P01M910_A329SecDescrip = new String[] {""} ;
      P01M910_n329SecDescrip = new boolean[] {false} ;
      P01M910_A874LiqNombre = new String[] {""} ;
      P01M910_A591LegNomApe = new String[] {""} ;
      P01M910_A93LegId = new String[] {""} ;
      P01M910_n93LegId = new boolean[] {false} ;
      P01M910_A81LiqDSecuencial = new int[1] ;
      P01M911_A6LegNumero = new int[1] ;
      P01M911_A1580LegOsoCod = new String[] {""} ;
      P01M911_n1580LegOsoCod = new boolean[] {false} ;
      P01M911_A1579LegSecCodigo = new String[] {""} ;
      P01M911_n1579LegSecCodigo = new boolean[] {false} ;
      P01M911_A31LiqNro = new int[1] ;
      P01M911_A32TLiqCod = new String[] {""} ;
      P01M911_n32TLiqCod = new boolean[] {false} ;
      P01M911_A3CliCod = new int[1] ;
      P01M911_A1EmpCod = new short[1] ;
      P01M911_A513LiqPerSinDia = new String[] {""} ;
      P01M911_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M911_A1072LiqDLogRecal = new String[] {""} ;
      P01M911_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M911_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M911_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M911_n269LiqDCanti = new boolean[] {false} ;
      P01M911_A464DTipoConCod = new String[] {""} ;
      P01M911_A393DConDescrip = new String[] {""} ;
      P01M911_A394DConCodigo = new String[] {""} ;
      P01M911_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M911_A340TliqDesc = new String[] {""} ;
      P01M911_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M911_A271LiqDescrip = new String[] {""} ;
      P01M911_A2417LegTipoTarifa = new String[] {""} ;
      P01M911_A235LegClase = new byte[1] ;
      P01M911_A2404LegModTra = new String[] {""} ;
      P01M911_A238LegCuentaBanc = new String[] {""} ;
      P01M911_n238LegCuentaBanc = new boolean[] {false} ;
      P01M911_A2225LegOsoDes = new String[] {""} ;
      P01M911_A329SecDescrip = new String[] {""} ;
      P01M911_n329SecDescrip = new boolean[] {false} ;
      P01M911_A874LiqNombre = new String[] {""} ;
      P01M911_A591LegNomApe = new String[] {""} ;
      P01M911_A93LegId = new String[] {""} ;
      P01M911_n93LegId = new boolean[] {false} ;
      P01M911_A81LiqDSecuencial = new int[1] ;
      P01M912_A6LegNumero = new int[1] ;
      P01M912_A1580LegOsoCod = new String[] {""} ;
      P01M912_n1580LegOsoCod = new boolean[] {false} ;
      P01M912_A1579LegSecCodigo = new String[] {""} ;
      P01M912_n1579LegSecCodigo = new boolean[] {false} ;
      P01M912_A31LiqNro = new int[1] ;
      P01M912_A32TLiqCod = new String[] {""} ;
      P01M912_n32TLiqCod = new boolean[] {false} ;
      P01M912_A1EmpCod = new short[1] ;
      P01M912_A3CliCod = new int[1] ;
      P01M912_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M912_A1072LiqDLogRecal = new String[] {""} ;
      P01M912_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M912_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M912_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M912_n269LiqDCanti = new boolean[] {false} ;
      P01M912_A464DTipoConCod = new String[] {""} ;
      P01M912_A393DConDescrip = new String[] {""} ;
      P01M912_A394DConCodigo = new String[] {""} ;
      P01M912_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M912_A340TliqDesc = new String[] {""} ;
      P01M912_A513LiqPerSinDia = new String[] {""} ;
      P01M912_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M912_A271LiqDescrip = new String[] {""} ;
      P01M912_A2417LegTipoTarifa = new String[] {""} ;
      P01M912_A235LegClase = new byte[1] ;
      P01M912_A2404LegModTra = new String[] {""} ;
      P01M912_A238LegCuentaBanc = new String[] {""} ;
      P01M912_n238LegCuentaBanc = new boolean[] {false} ;
      P01M912_A2225LegOsoDes = new String[] {""} ;
      P01M912_A329SecDescrip = new String[] {""} ;
      P01M912_n329SecDescrip = new boolean[] {false} ;
      P01M912_A874LiqNombre = new String[] {""} ;
      P01M912_A591LegNomApe = new String[] {""} ;
      P01M912_A93LegId = new String[] {""} ;
      P01M912_n93LegId = new boolean[] {false} ;
      P01M912_A81LiqDSecuencial = new int[1] ;
      P01M913_A6LegNumero = new int[1] ;
      P01M913_A1580LegOsoCod = new String[] {""} ;
      P01M913_n1580LegOsoCod = new boolean[] {false} ;
      P01M913_A1579LegSecCodigo = new String[] {""} ;
      P01M913_n1579LegSecCodigo = new boolean[] {false} ;
      P01M913_A31LiqNro = new int[1] ;
      P01M913_A32TLiqCod = new String[] {""} ;
      P01M913_n32TLiqCod = new boolean[] {false} ;
      P01M913_A1EmpCod = new short[1] ;
      P01M913_A3CliCod = new int[1] ;
      P01M913_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M913_A1072LiqDLogRecal = new String[] {""} ;
      P01M913_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M913_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M913_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M913_n269LiqDCanti = new boolean[] {false} ;
      P01M913_A464DTipoConCod = new String[] {""} ;
      P01M913_A393DConDescrip = new String[] {""} ;
      P01M913_A394DConCodigo = new String[] {""} ;
      P01M913_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M913_A340TliqDesc = new String[] {""} ;
      P01M913_A513LiqPerSinDia = new String[] {""} ;
      P01M913_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M913_A271LiqDescrip = new String[] {""} ;
      P01M913_A2417LegTipoTarifa = new String[] {""} ;
      P01M913_A235LegClase = new byte[1] ;
      P01M913_A2404LegModTra = new String[] {""} ;
      P01M913_A238LegCuentaBanc = new String[] {""} ;
      P01M913_n238LegCuentaBanc = new boolean[] {false} ;
      P01M913_A2225LegOsoDes = new String[] {""} ;
      P01M913_A329SecDescrip = new String[] {""} ;
      P01M913_n329SecDescrip = new boolean[] {false} ;
      P01M913_A874LiqNombre = new String[] {""} ;
      P01M913_A591LegNomApe = new String[] {""} ;
      P01M913_A93LegId = new String[] {""} ;
      P01M913_n93LegId = new boolean[] {false} ;
      P01M913_A81LiqDSecuencial = new int[1] ;
      P01M914_A6LegNumero = new int[1] ;
      P01M914_A1580LegOsoCod = new String[] {""} ;
      P01M914_n1580LegOsoCod = new boolean[] {false} ;
      P01M914_A1579LegSecCodigo = new String[] {""} ;
      P01M914_n1579LegSecCodigo = new boolean[] {false} ;
      P01M914_A31LiqNro = new int[1] ;
      P01M914_A32TLiqCod = new String[] {""} ;
      P01M914_n32TLiqCod = new boolean[] {false} ;
      P01M914_A3CliCod = new int[1] ;
      P01M914_A1EmpCod = new short[1] ;
      P01M914_A394DConCodigo = new String[] {""} ;
      P01M914_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M914_A1072LiqDLogRecal = new String[] {""} ;
      P01M914_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M914_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M914_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M914_n269LiqDCanti = new boolean[] {false} ;
      P01M914_A464DTipoConCod = new String[] {""} ;
      P01M914_A393DConDescrip = new String[] {""} ;
      P01M914_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M914_A340TliqDesc = new String[] {""} ;
      P01M914_A513LiqPerSinDia = new String[] {""} ;
      P01M914_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M914_A271LiqDescrip = new String[] {""} ;
      P01M914_A2417LegTipoTarifa = new String[] {""} ;
      P01M914_A235LegClase = new byte[1] ;
      P01M914_A2404LegModTra = new String[] {""} ;
      P01M914_A238LegCuentaBanc = new String[] {""} ;
      P01M914_n238LegCuentaBanc = new boolean[] {false} ;
      P01M914_A2225LegOsoDes = new String[] {""} ;
      P01M914_A329SecDescrip = new String[] {""} ;
      P01M914_n329SecDescrip = new boolean[] {false} ;
      P01M914_A874LiqNombre = new String[] {""} ;
      P01M914_A591LegNomApe = new String[] {""} ;
      P01M914_A93LegId = new String[] {""} ;
      P01M914_n93LegId = new boolean[] {false} ;
      P01M914_A81LiqDSecuencial = new int[1] ;
      P01M915_A6LegNumero = new int[1] ;
      P01M915_A1580LegOsoCod = new String[] {""} ;
      P01M915_n1580LegOsoCod = new boolean[] {false} ;
      P01M915_A1579LegSecCodigo = new String[] {""} ;
      P01M915_n1579LegSecCodigo = new boolean[] {false} ;
      P01M915_A31LiqNro = new int[1] ;
      P01M915_A32TLiqCod = new String[] {""} ;
      P01M915_n32TLiqCod = new boolean[] {false} ;
      P01M915_A3CliCod = new int[1] ;
      P01M915_A1EmpCod = new short[1] ;
      P01M915_A393DConDescrip = new String[] {""} ;
      P01M915_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M915_A1072LiqDLogRecal = new String[] {""} ;
      P01M915_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M915_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M915_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M915_n269LiqDCanti = new boolean[] {false} ;
      P01M915_A464DTipoConCod = new String[] {""} ;
      P01M915_A394DConCodigo = new String[] {""} ;
      P01M915_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M915_A340TliqDesc = new String[] {""} ;
      P01M915_A513LiqPerSinDia = new String[] {""} ;
      P01M915_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M915_A271LiqDescrip = new String[] {""} ;
      P01M915_A2417LegTipoTarifa = new String[] {""} ;
      P01M915_A235LegClase = new byte[1] ;
      P01M915_A2404LegModTra = new String[] {""} ;
      P01M915_A238LegCuentaBanc = new String[] {""} ;
      P01M915_n238LegCuentaBanc = new boolean[] {false} ;
      P01M915_A2225LegOsoDes = new String[] {""} ;
      P01M915_A329SecDescrip = new String[] {""} ;
      P01M915_n329SecDescrip = new boolean[] {false} ;
      P01M915_A874LiqNombre = new String[] {""} ;
      P01M915_A591LegNomApe = new String[] {""} ;
      P01M915_A93LegId = new String[] {""} ;
      P01M915_n93LegId = new boolean[] {false} ;
      P01M915_A81LiqDSecuencial = new int[1] ;
      P01M916_A6LegNumero = new int[1] ;
      P01M916_A1580LegOsoCod = new String[] {""} ;
      P01M916_n1580LegOsoCod = new boolean[] {false} ;
      P01M916_A1579LegSecCodigo = new String[] {""} ;
      P01M916_n1579LegSecCodigo = new boolean[] {false} ;
      P01M916_A31LiqNro = new int[1] ;
      P01M916_A32TLiqCod = new String[] {""} ;
      P01M916_n32TLiqCod = new boolean[] {false} ;
      P01M916_A1EmpCod = new short[1] ;
      P01M916_A3CliCod = new int[1] ;
      P01M916_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M916_A1072LiqDLogRecal = new String[] {""} ;
      P01M916_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M916_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M916_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M916_n269LiqDCanti = new boolean[] {false} ;
      P01M916_A464DTipoConCod = new String[] {""} ;
      P01M916_A393DConDescrip = new String[] {""} ;
      P01M916_A394DConCodigo = new String[] {""} ;
      P01M916_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M916_A340TliqDesc = new String[] {""} ;
      P01M916_A513LiqPerSinDia = new String[] {""} ;
      P01M916_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M916_A271LiqDescrip = new String[] {""} ;
      P01M916_A2417LegTipoTarifa = new String[] {""} ;
      P01M916_A235LegClase = new byte[1] ;
      P01M916_A2404LegModTra = new String[] {""} ;
      P01M916_A238LegCuentaBanc = new String[] {""} ;
      P01M916_n238LegCuentaBanc = new boolean[] {false} ;
      P01M916_A2225LegOsoDes = new String[] {""} ;
      P01M916_A329SecDescrip = new String[] {""} ;
      P01M916_n329SecDescrip = new boolean[] {false} ;
      P01M916_A874LiqNombre = new String[] {""} ;
      P01M916_A591LegNomApe = new String[] {""} ;
      P01M916_A93LegId = new String[] {""} ;
      P01M916_n93LegId = new boolean[] {false} ;
      P01M916_A81LiqDSecuencial = new int[1] ;
      AV96ConClasifAux = "" ;
      P01M917_A6LegNumero = new int[1] ;
      P01M917_A1580LegOsoCod = new String[] {""} ;
      P01M917_n1580LegOsoCod = new boolean[] {false} ;
      P01M917_A1579LegSecCodigo = new String[] {""} ;
      P01M917_n1579LegSecCodigo = new boolean[] {false} ;
      P01M917_A31LiqNro = new int[1] ;
      P01M917_A32TLiqCod = new String[] {""} ;
      P01M917_n32TLiqCod = new boolean[] {false} ;
      P01M917_A3CliCod = new int[1] ;
      P01M917_A1EmpCod = new short[1] ;
      P01M917_A1072LiqDLogRecal = new String[] {""} ;
      P01M917_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M917_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M917_n275LiqDImpCalcu = new boolean[] {false} ;
      P01M917_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01M917_n269LiqDCanti = new boolean[] {false} ;
      P01M917_A464DTipoConCod = new String[] {""} ;
      P01M917_A393DConDescrip = new String[] {""} ;
      P01M917_A394DConCodigo = new String[] {""} ;
      P01M917_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01M917_A340TliqDesc = new String[] {""} ;
      P01M917_A513LiqPerSinDia = new String[] {""} ;
      P01M917_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P01M917_A271LiqDescrip = new String[] {""} ;
      P01M917_A2417LegTipoTarifa = new String[] {""} ;
      P01M917_A235LegClase = new byte[1] ;
      P01M917_A2404LegModTra = new String[] {""} ;
      P01M917_A238LegCuentaBanc = new String[] {""} ;
      P01M917_n238LegCuentaBanc = new boolean[] {false} ;
      P01M917_A2225LegOsoDes = new String[] {""} ;
      P01M917_A329SecDescrip = new String[] {""} ;
      P01M917_n329SecDescrip = new boolean[] {false} ;
      P01M917_A874LiqNombre = new String[] {""} ;
      P01M917_A591LegNomApe = new String[] {""} ;
      P01M917_A93LegId = new String[] {""} ;
      P01M917_n93LegId = new boolean[] {false} ;
      P01M917_A81LiqDSecuencial = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacion_export3getfilterdata__default(),
         new Object[] {
             new Object[] {
            P01M92_A6LegNumero, P01M92_A1580LegOsoCod, P01M92_n1580LegOsoCod, P01M92_A1579LegSecCodigo, P01M92_n1579LegSecCodigo, P01M92_A31LiqNro, P01M92_A32TLiqCod, P01M92_n32TLiqCod, P01M92_A3CliCod, P01M92_A1EmpCod,
            P01M92_A93LegId, P01M92_n93LegId, P01M92_A764LiqDImpReCalcu, P01M92_A1072LiqDLogRecal, P01M92_A275LiqDImpCalcu, P01M92_n275LiqDImpCalcu, P01M92_A269LiqDCanti, P01M92_n269LiqDCanti, P01M92_A464DTipoConCod, P01M92_A393DConDescrip,
            P01M92_A394DConCodigo, P01M92_A280LiqFecPago, P01M92_A340TliqDesc, P01M92_A513LiqPerSinDia, P01M92_A98LiqFecha, P01M92_A271LiqDescrip, P01M92_A2417LegTipoTarifa, P01M92_A235LegClase, P01M92_A2404LegModTra, P01M92_A238LegCuentaBanc,
            P01M92_n238LegCuentaBanc, P01M92_A2225LegOsoDes, P01M92_A329SecDescrip, P01M92_n329SecDescrip, P01M92_A874LiqNombre, P01M92_A591LegNomApe, P01M92_A81LiqDSecuencial
            }
            , new Object[] {
            P01M93_A6LegNumero, P01M93_A1580LegOsoCod, P01M93_n1580LegOsoCod, P01M93_A1579LegSecCodigo, P01M93_n1579LegSecCodigo, P01M93_A31LiqNro, P01M93_A32TLiqCod, P01M93_n32TLiqCod, P01M93_A3CliCod, P01M93_A1EmpCod,
            P01M93_A591LegNomApe, P01M93_A764LiqDImpReCalcu, P01M93_A1072LiqDLogRecal, P01M93_A275LiqDImpCalcu, P01M93_n275LiqDImpCalcu, P01M93_A269LiqDCanti, P01M93_n269LiqDCanti, P01M93_A464DTipoConCod, P01M93_A393DConDescrip, P01M93_A394DConCodigo,
            P01M93_A280LiqFecPago, P01M93_A340TliqDesc, P01M93_A513LiqPerSinDia, P01M93_A98LiqFecha, P01M93_A271LiqDescrip, P01M93_A2417LegTipoTarifa, P01M93_A235LegClase, P01M93_A2404LegModTra, P01M93_A238LegCuentaBanc, P01M93_n238LegCuentaBanc,
            P01M93_A2225LegOsoDes, P01M93_A329SecDescrip, P01M93_n329SecDescrip, P01M93_A874LiqNombre, P01M93_A93LegId, P01M93_n93LegId, P01M93_A81LiqDSecuencial
            }
            , new Object[] {
            P01M94_A6LegNumero, P01M94_A1580LegOsoCod, P01M94_n1580LegOsoCod, P01M94_A1579LegSecCodigo, P01M94_n1579LegSecCodigo, P01M94_A31LiqNro, P01M94_A32TLiqCod, P01M94_n32TLiqCod, P01M94_A1EmpCod, P01M94_A3CliCod,
            P01M94_A764LiqDImpReCalcu, P01M94_A1072LiqDLogRecal, P01M94_A275LiqDImpCalcu, P01M94_n275LiqDImpCalcu, P01M94_A269LiqDCanti, P01M94_n269LiqDCanti, P01M94_A464DTipoConCod, P01M94_A393DConDescrip, P01M94_A394DConCodigo, P01M94_A280LiqFecPago,
            P01M94_A340TliqDesc, P01M94_A513LiqPerSinDia, P01M94_A98LiqFecha, P01M94_A271LiqDescrip, P01M94_A2417LegTipoTarifa, P01M94_A235LegClase, P01M94_A2404LegModTra, P01M94_A238LegCuentaBanc, P01M94_n238LegCuentaBanc, P01M94_A2225LegOsoDes,
            P01M94_A329SecDescrip, P01M94_n329SecDescrip, P01M94_A874LiqNombre, P01M94_A591LegNomApe, P01M94_A93LegId, P01M94_n93LegId, P01M94_A81LiqDSecuencial
            }
            , new Object[] {
            P01M95_A6LegNumero, P01M95_A1580LegOsoCod, P01M95_n1580LegOsoCod, P01M95_A1579LegSecCodigo, P01M95_n1579LegSecCodigo, P01M95_A31LiqNro, P01M95_A32TLiqCod, P01M95_n32TLiqCod, P01M95_A1EmpCod, P01M95_A3CliCod,
            P01M95_A764LiqDImpReCalcu, P01M95_A1072LiqDLogRecal, P01M95_A275LiqDImpCalcu, P01M95_n275LiqDImpCalcu, P01M95_A269LiqDCanti, P01M95_n269LiqDCanti, P01M95_A464DTipoConCod, P01M95_A393DConDescrip, P01M95_A394DConCodigo, P01M95_A280LiqFecPago,
            P01M95_A340TliqDesc, P01M95_A513LiqPerSinDia, P01M95_A98LiqFecha, P01M95_A271LiqDescrip, P01M95_A2417LegTipoTarifa, P01M95_A235LegClase, P01M95_A2404LegModTra, P01M95_A238LegCuentaBanc, P01M95_n238LegCuentaBanc, P01M95_A2225LegOsoDes,
            P01M95_A329SecDescrip, P01M95_n329SecDescrip, P01M95_A874LiqNombre, P01M95_A591LegNomApe, P01M95_A93LegId, P01M95_n93LegId, P01M95_A81LiqDSecuencial
            }
            , new Object[] {
            P01M96_A6LegNumero, P01M96_A1580LegOsoCod, P01M96_n1580LegOsoCod, P01M96_A1579LegSecCodigo, P01M96_n1579LegSecCodigo, P01M96_A31LiqNro, P01M96_A32TLiqCod, P01M96_n32TLiqCod, P01M96_A1EmpCod, P01M96_A3CliCod,
            P01M96_A764LiqDImpReCalcu, P01M96_A1072LiqDLogRecal, P01M96_A275LiqDImpCalcu, P01M96_n275LiqDImpCalcu, P01M96_A269LiqDCanti, P01M96_n269LiqDCanti, P01M96_A464DTipoConCod, P01M96_A393DConDescrip, P01M96_A394DConCodigo, P01M96_A280LiqFecPago,
            P01M96_A340TliqDesc, P01M96_A513LiqPerSinDia, P01M96_A98LiqFecha, P01M96_A271LiqDescrip, P01M96_A2417LegTipoTarifa, P01M96_A235LegClase, P01M96_A2404LegModTra, P01M96_A238LegCuentaBanc, P01M96_n238LegCuentaBanc, P01M96_A2225LegOsoDes,
            P01M96_A329SecDescrip, P01M96_n329SecDescrip, P01M96_A874LiqNombre, P01M96_A591LegNomApe, P01M96_A93LegId, P01M96_n93LegId, P01M96_A81LiqDSecuencial
            }
            , new Object[] {
            P01M97_A6LegNumero, P01M97_A1580LegOsoCod, P01M97_n1580LegOsoCod, P01M97_A1579LegSecCodigo, P01M97_n1579LegSecCodigo, P01M97_A31LiqNro, P01M97_A32TLiqCod, P01M97_n32TLiqCod, P01M97_A1EmpCod, P01M97_A3CliCod,
            P01M97_A764LiqDImpReCalcu, P01M97_A1072LiqDLogRecal, P01M97_A275LiqDImpCalcu, P01M97_n275LiqDImpCalcu, P01M97_A269LiqDCanti, P01M97_n269LiqDCanti, P01M97_A464DTipoConCod, P01M97_A393DConDescrip, P01M97_A394DConCodigo, P01M97_A280LiqFecPago,
            P01M97_A340TliqDesc, P01M97_A513LiqPerSinDia, P01M97_A98LiqFecha, P01M97_A271LiqDescrip, P01M97_A2417LegTipoTarifa, P01M97_A235LegClase, P01M97_A2404LegModTra, P01M97_A238LegCuentaBanc, P01M97_n238LegCuentaBanc, P01M97_A2225LegOsoDes,
            P01M97_A329SecDescrip, P01M97_n329SecDescrip, P01M97_A874LiqNombre, P01M97_A591LegNomApe, P01M97_A93LegId, P01M97_n93LegId, P01M97_A81LiqDSecuencial
            }
            , new Object[] {
            P01M98_A6LegNumero, P01M98_A1580LegOsoCod, P01M98_n1580LegOsoCod, P01M98_A1579LegSecCodigo, P01M98_n1579LegSecCodigo, P01M98_A31LiqNro, P01M98_A32TLiqCod, P01M98_n32TLiqCod, P01M98_A1EmpCod, P01M98_A3CliCod,
            P01M98_A764LiqDImpReCalcu, P01M98_A1072LiqDLogRecal, P01M98_A275LiqDImpCalcu, P01M98_n275LiqDImpCalcu, P01M98_A269LiqDCanti, P01M98_n269LiqDCanti, P01M98_A464DTipoConCod, P01M98_A393DConDescrip, P01M98_A394DConCodigo, P01M98_A280LiqFecPago,
            P01M98_A340TliqDesc, P01M98_A513LiqPerSinDia, P01M98_A98LiqFecha, P01M98_A271LiqDescrip, P01M98_A2417LegTipoTarifa, P01M98_A235LegClase, P01M98_A2404LegModTra, P01M98_A238LegCuentaBanc, P01M98_n238LegCuentaBanc, P01M98_A2225LegOsoDes,
            P01M98_A329SecDescrip, P01M98_n329SecDescrip, P01M98_A874LiqNombre, P01M98_A591LegNomApe, P01M98_A93LegId, P01M98_n93LegId, P01M98_A81LiqDSecuencial
            }
            , new Object[] {
            P01M99_A6LegNumero, P01M99_A1580LegOsoCod, P01M99_n1580LegOsoCod, P01M99_A1579LegSecCodigo, P01M99_n1579LegSecCodigo, P01M99_A31LiqNro, P01M99_A32TLiqCod, P01M99_n32TLiqCod, P01M99_A1EmpCod, P01M99_A3CliCod,
            P01M99_A764LiqDImpReCalcu, P01M99_A1072LiqDLogRecal, P01M99_A275LiqDImpCalcu, P01M99_n275LiqDImpCalcu, P01M99_A269LiqDCanti, P01M99_n269LiqDCanti, P01M99_A464DTipoConCod, P01M99_A393DConDescrip, P01M99_A394DConCodigo, P01M99_A280LiqFecPago,
            P01M99_A340TliqDesc, P01M99_A513LiqPerSinDia, P01M99_A98LiqFecha, P01M99_A271LiqDescrip, P01M99_A2417LegTipoTarifa, P01M99_A235LegClase, P01M99_A2404LegModTra, P01M99_A238LegCuentaBanc, P01M99_n238LegCuentaBanc, P01M99_A2225LegOsoDes,
            P01M99_A329SecDescrip, P01M99_n329SecDescrip, P01M99_A874LiqNombre, P01M99_A591LegNomApe, P01M99_A93LegId, P01M99_n93LegId, P01M99_A81LiqDSecuencial
            }
            , new Object[] {
            P01M910_A6LegNumero, P01M910_A1580LegOsoCod, P01M910_n1580LegOsoCod, P01M910_A1579LegSecCodigo, P01M910_n1579LegSecCodigo, P01M910_A31LiqNro, P01M910_A32TLiqCod, P01M910_n32TLiqCod, P01M910_A1EmpCod, P01M910_A3CliCod,
            P01M910_A764LiqDImpReCalcu, P01M910_A1072LiqDLogRecal, P01M910_A275LiqDImpCalcu, P01M910_n275LiqDImpCalcu, P01M910_A269LiqDCanti, P01M910_n269LiqDCanti, P01M910_A464DTipoConCod, P01M910_A393DConDescrip, P01M910_A394DConCodigo, P01M910_A280LiqFecPago,
            P01M910_A340TliqDesc, P01M910_A513LiqPerSinDia, P01M910_A98LiqFecha, P01M910_A271LiqDescrip, P01M910_A2417LegTipoTarifa, P01M910_A235LegClase, P01M910_A2404LegModTra, P01M910_A238LegCuentaBanc, P01M910_n238LegCuentaBanc, P01M910_A2225LegOsoDes,
            P01M910_A329SecDescrip, P01M910_n329SecDescrip, P01M910_A874LiqNombre, P01M910_A591LegNomApe, P01M910_A93LegId, P01M910_n93LegId, P01M910_A81LiqDSecuencial
            }
            , new Object[] {
            P01M911_A6LegNumero, P01M911_A1580LegOsoCod, P01M911_n1580LegOsoCod, P01M911_A1579LegSecCodigo, P01M911_n1579LegSecCodigo, P01M911_A31LiqNro, P01M911_A32TLiqCod, P01M911_n32TLiqCod, P01M911_A3CliCod, P01M911_A1EmpCod,
            P01M911_A513LiqPerSinDia, P01M911_A764LiqDImpReCalcu, P01M911_A1072LiqDLogRecal, P01M911_A275LiqDImpCalcu, P01M911_n275LiqDImpCalcu, P01M911_A269LiqDCanti, P01M911_n269LiqDCanti, P01M911_A464DTipoConCod, P01M911_A393DConDescrip, P01M911_A394DConCodigo,
            P01M911_A280LiqFecPago, P01M911_A340TliqDesc, P01M911_A98LiqFecha, P01M911_A271LiqDescrip, P01M911_A2417LegTipoTarifa, P01M911_A235LegClase, P01M911_A2404LegModTra, P01M911_A238LegCuentaBanc, P01M911_n238LegCuentaBanc, P01M911_A2225LegOsoDes,
            P01M911_A329SecDescrip, P01M911_n329SecDescrip, P01M911_A874LiqNombre, P01M911_A591LegNomApe, P01M911_A93LegId, P01M911_n93LegId, P01M911_A81LiqDSecuencial
            }
            , new Object[] {
            P01M912_A6LegNumero, P01M912_A1580LegOsoCod, P01M912_n1580LegOsoCod, P01M912_A1579LegSecCodigo, P01M912_n1579LegSecCodigo, P01M912_A31LiqNro, P01M912_A32TLiqCod, P01M912_n32TLiqCod, P01M912_A1EmpCod, P01M912_A3CliCod,
            P01M912_A764LiqDImpReCalcu, P01M912_A1072LiqDLogRecal, P01M912_A275LiqDImpCalcu, P01M912_n275LiqDImpCalcu, P01M912_A269LiqDCanti, P01M912_n269LiqDCanti, P01M912_A464DTipoConCod, P01M912_A393DConDescrip, P01M912_A394DConCodigo, P01M912_A280LiqFecPago,
            P01M912_A340TliqDesc, P01M912_A513LiqPerSinDia, P01M912_A98LiqFecha, P01M912_A271LiqDescrip, P01M912_A2417LegTipoTarifa, P01M912_A235LegClase, P01M912_A2404LegModTra, P01M912_A238LegCuentaBanc, P01M912_n238LegCuentaBanc, P01M912_A2225LegOsoDes,
            P01M912_A329SecDescrip, P01M912_n329SecDescrip, P01M912_A874LiqNombre, P01M912_A591LegNomApe, P01M912_A93LegId, P01M912_n93LegId, P01M912_A81LiqDSecuencial
            }
            , new Object[] {
            P01M913_A6LegNumero, P01M913_A1580LegOsoCod, P01M913_n1580LegOsoCod, P01M913_A1579LegSecCodigo, P01M913_n1579LegSecCodigo, P01M913_A31LiqNro, P01M913_A32TLiqCod, P01M913_n32TLiqCod, P01M913_A1EmpCod, P01M913_A3CliCod,
            P01M913_A764LiqDImpReCalcu, P01M913_A1072LiqDLogRecal, P01M913_A275LiqDImpCalcu, P01M913_n275LiqDImpCalcu, P01M913_A269LiqDCanti, P01M913_n269LiqDCanti, P01M913_A464DTipoConCod, P01M913_A393DConDescrip, P01M913_A394DConCodigo, P01M913_A280LiqFecPago,
            P01M913_A340TliqDesc, P01M913_A513LiqPerSinDia, P01M913_A98LiqFecha, P01M913_A271LiqDescrip, P01M913_A2417LegTipoTarifa, P01M913_A235LegClase, P01M913_A2404LegModTra, P01M913_A238LegCuentaBanc, P01M913_n238LegCuentaBanc, P01M913_A2225LegOsoDes,
            P01M913_A329SecDescrip, P01M913_n329SecDescrip, P01M913_A874LiqNombre, P01M913_A591LegNomApe, P01M913_A93LegId, P01M913_n93LegId, P01M913_A81LiqDSecuencial
            }
            , new Object[] {
            P01M914_A6LegNumero, P01M914_A1580LegOsoCod, P01M914_n1580LegOsoCod, P01M914_A1579LegSecCodigo, P01M914_n1579LegSecCodigo, P01M914_A31LiqNro, P01M914_A32TLiqCod, P01M914_n32TLiqCod, P01M914_A3CliCod, P01M914_A1EmpCod,
            P01M914_A394DConCodigo, P01M914_A764LiqDImpReCalcu, P01M914_A1072LiqDLogRecal, P01M914_A275LiqDImpCalcu, P01M914_n275LiqDImpCalcu, P01M914_A269LiqDCanti, P01M914_n269LiqDCanti, P01M914_A464DTipoConCod, P01M914_A393DConDescrip, P01M914_A280LiqFecPago,
            P01M914_A340TliqDesc, P01M914_A513LiqPerSinDia, P01M914_A98LiqFecha, P01M914_A271LiqDescrip, P01M914_A2417LegTipoTarifa, P01M914_A235LegClase, P01M914_A2404LegModTra, P01M914_A238LegCuentaBanc, P01M914_n238LegCuentaBanc, P01M914_A2225LegOsoDes,
            P01M914_A329SecDescrip, P01M914_n329SecDescrip, P01M914_A874LiqNombre, P01M914_A591LegNomApe, P01M914_A93LegId, P01M914_n93LegId, P01M914_A81LiqDSecuencial
            }
            , new Object[] {
            P01M915_A6LegNumero, P01M915_A1580LegOsoCod, P01M915_n1580LegOsoCod, P01M915_A1579LegSecCodigo, P01M915_n1579LegSecCodigo, P01M915_A31LiqNro, P01M915_A32TLiqCod, P01M915_n32TLiqCod, P01M915_A3CliCod, P01M915_A1EmpCod,
            P01M915_A393DConDescrip, P01M915_A764LiqDImpReCalcu, P01M915_A1072LiqDLogRecal, P01M915_A275LiqDImpCalcu, P01M915_n275LiqDImpCalcu, P01M915_A269LiqDCanti, P01M915_n269LiqDCanti, P01M915_A464DTipoConCod, P01M915_A394DConCodigo, P01M915_A280LiqFecPago,
            P01M915_A340TliqDesc, P01M915_A513LiqPerSinDia, P01M915_A98LiqFecha, P01M915_A271LiqDescrip, P01M915_A2417LegTipoTarifa, P01M915_A235LegClase, P01M915_A2404LegModTra, P01M915_A238LegCuentaBanc, P01M915_n238LegCuentaBanc, P01M915_A2225LegOsoDes,
            P01M915_A329SecDescrip, P01M915_n329SecDescrip, P01M915_A874LiqNombre, P01M915_A591LegNomApe, P01M915_A93LegId, P01M915_n93LegId, P01M915_A81LiqDSecuencial
            }
            , new Object[] {
            P01M916_A6LegNumero, P01M916_A1580LegOsoCod, P01M916_n1580LegOsoCod, P01M916_A1579LegSecCodigo, P01M916_n1579LegSecCodigo, P01M916_A31LiqNro, P01M916_A32TLiqCod, P01M916_n32TLiqCod, P01M916_A1EmpCod, P01M916_A3CliCod,
            P01M916_A764LiqDImpReCalcu, P01M916_A1072LiqDLogRecal, P01M916_A275LiqDImpCalcu, P01M916_n275LiqDImpCalcu, P01M916_A269LiqDCanti, P01M916_n269LiqDCanti, P01M916_A464DTipoConCod, P01M916_A393DConDescrip, P01M916_A394DConCodigo, P01M916_A280LiqFecPago,
            P01M916_A340TliqDesc, P01M916_A513LiqPerSinDia, P01M916_A98LiqFecha, P01M916_A271LiqDescrip, P01M916_A2417LegTipoTarifa, P01M916_A235LegClase, P01M916_A2404LegModTra, P01M916_A238LegCuentaBanc, P01M916_n238LegCuentaBanc, P01M916_A2225LegOsoDes,
            P01M916_A329SecDescrip, P01M916_n329SecDescrip, P01M916_A874LiqNombre, P01M916_A591LegNomApe, P01M916_A93LegId, P01M916_n93LegId, P01M916_A81LiqDSecuencial
            }
            , new Object[] {
            P01M917_A6LegNumero, P01M917_A1580LegOsoCod, P01M917_n1580LegOsoCod, P01M917_A1579LegSecCodigo, P01M917_n1579LegSecCodigo, P01M917_A31LiqNro, P01M917_A32TLiqCod, P01M917_n32TLiqCod, P01M917_A3CliCod, P01M917_A1EmpCod,
            P01M917_A1072LiqDLogRecal, P01M917_A764LiqDImpReCalcu, P01M917_A275LiqDImpCalcu, P01M917_n275LiqDImpCalcu, P01M917_A269LiqDCanti, P01M917_n269LiqDCanti, P01M917_A464DTipoConCod, P01M917_A393DConDescrip, P01M917_A394DConCodigo, P01M917_A280LiqFecPago,
            P01M917_A340TliqDesc, P01M917_A513LiqPerSinDia, P01M917_A98LiqFecha, P01M917_A271LiqDescrip, P01M917_A2417LegTipoTarifa, P01M917_A235LegClase, P01M917_A2404LegModTra, P01M917_A238LegCuentaBanc, P01M917_n238LegCuentaBanc, P01M917_A2225LegOsoDes,
            P01M917_A329SecDescrip, P01M917_n329SecDescrip, P01M917_A874LiqNombre, P01M917_A591LegNomApe, P01M917_A93LegId, P01M917_n93LegId, P01M917_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A235LegClase ;
   private short AV87EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV88CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV106GXV1 ;
   private int AV13TFLegId_Sels_size ;
   private int AV16TFLegNomApe_Sels_size ;
   private int AV19TFLiqNombre_Sels_size ;
   private int AV22TFSecDescrip_Sels_size ;
   private int AV99TFLegOsoDes_Sels_size ;
   private int AV30TFLegCuentaBanc_Sels_size ;
   private int AV101TFLegModTra_Sels_size ;
   private int AV32TFLegClase_Sels_size ;
   private int AV103TFLegTipoTarifa_Sels_size ;
   private int AV38TFLiqDescrip_Sels_size ;
   private int AV41TFLiqFecha_Sels_size ;
   private int AV44TFLiqPerSinDia_Sels_size ;
   private int AV47TFTliqDesc_Sels_size ;
   private int AV50TFLiqFecPago_Sels_size ;
   private int AV53TFDConCodigo_Sels_size ;
   private int AV56TFDConDescrip_Sels_size ;
   private int AV58TFDTipoConCod_Sels_size ;
   private int AV94TFLiqDLogRecal_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private int AV68InsertIndex ;
   private long AV74count ;
   private java.math.BigDecimal AV62TFLiqDCanti ;
   private java.math.BigDecimal AV63TFLiqDCanti_To ;
   private java.math.BigDecimal AV66TFLiqDImpCalcu ;
   private java.math.BigDecimal AV67TFLiqDImpCalcu_To ;
   private java.math.BigDecimal AV64TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV65TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV12TFLegId ;
   private String AV43TFLiqPerSinDia ;
   private String AV52TFDConCodigo ;
   private String scmdbuf ;
   private String lV12TFLegId ;
   private String lV43TFLiqPerSinDia ;
   private String lV52TFDConCodigo ;
   private String A93LegId ;
   private String A2404LegModTra ;
   private String A2417LegTipoTarifa ;
   private String A513LiqPerSinDia ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A1580LegOsoCod ;
   private String A1579LegSecCodigo ;
   private String A32TLiqCod ;
   private java.util.Date AV40TFLiqFecha ;
   private java.util.Date AV49TFLiqFecPago ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A280LiqFecPago ;
   private boolean returnInSub ;
   private boolean brk1M92 ;
   private boolean n1580LegOsoCod ;
   private boolean n1579LegSecCodigo ;
   private boolean n32TLiqCod ;
   private boolean n93LegId ;
   private boolean n275LiqDImpCalcu ;
   private boolean n269LiqDCanti ;
   private boolean n238LegCuentaBanc ;
   private boolean n329SecDescrip ;
   private boolean brk1M94 ;
   private boolean brk1M913 ;
   private boolean brk1M917 ;
   private boolean brk1M919 ;
   private boolean brk1M922 ;
   private String AV83OptionsJson ;
   private String AV84OptionsDescJson ;
   private String AV85OptionIndexesJson ;
   private String AV11TFLegId_SelsJson ;
   private String AV14TFLegNomApe_SelsJson ;
   private String AV17TFLiqNombre_SelsJson ;
   private String AV20TFSecDescrip_SelsJson ;
   private String AV97TFLegOsoDes_SelsJson ;
   private String AV28TFLegCuentaBanc_SelsJson ;
   private String AV100TFLegModTra_SelsJson ;
   private String AV31TFLegClase_SelsJson ;
   private String AV102TFLegTipoTarifa_SelsJson ;
   private String AV36TFLiqDescrip_SelsJson ;
   private String AV39TFLiqFecha_SelsJson ;
   private String AV42TFLiqPerSinDia_SelsJson ;
   private String AV45TFTliqDesc_SelsJson ;
   private String AV48TFLiqFecPago_SelsJson ;
   private String AV51TFDConCodigo_SelsJson ;
   private String AV54TFDConDescrip_SelsJson ;
   private String AV57TFDTipoConCod_SelsJson ;
   private String AV59TFConClasifAux_SelsJson ;
   private String AV92TFLiqDLogRecal_SelsJson ;
   private String A1072LiqDLogRecal ;
   private String AV80DDOName ;
   private String AV81SearchTxt ;
   private String AV82SearchTxtTo ;
   private String AV15TFLegNomApe ;
   private String AV18TFLiqNombre ;
   private String AV21TFSecDescrip ;
   private String AV98TFLegOsoDes ;
   private String AV29TFLegCuentaBanc ;
   private String AV37TFLiqDescrip ;
   private String AV46TFTliqDesc ;
   private String AV55TFDConDescrip ;
   private String AV60TFConClasifAux ;
   private String AV93TFLiqDLogRecal ;
   private String AV95MenuOpcCod ;
   private String lV15TFLegNomApe ;
   private String lV18TFLiqNombre ;
   private String lV55TFDConDescrip ;
   private String lV93TFLiqDLogRecal ;
   private String A591LegNomApe ;
   private String A874LiqNombre ;
   private String A329SecDescrip ;
   private String A2225LegOsoDes ;
   private String A238LegCuentaBanc ;
   private String A271LiqDescrip ;
   private String A340TliqDesc ;
   private String A393DConDescrip ;
   private String AV69Option ;
   private String AV71OptionDesc ;
   private String AV96ConClasifAux ;
   private GXSimpleCollection<Byte> AV32TFLegClase_Sels ;
   private com.genexus.webpanels.WebSession AV75Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01M92_A6LegNumero ;
   private String[] P01M92_A1580LegOsoCod ;
   private boolean[] P01M92_n1580LegOsoCod ;
   private String[] P01M92_A1579LegSecCodigo ;
   private boolean[] P01M92_n1579LegSecCodigo ;
   private int[] P01M92_A31LiqNro ;
   private String[] P01M92_A32TLiqCod ;
   private boolean[] P01M92_n32TLiqCod ;
   private int[] P01M92_A3CliCod ;
   private short[] P01M92_A1EmpCod ;
   private String[] P01M92_A93LegId ;
   private boolean[] P01M92_n93LegId ;
   private java.math.BigDecimal[] P01M92_A764LiqDImpReCalcu ;
   private String[] P01M92_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M92_A275LiqDImpCalcu ;
   private boolean[] P01M92_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M92_A269LiqDCanti ;
   private boolean[] P01M92_n269LiqDCanti ;
   private String[] P01M92_A464DTipoConCod ;
   private String[] P01M92_A393DConDescrip ;
   private String[] P01M92_A394DConCodigo ;
   private java.util.Date[] P01M92_A280LiqFecPago ;
   private String[] P01M92_A340TliqDesc ;
   private String[] P01M92_A513LiqPerSinDia ;
   private java.util.Date[] P01M92_A98LiqFecha ;
   private String[] P01M92_A271LiqDescrip ;
   private String[] P01M92_A2417LegTipoTarifa ;
   private byte[] P01M92_A235LegClase ;
   private String[] P01M92_A2404LegModTra ;
   private String[] P01M92_A238LegCuentaBanc ;
   private boolean[] P01M92_n238LegCuentaBanc ;
   private String[] P01M92_A2225LegOsoDes ;
   private String[] P01M92_A329SecDescrip ;
   private boolean[] P01M92_n329SecDescrip ;
   private String[] P01M92_A874LiqNombre ;
   private String[] P01M92_A591LegNomApe ;
   private int[] P01M92_A81LiqDSecuencial ;
   private int[] P01M93_A6LegNumero ;
   private String[] P01M93_A1580LegOsoCod ;
   private boolean[] P01M93_n1580LegOsoCod ;
   private String[] P01M93_A1579LegSecCodigo ;
   private boolean[] P01M93_n1579LegSecCodigo ;
   private int[] P01M93_A31LiqNro ;
   private String[] P01M93_A32TLiqCod ;
   private boolean[] P01M93_n32TLiqCod ;
   private int[] P01M93_A3CliCod ;
   private short[] P01M93_A1EmpCod ;
   private String[] P01M93_A591LegNomApe ;
   private java.math.BigDecimal[] P01M93_A764LiqDImpReCalcu ;
   private String[] P01M93_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M93_A275LiqDImpCalcu ;
   private boolean[] P01M93_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M93_A269LiqDCanti ;
   private boolean[] P01M93_n269LiqDCanti ;
   private String[] P01M93_A464DTipoConCod ;
   private String[] P01M93_A393DConDescrip ;
   private String[] P01M93_A394DConCodigo ;
   private java.util.Date[] P01M93_A280LiqFecPago ;
   private String[] P01M93_A340TliqDesc ;
   private String[] P01M93_A513LiqPerSinDia ;
   private java.util.Date[] P01M93_A98LiqFecha ;
   private String[] P01M93_A271LiqDescrip ;
   private String[] P01M93_A2417LegTipoTarifa ;
   private byte[] P01M93_A235LegClase ;
   private String[] P01M93_A2404LegModTra ;
   private String[] P01M93_A238LegCuentaBanc ;
   private boolean[] P01M93_n238LegCuentaBanc ;
   private String[] P01M93_A2225LegOsoDes ;
   private String[] P01M93_A329SecDescrip ;
   private boolean[] P01M93_n329SecDescrip ;
   private String[] P01M93_A874LiqNombre ;
   private String[] P01M93_A93LegId ;
   private boolean[] P01M93_n93LegId ;
   private int[] P01M93_A81LiqDSecuencial ;
   private int[] P01M94_A6LegNumero ;
   private String[] P01M94_A1580LegOsoCod ;
   private boolean[] P01M94_n1580LegOsoCod ;
   private String[] P01M94_A1579LegSecCodigo ;
   private boolean[] P01M94_n1579LegSecCodigo ;
   private int[] P01M94_A31LiqNro ;
   private String[] P01M94_A32TLiqCod ;
   private boolean[] P01M94_n32TLiqCod ;
   private short[] P01M94_A1EmpCod ;
   private int[] P01M94_A3CliCod ;
   private java.math.BigDecimal[] P01M94_A764LiqDImpReCalcu ;
   private String[] P01M94_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M94_A275LiqDImpCalcu ;
   private boolean[] P01M94_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M94_A269LiqDCanti ;
   private boolean[] P01M94_n269LiqDCanti ;
   private String[] P01M94_A464DTipoConCod ;
   private String[] P01M94_A393DConDescrip ;
   private String[] P01M94_A394DConCodigo ;
   private java.util.Date[] P01M94_A280LiqFecPago ;
   private String[] P01M94_A340TliqDesc ;
   private String[] P01M94_A513LiqPerSinDia ;
   private java.util.Date[] P01M94_A98LiqFecha ;
   private String[] P01M94_A271LiqDescrip ;
   private String[] P01M94_A2417LegTipoTarifa ;
   private byte[] P01M94_A235LegClase ;
   private String[] P01M94_A2404LegModTra ;
   private String[] P01M94_A238LegCuentaBanc ;
   private boolean[] P01M94_n238LegCuentaBanc ;
   private String[] P01M94_A2225LegOsoDes ;
   private String[] P01M94_A329SecDescrip ;
   private boolean[] P01M94_n329SecDescrip ;
   private String[] P01M94_A874LiqNombre ;
   private String[] P01M94_A591LegNomApe ;
   private String[] P01M94_A93LegId ;
   private boolean[] P01M94_n93LegId ;
   private int[] P01M94_A81LiqDSecuencial ;
   private int[] P01M95_A6LegNumero ;
   private String[] P01M95_A1580LegOsoCod ;
   private boolean[] P01M95_n1580LegOsoCod ;
   private String[] P01M95_A1579LegSecCodigo ;
   private boolean[] P01M95_n1579LegSecCodigo ;
   private int[] P01M95_A31LiqNro ;
   private String[] P01M95_A32TLiqCod ;
   private boolean[] P01M95_n32TLiqCod ;
   private short[] P01M95_A1EmpCod ;
   private int[] P01M95_A3CliCod ;
   private java.math.BigDecimal[] P01M95_A764LiqDImpReCalcu ;
   private String[] P01M95_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M95_A275LiqDImpCalcu ;
   private boolean[] P01M95_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M95_A269LiqDCanti ;
   private boolean[] P01M95_n269LiqDCanti ;
   private String[] P01M95_A464DTipoConCod ;
   private String[] P01M95_A393DConDescrip ;
   private String[] P01M95_A394DConCodigo ;
   private java.util.Date[] P01M95_A280LiqFecPago ;
   private String[] P01M95_A340TliqDesc ;
   private String[] P01M95_A513LiqPerSinDia ;
   private java.util.Date[] P01M95_A98LiqFecha ;
   private String[] P01M95_A271LiqDescrip ;
   private String[] P01M95_A2417LegTipoTarifa ;
   private byte[] P01M95_A235LegClase ;
   private String[] P01M95_A2404LegModTra ;
   private String[] P01M95_A238LegCuentaBanc ;
   private boolean[] P01M95_n238LegCuentaBanc ;
   private String[] P01M95_A2225LegOsoDes ;
   private String[] P01M95_A329SecDescrip ;
   private boolean[] P01M95_n329SecDescrip ;
   private String[] P01M95_A874LiqNombre ;
   private String[] P01M95_A591LegNomApe ;
   private String[] P01M95_A93LegId ;
   private boolean[] P01M95_n93LegId ;
   private int[] P01M95_A81LiqDSecuencial ;
   private int[] P01M96_A6LegNumero ;
   private String[] P01M96_A1580LegOsoCod ;
   private boolean[] P01M96_n1580LegOsoCod ;
   private String[] P01M96_A1579LegSecCodigo ;
   private boolean[] P01M96_n1579LegSecCodigo ;
   private int[] P01M96_A31LiqNro ;
   private String[] P01M96_A32TLiqCod ;
   private boolean[] P01M96_n32TLiqCod ;
   private short[] P01M96_A1EmpCod ;
   private int[] P01M96_A3CliCod ;
   private java.math.BigDecimal[] P01M96_A764LiqDImpReCalcu ;
   private String[] P01M96_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M96_A275LiqDImpCalcu ;
   private boolean[] P01M96_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M96_A269LiqDCanti ;
   private boolean[] P01M96_n269LiqDCanti ;
   private String[] P01M96_A464DTipoConCod ;
   private String[] P01M96_A393DConDescrip ;
   private String[] P01M96_A394DConCodigo ;
   private java.util.Date[] P01M96_A280LiqFecPago ;
   private String[] P01M96_A340TliqDesc ;
   private String[] P01M96_A513LiqPerSinDia ;
   private java.util.Date[] P01M96_A98LiqFecha ;
   private String[] P01M96_A271LiqDescrip ;
   private String[] P01M96_A2417LegTipoTarifa ;
   private byte[] P01M96_A235LegClase ;
   private String[] P01M96_A2404LegModTra ;
   private String[] P01M96_A238LegCuentaBanc ;
   private boolean[] P01M96_n238LegCuentaBanc ;
   private String[] P01M96_A2225LegOsoDes ;
   private String[] P01M96_A329SecDescrip ;
   private boolean[] P01M96_n329SecDescrip ;
   private String[] P01M96_A874LiqNombre ;
   private String[] P01M96_A591LegNomApe ;
   private String[] P01M96_A93LegId ;
   private boolean[] P01M96_n93LegId ;
   private int[] P01M96_A81LiqDSecuencial ;
   private int[] P01M97_A6LegNumero ;
   private String[] P01M97_A1580LegOsoCod ;
   private boolean[] P01M97_n1580LegOsoCod ;
   private String[] P01M97_A1579LegSecCodigo ;
   private boolean[] P01M97_n1579LegSecCodigo ;
   private int[] P01M97_A31LiqNro ;
   private String[] P01M97_A32TLiqCod ;
   private boolean[] P01M97_n32TLiqCod ;
   private short[] P01M97_A1EmpCod ;
   private int[] P01M97_A3CliCod ;
   private java.math.BigDecimal[] P01M97_A764LiqDImpReCalcu ;
   private String[] P01M97_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M97_A275LiqDImpCalcu ;
   private boolean[] P01M97_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M97_A269LiqDCanti ;
   private boolean[] P01M97_n269LiqDCanti ;
   private String[] P01M97_A464DTipoConCod ;
   private String[] P01M97_A393DConDescrip ;
   private String[] P01M97_A394DConCodigo ;
   private java.util.Date[] P01M97_A280LiqFecPago ;
   private String[] P01M97_A340TliqDesc ;
   private String[] P01M97_A513LiqPerSinDia ;
   private java.util.Date[] P01M97_A98LiqFecha ;
   private String[] P01M97_A271LiqDescrip ;
   private String[] P01M97_A2417LegTipoTarifa ;
   private byte[] P01M97_A235LegClase ;
   private String[] P01M97_A2404LegModTra ;
   private String[] P01M97_A238LegCuentaBanc ;
   private boolean[] P01M97_n238LegCuentaBanc ;
   private String[] P01M97_A2225LegOsoDes ;
   private String[] P01M97_A329SecDescrip ;
   private boolean[] P01M97_n329SecDescrip ;
   private String[] P01M97_A874LiqNombre ;
   private String[] P01M97_A591LegNomApe ;
   private String[] P01M97_A93LegId ;
   private boolean[] P01M97_n93LegId ;
   private int[] P01M97_A81LiqDSecuencial ;
   private int[] P01M98_A6LegNumero ;
   private String[] P01M98_A1580LegOsoCod ;
   private boolean[] P01M98_n1580LegOsoCod ;
   private String[] P01M98_A1579LegSecCodigo ;
   private boolean[] P01M98_n1579LegSecCodigo ;
   private int[] P01M98_A31LiqNro ;
   private String[] P01M98_A32TLiqCod ;
   private boolean[] P01M98_n32TLiqCod ;
   private short[] P01M98_A1EmpCod ;
   private int[] P01M98_A3CliCod ;
   private java.math.BigDecimal[] P01M98_A764LiqDImpReCalcu ;
   private String[] P01M98_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M98_A275LiqDImpCalcu ;
   private boolean[] P01M98_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M98_A269LiqDCanti ;
   private boolean[] P01M98_n269LiqDCanti ;
   private String[] P01M98_A464DTipoConCod ;
   private String[] P01M98_A393DConDescrip ;
   private String[] P01M98_A394DConCodigo ;
   private java.util.Date[] P01M98_A280LiqFecPago ;
   private String[] P01M98_A340TliqDesc ;
   private String[] P01M98_A513LiqPerSinDia ;
   private java.util.Date[] P01M98_A98LiqFecha ;
   private String[] P01M98_A271LiqDescrip ;
   private String[] P01M98_A2417LegTipoTarifa ;
   private byte[] P01M98_A235LegClase ;
   private String[] P01M98_A2404LegModTra ;
   private String[] P01M98_A238LegCuentaBanc ;
   private boolean[] P01M98_n238LegCuentaBanc ;
   private String[] P01M98_A2225LegOsoDes ;
   private String[] P01M98_A329SecDescrip ;
   private boolean[] P01M98_n329SecDescrip ;
   private String[] P01M98_A874LiqNombre ;
   private String[] P01M98_A591LegNomApe ;
   private String[] P01M98_A93LegId ;
   private boolean[] P01M98_n93LegId ;
   private int[] P01M98_A81LiqDSecuencial ;
   private int[] P01M99_A6LegNumero ;
   private String[] P01M99_A1580LegOsoCod ;
   private boolean[] P01M99_n1580LegOsoCod ;
   private String[] P01M99_A1579LegSecCodigo ;
   private boolean[] P01M99_n1579LegSecCodigo ;
   private int[] P01M99_A31LiqNro ;
   private String[] P01M99_A32TLiqCod ;
   private boolean[] P01M99_n32TLiqCod ;
   private short[] P01M99_A1EmpCod ;
   private int[] P01M99_A3CliCod ;
   private java.math.BigDecimal[] P01M99_A764LiqDImpReCalcu ;
   private String[] P01M99_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M99_A275LiqDImpCalcu ;
   private boolean[] P01M99_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M99_A269LiqDCanti ;
   private boolean[] P01M99_n269LiqDCanti ;
   private String[] P01M99_A464DTipoConCod ;
   private String[] P01M99_A393DConDescrip ;
   private String[] P01M99_A394DConCodigo ;
   private java.util.Date[] P01M99_A280LiqFecPago ;
   private String[] P01M99_A340TliqDesc ;
   private String[] P01M99_A513LiqPerSinDia ;
   private java.util.Date[] P01M99_A98LiqFecha ;
   private String[] P01M99_A271LiqDescrip ;
   private String[] P01M99_A2417LegTipoTarifa ;
   private byte[] P01M99_A235LegClase ;
   private String[] P01M99_A2404LegModTra ;
   private String[] P01M99_A238LegCuentaBanc ;
   private boolean[] P01M99_n238LegCuentaBanc ;
   private String[] P01M99_A2225LegOsoDes ;
   private String[] P01M99_A329SecDescrip ;
   private boolean[] P01M99_n329SecDescrip ;
   private String[] P01M99_A874LiqNombre ;
   private String[] P01M99_A591LegNomApe ;
   private String[] P01M99_A93LegId ;
   private boolean[] P01M99_n93LegId ;
   private int[] P01M99_A81LiqDSecuencial ;
   private int[] P01M910_A6LegNumero ;
   private String[] P01M910_A1580LegOsoCod ;
   private boolean[] P01M910_n1580LegOsoCod ;
   private String[] P01M910_A1579LegSecCodigo ;
   private boolean[] P01M910_n1579LegSecCodigo ;
   private int[] P01M910_A31LiqNro ;
   private String[] P01M910_A32TLiqCod ;
   private boolean[] P01M910_n32TLiqCod ;
   private short[] P01M910_A1EmpCod ;
   private int[] P01M910_A3CliCod ;
   private java.math.BigDecimal[] P01M910_A764LiqDImpReCalcu ;
   private String[] P01M910_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M910_A275LiqDImpCalcu ;
   private boolean[] P01M910_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M910_A269LiqDCanti ;
   private boolean[] P01M910_n269LiqDCanti ;
   private String[] P01M910_A464DTipoConCod ;
   private String[] P01M910_A393DConDescrip ;
   private String[] P01M910_A394DConCodigo ;
   private java.util.Date[] P01M910_A280LiqFecPago ;
   private String[] P01M910_A340TliqDesc ;
   private String[] P01M910_A513LiqPerSinDia ;
   private java.util.Date[] P01M910_A98LiqFecha ;
   private String[] P01M910_A271LiqDescrip ;
   private String[] P01M910_A2417LegTipoTarifa ;
   private byte[] P01M910_A235LegClase ;
   private String[] P01M910_A2404LegModTra ;
   private String[] P01M910_A238LegCuentaBanc ;
   private boolean[] P01M910_n238LegCuentaBanc ;
   private String[] P01M910_A2225LegOsoDes ;
   private String[] P01M910_A329SecDescrip ;
   private boolean[] P01M910_n329SecDescrip ;
   private String[] P01M910_A874LiqNombre ;
   private String[] P01M910_A591LegNomApe ;
   private String[] P01M910_A93LegId ;
   private boolean[] P01M910_n93LegId ;
   private int[] P01M910_A81LiqDSecuencial ;
   private int[] P01M911_A6LegNumero ;
   private String[] P01M911_A1580LegOsoCod ;
   private boolean[] P01M911_n1580LegOsoCod ;
   private String[] P01M911_A1579LegSecCodigo ;
   private boolean[] P01M911_n1579LegSecCodigo ;
   private int[] P01M911_A31LiqNro ;
   private String[] P01M911_A32TLiqCod ;
   private boolean[] P01M911_n32TLiqCod ;
   private int[] P01M911_A3CliCod ;
   private short[] P01M911_A1EmpCod ;
   private String[] P01M911_A513LiqPerSinDia ;
   private java.math.BigDecimal[] P01M911_A764LiqDImpReCalcu ;
   private String[] P01M911_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M911_A275LiqDImpCalcu ;
   private boolean[] P01M911_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M911_A269LiqDCanti ;
   private boolean[] P01M911_n269LiqDCanti ;
   private String[] P01M911_A464DTipoConCod ;
   private String[] P01M911_A393DConDescrip ;
   private String[] P01M911_A394DConCodigo ;
   private java.util.Date[] P01M911_A280LiqFecPago ;
   private String[] P01M911_A340TliqDesc ;
   private java.util.Date[] P01M911_A98LiqFecha ;
   private String[] P01M911_A271LiqDescrip ;
   private String[] P01M911_A2417LegTipoTarifa ;
   private byte[] P01M911_A235LegClase ;
   private String[] P01M911_A2404LegModTra ;
   private String[] P01M911_A238LegCuentaBanc ;
   private boolean[] P01M911_n238LegCuentaBanc ;
   private String[] P01M911_A2225LegOsoDes ;
   private String[] P01M911_A329SecDescrip ;
   private boolean[] P01M911_n329SecDescrip ;
   private String[] P01M911_A874LiqNombre ;
   private String[] P01M911_A591LegNomApe ;
   private String[] P01M911_A93LegId ;
   private boolean[] P01M911_n93LegId ;
   private int[] P01M911_A81LiqDSecuencial ;
   private int[] P01M912_A6LegNumero ;
   private String[] P01M912_A1580LegOsoCod ;
   private boolean[] P01M912_n1580LegOsoCod ;
   private String[] P01M912_A1579LegSecCodigo ;
   private boolean[] P01M912_n1579LegSecCodigo ;
   private int[] P01M912_A31LiqNro ;
   private String[] P01M912_A32TLiqCod ;
   private boolean[] P01M912_n32TLiqCod ;
   private short[] P01M912_A1EmpCod ;
   private int[] P01M912_A3CliCod ;
   private java.math.BigDecimal[] P01M912_A764LiqDImpReCalcu ;
   private String[] P01M912_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M912_A275LiqDImpCalcu ;
   private boolean[] P01M912_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M912_A269LiqDCanti ;
   private boolean[] P01M912_n269LiqDCanti ;
   private String[] P01M912_A464DTipoConCod ;
   private String[] P01M912_A393DConDescrip ;
   private String[] P01M912_A394DConCodigo ;
   private java.util.Date[] P01M912_A280LiqFecPago ;
   private String[] P01M912_A340TliqDesc ;
   private String[] P01M912_A513LiqPerSinDia ;
   private java.util.Date[] P01M912_A98LiqFecha ;
   private String[] P01M912_A271LiqDescrip ;
   private String[] P01M912_A2417LegTipoTarifa ;
   private byte[] P01M912_A235LegClase ;
   private String[] P01M912_A2404LegModTra ;
   private String[] P01M912_A238LegCuentaBanc ;
   private boolean[] P01M912_n238LegCuentaBanc ;
   private String[] P01M912_A2225LegOsoDes ;
   private String[] P01M912_A329SecDescrip ;
   private boolean[] P01M912_n329SecDescrip ;
   private String[] P01M912_A874LiqNombre ;
   private String[] P01M912_A591LegNomApe ;
   private String[] P01M912_A93LegId ;
   private boolean[] P01M912_n93LegId ;
   private int[] P01M912_A81LiqDSecuencial ;
   private int[] P01M913_A6LegNumero ;
   private String[] P01M913_A1580LegOsoCod ;
   private boolean[] P01M913_n1580LegOsoCod ;
   private String[] P01M913_A1579LegSecCodigo ;
   private boolean[] P01M913_n1579LegSecCodigo ;
   private int[] P01M913_A31LiqNro ;
   private String[] P01M913_A32TLiqCod ;
   private boolean[] P01M913_n32TLiqCod ;
   private short[] P01M913_A1EmpCod ;
   private int[] P01M913_A3CliCod ;
   private java.math.BigDecimal[] P01M913_A764LiqDImpReCalcu ;
   private String[] P01M913_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M913_A275LiqDImpCalcu ;
   private boolean[] P01M913_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M913_A269LiqDCanti ;
   private boolean[] P01M913_n269LiqDCanti ;
   private String[] P01M913_A464DTipoConCod ;
   private String[] P01M913_A393DConDescrip ;
   private String[] P01M913_A394DConCodigo ;
   private java.util.Date[] P01M913_A280LiqFecPago ;
   private String[] P01M913_A340TliqDesc ;
   private String[] P01M913_A513LiqPerSinDia ;
   private java.util.Date[] P01M913_A98LiqFecha ;
   private String[] P01M913_A271LiqDescrip ;
   private String[] P01M913_A2417LegTipoTarifa ;
   private byte[] P01M913_A235LegClase ;
   private String[] P01M913_A2404LegModTra ;
   private String[] P01M913_A238LegCuentaBanc ;
   private boolean[] P01M913_n238LegCuentaBanc ;
   private String[] P01M913_A2225LegOsoDes ;
   private String[] P01M913_A329SecDescrip ;
   private boolean[] P01M913_n329SecDescrip ;
   private String[] P01M913_A874LiqNombre ;
   private String[] P01M913_A591LegNomApe ;
   private String[] P01M913_A93LegId ;
   private boolean[] P01M913_n93LegId ;
   private int[] P01M913_A81LiqDSecuencial ;
   private int[] P01M914_A6LegNumero ;
   private String[] P01M914_A1580LegOsoCod ;
   private boolean[] P01M914_n1580LegOsoCod ;
   private String[] P01M914_A1579LegSecCodigo ;
   private boolean[] P01M914_n1579LegSecCodigo ;
   private int[] P01M914_A31LiqNro ;
   private String[] P01M914_A32TLiqCod ;
   private boolean[] P01M914_n32TLiqCod ;
   private int[] P01M914_A3CliCod ;
   private short[] P01M914_A1EmpCod ;
   private String[] P01M914_A394DConCodigo ;
   private java.math.BigDecimal[] P01M914_A764LiqDImpReCalcu ;
   private String[] P01M914_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M914_A275LiqDImpCalcu ;
   private boolean[] P01M914_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M914_A269LiqDCanti ;
   private boolean[] P01M914_n269LiqDCanti ;
   private String[] P01M914_A464DTipoConCod ;
   private String[] P01M914_A393DConDescrip ;
   private java.util.Date[] P01M914_A280LiqFecPago ;
   private String[] P01M914_A340TliqDesc ;
   private String[] P01M914_A513LiqPerSinDia ;
   private java.util.Date[] P01M914_A98LiqFecha ;
   private String[] P01M914_A271LiqDescrip ;
   private String[] P01M914_A2417LegTipoTarifa ;
   private byte[] P01M914_A235LegClase ;
   private String[] P01M914_A2404LegModTra ;
   private String[] P01M914_A238LegCuentaBanc ;
   private boolean[] P01M914_n238LegCuentaBanc ;
   private String[] P01M914_A2225LegOsoDes ;
   private String[] P01M914_A329SecDescrip ;
   private boolean[] P01M914_n329SecDescrip ;
   private String[] P01M914_A874LiqNombre ;
   private String[] P01M914_A591LegNomApe ;
   private String[] P01M914_A93LegId ;
   private boolean[] P01M914_n93LegId ;
   private int[] P01M914_A81LiqDSecuencial ;
   private int[] P01M915_A6LegNumero ;
   private String[] P01M915_A1580LegOsoCod ;
   private boolean[] P01M915_n1580LegOsoCod ;
   private String[] P01M915_A1579LegSecCodigo ;
   private boolean[] P01M915_n1579LegSecCodigo ;
   private int[] P01M915_A31LiqNro ;
   private String[] P01M915_A32TLiqCod ;
   private boolean[] P01M915_n32TLiqCod ;
   private int[] P01M915_A3CliCod ;
   private short[] P01M915_A1EmpCod ;
   private String[] P01M915_A393DConDescrip ;
   private java.math.BigDecimal[] P01M915_A764LiqDImpReCalcu ;
   private String[] P01M915_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M915_A275LiqDImpCalcu ;
   private boolean[] P01M915_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M915_A269LiqDCanti ;
   private boolean[] P01M915_n269LiqDCanti ;
   private String[] P01M915_A464DTipoConCod ;
   private String[] P01M915_A394DConCodigo ;
   private java.util.Date[] P01M915_A280LiqFecPago ;
   private String[] P01M915_A340TliqDesc ;
   private String[] P01M915_A513LiqPerSinDia ;
   private java.util.Date[] P01M915_A98LiqFecha ;
   private String[] P01M915_A271LiqDescrip ;
   private String[] P01M915_A2417LegTipoTarifa ;
   private byte[] P01M915_A235LegClase ;
   private String[] P01M915_A2404LegModTra ;
   private String[] P01M915_A238LegCuentaBanc ;
   private boolean[] P01M915_n238LegCuentaBanc ;
   private String[] P01M915_A2225LegOsoDes ;
   private String[] P01M915_A329SecDescrip ;
   private boolean[] P01M915_n329SecDescrip ;
   private String[] P01M915_A874LiqNombre ;
   private String[] P01M915_A591LegNomApe ;
   private String[] P01M915_A93LegId ;
   private boolean[] P01M915_n93LegId ;
   private int[] P01M915_A81LiqDSecuencial ;
   private int[] P01M916_A6LegNumero ;
   private String[] P01M916_A1580LegOsoCod ;
   private boolean[] P01M916_n1580LegOsoCod ;
   private String[] P01M916_A1579LegSecCodigo ;
   private boolean[] P01M916_n1579LegSecCodigo ;
   private int[] P01M916_A31LiqNro ;
   private String[] P01M916_A32TLiqCod ;
   private boolean[] P01M916_n32TLiqCod ;
   private short[] P01M916_A1EmpCod ;
   private int[] P01M916_A3CliCod ;
   private java.math.BigDecimal[] P01M916_A764LiqDImpReCalcu ;
   private String[] P01M916_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M916_A275LiqDImpCalcu ;
   private boolean[] P01M916_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M916_A269LiqDCanti ;
   private boolean[] P01M916_n269LiqDCanti ;
   private String[] P01M916_A464DTipoConCod ;
   private String[] P01M916_A393DConDescrip ;
   private String[] P01M916_A394DConCodigo ;
   private java.util.Date[] P01M916_A280LiqFecPago ;
   private String[] P01M916_A340TliqDesc ;
   private String[] P01M916_A513LiqPerSinDia ;
   private java.util.Date[] P01M916_A98LiqFecha ;
   private String[] P01M916_A271LiqDescrip ;
   private String[] P01M916_A2417LegTipoTarifa ;
   private byte[] P01M916_A235LegClase ;
   private String[] P01M916_A2404LegModTra ;
   private String[] P01M916_A238LegCuentaBanc ;
   private boolean[] P01M916_n238LegCuentaBanc ;
   private String[] P01M916_A2225LegOsoDes ;
   private String[] P01M916_A329SecDescrip ;
   private boolean[] P01M916_n329SecDescrip ;
   private String[] P01M916_A874LiqNombre ;
   private String[] P01M916_A591LegNomApe ;
   private String[] P01M916_A93LegId ;
   private boolean[] P01M916_n93LegId ;
   private int[] P01M916_A81LiqDSecuencial ;
   private int[] P01M917_A6LegNumero ;
   private String[] P01M917_A1580LegOsoCod ;
   private boolean[] P01M917_n1580LegOsoCod ;
   private String[] P01M917_A1579LegSecCodigo ;
   private boolean[] P01M917_n1579LegSecCodigo ;
   private int[] P01M917_A31LiqNro ;
   private String[] P01M917_A32TLiqCod ;
   private boolean[] P01M917_n32TLiqCod ;
   private int[] P01M917_A3CliCod ;
   private short[] P01M917_A1EmpCod ;
   private String[] P01M917_A1072LiqDLogRecal ;
   private java.math.BigDecimal[] P01M917_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01M917_A275LiqDImpCalcu ;
   private boolean[] P01M917_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01M917_A269LiqDCanti ;
   private boolean[] P01M917_n269LiqDCanti ;
   private String[] P01M917_A464DTipoConCod ;
   private String[] P01M917_A393DConDescrip ;
   private String[] P01M917_A394DConCodigo ;
   private java.util.Date[] P01M917_A280LiqFecPago ;
   private String[] P01M917_A340TliqDesc ;
   private String[] P01M917_A513LiqPerSinDia ;
   private java.util.Date[] P01M917_A98LiqFecha ;
   private String[] P01M917_A271LiqDescrip ;
   private String[] P01M917_A2417LegTipoTarifa ;
   private byte[] P01M917_A235LegClase ;
   private String[] P01M917_A2404LegModTra ;
   private String[] P01M917_A238LegCuentaBanc ;
   private boolean[] P01M917_n238LegCuentaBanc ;
   private String[] P01M917_A2225LegOsoDes ;
   private String[] P01M917_A329SecDescrip ;
   private boolean[] P01M917_n329SecDescrip ;
   private String[] P01M917_A874LiqNombre ;
   private String[] P01M917_A591LegNomApe ;
   private String[] P01M917_A93LegId ;
   private boolean[] P01M917_n93LegId ;
   private int[] P01M917_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV13TFLegId_Sels ;
   private GXSimpleCollection<String> AV101TFLegModTra_Sels ;
   private GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ;
   private GXSimpleCollection<String> AV53TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV58TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV70Options ;
   private GXSimpleCollection<String> AV72OptionsDesc ;
   private GXSimpleCollection<String> AV73OptionIndexes ;
   private GXSimpleCollection<String> AV16TFLegNomApe_Sels ;
   private GXSimpleCollection<String> AV19TFLiqNombre_Sels ;
   private GXSimpleCollection<String> AV22TFSecDescrip_Sels ;
   private GXSimpleCollection<String> AV99TFLegOsoDes_Sels ;
   private GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ;
   private GXSimpleCollection<String> AV38TFLiqDescrip_Sels ;
   private GXSimpleCollection<String> AV47TFTliqDesc_Sels ;
   private GXSimpleCollection<String> AV56TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV61TFConClasifAux_Sels ;
   private GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ;
   private GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ;
   private GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV77GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV78GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
}

final  class liquidacion_export3getfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01M92( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[15];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.CliCod, T1.EmpCod, T2.LegId, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int6[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int6[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int6[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int6[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int6[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int6[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int6[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int6[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T2.LegId" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01M93( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[15];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.CliCod, T1.EmpCod, T2.LegNomApe, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle T1" ;
      scmdbuf += " INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND T3.OsoCod" ;
      scmdbuf += " = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND T5.EmpCod" ;
      scmdbuf += " = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int9[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int9[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int9[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int9[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int9[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int9[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int9[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int9[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int9[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int9[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int9[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int9[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int9[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T2.LegNomApe" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
   }

   protected Object[] conditional_P01M94( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[15];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int12[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int12[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int12[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P01M95( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[15];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int15[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int15[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int15[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int15[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int15[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int15[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int15[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int15[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int15[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int15[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int15[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
   }

   protected Object[] conditional_P01M96( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int18 = new byte[15];
      Object[] GXv_Object19 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int18[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int18[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int18[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int18[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int18[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int18[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int18[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int18[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int18[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int18[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int18[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int18[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int18[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object19[0] = scmdbuf ;
      GXv_Object19[1] = GXv_int18 ;
      return GXv_Object19 ;
   }

   protected Object[] conditional_P01M97( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[15];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int21[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int21[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int21[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int21[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int21[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int21[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int21[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int21[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int21[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int21[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int21[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int21[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_P01M98( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[15];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int24[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int24[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int24[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int24[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int24[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int24[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int24[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int24[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int24[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int24[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int24[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int24[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int24[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object25[0] = scmdbuf ;
      GXv_Object25[1] = GXv_int24 ;
      return GXv_Object25 ;
   }

   protected Object[] conditional_P01M99( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A93LegId ,
                                          GXSimpleCollection<String> AV13TFLegId_Sels ,
                                          String A591LegNomApe ,
                                          GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                          String A874LiqNombre ,
                                          GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                          String A2225LegOsoDes ,
                                          GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                          String A238LegCuentaBanc ,
                                          GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                          String A2404LegModTra ,
                                          GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                          byte A235LegClase ,
                                          GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                          String A2417LegTipoTarifa ,
                                          GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                          String A271LiqDescrip ,
                                          GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                          java.util.Date A98LiqFecha ,
                                          GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                          String A513LiqPerSinDia ,
                                          GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                          String A340TliqDesc ,
                                          GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                          java.util.Date A280LiqFecPago ,
                                          GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                          String A1072LiqDLogRecal ,
                                          GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                          int AV13TFLegId_Sels_size ,
                                          String AV12TFLegId ,
                                          int AV16TFLegNomApe_Sels_size ,
                                          String AV15TFLegNomApe ,
                                          int AV19TFLiqNombre_Sels_size ,
                                          String AV18TFLiqNombre ,
                                          int AV22TFSecDescrip_Sels_size ,
                                          int AV99TFLegOsoDes_Sels_size ,
                                          int AV30TFLegCuentaBanc_Sels_size ,
                                          int AV101TFLegModTra_Sels_size ,
                                          int AV32TFLegClase_Sels_size ,
                                          int AV103TFLegTipoTarifa_Sels_size ,
                                          int AV38TFLiqDescrip_Sels_size ,
                                          int AV41TFLiqFecha_Sels_size ,
                                          int AV44TFLiqPerSinDia_Sels_size ,
                                          String AV43TFLiqPerSinDia ,
                                          int AV47TFTliqDesc_Sels_size ,
                                          int AV50TFLiqFecPago_Sels_size ,
                                          int AV53TFDConCodigo_Sels_size ,
                                          String AV52TFDConCodigo ,
                                          int AV56TFDConDescrip_Sels_size ,
                                          String AV55TFDConDescrip ,
                                          int AV58TFDTipoConCod_Sels_size ,
                                          java.math.BigDecimal AV62TFLiqDCanti ,
                                          java.math.BigDecimal AV63TFLiqDCanti_To ,
                                          java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                          java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                          int AV94TFLiqDLogRecal_Sels_size ,
                                          String AV93TFLiqDLogRecal ,
                                          java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                          java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                          java.math.BigDecimal A269LiqDCanti ,
                                          java.math.BigDecimal A275LiqDImpCalcu ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV88CliCod ,
                                          short AV87EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int27 = new byte[15];
      Object[] GXv_Object28 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int27[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int27[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int27[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int27[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int27[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int27[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int27[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int27[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int27[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int27[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int27[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int27[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int27[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object28[0] = scmdbuf ;
      GXv_Object28[1] = GXv_int27 ;
      return GXv_Object28 ;
   }

   protected Object[] conditional_P01M910( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int AV88CliCod ,
                                           short AV87EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int30 = new byte[15];
      Object[] GXv_Object31 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int30[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int30[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int30[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int30[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int30[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int30[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int30[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int30[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int30[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int30[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int30[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int30[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int30[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object31[0] = scmdbuf ;
      GXv_Object31[1] = GXv_int30 ;
      return GXv_Object31 ;
   }

   protected Object[] conditional_P01M911( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int A3CliCod ,
                                           int AV88CliCod ,
                                           short A1EmpCod ,
                                           short AV87EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int33 = new byte[15];
      Object[] GXv_Object34 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.CliCod, T1.EmpCod, T5.LiqPerSinDia, T1.LiqDImpReCalcu," ;
      scmdbuf += " T1.LiqDLogRecal, T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int33[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int33[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int33[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int33[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int33[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int33[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int33[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int33[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int33[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int33[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int33[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int33[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int33[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T5.LiqPerSinDia" ;
      GXv_Object34[0] = scmdbuf ;
      GXv_Object34[1] = GXv_int33 ;
      return GXv_Object34 ;
   }

   protected Object[] conditional_P01M912( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int AV88CliCod ,
                                           short AV87EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int36 = new byte[15];
      Object[] GXv_Object37 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int36[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int36[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int36[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int36[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int36[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int36[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int36[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int36[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int36[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int36[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int36[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int36[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int36[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object37[0] = scmdbuf ;
      GXv_Object37[1] = GXv_int36 ;
      return GXv_Object37 ;
   }

   protected Object[] conditional_P01M913( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int AV88CliCod ,
                                           short AV87EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int39 = new byte[15];
      Object[] GXv_Object40 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int39[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int39[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int39[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int39[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int39[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int39[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int39[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int39[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int39[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int39[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int39[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int39[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int39[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object40[0] = scmdbuf ;
      GXv_Object40[1] = GXv_int39 ;
      return GXv_Object40 ;
   }

   protected Object[] conditional_P01M914( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int A3CliCod ,
                                           int AV88CliCod ,
                                           short A1EmpCod ,
                                           short AV87EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int42 = new byte[15];
      Object[] GXv_Object43 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.CliCod, T1.EmpCod, T1.DConCodigo, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa, T2.LegClase," ;
      scmdbuf += " T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int42[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int42[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int42[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int42[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int42[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int42[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int42[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int42[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int42[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int42[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int42[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int42[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int42[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.DConCodigo" ;
      GXv_Object43[0] = scmdbuf ;
      GXv_Object43[1] = GXv_int42 ;
      return GXv_Object43 ;
   }

   protected Object[] conditional_P01M915( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int AV88CliCod ,
                                           short AV87EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int45 = new byte[15];
      Object[] GXv_Object46 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.CliCod, T1.EmpCod, T1.DConDescrip, T1.LiqDImpReCalcu," ;
      scmdbuf += " T1.LiqDLogRecal, T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int45[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int45[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int45[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int45[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int45[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int45[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int45[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int45[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int45[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int45[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int45[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int45[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int45[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.DConDescrip" ;
      GXv_Object46[0] = scmdbuf ;
      GXv_Object46[1] = GXv_int45 ;
      return GXv_Object46 ;
   }

   protected Object[] conditional_P01M916( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int AV88CliCod ,
                                           short AV87EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int48 = new byte[15];
      Object[] GXv_Object49 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDLogRecal," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int48[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int48[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int48[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int48[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int48[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int48[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int48[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int48[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int48[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int48[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int48[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int48[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int48[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object49[0] = scmdbuf ;
      GXv_Object49[1] = GXv_int48 ;
      return GXv_Object49 ;
   }

   protected Object[] conditional_P01M917( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           String A93LegId ,
                                           GXSimpleCollection<String> AV13TFLegId_Sels ,
                                           String A591LegNomApe ,
                                           GXSimpleCollection<String> AV16TFLegNomApe_Sels ,
                                           String A874LiqNombre ,
                                           GXSimpleCollection<String> AV19TFLiqNombre_Sels ,
                                           String A329SecDescrip ,
                                           GXSimpleCollection<String> AV22TFSecDescrip_Sels ,
                                           String A2225LegOsoDes ,
                                           GXSimpleCollection<String> AV99TFLegOsoDes_Sels ,
                                           String A238LegCuentaBanc ,
                                           GXSimpleCollection<String> AV30TFLegCuentaBanc_Sels ,
                                           String A2404LegModTra ,
                                           GXSimpleCollection<String> AV101TFLegModTra_Sels ,
                                           byte A235LegClase ,
                                           GXSimpleCollection<Byte> AV32TFLegClase_Sels ,
                                           String A2417LegTipoTarifa ,
                                           GXSimpleCollection<String> AV103TFLegTipoTarifa_Sels ,
                                           String A271LiqDescrip ,
                                           GXSimpleCollection<String> AV38TFLiqDescrip_Sels ,
                                           java.util.Date A98LiqFecha ,
                                           GXSimpleCollection<java.util.Date> AV41TFLiqFecha_Sels ,
                                           String A513LiqPerSinDia ,
                                           GXSimpleCollection<String> AV44TFLiqPerSinDia_Sels ,
                                           String A340TliqDesc ,
                                           GXSimpleCollection<String> AV47TFTliqDesc_Sels ,
                                           java.util.Date A280LiqFecPago ,
                                           GXSimpleCollection<java.util.Date> AV50TFLiqFecPago_Sels ,
                                           String A394DConCodigo ,
                                           GXSimpleCollection<String> AV53TFDConCodigo_Sels ,
                                           String A393DConDescrip ,
                                           GXSimpleCollection<String> AV56TFDConDescrip_Sels ,
                                           String A464DTipoConCod ,
                                           GXSimpleCollection<String> AV58TFDTipoConCod_Sels ,
                                           String A1072LiqDLogRecal ,
                                           GXSimpleCollection<String> AV94TFLiqDLogRecal_Sels ,
                                           int AV13TFLegId_Sels_size ,
                                           String AV12TFLegId ,
                                           int AV16TFLegNomApe_Sels_size ,
                                           String AV15TFLegNomApe ,
                                           int AV19TFLiqNombre_Sels_size ,
                                           String AV18TFLiqNombre ,
                                           int AV22TFSecDescrip_Sels_size ,
                                           int AV99TFLegOsoDes_Sels_size ,
                                           int AV30TFLegCuentaBanc_Sels_size ,
                                           int AV101TFLegModTra_Sels_size ,
                                           int AV32TFLegClase_Sels_size ,
                                           int AV103TFLegTipoTarifa_Sels_size ,
                                           int AV38TFLiqDescrip_Sels_size ,
                                           int AV41TFLiqFecha_Sels_size ,
                                           int AV44TFLiqPerSinDia_Sels_size ,
                                           String AV43TFLiqPerSinDia ,
                                           int AV47TFTliqDesc_Sels_size ,
                                           int AV50TFLiqFecPago_Sels_size ,
                                           int AV53TFDConCodigo_Sels_size ,
                                           String AV52TFDConCodigo ,
                                           int AV56TFDConDescrip_Sels_size ,
                                           String AV55TFDConDescrip ,
                                           int AV58TFDTipoConCod_Sels_size ,
                                           java.math.BigDecimal AV62TFLiqDCanti ,
                                           java.math.BigDecimal AV63TFLiqDCanti_To ,
                                           java.math.BigDecimal AV66TFLiqDImpCalcu ,
                                           java.math.BigDecimal AV67TFLiqDImpCalcu_To ,
                                           int AV94TFLiqDLogRecal_Sels_size ,
                                           String AV93TFLiqDLogRecal ,
                                           java.math.BigDecimal AV64TFLiqDImpReCalcu ,
                                           java.math.BigDecimal AV65TFLiqDImpReCalcu_To ,
                                           java.math.BigDecimal A269LiqDCanti ,
                                           java.math.BigDecimal A275LiqDImpCalcu ,
                                           java.math.BigDecimal A764LiqDImpReCalcu ,
                                           int A3CliCod ,
                                           int AV88CliCod ,
                                           short A1EmpCod ,
                                           short AV87EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int51 = new byte[15];
      Object[] GXv_Object52 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegOsoCod AS LegOsoCod, T2.LegSecCodigo AS LegSecCodigo, T1.LiqNro, T5.TLiqCod, T1.CliCod, T1.EmpCod, T1.LiqDLogRecal, T1.LiqDImpReCalcu," ;
      scmdbuf += " T1.LiqDImpCalcu, T1.LiqDCanti, T1.DTipoConCod, T1.DConDescrip, T1.DConCodigo, T5.LiqFecPago, T6.TliqDesc, T5.LiqPerSinDia, T5.LiqFecha, T5.LiqDescrip, T2.LegTipoTarifa," ;
      scmdbuf += " T2.LegClase, T2.LegModTra, T2.LegCuentaBanc, T3.OsoDescrip AS LegOsoDes, T4.SecDescrip, T5.LiqNombre, T2.LegNomApe, T2.LegId, T1.LiqDSecuencial FROM (((((LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND" ;
      scmdbuf += " T3.OsoCod = T2.LegOsoCod) LEFT JOIN Seccion T4 ON T4.CliCod = T1.CliCod AND T4.SecCodigo = T2.LegSecCodigo) INNER JOIN Liquidacion T5 ON T5.CliCod = T1.CliCod AND" ;
      scmdbuf += " T5.EmpCod = T1.EmpCod AND T5.LiqNro = T1.LiqNro) LEFT JOIN TipoLiquidacion T6 ON T6.CliCod = T1.CliCod AND T6.TLiqCod = T5.TLiqCod)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.EmpCod = ?)");
      if ( ( AV13TFLegId_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLegId)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegId) like LOWER(?))");
      }
      else
      {
         GXv_int51[2] = (byte)(1) ;
      }
      if ( AV13TFLegId_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLegId_Sels, "T2.LegId IN (", ")")+")");
      }
      if ( ( AV16TFLegNomApe_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFLegNomApe)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.LegNomApe) like LOWER(?))");
      }
      else
      {
         GXv_int51[3] = (byte)(1) ;
      }
      if ( AV16TFLegNomApe_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFLegNomApe_Sels, "T2.LegNomApe IN (", ")")+")");
      }
      if ( ( AV19TFLiqNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFLiqNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqNombre) like LOWER(?))");
      }
      else
      {
         GXv_int51[4] = (byte)(1) ;
      }
      if ( AV19TFLiqNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFLiqNombre_Sels, "T5.LiqNombre IN (", ")")+")");
      }
      if ( AV22TFSecDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFSecDescrip_Sels, "T4.SecDescrip IN (", ")")+")");
      }
      if ( AV99TFLegOsoDes_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99TFLegOsoDes_Sels, "T3.OsoDescrip IN (", ")")+")");
      }
      if ( AV30TFLegCuentaBanc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV30TFLegCuentaBanc_Sels, "T2.LegCuentaBanc IN (", ")")+")");
      }
      if ( AV101TFLegModTra_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101TFLegModTra_Sels, "T2.LegModTra IN (", ")")+")");
      }
      if ( AV32TFLegClase_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV32TFLegClase_Sels, "T2.LegClase IN (", ")")+")");
      }
      if ( AV103TFLegTipoTarifa_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103TFLegTipoTarifa_Sels, "T2.LegTipoTarifa IN (", ")")+")");
      }
      if ( AV38TFLiqDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV38TFLiqDescrip_Sels, "T5.LiqDescrip IN (", ")")+")");
      }
      if ( AV41TFLiqFecha_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41TFLiqFecha_Sels, "T5.LiqFecha IN (", ")")+")");
      }
      if ( ( AV44TFLiqPerSinDia_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV43TFLiqPerSinDia)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T5.LiqPerSinDia) like LOWER(?))");
      }
      else
      {
         GXv_int51[5] = (byte)(1) ;
      }
      if ( AV44TFLiqPerSinDia_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV44TFLiqPerSinDia_Sels, "T5.LiqPerSinDia IN (", ")")+")");
      }
      if ( AV47TFTliqDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFTliqDesc_Sels, "T6.TliqDesc IN (", ")")+")");
      }
      if ( AV50TFLiqFecPago_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50TFLiqFecPago_Sels, "T5.LiqFecPago IN (", ")")+")");
      }
      if ( ( AV53TFDConCodigo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52TFDConCodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int51[6] = (byte)(1) ;
      }
      if ( AV53TFDConCodigo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53TFDConCodigo_Sels, "T1.DConCodigo IN (", ")")+")");
      }
      if ( ( AV56TFDConDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55TFDConDescrip)==0) ) )
      {
         addWhere(sWhereString, "(T1.DConDescrip like ?)");
      }
      else
      {
         GXv_int51[7] = (byte)(1) ;
      }
      if ( AV56TFDConDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56TFDConDescrip_Sels, "T1.DConDescrip IN (", ")")+")");
      }
      if ( AV58TFDTipoConCod_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV58TFDTipoConCod_Sels, "T1.DTipoConCod IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62TFLiqDCanti)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti >= ?)");
      }
      else
      {
         GXv_int51[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63TFLiqDCanti_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDCanti <= ?)");
      }
      else
      {
         GXv_int51[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66TFLiqDImpCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu >= ?)");
      }
      else
      {
         GXv_int51[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67TFLiqDImpCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpCalcu <= ?)");
      }
      else
      {
         GXv_int51[11] = (byte)(1) ;
      }
      if ( ( AV94TFLiqDLogRecal_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV93TFLiqDLogRecal)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.LiqDLogRecal) like LOWER(?))");
      }
      else
      {
         GXv_int51[12] = (byte)(1) ;
      }
      if ( AV94TFLiqDLogRecal_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV94TFLiqDLogRecal_Sels, "T1.LiqDLogRecal IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64TFLiqDImpReCalcu)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int51[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65TFLiqDImpReCalcu_To)==0) )
      {
         addWhere(sWhereString, "(T1.LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int51[14] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.LiqDLogRecal" ;
      GXv_Object52[0] = scmdbuf ;
      GXv_Object52[1] = GXv_int51 ;
      return GXv_Object52 ;
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
                  return conditional_P01M92(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 1 :
                  return conditional_P01M93(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 2 :
                  return conditional_P01M94(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 3 :
                  return conditional_P01M95(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 4 :
                  return conditional_P01M96(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 5 :
                  return conditional_P01M97(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 6 :
                  return conditional_P01M98(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 7 :
                  return conditional_P01M99(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 8 :
                  return conditional_P01M910(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 9 :
                  return conditional_P01M911(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).shortValue() , ((Number) dynConstraints[73]).shortValue() );
            case 10 :
                  return conditional_P01M912(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 11 :
                  return conditional_P01M913(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 12 :
                  return conditional_P01M914(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).shortValue() , ((Number) dynConstraints[73]).shortValue() );
            case 13 :
                  return conditional_P01M915(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 14 :
                  return conditional_P01M916(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).shortValue() , ((Number) dynConstraints[72]).intValue() , ((Number) dynConstraints[73]).shortValue() );
            case 15 :
                  return conditional_P01M917(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[15] , (String)dynConstraints[16] , (GXSimpleCollection<String>)dynConstraints[17] , (String)dynConstraints[18] , (GXSimpleCollection<String>)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (GXSimpleCollection<java.util.Date>)dynConstraints[21] , (String)dynConstraints[22] , (GXSimpleCollection<String>)dynConstraints[23] , (String)dynConstraints[24] , (GXSimpleCollection<String>)dynConstraints[25] , (java.util.Date)dynConstraints[26] , (GXSimpleCollection<java.util.Date>)dynConstraints[27] , (String)dynConstraints[28] , (GXSimpleCollection<String>)dynConstraints[29] , (String)dynConstraints[30] , (GXSimpleCollection<String>)dynConstraints[31] , (String)dynConstraints[32] , (GXSimpleCollection<String>)dynConstraints[33] , (String)dynConstraints[34] , (GXSimpleCollection<String>)dynConstraints[35] , ((Number) dynConstraints[36]).intValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).intValue() , (String)dynConstraints[39] , ((Number) dynConstraints[40]).intValue() , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , ((Number) dynConstraints[43]).intValue() , ((Number) dynConstraints[44]).intValue() , ((Number) dynConstraints[45]).intValue() , ((Number) dynConstraints[46]).intValue() , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).intValue() , ((Number) dynConstraints[50]).intValue() , (String)dynConstraints[51] , ((Number) dynConstraints[52]).intValue() , ((Number) dynConstraints[53]).intValue() , ((Number) dynConstraints[54]).intValue() , (String)dynConstraints[55] , ((Number) dynConstraints[56]).intValue() , (String)dynConstraints[57] , ((Number) dynConstraints[58]).intValue() , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , ((Number) dynConstraints[63]).intValue() , (String)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , (java.math.BigDecimal)dynConstraints[67] , (java.math.BigDecimal)dynConstraints[68] , (java.math.BigDecimal)dynConstraints[69] , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).shortValue() , ((Number) dynConstraints[73]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01M92", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M93", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M94", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M95", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M96", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M97", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M98", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M99", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M910", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M911", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M912", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M913", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M914", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M915", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M916", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01M917", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(10);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(13, 20);
               ((String[]) buf[19])[0] = rslt.getVarchar(14);
               ((String[]) buf[20])[0] = rslt.getString(15, 10);
               ((java.util.Date[]) buf[21])[0] = rslt.getGXDate(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getString(18, 20);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((String[]) buf[26])[0] = rslt.getString(21, 1);
               ((byte[]) buf[27])[0] = rslt.getByte(22);
               ((String[]) buf[28])[0] = rslt.getString(23, 1);
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(25);
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getVarchar(27);
               ((String[]) buf[35])[0] = rslt.getVarchar(28);
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((String[]) buf[10])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
               ((String[]) buf[19])[0] = rslt.getString(15, 10);
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(16);
               ((String[]) buf[21])[0] = rslt.getVarchar(17);
               ((String[]) buf[22])[0] = rslt.getString(18, 20);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(19);
               ((String[]) buf[24])[0] = rslt.getVarchar(20);
               ((String[]) buf[25])[0] = rslt.getString(21, 1);
               ((byte[]) buf[26])[0] = rslt.getByte(22);
               ((String[]) buf[27])[0] = rslt.getString(23, 1);
               ((String[]) buf[28])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((String[]) buf[31])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
               ((String[]) buf[19])[0] = rslt.getString(15, 10);
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(16);
               ((String[]) buf[21])[0] = rslt.getVarchar(17);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 10);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((String[]) buf[10])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(10);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(12,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((short[]) buf[8])[0] = rslt.getShort(6);
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(9);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(12, 20);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 10);
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((String[]) buf[20])[0] = rslt.getVarchar(16);
               ((String[]) buf[21])[0] = rslt.getString(17, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(18);
               ((String[]) buf[23])[0] = rslt.getVarchar(19);
               ((String[]) buf[24])[0] = rslt.getString(20, 1);
               ((byte[]) buf[25])[0] = rslt.getByte(21);
               ((String[]) buf[26])[0] = rslt.getString(22, 1);
               ((String[]) buf[27])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getVarchar(26);
               ((String[]) buf[33])[0] = rslt.getVarchar(27);
               ((String[]) buf[34])[0] = rslt.getString(28, 20);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((int[]) buf[36])[0] = rslt.getInt(29);
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
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 9 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 10 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 11 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 12 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 13 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 14 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
            case 15 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[21], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 200);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               return;
      }
   }

}

