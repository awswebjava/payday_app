package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cliente_updatewwgetfilterdata extends GXProcedure
{
   public cliente_updatewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cliente_updatewwgetfilterdata.class ), "" );
   }

   public cliente_updatewwgetfilterdata( int remoteHandle ,
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
      cliente_updatewwgetfilterdata.this.aP5 = new String[] {""};
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
      cliente_updatewwgetfilterdata.this.AV28DDOName = aP0;
      cliente_updatewwgetfilterdata.this.AV29SearchTxt = aP1;
      cliente_updatewwgetfilterdata.this.AV30SearchTxtTo = aP2;
      cliente_updatewwgetfilterdata.this.aP3 = aP3;
      cliente_updatewwgetfilterdata.this.aP4 = aP4;
      cliente_updatewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV39Ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      GXt_int1 = AV35EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      cliente_updatewwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      cliente_updatewwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente_Update", GXv_boolean6) ;
      cliente_updatewwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_CLIUPDRELDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADCLIUPDRELDESCOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV18Options.toJSonString(false) ;
      AV32OptionsDescJson = AV20OptionsDesc.toJSonString(false) ;
      AV33OptionIndexesJson = AV21OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue("Cliente_UpdateWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Cliente_UpdateWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("Cliente_UpdateWWGridState"), null, null);
      }
      AV43GXV1 = 1 ;
      while ( AV43GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV43GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CLIUPDFECREL") == 0 )
         {
            AV38CliUpdFecRel = localUtil.ctot( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CLIUPDRELHAB") == 0 )
         {
            AV40CliUpdRelHab = GXutil.boolval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIUPDRELDESC") == 0 )
         {
            AV12TFCliUpdRelDesc = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIUPDRELDESC_SEL") == 0 )
         {
            AV11TFCliUpdRelDesc_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFCliUpdRelDesc_Sels.fromJSonString(AV11TFCliUpdRelDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLIUPDDTAPL") == 0 )
         {
            AV14TFCliUpdDTApl = localUtil.ctot( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV15TFCliUpdDTApl_To = localUtil.ctot( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV37MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV43GXV1 = (int)(AV43GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCLIUPDRELDESCOPTIONS' Routine */
      returnInSub = false ;
      AV12TFCliUpdRelDesc = AV29SearchTxt ;
      AV13TFCliUpdRelDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Cliente_updatewwds_1_cliupdfecrel = AV38CliUpdFecRel ;
      AV46Cliente_updatewwds_2_cliupdrelhab = AV40CliUpdRelHab ;
      AV47Cliente_updatewwds_3_tfcliupdreldesc = AV12TFCliUpdRelDesc ;
      AV48Cliente_updatewwds_4_tfcliupdreldesc_sels = AV13TFCliUpdRelDesc_Sels ;
      AV49Cliente_updatewwds_5_tfcliupddtapl = AV14TFCliUpdDTApl ;
      AV50Cliente_updatewwds_6_tfcliupddtapl_to = AV15TFCliUpdDTApl_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1884CliUpdRelDesc ,
                                           AV48Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                           Integer.valueOf(AV48Cliente_updatewwds_4_tfcliupdreldesc_sels.size()) ,
                                           AV47Cliente_updatewwds_3_tfcliupdreldesc ,
                                           AV49Cliente_updatewwds_5_tfcliupddtapl ,
                                           AV50Cliente_updatewwds_6_tfcliupddtapl_to ,
                                           A1883CliUpdDTApl ,
                                           AV39Ahora ,
                                           A1962CliUpdFecRel ,
                                           Boolean.valueOf(A1964CliUpdRelHab) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV36CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV47Cliente_updatewwds_3_tfcliupdreldesc = GXutil.concat( GXutil.rtrim( AV47Cliente_updatewwds_3_tfcliupdreldesc), "%", "") ;
      /* Using cursor P01RY2 */
      pr_default.execute(0, new Object[] {AV39Ahora, Integer.valueOf(AV36CliCod), lV47Cliente_updatewwds_3_tfcliupdreldesc, AV49Cliente_updatewwds_5_tfcliupddtapl, AV50Cliente_updatewwds_6_tfcliupddtapl_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1RY2 = false ;
         A1881CliUpdCliCod = P01RY2_A1881CliUpdCliCod[0] ;
         A1887CliUpdRelSec = P01RY2_A1887CliUpdRelSec[0] ;
         A1964CliUpdRelHab = P01RY2_A1964CliUpdRelHab[0] ;
         A3CliCod = P01RY2_A3CliCod[0] ;
         A1884CliUpdRelDesc = P01RY2_A1884CliUpdRelDesc[0] ;
         A1883CliUpdDTApl = P01RY2_A1883CliUpdDTApl[0] ;
         A1962CliUpdFecRel = P01RY2_A1962CliUpdFecRel[0] ;
         A1964CliUpdRelHab = P01RY2_A1964CliUpdRelHab[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01RY2_A1884CliUpdRelDesc[0], A1884CliUpdRelDesc) == 0 ) )
         {
            brk1RY2 = false ;
            A1881CliUpdCliCod = P01RY2_A1881CliUpdCliCod[0] ;
            A1887CliUpdRelSec = P01RY2_A1887CliUpdRelSec[0] ;
            A3CliCod = P01RY2_A3CliCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1RY2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1884CliUpdRelDesc)==0) )
         {
            AV17Option = A1884CliUpdRelDesc ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1RY2 )
         {
            brk1RY2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = cliente_updatewwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = cliente_updatewwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = cliente_updatewwgetfilterdata.this.AV33OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV33OptionIndexesJson = "" ;
      AV39Ahora = GXutil.resetTime( GXutil.nullDate() );
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV38CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      AV12TFCliUpdRelDesc = "" ;
      AV11TFCliUpdRelDesc_SelsJson = "" ;
      AV13TFCliUpdRelDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFCliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      AV15TFCliUpdDTApl_To = GXutil.resetTime( GXutil.nullDate() );
      AV37MenuOpcCod = "" ;
      A1884CliUpdRelDesc = "" ;
      AV45Cliente_updatewwds_1_cliupdfecrel = GXutil.resetTime( GXutil.nullDate() );
      AV47Cliente_updatewwds_3_tfcliupdreldesc = "" ;
      AV48Cliente_updatewwds_4_tfcliupdreldesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49Cliente_updatewwds_5_tfcliupddtapl = GXutil.resetTime( GXutil.nullDate() );
      AV50Cliente_updatewwds_6_tfcliupddtapl_to = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      lV47Cliente_updatewwds_3_tfcliupdreldesc = "" ;
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      P01RY2_A1881CliUpdCliCod = new int[1] ;
      P01RY2_A1887CliUpdRelSec = new int[1] ;
      P01RY2_A1964CliUpdRelHab = new boolean[] {false} ;
      P01RY2_A3CliCod = new int[1] ;
      P01RY2_A1884CliUpdRelDesc = new String[] {""} ;
      P01RY2_A1883CliUpdDTApl = new java.util.Date[] {GXutil.nullDate()} ;
      P01RY2_A1962CliUpdFecRel = new java.util.Date[] {GXutil.nullDate()} ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cliente_updatewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01RY2_A1881CliUpdCliCod, P01RY2_A1887CliUpdRelSec, P01RY2_A1964CliUpdRelHab, P01RY2_A3CliCod, P01RY2_A1884CliUpdRelDesc, P01RY2_A1883CliUpdDTApl, P01RY2_A1962CliUpdFecRel
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV43GXV1 ;
   private int AV48Cliente_updatewwds_4_tfcliupdreldesc_sels_size ;
   private int A3CliCod ;
   private int A1881CliUpdCliCod ;
   private int A1887CliUpdRelSec ;
   private long AV22count ;
   private String scmdbuf ;
   private java.util.Date AV39Ahora ;
   private java.util.Date AV38CliUpdFecRel ;
   private java.util.Date AV14TFCliUpdDTApl ;
   private java.util.Date AV15TFCliUpdDTApl_To ;
   private java.util.Date AV45Cliente_updatewwds_1_cliupdfecrel ;
   private java.util.Date AV49Cliente_updatewwds_5_tfcliupddtapl ;
   private java.util.Date AV50Cliente_updatewwds_6_tfcliupddtapl_to ;
   private java.util.Date A1883CliUpdDTApl ;
   private java.util.Date A1962CliUpdFecRel ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean AV40CliUpdRelHab ;
   private boolean AV46Cliente_updatewwds_2_cliupdrelhab ;
   private boolean A1964CliUpdRelHab ;
   private boolean brk1RY2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV11TFCliUpdRelDesc_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV12TFCliUpdRelDesc ;
   private String AV37MenuOpcCod ;
   private String A1884CliUpdRelDesc ;
   private String AV47Cliente_updatewwds_3_tfcliupdreldesc ;
   private String lV47Cliente_updatewwds_3_tfcliupdreldesc ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01RY2_A1881CliUpdCliCod ;
   private int[] P01RY2_A1887CliUpdRelSec ;
   private boolean[] P01RY2_A1964CliUpdRelHab ;
   private int[] P01RY2_A3CliCod ;
   private String[] P01RY2_A1884CliUpdRelDesc ;
   private java.util.Date[] P01RY2_A1883CliUpdDTApl ;
   private java.util.Date[] P01RY2_A1962CliUpdFecRel ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV13TFCliUpdRelDesc_Sels ;
   private GXSimpleCollection<String> AV48Cliente_updatewwds_4_tfcliupdreldesc_sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
}

final  class cliente_updatewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RY2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1884CliUpdRelDesc ,
                                          GXSimpleCollection<String> AV48Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                          int AV48Cliente_updatewwds_4_tfcliupdreldesc_sels_size ,
                                          String AV47Cliente_updatewwds_3_tfcliupdreldesc ,
                                          java.util.Date AV49Cliente_updatewwds_5_tfcliupddtapl ,
                                          java.util.Date AV50Cliente_updatewwds_6_tfcliupddtapl_to ,
                                          java.util.Date A1883CliUpdDTApl ,
                                          java.util.Date AV39Ahora ,
                                          java.util.Date A1962CliUpdFecRel ,
                                          boolean A1964CliUpdRelHab ,
                                          int A3CliCod ,
                                          int AV36CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.CliUpdCliCod AS CliUpdCliCod, T1.CliUpdRelSec AS CliUpdRelSec, T2.CliReHabilitado AS CliUpdRelHab, T1.CliCod, T1.CliUpdRelDesc, T1.CliUpdDTApl, T1.CliUpdFecRel" ;
      scmdbuf += " AS CliUpdFecRel FROM (Cliente_Update T1 INNER JOIN Cliente_Release T2 ON T2.CliCod = T1.CliUpdCliCod AND T2.CliRelSec = T1.CliUpdRelSec)" ;
      addWhere(sWhereString, "(? >= T1.CliUpdFecRel)");
      addWhere(sWhereString, "(T2.CliReHabilitado = TRUE)");
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV48Cliente_updatewwds_4_tfcliupdreldesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Cliente_updatewwds_3_tfcliupdreldesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.CliUpdRelDesc) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV48Cliente_updatewwds_4_tfcliupdreldesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Cliente_updatewwds_4_tfcliupdreldesc_sels, "T1.CliUpdRelDesc IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV49Cliente_updatewwds_5_tfcliupddtapl) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV50Cliente_updatewwds_6_tfcliupddtapl_to) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliUpdRelDesc" ;
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
                  return conditional_P01RY2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , (java.util.Date)dynConstraints[8] , ((Boolean) dynConstraints[9]).booleanValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RY2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDateTime(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(7);
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
                  stmt.setDateTime(sIdx, (java.util.Date)parms[5], false, true);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[8], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false);
               }
               return;
      }
   }

}

