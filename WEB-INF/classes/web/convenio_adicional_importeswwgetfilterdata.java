package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicional_importeswwgetfilterdata extends GXProcedure
{
   public convenio_adicional_importeswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicional_importeswwgetfilterdata.class ), "" );
   }

   public convenio_adicional_importeswwgetfilterdata( int remoteHandle ,
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
      convenio_adicional_importeswwgetfilterdata.this.aP5 = new String[] {""};
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
      convenio_adicional_importeswwgetfilterdata.this.AV30DDOName = aP0;
      convenio_adicional_importeswwgetfilterdata.this.AV31SearchTxt = aP1;
      convenio_adicional_importeswwgetfilterdata.this.AV32SearchTxtTo = aP2;
      convenio_adicional_importeswwgetfilterdata.this.aP3 = aP3;
      convenio_adicional_importeswwgetfilterdata.this.aP4 = aP4;
      convenio_adicional_importeswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV37EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      convenio_adicional_importeswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_adicional_importeswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Adicional_Importes", GXv_boolean6) ;
      convenio_adicional_importeswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_CONVEADICOD") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADICODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV33OptionsJson = AV20Options.toJSonString(false) ;
      AV34OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV35OptionIndexesJson = AV23OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25Session.getValue("Convenio_Adicional_ImportesWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Convenio_Adicional_ImportesWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("Convenio_Adicional_ImportesWWGridState"), null, null);
      }
      AV48GXV1 = 1 ;
      while ( AV48GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV48GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD") == 0 )
         {
            AV12TFConveAdicod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD_SEL") == 0 )
         {
            AV11TFConveAdicod_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFConveAdicod_Sels.fromJSonString(AV11TFConveAdicod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIVIG") == 0 )
         {
            AV14TFConveAdiVig = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV15TFConveAdiVig_To = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIIMPORTE") == 0 )
         {
            AV16TFConveAdiImporte = CommonUtil.decimalVal( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV17TFConveAdiImporte_To = CommonUtil.decimalVal( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV45MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV48GXV1 = (int)(AV48GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEADICODOPTIONS' Routine */
      returnInSub = false ;
      AV12TFConveAdicod = AV31SearchTxt ;
      AV13TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Convenio_adicional_importeswwds_1_tfconveadicod = AV12TFConveAdicod ;
      AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels = AV13TFConveAdicod_Sels ;
      AV52Convenio_adicional_importeswwds_3_tfconveadivig = AV14TFConveAdiVig ;
      AV53Convenio_adicional_importeswwds_4_tfconveadivig_to = AV15TFConveAdiVig_To ;
      AV54Convenio_adicional_importeswwds_5_tfconveadiimporte = AV16TFConveAdiImporte ;
      AV55Convenio_adicional_importeswwds_6_tfconveadiimporte_to = AV17TFConveAdiImporte_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels ,
                                           Integer.valueOf(AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels.size()) ,
                                           AV50Convenio_adicional_importeswwds_1_tfconveadicod ,
                                           AV52Convenio_adicional_importeswwds_3_tfconveadivig ,
                                           AV53Convenio_adicional_importeswwds_4_tfconveadivig_to ,
                                           AV54Convenio_adicional_importeswwds_5_tfconveadiimporte ,
                                           AV55Convenio_adicional_importeswwds_6_tfconveadiimporte_to ,
                                           A999ConveAdiVig ,
                                           A1000ConveAdiImporte ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(AV39PaiCod) ,
                                           AV40ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV50Convenio_adicional_importeswwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV50Convenio_adicional_importeswwds_1_tfconveadicod), 20, "%") ;
      /* Using cursor P01GY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV39PaiCod), AV40ConveCodigo, lV50Convenio_adicional_importeswwds_1_tfconveadicod, AV52Convenio_adicional_importeswwds_3_tfconveadivig, AV53Convenio_adicional_importeswwds_4_tfconveadivig_to, AV54Convenio_adicional_importeswwds_5_tfconveadiimporte, AV55Convenio_adicional_importeswwds_6_tfconveadiimporte_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1GY2 = false ;
         A1565CliConvenio = P01GY2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01GY2_A1564CliPaiConve[0] ;
         A3CliCod = P01GY2_A3CliCod[0] ;
         A996ConveAdicod = P01GY2_A996ConveAdicod[0] ;
         A1000ConveAdiImporte = P01GY2_A1000ConveAdiImporte[0] ;
         A999ConveAdiVig = P01GY2_A999ConveAdiVig[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01GY2_A3CliCod[0] == A3CliCod ) && ( P01GY2_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(P01GY2_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( GXutil.strcmp(P01GY2_A996ConveAdicod[0], A996ConveAdicod) == 0 ) )
         {
            brk1GY2 = false ;
            A999ConveAdiVig = P01GY2_A999ConveAdiVig[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1GY2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A996ConveAdicod)==0) )
         {
            AV19Option = A996ConveAdicod ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1GY2 )
         {
            brk1GY2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenio_adicional_importeswwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = convenio_adicional_importeswwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = convenio_adicional_importeswwgetfilterdata.this.AV35OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33OptionsJson = "" ;
      AV34OptionsDescJson = "" ;
      AV35OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25Session = httpContext.getWebSession();
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFConveAdicod = "" ;
      AV11TFConveAdicod_SelsJson = "" ;
      AV13TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFConveAdiVig = GXutil.nullDate() ;
      AV15TFConveAdiVig_To = GXutil.nullDate() ;
      AV16TFConveAdiImporte = DecimalUtil.ZERO ;
      AV17TFConveAdiImporte_To = DecimalUtil.ZERO ;
      AV45MenuOpcCod = "" ;
      A996ConveAdicod = "" ;
      AV50Convenio_adicional_importeswwds_1_tfconveadicod = "" ;
      AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Convenio_adicional_importeswwds_3_tfconveadivig = GXutil.nullDate() ;
      AV53Convenio_adicional_importeswwds_4_tfconveadivig_to = GXutil.nullDate() ;
      AV54Convenio_adicional_importeswwds_5_tfconveadiimporte = DecimalUtil.ZERO ;
      AV55Convenio_adicional_importeswwds_6_tfconveadiimporte_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV50Convenio_adicional_importeswwds_1_tfconveadicod = "" ;
      A999ConveAdiVig = GXutil.nullDate() ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      AV40ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      P01GY2_A1565CliConvenio = new String[] {""} ;
      P01GY2_A1564CliPaiConve = new short[1] ;
      P01GY2_A3CliCod = new int[1] ;
      P01GY2_A996ConveAdicod = new String[] {""} ;
      P01GY2_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GY2_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      AV19Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicional_importeswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01GY2_A1565CliConvenio, P01GY2_A1564CliPaiConve, P01GY2_A3CliCod, P01GY2_A996ConveAdicod, P01GY2_A1000ConveAdiImporte, P01GY2_A999ConveAdiVig
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV39PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV48GXV1 ;
   private int AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels_size ;
   private int A3CliCod ;
   private long AV24count ;
   private java.math.BigDecimal AV16TFConveAdiImporte ;
   private java.math.BigDecimal AV17TFConveAdiImporte_To ;
   private java.math.BigDecimal AV54Convenio_adicional_importeswwds_5_tfconveadiimporte ;
   private java.math.BigDecimal AV55Convenio_adicional_importeswwds_6_tfconveadiimporte_to ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private String AV12TFConveAdicod ;
   private String A996ConveAdicod ;
   private String AV50Convenio_adicional_importeswwds_1_tfconveadicod ;
   private String scmdbuf ;
   private String lV50Convenio_adicional_importeswwds_1_tfconveadicod ;
   private String AV40ConveCodigo ;
   private String A1565CliConvenio ;
   private java.util.Date AV14TFConveAdiVig ;
   private java.util.Date AV15TFConveAdiVig_To ;
   private java.util.Date AV52Convenio_adicional_importeswwds_3_tfconveadivig ;
   private java.util.Date AV53Convenio_adicional_importeswwds_4_tfconveadivig_to ;
   private java.util.Date A999ConveAdiVig ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1GY2 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV11TFConveAdicod_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV45MenuOpcCod ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GY2_A1565CliConvenio ;
   private short[] P01GY2_A1564CliPaiConve ;
   private int[] P01GY2_A3CliCod ;
   private String[] P01GY2_A996ConveAdicod ;
   private java.math.BigDecimal[] P01GY2_A1000ConveAdiImporte ;
   private java.util.Date[] P01GY2_A999ConveAdiVig ;
   private GXSimpleCollection<String> AV13TFConveAdicod_Sels ;
   private GXSimpleCollection<String> AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class convenio_adicional_importeswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01GY2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels ,
                                          int AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels_size ,
                                          String AV50Convenio_adicional_importeswwds_1_tfconveadicod ,
                                          java.util.Date AV52Convenio_adicional_importeswwds_3_tfconveadivig ,
                                          java.util.Date AV53Convenio_adicional_importeswwds_4_tfconveadivig_to ,
                                          java.math.BigDecimal AV54Convenio_adicional_importeswwds_5_tfconveadiimporte ,
                                          java.math.BigDecimal AV55Convenio_adicional_importeswwds_6_tfconveadiimporte_to ,
                                          java.util.Date A999ConveAdiVig ,
                                          java.math.BigDecimal A1000ConveAdiImporte ,
                                          int AV38CliCod ,
                                          short AV39PaiCod ,
                                          String AV40ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, ConveAdicod, ConveAdiImporte, ConveAdiVig FROM convenio_adicionalimportes" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ( AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Convenio_adicional_importeswwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Convenio_adicional_importeswwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV52Convenio_adicional_importeswwds_3_tfconveadivig)) )
      {
         addWhere(sWhereString, "(ConveAdiVig >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV53Convenio_adicional_importeswwds_4_tfconveadivig_to)) )
      {
         addWhere(sWhereString, "(ConveAdiVig <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54Convenio_adicional_importeswwds_5_tfconveadiimporte)==0) )
      {
         addWhere(sWhereString, "(ConveAdiImporte >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Convenio_adicional_importeswwds_6_tfconveadiimporte_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiImporte <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod" ;
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
                  return conditional_P01GY2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , (String)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GY2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[14], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 2);
               }
               return;
      }
   }

}

