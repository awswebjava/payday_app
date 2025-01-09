package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class motivoegresorevistaafipwwgetfilterdata extends GXProcedure
{
   public motivoegresorevistaafipwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegresorevistaafipwwgetfilterdata.class ), "" );
   }

   public motivoegresorevistaafipwwgetfilterdata( int remoteHandle ,
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
      motivoegresorevistaafipwwgetfilterdata.this.aP5 = new String[] {""};
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
      motivoegresorevistaafipwwgetfilterdata.this.AV31DDOName = aP0;
      motivoegresorevistaafipwwgetfilterdata.this.AV32SearchTxt = aP1;
      motivoegresorevistaafipwwgetfilterdata.this.AV33SearchTxtTo = aP2;
      motivoegresorevistaafipwwgetfilterdata.this.aP3 = aP3;
      motivoegresorevistaafipwwgetfilterdata.this.aP4 = aP4;
      motivoegresorevistaafipwwgetfilterdata.this.aP5 = aP5;
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
      motivoegresorevistaafipwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV38EmpCod = GXt_int1 ;
      GXt_int3 = AV39CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      motivoegresorevistaafipwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV39CliCod = GXt_int3 ;
      AV21Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgresoRevistaAfip", GXv_boolean6) ;
      motivoegresorevistaafipwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_MEGCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADMEGCODIGOOPTIONS' */
            S121 ();
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
      if ( GXutil.strcmp(AV26Session.getValue("MotivoEgresoRevistaAfipWWGridState"), "") == 0 )
      {
         AV28GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MotivoEgresoRevistaAfipWWGridState"), null, null);
      }
      else
      {
         AV28GridState.fromxml(AV26Session.getValue("MotivoEgresoRevistaAfipWWGridState"), null, null);
      }
      AV43GXV1 = 1 ;
      while ( AV43GXV1 <= AV28GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV29GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV28GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV43GXV1));
         if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV11TFCliCod = (int)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCliCod_To = (int)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO") == 0 )
         {
            AV14TFMegCodigo = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO_SEL") == 0 )
         {
            AV13TFMegCodigo_SelsJson = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFMegCodigo_Sels.fromJSonString(AV13TFMegCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGSITREVISTA") == 0 )
         {
            AV16TFMegSitRevista = (short)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV17TFMegSitRevista_To = (short)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGSITREVDEF_SEL") == 0 )
         {
            AV18TFMegSitRevDef_Sel = (byte)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
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
      /* 'LOADMEGCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV14TFMegCodigo = AV32SearchTxt ;
      AV15TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV45Motivoegresorevistaafipwwds_1_tfclicod = AV11TFCliCod ;
      AV46Motivoegresorevistaafipwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV47Motivoegresorevistaafipwwds_3_tfmegcodigo = AV14TFMegCodigo ;
      AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels = AV15TFMegCodigo_Sels ;
      AV49Motivoegresorevistaafipwwds_5_tfmegsitrevista = AV16TFMegSitRevista ;
      AV50Motivoegresorevistaafipwwds_6_tfmegsitrevista_to = AV17TFMegSitRevista_To ;
      AV51Motivoegresorevistaafipwwds_7_tfmegsitrevdef_sel = AV18TFMegSitRevDef_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A11MegCodigo ,
                                           AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels ,
                                           Integer.valueOf(AV45Motivoegresorevistaafipwwds_1_tfclicod) ,
                                           Integer.valueOf(AV46Motivoegresorevistaafipwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels.size()) ,
                                           AV47Motivoegresorevistaafipwwds_3_tfmegcodigo ,
                                           Short.valueOf(AV49Motivoegresorevistaafipwwds_5_tfmegsitrevista) ,
                                           Short.valueOf(AV50Motivoegresorevistaafipwwds_6_tfmegsitrevista_to) ,
                                           Byte.valueOf(AV51Motivoegresorevistaafipwwds_7_tfmegsitrevdef_sel) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1601MegSitRevista) ,
                                           Boolean.valueOf(A1606MegSitRevDef) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.BOOLEAN
                                           }
      });
      lV47Motivoegresorevistaafipwwds_3_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV47Motivoegresorevistaafipwwds_3_tfmegcodigo), 20, "%") ;
      /* Using cursor P01JV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV45Motivoegresorevistaafipwwds_1_tfclicod), Integer.valueOf(AV46Motivoegresorevistaafipwwds_2_tfclicod_to), lV47Motivoegresorevistaafipwwds_3_tfmegcodigo, Short.valueOf(AV49Motivoegresorevistaafipwwds_5_tfmegsitrevista), Short.valueOf(AV50Motivoegresorevistaafipwwds_6_tfmegsitrevista_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1JV2 = false ;
         A11MegCodigo = P01JV2_A11MegCodigo[0] ;
         A1606MegSitRevDef = P01JV2_A1606MegSitRevDef[0] ;
         A1601MegSitRevista = P01JV2_A1601MegSitRevista[0] ;
         A3CliCod = P01JV2_A3CliCod[0] ;
         AV25count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01JV2_A11MegCodigo[0], A11MegCodigo) == 0 ) )
         {
            brk1JV2 = false ;
            A1601MegSitRevista = P01JV2_A1601MegSitRevista[0] ;
            A3CliCod = P01JV2_A3CliCod[0] ;
            AV25count = (long)(AV25count+1) ;
            brk1JV2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A11MegCodigo)==0) )
         {
            AV20Option = A11MegCodigo ;
            AV21Options.add(AV20Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV25count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JV2 )
         {
            brk1JV2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = motivoegresorevistaafipwwgetfilterdata.this.AV34OptionsJson;
      this.aP4[0] = motivoegresorevistaafipwwgetfilterdata.this.AV35OptionsDescJson;
      this.aP5[0] = motivoegresorevistaafipwwgetfilterdata.this.AV36OptionIndexesJson;
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
      AV14TFMegCodigo = "" ;
      AV13TFMegCodigo_SelsJson = "" ;
      AV15TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40MenuOpcCod = "" ;
      A11MegCodigo = "" ;
      AV47Motivoegresorevistaafipwwds_3_tfmegcodigo = "" ;
      AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV47Motivoegresorevistaafipwwds_3_tfmegcodigo = "" ;
      P01JV2_A11MegCodigo = new String[] {""} ;
      P01JV2_A1606MegSitRevDef = new boolean[] {false} ;
      P01JV2_A1601MegSitRevista = new short[1] ;
      P01JV2_A3CliCod = new int[1] ;
      AV20Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegresorevistaafipwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01JV2_A11MegCodigo, P01JV2_A1606MegSitRevDef, P01JV2_A1601MegSitRevista, P01JV2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18TFMegSitRevDef_Sel ;
   private byte AV51Motivoegresorevistaafipwwds_7_tfmegsitrevdef_sel ;
   private short AV38EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV16TFMegSitRevista ;
   private short AV17TFMegSitRevista_To ;
   private short AV49Motivoegresorevistaafipwwds_5_tfmegsitrevista ;
   private short AV50Motivoegresorevistaafipwwds_6_tfmegsitrevista_to ;
   private short A1601MegSitRevista ;
   private short Gx_err ;
   private int AV39CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV43GXV1 ;
   private int AV11TFCliCod ;
   private int AV12TFCliCod_To ;
   private int AV45Motivoegresorevistaafipwwds_1_tfclicod ;
   private int AV46Motivoegresorevistaafipwwds_2_tfclicod_to ;
   private int AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels_size ;
   private int A3CliCod ;
   private long AV25count ;
   private String AV14TFMegCodigo ;
   private String A11MegCodigo ;
   private String AV47Motivoegresorevistaafipwwds_3_tfmegcodigo ;
   private String scmdbuf ;
   private String lV47Motivoegresorevistaafipwwds_3_tfmegcodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1606MegSitRevDef ;
   private boolean brk1JV2 ;
   private String AV34OptionsJson ;
   private String AV35OptionsDescJson ;
   private String AV36OptionIndexesJson ;
   private String AV13TFMegCodigo_SelsJson ;
   private String AV31DDOName ;
   private String AV32SearchTxt ;
   private String AV33SearchTxtTo ;
   private String AV40MenuOpcCod ;
   private String AV20Option ;
   private com.genexus.webpanels.WebSession AV26Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01JV2_A11MegCodigo ;
   private boolean[] P01JV2_A1606MegSitRevDef ;
   private short[] P01JV2_A1601MegSitRevista ;
   private int[] P01JV2_A3CliCod ;
   private GXSimpleCollection<String> AV15TFMegCodigo_Sels ;
   private GXSimpleCollection<String> AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels ;
   private GXSimpleCollection<String> AV21Options ;
   private GXSimpleCollection<String> AV23OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV28GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV29GridStateFilterValue ;
}

final  class motivoegresorevistaafipwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels ,
                                          int AV45Motivoegresorevistaafipwwds_1_tfclicod ,
                                          int AV46Motivoegresorevistaafipwwds_2_tfclicod_to ,
                                          int AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels_size ,
                                          String AV47Motivoegresorevistaafipwwds_3_tfmegcodigo ,
                                          short AV49Motivoegresorevistaafipwwds_5_tfmegsitrevista ,
                                          short AV50Motivoegresorevistaafipwwds_6_tfmegsitrevista_to ,
                                          byte AV51Motivoegresorevistaafipwwds_7_tfmegsitrevdef_sel ,
                                          int A3CliCod ,
                                          short A1601MegSitRevista ,
                                          boolean A1606MegSitRevDef )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT MegCodigo, MegSitRevDef, MegSitRevista, CliCod FROM MotivoEgresoRevistaAfip" ;
      if ( ! (0==AV45Motivoegresorevistaafipwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV46Motivoegresorevistaafipwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Motivoegresorevistaafipwwds_3_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Motivoegresorevistaafipwwds_4_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( ! (0==AV49Motivoegresorevistaafipwwds_5_tfmegsitrevista) )
      {
         addWhere(sWhereString, "(MegSitRevista >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV50Motivoegresorevistaafipwwds_6_tfmegsitrevista_to) )
      {
         addWhere(sWhereString, "(MegSitRevista <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV51Motivoegresorevistaafipwwds_7_tfmegsitrevdef_sel == 1 )
      {
         addWhere(sWhereString, "(MegSitRevDef = TRUE)");
      }
      if ( AV51Motivoegresorevistaafipwwds_7_tfmegsitrevdef_sel == 2 )
      {
         addWhere(sWhereString, "(MegSitRevDef = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MegCodigo" ;
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
                  return conditional_P01JV2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JV2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               return;
      }
   }

}

