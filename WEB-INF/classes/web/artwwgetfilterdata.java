package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class artwwgetfilterdata extends GXProcedure
{
   public artwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( artwwgetfilterdata.class ), "" );
   }

   public artwwgetfilterdata( int remoteHandle ,
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
      artwwgetfilterdata.this.aP5 = new String[] {""};
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
      artwwgetfilterdata.this.AV33DDOName = aP0;
      artwwgetfilterdata.this.AV34SearchTxt = aP1;
      artwwgetfilterdata.this.AV35SearchTxtTo = aP2;
      artwwgetfilterdata.this.aP3 = aP3;
      artwwgetfilterdata.this.aP4 = aP4;
      artwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV40EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      artwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      artwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWART", GXv_boolean6) ;
      artwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_ARTNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADARTNOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_ARTPAINOM") == 0 )
         {
            /* Execute user subroutine: 'LOADARTPAINOMOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV36OptionsJson = AV23Options.toJSonString(false) ;
      AV37OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV38OptionIndexesJson = AV26OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("ARTWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ARTWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("ARTWWGridState"), null, null);
      }
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV46GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTNOM") == 0 )
         {
            AV17TFARTNom = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTNOM_SEL") == 0 )
         {
            AV16TFARTNom_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFARTNom_Sels.fromJSonString(AV16TFARTNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTPAICOD") == 0 )
         {
            AV11TFARTPaiCod = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFARTPaiCod_To = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTPAINOM") == 0 )
         {
            AV14TFARTPaiNom = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTPAINOM_SEL") == 0 )
         {
            AV13TFARTPaiNom_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFARTPaiNom_Sels.fromJSonString(AV13TFARTPaiNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFARTALI") == 0 )
         {
            AV19TFARTAli = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV20TFARTAli_To = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV43MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADARTNOMOPTIONS' Routine */
      returnInSub = false ;
      AV17TFARTNom = AV34SearchTxt ;
      AV18TFARTNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Artwwds_1_tfartnom = AV17TFARTNom ;
      AV49Artwwds_2_tfartnom_sels = AV18TFARTNom_Sels ;
      AV50Artwwds_3_tfartpaicod = AV11TFARTPaiCod ;
      AV51Artwwds_4_tfartpaicod_to = AV12TFARTPaiCod_To ;
      AV52Artwwds_5_tfartpainom = AV14TFARTPaiNom ;
      AV53Artwwds_6_tfartpainom_sels = AV15TFARTPaiNom_Sels ;
      AV54Artwwds_7_tfartali = AV19TFARTAli ;
      AV55Artwwds_8_tfartali_to = AV20TFARTAli_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1152ARTNom ,
                                           AV49Artwwds_2_tfartnom_sels ,
                                           A1150ARTPaiNom ,
                                           AV53Artwwds_6_tfartpainom_sels ,
                                           Integer.valueOf(AV49Artwwds_2_tfartnom_sels.size()) ,
                                           AV48Artwwds_1_tfartnom ,
                                           Short.valueOf(AV50Artwwds_3_tfartpaicod) ,
                                           Short.valueOf(AV51Artwwds_4_tfartpaicod_to) ,
                                           Integer.valueOf(AV53Artwwds_6_tfartpainom_sels.size()) ,
                                           AV52Artwwds_5_tfartpainom ,
                                           AV54Artwwds_7_tfartali ,
                                           AV55Artwwds_8_tfartali_to ,
                                           Short.valueOf(AV42PaiCod) ,
                                           Short.valueOf(A1149ARTPaiCod) ,
                                           A1153ARTAli } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL
                                           }
      });
      lV48Artwwds_1_tfartnom = GXutil.concat( GXutil.rtrim( AV48Artwwds_1_tfartnom), "%", "") ;
      lV52Artwwds_5_tfartpainom = GXutil.concat( GXutil.rtrim( AV52Artwwds_5_tfartpainom), "%", "") ;
      /* Using cursor P01992 */
      pr_default.execute(0, new Object[] {lV48Artwwds_1_tfartnom, Short.valueOf(AV50Artwwds_3_tfartpaicod), Short.valueOf(AV51Artwwds_4_tfartpaicod_to), lV52Artwwds_5_tfartpainom, AV54Artwwds_7_tfartali, AV55Artwwds_8_tfartali_to, Short.valueOf(AV42PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1992 = false ;
         A1152ARTNom = P01992_A1152ARTNom[0] ;
         A1153ARTAli = P01992_A1153ARTAli[0] ;
         A1150ARTPaiNom = P01992_A1150ARTPaiNom[0] ;
         A1149ARTPaiCod = P01992_A1149ARTPaiCod[0] ;
         A1151ARTSec = P01992_A1151ARTSec[0] ;
         A1150ARTPaiNom = P01992_A1150ARTPaiNom[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01992_A1152ARTNom[0], A1152ARTNom) == 0 ) )
         {
            brk1992 = false ;
            A1151ARTSec = P01992_A1151ARTSec[0] ;
            AV27count = (long)(AV27count+1) ;
            brk1992 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1152ARTNom)==0) )
         {
            AV22Option = A1152ARTNom ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1992 )
         {
            brk1992 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADARTPAINOMOPTIONS' Routine */
      returnInSub = false ;
      AV14TFARTPaiNom = AV34SearchTxt ;
      AV15TFARTPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV48Artwwds_1_tfartnom = AV17TFARTNom ;
      AV49Artwwds_2_tfartnom_sels = AV18TFARTNom_Sels ;
      AV50Artwwds_3_tfartpaicod = AV11TFARTPaiCod ;
      AV51Artwwds_4_tfartpaicod_to = AV12TFARTPaiCod_To ;
      AV52Artwwds_5_tfartpainom = AV14TFARTPaiNom ;
      AV53Artwwds_6_tfartpainom_sels = AV15TFARTPaiNom_Sels ;
      AV54Artwwds_7_tfartali = AV19TFARTAli ;
      AV55Artwwds_8_tfartali_to = AV20TFARTAli_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1152ARTNom ,
                                           AV49Artwwds_2_tfartnom_sels ,
                                           A1150ARTPaiNom ,
                                           AV53Artwwds_6_tfartpainom_sels ,
                                           Integer.valueOf(AV49Artwwds_2_tfartnom_sels.size()) ,
                                           AV48Artwwds_1_tfartnom ,
                                           Short.valueOf(AV50Artwwds_3_tfartpaicod) ,
                                           Short.valueOf(AV51Artwwds_4_tfartpaicod_to) ,
                                           Integer.valueOf(AV53Artwwds_6_tfartpainom_sels.size()) ,
                                           AV52Artwwds_5_tfartpainom ,
                                           AV54Artwwds_7_tfartali ,
                                           AV55Artwwds_8_tfartali_to ,
                                           Short.valueOf(AV42PaiCod) ,
                                           Short.valueOf(A1149ARTPaiCod) ,
                                           A1153ARTAli } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL
                                           }
      });
      lV48Artwwds_1_tfartnom = GXutil.concat( GXutil.rtrim( AV48Artwwds_1_tfartnom), "%", "") ;
      lV52Artwwds_5_tfartpainom = GXutil.concat( GXutil.rtrim( AV52Artwwds_5_tfartpainom), "%", "") ;
      /* Using cursor P01993 */
      pr_default.execute(1, new Object[] {lV48Artwwds_1_tfartnom, Short.valueOf(AV50Artwwds_3_tfartpaicod), Short.valueOf(AV51Artwwds_4_tfartpaicod_to), lV52Artwwds_5_tfartpainom, AV54Artwwds_7_tfartali, AV55Artwwds_8_tfartali_to, Short.valueOf(AV42PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1994 = false ;
         A1149ARTPaiCod = P01993_A1149ARTPaiCod[0] ;
         A1153ARTAli = P01993_A1153ARTAli[0] ;
         A1150ARTPaiNom = P01993_A1150ARTPaiNom[0] ;
         A1152ARTNom = P01993_A1152ARTNom[0] ;
         A1151ARTSec = P01993_A1151ARTSec[0] ;
         A1150ARTPaiNom = P01993_A1150ARTPaiNom[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01993_A1149ARTPaiCod[0] == A1149ARTPaiCod ) )
         {
            brk1994 = false ;
            A1151ARTSec = P01993_A1151ARTSec[0] ;
            AV27count = (long)(AV27count+1) ;
            brk1994 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1150ARTPaiNom)==0) )
         {
            AV22Option = A1150ARTPaiNom ;
            AV21InsertIndex = 1 ;
            while ( ( AV21InsertIndex <= AV23Options.size() ) && ( GXutil.strcmp((String)AV23Options.elementAt(-1+AV21InsertIndex), AV22Option) < 0 ) )
            {
               AV21InsertIndex = (int)(AV21InsertIndex+1) ;
            }
            AV23Options.add(AV22Option, AV21InsertIndex);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), AV21InsertIndex);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1994 )
         {
            brk1994 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = artwwgetfilterdata.this.AV36OptionsJson;
      this.aP4[0] = artwwgetfilterdata.this.AV37OptionsDescJson;
      this.aP5[0] = artwwgetfilterdata.this.AV38OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV36OptionsJson = "" ;
      AV37OptionsDescJson = "" ;
      AV38OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV17TFARTNom = "" ;
      AV16TFARTNom_SelsJson = "" ;
      AV18TFARTNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFARTPaiNom = "" ;
      AV13TFARTPaiNom_SelsJson = "" ;
      AV15TFARTPaiNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFARTAli = DecimalUtil.ZERO ;
      AV20TFARTAli_To = DecimalUtil.ZERO ;
      AV43MenuOpcCod = "" ;
      A1152ARTNom = "" ;
      AV48Artwwds_1_tfartnom = "" ;
      AV49Artwwds_2_tfartnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Artwwds_5_tfartpainom = "" ;
      AV53Artwwds_6_tfartpainom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Artwwds_7_tfartali = DecimalUtil.ZERO ;
      AV55Artwwds_8_tfartali_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV48Artwwds_1_tfartnom = "" ;
      lV52Artwwds_5_tfartpainom = "" ;
      A1150ARTPaiNom = "" ;
      A1153ARTAli = DecimalUtil.ZERO ;
      P01992_A1152ARTNom = new String[] {""} ;
      P01992_A1153ARTAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01992_A1150ARTPaiNom = new String[] {""} ;
      P01992_A1149ARTPaiCod = new short[1] ;
      P01992_A1151ARTSec = new short[1] ;
      AV22Option = "" ;
      P01993_A1149ARTPaiCod = new short[1] ;
      P01993_A1153ARTAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01993_A1150ARTPaiNom = new String[] {""} ;
      P01993_A1152ARTNom = new String[] {""} ;
      P01993_A1151ARTSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.artwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01992_A1152ARTNom, P01992_A1153ARTAli, P01992_A1150ARTPaiNom, P01992_A1149ARTPaiCod, P01992_A1151ARTSec
            }
            , new Object[] {
            P01993_A1149ARTPaiCod, P01993_A1153ARTAli, P01993_A1150ARTPaiNom, P01993_A1152ARTNom, P01993_A1151ARTSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFARTPaiCod ;
   private short AV12TFARTPaiCod_To ;
   private short AV50Artwwds_3_tfartpaicod ;
   private short AV51Artwwds_4_tfartpaicod_to ;
   private short AV42PaiCod ;
   private short A1149ARTPaiCod ;
   private short A1151ARTSec ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV46GXV1 ;
   private int AV49Artwwds_2_tfartnom_sels_size ;
   private int AV53Artwwds_6_tfartpainom_sels_size ;
   private int AV21InsertIndex ;
   private long AV27count ;
   private java.math.BigDecimal AV19TFARTAli ;
   private java.math.BigDecimal AV20TFARTAli_To ;
   private java.math.BigDecimal AV54Artwwds_7_tfartali ;
   private java.math.BigDecimal AV55Artwwds_8_tfartali_to ;
   private java.math.BigDecimal A1153ARTAli ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1992 ;
   private boolean brk1994 ;
   private String AV36OptionsJson ;
   private String AV37OptionsDescJson ;
   private String AV38OptionIndexesJson ;
   private String AV16TFARTNom_SelsJson ;
   private String AV13TFARTPaiNom_SelsJson ;
   private String AV33DDOName ;
   private String AV34SearchTxt ;
   private String AV35SearchTxtTo ;
   private String AV17TFARTNom ;
   private String AV14TFARTPaiNom ;
   private String AV43MenuOpcCod ;
   private String A1152ARTNom ;
   private String AV48Artwwds_1_tfartnom ;
   private String AV52Artwwds_5_tfartpainom ;
   private String lV48Artwwds_1_tfartnom ;
   private String lV52Artwwds_5_tfartpainom ;
   private String A1150ARTPaiNom ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01992_A1152ARTNom ;
   private java.math.BigDecimal[] P01992_A1153ARTAli ;
   private String[] P01992_A1150ARTPaiNom ;
   private short[] P01992_A1149ARTPaiCod ;
   private short[] P01992_A1151ARTSec ;
   private short[] P01993_A1149ARTPaiCod ;
   private java.math.BigDecimal[] P01993_A1153ARTAli ;
   private String[] P01993_A1150ARTPaiNom ;
   private String[] P01993_A1152ARTNom ;
   private short[] P01993_A1151ARTSec ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV26OptionIndexes ;
   private GXSimpleCollection<String> AV18TFARTNom_Sels ;
   private GXSimpleCollection<String> AV15TFARTPaiNom_Sels ;
   private GXSimpleCollection<String> AV49Artwwds_2_tfartnom_sels ;
   private GXSimpleCollection<String> AV53Artwwds_6_tfartpainom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class artwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01992( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1152ARTNom ,
                                          GXSimpleCollection<String> AV49Artwwds_2_tfartnom_sels ,
                                          String A1150ARTPaiNom ,
                                          GXSimpleCollection<String> AV53Artwwds_6_tfartpainom_sels ,
                                          int AV49Artwwds_2_tfartnom_sels_size ,
                                          String AV48Artwwds_1_tfartnom ,
                                          short AV50Artwwds_3_tfartpaicod ,
                                          short AV51Artwwds_4_tfartpaicod_to ,
                                          int AV53Artwwds_6_tfartpainom_sels_size ,
                                          String AV52Artwwds_5_tfartpainom ,
                                          java.math.BigDecimal AV54Artwwds_7_tfartali ,
                                          java.math.BigDecimal AV55Artwwds_8_tfartali_to ,
                                          short AV42PaiCod ,
                                          short A1149ARTPaiCod ,
                                          java.math.BigDecimal A1153ARTAli )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[7];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.ARTNom, T1.ARTAli, T2.PaiNom AS ARTPaiNom, T1.ARTPaiCod AS ARTPaiCod, T1.ARTSec FROM (ART T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.ARTPaiCod)" ;
      if ( ( AV49Artwwds_2_tfartnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Artwwds_1_tfartnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ARTNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV49Artwwds_2_tfartnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Artwwds_2_tfartnom_sels, "T1.ARTNom IN (", ")")+")");
      }
      if ( ! (0==AV50Artwwds_3_tfartpaicod) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (0==AV51Artwwds_4_tfartpaicod_to) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod <= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ( AV53Artwwds_6_tfartpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Artwwds_5_tfartpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV53Artwwds_6_tfartpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Artwwds_6_tfartpainom_sels, "T2.PaiNom IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54Artwwds_7_tfartali)==0) )
      {
         addWhere(sWhereString, "(T1.ARTAli >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Artwwds_8_tfartali_to)==0) )
      {
         addWhere(sWhereString, "(T1.ARTAli <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV42PaiCod) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod = ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ARTNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01993( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1152ARTNom ,
                                          GXSimpleCollection<String> AV49Artwwds_2_tfartnom_sels ,
                                          String A1150ARTPaiNom ,
                                          GXSimpleCollection<String> AV53Artwwds_6_tfartpainom_sels ,
                                          int AV49Artwwds_2_tfartnom_sels_size ,
                                          String AV48Artwwds_1_tfartnom ,
                                          short AV50Artwwds_3_tfartpaicod ,
                                          short AV51Artwwds_4_tfartpaicod_to ,
                                          int AV53Artwwds_6_tfartpainom_sels_size ,
                                          String AV52Artwwds_5_tfartpainom ,
                                          java.math.BigDecimal AV54Artwwds_7_tfartali ,
                                          java.math.BigDecimal AV55Artwwds_8_tfartali_to ,
                                          short AV42PaiCod ,
                                          short A1149ARTPaiCod ,
                                          java.math.BigDecimal A1153ARTAli )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[7];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.ARTPaiCod AS ARTPaiCod, T1.ARTAli, T2.PaiNom AS ARTPaiNom, T1.ARTNom, T1.ARTSec FROM (ART T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.ARTPaiCod)" ;
      if ( ( AV49Artwwds_2_tfartnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Artwwds_1_tfartnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ARTNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV49Artwwds_2_tfartnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Artwwds_2_tfartnom_sels, "T1.ARTNom IN (", ")")+")");
      }
      if ( ! (0==AV50Artwwds_3_tfartpaicod) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ! (0==AV51Artwwds_4_tfartpaicod_to) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod <= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ( AV53Artwwds_6_tfartpainom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Artwwds_5_tfartpainom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.PaiNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV53Artwwds_6_tfartpainom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Artwwds_6_tfartpainom_sels, "T2.PaiNom IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV54Artwwds_7_tfartali)==0) )
      {
         addWhere(sWhereString, "(T1.ARTAli >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV55Artwwds_8_tfartali_to)==0) )
      {
         addWhere(sWhereString, "(T1.ARTAli <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV42PaiCod) )
      {
         addWhere(sWhereString, "(T1.ARTPaiCod = ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ARTPaiCod" ;
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
                  return conditional_P01992(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.math.BigDecimal)dynConstraints[14] );
            case 1 :
                  return conditional_P01993(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).shortValue() , (java.math.BigDecimal)dynConstraints[14] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01992", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01993", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
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
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
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
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 30);
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
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               return;
      }
   }

}

