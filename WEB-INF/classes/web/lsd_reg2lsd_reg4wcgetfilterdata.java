package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class lsd_reg2lsd_reg4wcgetfilterdata extends GXProcedure
{
   public lsd_reg2lsd_reg4wcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg2lsd_reg4wcgetfilterdata.class ), "" );
   }

   public lsd_reg2lsd_reg4wcgetfilterdata( int remoteHandle ,
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
      lsd_reg2lsd_reg4wcgetfilterdata.this.aP5 = new String[] {""};
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
      lsd_reg2lsd_reg4wcgetfilterdata.this.AV68DDOName = aP0;
      lsd_reg2lsd_reg4wcgetfilterdata.this.AV69SearchTxt = aP1;
      lsd_reg2lsd_reg4wcgetfilterdata.this.AV70SearchTxtTo = aP2;
      lsd_reg2lsd_reg4wcgetfilterdata.this.aP3 = aP3;
      lsd_reg2lsd_reg4wcgetfilterdata.this.aP4 = aP4;
      lsd_reg2lsd_reg4wcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV58Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV60OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV61OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg4", GXv_boolean2) ;
      lsd_reg2lsd_reg4wcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV68DDOName), "DDO_LSD4CODIGOOBRASOCIAL_63_6") == 0 )
         {
            /* Execute user subroutine: 'LOADLSD4CODIGOOBRASOCIAL_63_6OPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV71OptionsJson = AV58Options.toJSonString(false) ;
      AV72OptionsDescJson = AV60OptionsDesc.toJSonString(false) ;
      AV73OptionIndexesJson = AV61OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV63Session.getValue("LSD_reg2LSD_reg4WCGridState"), "") == 0 )
      {
         AV65GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LSD_reg2LSD_reg4WCGridState"), null, null);
      }
      else
      {
         AV65GridState.fromxml(AV63Session.getValue("LSD_reg2LSD_reg4WCGridState"), null, null);
      }
      AV80GXV1 = 1 ;
      while ( AV80GXV1 <= AV65GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV66GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV65GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV80GXV1));
         if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CODIGOOBRASOCIAL_63_6") == 0 )
         {
            AV12TFLSD4CodigoObraSocial_63_6 = AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CODIGOOBRASOCIAL_63_6_SEL") == 0 )
         {
            AV11TFLSD4CodigoObraSocial_63_6_SelsJson = AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFLSD4CodigoObraSocial_63_6_Sels.fromJSonString(AV11TFLSD4CodigoObraSocial_63_6_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CANTIDADADHERENTES_69_2") == 0 )
         {
            AV14TFLSD4CantidadAdherentes_69_2 = (byte)(GXutil.lval( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV15TFLSD4CantidadAdherentes_69_2_To = (byte)(GXutil.lval( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4APORTEADICIONALOS_71_15") == 0 )
         {
            AV16TFLSD4AporteAdicionalOS_71_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV17TFLSD4AporteAdicionalOS_71_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4CONTRIBUCIONADICIONALOS_86_15") == 0 )
         {
            AV18TFLSD4ContribucionAdicionalOS_86_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV19TFLSD4ContribucionAdicionalOS_86_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASECALCULODIFERENCIALAPORTESOSYFSR_101_15") == 0 )
         {
            AV20TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV21TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASECALCULODIFERENCIALOSYFSR_116_15") == 0 )
         {
            AV22TFLSD4BaseCalculoDiferencialOSyFSR_116_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV23TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASECALCULODIFERENCIALLRT_131_15") == 0 )
         {
            AV24TFLSD4BaseCalculoDiferencialLRT_131_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV25TFLSD4BaseCalculoDiferencialLRT_131_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4REMUNERACIONMATERNIDADANSES_146_15") == 0 )
         {
            AV26TFLSD4RemuneracionMaternidadANSeS_146_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV27TFLSD4RemuneracionMaternidadANSeS_146_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4REMUNERACIONBRUTA_161_15") == 0 )
         {
            AV28TFLSD4RemuneracionBruta_161_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV29TFLSD4RemuneracionBruta_161_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE1_176_15") == 0 )
         {
            AV30TFLSD4BaseImponible1_176_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV31TFLSD4BaseImponible1_176_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE2_191_15") == 0 )
         {
            AV32TFLSD4BaseImponible2_191_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV33TFLSD4BaseImponible2_191_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE3_206_15") == 0 )
         {
            AV34TFLSD4BaseImponible3_206_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV35TFLSD4BaseImponible3_206_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE4_221_15") == 0 )
         {
            AV36TFLSD4BaseImponible4_221_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV37TFLSD4BaseImponible4_221_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE5_236_15") == 0 )
         {
            AV38TFLSD4BaseImponible5_236_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV39TFLSD4BaseImponible5_236_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE6_251_15") == 0 )
         {
            AV40TFLSD4BaseImponible6_251_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV41TFLSD4BaseImponible6_251_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE7_266_15") == 0 )
         {
            AV42TFLSD4BaseImponible7_266_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV43TFLSD4BaseImponible7_266_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE8_281_15") == 0 )
         {
            AV44TFLSD4BaseImponible8_281_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV45TFLSD4BaseImponible8_281_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE9_296_15") == 0 )
         {
            AV46TFLSD4BaseImponible9_296_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV47TFLSD4BaseImponible9_296_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEDIFAPOSEGSOC_311_15") == 0 )
         {
            AV48TFLSD4BaseDifApoSegSoc_311_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV49TFLSD4BaseDifApoSegSoc_311_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEDIFCONTSEGSOC_326_15") == 0 )
         {
            AV50TFLSD4BaseDifContSegSoc_326_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV51TFLSD4BaseDifContSegSoc_326_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4BASEIMPONIBLE10_341_15") == 0 )
         {
            AV52TFLSD4BaseImponible10_341_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV53TFLSD4BaseImponible10_341_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD4IMPORTEADETRAER_356_15") == 0 )
         {
            AV54TFLSD4ImporteADetraer_356_15 = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV55TFLSD4ImporteADetraer_356_15_To = CommonUtil.decimalVal( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV74CliCod = (int)(GXutil.lval( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV75EmpCod = (short)(GXutil.lval( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LSDSEC") == 0 )
         {
            AV76LSDSec = (int)(GXutil.lval( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LSD2SEC") == 0 )
         {
            AV77LSD2Sec = (int)(GXutil.lval( AV66GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV80GXV1 = (int)(AV80GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLSD4CODIGOOBRASOCIAL_63_6OPTIONS' Routine */
      returnInSub = false ;
      AV12TFLSD4CodigoObraSocial_63_6 = AV69SearchTxt ;
      AV13TFLSD4CodigoObraSocial_63_6_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1699LSD4CodigoObraSocial_63_6 ,
                                           AV13TFLSD4CodigoObraSocial_63_6_Sels ,
                                           Integer.valueOf(AV13TFLSD4CodigoObraSocial_63_6_Sels.size()) ,
                                           AV12TFLSD4CodigoObraSocial_63_6 ,
                                           Byte.valueOf(AV14TFLSD4CantidadAdherentes_69_2) ,
                                           Byte.valueOf(AV15TFLSD4CantidadAdherentes_69_2_To) ,
                                           AV16TFLSD4AporteAdicionalOS_71_15 ,
                                           AV17TFLSD4AporteAdicionalOS_71_15_To ,
                                           AV18TFLSD4ContribucionAdicionalOS_86_15 ,
                                           AV19TFLSD4ContribucionAdicionalOS_86_15_To ,
                                           AV20TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ,
                                           AV21TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ,
                                           AV22TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ,
                                           AV23TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ,
                                           AV24TFLSD4BaseCalculoDiferencialLRT_131_15 ,
                                           AV25TFLSD4BaseCalculoDiferencialLRT_131_15_To ,
                                           AV26TFLSD4RemuneracionMaternidadANSeS_146_15 ,
                                           AV27TFLSD4RemuneracionMaternidadANSeS_146_15_To ,
                                           AV28TFLSD4RemuneracionBruta_161_15 ,
                                           AV29TFLSD4RemuneracionBruta_161_15_To ,
                                           AV30TFLSD4BaseImponible1_176_15 ,
                                           AV31TFLSD4BaseImponible1_176_15_To ,
                                           AV32TFLSD4BaseImponible2_191_15 ,
                                           AV33TFLSD4BaseImponible2_191_15_To ,
                                           AV34TFLSD4BaseImponible3_206_15 ,
                                           AV35TFLSD4BaseImponible3_206_15_To ,
                                           AV36TFLSD4BaseImponible4_221_15 ,
                                           AV37TFLSD4BaseImponible4_221_15_To ,
                                           AV38TFLSD4BaseImponible5_236_15 ,
                                           AV39TFLSD4BaseImponible5_236_15_To ,
                                           AV40TFLSD4BaseImponible6_251_15 ,
                                           AV41TFLSD4BaseImponible6_251_15_To ,
                                           AV42TFLSD4BaseImponible7_266_15 ,
                                           AV43TFLSD4BaseImponible7_266_15_To ,
                                           AV44TFLSD4BaseImponible8_281_15 ,
                                           AV45TFLSD4BaseImponible8_281_15_To ,
                                           AV46TFLSD4BaseImponible9_296_15 ,
                                           AV47TFLSD4BaseImponible9_296_15_To ,
                                           AV48TFLSD4BaseDifApoSegSoc_311_15 ,
                                           AV49TFLSD4BaseDifApoSegSoc_311_15_To ,
                                           AV50TFLSD4BaseDifContSegSoc_326_15 ,
                                           AV51TFLSD4BaseDifContSegSoc_326_15_To ,
                                           AV52TFLSD4BaseImponible10_341_15 ,
                                           AV53TFLSD4BaseImponible10_341_15_To ,
                                           AV54TFLSD4ImporteADetraer_356_15 ,
                                           AV55TFLSD4ImporteADetraer_356_15_To ,
                                           Byte.valueOf(A1700LSD4CantidadAdherentes_69_2) ,
                                           A1701LSD4AporteAdicionalOS_71_15 ,
                                           A1702LSD4ContribucionAdicionalOS_86 ,
                                           A1703LSD4BaseCalculoDiferencialApor ,
                                           A1704LSD4BaseCalculoDiferencialOSyF ,
                                           A1705LSD4BaseCalculoDiferencialLRT_ ,
                                           A1706LSD4RemuneracionMaternidadANSe ,
                                           A1707LSD4RemuneracionBruta_161_15 ,
                                           A1708LSD4BaseImponible1_176_15 ,
                                           A1709LSD4BaseImponible2_191_15 ,
                                           A1710LSD4BaseImponible3_206_15 ,
                                           A1711LSD4BaseImponible4_221_15 ,
                                           A1712LSD4BaseImponible5_236_15 ,
                                           A1713LSD4BaseImponible6_251_15 ,
                                           A1714LSD4BaseImponible7_266_15 ,
                                           A1715LSD4BaseImponible8_281_15 ,
                                           A1716LSD4BaseImponible9_296_15 ,
                                           A1717LSD4BaseDifApoSegSoc_311_15 ,
                                           A1718LSD4BaseDifContSegSoc_326_15 ,
                                           A1719LSD4BaseImponible10_341_15 ,
                                           A1720LSD4ImporteADetraer_356_15 ,
                                           Integer.valueOf(AV74CliCod) ,
                                           Short.valueOf(AV75EmpCod) ,
                                           Integer.valueOf(AV76LSDSec) ,
                                           Integer.valueOf(AV77LSD2Sec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A1649LSDSec) ,
                                           Integer.valueOf(A1657LSD2Sec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV12TFLSD4CodigoObraSocial_63_6 = GXutil.padr( GXutil.rtrim( AV12TFLSD4CodigoObraSocial_63_6), 6, "%") ;
      /* Using cursor P01Q22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV74CliCod), Short.valueOf(AV75EmpCod), Integer.valueOf(AV76LSDSec), Integer.valueOf(AV77LSD2Sec), lV12TFLSD4CodigoObraSocial_63_6, Byte.valueOf(AV14TFLSD4CantidadAdherentes_69_2), Byte.valueOf(AV15TFLSD4CantidadAdherentes_69_2_To), AV16TFLSD4AporteAdicionalOS_71_15, AV17TFLSD4AporteAdicionalOS_71_15_To, AV18TFLSD4ContribucionAdicionalOS_86_15, AV19TFLSD4ContribucionAdicionalOS_86_15_To, AV20TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15, AV21TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To, AV22TFLSD4BaseCalculoDiferencialOSyFSR_116_15, AV23TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To, AV24TFLSD4BaseCalculoDiferencialLRT_131_15, AV25TFLSD4BaseCalculoDiferencialLRT_131_15_To, AV26TFLSD4RemuneracionMaternidadANSeS_146_15, AV27TFLSD4RemuneracionMaternidadANSeS_146_15_To, AV28TFLSD4RemuneracionBruta_161_15, AV29TFLSD4RemuneracionBruta_161_15_To, AV30TFLSD4BaseImponible1_176_15, AV31TFLSD4BaseImponible1_176_15_To, AV32TFLSD4BaseImponible2_191_15, AV33TFLSD4BaseImponible2_191_15_To, AV34TFLSD4BaseImponible3_206_15, AV35TFLSD4BaseImponible3_206_15_To, AV36TFLSD4BaseImponible4_221_15, AV37TFLSD4BaseImponible4_221_15_To, AV38TFLSD4BaseImponible5_236_15, AV39TFLSD4BaseImponible5_236_15_To, AV40TFLSD4BaseImponible6_251_15, AV41TFLSD4BaseImponible6_251_15_To, AV42TFLSD4BaseImponible7_266_15, AV43TFLSD4BaseImponible7_266_15_To, AV44TFLSD4BaseImponible8_281_15, AV45TFLSD4BaseImponible8_281_15_To, AV46TFLSD4BaseImponible9_296_15, AV47TFLSD4BaseImponible9_296_15_To, AV48TFLSD4BaseDifApoSegSoc_311_15, AV49TFLSD4BaseDifApoSegSoc_311_15_To, AV50TFLSD4BaseDifContSegSoc_326_15, AV51TFLSD4BaseDifContSegSoc_326_15_To, AV52TFLSD4BaseImponible10_341_15, AV53TFLSD4BaseImponible10_341_15_To, AV54TFLSD4ImporteADetraer_356_15, AV55TFLSD4ImporteADetraer_356_15_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1Q22 = false ;
         A3CliCod = P01Q22_A3CliCod[0] ;
         A1EmpCod = P01Q22_A1EmpCod[0] ;
         A1649LSDSec = P01Q22_A1649LSDSec[0] ;
         A1657LSD2Sec = P01Q22_A1657LSD2Sec[0] ;
         A1699LSD4CodigoObraSocial_63_6 = P01Q22_A1699LSD4CodigoObraSocial_63_6[0] ;
         A1720LSD4ImporteADetraer_356_15 = P01Q22_A1720LSD4ImporteADetraer_356_15[0] ;
         A1719LSD4BaseImponible10_341_15 = P01Q22_A1719LSD4BaseImponible10_341_15[0] ;
         A1718LSD4BaseDifContSegSoc_326_15 = P01Q22_A1718LSD4BaseDifContSegSoc_326_15[0] ;
         A1717LSD4BaseDifApoSegSoc_311_15 = P01Q22_A1717LSD4BaseDifApoSegSoc_311_15[0] ;
         A1716LSD4BaseImponible9_296_15 = P01Q22_A1716LSD4BaseImponible9_296_15[0] ;
         A1715LSD4BaseImponible8_281_15 = P01Q22_A1715LSD4BaseImponible8_281_15[0] ;
         A1714LSD4BaseImponible7_266_15 = P01Q22_A1714LSD4BaseImponible7_266_15[0] ;
         A1713LSD4BaseImponible6_251_15 = P01Q22_A1713LSD4BaseImponible6_251_15[0] ;
         A1712LSD4BaseImponible5_236_15 = P01Q22_A1712LSD4BaseImponible5_236_15[0] ;
         A1711LSD4BaseImponible4_221_15 = P01Q22_A1711LSD4BaseImponible4_221_15[0] ;
         A1710LSD4BaseImponible3_206_15 = P01Q22_A1710LSD4BaseImponible3_206_15[0] ;
         A1709LSD4BaseImponible2_191_15 = P01Q22_A1709LSD4BaseImponible2_191_15[0] ;
         A1708LSD4BaseImponible1_176_15 = P01Q22_A1708LSD4BaseImponible1_176_15[0] ;
         A1707LSD4RemuneracionBruta_161_15 = P01Q22_A1707LSD4RemuneracionBruta_161_15[0] ;
         A1706LSD4RemuneracionMaternidadANSe = P01Q22_A1706LSD4RemuneracionMaternidadANSe[0] ;
         A1705LSD4BaseCalculoDiferencialLRT_ = P01Q22_A1705LSD4BaseCalculoDiferencialLRT_[0] ;
         A1704LSD4BaseCalculoDiferencialOSyF = P01Q22_A1704LSD4BaseCalculoDiferencialOSyF[0] ;
         A1703LSD4BaseCalculoDiferencialApor = P01Q22_A1703LSD4BaseCalculoDiferencialApor[0] ;
         A1702LSD4ContribucionAdicionalOS_86 = P01Q22_A1702LSD4ContribucionAdicionalOS_86[0] ;
         A1701LSD4AporteAdicionalOS_71_15 = P01Q22_A1701LSD4AporteAdicionalOS_71_15[0] ;
         A1700LSD4CantidadAdherentes_69_2 = P01Q22_A1700LSD4CantidadAdherentes_69_2[0] ;
         A1674LSD4Sec = P01Q22_A1674LSD4Sec[0] ;
         AV62count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01Q22_A3CliCod[0] == A3CliCod ) && ( P01Q22_A1EmpCod[0] == A1EmpCod ) && ( P01Q22_A1649LSDSec[0] == A1649LSDSec ) && ( P01Q22_A1657LSD2Sec[0] == A1657LSD2Sec ) )
         {
            if ( ! ( ( GXutil.strcmp(P01Q22_A1699LSD4CodigoObraSocial_63_6[0], A1699LSD4CodigoObraSocial_63_6) == 0 ) ) )
            {
               if (true) break;
            }
            brk1Q22 = false ;
            A1674LSD4Sec = P01Q22_A1674LSD4Sec[0] ;
            AV62count = (long)(AV62count+1) ;
            brk1Q22 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1699LSD4CodigoObraSocial_63_6)==0) )
         {
            AV57Option = A1699LSD4CodigoObraSocial_63_6 ;
            AV58Options.add(AV57Option, 0);
            AV61OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV62count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV58Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1Q22 )
         {
            brk1Q22 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = lsd_reg2lsd_reg4wcgetfilterdata.this.AV71OptionsJson;
      this.aP4[0] = lsd_reg2lsd_reg4wcgetfilterdata.this.AV72OptionsDescJson;
      this.aP5[0] = lsd_reg2lsd_reg4wcgetfilterdata.this.AV73OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV71OptionsJson = "" ;
      AV72OptionsDescJson = "" ;
      AV73OptionIndexesJson = "" ;
      AV58Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV63Session = httpContext.getWebSession();
      AV65GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV66GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFLSD4CodigoObraSocial_63_6 = "" ;
      AV11TFLSD4CodigoObraSocial_63_6_SelsJson = "" ;
      AV13TFLSD4CodigoObraSocial_63_6_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFLSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      AV17TFLSD4AporteAdicionalOS_71_15_To = DecimalUtil.ZERO ;
      AV18TFLSD4ContribucionAdicionalOS_86_15 = DecimalUtil.ZERO ;
      AV19TFLSD4ContribucionAdicionalOS_86_15_To = DecimalUtil.ZERO ;
      AV20TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 = DecimalUtil.ZERO ;
      AV21TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To = DecimalUtil.ZERO ;
      AV22TFLSD4BaseCalculoDiferencialOSyFSR_116_15 = DecimalUtil.ZERO ;
      AV23TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To = DecimalUtil.ZERO ;
      AV24TFLSD4BaseCalculoDiferencialLRT_131_15 = DecimalUtil.ZERO ;
      AV25TFLSD4BaseCalculoDiferencialLRT_131_15_To = DecimalUtil.ZERO ;
      AV26TFLSD4RemuneracionMaternidadANSeS_146_15 = DecimalUtil.ZERO ;
      AV27TFLSD4RemuneracionMaternidadANSeS_146_15_To = DecimalUtil.ZERO ;
      AV28TFLSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      AV29TFLSD4RemuneracionBruta_161_15_To = DecimalUtil.ZERO ;
      AV30TFLSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      AV31TFLSD4BaseImponible1_176_15_To = DecimalUtil.ZERO ;
      AV32TFLSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      AV33TFLSD4BaseImponible2_191_15_To = DecimalUtil.ZERO ;
      AV34TFLSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      AV35TFLSD4BaseImponible3_206_15_To = DecimalUtil.ZERO ;
      AV36TFLSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      AV37TFLSD4BaseImponible4_221_15_To = DecimalUtil.ZERO ;
      AV38TFLSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      AV39TFLSD4BaseImponible5_236_15_To = DecimalUtil.ZERO ;
      AV40TFLSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      AV41TFLSD4BaseImponible6_251_15_To = DecimalUtil.ZERO ;
      AV42TFLSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      AV43TFLSD4BaseImponible7_266_15_To = DecimalUtil.ZERO ;
      AV44TFLSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      AV45TFLSD4BaseImponible8_281_15_To = DecimalUtil.ZERO ;
      AV46TFLSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      AV47TFLSD4BaseImponible9_296_15_To = DecimalUtil.ZERO ;
      AV48TFLSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      AV49TFLSD4BaseDifApoSegSoc_311_15_To = DecimalUtil.ZERO ;
      AV50TFLSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      AV51TFLSD4BaseDifContSegSoc_326_15_To = DecimalUtil.ZERO ;
      AV52TFLSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      AV53TFLSD4BaseImponible10_341_15_To = DecimalUtil.ZERO ;
      AV54TFLSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      AV55TFLSD4ImporteADetraer_356_15_To = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV12TFLSD4CodigoObraSocial_63_6 = "" ;
      A1699LSD4CodigoObraSocial_63_6 = "" ;
      A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      P01Q22_A3CliCod = new int[1] ;
      P01Q22_A1EmpCod = new short[1] ;
      P01Q22_A1649LSDSec = new int[1] ;
      P01Q22_A1657LSD2Sec = new int[1] ;
      P01Q22_A1699LSD4CodigoObraSocial_63_6 = new String[] {""} ;
      P01Q22_A1720LSD4ImporteADetraer_356_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1719LSD4BaseImponible10_341_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1718LSD4BaseDifContSegSoc_326_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1717LSD4BaseDifApoSegSoc_311_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1716LSD4BaseImponible9_296_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1715LSD4BaseImponible8_281_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1714LSD4BaseImponible7_266_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1713LSD4BaseImponible6_251_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1712LSD4BaseImponible5_236_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1711LSD4BaseImponible4_221_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1710LSD4BaseImponible3_206_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1709LSD4BaseImponible2_191_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1708LSD4BaseImponible1_176_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1707LSD4RemuneracionBruta_161_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1706LSD4RemuneracionMaternidadANSe = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1705LSD4BaseCalculoDiferencialLRT_ = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1704LSD4BaseCalculoDiferencialOSyF = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1703LSD4BaseCalculoDiferencialApor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1702LSD4ContribucionAdicionalOS_86 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1701LSD4AporteAdicionalOS_71_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q22_A1700LSD4CantidadAdherentes_69_2 = new byte[1] ;
      P01Q22_A1674LSD4Sec = new short[1] ;
      AV57Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg2lsd_reg4wcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01Q22_A3CliCod, P01Q22_A1EmpCod, P01Q22_A1649LSDSec, P01Q22_A1657LSD2Sec, P01Q22_A1699LSD4CodigoObraSocial_63_6, P01Q22_A1720LSD4ImporteADetraer_356_15, P01Q22_A1719LSD4BaseImponible10_341_15, P01Q22_A1718LSD4BaseDifContSegSoc_326_15, P01Q22_A1717LSD4BaseDifApoSegSoc_311_15, P01Q22_A1716LSD4BaseImponible9_296_15,
            P01Q22_A1715LSD4BaseImponible8_281_15, P01Q22_A1714LSD4BaseImponible7_266_15, P01Q22_A1713LSD4BaseImponible6_251_15, P01Q22_A1712LSD4BaseImponible5_236_15, P01Q22_A1711LSD4BaseImponible4_221_15, P01Q22_A1710LSD4BaseImponible3_206_15, P01Q22_A1709LSD4BaseImponible2_191_15, P01Q22_A1708LSD4BaseImponible1_176_15, P01Q22_A1707LSD4RemuneracionBruta_161_15, P01Q22_A1706LSD4RemuneracionMaternidadANSe,
            P01Q22_A1705LSD4BaseCalculoDiferencialLRT_, P01Q22_A1704LSD4BaseCalculoDiferencialOSyF, P01Q22_A1703LSD4BaseCalculoDiferencialApor, P01Q22_A1702LSD4ContribucionAdicionalOS_86, P01Q22_A1701LSD4AporteAdicionalOS_71_15, P01Q22_A1700LSD4CantidadAdherentes_69_2, P01Q22_A1674LSD4Sec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14TFLSD4CantidadAdherentes_69_2 ;
   private byte AV15TFLSD4CantidadAdherentes_69_2_To ;
   private byte A1700LSD4CantidadAdherentes_69_2 ;
   private short AV75EmpCod ;
   private short A1EmpCod ;
   private short A1674LSD4Sec ;
   private short Gx_err ;
   private int AV80GXV1 ;
   private int AV74CliCod ;
   private int AV76LSDSec ;
   private int AV77LSD2Sec ;
   private int AV13TFLSD4CodigoObraSocial_63_6_Sels_size ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1657LSD2Sec ;
   private long AV62count ;
   private java.math.BigDecimal AV16TFLSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal AV17TFLSD4AporteAdicionalOS_71_15_To ;
   private java.math.BigDecimal AV18TFLSD4ContribucionAdicionalOS_86_15 ;
   private java.math.BigDecimal AV19TFLSD4ContribucionAdicionalOS_86_15_To ;
   private java.math.BigDecimal AV20TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ;
   private java.math.BigDecimal AV21TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ;
   private java.math.BigDecimal AV22TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ;
   private java.math.BigDecimal AV23TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ;
   private java.math.BigDecimal AV24TFLSD4BaseCalculoDiferencialLRT_131_15 ;
   private java.math.BigDecimal AV25TFLSD4BaseCalculoDiferencialLRT_131_15_To ;
   private java.math.BigDecimal AV26TFLSD4RemuneracionMaternidadANSeS_146_15 ;
   private java.math.BigDecimal AV27TFLSD4RemuneracionMaternidadANSeS_146_15_To ;
   private java.math.BigDecimal AV28TFLSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal AV29TFLSD4RemuneracionBruta_161_15_To ;
   private java.math.BigDecimal AV30TFLSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal AV31TFLSD4BaseImponible1_176_15_To ;
   private java.math.BigDecimal AV32TFLSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal AV33TFLSD4BaseImponible2_191_15_To ;
   private java.math.BigDecimal AV34TFLSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal AV35TFLSD4BaseImponible3_206_15_To ;
   private java.math.BigDecimal AV36TFLSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal AV37TFLSD4BaseImponible4_221_15_To ;
   private java.math.BigDecimal AV38TFLSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal AV39TFLSD4BaseImponible5_236_15_To ;
   private java.math.BigDecimal AV40TFLSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal AV41TFLSD4BaseImponible6_251_15_To ;
   private java.math.BigDecimal AV42TFLSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal AV43TFLSD4BaseImponible7_266_15_To ;
   private java.math.BigDecimal AV44TFLSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal AV45TFLSD4BaseImponible8_281_15_To ;
   private java.math.BigDecimal AV46TFLSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal AV47TFLSD4BaseImponible9_296_15_To ;
   private java.math.BigDecimal AV48TFLSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal AV49TFLSD4BaseDifApoSegSoc_311_15_To ;
   private java.math.BigDecimal AV50TFLSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal AV51TFLSD4BaseDifContSegSoc_326_15_To ;
   private java.math.BigDecimal AV52TFLSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal AV53TFLSD4BaseImponible10_341_15_To ;
   private java.math.BigDecimal AV54TFLSD4ImporteADetraer_356_15 ;
   private java.math.BigDecimal AV55TFLSD4ImporteADetraer_356_15_To ;
   private java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ;
   private String AV12TFLSD4CodigoObraSocial_63_6 ;
   private String scmdbuf ;
   private String lV12TFLSD4CodigoObraSocial_63_6 ;
   private String A1699LSD4CodigoObraSocial_63_6 ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk1Q22 ;
   private String AV71OptionsJson ;
   private String AV72OptionsDescJson ;
   private String AV73OptionIndexesJson ;
   private String AV11TFLSD4CodigoObraSocial_63_6_SelsJson ;
   private String AV68DDOName ;
   private String AV69SearchTxt ;
   private String AV70SearchTxtTo ;
   private String AV57Option ;
   private com.genexus.webpanels.WebSession AV63Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01Q22_A3CliCod ;
   private short[] P01Q22_A1EmpCod ;
   private int[] P01Q22_A1649LSDSec ;
   private int[] P01Q22_A1657LSD2Sec ;
   private String[] P01Q22_A1699LSD4CodigoObraSocial_63_6 ;
   private java.math.BigDecimal[] P01Q22_A1720LSD4ImporteADetraer_356_15 ;
   private java.math.BigDecimal[] P01Q22_A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal[] P01Q22_A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal[] P01Q22_A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal[] P01Q22_A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal[] P01Q22_A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal[] P01Q22_A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal[] P01Q22_A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal[] P01Q22_A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal[] P01Q22_A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal[] P01Q22_A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal[] P01Q22_A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal[] P01Q22_A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal[] P01Q22_A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal[] P01Q22_A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal[] P01Q22_A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal[] P01Q22_A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal[] P01Q22_A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal[] P01Q22_A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal[] P01Q22_A1701LSD4AporteAdicionalOS_71_15 ;
   private byte[] P01Q22_A1700LSD4CantidadAdherentes_69_2 ;
   private short[] P01Q22_A1674LSD4Sec ;
   private GXSimpleCollection<String> AV13TFLSD4CodigoObraSocial_63_6_Sels ;
   private GXSimpleCollection<String> AV58Options ;
   private GXSimpleCollection<String> AV60OptionsDesc ;
   private GXSimpleCollection<String> AV61OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV65GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV66GridStateFilterValue ;
}

final  class lsd_reg2lsd_reg4wcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01Q22( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1699LSD4CodigoObraSocial_63_6 ,
                                          GXSimpleCollection<String> AV13TFLSD4CodigoObraSocial_63_6_Sels ,
                                          int AV13TFLSD4CodigoObraSocial_63_6_Sels_size ,
                                          String AV12TFLSD4CodigoObraSocial_63_6 ,
                                          byte AV14TFLSD4CantidadAdherentes_69_2 ,
                                          byte AV15TFLSD4CantidadAdherentes_69_2_To ,
                                          java.math.BigDecimal AV16TFLSD4AporteAdicionalOS_71_15 ,
                                          java.math.BigDecimal AV17TFLSD4AporteAdicionalOS_71_15_To ,
                                          java.math.BigDecimal AV18TFLSD4ContribucionAdicionalOS_86_15 ,
                                          java.math.BigDecimal AV19TFLSD4ContribucionAdicionalOS_86_15_To ,
                                          java.math.BigDecimal AV20TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15 ,
                                          java.math.BigDecimal AV21TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To ,
                                          java.math.BigDecimal AV22TFLSD4BaseCalculoDiferencialOSyFSR_116_15 ,
                                          java.math.BigDecimal AV23TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To ,
                                          java.math.BigDecimal AV24TFLSD4BaseCalculoDiferencialLRT_131_15 ,
                                          java.math.BigDecimal AV25TFLSD4BaseCalculoDiferencialLRT_131_15_To ,
                                          java.math.BigDecimal AV26TFLSD4RemuneracionMaternidadANSeS_146_15 ,
                                          java.math.BigDecimal AV27TFLSD4RemuneracionMaternidadANSeS_146_15_To ,
                                          java.math.BigDecimal AV28TFLSD4RemuneracionBruta_161_15 ,
                                          java.math.BigDecimal AV29TFLSD4RemuneracionBruta_161_15_To ,
                                          java.math.BigDecimal AV30TFLSD4BaseImponible1_176_15 ,
                                          java.math.BigDecimal AV31TFLSD4BaseImponible1_176_15_To ,
                                          java.math.BigDecimal AV32TFLSD4BaseImponible2_191_15 ,
                                          java.math.BigDecimal AV33TFLSD4BaseImponible2_191_15_To ,
                                          java.math.BigDecimal AV34TFLSD4BaseImponible3_206_15 ,
                                          java.math.BigDecimal AV35TFLSD4BaseImponible3_206_15_To ,
                                          java.math.BigDecimal AV36TFLSD4BaseImponible4_221_15 ,
                                          java.math.BigDecimal AV37TFLSD4BaseImponible4_221_15_To ,
                                          java.math.BigDecimal AV38TFLSD4BaseImponible5_236_15 ,
                                          java.math.BigDecimal AV39TFLSD4BaseImponible5_236_15_To ,
                                          java.math.BigDecimal AV40TFLSD4BaseImponible6_251_15 ,
                                          java.math.BigDecimal AV41TFLSD4BaseImponible6_251_15_To ,
                                          java.math.BigDecimal AV42TFLSD4BaseImponible7_266_15 ,
                                          java.math.BigDecimal AV43TFLSD4BaseImponible7_266_15_To ,
                                          java.math.BigDecimal AV44TFLSD4BaseImponible8_281_15 ,
                                          java.math.BigDecimal AV45TFLSD4BaseImponible8_281_15_To ,
                                          java.math.BigDecimal AV46TFLSD4BaseImponible9_296_15 ,
                                          java.math.BigDecimal AV47TFLSD4BaseImponible9_296_15_To ,
                                          java.math.BigDecimal AV48TFLSD4BaseDifApoSegSoc_311_15 ,
                                          java.math.BigDecimal AV49TFLSD4BaseDifApoSegSoc_311_15_To ,
                                          java.math.BigDecimal AV50TFLSD4BaseDifContSegSoc_326_15 ,
                                          java.math.BigDecimal AV51TFLSD4BaseDifContSegSoc_326_15_To ,
                                          java.math.BigDecimal AV52TFLSD4BaseImponible10_341_15 ,
                                          java.math.BigDecimal AV53TFLSD4BaseImponible10_341_15_To ,
                                          java.math.BigDecimal AV54TFLSD4ImporteADetraer_356_15 ,
                                          java.math.BigDecimal AV55TFLSD4ImporteADetraer_356_15_To ,
                                          byte A1700LSD4CantidadAdherentes_69_2 ,
                                          java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ,
                                          java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ,
                                          java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ,
                                          java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ,
                                          java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ,
                                          java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ,
                                          java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ,
                                          java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ,
                                          java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ,
                                          java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ,
                                          java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ,
                                          java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ,
                                          java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ,
                                          java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ,
                                          java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ,
                                          java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ,
                                          java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ,
                                          java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ,
                                          java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ,
                                          java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ,
                                          int AV74CliCod ,
                                          short AV75EmpCod ,
                                          int AV76LSDSec ,
                                          int AV77LSD2Sec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A1649LSDSec ,
                                          int A1657LSD2Sec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[47];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoObraSocial_63_6, LSD4ImporteADetraer_356_15, LSD4BaseImponible10_341_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseDifApoSegSoc_311_15," ;
      scmdbuf += " LSD4BaseImponible9_296_15, LSD4BaseImponible8_281_15, LSD4BaseImponible7_266_15, LSD4BaseImponible6_251_15, LSD4BaseImponible5_236_15, LSD4BaseImponible4_221_15," ;
      scmdbuf += " LSD4BaseImponible3_206_15, LSD4BaseImponible2_191_15, LSD4BaseImponible1_176_15, LSD4RemuneracionBruta_161_15, LSD4RemuneracionMaternidadANSe, LSD4BaseCalculoDiferencialLRT_," ;
      scmdbuf += " LSD4BaseCalculoDiferencialOSyF, LSD4BaseCalculoDiferencialApor, LSD4ContribucionAdicionalOS_86, LSD4AporteAdicionalOS_71_15, LSD4CantidadAdherentes_69_2, LSD4Sec" ;
      scmdbuf += " FROM LSD_reg4" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ?)");
      if ( ( AV13TFLSD4CodigoObraSocial_63_6_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFLSD4CodigoObraSocial_63_6)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD4CodigoObraSocial_63_6) like LOWER(?))");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( AV13TFLSD4CodigoObraSocial_63_6_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFLSD4CodigoObraSocial_63_6_Sels, "LSD4CodigoObraSocial_63_6 IN (", ")")+")");
      }
      if ( ! (0==AV14TFLSD4CantidadAdherentes_69_2) )
      {
         addWhere(sWhereString, "(LSD4CantidadAdherentes_69_2 >= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (0==AV15TFLSD4CantidadAdherentes_69_2_To) )
      {
         addWhere(sWhereString, "(LSD4CantidadAdherentes_69_2 <= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV16TFLSD4AporteAdicionalOS_71_15)==0) )
      {
         addWhere(sWhereString, "(LSD4AporteAdicionalOS_71_15 >= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV17TFLSD4AporteAdicionalOS_71_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4AporteAdicionalOS_71_15 <= ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV18TFLSD4ContribucionAdicionalOS_86_15)==0) )
      {
         addWhere(sWhereString, "(LSD4ContribucionAdicionalOS_86 >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV19TFLSD4ContribucionAdicionalOS_86_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4ContribucionAdicionalOS_86 <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV20TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialApor >= ?)");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV21TFLSD4BaseCalculoDiferencialAportesOSyFSR_101_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialApor <= ?)");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22TFLSD4BaseCalculoDiferencialOSyFSR_116_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialOSyF >= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV23TFLSD4BaseCalculoDiferencialOSyFSR_116_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialOSyF <= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV24TFLSD4BaseCalculoDiferencialLRT_131_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialLRT_ >= ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFLSD4BaseCalculoDiferencialLRT_131_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseCalculoDiferencialLRT_ <= ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFLSD4RemuneracionMaternidadANSeS_146_15)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionMaternidadANSe >= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV27TFLSD4RemuneracionMaternidadANSeS_146_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionMaternidadANSe <= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV28TFLSD4RemuneracionBruta_161_15)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionBruta_161_15 >= ?)");
      }
      else
      {
         GXv_int4[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29TFLSD4RemuneracionBruta_161_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4RemuneracionBruta_161_15 <= ?)");
      }
      else
      {
         GXv_int4[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30TFLSD4BaseImponible1_176_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible1_176_15 >= ?)");
      }
      else
      {
         GXv_int4[21] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV31TFLSD4BaseImponible1_176_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible1_176_15 <= ?)");
      }
      else
      {
         GXv_int4[22] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV32TFLSD4BaseImponible2_191_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible2_191_15 >= ?)");
      }
      else
      {
         GXv_int4[23] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV33TFLSD4BaseImponible2_191_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible2_191_15 <= ?)");
      }
      else
      {
         GXv_int4[24] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV34TFLSD4BaseImponible3_206_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible3_206_15 >= ?)");
      }
      else
      {
         GXv_int4[25] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV35TFLSD4BaseImponible3_206_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible3_206_15 <= ?)");
      }
      else
      {
         GXv_int4[26] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV36TFLSD4BaseImponible4_221_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible4_221_15 >= ?)");
      }
      else
      {
         GXv_int4[27] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV37TFLSD4BaseImponible4_221_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible4_221_15 <= ?)");
      }
      else
      {
         GXv_int4[28] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38TFLSD4BaseImponible5_236_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible5_236_15 >= ?)");
      }
      else
      {
         GXv_int4[29] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39TFLSD4BaseImponible5_236_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible5_236_15 <= ?)");
      }
      else
      {
         GXv_int4[30] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40TFLSD4BaseImponible6_251_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible6_251_15 >= ?)");
      }
      else
      {
         GXv_int4[31] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41TFLSD4BaseImponible6_251_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible6_251_15 <= ?)");
      }
      else
      {
         GXv_int4[32] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV42TFLSD4BaseImponible7_266_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible7_266_15 >= ?)");
      }
      else
      {
         GXv_int4[33] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV43TFLSD4BaseImponible7_266_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible7_266_15 <= ?)");
      }
      else
      {
         GXv_int4[34] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44TFLSD4BaseImponible8_281_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible8_281_15 >= ?)");
      }
      else
      {
         GXv_int4[35] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV45TFLSD4BaseImponible8_281_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible8_281_15 <= ?)");
      }
      else
      {
         GXv_int4[36] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV46TFLSD4BaseImponible9_296_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible9_296_15 >= ?)");
      }
      else
      {
         GXv_int4[37] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV47TFLSD4BaseImponible9_296_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible9_296_15 <= ?)");
      }
      else
      {
         GXv_int4[38] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV48TFLSD4BaseDifApoSegSoc_311_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifApoSegSoc_311_15 >= ?)");
      }
      else
      {
         GXv_int4[39] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49TFLSD4BaseDifApoSegSoc_311_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifApoSegSoc_311_15 <= ?)");
      }
      else
      {
         GXv_int4[40] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50TFLSD4BaseDifContSegSoc_326_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifContSegSoc_326_15 >= ?)");
      }
      else
      {
         GXv_int4[41] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51TFLSD4BaseDifContSegSoc_326_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseDifContSegSoc_326_15 <= ?)");
      }
      else
      {
         GXv_int4[42] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV52TFLSD4BaseImponible10_341_15)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible10_341_15 >= ?)");
      }
      else
      {
         GXv_int4[43] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV53TFLSD4BaseImponible10_341_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4BaseImponible10_341_15 <= ?)");
      }
      else
      {
         GXv_int4[44] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54TFLSD4ImporteADetraer_356_15)==0) )
      {
         addWhere(sWhereString, "(LSD4ImporteADetraer_356_15 >= ?)");
      }
      else
      {
         GXv_int4[45] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55TFLSD4ImporteADetraer_356_15_To)==0) )
      {
         addWhere(sWhereString, "(LSD4ImporteADetraer_356_15 <= ?)");
      }
      else
      {
         GXv_int4[46] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CodigoObraSocial_63_6" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P01Q22(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , ((Number) dynConstraints[5]).byteValue() , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , (java.math.BigDecimal)dynConstraints[31] , (java.math.BigDecimal)dynConstraints[32] , (java.math.BigDecimal)dynConstraints[33] , (java.math.BigDecimal)dynConstraints[34] , (java.math.BigDecimal)dynConstraints[35] , (java.math.BigDecimal)dynConstraints[36] , (java.math.BigDecimal)dynConstraints[37] , (java.math.BigDecimal)dynConstraints[38] , (java.math.BigDecimal)dynConstraints[39] , (java.math.BigDecimal)dynConstraints[40] , (java.math.BigDecimal)dynConstraints[41] , (java.math.BigDecimal)dynConstraints[42] , (java.math.BigDecimal)dynConstraints[43] , (java.math.BigDecimal)dynConstraints[44] , (java.math.BigDecimal)dynConstraints[45] , ((Number) dynConstraints[46]).byteValue() , (java.math.BigDecimal)dynConstraints[47] , (java.math.BigDecimal)dynConstraints[48] , (java.math.BigDecimal)dynConstraints[49] , (java.math.BigDecimal)dynConstraints[50] , (java.math.BigDecimal)dynConstraints[51] , (java.math.BigDecimal)dynConstraints[52] , (java.math.BigDecimal)dynConstraints[53] , (java.math.BigDecimal)dynConstraints[54] , (java.math.BigDecimal)dynConstraints[55] , (java.math.BigDecimal)dynConstraints[56] , (java.math.BigDecimal)dynConstraints[57] , (java.math.BigDecimal)dynConstraints[58] , (java.math.BigDecimal)dynConstraints[59] , (java.math.BigDecimal)dynConstraints[60] , (java.math.BigDecimal)dynConstraints[61] , (java.math.BigDecimal)dynConstraints[62] , (java.math.BigDecimal)dynConstraints[63] , (java.math.BigDecimal)dynConstraints[64] , (java.math.BigDecimal)dynConstraints[65] , (java.math.BigDecimal)dynConstraints[66] , ((Number) dynConstraints[67]).intValue() , ((Number) dynConstraints[68]).shortValue() , ((Number) dynConstraints[69]).intValue() , ((Number) dynConstraints[70]).intValue() , ((Number) dynConstraints[71]).intValue() , ((Number) dynConstraints[72]).shortValue() , ((Number) dynConstraints[73]).intValue() , ((Number) dynConstraints[74]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Q22", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 6);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(16,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(17,2);
               ((java.math.BigDecimal[]) buf[17])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[18])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(23,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(24,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(25,2);
               ((byte[]) buf[25])[0] = rslt.getByte(26);
               ((short[]) buf[26])[0] = rslt.getShort(27);
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
                  stmt.setInt(sIdx, ((Number) parms[47]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[48]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[49]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[50]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[51], 6);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[52]).byteValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[53]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[54], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[55], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[56], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[57], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[58], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[59], 2);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[60], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[61], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[62], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[63], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[64], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[65], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[66], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[67], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[68], 2);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[69], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[70], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[71], 2);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[72], 2);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[73], 2);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[74], 2);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[75], 2);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[76], 2);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[77], 2);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[78], 2);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[79], 2);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[80], 2);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[81], 2);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[82], 2);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[83], 2);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[84], 2);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[85], 2);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[86], 2);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[87], 2);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[88], 2);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[89], 2);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[90], 2);
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[91], 2);
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[92], 2);
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[93], 2);
               }
               return;
      }
   }

}

