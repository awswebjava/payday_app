package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esquemahorasespecialeswwgetfilterdata extends GXProcedure
{
   public esquemahorasespecialeswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemahorasespecialeswwgetfilterdata.class ), "" );
   }

   public esquemahorasespecialeswwgetfilterdata( int remoteHandle ,
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
      esquemahorasespecialeswwgetfilterdata.this.aP5 = new String[] {""};
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
      esquemahorasespecialeswwgetfilterdata.this.AV36DDOName = aP0;
      esquemahorasespecialeswwgetfilterdata.this.AV37SearchTxt = aP1;
      esquemahorasespecialeswwgetfilterdata.this.AV38SearchTxtTo = aP2;
      esquemahorasespecialeswwgetfilterdata.this.aP3 = aP3;
      esquemahorasespecialeswwgetfilterdata.this.aP4 = aP4;
      esquemahorasespecialeswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV44EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      esquemahorasespecialeswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV44EmpCod = GXt_int1 ;
      GXt_int3 = AV45CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      esquemahorasespecialeswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV45CliCod = GXt_int3 ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaHorasEspeciales", GXv_boolean6) ;
      esquemahorasespecialeswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
      if ( GXutil.strcmp(AV31Session.getValue("EsquemaHorasEspecialesWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EsquemaHorasEspecialesWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("EsquemaHorasEspecialesWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVHSPDIATIPTRA_SEL") == 0 )
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
            AV46TFConveTarifaPDCri_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFConveTarifaPDCri_Sels.fromJSonString(AV46TFConveTarifaPDCri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV42MenuOpcCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICONVENIO") == 0 )
         {
            AV43CliConvenio = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEHSPDIADESDEOPTIONS' Routine */
      returnInSub = false ;
      AV18TFConveHsPDiaDesde = AV37SearchTxt ;
      AV19TFConveHsPDiaDesde_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels = AV14TFConvHsPDiaTipTra_Sels ;
      AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels = AV16TFConveHsPDiaDia_Sels ;
      AV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde = AV18TFConveHsPDiaDesde ;
      AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels = AV19TFConveHsPDiaDesde_Sels ;
      AV56Esquemahorasespecialeswwds_5_tfconvetarifapdia = AV20TFConveTarifaPDia ;
      AV57Esquemahorasespecialeswwds_6_tfconvetarifapdia_to = AV21TFConveTarifaPDia_To ;
      AV58Esquemahorasespecialeswwds_7_tfconvetarifapdrec = AV22TFConveTarifaPDRec ;
      AV59Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to = AV23TFConveTarifaPDRec_To ;
      AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels = AV47TFConveTarifaPDCri_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1326ConvHsPDiaTipTra ,
                                           AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels ,
                                           Byte.valueOf(A1328ConveHsPDiaDia) ,
                                           AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels ,
                                           A1329ConveHsPDiaDesde ,
                                           AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels ,
                                           A2432ConveTarifaPDCri ,
                                           AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels ,
                                           Integer.valueOf(AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels.size()) ,
                                           Integer.valueOf(AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels.size()) ,
                                           Integer.valueOf(AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels.size()) ,
                                           AV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde ,
                                           AV56Esquemahorasespecialeswwds_5_tfconvetarifapdia ,
                                           AV57Esquemahorasespecialeswwds_6_tfconvetarifapdia_to ,
                                           AV58Esquemahorasespecialeswwds_7_tfconvetarifapdrec ,
                                           AV59Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to ,
                                           Integer.valueOf(AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels.size()) ,
                                           A1330ConveTarifaPDia ,
                                           A1350ConveTarifaPDRec ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV45CliCod) ,
                                           A1565CliConvenio ,
                                           AV43CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde = GXutil.padr( GXutil.rtrim( AV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde), 5, "%") ;
      /* Using cursor P02M32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV45CliCod), AV43CliConvenio, lV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde, AV56Esquemahorasespecialeswwds_5_tfconvetarifapdia, AV57Esquemahorasespecialeswwds_6_tfconvetarifapdia_to, AV58Esquemahorasespecialeswwds_7_tfconvetarifapdrec, AV59Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2M32 = false ;
         A3CliCod = P02M32_A3CliCod[0] ;
         A1565CliConvenio = P02M32_A1565CliConvenio[0] ;
         A1329ConveHsPDiaDesde = P02M32_A1329ConveHsPDiaDesde[0] ;
         n1329ConveHsPDiaDesde = P02M32_n1329ConveHsPDiaDesde[0] ;
         A2432ConveTarifaPDCri = P02M32_A2432ConveTarifaPDCri[0] ;
         A1350ConveTarifaPDRec = P02M32_A1350ConveTarifaPDRec[0] ;
         A1330ConveTarifaPDia = P02M32_A1330ConveTarifaPDia[0] ;
         A1328ConveHsPDiaDia = P02M32_A1328ConveHsPDiaDia[0] ;
         A1326ConvHsPDiaTipTra = P02M32_A1326ConvHsPDiaTipTra[0] ;
         A1564CliPaiConve = P02M32_A1564CliPaiConve[0] ;
         A1327ConveHsExSec = P02M32_A1327ConveHsExSec[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P02M32_A1329ConveHsPDiaDesde[0], A1329ConveHsPDiaDesde) == 0 ) )
         {
            brk2M32 = false ;
            A3CliCod = P02M32_A3CliCod[0] ;
            A1565CliConvenio = P02M32_A1565CliConvenio[0] ;
            A1564CliPaiConve = P02M32_A1564CliPaiConve[0] ;
            A1327ConveHsExSec = P02M32_A1327ConveHsExSec[0] ;
            AV30count = (long)(AV30count+1) ;
            brk2M32 = true ;
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
         if ( ! brk2M32 )
         {
            brk2M32 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = esquemahorasespecialeswwgetfilterdata.this.AV39OptionsJson;
      this.aP4[0] = esquemahorasespecialeswwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = esquemahorasespecialeswwgetfilterdata.this.AV41OptionIndexesJson;
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
      AV46TFConveTarifaPDCri_SelsJson = "" ;
      AV47TFConveTarifaPDCri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42MenuOpcCod = "" ;
      AV43CliConvenio = "" ;
      A1329ConveHsPDiaDesde = "" ;
      AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde = "" ;
      AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Esquemahorasespecialeswwds_5_tfconvetarifapdia = DecimalUtil.ZERO ;
      AV57Esquemahorasespecialeswwds_6_tfconvetarifapdia_to = DecimalUtil.ZERO ;
      AV58Esquemahorasespecialeswwds_7_tfconvetarifapdrec = DecimalUtil.ZERO ;
      AV59Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to = DecimalUtil.ZERO ;
      AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde = "" ;
      A1326ConvHsPDiaTipTra = "" ;
      A2432ConveTarifaPDCri = "" ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A1565CliConvenio = "" ;
      P02M32_A3CliCod = new int[1] ;
      P02M32_A1565CliConvenio = new String[] {""} ;
      P02M32_A1329ConveHsPDiaDesde = new String[] {""} ;
      P02M32_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P02M32_A2432ConveTarifaPDCri = new String[] {""} ;
      P02M32_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M32_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M32_A1328ConveHsPDiaDia = new byte[1] ;
      P02M32_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P02M32_A1564CliPaiConve = new short[1] ;
      P02M32_A1327ConveHsExSec = new short[1] ;
      AV25Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemahorasespecialeswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02M32_A3CliCod, P02M32_A1565CliConvenio, P02M32_A1329ConveHsPDiaDesde, P02M32_n1329ConveHsPDiaDesde, P02M32_A2432ConveTarifaPDCri, P02M32_A1350ConveTarifaPDRec, P02M32_A1330ConveTarifaPDia, P02M32_A1328ConveHsPDiaDia, P02M32_A1326ConvHsPDiaTipTra, P02M32_A1564CliPaiConve,
            P02M32_A1327ConveHsExSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1328ConveHsPDiaDia ;
   private short AV44EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short Gx_err ;
   private int AV45CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV50GXV1 ;
   private int AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels_size ;
   private int AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels_size ;
   private int AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size ;
   private int AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels_size ;
   private int A3CliCod ;
   private long AV30count ;
   private java.math.BigDecimal AV20TFConveTarifaPDia ;
   private java.math.BigDecimal AV21TFConveTarifaPDia_To ;
   private java.math.BigDecimal AV22TFConveTarifaPDRec ;
   private java.math.BigDecimal AV23TFConveTarifaPDRec_To ;
   private java.math.BigDecimal AV56Esquemahorasespecialeswwds_5_tfconvetarifapdia ;
   private java.math.BigDecimal AV57Esquemahorasespecialeswwds_6_tfconvetarifapdia_to ;
   private java.math.BigDecimal AV58Esquemahorasespecialeswwds_7_tfconvetarifapdrec ;
   private java.math.BigDecimal AV59Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private String AV18TFConveHsPDiaDesde ;
   private String AV43CliConvenio ;
   private String A1329ConveHsPDiaDesde ;
   private String AV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde ;
   private String scmdbuf ;
   private String lV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde ;
   private String A1326ConvHsPDiaTipTra ;
   private String A2432ConveTarifaPDCri ;
   private String A1565CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk2M32 ;
   private boolean n1329ConveHsPDiaDesde ;
   private String AV39OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV41OptionIndexesJson ;
   private String AV13TFConvHsPDiaTipTra_SelsJson ;
   private String AV15TFConveHsPDiaDia_SelsJson ;
   private String AV17TFConveHsPDiaDesde_SelsJson ;
   private String AV46TFConveTarifaPDCri_SelsJson ;
   private String AV36DDOName ;
   private String AV37SearchTxt ;
   private String AV38SearchTxtTo ;
   private String AV42MenuOpcCod ;
   private String AV25Option ;
   private GXSimpleCollection<Byte> AV16TFConveHsPDiaDia_Sels ;
   private GXSimpleCollection<Byte> AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02M32_A3CliCod ;
   private String[] P02M32_A1565CliConvenio ;
   private String[] P02M32_A1329ConveHsPDiaDesde ;
   private boolean[] P02M32_n1329ConveHsPDiaDesde ;
   private String[] P02M32_A2432ConveTarifaPDCri ;
   private java.math.BigDecimal[] P02M32_A1350ConveTarifaPDRec ;
   private java.math.BigDecimal[] P02M32_A1330ConveTarifaPDia ;
   private byte[] P02M32_A1328ConveHsPDiaDia ;
   private String[] P02M32_A1326ConvHsPDiaTipTra ;
   private short[] P02M32_A1564CliPaiConve ;
   private short[] P02M32_A1327ConveHsExSec ;
   private GXSimpleCollection<String> AV14TFConvHsPDiaTipTra_Sels ;
   private GXSimpleCollection<String> AV19TFConveHsPDiaDesde_Sels ;
   private GXSimpleCollection<String> AV47TFConveTarifaPDCri_Sels ;
   private GXSimpleCollection<String> AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels ;
   private GXSimpleCollection<String> AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels ;
   private GXSimpleCollection<String> AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV28OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class esquemahorasespecialeswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02M32( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1326ConvHsPDiaTipTra ,
                                          GXSimpleCollection<String> AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels ,
                                          byte A1328ConveHsPDiaDia ,
                                          GXSimpleCollection<Byte> AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels ,
                                          String A1329ConveHsPDiaDesde ,
                                          GXSimpleCollection<String> AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels ,
                                          String A2432ConveTarifaPDCri ,
                                          GXSimpleCollection<String> AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels ,
                                          int AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels_size ,
                                          int AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels_size ,
                                          int AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size ,
                                          String AV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde ,
                                          java.math.BigDecimal AV56Esquemahorasespecialeswwds_5_tfconvetarifapdia ,
                                          java.math.BigDecimal AV57Esquemahorasespecialeswwds_6_tfconvetarifapdia_to ,
                                          java.math.BigDecimal AV58Esquemahorasespecialeswwds_7_tfconvetarifapdrec ,
                                          java.math.BigDecimal AV59Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to ,
                                          int AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels_size ,
                                          java.math.BigDecimal A1330ConveTarifaPDia ,
                                          java.math.BigDecimal A1350ConveTarifaPDRec ,
                                          int A3CliCod ,
                                          int AV45CliCod ,
                                          String A1565CliConvenio ,
                                          String AV43CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, CliConvenio, ConveHsPDiaDesde, ConveTarifaPDCri, ConveTarifaPDRec, ConveTarifaPDia, ConveHsPDiaDia, ConvHsPDiaTipTra, CliPaiConve, ConveHsExSec FROM" ;
      scmdbuf += " Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Esquemahorasespecialeswwds_1_tfconvhspdiatiptra_sels, "ConvHsPDiaTipTra IN (", ")")+")");
      }
      if ( AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Esquemahorasespecialeswwds_2_tfconvehspdiadia_sels, "ConveHsPDiaDia IN (", ")")+")");
      }
      if ( ( AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Esquemahorasespecialeswwds_3_tfconvehspdiadesde)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveHsPDiaDesde) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Esquemahorasespecialeswwds_4_tfconvehspdiadesde_sels, "ConveHsPDiaDesde IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV56Esquemahorasespecialeswwds_5_tfconvetarifapdia)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV57Esquemahorasespecialeswwds_6_tfconvetarifapdia_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDia <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV58Esquemahorasespecialeswwds_7_tfconvetarifapdrec)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Esquemahorasespecialeswwds_8_tfconvetarifapdrec_to)==0) )
      {
         addWhere(sWhereString, "(ConveTarifaPDRec <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Esquemahorasespecialeswwds_9_tfconvetarifapdcri_sels, "ConveTarifaPDCri IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveHsPDiaDesde" ;
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
                  return conditional_P02M32(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , (String)dynConstraints[22] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02M32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 5);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((byte[]) buf[7])[0] = rslt.getByte(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 20);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
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
                  stmt.setString(sIdx, (String)parms[8], 20);
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

