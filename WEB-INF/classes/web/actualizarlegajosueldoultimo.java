package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarlegajosueldoultimo extends GXProcedure
{
   public actualizarlegajosueldoultimo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarlegajosueldoultimo.class ), "" );
   }

   public actualizarlegajosueldoultimo( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal aP4 )
   {
      actualizarlegajosueldoultimo.this.AV8CliCod = aP0;
      actualizarlegajosueldoultimo.this.AV9EmpCod = aP1;
      actualizarlegajosueldoultimo.this.AV10LegNumero = aP2;
      actualizarlegajosueldoultimo.this.AV12LegSuelFecha = aP3;
      actualizarlegajosueldoultimo.this.AV13LegSuelImporte = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
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
      /* Using cursor P018J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV12LegSuelFecha});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1136LegSuelFecha = P018J2_A1136LegSuelFecha[0] ;
         A6LegNumero = P018J2_A6LegNumero[0] ;
         A1EmpCod = P018J2_A1EmpCod[0] ;
         A3CliCod = P018J2_A3CliCod[0] ;
         A1137LegSuelImporte = P018J2_A1137LegSuelImporte[0] ;
         A1135LegSuelSec = P018J2_A1135LegSuelSec[0] ;
         A1137LegSuelImporte = AV13LegSuelImporte ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P018J3 */
         pr_default.execute(1, new Object[] {A1137LegSuelImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
         if (true) break;
         /* Using cursor P018J4 */
         pr_default.execute(2, new Object[] {A1137LegSuelImporte, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1135LegSuelSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_sueldos");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizarlegajosueldoultimo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      A1136LegSuelFecha = GXutil.nullDate() ;
      P018J2_A1136LegSuelFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P018J2_A6LegNumero = new int[1] ;
      P018J2_A1EmpCod = new short[1] ;
      P018J2_A3CliCod = new int[1] ;
      P018J2_A1137LegSuelImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P018J2_A1135LegSuelSec = new short[1] ;
      A1137LegSuelImporte = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarlegajosueldoultimo__default(),
         new Object[] {
             new Object[] {
            P018J2_A1136LegSuelFecha, P018J2_A6LegNumero, P018J2_A1EmpCod, P018J2_A3CliCod, P018J2_A1137LegSuelImporte, P018J2_A1135LegSuelSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV13LegSuelImporte ;
   private java.math.BigDecimal A1137LegSuelImporte ;
   private String scmdbuf ;
   private java.util.Date AV12LegSuelFecha ;
   private java.util.Date A1136LegSuelFecha ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P018J2_A1136LegSuelFecha ;
   private int[] P018J2_A6LegNumero ;
   private short[] P018J2_A1EmpCod ;
   private int[] P018J2_A3CliCod ;
   private java.math.BigDecimal[] P018J2_A1137LegSuelImporte ;
   private short[] P018J2_A1135LegSuelSec ;
}

final  class actualizarlegajosueldoultimo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P018J2( ModelContext context ,
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
      scmdbuf = "SELECT LegSuelFecha, LegNumero, EmpCod, CliCod, LegSuelImporte, LegSuelSec FROM legajo_sueldos" ;
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
      scmdbuf += " FOR UPDATE OF legajo_sueldos" ;
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
                  return conditional_P018J2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018J2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P018J3", "SAVEPOINT gxupdate;UPDATE legajo_sueldos SET LegSuelImporte=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P018J4", "SAVEPOINT gxupdate;UPDATE legajo_sueldos SET LegSuelImporte=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegSuelSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

