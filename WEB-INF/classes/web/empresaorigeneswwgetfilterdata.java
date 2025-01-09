package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresaorigeneswwgetfilterdata extends GXProcedure
{
   public empresaorigeneswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresaorigeneswwgetfilterdata.class ), "" );
   }

   public empresaorigeneswwgetfilterdata( int remoteHandle ,
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
      empresaorigeneswwgetfilterdata.this.aP5 = new String[] {""};
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
      empresaorigeneswwgetfilterdata.this.AV26DDOName = aP0;
      empresaorigeneswwgetfilterdata.this.AV27SearchTxt = aP1;
      empresaorigeneswwgetfilterdata.this.AV28SearchTxtTo = aP2;
      empresaorigeneswwgetfilterdata.this.aP3 = aP3;
      empresaorigeneswwgetfilterdata.this.aP4 = aP4;
      empresaorigeneswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV33EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      empresaorigeneswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV33EmpCod = GXt_int1 ;
      GXt_int3 = AV34CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      empresaorigeneswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV34CliCod = GXt_int3 ;
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaOrigenes", GXv_boolean6) ;
      empresaorigeneswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV26DDOName), "DDO_EMPORIGEN") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPORIGENOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV29OptionsJson = AV16Options.toJSonString(false) ;
      AV30OptionsDescJson = AV18OptionsDesc.toJSonString(false) ;
      AV31OptionIndexesJson = AV19OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV21Session.getValue("EmpresaOrigenesWWGridState"), "") == 0 )
      {
         AV23GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EmpresaOrigenesWWGridState"), null, null);
      }
      else
      {
         AV23GridState.fromxml(AV21Session.getValue("EmpresaOrigenesWWGridState"), null, null);
      }
      AV38GXV1 = 1 ;
      while ( AV38GXV1 <= AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV24GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV23GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV38GXV1));
         if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPORIGEN") == 0 )
         {
            AV12TFEmpOrigen = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPORIGEN_SEL") == 0 )
         {
            AV11TFEmpOrigen_SelsJson = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFEmpOrigen_Sels.fromJSonString(AV11TFEmpOrigen_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV35MenuOpcCod = AV24GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV38GXV1 = (int)(AV38GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEMPORIGENOPTIONS' Routine */
      returnInSub = false ;
      AV12TFEmpOrigen = AV27SearchTxt ;
      AV13TFEmpOrigen_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV40Empresaorigeneswwds_1_tfemporigen = AV12TFEmpOrigen ;
      AV41Empresaorigeneswwds_2_tfemporigen_sels = AV13TFEmpOrigen_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1238EmpOrigen ,
                                           AV41Empresaorigeneswwds_2_tfemporigen_sels ,
                                           Integer.valueOf(AV41Empresaorigeneswwds_2_tfemporigen_sels.size()) ,
                                           AV40Empresaorigeneswwds_1_tfemporigen ,
                                           A1284OrigNombre ,
                                           Integer.valueOf(AV34CliCod) ,
                                           Short.valueOf(AV33EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV40Empresaorigeneswwds_1_tfemporigen = GXutil.concat( GXutil.rtrim( AV40Empresaorigeneswwds_1_tfemporigen), "%", "") ;
      /* Using cursor P01S32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV34CliCod), Short.valueOf(AV33EmpCod), lV40Empresaorigeneswwds_1_tfemporigen});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1S32 = false ;
         A1231OrigId = P01S32_A1231OrigId[0] ;
         A1EmpCod = P01S32_A1EmpCod[0] ;
         A3CliCod = P01S32_A3CliCod[0] ;
         A1238EmpOrigen = P01S32_A1238EmpOrigen[0] ;
         A1284OrigNombre = P01S32_A1284OrigNombre[0] ;
         A1284OrigNombre = P01S32_A1284OrigNombre[0] ;
         AV20count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01S32_A3CliCod[0] == A3CliCod ) && ( P01S32_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P01S32_A1238EmpOrigen[0], A1238EmpOrigen) == 0 ) )
         {
            brk1S32 = false ;
            AV20count = (long)(AV20count+1) ;
            brk1S32 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1284OrigNombre)==0) )
         {
            AV15Option = A1238EmpOrigen ;
            AV17OptionDesc = A1284OrigNombre ;
            AV14InsertIndex = 1 ;
            while ( ( AV14InsertIndex <= AV16Options.size() ) && ( GXutil.strcmp((String)AV18OptionsDesc.elementAt(-1+AV14InsertIndex), AV17OptionDesc) < 0 ) )
            {
               AV14InsertIndex = (int)(AV14InsertIndex+1) ;
            }
            AV16Options.add(AV15Option, AV14InsertIndex);
            AV18OptionsDesc.add(AV17OptionDesc, AV14InsertIndex);
            AV19OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV20count), "Z,ZZZ,ZZZ,ZZ9")), AV14InsertIndex);
         }
         if ( AV16Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1S32 )
         {
            brk1S32 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = empresaorigeneswwgetfilterdata.this.AV29OptionsJson;
      this.aP4[0] = empresaorigeneswwgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = empresaorigeneswwgetfilterdata.this.AV31OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV29OptionsJson = "" ;
      AV30OptionsDescJson = "" ;
      AV31OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV16Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV21Session = httpContext.getWebSession();
      AV23GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV24GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFEmpOrigen = "" ;
      AV11TFEmpOrigen_SelsJson = "" ;
      AV13TFEmpOrigen_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35MenuOpcCod = "" ;
      A1284OrigNombre = "" ;
      A1238EmpOrigen = "" ;
      AV40Empresaorigeneswwds_1_tfemporigen = "" ;
      AV41Empresaorigeneswwds_2_tfemporigen_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV40Empresaorigeneswwds_1_tfemporigen = "" ;
      P01S32_A1231OrigId = new String[] {""} ;
      P01S32_A1EmpCod = new short[1] ;
      P01S32_A3CliCod = new int[1] ;
      P01S32_A1238EmpOrigen = new String[] {""} ;
      P01S32_A1284OrigNombre = new String[] {""} ;
      A1231OrigId = "" ;
      AV15Option = "" ;
      AV17OptionDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresaorigeneswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01S32_A1231OrigId, P01S32_A1EmpCod, P01S32_A3CliCod, P01S32_A1238EmpOrigen, P01S32_A1284OrigNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV33EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV34CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV38GXV1 ;
   private int AV41Empresaorigeneswwds_2_tfemporigen_sels_size ;
   private int A3CliCod ;
   private int AV14InsertIndex ;
   private long AV20count ;
   private String A1238EmpOrigen ;
   private String scmdbuf ;
   private String A1231OrigId ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1S32 ;
   private String AV29OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV31OptionIndexesJson ;
   private String AV11TFEmpOrigen_SelsJson ;
   private String AV26DDOName ;
   private String AV27SearchTxt ;
   private String AV28SearchTxtTo ;
   private String AV12TFEmpOrigen ;
   private String AV35MenuOpcCod ;
   private String A1284OrigNombre ;
   private String AV40Empresaorigeneswwds_1_tfemporigen ;
   private String lV40Empresaorigeneswwds_1_tfemporigen ;
   private String AV15Option ;
   private String AV17OptionDesc ;
   private com.genexus.webpanels.WebSession AV21Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01S32_A1231OrigId ;
   private short[] P01S32_A1EmpCod ;
   private int[] P01S32_A3CliCod ;
   private String[] P01S32_A1238EmpOrigen ;
   private String[] P01S32_A1284OrigNombre ;
   private GXSimpleCollection<String> AV13TFEmpOrigen_Sels ;
   private GXSimpleCollection<String> AV41Empresaorigeneswwds_2_tfemporigen_sels ;
   private GXSimpleCollection<String> AV16Options ;
   private GXSimpleCollection<String> AV18OptionsDesc ;
   private GXSimpleCollection<String> AV19OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV23GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV24GridStateFilterValue ;
}

final  class empresaorigeneswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01S32( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1238EmpOrigen ,
                                          GXSimpleCollection<String> AV41Empresaorigeneswwds_2_tfemporigen_sels ,
                                          int AV41Empresaorigeneswwds_2_tfemporigen_sels_size ,
                                          String AV40Empresaorigeneswwds_1_tfemporigen ,
                                          String A1284OrigNombre ,
                                          int AV34CliCod ,
                                          short AV33EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T2.OrigId, T1.EmpCod, T1.CliCod, T1.EmpOrigen, T2.OrigNombre FROM (Empresanolaborables_origen T1 INNER JOIN Origen T2 ON T2.OrigId = T1.EmpOrigen)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV41Empresaorigeneswwds_2_tfemporigen_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV40Empresaorigeneswwds_1_tfemporigen)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.OrigNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV41Empresaorigeneswwds_2_tfemporigen_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV41Empresaorigeneswwds_2_tfemporigen_sels, "T1.EmpOrigen IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.EmpOrigen" ;
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
                  return conditional_P01S32(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01S32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               return;
      }
   }

}

