package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipoempleadorwwgetfilterdata extends GXProcedure
{
   public tipoempleadorwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipoempleadorwwgetfilterdata.class ), "" );
   }

   public tipoempleadorwwgetfilterdata( int remoteHandle ,
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
      tipoempleadorwwgetfilterdata.this.aP5 = new String[] {""};
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
      tipoempleadorwwgetfilterdata.this.AV31DDOName = aP0;
      tipoempleadorwwgetfilterdata.this.AV32SearchTxt = aP1;
      tipoempleadorwwgetfilterdata.this.AV33SearchTxtTo = aP2;
      tipoempleadorwwgetfilterdata.this.aP3 = aP3;
      tipoempleadorwwgetfilterdata.this.aP4 = aP4;
      tipoempleadorwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV38EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      tipoempleadorwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV38EmpCod = GXt_int1 ;
      GXt_int3 = AV39CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      tipoempleadorwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV39CliCod = GXt_int3 ;
      AV21Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoEmpleador", GXv_boolean6) ;
      tipoempleadorwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_TIPEMPLECOD") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPEMPLECODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_TIPEMPLEDESCRI") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPEMPLEDESCRIOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV34OptionsJson = AV21Options.toJSonString(false) ;
      AV35OptionsDescJson = AV23OptionsDesc.toJSonString(false) ;
      AV36OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV26Session.getValue("TipoEmpleadorWWGridState"), "") == 0 )
      {
         AV28GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TipoEmpleadorWWGridState"), null, null);
      }
      else
      {
         AV28GridState.fromxml(AV26Session.getValue("TipoEmpleadorWWGridState"), null, null);
      }
      AV43GXV1 = 1 ;
      while ( AV43GXV1 <= AV28GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV29GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV28GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV43GXV1));
         if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLECOD") == 0 )
         {
            AV12TFTipEmpleCod = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLECOD_SEL") == 0 )
         {
            AV11TFTipEmpleCod_SelsJson = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFTipEmpleCod_Sels.fromJSonString(AV11TFTipEmpleCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI") == 0 )
         {
            AV15TFTipEmpleDescri = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDESCRI_SEL") == 0 )
         {
            AV14TFTipEmpleDescri_SelsJson = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFTipEmpleDescri_Sels.fromJSonString(AV14TFTipEmpleDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPEMPLEDEFINS_SEL") == 0 )
         {
            AV17TFTipEmpleDefIns_SelsJson = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFTipEmpleDefIns_Sels.fromJSonString(AV17TFTipEmpleDefIns_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV40MenuOpcCod = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV43GXV1 = (int)(AV43GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTIPEMPLECODOPTIONS' Routine */
      returnInSub = false ;
      AV12TFTipEmpleCod = AV32SearchTxt ;
      AV13TFTipEmpleCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Tipoempleadorwwds_1_tftipemplecod = AV12TFTipEmpleCod ;
      AV46Tipoempleadorwwds_2_tftipemplecod_sels = AV13TFTipEmpleCod_Sels ;
      AV47Tipoempleadorwwds_3_tftipempledescri = AV15TFTipEmpleDescri ;
      AV48Tipoempleadorwwds_4_tftipempledescri_sels = AV16TFTipEmpleDescri_Sels ;
      AV49Tipoempleadorwwds_5_tftipempledefins_sels = AV18TFTipEmpleDefIns_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A45TipEmpleCod ,
                                           AV46Tipoempleadorwwds_2_tftipemplecod_sels ,
                                           A339TipEmpleDescri ,
                                           AV48Tipoempleadorwwds_4_tftipempledescri_sels ,
                                           A530TipEmpleDefIns ,
                                           AV49Tipoempleadorwwds_5_tftipempledefins_sels ,
                                           Integer.valueOf(AV46Tipoempleadorwwds_2_tftipemplecod_sels.size()) ,
                                           AV45Tipoempleadorwwds_1_tftipemplecod ,
                                           Integer.valueOf(AV48Tipoempleadorwwds_4_tftipempledescri_sels.size()) ,
                                           AV47Tipoempleadorwwds_3_tftipempledescri ,
                                           Integer.valueOf(AV49Tipoempleadorwwds_5_tftipempledefins_sels.size()) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT
                                           }
      });
      lV45Tipoempleadorwwds_1_tftipemplecod = GXutil.padr( GXutil.rtrim( AV45Tipoempleadorwwds_1_tftipemplecod), 4, "%") ;
      lV47Tipoempleadorwwds_3_tftipempledescri = GXutil.concat( GXutil.rtrim( AV47Tipoempleadorwwds_3_tftipempledescri), "%", "") ;
      /* Using cursor P01GS2 */
      pr_default.execute(0, new Object[] {lV45Tipoempleadorwwds_1_tftipemplecod, lV47Tipoempleadorwwds_3_tftipempledescri});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A530TipEmpleDefIns = P01GS2_A530TipEmpleDefIns[0] ;
         A339TipEmpleDescri = P01GS2_A339TipEmpleDescri[0] ;
         A45TipEmpleCod = P01GS2_A45TipEmpleCod[0] ;
         if ( ! (GXutil.strcmp("", A45TipEmpleCod)==0) )
         {
            AV20Option = A45TipEmpleCod ;
            AV21Options.add(AV20Option, 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADTIPEMPLEDESCRIOPTIONS' Routine */
      returnInSub = false ;
      AV15TFTipEmpleDescri = AV32SearchTxt ;
      AV16TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Tipoempleadorwwds_1_tftipemplecod = AV12TFTipEmpleCod ;
      AV46Tipoempleadorwwds_2_tftipemplecod_sels = AV13TFTipEmpleCod_Sels ;
      AV47Tipoempleadorwwds_3_tftipempledescri = AV15TFTipEmpleDescri ;
      AV48Tipoempleadorwwds_4_tftipempledescri_sels = AV16TFTipEmpleDescri_Sels ;
      AV49Tipoempleadorwwds_5_tftipempledefins_sels = AV18TFTipEmpleDefIns_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A45TipEmpleCod ,
                                           AV46Tipoempleadorwwds_2_tftipemplecod_sels ,
                                           A339TipEmpleDescri ,
                                           AV48Tipoempleadorwwds_4_tftipempledescri_sels ,
                                           A530TipEmpleDefIns ,
                                           AV49Tipoempleadorwwds_5_tftipempledefins_sels ,
                                           Integer.valueOf(AV46Tipoempleadorwwds_2_tftipemplecod_sels.size()) ,
                                           AV45Tipoempleadorwwds_1_tftipemplecod ,
                                           Integer.valueOf(AV48Tipoempleadorwwds_4_tftipempledescri_sels.size()) ,
                                           AV47Tipoempleadorwwds_3_tftipempledescri ,
                                           Integer.valueOf(AV49Tipoempleadorwwds_5_tftipempledefins_sels.size()) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT
                                           }
      });
      lV45Tipoempleadorwwds_1_tftipemplecod = GXutil.padr( GXutil.rtrim( AV45Tipoempleadorwwds_1_tftipemplecod), 4, "%") ;
      lV47Tipoempleadorwwds_3_tftipempledescri = GXutil.concat( GXutil.rtrim( AV47Tipoempleadorwwds_3_tftipempledescri), "%", "") ;
      /* Using cursor P01GS3 */
      pr_default.execute(1, new Object[] {lV45Tipoempleadorwwds_1_tftipemplecod, lV47Tipoempleadorwwds_3_tftipempledescri});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1GS3 = false ;
         A339TipEmpleDescri = P01GS3_A339TipEmpleDescri[0] ;
         A530TipEmpleDefIns = P01GS3_A530TipEmpleDefIns[0] ;
         A45TipEmpleCod = P01GS3_A45TipEmpleCod[0] ;
         AV25count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01GS3_A339TipEmpleDescri[0], A339TipEmpleDescri) == 0 ) )
         {
            brk1GS3 = false ;
            A45TipEmpleCod = P01GS3_A45TipEmpleCod[0] ;
            AV25count = (long)(AV25count+1) ;
            brk1GS3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A339TipEmpleDescri)==0) )
         {
            AV20Option = A339TipEmpleDescri ;
            AV21Options.add(AV20Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV25count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1GS3 )
         {
            brk1GS3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = tipoempleadorwwgetfilterdata.this.AV34OptionsJson;
      this.aP4[0] = tipoempleadorwwgetfilterdata.this.AV35OptionsDescJson;
      this.aP5[0] = tipoempleadorwwgetfilterdata.this.AV36OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV34OptionsJson = "" ;
      AV35OptionsDescJson = "" ;
      AV36OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV21Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV26Session = httpContext.getWebSession();
      AV28GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV29GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFTipEmpleCod = "" ;
      AV11TFTipEmpleCod_SelsJson = "" ;
      AV13TFTipEmpleCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFTipEmpleDescri = "" ;
      AV14TFTipEmpleDescri_SelsJson = "" ;
      AV16TFTipEmpleDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFTipEmpleDefIns_SelsJson = "" ;
      AV18TFTipEmpleDefIns_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40MenuOpcCod = "" ;
      A45TipEmpleCod = "" ;
      AV45Tipoempleadorwwds_1_tftipemplecod = "" ;
      AV46Tipoempleadorwwds_2_tftipemplecod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47Tipoempleadorwwds_3_tftipempledescri = "" ;
      AV48Tipoempleadorwwds_4_tftipempledescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49Tipoempleadorwwds_5_tftipempledefins_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV45Tipoempleadorwwds_1_tftipemplecod = "" ;
      lV47Tipoempleadorwwds_3_tftipempledescri = "" ;
      A339TipEmpleDescri = "" ;
      A530TipEmpleDefIns = "" ;
      P01GS2_A530TipEmpleDefIns = new String[] {""} ;
      P01GS2_A339TipEmpleDescri = new String[] {""} ;
      P01GS2_A45TipEmpleCod = new String[] {""} ;
      AV20Option = "" ;
      P01GS3_A339TipEmpleDescri = new String[] {""} ;
      P01GS3_A530TipEmpleDefIns = new String[] {""} ;
      P01GS3_A45TipEmpleCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipoempleadorwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01GS2_A530TipEmpleDefIns, P01GS2_A339TipEmpleDescri, P01GS2_A45TipEmpleCod
            }
            , new Object[] {
            P01GS3_A339TipEmpleDescri, P01GS3_A530TipEmpleDefIns, P01GS3_A45TipEmpleCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV38EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV39CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV43GXV1 ;
   private int AV46Tipoempleadorwwds_2_tftipemplecod_sels_size ;
   private int AV48Tipoempleadorwwds_4_tftipempledescri_sels_size ;
   private int AV49Tipoempleadorwwds_5_tftipempledefins_sels_size ;
   private long AV25count ;
   private String AV12TFTipEmpleCod ;
   private String A45TipEmpleCod ;
   private String AV45Tipoempleadorwwds_1_tftipemplecod ;
   private String scmdbuf ;
   private String lV45Tipoempleadorwwds_1_tftipemplecod ;
   private String A530TipEmpleDefIns ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1GS3 ;
   private String AV34OptionsJson ;
   private String AV35OptionsDescJson ;
   private String AV36OptionIndexesJson ;
   private String AV11TFTipEmpleCod_SelsJson ;
   private String AV14TFTipEmpleDescri_SelsJson ;
   private String AV17TFTipEmpleDefIns_SelsJson ;
   private String AV31DDOName ;
   private String AV32SearchTxt ;
   private String AV33SearchTxtTo ;
   private String AV15TFTipEmpleDescri ;
   private String AV40MenuOpcCod ;
   private String AV47Tipoempleadorwwds_3_tftipempledescri ;
   private String lV47Tipoempleadorwwds_3_tftipempledescri ;
   private String A339TipEmpleDescri ;
   private String AV20Option ;
   private com.genexus.webpanels.WebSession AV26Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GS2_A530TipEmpleDefIns ;
   private String[] P01GS2_A339TipEmpleDescri ;
   private String[] P01GS2_A45TipEmpleCod ;
   private String[] P01GS3_A339TipEmpleDescri ;
   private String[] P01GS3_A530TipEmpleDefIns ;
   private String[] P01GS3_A45TipEmpleCod ;
   private GXSimpleCollection<String> AV13TFTipEmpleCod_Sels ;
   private GXSimpleCollection<String> AV18TFTipEmpleDefIns_Sels ;
   private GXSimpleCollection<String> AV46Tipoempleadorwwds_2_tftipemplecod_sels ;
   private GXSimpleCollection<String> AV49Tipoempleadorwwds_5_tftipempledefins_sels ;
   private GXSimpleCollection<String> AV21Options ;
   private GXSimpleCollection<String> AV23OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private GXSimpleCollection<String> AV16TFTipEmpleDescri_Sels ;
   private GXSimpleCollection<String> AV48Tipoempleadorwwds_4_tftipempledescri_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV28GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV29GridStateFilterValue ;
}

final  class tipoempleadorwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01GS2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A45TipEmpleCod ,
                                          GXSimpleCollection<String> AV46Tipoempleadorwwds_2_tftipemplecod_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV48Tipoempleadorwwds_4_tftipempledescri_sels ,
                                          String A530TipEmpleDefIns ,
                                          GXSimpleCollection<String> AV49Tipoempleadorwwds_5_tftipempledefins_sels ,
                                          int AV46Tipoempleadorwwds_2_tftipemplecod_sels_size ,
                                          String AV45Tipoempleadorwwds_1_tftipemplecod ,
                                          int AV48Tipoempleadorwwds_4_tftipempledescri_sels_size ,
                                          String AV47Tipoempleadorwwds_3_tftipempledescri ,
                                          int AV49Tipoempleadorwwds_5_tftipempledefins_sels_size )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS TipEmpleDefIns, NULL AS TipEmpleDescri, TipEmpleCod FROM ( SELECT TipEmpleDefIns, TipEmpleDescri, TipEmpleCod FROM TipoEmpleador" ;
      if ( ( AV46Tipoempleadorwwds_2_tftipemplecod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Tipoempleadorwwds_1_tftipemplecod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV46Tipoempleadorwwds_2_tftipemplecod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Tipoempleadorwwds_2_tftipemplecod_sels, "TipEmpleCod IN (", ")")+")");
      }
      if ( ( AV48Tipoempleadorwwds_4_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Tipoempleadorwwds_3_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV48Tipoempleadorwwds_4_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Tipoempleadorwwds_4_tftipempledescri_sels, "TipEmpleDescri IN (", ")")+")");
      }
      if ( AV49Tipoempleadorwwds_5_tftipempledefins_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Tipoempleadorwwds_5_tftipempledefins_sels, "TipEmpleDefIns IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipEmpleCod" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY TipEmpleCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01GS3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A45TipEmpleCod ,
                                          GXSimpleCollection<String> AV46Tipoempleadorwwds_2_tftipemplecod_sels ,
                                          String A339TipEmpleDescri ,
                                          GXSimpleCollection<String> AV48Tipoempleadorwwds_4_tftipempledescri_sels ,
                                          String A530TipEmpleDefIns ,
                                          GXSimpleCollection<String> AV49Tipoempleadorwwds_5_tftipempledefins_sels ,
                                          int AV46Tipoempleadorwwds_2_tftipemplecod_sels_size ,
                                          String AV45Tipoempleadorwwds_1_tftipemplecod ,
                                          int AV48Tipoempleadorwwds_4_tftipempledescri_sels_size ,
                                          String AV47Tipoempleadorwwds_3_tftipempledescri ,
                                          int AV49Tipoempleadorwwds_5_tftipempledefins_sels_size )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT TipEmpleDescri, TipEmpleDefIns, TipEmpleCod FROM TipoEmpleador" ;
      if ( ( AV46Tipoempleadorwwds_2_tftipemplecod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Tipoempleadorwwds_1_tftipemplecod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV46Tipoempleadorwwds_2_tftipemplecod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Tipoempleadorwwds_2_tftipemplecod_sels, "TipEmpleCod IN (", ")")+")");
      }
      if ( ( AV48Tipoempleadorwwds_4_tftipempledescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Tipoempleadorwwds_3_tftipempledescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipEmpleDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV48Tipoempleadorwwds_4_tftipempledescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Tipoempleadorwwds_4_tftipempledescri_sels, "TipEmpleDescri IN (", ")")+")");
      }
      if ( AV49Tipoempleadorwwds_5_tftipempledefins_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Tipoempleadorwwds_5_tftipempledefins_sels, "TipEmpleDefIns IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipEmpleDescri" ;
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
                  return conditional_P01GS2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() );
            case 1 :
                  return conditional_P01GS3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GS2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01GS3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getString(3, 4);
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
                  stmt.setString(sIdx, (String)parms[2], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 4);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
      }
   }

}

