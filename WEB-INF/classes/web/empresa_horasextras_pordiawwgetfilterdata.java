package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresa_horasextras_pordiawwgetfilterdata extends GXProcedure
{
   public empresa_horasextras_pordiawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_horasextras_pordiawwgetfilterdata.class ), "" );
   }

   public empresa_horasextras_pordiawwgetfilterdata( int remoteHandle ,
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
      empresa_horasextras_pordiawwgetfilterdata.this.aP5 = new String[] {""};
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
      empresa_horasextras_pordiawwgetfilterdata.this.AV36DDOName = aP0;
      empresa_horasextras_pordiawwgetfilterdata.this.AV37SearchTxt = aP1;
      empresa_horasextras_pordiawwgetfilterdata.this.AV38SearchTxtTo = aP2;
      empresa_horasextras_pordiawwgetfilterdata.this.aP3 = aP3;
      empresa_horasextras_pordiawwgetfilterdata.this.aP4 = aP4;
      empresa_horasextras_pordiawwgetfilterdata.this.aP5 = aP5;
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
      empresa_horasextras_pordiawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV43EmpCod = GXt_int1 ;
      GXt_int3 = AV44CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      empresa_horasextras_pordiawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV44CliCod = GXt_int3 ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresa_horasextras_porDia", GXv_boolean6) ;
      empresa_horasextras_pordiawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_EMPHSPDIADESDE") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPHSPDIADESDEOPTIONS' */
            S121 ();
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
      if ( GXutil.strcmp(AV31Session.getValue("Empresa_horasextras_porDiaWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Empresa_horasextras_porDiaWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("Empresa_horasextras_porDiaWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIATIPTRA_SEL") == 0 )
         {
            AV13TFEmpHsPDiaTipTra_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV14TFEmpHsPDiaTipTra_Sels.fromJSonString(AV13TFEmpHsPDiaTipTra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIADIA_SEL") == 0 )
         {
            AV15TFEmpHsPDiaDia_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFEmpHsPDiaDia_Sels.fromJSonString(AV15TFEmpHsPDiaDia_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIADESDE") == 0 )
         {
            AV18TFEmpHsPDiaDesde = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPHSPDIADESDE_SEL") == 0 )
         {
            AV17TFEmpHsPDiaDesde_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFEmpHsPDiaDesde_Sels.fromJSonString(AV17TFEmpHsPDiaDesde_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPTARIFAPDIA") == 0 )
         {
            AV20TFEmpTarifaPDia = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV21TFEmpTarifaPDia_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPTARFAPDREC") == 0 )
         {
            AV22TFEmpTarfaPDRec = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV23TFEmpTarfaPDRec_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPTARIFAPDCRI_SEL") == 0 )
         {
            AV46TFEmpTarifaPDCri_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFEmpTarifaPDCri_Sels.fromJSonString(AV46TFEmpTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV45MenuOpcCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEMPHSPDIADESDEOPTIONS' Routine */
      returnInSub = false ;
      AV18TFEmpHsPDiaDesde = AV37SearchTxt ;
      AV19TFEmpHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels = AV14TFEmpHsPDiaTipTra_Sels ;
      AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels = AV16TFEmpHsPDiaDia_Sels ;
      AV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = AV18TFEmpHsPDiaDesde ;
      AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels = AV19TFEmpHsPDiaDesde_Sels ;
      AV56Empresa_horasextras_pordiawwds_5_tfemptarifapdia = AV20TFEmpTarifaPDia ;
      AV57Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to = AV21TFEmpTarifaPDia_To ;
      AV58Empresa_horasextras_pordiawwds_7_tfemptarfapdrec = AV22TFEmpTarfaPDRec ;
      AV59Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to = AV23TFEmpTarfaPDRec_To ;
      AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels = AV47TFEmpTarifaPDCri_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1339EmpHsPDiaTipTra ,
                                           AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels ,
                                           Byte.valueOf(A1341EmpHsPDiaDia) ,
                                           AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels ,
                                           A1342EmpHsPDiaDesde ,
                                           AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels ,
                                           A2433EmpTarifaPDCri ,
                                           AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels ,
                                           Integer.valueOf(AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels.size()) ,
                                           Integer.valueOf(AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels.size()) ,
                                           AV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ,
                                           AV56Empresa_horasextras_pordiawwds_5_tfemptarifapdia ,
                                           AV57Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to ,
                                           AV58Empresa_horasextras_pordiawwds_7_tfemptarfapdrec ,
                                           AV59Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to ,
                                           Integer.valueOf(AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels.size()) ,
                                           A1343EmpTarifaPDia ,
                                           A1351EmpTarfaPDRec ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV44CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV43EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = GXutil.padr( GXutil.rtrim( AV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde), 5, "%") ;
      /* Using cursor P01S22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV44CliCod), Short.valueOf(AV43EmpCod), lV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde, AV56Empresa_horasextras_pordiawwds_5_tfemptarifapdia, AV57Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to, AV58Empresa_horasextras_pordiawwds_7_tfemptarfapdrec, AV59Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1S22 = false ;
         A3CliCod = P01S22_A3CliCod[0] ;
         A1EmpCod = P01S22_A1EmpCod[0] ;
         A1342EmpHsPDiaDesde = P01S22_A1342EmpHsPDiaDesde[0] ;
         n1342EmpHsPDiaDesde = P01S22_n1342EmpHsPDiaDesde[0] ;
         A2433EmpTarifaPDCri = P01S22_A2433EmpTarifaPDCri[0] ;
         A1351EmpTarfaPDRec = P01S22_A1351EmpTarfaPDRec[0] ;
         A1343EmpTarifaPDia = P01S22_A1343EmpTarifaPDia[0] ;
         A1341EmpHsPDiaDia = P01S22_A1341EmpHsPDiaDia[0] ;
         A1339EmpHsPDiaTipTra = P01S22_A1339EmpHsPDiaTipTra[0] ;
         A1340EmpHsExSec = P01S22_A1340EmpHsExSec[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01S22_A1342EmpHsPDiaDesde[0], A1342EmpHsPDiaDesde) == 0 ) )
         {
            brk1S22 = false ;
            A3CliCod = P01S22_A3CliCod[0] ;
            A1EmpCod = P01S22_A1EmpCod[0] ;
            A1340EmpHsExSec = P01S22_A1340EmpHsExSec[0] ;
            AV30count = (long)(AV30count+1) ;
            brk1S22 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1342EmpHsPDiaDesde)==0) )
         {
            AV25Option = A1342EmpHsPDiaDesde ;
            AV26Options.add(AV25Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1S22 )
         {
            brk1S22 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = empresa_horasextras_pordiawwgetfilterdata.this.AV39OptionsJson;
      this.aP4[0] = empresa_horasextras_pordiawwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = empresa_horasextras_pordiawwgetfilterdata.this.AV41OptionIndexesJson;
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
      AV13TFEmpHsPDiaTipTra_SelsJson = "" ;
      AV14TFEmpHsPDiaTipTra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFEmpHsPDiaDia_SelsJson = "" ;
      AV16TFEmpHsPDiaDia_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV18TFEmpHsPDiaDesde = "" ;
      AV17TFEmpHsPDiaDesde_SelsJson = "" ;
      AV19TFEmpHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFEmpTarifaPDia = DecimalUtil.ZERO ;
      AV21TFEmpTarifaPDia_To = DecimalUtil.ZERO ;
      AV22TFEmpTarfaPDRec = DecimalUtil.ZERO ;
      AV23TFEmpTarfaPDRec_To = DecimalUtil.ZERO ;
      AV46TFEmpTarifaPDCri_SelsJson = "" ;
      AV47TFEmpTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV45MenuOpcCod = "" ;
      A1342EmpHsPDiaDesde = "" ;
      AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = "" ;
      AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Empresa_horasextras_pordiawwds_5_tfemptarifapdia = DecimalUtil.ZERO ;
      AV57Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to = DecimalUtil.ZERO ;
      AV58Empresa_horasextras_pordiawwds_7_tfemptarfapdrec = DecimalUtil.ZERO ;
      AV59Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to = DecimalUtil.ZERO ;
      AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde = "" ;
      A1339EmpHsPDiaTipTra = "" ;
      A2433EmpTarifaPDCri = "" ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      P01S22_A3CliCod = new int[1] ;
      P01S22_A1EmpCod = new short[1] ;
      P01S22_A1342EmpHsPDiaDesde = new String[] {""} ;
      P01S22_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      P01S22_A2433EmpTarifaPDCri = new String[] {""} ;
      P01S22_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01S22_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01S22_A1341EmpHsPDiaDia = new byte[1] ;
      P01S22_A1339EmpHsPDiaTipTra = new String[] {""} ;
      P01S22_A1340EmpHsExSec = new short[1] ;
      AV25Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_horasextras_pordiawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01S22_A3CliCod, P01S22_A1EmpCod, P01S22_A1342EmpHsPDiaDesde, P01S22_n1342EmpHsPDiaDesde, P01S22_A2433EmpTarifaPDCri, P01S22_A1351EmpTarfaPDRec, P01S22_A1343EmpTarifaPDia, P01S22_A1341EmpHsPDiaDia, P01S22_A1339EmpHsPDiaTipTra, P01S22_A1340EmpHsExSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1341EmpHsPDiaDia ;
   private short AV43EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short A1340EmpHsExSec ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV50GXV1 ;
   private int AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels_size ;
   private int AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels_size ;
   private int AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size ;
   private int AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels_size ;
   private int A3CliCod ;
   private long AV30count ;
   private java.math.BigDecimal AV20TFEmpTarifaPDia ;
   private java.math.BigDecimal AV21TFEmpTarifaPDia_To ;
   private java.math.BigDecimal AV22TFEmpTarfaPDRec ;
   private java.math.BigDecimal AV23TFEmpTarfaPDRec_To ;
   private java.math.BigDecimal AV56Empresa_horasextras_pordiawwds_5_tfemptarifapdia ;
   private java.math.BigDecimal AV57Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to ;
   private java.math.BigDecimal AV58Empresa_horasextras_pordiawwds_7_tfemptarfapdrec ;
   private java.math.BigDecimal AV59Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to ;
   private java.math.BigDecimal A1343EmpTarifaPDia ;
   private java.math.BigDecimal A1351EmpTarfaPDRec ;
   private String AV18TFEmpHsPDiaDesde ;
   private String A1342EmpHsPDiaDesde ;
   private String AV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ;
   private String scmdbuf ;
   private String lV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ;
   private String A1339EmpHsPDiaTipTra ;
   private String A2433EmpTarifaPDCri ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1S22 ;
   private boolean n1342EmpHsPDiaDesde ;
   private String AV39OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV41OptionIndexesJson ;
   private String AV13TFEmpHsPDiaTipTra_SelsJson ;
   private String AV15TFEmpHsPDiaDia_SelsJson ;
   private String AV17TFEmpHsPDiaDesde_SelsJson ;
   private String AV46TFEmpTarifaPDCri_SelsJson ;
   private String AV36DDOName ;
   private String AV37SearchTxt ;
   private String AV38SearchTxtTo ;
   private String AV45MenuOpcCod ;
   private String AV25Option ;
   private GXSimpleCollection<Byte> AV16TFEmpHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01S22_A3CliCod ;
   private short[] P01S22_A1EmpCod ;
   private String[] P01S22_A1342EmpHsPDiaDesde ;
   private boolean[] P01S22_n1342EmpHsPDiaDesde ;
   private String[] P01S22_A2433EmpTarifaPDCri ;
   private java.math.BigDecimal[] P01S22_A1351EmpTarfaPDRec ;
   private java.math.BigDecimal[] P01S22_A1343EmpTarifaPDia ;
   private byte[] P01S22_A1341EmpHsPDiaDia ;
   private String[] P01S22_A1339EmpHsPDiaTipTra ;
   private short[] P01S22_A1340EmpHsExSec ;
   private GXSimpleCollection<String> AV14TFEmpHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV19TFEmpHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV47TFEmpTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels ;
   private GXSimpleCollection<String> AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels ;
   private GXSimpleCollection<String> AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV28OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class empresa_horasextras_pordiawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01S22( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1339EmpHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels ,
                                          byte A1341EmpHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels ,
                                          String A1342EmpHsPDiaDesde ,
                                          GXSimpleCollection<String> AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels ,
                                          String A2433EmpTarifaPDCri ,
                                          GXSimpleCollection<String> AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels ,
                                          int AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels_size ,
                                          int AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels_size ,
                                          int AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size ,
                                          String AV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde ,
                                          java.math.BigDecimal AV56Empresa_horasextras_pordiawwds_5_tfemptarifapdia ,
                                          java.math.BigDecimal AV57Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to ,
                                          java.math.BigDecimal AV58Empresa_horasextras_pordiawwds_7_tfemptarfapdrec ,
                                          java.math.BigDecimal AV59Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to ,
                                          int AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels_size ,
                                          java.math.BigDecimal A1343EmpTarifaPDia ,
                                          java.math.BigDecimal A1351EmpTarfaPDRec ,
                                          int A3CliCod ,
                                          int AV44CliCod ,
                                          short A1EmpCod ,
                                          short AV43EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, EmpHsPDiaDesde, EmpTarifaPDCri, EmpTarfaPDRec, EmpTarifaPDia, EmpHsPDiaDia, EmpHsPDiaTipTra, EmpHsExSec FROM Empresahorasextras_pordia" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Empresa_horasextras_pordiawwds_1_tfemphspdiatiptra_sels, "EmpHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Empresa_horasextras_pordiawwds_2_tfemphspdiadia_sels, "EmpHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Empresa_horasextras_pordiawwds_3_tfemphspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(EmpHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Empresa_horasextras_pordiawwds_4_tfemphspdiadesde_sels, "EmpHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56Empresa_horasextras_pordiawwds_5_tfemptarifapdia)==0) )
      {
         addWhere(sWhereString, "(EmpTarifaPDia >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57Empresa_horasextras_pordiawwds_6_tfemptarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(EmpTarifaPDia <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Empresa_horasextras_pordiawwds_7_tfemptarfapdrec)==0) )
      {
         addWhere(sWhereString, "(EmpTarfaPDRec >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Empresa_horasextras_pordiawwds_8_tfemptarfapdrec_to)==0) )
      {
         addWhere(sWhereString, "(EmpTarfaPDRec <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Empresa_horasextras_pordiawwds_9_tfemptarifapdcri_sels, "EmpTarifaPDCri IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY EmpHsPDiaDesde" ;
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
                  return conditional_P01S22(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01S22", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 5);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[10], 4);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 4);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 4);
               }
               return;
      }
   }

}

