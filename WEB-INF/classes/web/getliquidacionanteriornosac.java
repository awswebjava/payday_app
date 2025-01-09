package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliquidacionanteriornosac extends GXProcedure
{
   public getliquidacionanteriornosac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliquidacionanteriornosac.class ), "" );
   }

   public getliquidacionanteriornosac( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 ,
                          int aP3 ,
                          boolean aP4 ,
                          java.util.Date aP5 )
   {
      getliquidacionanteriornosac.this.aP6 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        boolean aP4 ,
                        java.util.Date aP5 ,
                        int[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             boolean aP4 ,
                             java.util.Date aP5 ,
                             int[] aP6 )
   {
      getliquidacionanteriornosac.this.AV8CliCod = aP0;
      getliquidacionanteriornosac.this.AV9EmpCod = aP1;
      getliquidacionanteriornosac.this.AV10LegNumero = aP2;
      getliquidacionanteriornosac.this.AV11LiqNro = aP3;
      getliquidacionanteriornosac.this.AV15mesAnterior = aP4;
      getliquidacionanteriornosac.this.AV14LiqPeriodo = aP5;
      getliquidacionanteriornosac.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV11LiqNro, 8, 0))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV14LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " mesanterior ", "")+GXutil.trim( GXutil.booltostr( AV15mesAnterior))) ;
      AV21anteriorLiqPeriodo = GXutil.addmth( AV14LiqPeriodo, (short)(-1)) ;
      GXt_char1 = AV16anticipoTLiqCod ;
      GXt_char2 = AV16anticipoTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqanticipo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getliquidacionanteriornosac.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      getliquidacionanteriornosac.this.GXt_char1 = GXv_char4[0] ;
      AV16anticipoTLiqCod = GXt_char1 ;
      AV18i = (short)(1) ;
      while ( AV18i <= 2 )
      {
         AV25GXLvl24 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Boolean.valueOf(AV15mesAnterior) ,
                                              A283LiqPeriodo ,
                                              AV14LiqPeriodo ,
                                              AV21anteriorLiqPeriodo ,
                                              A32TLiqCod ,
                                              AV16anticipoTLiqCod ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV9EmpCod) ,
                                              Integer.valueOf(AV10LegNumero) ,
                                              Integer.valueOf(AV11LiqNro) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         /* Using cursor P014X2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Integer.valueOf(AV11LiqNro), AV21anteriorLiqPeriodo, AV16anticipoTLiqCod, AV14LiqPeriodo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A283LiqPeriodo = P014X2_A283LiqPeriodo[0] ;
            A31LiqNro = P014X2_A31LiqNro[0] ;
            A32TLiqCod = P014X2_A32TLiqCod[0] ;
            n32TLiqCod = P014X2_n32TLiqCod[0] ;
            A6LegNumero = P014X2_A6LegNumero[0] ;
            A1EmpCod = P014X2_A1EmpCod[0] ;
            A3CliCod = P014X2_A3CliCod[0] ;
            AV25GXLvl24 = (byte)(1) ;
            AV13antLiqNro = A31LiqNro ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, "2") ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV25GXLvl24 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "none", "")) ;
         }
         if ( ! (0==AV13antLiqNro) )
         {
            if (true) break;
         }
         GXt_char2 = AV16anticipoTLiqCod ;
         GXt_char1 = AV16anticipoTLiqCod ;
         GXv_char4[0] = GXt_char1 ;
         new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         getliquidacionanteriornosac.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
         getliquidacionanteriornosac.this.GXt_char2 = GXv_char3[0] ;
         AV16anticipoTLiqCod = GXt_char2 ;
         AV18i = (short)(AV18i+1) ;
      }
      if ( (0==AV13antLiqNro) )
      {
         GXt_char2 = AV17TLiqCod ;
         GXv_char4[0] = GXt_char2 ;
         new web.gettipoliq(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LiqNro, GXv_char4) ;
         getliquidacionanteriornosac.this.GXt_char2 = GXv_char4[0] ;
         AV17TLiqCod = GXt_char2 ;
         AV26GXLvl50 = (byte)(0) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              Boolean.valueOf(AV15mesAnterior) ,
                                              A283LiqPeriodo ,
                                              AV14LiqPeriodo ,
                                              AV21anteriorLiqPeriodo ,
                                              A32TLiqCod ,
                                              AV17TLiqCod ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV9EmpCod) ,
                                              Integer.valueOf(AV10LegNumero) ,
                                              Integer.valueOf(AV11LiqNro) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         /* Using cursor P014X3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), Integer.valueOf(AV11LiqNro), AV21anteriorLiqPeriodo, AV17TLiqCod, AV14LiqPeriodo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A283LiqPeriodo = P014X3_A283LiqPeriodo[0] ;
            A31LiqNro = P014X3_A31LiqNro[0] ;
            A32TLiqCod = P014X3_A32TLiqCod[0] ;
            n32TLiqCod = P014X3_n32TLiqCod[0] ;
            A6LegNumero = P014X3_A6LegNumero[0] ;
            A1EmpCod = P014X3_A1EmpCod[0] ;
            A3CliCod = P014X3_A3CliCod[0] ;
            AV26GXLvl50 = (byte)(1) ;
            AV13antLiqNro = A31LiqNro ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "2b", "")) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV26GXLvl50 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "noneb", "")) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getliquidacionanteriornosac.this.AV13antLiqNro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24Pgmname = "" ;
      AV21anteriorLiqPeriodo = GXutil.nullDate() ;
      AV16anticipoTLiqCod = "" ;
      scmdbuf = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      P014X2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P014X2_A31LiqNro = new int[1] ;
      P014X2_A32TLiqCod = new String[] {""} ;
      P014X2_n32TLiqCod = new boolean[] {false} ;
      P014X2_A6LegNumero = new int[1] ;
      P014X2_A1EmpCod = new short[1] ;
      P014X2_A3CliCod = new int[1] ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV17TLiqCod = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      P014X3_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P014X3_A31LiqNro = new int[1] ;
      P014X3_A32TLiqCod = new String[] {""} ;
      P014X3_n32TLiqCod = new boolean[] {false} ;
      P014X3_A6LegNumero = new int[1] ;
      P014X3_A1EmpCod = new short[1] ;
      P014X3_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliquidacionanteriornosac__default(),
         new Object[] {
             new Object[] {
            P014X2_A283LiqPeriodo, P014X2_A31LiqNro, P014X2_A32TLiqCod, P014X2_n32TLiqCod, P014X2_A6LegNumero, P014X2_A1EmpCod, P014X2_A3CliCod
            }
            , new Object[] {
            P014X3_A283LiqPeriodo, P014X3_A31LiqNro, P014X3_A32TLiqCod, P014X3_n32TLiqCod, P014X3_A6LegNumero, P014X3_A1EmpCod, P014X3_A3CliCod
            }
         }
      );
      AV24Pgmname = "getLiquidacionAnteriorNoSac" ;
      /* GeneXus formulas. */
      AV24Pgmname = "getLiquidacionAnteriorNoSac" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl24 ;
   private byte AV26GXLvl50 ;
   private short AV9EmpCod ;
   private short AV18i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int AV11LiqNro ;
   private int AV13antLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private String AV24Pgmname ;
   private String AV16anticipoTLiqCod ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV17TLiqCod ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private java.util.Date AV14LiqPeriodo ;
   private java.util.Date AV21anteriorLiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV15mesAnterior ;
   private boolean n32TLiqCod ;
   private int[] aP6 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P014X2_A283LiqPeriodo ;
   private int[] P014X2_A31LiqNro ;
   private String[] P014X2_A32TLiqCod ;
   private boolean[] P014X2_n32TLiqCod ;
   private int[] P014X2_A6LegNumero ;
   private short[] P014X2_A1EmpCod ;
   private int[] P014X2_A3CliCod ;
   private java.util.Date[] P014X3_A283LiqPeriodo ;
   private int[] P014X3_A31LiqNro ;
   private String[] P014X3_A32TLiqCod ;
   private boolean[] P014X3_n32TLiqCod ;
   private int[] P014X3_A6LegNumero ;
   private short[] P014X3_A1EmpCod ;
   private int[] P014X3_A3CliCod ;
}

final  class getliquidacionanteriornosac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P014X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV15mesAnterior ,
                                          java.util.Date A283LiqPeriodo ,
                                          java.util.Date AV14LiqPeriodo ,
                                          java.util.Date AV21anteriorLiqPeriodo ,
                                          String A32TLiqCod ,
                                          String AV16anticipoTLiqCod ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int AV11LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[7];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT LiqPeriodo, LiqNro, TLiqCod, LegNumero, EmpCod, CliCod FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ? and LiqNro < ?)");
      addWhere(sWhereString, "(LiqPeriodo >= ?)");
      addWhere(sWhereString, "(TLiqCod = ( ?))");
      if ( AV15mesAnterior )
      {
         addWhere(sWhereString, "(LiqPeriodo < ?)");
      }
      else
      {
         GXv_int5[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LiqNro DESC" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   protected Object[] conditional_P014X3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV15mesAnterior ,
                                          java.util.Date A283LiqPeriodo ,
                                          java.util.Date AV14LiqPeriodo ,
                                          java.util.Date AV21anteriorLiqPeriodo ,
                                          String A32TLiqCod ,
                                          String AV17TLiqCod ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int AV11LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[7];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT LiqPeriodo, LiqNro, TLiqCod, LegNumero, EmpCod, CliCod FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ? and LiqNro < ?)");
      addWhere(sWhereString, "(LiqPeriodo >= ?)");
      addWhere(sWhereString, "(TLiqCod = ( ?))");
      if ( AV15mesAnterior )
      {
         addWhere(sWhereString, "(LiqPeriodo < ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LiqNro DESC" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P014X2(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() );
            case 1 :
                  return conditional_P014X3(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , (java.util.Date)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014X2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P014X3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               return;
            case 1 :
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               return;
      }
   }

}

