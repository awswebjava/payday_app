package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodoultnovedad extends GXProcedure
{
   public getperiodoultnovedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodoultnovedad.class ), "" );
   }

   public getperiodoultnovedad( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              short[] aP3 ,
                              short[] aP4 )
   {
      getperiodoultnovedad.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 ,
                        short[] aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 ,
                             short[] aP4 ,
                             boolean[] aP5 )
   {
      getperiodoultnovedad.this.AV10CliCod = aP0;
      getperiodoultnovedad.this.AV11EmpCod = aP1;
      getperiodoultnovedad.this.AV13LegNumero = aP2;
      getperiodoultnovedad.this.aP3 = aP3;
      getperiodoultnovedad.this.aP4 = aP4;
      getperiodoultnovedad.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (0==AV13LegNumero) )
      {
         GXt_char1 = AV12TLiqCod ;
         GXt_char2 = AV12TLiqCod ;
         GXv_char3[0] = GXt_char2 ;
         new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         getperiodoultnovedad.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
         getperiodoultnovedad.this.GXt_char1 = GXv_char4[0] ;
         AV12TLiqCod = GXt_char1 ;
         /* Execute user subroutine: 'ULTIMO LIQUIDADO' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV8Anio = AV16liqAnio ;
         AV9Mes = AV17liqMes ;
      }
      else
      {
         AV15auxLegNumero = AV13LegNumero ;
         /* Execute user subroutine: 'ULTIMO LIQUIDADO' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_int5[0] = AV19novAnio ;
         GXv_int6[0] = AV20novMes ;
         GXv_date7[0] = AV21novLiqPeriodo ;
         GXv_boolean8[0] = AV14hay ;
         GXv_char4[0] = "" ;
         new web.getultimanovedad(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV13LegNumero, false, GXv_int5, GXv_int6, GXv_date7, GXv_boolean8, GXv_char4) ;
         getperiodoultnovedad.this.AV19novAnio = GXv_int5[0] ;
         getperiodoultnovedad.this.AV20novMes = GXv_int6[0] ;
         getperiodoultnovedad.this.AV21novLiqPeriodo = GXv_date7[0] ;
         getperiodoultnovedad.this.AV14hay = GXv_boolean8[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&novLiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV21novLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV18LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         if ( GXutil.resetTime(AV21novLiqPeriodo).after( GXutil.resetTime( AV18LiqPeriodo )) )
         {
            AV8Anio = AV19novAnio ;
            AV9Mes = AV20novMes ;
         }
         else
         {
            AV8Anio = AV16liqAnio ;
            AV9Mes = AV17liqMes ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&TLiqCod: ", "")+GXutil.trim( AV12TLiqCod)) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV13LegNumero, 8, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&Anio: ", "")+GXutil.trim( GXutil.str( AV8Anio, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&Mes: ", "")+GXutil.trim( GXutil.str( AV9Mes, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&hay: ", "")+GXutil.trim( GXutil.booltostr( AV14hay))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&&novAnio: ", "")+GXutil.trim( GXutil.str( AV19novAnio, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&&novMes: ", "")+GXutil.trim( GXutil.str( AV20novMes, 2, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&&&liqAnio: ", "")+GXutil.trim( GXutil.str( AV16liqAnio, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "&&&liqMes: ", "")+GXutil.trim( GXutil.str( AV17liqMes, 2, 0))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'ULTIMO LIQUIDADO' Routine */
      returnInSub = false ;
      AV25GXLvl49 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV15auxLegNumero) ,
                                           AV12TLiqCod ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A32TLiqCod ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P021I2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV15auxLegNumero), AV12TLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P021I2_A32TLiqCod[0] ;
         n32TLiqCod = P021I2_n32TLiqCod[0] ;
         A6LegNumero = P021I2_A6LegNumero[0] ;
         A1EmpCod = P021I2_A1EmpCod[0] ;
         A3CliCod = P021I2_A3CliCod[0] ;
         A283LiqPeriodo = P021I2_A283LiqPeriodo[0] ;
         A31LiqNro = P021I2_A31LiqNro[0] ;
         AV25GXLvl49 = (byte)(1) ;
         AV16liqAnio = (short)(GXutil.year( A283LiqPeriodo)) ;
         AV17liqMes = (byte)(GXutil.month( A283LiqPeriodo)) ;
         AV18LiqPeriodo = A283LiqPeriodo ;
         AV14hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV25GXLvl49 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV24Pgmname, httpContext.getMessage( "none ultimo liq", "")) ;
      }
   }

   protected void cleanup( )
   {
      this.aP3[0] = getperiodoultnovedad.this.AV8Anio;
      this.aP4[0] = getperiodoultnovedad.this.AV9Mes;
      this.aP5[0] = getperiodoultnovedad.this.AV14hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12TLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_int5 = new short[1] ;
      GXv_int6 = new byte[1] ;
      AV21novLiqPeriodo = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      GXv_boolean8 = new boolean[1] ;
      GXv_char4 = new String[1] ;
      AV24Pgmname = "" ;
      AV18LiqPeriodo = GXutil.nullDate() ;
      A283LiqPeriodo = GXutil.nullDate() ;
      scmdbuf = "" ;
      A32TLiqCod = "" ;
      P021I2_A32TLiqCod = new String[] {""} ;
      P021I2_n32TLiqCod = new boolean[] {false} ;
      P021I2_A6LegNumero = new int[1] ;
      P021I2_A1EmpCod = new short[1] ;
      P021I2_A3CliCod = new int[1] ;
      P021I2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P021I2_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiodoultnovedad__default(),
         new Object[] {
             new Object[] {
            P021I2_A32TLiqCod, P021I2_n32TLiqCod, P021I2_A6LegNumero, P021I2_A1EmpCod, P021I2_A3CliCod, P021I2_A283LiqPeriodo, P021I2_A31LiqNro
            }
         }
      );
      AV24Pgmname = "getPeriodoUltNovedad" ;
      /* GeneXus formulas. */
      AV24Pgmname = "getPeriodoUltNovedad" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17liqMes ;
   private byte AV20novMes ;
   private byte GXv_int6[] ;
   private byte AV25GXLvl49 ;
   private short AV11EmpCod ;
   private short AV8Anio ;
   private short AV9Mes ;
   private short AV16liqAnio ;
   private short AV19novAnio ;
   private short GXv_int5[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV13LegNumero ;
   private int AV15auxLegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String AV12TLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV24Pgmname ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private java.util.Date AV21novLiqPeriodo ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date AV18LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV14hay ;
   private boolean returnInSub ;
   private boolean GXv_boolean8[] ;
   private boolean n32TLiqCod ;
   private boolean[] aP5 ;
   private short[] aP3 ;
   private short[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P021I2_A32TLiqCod ;
   private boolean[] P021I2_n32TLiqCod ;
   private int[] P021I2_A6LegNumero ;
   private short[] P021I2_A1EmpCod ;
   private int[] P021I2_A3CliCod ;
   private java.util.Date[] P021I2_A283LiqPeriodo ;
   private int[] P021I2_A31LiqNro ;
}

final  class getperiodoultnovedad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P021I2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV15auxLegNumero ,
                                          String AV12TLiqCod ,
                                          int A6LegNumero ,
                                          String A32TLiqCod ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[4];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT TLiqCod, LegNumero, EmpCod, CliCod, LiqPeriodo, LiqNro FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV15auxLegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int9[2] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV12TLiqCod)==0) )
      {
         addWhere(sWhereString, "(TLiqCod = ( ?))");
      }
      else
      {
         GXv_int9[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( (0==AV15auxLegNumero) )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, TLiqCod, LiqPeriodo DESC" ;
      }
      else if ( ! (0==AV15auxLegNumero) )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, TLiqCod, LiqPeriodo DESC" ;
      }
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
                  return conditional_P021I2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P021I2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
      }
   }

}

