package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class escalasalarialwwgetfilterdata extends GXProcedure
{
   public escalasalarialwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escalasalarialwwgetfilterdata.class ), "" );
   }

   public escalasalarialwwgetfilterdata( int remoteHandle ,
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
      escalasalarialwwgetfilterdata.this.aP5 = new String[] {""};
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
      escalasalarialwwgetfilterdata.this.AV36DDOName = aP0;
      escalasalarialwwgetfilterdata.this.AV37SearchTxt = aP1;
      escalasalarialwwgetfilterdata.this.AV38SearchTxtTo = aP2;
      escalasalarialwwgetfilterdata.this.aP3 = aP3;
      escalasalarialwwgetfilterdata.this.aP4 = aP4;
      escalasalarialwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV47ConveCodigo ;
      new web.getconvecodsesion(remoteHandle, context).execute( GXv_char1) ;
      escalasalarialwwgetfilterdata.this.AV47ConveCodigo = GXv_char1[0] ;
      GXt_int2 = AV45CliCod ;
      GXv_int3[0] = GXt_int2 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
      escalasalarialwwgetfilterdata.this.GXt_int2 = GXv_int3[0] ;
      AV45CliCod = GXt_int2 ;
      GXv_int4[0] = AV46PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV45CliCod, GXv_int4) ;
      escalasalarialwwgetfilterdata.this.AV46PaiCod = GXv_int4[0] ;
      GXt_int5 = AV44EmpCod ;
      GXv_int4[0] = GXt_int5 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      escalasalarialwwgetfilterdata.this.GXt_int5 = GXv_int4[0] ;
      AV44EmpCod = GXt_int5 ;
      GXt_int2 = AV45CliCod ;
      GXv_int3[0] = GXt_int2 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int3) ;
      escalasalarialwwgetfilterdata.this.GXt_int2 = GXv_int3[0] ;
      AV45CliCod = GXt_int2 ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean6 = AV8IsAuthorized ;
      GXv_boolean7[0] = GXt_boolean6 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEscalaSalarial", GXv_boolean7) ;
      escalasalarialwwgetfilterdata.this.GXt_boolean6 = GXv_boolean7[0] ;
      AV8IsAuthorized = GXt_boolean6 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext8[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext8) ;
         AV9WWPContext = GXv_SdtWWPContext8[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_CATDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCATDESCRIPOPTIONS' */
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
      if ( GXutil.strcmp(AV31Session.getValue("EscalaSalarialWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EscalaSalarialWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("EscalaSalarialWWGridState"), null, null);
      }
      AV65GXV1 = 1 ;
      while ( AV65GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV65GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP") == 0 )
         {
            AV49TFCatDescrip = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP_SEL") == 0 )
         {
            AV48TFCatDescrip_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFCatDescrip_Sels.fromJSonString(AV48TFCatDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATVIGENCIA") == 0 )
         {
            AV14TFCatVigencia = localUtil.ctod( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV15TFCatVigencia_To = localUtil.ctod( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESCBASICO") == 0 )
         {
            AV54TFEscBasico = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV55TFEscBasico_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFESCADICIONAL") == 0 )
         {
            AV56TFEscAdicional = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV57TFEscAdicional_To = CommonUtil.decimalVal( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV62MenuOpcCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV65GXV1 = (int)(AV65GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCATDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV49TFCatDescrip = AV37SearchTxt ;
      AV50TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV67Escalasalarialwwds_1_tfcatdescrip = AV49TFCatDescrip ;
      AV68Escalasalarialwwds_2_tfcatdescrip_sels = AV50TFCatDescrip_Sels ;
      AV69Escalasalarialwwds_3_tfcatvigencia = AV14TFCatVigencia ;
      AV70Escalasalarialwwds_4_tfcatvigencia_to = AV15TFCatVigencia_To ;
      AV71Escalasalarialwwds_5_tfescbasico = AV54TFEscBasico ;
      AV72Escalasalarialwwds_6_tfescbasico_to = AV55TFEscBasico_To ;
      AV73Escalasalarialwwds_7_tfescadicional = AV56TFEscAdicional ;
      AV74Escalasalarialwwds_8_tfescadicional_to = AV57TFEscAdicional_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A123CatDescrip ,
                                           AV68Escalasalarialwwds_2_tfcatdescrip_sels ,
                                           Integer.valueOf(AV68Escalasalarialwwds_2_tfcatdescrip_sels.size()) ,
                                           AV67Escalasalarialwwds_1_tfcatdescrip ,
                                           AV69Escalasalarialwwds_3_tfcatvigencia ,
                                           AV70Escalasalarialwwds_4_tfcatvigencia_to ,
                                           AV71Escalasalarialwwds_5_tfescbasico ,
                                           AV72Escalasalarialwwds_6_tfescbasico_to ,
                                           AV73Escalasalarialwwds_7_tfescadicional ,
                                           AV74Escalasalarialwwds_8_tfescadicional_to ,
                                           A907CatVigencia ,
                                           A1892EscBasico ,
                                           A1893EscAdicional ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV45CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV46PaiCod) ,
                                           A1565CliConvenio ,
                                           AV47ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DATE,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV67Escalasalarialwwds_1_tfcatdescrip = GXutil.concat( GXutil.rtrim( AV67Escalasalarialwwds_1_tfcatdescrip), "%", "") ;
      /* Using cursor P01GU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV45CliCod), Short.valueOf(AV46PaiCod), AV47ConveCodigo, lV67Escalasalarialwwds_1_tfcatdescrip, AV69Escalasalarialwwds_3_tfcatvigencia, AV70Escalasalarialwwds_4_tfcatvigencia_to, AV71Escalasalarialwwds_5_tfescbasico, AV72Escalasalarialwwds_6_tfescbasico_to, AV73Escalasalarialwwds_7_tfescadicional, AV74Escalasalarialwwds_8_tfescadicional_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1GU2 = false ;
         A8CatCodigo = P01GU2_A8CatCodigo[0] ;
         A3CliCod = P01GU2_A3CliCod[0] ;
         A1564CliPaiConve = P01GU2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01GU2_A1565CliConvenio[0] ;
         A123CatDescrip = P01GU2_A123CatDescrip[0] ;
         A1893EscAdicional = P01GU2_A1893EscAdicional[0] ;
         A1892EscBasico = P01GU2_A1892EscBasico[0] ;
         A907CatVigencia = P01GU2_A907CatVigencia[0] ;
         A123CatDescrip = P01GU2_A123CatDescrip[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01GU2_A123CatDescrip[0], A123CatDescrip) == 0 ) )
         {
            brk1GU2 = false ;
            A8CatCodigo = P01GU2_A8CatCodigo[0] ;
            A3CliCod = P01GU2_A3CliCod[0] ;
            A1564CliPaiConve = P01GU2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01GU2_A1565CliConvenio[0] ;
            A907CatVigencia = P01GU2_A907CatVigencia[0] ;
            AV30count = (long)(AV30count+1) ;
            brk1GU2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A123CatDescrip)==0) )
         {
            AV25Option = A123CatDescrip ;
            AV26Options.add(AV25Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1GU2 )
         {
            brk1GU2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = escalasalarialwwgetfilterdata.this.AV39OptionsJson;
      this.aP4[0] = escalasalarialwwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = escalasalarialwwgetfilterdata.this.AV41OptionIndexesJson;
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
      AV47ConveCodigo = "" ;
      GXv_char1 = new String[1] ;
      GXv_int4 = new short[1] ;
      GXv_int3 = new int[1] ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean7 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext8 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV49TFCatDescrip = "" ;
      AV48TFCatDescrip_SelsJson = "" ;
      AV50TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFCatVigencia = GXutil.nullDate() ;
      AV15TFCatVigencia_To = GXutil.nullDate() ;
      AV54TFEscBasico = DecimalUtil.ZERO ;
      AV55TFEscBasico_To = DecimalUtil.ZERO ;
      AV56TFEscAdicional = DecimalUtil.ZERO ;
      AV57TFEscAdicional_To = DecimalUtil.ZERO ;
      AV62MenuOpcCod = "" ;
      A123CatDescrip = "" ;
      AV67Escalasalarialwwds_1_tfcatdescrip = "" ;
      AV68Escalasalarialwwds_2_tfcatdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Escalasalarialwwds_3_tfcatvigencia = GXutil.nullDate() ;
      AV70Escalasalarialwwds_4_tfcatvigencia_to = GXutil.nullDate() ;
      AV71Escalasalarialwwds_5_tfescbasico = DecimalUtil.ZERO ;
      AV72Escalasalarialwwds_6_tfescbasico_to = DecimalUtil.ZERO ;
      AV73Escalasalarialwwds_7_tfescadicional = DecimalUtil.ZERO ;
      AV74Escalasalarialwwds_8_tfescadicional_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV67Escalasalarialwwds_1_tfcatdescrip = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      A1565CliConvenio = "" ;
      P01GU2_A8CatCodigo = new String[] {""} ;
      P01GU2_A3CliCod = new int[1] ;
      P01GU2_A1564CliPaiConve = new short[1] ;
      P01GU2_A1565CliConvenio = new String[] {""} ;
      P01GU2_A123CatDescrip = new String[] {""} ;
      P01GU2_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GU2_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GU2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      A8CatCodigo = "" ;
      AV25Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.escalasalarialwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01GU2_A8CatCodigo, P01GU2_A3CliCod, P01GU2_A1564CliPaiConve, P01GU2_A1565CliConvenio, P01GU2_A123CatDescrip, P01GU2_A1893EscAdicional, P01GU2_A1892EscBasico, P01GU2_A907CatVigencia
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV46PaiCod ;
   private short AV44EmpCod ;
   private short GXt_int5 ;
   private short GXv_int4[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV45CliCod ;
   private int GXt_int2 ;
   private int GXv_int3[] ;
   private int AV65GXV1 ;
   private int AV68Escalasalarialwwds_2_tfcatdescrip_sels_size ;
   private int A3CliCod ;
   private long AV30count ;
   private java.math.BigDecimal AV54TFEscBasico ;
   private java.math.BigDecimal AV55TFEscBasico_To ;
   private java.math.BigDecimal AV56TFEscAdicional ;
   private java.math.BigDecimal AV57TFEscAdicional_To ;
   private java.math.BigDecimal AV71Escalasalarialwwds_5_tfescbasico ;
   private java.math.BigDecimal AV72Escalasalarialwwds_6_tfescbasico_to ;
   private java.math.BigDecimal AV73Escalasalarialwwds_7_tfescadicional ;
   private java.math.BigDecimal AV74Escalasalarialwwds_8_tfescadicional_to ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private String AV47ConveCodigo ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private java.util.Date AV14TFCatVigencia ;
   private java.util.Date AV15TFCatVigencia_To ;
   private java.util.Date AV69Escalasalarialwwds_3_tfcatvigencia ;
   private java.util.Date AV70Escalasalarialwwds_4_tfcatvigencia_to ;
   private java.util.Date A907CatVigencia ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean returnInSub ;
   private boolean brk1GU2 ;
   private String AV39OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV41OptionIndexesJson ;
   private String AV48TFCatDescrip_SelsJson ;
   private String AV36DDOName ;
   private String AV37SearchTxt ;
   private String AV38SearchTxtTo ;
   private String AV49TFCatDescrip ;
   private String AV62MenuOpcCod ;
   private String A123CatDescrip ;
   private String AV67Escalasalarialwwds_1_tfcatdescrip ;
   private String lV67Escalasalarialwwds_1_tfcatdescrip ;
   private String AV25Option ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GU2_A8CatCodigo ;
   private int[] P01GU2_A3CliCod ;
   private short[] P01GU2_A1564CliPaiConve ;
   private String[] P01GU2_A1565CliConvenio ;
   private String[] P01GU2_A123CatDescrip ;
   private java.math.BigDecimal[] P01GU2_A1893EscAdicional ;
   private java.math.BigDecimal[] P01GU2_A1892EscBasico ;
   private java.util.Date[] P01GU2_A907CatVigencia ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV28OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private GXSimpleCollection<String> AV50TFCatDescrip_Sels ;
   private GXSimpleCollection<String> AV68Escalasalarialwwds_2_tfcatdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext8[] ;
}

final  class escalasalarialwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01GU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV68Escalasalarialwwds_2_tfcatdescrip_sels ,
                                          int AV68Escalasalarialwwds_2_tfcatdescrip_sels_size ,
                                          String AV67Escalasalarialwwds_1_tfcatdescrip ,
                                          java.util.Date AV69Escalasalarialwwds_3_tfcatvigencia ,
                                          java.util.Date AV70Escalasalarialwwds_4_tfcatvigencia_to ,
                                          java.math.BigDecimal AV71Escalasalarialwwds_5_tfescbasico ,
                                          java.math.BigDecimal AV72Escalasalarialwwds_6_tfescbasico_to ,
                                          java.math.BigDecimal AV73Escalasalarialwwds_7_tfescadicional ,
                                          java.math.BigDecimal AV74Escalasalarialwwds_8_tfescadicional_to ,
                                          java.util.Date A907CatVigencia ,
                                          java.math.BigDecimal A1892EscBasico ,
                                          java.math.BigDecimal A1893EscAdicional ,
                                          int A3CliCod ,
                                          int AV45CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV46PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV47ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[10];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT T1.CatCodigo, T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T2.CatDescrip, T1.EscAdicional, T1.EscBasico, T1.CatVigencia FROM (Categoriavalores1 T1 INNER JOIN" ;
      scmdbuf += " Categoria1 T2 ON T2.CliCod = T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio AND T2.CatCodigo = T1.CatCodigo)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.CliPaiConve = ?)");
      addWhere(sWhereString, "(T1.CliConvenio = ( ?))");
      if ( ( AV68Escalasalarialwwds_2_tfcatdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Escalasalarialwwds_1_tfcatdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int9[3] = (byte)(1) ;
      }
      if ( AV68Escalasalarialwwds_2_tfcatdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Escalasalarialwwds_2_tfcatdescrip_sels, "T2.CatDescrip IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV69Escalasalarialwwds_3_tfcatvigencia)) )
      {
         addWhere(sWhereString, "(T1.CatVigencia >= ?)");
      }
      else
      {
         GXv_int9[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV70Escalasalarialwwds_4_tfcatvigencia_to)) )
      {
         addWhere(sWhereString, "(T1.CatVigencia <= ?)");
      }
      else
      {
         GXv_int9[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Escalasalarialwwds_5_tfescbasico)==0) )
      {
         addWhere(sWhereString, "(T1.EscBasico >= ?)");
      }
      else
      {
         GXv_int9[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Escalasalarialwwds_6_tfescbasico_to)==0) )
      {
         addWhere(sWhereString, "(T1.EscBasico <= ?)");
      }
      else
      {
         GXv_int9[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV73Escalasalarialwwds_7_tfescadicional)==0) )
      {
         addWhere(sWhereString, "(T1.EscAdicional >= ?)");
      }
      else
      {
         GXv_int9[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV74Escalasalarialwwds_8_tfescadicional_to)==0) )
      {
         addWhere(sWhereString, "(T1.EscAdicional <= ?)");
      }
      else
      {
         GXv_int9[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.CatDescrip" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
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
                  return conditional_P01GU2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , (String)dynConstraints[18] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[17], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               return;
      }
   }

}

