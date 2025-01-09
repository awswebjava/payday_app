package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodoultliqmensual extends GXProcedure
{
   public getperiodoultliqmensual( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodoultliqmensual.class ), "" );
   }

   public getperiodoultliqmensual( int remoteHandle ,
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
      getperiodoultliqmensual.this.aP5 = new boolean[] {false};
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
      getperiodoultliqmensual.this.AV10CliCod = aP0;
      getperiodoultliqmensual.this.AV11EmpCod = aP1;
      getperiodoultliqmensual.this.AV13LegNumero = aP2;
      getperiodoultliqmensual.this.aP3 = aP3;
      getperiodoultliqmensual.this.aP4 = aP4;
      getperiodoultliqmensual.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12TLiqCod ;
      GXt_char2 = AV12TLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      getperiodoultliqmensual.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      getperiodoultliqmensual.this.GXt_char1 = GXv_char4[0] ;
      AV12TLiqCod = GXt_char1 ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV13LegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A32TLiqCod ,
                                           AV12TLiqCod ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00TJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV12TLiqCod, Integer.valueOf(AV13LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A32TLiqCod = P00TJ2_A32TLiqCod[0] ;
         n32TLiqCod = P00TJ2_n32TLiqCod[0] ;
         A6LegNumero = P00TJ2_A6LegNumero[0] ;
         A1EmpCod = P00TJ2_A1EmpCod[0] ;
         A3CliCod = P00TJ2_A3CliCod[0] ;
         A283LiqPeriodo = P00TJ2_A283LiqPeriodo[0] ;
         A31LiqNro = P00TJ2_A31LiqNro[0] ;
         AV8Anio = (short)(GXutil.year( A283LiqPeriodo)) ;
         AV9Mes = (short)(GXutil.month( A283LiqPeriodo)) ;
         AV14hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&TLiqCod: ", "")+GXutil.trim( AV12TLiqCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV13LegNumero, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&Anio: ", "")+GXutil.trim( GXutil.str( AV8Anio, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&Mes: ", "")+GXutil.trim( GXutil.str( AV9Mes, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&hay: ", "")+GXutil.trim( GXutil.booltostr( AV14hay))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getperiodoultliqmensual.this.AV8Anio;
      this.aP4[0] = getperiodoultliqmensual.this.AV9Mes;
      this.aP5[0] = getperiodoultliqmensual.this.AV14hay;
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
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      A32TLiqCod = "" ;
      P00TJ2_A32TLiqCod = new String[] {""} ;
      P00TJ2_n32TLiqCod = new boolean[] {false} ;
      P00TJ2_A6LegNumero = new int[1] ;
      P00TJ2_A1EmpCod = new short[1] ;
      P00TJ2_A3CliCod = new int[1] ;
      P00TJ2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00TJ2_A31LiqNro = new int[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      AV19Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiodoultliqmensual__default(),
         new Object[] {
             new Object[] {
            P00TJ2_A32TLiqCod, P00TJ2_n32TLiqCod, P00TJ2_A6LegNumero, P00TJ2_A1EmpCod, P00TJ2_A3CliCod, P00TJ2_A283LiqPeriodo, P00TJ2_A31LiqNro
            }
         }
      );
      AV19Pgmname = "getPeriodoUltLiqMensual" ;
      /* GeneXus formulas. */
      AV19Pgmname = "getPeriodoUltLiqMensual" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV8Anio ;
   private short AV9Mes ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV13LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String AV12TLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV19Pgmname ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV14hay ;
   private boolean n32TLiqCod ;
   private boolean[] aP5 ;
   private short[] aP3 ;
   private short[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00TJ2_A32TLiqCod ;
   private boolean[] P00TJ2_n32TLiqCod ;
   private int[] P00TJ2_A6LegNumero ;
   private short[] P00TJ2_A1EmpCod ;
   private int[] P00TJ2_A3CliCod ;
   private java.util.Date[] P00TJ2_A283LiqPeriodo ;
   private int[] P00TJ2_A31LiqNro ;
}

final  class getperiodoultliqmensual__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00TJ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV13LegNumero ,
                                          int A6LegNumero ,
                                          String A32TLiqCod ,
                                          String AV12TLiqCod ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[4];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT TLiqCod, LegNumero, EmpCod, CliCod, LiqPeriodo, LiqNro FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(TLiqCod = ( ?))");
      if ( ! (0==AV13LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int5[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( (0==AV13LegNumero) )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, TLiqCod, LiqPeriodo DESC" ;
      }
      else if ( ! (0==AV13LegNumero) )
      {
         scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, TLiqCod, LiqPeriodo DESC" ;
      }
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P00TJ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00TJ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
      }
   }

}

