package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajosueldoultimo extends GXProcedure
{
   public getlegajosueldoultimo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajosueldoultimo.class ), "" );
   }

   public getlegajosueldoultimo( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              java.math.BigDecimal[] aP5 ,
                              String[] aP6 ,
                              short[] aP7 )
   {
      getlegajosueldoultimo.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 ,
                        short[] aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             short[] aP7 ,
                             boolean[] aP8 )
   {
      getlegajosueldoultimo.this.AV8CliCod = aP0;
      getlegajosueldoultimo.this.AV9EmpCod = aP1;
      getlegajosueldoultimo.this.AV15LiqNro = aP2;
      getlegajosueldoultimo.this.AV10LegNumero = aP3;
      getlegajosueldoultimo.this.AV12LegSuelFecha = aP4;
      getlegajosueldoultimo.this.aP5 = aP5;
      getlegajosueldoultimo.this.aP6 = aP6;
      getlegajosueldoultimo.this.aP7 = aP7;
      getlegajosueldoultimo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&&LiqNro: ", "")+GXutil.trim( GXutil.str( AV15LiqNro, 8, 0))) ;
      AV14existe = false ;
      if ( (0==AV15LiqNro) )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12LegSuelFecha ,
                                              A1136LegSuelFecha ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV9EmpCod) ,
                                              Integer.valueOf(AV10LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         /* Using cursor P018I2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV12LegSuelFecha});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1136LegSuelFecha = P018I2_A1136LegSuelFecha[0] ;
            A6LegNumero = P018I2_A6LegNumero[0] ;
            A1EmpCod = P018I2_A1EmpCod[0] ;
            A3CliCod = P018I2_A3CliCod[0] ;
            A1135LegSuelSec = P018I2_A1135LegSuelSec[0] ;
            A2344LegSuelTipo = P018I2_A2344LegSuelTipo[0] ;
            n2344LegSuelTipo = P018I2_n2344LegSuelTipo[0] ;
            A1137LegSuelImporte = P018I2_A1137LegSuelImporte[0] ;
            A2347LegSuelCalc = P018I2_A2347LegSuelCalc[0] ;
            AV11LegSuelSec = A1135LegSuelSec ;
            if ( GXutil.strcmp(A2344LegSuelTipo, "Bruto") == 0 )
            {
               AV13LegSuelImporte = A1137LegSuelImporte ;
            }
            else
            {
               AV13LegSuelImporte = A2347LegSuelCalc ;
            }
            AV16LegSuelTipo = A2344LegSuelTipo ;
            AV14existe = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P018I3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV15LiqNro), Integer.valueOf(AV10LegNumero)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A6LegNumero = P018I3_A6LegNumero[0] ;
            A31LiqNro = P018I3_A31LiqNro[0] ;
            A1EmpCod = P018I3_A1EmpCod[0] ;
            A3CliCod = P018I3_A3CliCod[0] ;
            A2114LiqLegSueldo = P018I3_A2114LiqLegSueldo[0] ;
            AV13LegSuelImporte = A2114LiqLegSueldo ;
            AV14existe = true ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&LegSuelFecha: ", "")+GXutil.trim( localUtil.dtoc( AV12LegSuelFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&LegSuelImporte: ", "")+GXutil.trim( GXutil.str( AV13LegSuelImporte, 14, 2))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV19Pgmname, httpContext.getMessage( "&existe: ", "")+GXutil.trim( GXutil.booltostr( AV14existe))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = getlegajosueldoultimo.this.AV13LegSuelImporte;
      this.aP6[0] = getlegajosueldoultimo.this.AV16LegSuelTipo;
      this.aP7[0] = getlegajosueldoultimo.this.AV11LegSuelSec;
      this.aP8[0] = getlegajosueldoultimo.this.AV14existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LegSuelImporte = DecimalUtil.ZERO ;
      AV16LegSuelTipo = "" ;
      AV19Pgmname = "" ;
      scmdbuf = "" ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      P018I2_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P018I2_A6LegNumero = new int[1] ;
      P018I2_A1EmpCod = new short[1] ;
      P018I2_A3CliCod = new int[1] ;
      P018I2_A1135LegSuelSec = new short[1] ;
      P018I2_A2344LegSuelTipo = new String[] {""} ;
      P018I2_n2344LegSuelTipo = new boolean[] {false} ;
      P018I2_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P018I2_A2347LegSuelCalc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A2344LegSuelTipo = "" ;
      A1137LegSuelImporte = DecimalUtil.ZERO ;
      A2347LegSuelCalc = DecimalUtil.ZERO ;
      P018I3_A6LegNumero = new int[1] ;
      P018I3_A31LiqNro = new int[1] ;
      P018I3_A1EmpCod = new short[1] ;
      P018I3_A3CliCod = new int[1] ;
      P018I3_A2114LiqLegSueldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A2114LiqLegSueldo = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajosueldoultimo__default(),
         new Object[] {
             new Object[] {
            P018I2_A1136LegSuelFecha, P018I2_A6LegNumero, P018I2_A1EmpCod, P018I2_A3CliCod, P018I2_A1135LegSuelSec, P018I2_A2344LegSuelTipo, P018I2_n2344LegSuelTipo, P018I2_A1137LegSuelImporte, P018I2_A2347LegSuelCalc
            }
            , new Object[] {
            P018I3_A6LegNumero, P018I3_A31LiqNro, P018I3_A1EmpCod, P018I3_A3CliCod, P018I3_A2114LiqLegSueldo
            }
         }
      );
      AV19Pgmname = "getLegajoSueldoUltimo" ;
      /* GeneXus formulas. */
      AV19Pgmname = "getLegajoSueldoUltimo" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11LegSuelSec ;
   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15LiqNro ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private java.math.BigDecimal AV13LegSuelImporte ;
   private java.math.BigDecimal A1137LegSuelImporte ;
   private java.math.BigDecimal A2347LegSuelCalc ;
   private java.math.BigDecimal A2114LiqLegSueldo ;
   private String AV16LegSuelTipo ;
   private String AV19Pgmname ;
   private String scmdbuf ;
   private String A2344LegSuelTipo ;
   private java.util.Date AV12LegSuelFecha ;
   private java.util.Date A1136LegSuelFecha ;
   private boolean AV14existe ;
   private boolean n2344LegSuelTipo ;
   private boolean[] aP8 ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP6 ;
   private short[] aP7 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P018I2_A1136LegSuelFecha ;
   private int[] P018I2_A6LegNumero ;
   private short[] P018I2_A1EmpCod ;
   private int[] P018I2_A3CliCod ;
   private short[] P018I2_A1135LegSuelSec ;
   private String[] P018I2_A2344LegSuelTipo ;
   private boolean[] P018I2_n2344LegSuelTipo ;
   private java.math.BigDecimal[] P018I2_A1137LegSuelImporte ;
   private java.math.BigDecimal[] P018I2_A2347LegSuelCalc ;
   private int[] P018I3_A6LegNumero ;
   private int[] P018I3_A31LiqNro ;
   private short[] P018I3_A1EmpCod ;
   private int[] P018I3_A3CliCod ;
   private java.math.BigDecimal[] P018I3_A2114LiqLegSueldo ;
}

final  class getlegajosueldoultimo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P018I2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV12LegSuelFecha ,
                                          java.util.Date A1136LegSuelFecha ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegSuelFecha, LegNumero, EmpCod, CliCod, LegSuelSec, LegSuelTipo, LegSuelImporte, LegSuelCalc FROM legajo_sueldos" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV12LegSuelFecha)) )
      {
         addWhere(sWhereString, "(LegSuelFecha <= ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LegSuelFecha DESC" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P018I2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018I2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P018I3", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegSueldo FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
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
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

