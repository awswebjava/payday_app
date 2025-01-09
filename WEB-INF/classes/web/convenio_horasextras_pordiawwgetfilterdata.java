package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_horasextras_pordiawwgetfilterdata extends GXProcedure
{
   public convenio_horasextras_pordiawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_horasextras_pordiawwgetfilterdata.class ), "" );
   }

   public convenio_horasextras_pordiawwgetfilterdata( int remoteHandle ,
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
      convenio_horasextras_pordiawwgetfilterdata.this.aP5 = new String[] {""};
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
      convenio_horasextras_pordiawwgetfilterdata.this.AV36DDOName = aP0;
      convenio_horasextras_pordiawwgetfilterdata.this.AV37SearchTxt = aP1;
      convenio_horasextras_pordiawwgetfilterdata.this.AV38SearchTxtTo = aP2;
      convenio_horasextras_pordiawwgetfilterdata.this.aP3 = aP3;
      convenio_horasextras_pordiawwgetfilterdata.this.aP4 = aP4;
      convenio_horasextras_pordiawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV43EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      convenio_horasextras_pordiawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV43EmpCod = GXt_int1 ;
      GXt_int3 = AV44CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_horasextras_pordiawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV44CliCod = GXt_int3 ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_horasextras_porDia", GXv_boolean6) ;
      convenio_horasextras_pordiawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_CONVEHSPDIADESDE") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEHSPDIADESDEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_CONVEHSPDIARELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEHSPDIARELREFOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV39OptionsJson = AV26Options.toJSonString(false) ;
      AV40OptionsDescJson = AV28OptionsDesc.toJSonString(false) ;
      AV41OptionIndexesJson = AV29OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("Convenio_horasextras_porDiaWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Convenio_horasextras_porDiaWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("Convenio_horasextras_porDiaWWGridState"), null, null);
      }
      AV56GXV1 = 1 ;
      while ( AV56GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSEXSEC") == 0 )
         {
            AV11TFConveHsExSec = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFConveHsExSec_To = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVHSPDIATIPTRA_SEL") == 0 )
         {
            AV13TFConvHsPDiaTipTra_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV14TFConvHsPDiaTipTra_Sels.fromJSonString(AV13TFConvHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADIA_SEL") == 0 )
         {
            AV15TFConveHsPDiaDia_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFConveHsPDiaDia_Sels.fromJSonString(AV15TFConveHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE") == 0 )
         {
            AV18TFConveHsPDiaDesde = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIADESDE_SEL") == 0 )
         {
            AV17TFConveHsPDiaDesde_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFConveHsPDiaDesde_Sels.fromJSonString(AV17TFConveHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDIA") == 0 )
         {
            AV20TFConveTarifaPDia = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV21TFConveTarifaPDia_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDREC") == 0 )
         {
            AV22TFConveTarifaPDRec = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV23TFConveTarifaPDRec_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVETARIFAPDCRI_SEL") == 0 )
         {
            AV52TFConveTarifaPDCri_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFConveTarifaPDCri_Sels.fromJSonString(AV52TFConveTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIARELREF") == 0 )
         {
            AV50TFConveHsPdiaRelRef = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEHSPDIARELREF_SEL") == 0 )
         {
            AV49TFConveHsPdiaRelRef_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFConveHsPdiaRelRef_Sels.fromJSonString(AV49TFConveHsPdiaRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV48MenuOpcCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV56GXV1 = (int)(AV56GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEHSPDIADESDEOPTIONS' Routine */
      returnInSub = false ;
      AV18TFConveHsPDiaDesde = AV37SearchTxt ;
      AV19TFConveHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV11TFConveHsExSec ;
      AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV12TFConveHsExSec_To ;
      AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV14TFConvHsPDiaTipTra_Sels ;
      AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV16TFConveHsPDiaDia_Sels ;
      AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV18TFConveHsPDiaDesde ;
      AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV19TFConveHsPDiaDesde_Sels ;
      AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV20TFConveTarifaPDia ;
      AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV21TFConveTarifaPDia_To ;
      AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV22TFConveTarifaPDRec ;
      AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV23TFConveTarifaPDRec_To ;
      AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV53TFConveTarifaPDCri_Sels ;
      AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV50TFConveHsPdiaRelRef ;
      AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV51TFConveHsPdiaRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1326ConvHsPDiaTipTra ,
                                           AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                           Byte.valueOf(A1328ConveHsPDiaDia) ,
                                           AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                           A1329ConveHsPDiaDesde ,
                                           AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                           A2432ConveTarifaPDCri ,
                                           AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                           A2067ConveHsPdiaRelRef ,
                                           AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                           Short.valueOf(AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec) ,
                                           Short.valueOf(AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) ,
                                           Integer.valueOf(AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels.size()) ,
                                           Integer.valueOf(AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels.size()) ,
                                           AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                           AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                           AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                           AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                           AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                           Integer.valueOf(AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels.size()) ,
                                           AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                           Short.valueOf(A1327ConveHsExSec) ,
                                           A1330ConveTarifaPDia ,
                                           A1350ConveTarifaPDRec ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV45PaiCod) ,
                                           A1565CliConvenio ,
                                           AV47ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = GXutil.padr( GXutil.rtrim( AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde), 5, "%") ;
      lV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = GXutil.concat( GXutil.rtrim( AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref), "%", "") ;
      /* Using cursor P01HC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), Short.valueOf(AV45PaiCod), AV47ConveCodigo, Short.valueOf(AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec), Short.valueOf(AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to), lV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde, AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia, AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to, AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec, AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to, lV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1HC2 = false ;
         A3CliCod = P01HC2_A3CliCod[0] ;
         A1564CliPaiConve = P01HC2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01HC2_A1565CliConvenio[0] ;
         A1329ConveHsPDiaDesde = P01HC2_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = P01HC2_n1329ConveHsPDiaDesde[0] ;
         A2067ConveHsPdiaRelRef = P01HC2_A2067ConveHsPdiaRelRef[0] ;
         A2432ConveTarifaPDCri = P01HC2_A2432ConveTarifaPDCri[0] ;
         A1350ConveTarifaPDRec = P01HC2_A1350ConveTarifaPDRec[0] ;
         A1330ConveTarifaPDia = P01HC2_A1330ConveTarifaPDia[0] ;
         A1328ConveHsPDiaDia = P01HC2_A1328ConveHsPDiaDia[0] ;
         A1326ConvHsPDiaTipTra = P01HC2_A1326ConvHsPDiaTipTra[0] ;
         A1327ConveHsExSec = P01HC2_A1327ConveHsExSec[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01HC2_A1329ConveHsPDiaDesde[0], A1329ConveHsPDiaDesde) == 0 ) )
         {
            brk1HC2 = false ;
            A3CliCod = P01HC2_A3CliCod[0] ;
            A1564CliPaiConve = P01HC2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01HC2_A1565CliConvenio[0] ;
            A1327ConveHsExSec = P01HC2_A1327ConveHsExSec[0] ;
            AV30count = (long)(AV30count+1) ;
            brk1HC2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1329ConveHsPDiaDesde)==0) )
         {
            AV25Option = A1329ConveHsPDiaDesde ;
            AV26Options.add(AV25Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HC2 )
         {
            brk1HC2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCONVEHSPDIARELREFOPTIONS' Routine */
      returnInSub = false ;
      AV50TFConveHsPdiaRelRef = AV37SearchTxt ;
      AV51TFConveHsPdiaRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec = AV11TFConveHsExSec ;
      AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to = AV12TFConveHsExSec_To ;
      AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = AV14TFConvHsPDiaTipTra_Sels ;
      AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = AV16TFConveHsPDiaDia_Sels ;
      AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = AV18TFConveHsPDiaDesde ;
      AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = AV19TFConveHsPDiaDesde_Sels ;
      AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = AV20TFConveTarifaPDia ;
      AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = AV21TFConveTarifaPDia_To ;
      AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = AV22TFConveTarifaPDRec ;
      AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = AV23TFConveTarifaPDRec_To ;
      AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = AV53TFConveTarifaPDCri_Sels ;
      AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = AV50TFConveHsPdiaRelRef ;
      AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = AV51TFConveHsPdiaRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1326ConvHsPDiaTipTra ,
                                           AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                           Byte.valueOf(A1328ConveHsPDiaDia) ,
                                           AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                           A1329ConveHsPDiaDesde ,
                                           AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                           A2432ConveTarifaPDCri ,
                                           AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                           A2067ConveHsPdiaRelRef ,
                                           AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                           Short.valueOf(AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec) ,
                                           Short.valueOf(AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) ,
                                           Integer.valueOf(AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels.size()) ,
                                           Integer.valueOf(AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels.size()) ,
                                           AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                           AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                           AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                           AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                           AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                           Integer.valueOf(AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels.size()) ,
                                           Integer.valueOf(AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels.size()) ,
                                           AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                           Short.valueOf(A1327ConveHsExSec) ,
                                           A1330ConveTarifaPDia ,
                                           A1350ConveTarifaPDRec ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV45PaiCod) ,
                                           A1565CliConvenio ,
                                           AV47ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = GXutil.padr( GXutil.rtrim( AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde), 5, "%") ;
      lV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = GXutil.concat( GXutil.rtrim( AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref), "%", "") ;
      /* Using cursor P01HC3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV44CliCod), Short.valueOf(AV45PaiCod), AV47ConveCodigo, Short.valueOf(AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec), Short.valueOf(AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to), lV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde, AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia, AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to, AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec, AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to, lV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1HC4 = false ;
         A3CliCod = P01HC3_A3CliCod[0] ;
         A1564CliPaiConve = P01HC3_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01HC3_A1565CliConvenio[0] ;
         A2067ConveHsPdiaRelRef = P01HC3_A2067ConveHsPdiaRelRef[0] ;
         A2432ConveTarifaPDCri = P01HC3_A2432ConveTarifaPDCri[0] ;
         A1350ConveTarifaPDRec = P01HC3_A1350ConveTarifaPDRec[0] ;
         A1330ConveTarifaPDia = P01HC3_A1330ConveTarifaPDia[0] ;
         A1329ConveHsPDiaDesde = P01HC3_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = P01HC3_n1329ConveHsPDiaDesde[0] ;
         A1328ConveHsPDiaDia = P01HC3_A1328ConveHsPDiaDia[0] ;
         A1326ConvHsPDiaTipTra = P01HC3_A1326ConvHsPDiaTipTra[0] ;
         A1327ConveHsExSec = P01HC3_A1327ConveHsExSec[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01HC3_A2067ConveHsPdiaRelRef[0], A2067ConveHsPdiaRelRef) == 0 ) )
         {
            brk1HC4 = false ;
            A3CliCod = P01HC3_A3CliCod[0] ;
            A1564CliPaiConve = P01HC3_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01HC3_A1565CliConvenio[0] ;
            A1327ConveHsExSec = P01HC3_A1327ConveHsExSec[0] ;
            AV30count = (long)(AV30count+1) ;
            brk1HC4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2067ConveHsPdiaRelRef)==0) )
         {
            AV25Option = A2067ConveHsPdiaRelRef ;
            AV26Options.add(AV25Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HC4 )
         {
            brk1HC4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenio_horasextras_pordiawwgetfilterdata.this.AV39OptionsJson;
      this.aP4[0] = convenio_horasextras_pordiawwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = convenio_horasextras_pordiawwgetfilterdata.this.AV41OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV39OptionsJson = "" ;
      AV40OptionsDescJson = "" ;
      AV41OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV13TFConvHsPDiaTipTra_SelsJson = "" ;
      AV14TFConvHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFConveHsPDiaDia_SelsJson = "" ;
      AV16TFConveHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV18TFConveHsPDiaDesde = "" ;
      AV17TFConveHsPDiaDesde_SelsJson = "" ;
      AV19TFConveHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFConveTarifaPDia = DecimalUtil.ZERO ;
      AV21TFConveTarifaPDia_To = DecimalUtil.ZERO ;
      AV22TFConveTarifaPDRec = DecimalUtil.ZERO ;
      AV23TFConveTarifaPDRec_To = DecimalUtil.ZERO ;
      AV52TFConveTarifaPDCri_SelsJson = "" ;
      AV53TFConveTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50TFConveHsPdiaRelRef = "" ;
      AV49TFConveHsPdiaRelRef_SelsJson = "" ;
      AV51TFConveHsPdiaRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48MenuOpcCod = "" ;
      A1329ConveHsPDiaDesde = "" ;
      AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = "" ;
      AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia = DecimalUtil.ZERO ;
      AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to = DecimalUtil.ZERO ;
      AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec = DecimalUtil.ZERO ;
      AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to = DecimalUtil.ZERO ;
      AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = "" ;
      AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde = "" ;
      lV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref = "" ;
      A1326ConvHsPDiaTipTra = "" ;
      A2432ConveTarifaPDCri = "" ;
      A2067ConveHsPdiaRelRef = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A1565CliConvenio = "" ;
      AV47ConveCodigo = "" ;
      P01HC2_A3CliCod = new int[1] ;
      P01HC2_A1564CliPaiConve = new short[1] ;
      P01HC2_A1565CliConvenio = new String[] {""} ;
      P01HC2_A1329ConveHsPDiaDesde = new String[] {""} ;
      P01HC2_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P01HC2_A2067ConveHsPdiaRelRef = new String[] {""} ;
      P01HC2_A2432ConveTarifaPDCri = new String[] {""} ;
      P01HC2_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01HC2_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01HC2_A1328ConveHsPDiaDia = new byte[1] ;
      P01HC2_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P01HC2_A1327ConveHsExSec = new short[1] ;
      AV25Option = "" ;
      P01HC3_A3CliCod = new int[1] ;
      P01HC3_A1564CliPaiConve = new short[1] ;
      P01HC3_A1565CliConvenio = new String[] {""} ;
      P01HC3_A2067ConveHsPdiaRelRef = new String[] {""} ;
      P01HC3_A2432ConveTarifaPDCri = new String[] {""} ;
      P01HC3_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01HC3_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01HC3_A1329ConveHsPDiaDesde = new String[] {""} ;
      P01HC3_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P01HC3_A1328ConveHsPDiaDia = new byte[1] ;
      P01HC3_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P01HC3_A1327ConveHsExSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_horasextras_pordiawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01HC2_A3CliCod, P01HC2_A1564CliPaiConve, P01HC2_A1565CliConvenio, P01HC2_A1329ConveHsPDiaDesde, P01HC2_n1329ConveHsPDiaDesde, P01HC2_A2067ConveHsPdiaRelRef, P01HC2_A2432ConveTarifaPDCri, P01HC2_A1350ConveTarifaPDRec, P01HC2_A1330ConveTarifaPDia, P01HC2_A1328ConveHsPDiaDia,
            P01HC2_A1326ConvHsPDiaTipTra, P01HC2_A1327ConveHsExSec
            }
            , new Object[] {
            P01HC3_A3CliCod, P01HC3_A1564CliPaiConve, P01HC3_A1565CliConvenio, P01HC3_A2067ConveHsPdiaRelRef, P01HC3_A2432ConveTarifaPDCri, P01HC3_A1350ConveTarifaPDRec, P01HC3_A1330ConveTarifaPDia, P01HC3_A1329ConveHsPDiaDesde, P01HC3_n1329ConveHsPDiaDesde, P01HC3_A1328ConveHsPDiaDia,
            P01HC3_A1326ConvHsPDiaTipTra, P01HC3_A1327ConveHsExSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1328ConveHsPDiaDia ;
   private short AV43EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFConveHsExSec ;
   private short AV12TFConveHsExSec_To ;
   private short AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec ;
   private short AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ;
   private short A1327ConveHsExSec ;
   private short A1564CliPaiConve ;
   private short AV45PaiCod ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV56GXV1 ;
   private int AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ;
   private int AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ;
   private int AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ;
   private int AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ;
   private int AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ;
   private int A3CliCod ;
   private long AV30count ;
   private java.math.BigDecimal AV20TFConveTarifaPDia ;
   private java.math.BigDecimal AV21TFConveTarifaPDia_To ;
   private java.math.BigDecimal AV22TFConveTarifaPDRec ;
   private java.math.BigDecimal AV23TFConveTarifaPDRec_To ;
   private java.math.BigDecimal AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ;
   private java.math.BigDecimal AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ;
   private java.math.BigDecimal AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ;
   private java.math.BigDecimal AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private String AV18TFConveHsPDiaDesde ;
   private String A1329ConveHsPDiaDesde ;
   private String AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ;
   private String scmdbuf ;
   private String lV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ;
   private String A1326ConvHsPDiaTipTra ;
   private String A2432ConveTarifaPDCri ;
   private String A1565CliConvenio ;
   private String AV47ConveCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1HC2 ;
   private boolean n1329ConveHsPDiaDesde ;
   private boolean brk1HC4 ;
   private String AV39OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV41OptionIndexesJson ;
   private String AV13TFConvHsPDiaTipTra_SelsJson ;
   private String AV15TFConveHsPDiaDia_SelsJson ;
   private String AV17TFConveHsPDiaDesde_SelsJson ;
   private String AV52TFConveTarifaPDCri_SelsJson ;
   private String AV49TFConveHsPdiaRelRef_SelsJson ;
   private String AV36DDOName ;
   private String AV37SearchTxt ;
   private String AV38SearchTxtTo ;
   private String AV50TFConveHsPdiaRelRef ;
   private String AV48MenuOpcCod ;
   private String AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ;
   private String lV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ;
   private String A2067ConveHsPdiaRelRef ;
   private String AV25Option ;
   private GXSimpleCollection<Byte> AV16TFConveHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01HC2_A3CliCod ;
   private short[] P01HC2_A1564CliPaiConve ;
   private String[] P01HC2_A1565CliConvenio ;
   private String[] P01HC2_A1329ConveHsPDiaDesde ;
   private boolean[] P01HC2_n1329ConveHsPDiaDesde ;
   private String[] P01HC2_A2067ConveHsPdiaRelRef ;
   private String[] P01HC2_A2432ConveTarifaPDCri ;
   private java.math.BigDecimal[] P01HC2_A1350ConveTarifaPDRec ;
   private java.math.BigDecimal[] P01HC2_A1330ConveTarifaPDia ;
   private byte[] P01HC2_A1328ConveHsPDiaDia ;
   private String[] P01HC2_A1326ConvHsPDiaTipTra ;
   private short[] P01HC2_A1327ConveHsExSec ;
   private int[] P01HC3_A3CliCod ;
   private short[] P01HC3_A1564CliPaiConve ;
   private String[] P01HC3_A1565CliConvenio ;
   private String[] P01HC3_A2067ConveHsPdiaRelRef ;
   private String[] P01HC3_A2432ConveTarifaPDCri ;
   private java.math.BigDecimal[] P01HC3_A1350ConveTarifaPDRec ;
   private java.math.BigDecimal[] P01HC3_A1330ConveTarifaPDia ;
   private String[] P01HC3_A1329ConveHsPDiaDesde ;
   private boolean[] P01HC3_n1329ConveHsPDiaDesde ;
   private byte[] P01HC3_A1328ConveHsPDiaDia ;
   private String[] P01HC3_A1326ConvHsPDiaTipTra ;
   private short[] P01HC3_A1327ConveHsExSec ;
   private GXSimpleCollection<String> AV14TFConvHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV19TFConveHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV53TFConveTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ;
   private GXSimpleCollection<String> AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ;
   private GXSimpleCollection<String> AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV28OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private GXSimpleCollection<String> AV51TFConveHsPdiaRelRef_Sels ;
   private GXSimpleCollection<String> AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class convenio_horasextras_pordiawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1326ConvHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                          byte A1328ConveHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                          String A1329ConveHsPDiaDesde ,
                                          GXSimpleCollection<String> AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                          String A2432ConveTarifaPDCri ,
                                          GXSimpleCollection<String> AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                          String A2067ConveHsPdiaRelRef ,
                                          GXSimpleCollection<String> AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                          short AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec ,
                                          short AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ,
                                          int AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ,
                                          int AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ,
                                          int AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ,
                                          String AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                          java.math.BigDecimal AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                          java.math.BigDecimal AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                          java.math.BigDecimal AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                          java.math.BigDecimal AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                          int AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ,
                                          int AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ,
                                          String AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                          short A1327ConveHsExSec ,
                                          java.math.BigDecimal A1330ConveTarifaPDia ,
                                          java.math.BigDecimal A1350ConveTarifaPDRec ,
                                          int A3CliCod ,
                                          int AV44CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV45PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV47ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[11];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsPDiaDesde, ConveHsPdiaRelRef, ConveTarifaPDCri, ConveTarifaPDRec, ConveTarifaPDia, ConveHsPDiaDia, ConvHsPDiaTipTra," ;
      scmdbuf += " ConveHsExSec FROM Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ! (0==AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec) )
      {
         addWhere(sWhereString, "(ConveHsExSec >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) )
      {
         addWhere(sWhereString, "(ConveHsExSec <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels, "ConvHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels, "ConveHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels, "ConveHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels, "ConveTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPdiaRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels, "ConveHsPdiaRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveHsPDiaDesde" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01HC3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1326ConvHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels ,
                                          byte A1328ConveHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels ,
                                          String A1329ConveHsPDiaDesde ,
                                          GXSimpleCollection<String> AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels ,
                                          String A2432ConveTarifaPDCri ,
                                          GXSimpleCollection<String> AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels ,
                                          String A2067ConveHsPdiaRelRef ,
                                          GXSimpleCollection<String> AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels ,
                                          short AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec ,
                                          short AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to ,
                                          int AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size ,
                                          int AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size ,
                                          int AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size ,
                                          String AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde ,
                                          java.math.BigDecimal AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia ,
                                          java.math.BigDecimal AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to ,
                                          java.math.BigDecimal AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec ,
                                          java.math.BigDecimal AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to ,
                                          int AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size ,
                                          int AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size ,
                                          String AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref ,
                                          short A1327ConveHsExSec ,
                                          java.math.BigDecimal A1330ConveTarifaPDia ,
                                          java.math.BigDecimal A1350ConveTarifaPDRec ,
                                          int A3CliCod ,
                                          int AV44CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV45PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV47ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[11];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveHsPdiaRelRef, ConveTarifaPDCri, ConveTarifaPDRec, ConveTarifaPDia, ConveHsPDiaDesde, ConveHsPDiaDia, ConvHsPDiaTipTra," ;
      scmdbuf += " ConveHsExSec FROM Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ! (0==AV58Convenio_horasextras_pordiawwds_1_tfconvehsexsec) )
      {
         addWhere(sWhereString, "(ConveHsExSec >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV59Convenio_horasextras_pordiawwds_2_tfconvehsexsec_to) )
      {
         addWhere(sWhereString, "(ConveHsExSec <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Convenio_horasextras_pordiawwds_3_tfconvhspdiatiptra_sels, "ConvHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Convenio_horasextras_pordiawwds_4_tfconvehspdiadia_sels, "ConveHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Convenio_horasextras_pordiawwds_5_tfconvehspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Convenio_horasextras_pordiawwds_6_tfconvehspdiadesde_sels, "ConveHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Convenio_horasextras_pordiawwds_7_tfconvetarifapdia)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Convenio_horasextras_pordiawwds_8_tfconvetarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV66Convenio_horasextras_pordiawwds_9_tfconvetarifapdrec)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV67Convenio_horasextras_pordiawwds_10_tfconvetarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Convenio_horasextras_pordiawwds_11_tfconvetarifapdcri_sels, "ConveTarifaPDCri IN (", ")")+")");
      }
      if ( ( AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Convenio_horasextras_pordiawwds_12_tfconvehspdiarelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPdiaRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Convenio_horasextras_pordiawwds_13_tfconvehspdiarelref_sels, "ConveHsPdiaRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveHsPdiaRelRef" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P01HC2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , (String)dynConstraints[31] );
            case 1 :
                  return conditional_P01HC3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , (String)dynConstraints[22] , ((Number) dynConstraints[23]).shortValue() , (java.math.BigDecimal)dynConstraints[24] , (java.math.BigDecimal)dynConstraints[25] , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).shortValue() , (String)dynConstraints[30] , (String)dynConstraints[31] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01HC3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,4);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((short[]) buf[11])[0] = rslt.getShort(11);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[7])[0] = rslt.getString(8, 5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((short[]) buf[11])[0] = rslt.getShort(11);
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
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 5);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 5);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 4);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 40);
               }
               return;
      }
   }

}

