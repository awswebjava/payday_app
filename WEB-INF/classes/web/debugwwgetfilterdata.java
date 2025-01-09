package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class debugwwgetfilterdata extends GXProcedure
{
   public debugwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( debugwwgetfilterdata.class ), "" );
   }

   public debugwwgetfilterdata( int remoteHandle ,
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
      debugwwgetfilterdata.this.aP5 = new String[] {""};
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
      debugwwgetfilterdata.this.AV27DDOName = aP0;
      debugwwgetfilterdata.this.AV28SearchTxt = aP1;
      debugwwgetfilterdata.this.AV29SearchTxtTo = aP2;
      debugwwgetfilterdata.this.aP3 = aP3;
      debugwwgetfilterdata.this.aP4 = aP4;
      debugwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV34EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      debugwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV34EmpCod = GXt_int1 ;
      GXt_int3 = AV33CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      debugwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV33CliCod = GXt_int3 ;
      AV17Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV19OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDebug", GXv_boolean6) ;
      debugwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV27DDOName), "DDO_DEBUGPGM") == 0 )
         {
            /* Execute user subroutine: 'LOADDEBUGPGMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV30OptionsJson = AV17Options.toJSonString(false) ;
      AV31OptionsDescJson = AV19OptionsDesc.toJSonString(false) ;
      AV32OptionIndexesJson = AV20OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV22Session.getValue("DebugWWGridState"), "") == 0 )
      {
         AV24GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DebugWWGridState"), null, null);
      }
      else
      {
         AV24GridState.fromxml(AV22Session.getValue("DebugWWGridState"), null, null);
      }
      AV37GXV1 = 1 ;
      while ( AV37GXV1 <= AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV25GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV24GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV37GXV1));
         if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDEBUGPGM") == 0 )
         {
            AV12TFDebugPgm = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDEBUGPGM_SEL") == 0 )
         {
            AV11TFDebugPgm_SelsJson = AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFDebugPgm_Sels.fromJSonString(AV11TFDebugPgm_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDEBUGACTIVO_SEL") == 0 )
         {
            AV14TFDebugActivo_Sel = (byte)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV33CliCod = (int)(GXutil.lval( AV25GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV37GXV1 = (int)(AV37GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADDEBUGPGMOPTIONS' Routine */
      returnInSub = false ;
      AV12TFDebugPgm = AV28SearchTxt ;
      AV13TFDebugPgm_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39Debugwwds_1_tfdebugpgm = AV12TFDebugPgm ;
      AV40Debugwwds_2_tfdebugpgm_sels = AV13TFDebugPgm_Sels ;
      AV41Debugwwds_3_tfdebugactivo_sel = AV14TFDebugActivo_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1754DebugPgm ,
                                           AV40Debugwwds_2_tfdebugpgm_sels ,
                                           Integer.valueOf(AV40Debugwwds_2_tfdebugpgm_sels.size()) ,
                                           AV39Debugwwds_1_tfdebugpgm ,
                                           Byte.valueOf(AV41Debugwwds_3_tfdebugactivo_sel) ,
                                           Boolean.valueOf(A1755DebugActivo) ,
                                           Integer.valueOf(AV33CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV39Debugwwds_1_tfdebugpgm = GXutil.concat( GXutil.rtrim( AV39Debugwwds_1_tfdebugpgm), "%", "") ;
      /* Using cursor P02CX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV33CliCod), lV39Debugwwds_1_tfdebugpgm});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2CX2 = false ;
         A3CliCod = P02CX2_A3CliCod[0] ;
         A1754DebugPgm = P02CX2_A1754DebugPgm[0] ;
         A1755DebugActivo = P02CX2_A1755DebugActivo[0] ;
         AV21count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P02CX2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P02CX2_A1754DebugPgm[0], A1754DebugPgm) == 0 ) )
         {
            brk2CX2 = false ;
            AV21count = (long)(AV21count+1) ;
            brk2CX2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1754DebugPgm)==0) )
         {
            AV16Option = A1754DebugPgm ;
            AV17Options.add(AV16Option, 0);
            AV20OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV21count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV17Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2CX2 )
         {
            brk2CX2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = debugwwgetfilterdata.this.AV30OptionsJson;
      this.aP4[0] = debugwwgetfilterdata.this.AV31OptionsDescJson;
      this.aP5[0] = debugwwgetfilterdata.this.AV32OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV30OptionsJson = "" ;
      AV31OptionsDescJson = "" ;
      AV32OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV17Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV22Session = httpContext.getWebSession();
      AV24GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV25GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFDebugPgm = "" ;
      AV11TFDebugPgm_SelsJson = "" ;
      AV13TFDebugPgm_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      A1754DebugPgm = "" ;
      AV39Debugwwds_1_tfdebugpgm = "" ;
      AV40Debugwwds_2_tfdebugpgm_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV39Debugwwds_1_tfdebugpgm = "" ;
      P02CX2_A3CliCod = new int[1] ;
      P02CX2_A1754DebugPgm = new String[] {""} ;
      P02CX2_A1755DebugActivo = new boolean[] {false} ;
      AV16Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.debugwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02CX2_A3CliCod, P02CX2_A1754DebugPgm, P02CX2_A1755DebugActivo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV14TFDebugActivo_Sel ;
   private byte AV41Debugwwds_3_tfdebugactivo_sel ;
   private short AV34EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV33CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV37GXV1 ;
   private int AV40Debugwwds_2_tfdebugpgm_sels_size ;
   private int A3CliCod ;
   private long AV21count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1755DebugActivo ;
   private boolean brk2CX2 ;
   private String AV30OptionsJson ;
   private String AV31OptionsDescJson ;
   private String AV32OptionIndexesJson ;
   private String AV11TFDebugPgm_SelsJson ;
   private String AV27DDOName ;
   private String AV28SearchTxt ;
   private String AV29SearchTxtTo ;
   private String AV12TFDebugPgm ;
   private String A1754DebugPgm ;
   private String AV39Debugwwds_1_tfdebugpgm ;
   private String lV39Debugwwds_1_tfdebugpgm ;
   private String AV16Option ;
   private com.genexus.webpanels.WebSession AV22Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02CX2_A3CliCod ;
   private String[] P02CX2_A1754DebugPgm ;
   private boolean[] P02CX2_A1755DebugActivo ;
   private GXSimpleCollection<String> AV17Options ;
   private GXSimpleCollection<String> AV19OptionsDesc ;
   private GXSimpleCollection<String> AV20OptionIndexes ;
   private GXSimpleCollection<String> AV13TFDebugPgm_Sels ;
   private GXSimpleCollection<String> AV40Debugwwds_2_tfdebugpgm_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV24GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV25GridStateFilterValue ;
}

final  class debugwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CX2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1754DebugPgm ,
                                          GXSimpleCollection<String> AV40Debugwwds_2_tfdebugpgm_sels ,
                                          int AV40Debugwwds_2_tfdebugpgm_sels_size ,
                                          String AV39Debugwwds_1_tfdebugpgm ,
                                          byte AV41Debugwwds_3_tfdebugactivo_sel ,
                                          boolean A1755DebugActivo ,
                                          int AV33CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, DebugPgm, DebugActivo FROM Debug" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV40Debugwwds_2_tfdebugpgm_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV39Debugwwds_1_tfdebugpgm)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DebugPgm) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV40Debugwwds_2_tfdebugpgm_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV40Debugwwds_2_tfdebugpgm_sels, "DebugPgm IN (", ")")+")");
      }
      if ( AV41Debugwwds_3_tfdebugactivo_sel == 1 )
      {
         addWhere(sWhereString, "(DebugActivo = TRUE)");
      }
      if ( AV41Debugwwds_3_tfdebugactivo_sel == 2 )
      {
         addWhere(sWhereString, "(DebugActivo = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, DebugPgm" ;
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
                  return conditional_P02CX2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , ((Boolean) dynConstraints[5]).booleanValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CX2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 100);
               }
               return;
      }
   }

}

